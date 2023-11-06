package dev.gothickit.zenkit.mds;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;

public class EventSoundEffect {
	private final Pointer handle;

	public EventSoundEffect(Pointer handle) {
		this.handle = handle;
	}

	public int getFrame() {
		return ZenKit.API.ZkEventSoundEffect_getFrame(handle);
	}

	public String getName() {
		return ZenKit.API.ZkEventSoundEffect_getName(handle);
	}

	public float getRange() {
		return ZenKit.API.ZkEventSoundEffect_getRange(handle);
	}

	public boolean getEmptySlot() {
		return ZenKit.API.ZkEventSoundEffect_getEmptySlot(handle);
	}
}
