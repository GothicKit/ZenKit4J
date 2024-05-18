package dev.gothickit.zenkit.bsp;

import dev.gothickit.zenkit.CacheableObject;
import dev.gothickit.zenkit.Vec3f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface BinarySpacePartitionTree extends CacheableObject<CachedBinarySpacePartitionTree> {
	@NotNull
	BinarySpacePartitionType type();

	int @NotNull [] polygonIndices();

	int @NotNull [] leafPolygonIndices();

	int @NotNull [] portalPolygonIndices();

	@NotNull
	Vec3f @NotNull [] lightPoints();

	long @NotNull [] leafNodeIndices();

	@NotNull
	BinarySpacePartitionNode @NotNull [] nodes();

	long sectorCount();

	@Nullable
	BinarySpacePartitionSector sector(long i);

	@NotNull
	List<@NotNull BinarySpacePartitionSector> sectors();
}
