package dev.gothickit.zenkit.mds;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public record CachedEventTag(
		int frame,

		@NotNull
		EventType type,

		@NotNull
		String item,

		@NotNull List<String> slots,

		int @NotNull [] frames,

		@NotNull
		FightMode fightMode,

		boolean isAttached
) implements EventTag {
	@Override
	public @Nullable String slot(long i) {
		if (i >= slots.size()) return null;
		return slots.get((int) i);
	}

	@Override
	public @NotNull CachedEventTag cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
