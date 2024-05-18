package dev.gothickit.zenkit.mmb;

import dev.gothickit.zenkit.Vec3f;
import org.jetbrains.annotations.NotNull;

public record CachedMorphAnimation(
		@NotNull
		String name,

		int layer,

		float blendIn,

		float blendOut,

		float duration,

		float speed,

		byte flags,

		int frameCount,

		int @NotNull [] vertices,

		@NotNull
		Vec3f @NotNull [] samples
) implements MorphAnimation {
	@Override
	public @NotNull CachedMorphAnimation cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
