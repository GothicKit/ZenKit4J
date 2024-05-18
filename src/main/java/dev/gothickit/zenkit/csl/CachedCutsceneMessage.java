package dev.gothickit.zenkit.csl;

import org.jetbrains.annotations.NotNull;

public record CachedCutsceneMessage(
		int type,
		@NotNull String text,
		@NotNull String name
) implements CutsceneMessage {
	@Override
	public @NotNull CachedCutsceneMessage cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
