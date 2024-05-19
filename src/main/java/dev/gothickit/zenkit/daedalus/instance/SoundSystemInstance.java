package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public final class SoundSystemInstance extends DaedalusInstance {
	public SoundSystemInstance(Pointer handle) {
		super(handle);
	}

	public float getVolume() {
		return ZenKit.API.ZkSoundSystemInstance_getVolume(getNativeHandle());
	}

	public int getBitResolution() {
		return ZenKit.API.ZkSoundSystemInstance_getBitResolution(getNativeHandle());
	}

	public int getSampleRate() {
		return ZenKit.API.ZkSoundSystemInstance_getSampleRate(getNativeHandle());
	}

	public int getUseStereo() {
		return ZenKit.API.ZkSoundSystemInstance_getUseStereo(getNativeHandle());
	}

	public int getNumSfxChannels() {
		return ZenKit.API.ZkSoundSystemInstance_getNumSfxChannels(getNativeHandle());
	}

	public String getUsed3DProviderName() {
		return ZenKit.API.ZkSoundSystemInstance_getUsed3DProviderName(getNativeHandle());
	}
}
