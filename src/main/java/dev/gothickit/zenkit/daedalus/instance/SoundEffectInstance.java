package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public final class SoundEffectInstance extends DaedalusInstance {
	public SoundEffectInstance(Pointer handle) {
		super(handle);
	}

	public String getFile() {
		return ZenKit.API.ZkSoundEffectInstance_getFile(getNativeHandle());
	}

	public int getPitchOff() {
		return ZenKit.API.ZkSoundEffectInstance_getPitchOff(getNativeHandle());
	}

	public int getPitchVar() {
		return ZenKit.API.ZkSoundEffectInstance_getPitchVar(getNativeHandle());
	}

	public int getVolume() {
		return ZenKit.API.ZkSoundEffectInstance_getVolume(getNativeHandle());
	}

	public int getLoop() {
		return ZenKit.API.ZkSoundEffectInstance_getLoop(getNativeHandle());
	}

	public int getLoopStartOffset() {
		return ZenKit.API.ZkSoundEffectInstance_getLoopStartOffset(getNativeHandle());
	}

	public int getLoopEndOffset() {
		return ZenKit.API.ZkSoundEffectInstance_getLoopEndOffset(getNativeHandle());
	}

	public float getReverbLevel() {
		return ZenKit.API.ZkSoundEffectInstance_getReverbLevel(getNativeHandle());
	}

	public String getPfxName() {
		return ZenKit.API.ZkSoundEffectInstance_getPfxName(getNativeHandle());
	}

}
