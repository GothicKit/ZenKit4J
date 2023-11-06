package dev.gothickit.zenkit.mds;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;

public class EventParticleEffectStop {
	private final Pointer handle;

	public EventParticleEffectStop(Pointer handle) {
		this.handle = handle;
	}

	public int getFrame() {
		return ZenKit.API.ZkEventParticleEffectStop_getFrame(handle);
	}

	public int getIndex() {
		return ZenKit.API.ZkEventParticleEffectStop_getIndex(handle);
	}
}
