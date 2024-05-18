package dev.gothickit.zenkit.way;

import dev.gothickit.zenkit.CacheableObject;
import dev.gothickit.zenkit.Vec3f;
import org.jetbrains.annotations.NotNull;

public interface WayPoint extends CacheableObject<CachedWayPoint> {
	@NotNull
	String name();

	int waterDepth();

	boolean underWater();

	@NotNull
	Vec3f position();

	@NotNull
	Vec3f direction();

	boolean freePoint();
}
