package dev.gothickit.zenkit.mds;

import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;

public record CachedAnimationCombine(
		@NotNull
		String name,

		int layer,

		@NotNull
		String next,

		float blendIn,

		float blendOut,

		@NotNull
		EnumSet<AnimationFlag> flags,

		@NotNull
		String model,

		int lastFrame
) implements AnimationCombine {
	@Override
	public @NotNull CachedAnimationCombine cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
