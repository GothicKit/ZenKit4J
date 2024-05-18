package dev.gothickit.zenkit.bsp;

import org.jetbrains.annotations.NotNull;

public record CachedBinarySpacePartitionSector(
		@NotNull String name,
		int @NotNull [] nodeIndices,
		int @NotNull [] portalPolygonIndices
) implements BinarySpacePartitionSector {
	@Override
	public @NotNull CachedBinarySpacePartitionSector cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
