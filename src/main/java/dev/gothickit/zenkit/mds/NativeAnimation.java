package dev.gothickit.zenkit.mds;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.CacheableObject;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public final class NativeAnimation implements NativeObject, Animation {
	private final Pointer handle;

	private NativeAnimation(Pointer handle) {
		this.handle = handle;
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable NativeAnimation fromNativeHandle(Pointer handle) {
		if (handle == null) return null;
		return new NativeAnimation(handle);
	}

	@Override
	public @NotNull String name() {
		return ZenKit.API.ZkAnimation_getName(handle);
	}

	@Override
	public int layer() {
		return ZenKit.API.ZkAnimation_getLayer(handle);
	}

	@Override
	public @NotNull String next() {
		return ZenKit.API.ZkAnimation_getNext(handle);
	}

	@Override
	public float blendIn() {
		return ZenKit.API.ZkAnimation_getBlendIn(handle);
	}

	@Override
	public float blendOut() {
		return ZenKit.API.ZkAnimation_getBlendOut(handle);
	}

	@Override
	public @NotNull EnumSet<AnimationFlag> flags() {
		return AnimationFlag.fromInt(ZenKit.API.ZkAnimation_getFlags(handle));
	}

	@Override
	public @NotNull String model() {
		return ZenKit.API.ZkAnimation_getModel(handle);
	}

	@Override
	public @NotNull AnimationDirection direction() {
		return ZenKit.API.ZkAnimation_getDirection(handle);
	}

	@Override
	public int firstFrame() {
		return ZenKit.API.ZkAnimation_getFirstFrame(handle);
	}

	@Override
	public int lastFrame() {
		return ZenKit.API.ZkAnimation_getLastFrame(handle);
	}

	@Override
	public float fps() {
		return ZenKit.API.ZkAnimation_getFps(handle);
	}

	@Override
	public float speed() {
		return ZenKit.API.ZkAnimation_getSpeed(handle);
	}

	@Override
	public float collisionVolumeScale() {
		return ZenKit.API.ZkAnimation_getCollisionVolumeScale(handle);
	}

	@Override
	public long eventTagCount() {
		return ZenKit.API.ZkAnimation_getEventTagCount(handle);
	}

	@Override
	public long particleEffectCount() {
		return ZenKit.API.ZkAnimation_getParticleEffectCount(handle);
	}

	@Override
	public long particleEffectStopCount() {
		return ZenKit.API.ZkAnimation_getParticleEffectStopCount(handle);
	}

	@Override
	public long soundEffectCount() {
		return ZenKit.API.ZkAnimation_getSoundEffectCount(handle);
	}

	@Override
	public long soundEffectGroundCount() {
		return ZenKit.API.ZkAnimation_getSoundEffectGroundCount(handle);
	}

	@Override
	public long morphAnimationCount() {
		return ZenKit.API.ZkAnimation_getMorphAnimationCount(handle);
	}

	@Override
	public long cameraTremorCount() {
		return ZenKit.API.ZkAnimation_getCameraTremorCount(handle);
	}

	@Override
	public @NotNull EventTag eventTag(long i) {
		var ptr = ZenKit.API.ZkAnimation_getEventTag(handle, i);
		return NativeEventTag.fromNativeHandle(ptr);
	}

	@Override
	public @NotNull EventParticleEffect particleEffect(long i) {
		var ptr = ZenKit.API.ZkAnimation_getParticleEffect(handle, i);
		return NativeEventParticleEffect.fromNativeHandle(ptr);
	}

	@Override
	public @NotNull EventParticleEffectStop particleEffectStop(long i) {
		var ptr = ZenKit.API.ZkAnimation_getParticleEffectStop(handle, i);
		return NativeEventParticleEffectStop.fromNativeHandle(ptr);
	}

	@Override
	public @NotNull EventSoundEffect soundEffect(long i) {
		var ptr = ZenKit.API.ZkAnimation_getSoundEffect(handle, i);
		return NativeEventSoundEffect.fromNativeHandle(ptr);
	}

	@Override
	public @NotNull EventSoundEffectGround soundEffectGround(long i) {
		var ptr = ZenKit.API.ZkAnimation_getSoundEffectGround(handle, i);
		return NativeEventSoundEffectGround.fromNativeHandle(ptr);
	}

	@Override
	public @NotNull EventMorphAnimation morphAnimation(long i) {
		var ptr = ZenKit.API.ZkAnimation_getMorphAnimation(handle, i);
		return NativeEventMorphAnimation.fromNativeHandle(ptr);
	}

	@Override
	public @NotNull EventCameraTremor cameraTremor(long i) {
		var ptr = ZenKit.API.ZkAnimation_getCameraTremor(handle, i);
		return NativeEventCameraTremor.fromNativeHandle(ptr);
	}

	@Override
	public @NotNull List<@NotNull EventTag> eventTags() {
		var arr = new ArrayList<EventTag>();

		ZenKit.API.ZkAnimation_enumerateEventTags(handle, (ctx, evt) -> {
			arr.add(NativeEventTag.fromNativeHandle(evt));
			return false;
		}, Pointer.NULL);

		return arr;
	}

	@Override
	public @NotNull List<@NotNull EventParticleEffect> particleEffects() {
		var arr = new ArrayList<EventParticleEffect>();

		ZenKit.API.ZkAnimation_enumerateParticleEffects(handle, (ctx, evt) -> {
			arr.add(NativeEventParticleEffect.fromNativeHandle(evt));
			return false;
		}, Pointer.NULL);

		return arr;
	}

	@Override
	public @NotNull List<@NotNull EventParticleEffectStop> particleEffectsStop() {
		var arr = new ArrayList<EventParticleEffectStop>();

		ZenKit.API.ZkAnimation_enumerateParticleEffectStops(handle, (ctx, evt) -> {
			arr.add(NativeEventParticleEffectStop.fromNativeHandle(evt));
			return false;
		}, Pointer.NULL);

		return arr;
	}

	@Override
	public @NotNull List<@NotNull EventSoundEffect> soundEffects() {
		var arr = new ArrayList<EventSoundEffect>();

		ZenKit.API.ZkAnimation_enumerateSoundEffects(handle, (ctx, evt) -> {
			arr.add(NativeEventSoundEffect.fromNativeHandle(evt));
			return false;
		}, Pointer.NULL);

		return arr;
	}

	@Override
	public @NotNull List<@NotNull EventSoundEffectGround> soundEffectsGround() {
		var arr = new ArrayList<EventSoundEffectGround>();

		ZenKit.API.ZkAnimation_enumerateSoundEffectGrounds(handle, (ctx, evt) -> {
			arr.add(NativeEventSoundEffectGround.fromNativeHandle(evt));
			return false;
		}, Pointer.NULL);

		return arr;
	}

	@Override
	public @NotNull List<@NotNull EventMorphAnimation> morphAnimations() {
		var arr = new ArrayList<EventMorphAnimation>();

		ZenKit.API.ZkAnimation_enumerateMorphAnimations(handle, (ctx, evt) -> {
			arr.add(NativeEventMorphAnimation.fromNativeHandle(evt));
			return false;
		}, Pointer.NULL);

		return arr;
	}

	@Override
	public @NotNull List<@NotNull EventCameraTremor> cameraTremors() {
		var arr = new ArrayList<EventCameraTremor>();

		ZenKit.API.ZkAnimation_enumerateCameraTremors(handle, (ctx, evt) -> {
			arr.add(NativeEventCameraTremor.fromNativeHandle(evt));
			return false;
		}, Pointer.NULL);

		return arr;
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle;
	}

	@Override
	public @NotNull CachedAnimation cache() {
		return new CachedAnimation(
				name(),
				layer(),
				next(),
				blendIn(),
				blendOut(),
				flags(),
				model(),
				direction(),
				firstFrame(),
				lastFrame(),
				fps(),
				speed(),
				collisionVolumeScale(),
				eventTags().stream().map(CacheableObject::cache).collect(Collectors.toList()),
				particleEffects().stream().map(CacheableObject::cache).collect(Collectors.toList()),
				particleEffectsStop().stream().map(CacheableObject::cache).collect(Collectors.toList()),
				soundEffects().stream().map(CacheableObject::cache).collect(Collectors.toList()),
				soundEffectsGround().stream().map(CacheableObject::cache).collect(Collectors.toList()),
				morphAnimations().stream().map(CacheableObject::cache).collect(Collectors.toList()),
				cameraTremors().stream().map(CacheableObject::cache).collect(Collectors.toList())
		);
	}

	@Override
	public boolean isCached() {
		return false;
	}
}
