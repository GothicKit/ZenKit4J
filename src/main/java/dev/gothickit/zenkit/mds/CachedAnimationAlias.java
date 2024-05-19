package dev.gothickit.zenkit.mds;

import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;

public record CachedAnimationAlias(
		@NotNull String name,

		int layer,

		@NotNull String next,

		float blendIn,

		float blendOut,

		@NotNull
		EnumSet<AnimationFlag> flags,

		@NotNull String alias,

		@NotNull AnimationDirection direction
) implements AnimationAlias {
	@Override
	public @NotNull CachedAnimationAlias cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
