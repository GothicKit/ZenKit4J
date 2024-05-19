package dev.gothickit.zenkit.mds;

import dev.gothickit.zenkit.CacheableObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.List;

public interface Animation extends CacheableObject<CachedAnimation> {
	@NotNull
	String name();

	int layer();

	@NotNull
	String next();

	float blendIn();

	float blendOut();

	@NotNull EnumSet<AnimationFlag> flags();

	@NotNull
	String model();

	@NotNull
	AnimationDirection direction();

	int firstFrame();

	int lastFrame();

	float fps();

	float speed();

	float collisionVolumeScale();

	long eventTagCount();

	long particleEffectCount();

	long particleEffectStopCount();

	long soundEffectCount();

	long soundEffectGroundCount();

	long morphAnimationCount();

	long cameraTremorCount();

	@Nullable
	EventTag eventTag(long i);

	@Nullable
	EventParticleEffect particleEffect(long i);

	@Nullable
	EventParticleEffectStop particleEffectStop(long i);

	@Nullable
	EventSoundEffect soundEffect(long i);

	@Nullable
	EventSoundEffectGround soundEffectGround(long i);

	@Nullable
	EventMorphAnimation morphAnimation(long i);

	@Nullable
	EventCameraTremor cameraTremor(long i);

	@NotNull
	List<@NotNull EventTag> eventTags();

	@NotNull
	List<@NotNull EventParticleEffect> particleEffects();

	@NotNull
	List<@NotNull EventParticleEffectStop> particleEffectsStop();

	@NotNull
	List<@NotNull EventSoundEffect> soundEffects();

	@NotNull
	List<@NotNull EventSoundEffectGround> soundEffectsGround();

	@NotNull
	List<@NotNull EventMorphAnimation> morphAnimations();

	@NotNull
	List<@NotNull EventCameraTremor> cameraTremors();
}
