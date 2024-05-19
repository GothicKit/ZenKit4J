package dev.gothickit.zenkit.mds;

import org.jetbrains.annotations.NotNull;

public record CachedEventParticleEffectStop(
		int frame,
		int index
) implements EventParticleEffectStop {
	@Override
	public @NotNull CachedEventParticleEffectStop cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
