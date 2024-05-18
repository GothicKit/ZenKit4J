package dev.gothickit.zenkit.bsp;

import dev.gothickit.zenkit.Vec3f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public record CachedBinarySpacePartitionTree(
		@NotNull BinarySpacePartitionType type,
		int @NotNull [] polygonIndices,
		int @NotNull [] leafPolygonIndices,
		int @NotNull [] portalPolygonIndices,
		@NotNull Vec3f @NotNull [] lightPoints,
		long @NotNull [] leafNodeIndices,
		@NotNull BinarySpacePartitionNode @NotNull [] nodes,
		@NotNull List<@NotNull BinarySpacePartitionSector> sectors
) implements BinarySpacePartitionTree {
	@Override
	public @NotNull Vec3f @NotNull [] lightPoints() {
		return lightPoints;
	}

	@Override
	public long sectorCount() {
		return sectors.size();
	}

	@Override
	public @Nullable BinarySpacePartitionSector sector(long i) {
		if (i >= sectors.size()) {
			return null;
		}

		return sectors.get((int) i);
	}


	@Override
	public @NotNull CachedBinarySpacePartitionTree cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
