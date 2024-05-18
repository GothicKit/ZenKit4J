package dev.gothickit.zenkit.fnt;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public record CachedFont(
		@NotNull String name,
		int height,
		@NotNull List<@NotNull FontGlyph> glyphs
) implements Font {
	@Override
	public long glyphCount() {
		return glyphs.size();
	}

	@Override
	public @Nullable FontGlyph glyph(long i) {
		if (i >= glyphs.size()) return null;
		return glyphs.get((int) i);
	}

	@Override
	public @NotNull CachedFont cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
