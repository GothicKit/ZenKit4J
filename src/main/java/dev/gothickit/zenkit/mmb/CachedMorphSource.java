package dev.gothickit.zenkit.mmb;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public record CachedMorphSource(
		@NotNull
		String fileName,

		@NotNull
		Calendar fileDate
) implements MorphSource {
	@Override
	public @NotNull CachedMorphSource cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
