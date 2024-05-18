package dev.gothickit.zenkit.mrm;

import dev.gothickit.zenkit.CacheableObject;
import dev.gothickit.zenkit.mat.Material;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface MultiResolutionSubMesh extends CacheableObject<CachedMultiResolutionSubMesh> {
	@Nullable
	Material material();

	@NotNull
	MeshTriangle @NotNull [] triangles();

	@NotNull
	MeshWedge @NotNull [] wedges();

	float @NotNull [] colors();

	short @NotNull [] trianglePlaneIndices();

	@NotNull
	MeshPlane @NotNull [] trianglePlanes();

	@NotNull
	MeshTriangleEdge @NotNull [] triangleEdges();

	@NotNull
	MeshEdge @NotNull [] edges();

	float @NotNull [] edgeScores();

	short @NotNull [] wedgeMap();
}
