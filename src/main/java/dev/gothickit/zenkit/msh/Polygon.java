package dev.gothickit.zenkit.msh;

import dev.gothickit.zenkit.CacheableObject;
import org.jetbrains.annotations.NotNull;

public interface Polygon extends CacheableObject<CachedPolygon> {
	int materialIndex();

	int lightMapIndex();

	int @NotNull [] positionIndices();

	int @NotNull [] polygonIndices();

	boolean portal();

	boolean occluder();

	boolean sector();

	boolean shouldRelight();

	boolean outdoor();

	boolean ghostOccluder();

	boolean dynamicallyLit();

	boolean lod();

	byte normalAxis();

	short sectorIndex();
}
