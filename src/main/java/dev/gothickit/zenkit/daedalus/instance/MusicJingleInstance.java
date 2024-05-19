package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public final class MusicJingleInstance extends DaedalusInstance {
	public MusicJingleInstance(Pointer handle) {
		super(handle);
	}

	public String getName() {
		return ZenKit.API.ZkMusicJingleInstance_getName(getNativeHandle());
	}

	public int getLoop() {
		return ZenKit.API.ZkMusicJingleInstance_getLoop(getNativeHandle());
	}

	public float getVol() {
		return ZenKit.API.ZkMusicJingleInstance_getVol(getNativeHandle());
	}

	public int getTransSubType() {
		return ZenKit.API.ZkMusicJingleInstance_getTranssubtype(getNativeHandle());
	}
}
