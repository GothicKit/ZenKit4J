package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public class MusicJingleInstance extends DaedalusInstance {
	public MusicJingleInstance(Pointer handle) {
		super(handle);
	}

	public String getName() {
		return ZenKit.API.ZkMusicJingleInstance_getName(getHandle());
	}

	public int getLoop() {
		return ZenKit.API.ZkMusicJingleInstance_getLoop(getHandle());
	}

	public float getVol() {
		return ZenKit.API.ZkMusicJingleInstance_getVol(getHandle());
	}

	public int getTransSubType() {
		return ZenKit.API.ZkMusicJingleInstance_getTranssubtype(getHandle());
	}
}
