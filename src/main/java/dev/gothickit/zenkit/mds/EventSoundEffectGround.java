package dev.gothickit.zenkit.mds;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;

public class EventSoundEffectGround {
	private final Pointer handle;

	public EventSoundEffectGround(Pointer handle) {
		this.handle = handle;
	}

	public int getFrame() {
		return ZenKit.API.ZkEventSoundEffectGround_getFrame(handle);
	}

	public String getName() {
		return ZenKit.API.ZkEventSoundEffectGround_getName(handle);
	}

	public float getRange() {
		return ZenKit.API.ZkEventSoundEffectGround_getRange(handle);
	}

	public boolean getEmptySlot() {
		return ZenKit.API.ZkEventSoundEffectGround_getEmptySlot(handle);
	}
}
