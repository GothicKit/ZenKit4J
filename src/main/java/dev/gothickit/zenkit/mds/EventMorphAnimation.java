package dev.gothickit.zenkit.mds;

import dev.gothickit.zenkit.CacheableObject;
import org.jetbrains.annotations.NotNull;

public interface EventMorphAnimation extends CacheableObject<CachedEventMorphAnimation> {
	int frame();

	@NotNull
	String animation();

	@NotNull
	String node();
}
