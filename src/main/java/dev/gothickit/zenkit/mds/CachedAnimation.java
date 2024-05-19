package dev.gothickit.zenkit.mds;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.List;

public record CachedAnimation(
		@NotNull String name,

		int layer,

		@NotNull String next,

		float blendIn,

		float blendOut,

		EnumSet<AnimationFlag> flags,

		@NotNull String model,

		@NotNull AnimationDirection direction,

		int firstFrame,

		int lastFrame,

		float fps,

		float speed,

		float collisionVolumeScale,

		@NotNull
		List<@NotNull EventTag> eventTags,

		@NotNull List<@NotNull EventParticleEffect> particleEffects,

		@NotNull List<@NotNull EventParticleEffectStop> particleEffectsStop,

		@NotNull List<@NotNull EventSoundEffect> soundEffects,

		@NotNull List<@NotNull EventSoundEffectGround> soundEffectsGround,

		@NotNull List<@NotNull EventMorphAnimation> morphAnimations,

		@NotNull List<@NotNull EventCameraTremor> cameraTremors
) implements Animation {
	@Override
	public long eventTagCount() {
		return eventTags.size();
	}

	@Override
	public long particleEffectCount() {
		return particleEffects.size();
	}

	@Override
	public long particleEffectStopCount() {
		return particleEffectsStop.size();
	}

	@Override
	public long soundEffectCount() {
		return soundEffects.size();
	}

	@Override
	public long soundEffectGroundCount() {
		return soundEffectsGround.size();
	}

	@Override
	public long morphAnimationCount() {
		return morphAnimations.size();
	}

	@Override
	public long cameraTremorCount() {
		return cameraTremors.size();
	}

	@Override
	public @Nullable EventTag eventTag(long i) {
		if (i >= eventTags.size()) return null;
		return eventTags.get((int) i);
	}

	@Override
	public @Nullable EventParticleEffect particleEffect(long i) {
		if (i >= particleEffects.size()) return null;
		return particleEffects.get((int) i);
	}

	@Override
	public @Nullable EventParticleEffectStop particleEffectStop(long i) {
		if (i >= particleEffectsStop.size()) return null;
		return particleEffectsStop.get((int) i);
	}

	@Override
	public @Nullable EventSoundEffect soundEffect(long i) {
		if (i >= soundEffects.size()) return null;
		return soundEffects.get((int) i);
	}

	@Override
	public @Nullable EventSoundEffectGround soundEffectGround(long i) {
		if (i >= soundEffectsGround.size()) return null;
		return soundEffectsGround.get((int) i);
	}

	@Override
	public @Nullable EventMorphAnimation morphAnimation(long i) {
		if (i >= morphAnimations.size()) return null;
		return morphAnimations.get((int) i);
	}

	@Override
	public @Nullable EventCameraTremor cameraTremor(long i) {
		if (i >= cameraTremors.size()) return null;
		return cameraTremors.get((int) i);
	}

	@Override
	public @NotNull CachedAnimation cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
