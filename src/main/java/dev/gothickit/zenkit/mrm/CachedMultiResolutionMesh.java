package dev.gothickit.zenkit.mrm;

import dev.gothickit.zenkit.AxisAlignedBoundingBox;
import dev.gothickit.zenkit.OrientedBoundingBox;
import dev.gothickit.zenkit.Vec3f;
import dev.gothickit.zenkit.mat.Material;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public record CachedMultiResolutionMesh(
		@NotNull
		Vec3f @NotNull [] positions,

		@NotNull
		Vec3f[] normals,

		@NotNull
		List<@NotNull MultiResolutionSubMesh> subMeshes,


		@NotNull
		List<@NotNull Material> materials,

		boolean alphaTest,

		@NotNull
		AxisAlignedBoundingBox bbox,

		@Nullable
		OrientedBoundingBox orientedBbox
) implements MultiResolutionMesh {
	@Override
	public long subMeshCount() {
		return subMeshes.size();
	}

	@Override
	public @Nullable MultiResolutionSubMesh subMesh(long i) {
		if (i >= subMeshes.size()) return null;
		return subMeshes.get((int) i);
	}

	@Override
	public long materialCount() {
		return materials.size();
	}

	@Override
	public @Nullable Material material(long i) {
		if (i >= materials.size()) return null;
		return materials.get((int) i);
	}

	@Override
	public @NotNull CachedMultiResolutionMesh cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
