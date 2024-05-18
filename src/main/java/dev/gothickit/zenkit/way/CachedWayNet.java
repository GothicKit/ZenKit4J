package dev.gothickit.zenkit.way;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public record CachedWayNet(
		@NotNull WayEdge @NotNull [] edges,

		@NotNull
		List<@NotNull WayPoint> points
) implements WayNet {
	@Override
	public long pointCount() {
		return points.size();
	}

	@Override
	public @Nullable WayPoint point(long i) {
		if (i >= points.size()) return null;
		return points.get((int) i);
	}

	@Override
	public @NotNull CachedWayNet cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
