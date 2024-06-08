package dev.gothickit.zenkit.msh;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.LongByReference;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NativePolygon implements NativeObject, Polygon {
	private final Pointer handle;
	private final NativeMesh mesh;

	private NativePolygon(Pointer handle, NativeMesh mesh) {
		this.handle = handle;
		this.mesh = mesh;
	}

	@Contract("null, _ -> null; !null, _ -> new")
	public static @Nullable Polygon fromNativeHandle(Pointer handle, @NotNull NativeMesh mesh) {
		if (handle == null) return null;
		return new NativePolygon(handle, mesh);
	}

	@Override
	public int materialIndex() {
		return ZenKit.API.ZkPolygon_getMaterialIndex(handle);
	}

	@Override
	public int lightMapIndex() {
		return ZenKit.API.ZkPolygon_getLightMapIndex(handle);
	}

	@Override
	public int @NotNull [] positionIndices() {
		var count = new LongByReference();
		var ptr = ZenKit.API.ZkPolygon_getPositionIndices(handle, mesh.getNativeHandle(), count);
		if (ptr == Pointer.NULL || count.getValue() == 0) return new int[0];
		return ptr.getIntArray(0, (int) count.getValue());
	}

	@Override
	public int @NotNull [] polygonIndices() {
		var count = new LongByReference();
		var ptr = ZenKit.API.ZkPolygon_getFeatureIndices(handle, mesh.getNativeHandle(), count);
		if (ptr == Pointer.NULL || count.getValue() == 0) return new int[0];
		return ptr.getIntArray(0, (int) count.getValue());
	}

	@Override
	public boolean portal() {
		return ZenKit.API.ZkPolygon_getIsPortal(handle);
	}

	@Override
	public boolean occluder() {
		return ZenKit.API.ZkPolygon_getIsOccluder(handle);
	}

	@Override
	public boolean sector() {
		return ZenKit.API.ZkPolygon_getIsSector(handle);
	}

	@Override
	public boolean shouldRelight() {
		return ZenKit.API.ZkPolygon_getShouldRelight(handle);
	}

	@Override
	public boolean outdoor() {
		return ZenKit.API.ZkPolygon_getIsOutdoor(handle);
	}

	@Override
	public boolean ghostOccluder() {
		return ZenKit.API.ZkPolygon_getIsGhostOccluder(handle);
	}

	@Override
	public boolean dynamicallyLit() {
		return ZenKit.API.ZkPolygon_getIsDynamicallyLit(handle);
	}

	@Override
	public boolean lod() {
		return ZenKit.API.ZkPolygon_getIsLod(handle);
	}

	@Override
	public byte normalAxis() {
		return ZenKit.API.ZkPolygon_getNormalAxis(handle);
	}

	@Override
	public short sectorIndex() {
		return ZenKit.API.ZkPolygon_getSectorIndex(handle);
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle;
	}

	@Override
	public @NotNull CachedPolygon cache() {
		return new CachedPolygon(
				materialIndex(),
				lightMapIndex(),
				positionIndices(),
				polygonIndices(),
				portal(),
				occluder(),
				sector(),
				shouldRelight(),
				outdoor(),
				ghostOccluder(),
				dynamicallyLit(),
				lod(),
				normalAxis(),
				sectorIndex()
		);
	}

	@Override
	public boolean isCached() {
		return false;
	}
}
