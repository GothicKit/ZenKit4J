package dev.gothickit.zenkit.mds;

import dev.gothickit.zenkit.CacheableObject;
import org.jetbrains.annotations.NotNull;

public interface AnimationBlend extends CacheableObject<CachedAnimationBlend> {
	@NotNull
	String name();

	@NotNull String next();

	float blendIn();

	float blendOut();
}
