package dev.gothickit.zenkit.mds;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;

import java.util.ArrayList;
import java.util.List;

public class Animation {
	private final Pointer handle;

	public Animation(Pointer handle) {
		this.handle = handle;
	}

	public String getName() {
		return ZenKit.API.ZkAnimation_getName(handle);
	}

	public int getLayer() {
		return ZenKit.API.ZkAnimation_getLayer(handle);
	}

	public String getNext() {
		return ZenKit.API.ZkAnimation_getNext(handle);
	}

	public float getBlendIn() {
		return ZenKit.API.ZkAnimation_getBlendIn(handle);
	}

	public float getBlendOut() {
		return ZenKit.API.ZkAnimation_getBlendOut(handle);
	}

	public int getFlags() {
		return ZenKit.API.ZkAnimation_getFlags(handle);
	}

	public String getModel() {
		return ZenKit.API.ZkAnimation_getModel(handle);
	}

	public AnimationDirection getDirection() {
		return ZenKit.API.ZkAnimation_getDirection(handle);
	}

	public int getFirstFrame() {
		return ZenKit.API.ZkAnimation_getFirstFrame(handle);
	}

	public int getLastFrame() {
		return ZenKit.API.ZkAnimation_getLastFrame(handle);
	}

	public float getFps() {
		return ZenKit.API.ZkAnimation_getFps(handle);
	}

	public float getSpeed() {
		return ZenKit.API.ZkAnimation_getSpeed(handle);
	}

	public float getCollisionVolumeScale() {
		return ZenKit.API.ZkAnimation_getCollisionVolumeScale(handle);
	}

	public long getEventTagCount() {
		return ZenKit.API.ZkAnimation_getEventTagCount(handle);
	}

	public long getParticleEffectCount() {
		return ZenKit.API.ZkAnimation_getParticleEffectCount(handle);
	}

	public long getParticleEffectStopCount() {
		return ZenKit.API.ZkAnimation_getParticleEffectStopCount(handle);
	}

	public long getSoundEffectCount() {
		return ZenKit.API.ZkAnimation_getSoundEffectCount(handle);
	}

	public long getSoundEffectGroundCount() {
		return ZenKit.API.ZkAnimation_getSoundEffectGroundCount(handle);
	}

	public long getMorphAnimationCount() {
		return ZenKit.API.ZkAnimation_getMorphAnimationCount(handle);
	}

	public long getCameraTremorCount() {
		return ZenKit.API.ZkAnimation_getCameraTremorCount(handle);
	}

	public EventTag getEventTag(long i) {
		return new EventTag(ZenKit.API.ZkAnimation_getEventTag(handle, i));
	}

	public EventParticleEffect getParticleEffect(long i) {
		return new EventParticleEffect(ZenKit.API.ZkAnimation_getParticleEffect(handle, i));
	}

	public EventParticleEffectStop getParticleEffectStop(long i) {
		return new EventParticleEffectStop(ZenKit.API.ZkAnimation_getParticleEffectStop(handle, i));
	}

	public EventSoundEffect getSoundEffect(long i) {
		return new EventSoundEffect(ZenKit.API.ZkAnimation_getSoundEffect(handle, i));
	}

	public EventSoundEffectGround getSoundEffectGround(long i) {
		return new EventSoundEffectGround(ZenKit.API.ZkAnimation_getSoundEffectGround(handle, i));
	}

	public EventMorphAnimation getMorphAnimation(long i) {
		return new EventMorphAnimation(ZenKit.API.ZkAnimation_getMorphAnimation(handle, i));
	}

	public EventCameraTremor getCameraTremor(long i) {
		return new EventCameraTremor(ZenKit.API.ZkAnimation_getCameraTremor(handle, i));
	}

	public List<EventTag> getEventTags() {
		var arr = new ArrayList<EventTag>();

		ZenKit.API.ZkAnimation_enumerateEventTags(handle, (ctx, evt) -> {
			arr.add(new EventTag(evt));
			return false;
		}, Pointer.NULL);

		return arr;
	}

	public List<EventParticleEffect> getParticleEffects() {
		var arr = new ArrayList<EventParticleEffect>();

		ZenKit.API.ZkAnimation_enumerateParticleEffects(handle, (ctx, evt) -> {
			arr.add(new EventParticleEffect(evt));
			return false;
		}, Pointer.NULL);

		return arr;
	}

	public List<EventParticleEffectStop> getParticleEffectsStop() {
		var arr = new ArrayList<EventParticleEffectStop>();

		ZenKit.API.ZkAnimation_enumerateParticleEffectStops(handle, (ctx, evt) -> {
			arr.add(new EventParticleEffectStop(evt));
			return false;
		}, Pointer.NULL);

		return arr;
	}

	public List<EventSoundEffect> getSoundEffects() {
		var arr = new ArrayList<EventSoundEffect>();

		ZenKit.API.ZkAnimation_enumerateSoundEffects(handle, (ctx, evt) -> {
			arr.add(new EventSoundEffect(evt));
			return false;
		}, Pointer.NULL);

		return arr;
	}

	public List<EventSoundEffectGround> getSoundEffectsGround() {
		var arr = new ArrayList<EventSoundEffectGround>();

		ZenKit.API.ZkAnimation_enumerateSoundEffectGrounds(handle, (ctx, evt) -> {
			arr.add(new EventSoundEffectGround(evt));
			return false;
		}, Pointer.NULL);

		return arr;
	}

	public List<EventMorphAnimation> getMorphAnimations() {
		var arr = new ArrayList<EventMorphAnimation>();

		ZenKit.API.ZkAnimation_enumerateMorphAnimations(handle, (ctx, evt) -> {
			arr.add(new EventMorphAnimation(evt));
			return false;
		}, Pointer.NULL);

		return arr;
	}

	public List<EventCameraTremor> getCameraTremors() {
		var arr = new ArrayList<EventCameraTremor>();

		ZenKit.API.ZkAnimation_enumerateCameraTremors(handle, (ctx, evt) -> {
			arr.add(new EventCameraTremor(evt));
			return false;
		}, Pointer.NULL);

		return arr;
	}
}
