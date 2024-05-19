package dev.gothickit.zenkit.mds;

import org.jetbrains.annotations.NotNull;

public record CachedEventSoundEffectGround(
		int frame,

		@NotNull
		String name,

		float range,

		boolean emptySlot
) implements EventSoundEffectGround {
	@Override
	public @NotNull CachedEventSoundEffectGround cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
