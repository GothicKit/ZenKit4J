package dev.gothickit.zenkit.mrm;

import dev.gothickit.zenkit.mat.Material;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record CachedMultiResolutionSubMesh(
		@Nullable
		Material material,

		@NotNull
		MeshTriangle @NotNull [] triangles,

		@NotNull
		MeshWedge @NotNull [] wedges,

		float @NotNull [] colors,

		short @NotNull [] trianglePlaneIndices,

		@NotNull MeshPlane @NotNull [] trianglePlanes,

		@NotNull MeshTriangleEdge @NotNull [] triangleEdges,

		@NotNull MeshEdge @NotNull [] edges,

		float @NotNull [] edgeScores,

		short @NotNull [] wedgeMap
) implements MultiResolutionSubMesh {
	@Override
	public @NotNull CachedMultiResolutionSubMesh cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
