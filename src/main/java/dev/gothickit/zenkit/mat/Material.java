package dev.gothickit.zenkit.mat;

import dev.gothickit.zenkit.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface Material extends CacheableObject<CachedMaterial> {
	@Contract("_ -> new")
	static @NotNull Material load(@NotNull String path) throws ResourceIOException {
		return new NativeMaterial(path);
	}

	@Contract("_ -> new")
	static @NotNull Material load(@NotNull Read buf) throws ResourceIOException {
		return new NativeMaterial(buf);
	}

	@NotNull
	String name();

	@NotNull
	MaterialGroup group();

	@NotNull
	Color color();

	float smoothAngle();

	@NotNull
	String texture();

	@NotNull
	Vec2f textureScale();

	float textureAnimationFps();

	@NotNull
	AnimationMapping textureAnimationMapping();

	@NotNull
	Vec2f textureAnimationMappingDirection();

	boolean disableCollision();

	boolean disableLightmap();

	boolean dontCollapse();

	@NotNull
	String detailObject();

	float detailObjectScale();

	boolean forceOccluder();

	boolean environmentMapping();

	float environmentMappingStrength();

	@NotNull
	WaveMode waveMode();

	@NotNull
	WaveSpeed waveSpeed();

	float waveAmplitude();

	float waveGridSize();

	boolean ignoreSun();

	@NotNull
	AlphaFunction alphaFunction();

	@NotNull
	Vec2f defaultMapping();
}
