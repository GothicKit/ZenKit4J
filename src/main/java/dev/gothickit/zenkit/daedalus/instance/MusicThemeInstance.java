package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public final class MusicThemeInstance extends DaedalusInstance {
	public MusicThemeInstance(Pointer handle) {
		super(handle);
	}

	public String getFile() {
		return ZenKit.API.ZkMusicThemeInstance_getFile(getNativeHandle());
	}

	public float getVol() {
		return ZenKit.API.ZkMusicThemeInstance_getVol(getNativeHandle());
	}

	public int getLoop() {
		return ZenKit.API.ZkMusicThemeInstance_getLoop(getNativeHandle());
	}

	public float getReverbmix() {
		return ZenKit.API.ZkMusicThemeInstance_getReverbmix(getNativeHandle());
	}

	public float getReverbtime() {
		return ZenKit.API.ZkMusicThemeInstance_getReverbtime(getNativeHandle());
	}

	public MusicTransitionEffect getTransType() {
		return ZenKit.API.ZkMusicThemeInstance_getTranstype(getNativeHandle());
	}

	public MusicTransitionType getTransSubType() {
		return ZenKit.API.ZkMusicThemeInstance_getTranssubtype(getNativeHandle());
	}
}
