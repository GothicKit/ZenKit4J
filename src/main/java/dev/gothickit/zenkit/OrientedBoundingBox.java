package dev.gothickit.zenkit;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;

import java.util.ArrayList;
import java.util.List;

public class OrientedBoundingBox {
	private final Pointer handle;

	public OrientedBoundingBox(Pointer handle) {
		this.handle = handle;
	}

	public Vec3f getCenter() {
		return ZenKit.API.ZkOrientedBoundingBox_getCenter(handle);
	}

	public Vec3f[] getAxes() {
		return new Vec3f[]{
				ZenKit.API.ZkOrientedBoundingBox_getAxis(handle, 0),
				ZenKit.API.ZkOrientedBoundingBox_getAxis(handle, 1),
				ZenKit.API.ZkOrientedBoundingBox_getAxis(handle, 2),
		};
	}

	public Vec3f getHalfWidth() {
		return ZenKit.API.ZkOrientedBoundingBox_getHalfWidth(handle);
	}

	public long getChildCount() {
		return ZenKit.API.ZkOrientedBoundingBox_getChildCount(handle);
	}

	public OrientedBoundingBox getChild(long i) {
		return new OrientedBoundingBox(ZenKit.API.ZkOrientedBoundingBox_getChild(handle, i));
	}

	public List<OrientedBoundingBox> getChildren() {
		var children = new ArrayList<OrientedBoundingBox>();

		ZenKit.API.ZkOrientedBoundingBox_enumerateChildren(handle, (ctx, box) -> {
			children.add(new OrientedBoundingBox(box));
			return false;
		}, Pointer.NULL);

		return children;
	}

	public AxisAlignedBoundingBox toAabb() {
		return ZenKit.API.ZkOrientedBoundingBox_toAabb(handle);
	}
}
