package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public class MusicSystemInstance extends DaedalusInstance {
	public MusicSystemInstance(Pointer handle) {
		super(handle);
	}

	public float getVolume() {
		return ZenKit.API.ZkMusicSystemInstance_getVolume(getHandle());
	}

	public int getBitResolution() {
		return ZenKit.API.ZkMusicSystemInstance_getBitResolution(getHandle());
	}

	public int getGlobalReverbEnabled() {
		return ZenKit.API.ZkMusicSystemInstance_getGlobalReverbEnabled(getHandle());
	}

	public int getSampleRate() {
		return ZenKit.API.ZkMusicSystemInstance_getSampleRate(getHandle());
	}

	public int getNumChannels() {
		return ZenKit.API.ZkMusicSystemInstance_getNumChannels(getHandle());
	}

	public int getReverbBufferSize() {
		return ZenKit.API.ZkMusicSystemInstance_getReverbBufferSize(getHandle());
	}
}
