package dev.gothickit.zenkit.world;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;

public class EventManager {
	private final Handle handle;

	public EventManager() {
		this(ZenKit.API.ZkEventManager_new());
	}

	public EventManager(Pointer handle) {
		this.handle = new Handle(handle, ZenKit.API::ZkEventManager_del);
	}

	public Pointer getHandle() {
		return handle.get();
	}

	public boolean isCleared() {
		return ZenKit.API.ZkEventManager_getCleared(getHandle());
	}

	public void setCleared(boolean val) {
		ZenKit.API.ZkEventManager_setCleared(getHandle(), val);
	}

	public boolean isActive() {
		return ZenKit.API.ZkEventManager_getActive(getHandle());
	}

	public void setActive(boolean val) {
		ZenKit.API.ZkEventManager_setActive(getHandle(), val);
	}
}
