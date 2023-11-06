package dev.gothickit.zenkit.mds;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import dev.gothickit.zenkit.capi.ZenKit;

public class EventTag {
	private final Pointer handle;

	public EventTag(Pointer handle) {
		this.handle = handle;
	}

	public int getFrame() {
		return ZenKit.API.ZkEventTag_getFrame(handle);
	}

	public EventType getType() {
		return ZenKit.API.ZkEventTag_getType(handle);
	}

	public String getSlot(long i) {
		return ZenKit.API.ZkEventTag_getSlot(handle, i);
	}

	public String getItem() {
		return ZenKit.API.ZkEventTag_getItem(handle);
	}

	public int[] getFrames() {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkEventTag_getFrames(handle, count);
		if (ptr == Pointer.NULL || count.getValue() == 0) return new int[0];
		return ptr.getIntArray(0, count.getValue());
	}

	public FightMode getFightMode() {
		return ZenKit.API.ZkEventTag_getFightMode(handle);
	}

	public boolean isAttached() {
		return ZenKit.API.ZkEventTag_getIsAttached(handle);
	}
}
