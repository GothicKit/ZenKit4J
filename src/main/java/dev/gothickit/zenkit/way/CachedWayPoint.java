package dev.gothickit.zenkit.way;

import dev.gothickit.zenkit.Vec3f;
import org.jetbrains.annotations.NotNull;

public record CachedWayPoint(
		@NotNull
		String name,

		int waterDepth,

		boolean underWater,

		@NotNull
		Vec3f position,

		@NotNull
		Vec3f direction,

		boolean freePoint
) implements WayPoint {
	@Override
	public @NotNull CachedWayPoint cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
