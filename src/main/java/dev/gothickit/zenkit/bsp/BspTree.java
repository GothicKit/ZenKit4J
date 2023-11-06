package dev.gothickit.zenkit.bsp;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import dev.gothickit.zenkit.Vec3f;
import dev.gothickit.zenkit.capi.ZenKit;

import java.util.ArrayList;
import java.util.List;

public class BspTree {
	private final Pointer handle;

	public BspTree(Pointer handle) {
		this.handle = handle;
	}

	public BspTreeType getType() {
		return ZenKit.API.ZkBspTree_getType(handle);
	}

	public int[] getPolygonIndices() {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkBspTree_getPolygonIndices(handle, count);
		if (ptr == Pointer.NULL || count.getValue() == 0) return new int[0];
		return ptr.getIntArray(0, count.getValue());
	}

	public int[] getLeafPolygonIndices() {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkBspTree_getLeafPolygonIndices(handle, count);
		if (ptr == Pointer.NULL || count.getValue() == 0) return new int[0];
		return ptr.getIntArray(0, count.getValue());
	}

	public int[] getPortalPolygonIndices() {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkBspTree_getPortalPolygonIndices(handle, count);
		if (ptr == Pointer.NULL || count.getValue() == 0) return new int[0];
		return ptr.getIntArray(0, count.getValue());
	}

	public Vec3f[] getLightPoints() {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkBspTree_getLightPoints(handle, count);
		if (ptr == null || count.getValue() == 0) return new Vec3f[0];
		return (Vec3f[]) ptr.toArray(count.getValue());
	}

	public long[] getLeafNodeIndices() {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkBspTree_getLeafNodeIndices(handle, count);
		if (ptr == Pointer.NULL || count.getValue() == 0) return new long[0];
		return ptr.getLongArray(0, count.getValue());
	}

	public BspNode[] getNodes() {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkBspTree_getNodes(handle, count);
		if (ptr == null || count.getValue() == 0) return new BspNode[0];
		return (BspNode[]) ptr.toArray(count.getValue());
	}

	public long getSectorCount() {
		return ZenKit.API.ZkBspTree_getSectorCount(handle);
	}

	public BspSector getSector(long i) {
		return new BspSector(ZenKit.API.ZkBspTree_getSector(handle, i));
	}

	public List<BspSector> getSectors() {
		var sectors = new ArrayList<BspSector>();

		ZenKit.API.ZkBspTree_enumerateSectors(handle, (ctx, sector) -> {
			sectors.add(new BspSector(sector));
			return false;
		}, Pointer.NULL);

		return sectors;
	}
}
