package dev.gothickit.zenkit.bsp;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import dev.gothickit.zenkit.CacheableObject;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.Vec3f;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class NativeBinarySpacePartitionTree implements NativeObject, BinarySpacePartitionTree {
	private final Pointer handle;

	private NativeBinarySpacePartitionTree(Pointer handle) {
		this.handle = handle;
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable NativeBinarySpacePartitionTree fromNativeHandle(@Nullable Pointer handle) {
		if (handle == null) return null;
		return new NativeBinarySpacePartitionTree(handle);
	}

	@Override
	public @NotNull BinarySpacePartitionType type() {
		return ZenKit.API.ZkBspTree_getType(handle);
	}

	@Override
	public int @NotNull [] polygonIndices() {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkBspTree_getPolygonIndices(handle, count);
		if (ptr == Pointer.NULL || count.getValue() == 0) return new int[0];
		return ptr.getIntArray(0, count.getValue());
	}

	@Override
	public int @NotNull [] leafPolygonIndices() {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkBspTree_getLeafPolygonIndices(handle, count);
		if (ptr == Pointer.NULL || count.getValue() == 0) return new int[0];
		return ptr.getIntArray(0, count.getValue());
	}

	@Override
	public int @NotNull [] portalPolygonIndices() {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkBspTree_getPortalPolygonIndices(handle, count);
		if (ptr == Pointer.NULL || count.getValue() == 0) return new int[0];
		return ptr.getIntArray(0, count.getValue());
	}

	@Override
	public Vec3f @NotNull [] lightPoints() {
		var count = ZenKit.API.ZkBspTree_getLightPointCount(handle);
		var weights = new Vec3f[(int) count];

		for (int i = 0; i < count; i++) {
			weights[i] = ZenKit.API.ZkBspTree_getLightPoint(handle, i);
		}

		return weights;
	}

	@Override
	public long @NotNull [] leafNodeIndices() {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkBspTree_getLeafNodeIndices(handle, count);
		if (ptr == Pointer.NULL || count.getValue() == 0) return new long[0];
		return ptr.getLongArray(0, count.getValue());
	}

	@Override
	public BinarySpacePartitionNode @NotNull [] nodes() {
		var count = ZenKit.API.ZkBspTree_getNodeCount(handle);
		var weights = new BinarySpacePartitionNode[(int) count];

		for (int i = 0; i < count; i++) {
			weights[i] = ZenKit.API.ZkBspTree_getNode(handle, i);
		}

		return weights;
	}

	@Override
	public long sectorCount() {
		return ZenKit.API.ZkBspTree_getSectorCount(handle);
	}

	@Override
	public @Nullable BinarySpacePartitionSector sector(long i) {
		return NativeBinarySpacePartitionSector.fromNativeHandle(ZenKit.API.ZkBspTree_getSector(handle, i));
	}

	@Override
	public @NotNull List<@NotNull BinarySpacePartitionSector> sectors() {
		var sectors = new ArrayList<BinarySpacePartitionSector>();

		ZenKit.API.ZkBspTree_enumerateSectors(handle, (ctx, sector) -> {
			sectors.add(NativeBinarySpacePartitionSector.fromNativeHandle(sector));
			return false;
		}, Pointer.NULL);

		return sectors;
	}

	@Override
	public @NotNull CachedBinarySpacePartitionTree cache() {
		return new CachedBinarySpacePartitionTree(
				type(),
				polygonIndices(),
				leafPolygonIndices(),
				portalPolygonIndices(),
				lightPoints(),
				leafNodeIndices(),
				nodes(),
				sectors().stream().map(CacheableObject::cache).collect(Collectors.toList())
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
