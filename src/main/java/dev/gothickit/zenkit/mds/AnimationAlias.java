package dev.gothickit.zenkit.mds;

import dev.gothickit.zenkit.CacheableObject;
import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;

public interface AnimationAlias extends CacheableObject<CachedAnimationAlias> {
	@NotNull String name();

	int layer();

	@NotNull String next();

	float blendIn();

	float blendOut();

	@NotNull EnumSet<AnimationFlag> flags();

	@NotNull String alias();

	@NotNull AnimationDirection direction();
}
