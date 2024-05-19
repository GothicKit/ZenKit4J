package dev.gothickit.zenkit.world;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class EventManager implements NativeObject {
	private final Handle handle;

	public EventManager() {
		this(ZenKit.API.ZkEventManager_new());
	}

	private EventManager(Pointer handle) {
		this.handle = new Handle(handle, ZenKit.API::ZkEventManager_del);
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable EventManager fromNativeHandle(@Nullable Pointer handle) {
		if (handle == null) return null;

		handle = ZenKit.API.ZkObject_takeRef(handle);
		return new EventManager(handle);
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle.get();
	}

	public boolean isCleared() {
		return ZenKit.API.ZkEventManager_getCleared(getNativeHandle());
	}

	public void setCleared(boolean val) {
		ZenKit.API.ZkEventManager_setCleared(getNativeHandle(), val);
	}

	public boolean isActive() {
		return ZenKit.API.ZkEventManager_getActive(getNativeHandle());
	}

	public void setActive(boolean val) {
		ZenKit.API.ZkEventManager_setActive(getNativeHandle(), val);
	}
}
