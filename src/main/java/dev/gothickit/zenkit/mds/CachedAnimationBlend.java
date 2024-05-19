package dev.gothickit.zenkit.mds;

import org.jetbrains.annotations.NotNull;

public record CachedAnimationBlend(
		@NotNull
		String name,

		@NotNull String next,

		float blendIn,

		float blendOut
) implements AnimationBlend {
	@Override
	public @NotNull CachedAnimationBlend cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
