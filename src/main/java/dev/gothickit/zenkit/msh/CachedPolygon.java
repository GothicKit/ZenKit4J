package dev.gothickit.zenkit.msh;

import org.jetbrains.annotations.NotNull;

public record CachedPolygon(
		int materialIndex,

		int lightMapIndex,

		int @NotNull [] positionIndices,

		int @NotNull [] polygonIndices,

		boolean portal,

		boolean occluder,

		boolean sector,

		boolean shouldRelight,

		boolean outdoor,

		boolean ghostOccluder,

		boolean dynamicallyLit,

		boolean lod,

		byte normalAxis,

		short sectorIndex
) implements Polygon {
	@Override
	public @NotNull CachedPolygon cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
