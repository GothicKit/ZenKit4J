package dev.gothickit.zenkit.msh;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import dev.gothickit.zenkit.capi.ZenKit;

public class Polygon {
	private final Pointer handle;

	public Polygon(Pointer handle) {
		this.handle = handle;
	}

	public int getMaterialIndex() {
		return ZenKit.API.ZkPolygon_getMaterialIndex(handle);
	}

	public int getLightMapIndex() {
		return ZenKit.API.ZkPolygon_getLightMapIndex(handle);
	}

	public int[] getPositionIndices() {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkPolygon_getPositionIndices(handle, count);
		if (ptr == Pointer.NULL || count.getValue() == 0) return null;
		return ptr.getIntArray(0, count.getValue());
	}

	public int[] getPolygonIndices() {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkPolygon_getPolygonIndices(handle, count);
		if (ptr == Pointer.NULL || count.getValue() == 0) return null;
		return ptr.getIntArray(0, count.getValue());
	}

	public boolean isPortal() {
		return ZenKit.API.ZkPolygon_getIsPortal(handle);
	}

	public boolean isOccluder() {
		return ZenKit.API.ZkPolygon_getIsOccluder(handle);
	}

	public boolean isSector() {
		return ZenKit.API.ZkPolygon_getIsSector(handle);
	}

	public boolean shouldRelight() {
		return ZenKit.API.ZkPolygon_getShouldRelight(handle);
	}

	public boolean isOutdoor() {
		return ZenKit.API.ZkPolygon_getIsOutdoor(handle);
	}

	public boolean isGhostOccluder() {
		return ZenKit.API.ZkPolygon_getIsGhostOccluder(handle);
	}

	public boolean isDynamicallyLit() {
		return ZenKit.API.ZkPolygon_getIsDynamicallyLit(handle);
	}

	public boolean isLod() {
		return ZenKit.API.ZkPolygon_getIsLod(handle);
	}

	public byte getNormalAxis() {
		return ZenKit.API.ZkPolygon_getNormalAxis(handle);
	}

	public short getSectorIndex() {
		return ZenKit.API.ZkPolygon_getSectorIndex(handle);
	}
}
