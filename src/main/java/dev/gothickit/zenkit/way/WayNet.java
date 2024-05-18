package dev.gothickit.zenkit.way;

import dev.gothickit.zenkit.CacheableObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface WayNet extends CacheableObject<CachedWayNet> {
	@NotNull
	WayEdge @NotNull [] edges();

	long pointCount();

	@Nullable
	WayPoint point(long i);

	@NotNull
	List<@NotNull WayPoint> points();
}
