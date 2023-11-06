package dev.gothickit.zenkit.mds;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;

public class EventParticleEffect {
	private final Pointer handle;

	public EventParticleEffect(Pointer handle) {
		this.handle = handle;
	}

	public int getFrame() {
		return ZenKit.API.ZkEventParticleEffect_getFrame(handle);
	}

	public int getIndex() {
		return ZenKit.API.ZkEventParticleEffect_getIndex(handle);
	}

	public String getName() {
		return ZenKit.API.ZkEventParticleEffect_getName(handle);
	}

	public String getPosition() {
		return ZenKit.API.ZkEventParticleEffect_getPosition(handle);
	}

	public boolean isAttached() {
		return ZenKit.API.ZkEventParticleEffect_getIsAttached(handle);
	}
}
