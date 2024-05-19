package dev.gothickit.zenkit.mds;

import org.jetbrains.annotations.NotNull;

public record CachedEventSoundEffect(
		int frame,
		@NotNull String name,
		float range,
		boolean emptySlot
) implements EventSoundEffect {
	@Override
	public @NotNull CachedEventSoundEffect cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
