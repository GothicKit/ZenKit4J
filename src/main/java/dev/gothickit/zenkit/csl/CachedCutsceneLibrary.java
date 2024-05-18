package dev.gothickit.zenkit.csl;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public record CachedCutsceneLibrary(
		@NotNull List<@NotNull CutsceneBlock> blocks
) implements CutsceneLibrary {
	@Override
	public long blockCount() {
		return blocks.size();
	}

	@Override
	public @Nullable CutsceneBlock block(String name) {
		for (CutsceneBlock block : blocks) {
			if (block.name().equalsIgnoreCase(name)) {
				return block;
			}
		}

		return null;
	}

	@Override
	public @Nullable CutsceneBlock block(long i) {
		if (i >= blocks.size()) return null;
		return blocks.get((int) i);
	}

	@Override
	public @NotNull CachedCutsceneLibrary cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
