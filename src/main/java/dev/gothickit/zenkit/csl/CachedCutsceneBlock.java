package dev.gothickit.zenkit.csl;

import org.jetbrains.annotations.NotNull;

public record CachedCutsceneBlock(
		@NotNull String name,
		@NotNull CutsceneMessage message
) implements CutsceneBlock {
	@Override
	public @NotNull CachedCutsceneBlock cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
