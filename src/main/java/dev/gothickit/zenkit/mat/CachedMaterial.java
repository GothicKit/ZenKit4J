package dev.gothickit.zenkit.mat;

import dev.gothickit.zenkit.Color;
import dev.gothickit.zenkit.Vec2f;
import org.jetbrains.annotations.NotNull;

public record CachedMaterial(
		@NotNull String name,

		@NotNull MaterialGroup group,

		@NotNull
		Color color,

		float smoothAngle,

		@NotNull String texture,

		@NotNull
		Vec2f textureScale,

		float textureAnimationFps,

		@NotNull AnimationMapping textureAnimationMapping,

		@NotNull Vec2f textureAnimationMappingDirection,

		boolean disableCollision,

		boolean disableLightmap,

		boolean dontCollapse,

		@NotNull String detailObject,

		float detailObjectScale,

		boolean forceOccluder,

		boolean environmentMapping,

		float environmentMappingStrength,

		@NotNull WaveMode waveMode,

		@NotNull WaveSpeed waveSpeed,

		float waveAmplitude,

		float waveGridSize,

		boolean ignoreSun,

		@NotNull AlphaFunction alphaFunction,

		@NotNull Vec2f defaultMapping
) implements Material {
	@Override
	public @NotNull CachedMaterial cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
