package dev.gothickit.zenkit;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class NativeOrientedBoundingBox implements NativeObject, OrientedBoundingBox {
	private final Pointer handle;

	private NativeOrientedBoundingBox(Pointer handle) {
		this.handle = handle;
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable NativeOrientedBoundingBox fromNativeHandle(Pointer handle) {
		if (handle == null) return null;
		return new NativeOrientedBoundingBox(handle);
	}

	@Override
	public @NotNull Vec3f center() {
		return ZenKit.API.ZkOrientedBoundingBox_getCenter(handle);
	}

	@Override
	public Vec3f @NotNull [] axes() {
		return new Vec3f[]{
				ZenKit.API.ZkOrientedBoundingBox_getAxis(handle, 0),
				ZenKit.API.ZkOrientedBoundingBox_getAxis(handle, 1),
				ZenKit.API.ZkOrientedBoundingBox_getAxis(handle, 2),
		};
	}

	@Override
	public @NotNull Vec3f halfWidth() {
		return ZenKit.API.ZkOrientedBoundingBox_getHalfWidth(handle);
	}

	@Override
	public long childCount() {
		return ZenKit.API.ZkOrientedBoundingBox_getChildCount(handle);
	}

	@Override
	public @Nullable OrientedBoundingBox child(long i) {
		var ptr = ZenKit.API.ZkOrientedBoundingBox_getChild(handle, i);
		return NativeOrientedBoundingBox.fromNativeHandle(ptr);
	}

	@Override
	public @NotNull List<OrientedBoundingBox> children() {
		var children = new ArrayList<OrientedBoundingBox>();

		ZenKit.API.ZkOrientedBoundingBox_enumerateChildren(handle, (ctx, box) -> {
			children.add(new NativeOrientedBoundingBox(box));
			return false;
		}, Pointer.NULL);

		return children;
	}

	public AxisAlignedBoundingBox toAabb() {
		return ZenKit.API.ZkOrientedBoundingBox_toAabb(handle);
	}

	@Override
	public @NotNull CachedOrientedBoundingBox cache() {
		return new CachedOrientedBoundingBox(
				center(),
				axes(),
				halfWidth(),
				children().stream().map(CacheableObject::cache).collect(Collectors.toList())
		);
	}

	@Override
	public boolean isCached() {
		return false;
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle;
	}
}
