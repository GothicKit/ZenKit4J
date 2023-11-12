package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public class SoundSystemInstance extends DaedalusInstance {
	public SoundSystemInstance(Pointer handle) {
		super(handle);
	}

	public float getVolume() {
		return ZenKit.API.ZkSoundSystemInstance_getVolume(getHandle());
	}

	public int getBitResolution() {
		return ZenKit.API.ZkSoundSystemInstance_getBitResolution(getHandle());
	}

	public int getSampleRate() {
		return ZenKit.API.ZkSoundSystemInstance_getSampleRate(getHandle());
	}

	public int getUseStereo() {
		return ZenKit.API.ZkSoundSystemInstance_getUseStereo(getHandle());
	}

	public int getNumSfxChannels() {
		return ZenKit.API.ZkSoundSystemInstance_getNumSfxChannels(getHandle());
	}

	public String getUsed3DProviderName() {
		return ZenKit.API.ZkSoundSystemInstance_getUsed3DProviderName(getHandle());
	}
}
