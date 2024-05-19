package dev.gothickit.zenkit.mds;

import org.jetbrains.annotations.NotNull;

public record CachedEventMorphAnimation(
		int frame,

		@NotNull
		String animation,

		@NotNull
		String node
) implements EventMorphAnimation {
	@Override
	public @NotNull CachedEventMorphAnimation cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
