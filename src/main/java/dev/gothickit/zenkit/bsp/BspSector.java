package dev.gothickit.zenkit.bsp;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import dev.gothickit.zenkit.capi.ZenKit;

public class BspSector {
	private final Pointer handle;

	public BspSector(Pointer handle) {
		this.handle = handle;
	}

	public String getName() {
		return ZenKit.API.ZkBspSector_getName(handle);
	}

	public int[] getNodeIndices() {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkBspSector_getNodeIndices(handle, count);
		if (ptr == Pointer.NULL || count.getValue() == 0) return new int[0];
		return ptr.getIntArray(0, count.getValue());
	}

	public int[] getPortalPolygonIndices() {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkBspSector_getPortalPolygonIndices(handle, count);
		if (ptr == Pointer.NULL || count.getValue() == 0) return new int[0];
		return ptr.getIntArray(0, count.getValue());
	}
}
