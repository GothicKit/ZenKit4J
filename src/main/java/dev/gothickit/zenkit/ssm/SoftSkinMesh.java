package dev.gothickit.zenkit.ssm;

import dev.gothickit.zenkit.CacheableObject;
import dev.gothickit.zenkit.OrientedBoundingBox;
import dev.gothickit.zenkit.mrm.MultiResolutionMesh;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface SoftSkinMesh extends CacheableObject<CachedSoftSkinMesh> {
	long nodeCount();

	@NotNull
	MultiResolutionMesh mesh();

	@Nullable
	OrientedBoundingBox bbox(long node);

	@NotNull
	List<@NotNull OrientedBoundingBox> boundingBoxes();

	@NotNull
	SoftSkinWeightEntry @Nullable [] weights(long node);

	@NotNull
	List<@NotNull SoftSkinWeightEntry[]> weights();

	@NotNull
	SoftSkinWedgeNormal @NotNull [] wedgeNormals();

	int[] nodes();
}
