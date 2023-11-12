package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public class SoundEffectInstance extends DaedalusInstance {
	public SoundEffectInstance(Pointer handle) {
		super(handle);
	}

	public String getFile() {
		return ZenKit.API.ZkSoundEffectInstance_getFile(getHandle());
	}

	public int getPitchOff() {
		return ZenKit.API.ZkSoundEffectInstance_getPitchOff(getHandle());
	}

	public int getPitchVar() {
		return ZenKit.API.ZkSoundEffectInstance_getPitchVar(getHandle());
	}

	public int getVolume() {
		return ZenKit.API.ZkSoundEffectInstance_getVolume(getHandle());
	}

	public int getLoop() {
		return ZenKit.API.ZkSoundEffectInstance_getLoop(getHandle());
	}

	public int getLoopStartOffset() {
		return ZenKit.API.ZkSoundEffectInstance_getLoopStartOffset(getHandle());
	}

	public int getLoopEndOffset() {
		return ZenKit.API.ZkSoundEffectInstance_getLoopEndOffset(getHandle());
	}

	public float getReverbLevel() {
		return ZenKit.API.ZkSoundEffectInstance_getReverbLevel(getHandle());
	}

	public String getPfxName() {
		return ZenKit.API.ZkSoundEffectInstance_getPfxName(getHandle());
	}

}
