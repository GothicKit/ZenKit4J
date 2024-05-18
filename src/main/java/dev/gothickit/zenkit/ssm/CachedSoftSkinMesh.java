package dev.gothickit.zenkit.ssm;

import dev.gothickit.zenkit.OrientedBoundingBox;
import dev.gothickit.zenkit.mrm.MultiResolutionMesh;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public record CachedSoftSkinMesh(
		@Nullable
		MultiResolutionMesh mesh,

		@NotNull
		List<@NotNull OrientedBoundingBox> boundingBoxes,

		@NotNull
		List<@NotNull SoftSkinWeightEntry[]> weights,

		@NotNull
		SoftSkinWedgeNormal @NotNull [] wedgeNormals,

		int[] nodes
) implements SoftSkinMesh {
	@Override
	public long nodeCount() {
		return nodes.length;
	}

	@Override
	public @Nullable OrientedBoundingBox bbox(long node) {
		if (node >= boundingBoxes.size()) return null;
		return boundingBoxes.get((int) node);
	}

	@Override
	public @NotNull SoftSkinWeightEntry @Nullable [] weights(long node) {
		if (node >= weights.size()) return null;
		return weights.get((int) node);
	}

	@Override
	public @NotNull CachedSoftSkinMesh cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
