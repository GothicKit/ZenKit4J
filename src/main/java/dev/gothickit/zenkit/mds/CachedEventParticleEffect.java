package dev.gothickit.zenkit.mds;

import org.jetbrains.annotations.NotNull;

public record CachedEventParticleEffect(
		int frame,

		int index,

		@NotNull String name,

		@NotNull String position,

		boolean isAttached
) implements EventParticleEffect {
	@Override
	public @NotNull CachedEventParticleEffect cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
