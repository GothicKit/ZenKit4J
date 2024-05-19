package dev.gothickit.zenkit.mds;

import dev.gothickit.zenkit.CacheableObject;

public interface EventParticleEffectStop extends CacheableObject<CachedEventParticleEffectStop> {
	int frame();

	int index();
}
