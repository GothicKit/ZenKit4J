package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public final class MusicSystemInstance extends DaedalusInstance {
	public MusicSystemInstance(Pointer handle) {
		super(handle);
	}

	public float getVolume() {
		return ZenKit.API.ZkMusicSystemInstance_getVolume(getNativeHandle());
	}

	public int getBitResolution() {
		return ZenKit.API.ZkMusicSystemInstance_getBitResolution(getNativeHandle());
	}

	public int getGlobalReverbEnabled() {
		return ZenKit.API.ZkMusicSystemInstance_getGlobalReverbEnabled(getNativeHandle());
	}

	public int getSampleRate() {
		return ZenKit.API.ZkMusicSystemInstance_getSampleRate(getNativeHandle());
	}

	public int getNumChannels() {
		return ZenKit.API.ZkMusicSystemInstance_getNumChannels(getNativeHandle());
	}

	public int getReverbBufferSize() {
		return ZenKit.API.ZkMusicSystemInstance_getReverbBufferSize(getNativeHandle());
	}
}
