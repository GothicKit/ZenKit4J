package dev.gothickit.zenkit.mds;

import org.jetbrains.annotations.NotNull;

public record CachedEventCameraTremor(
		int frame,
		int field1,
		int field2,
		int field3,
		int field4
) implements EventCameraTremor {
	@Override
	public @NotNull CachedEventCameraTremor cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
