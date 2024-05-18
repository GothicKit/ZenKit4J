package dev.gothickit.zenkit.bsp;

import dev.gothickit.zenkit.CacheableObject;
import org.jetbrains.annotations.NotNull;

public interface BinarySpacePartitionSector extends CacheableObject<CachedBinarySpacePartitionSector> {
	@NotNull
	String name();

	int @NotNull [] nodeIndices();

	int @NotNull [] portalPolygonIndices();
}
