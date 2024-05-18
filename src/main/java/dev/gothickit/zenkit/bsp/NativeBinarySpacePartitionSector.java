package dev.gothickit.zenkit.bsp;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.LongByReference;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NativeBinarySpacePartitionSector implements NativeObject, BinarySpacePartitionSector {
	private final Pointer handle;

	private NativeBinarySpacePartitionSector(Pointer handle) {
		this.handle = handle;
	}

	@Contract(value = "null -> null; !null -> new", pure = true)
	public static @Nullable NativeBinarySpacePartitionSector fromNativeHandle(@Nullable Pointer handle) {
		if (handle == null) return null;
		return new NativeBinarySpacePartitionSector(handle);
	}

	public @NotNull String name() {
		return ZenKit.API.ZkBspSector_getName(handle);
	}

	@Override
	@NotNull
	public String toString() {
		return "NativeBinarySpacePartitionSector(name='%s')".formatted(name());
	}

	public @NotNull CachedBinarySpacePartitionSector cache() {
		return new CachedBinarySpacePartitionSector(name(), nodeIndices(), portalPolygonIndices());
	}

	@Override
	public boolean isCached() {
		return false;
	}

	public int @NotNull [] nodeIndices() {
		var count = new LongByReference();
		var ptr = ZenKit.API.ZkBspSector_getNodeIndices(handle, count);
		if (ptr == Pointer.NULL || count.getValue() == 0) return new int[0];
		return ptr.getIntArray(0, (int) count.getValue());
	}

	public int @NotNull [] portalPolygonIndices() {
		var count = new LongByReference();
		var ptr = ZenKit.API.ZkBspSector_getPortalPolygonIndices(handle, count);
		if (ptr == Pointer.NULL || count.getValue() == 0) return new int[0];
		return ptr.getIntArray(0, (int) count.getValue());
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle;
	}
}
