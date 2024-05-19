package dev.gothickit.zenkit.mds;

import dev.gothickit.zenkit.CacheableObject;
import org.jetbrains.annotations.NotNull;

public interface EventParticleEffect extends CacheableObject<CachedEventParticleEffect> {
	int frame();

	int index();

	@NotNull String name();

	@NotNull String position();

	boolean isAttached();
}
