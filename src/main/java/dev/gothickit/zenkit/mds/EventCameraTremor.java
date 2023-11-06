package dev.gothickit.zenkit.mds;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;

public class EventCameraTremor {
	private final Pointer handle;

	public EventCameraTremor(Pointer handle) {
		this.handle = handle;
	}

	public int getFrame() {
		return ZenKit.API.ZkEventCameraTremor_getFrame(handle);
	}

	public int getField1() {
		return ZenKit.API.ZkEventCameraTremor_getField1(handle);
	}

	public int getField2() {
		return ZenKit.API.ZkEventCameraTremor_getField2(handle);
	}

	public int getField3() {
		return ZenKit.API.ZkEventCameraTremor_getField3(handle);
	}

	public int getField4() {
		return ZenKit.API.ZkEventCameraTremor_getField4(handle);
	}
}
