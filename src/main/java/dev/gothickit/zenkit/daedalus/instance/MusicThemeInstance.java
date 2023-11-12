package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public class MusicThemeInstance extends DaedalusInstance {
	public MusicThemeInstance(Pointer handle) {
		super(handle);
	}

	public String getFile() {
		return ZenKit.API.ZkMusicThemeInstance_getFile(getHandle());
	}

	public float getVol() {
		return ZenKit.API.ZkMusicThemeInstance_getVol(getHandle());
	}

	public int getLoop() {
		return ZenKit.API.ZkMusicThemeInstance_getLoop(getHandle());
	}

	public float getReverbmix() {
		return ZenKit.API.ZkMusicThemeInstance_getReverbmix(getHandle());
	}

	public float getReverbtime() {
		return ZenKit.API.ZkMusicThemeInstance_getReverbtime(getHandle());
	}

	public MusicTransitionEffect getTransType() {
		return ZenKit.API.ZkMusicThemeInstance_getTranstype(getHandle());
	}

	public MusicTransitionType getTransSubType() {
		return ZenKit.API.ZkMusicThemeInstance_getTranssubtype(getHandle());
	}
}
