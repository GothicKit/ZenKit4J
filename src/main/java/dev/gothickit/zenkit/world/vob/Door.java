package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public final class Door extends InteractiveObject {
	public Door() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.oCMobDoor));
	}

	Door(@NotNull NativeRead buf, GameVersion version) {
		super(ZenKit.API.ZkDoor_load(buf.getNativeHandle(), version), ZenKit.API::ZkDoor_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Door vob");
	}

	Door(String path, GameVersion version) {
		super(ZenKit.API.ZkDoor_loadPath(path, version), ZenKit.API::ZkFire_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Door vob");
	}

	Door(Pointer handle) {
		super(handle, ZenKit.API::ZkDoor_del);
	}

	public boolean isLocked() {
		return ZenKit.API.ZkDoor_getIsLocked(getNativeHandle());
	}

	public void setLocked(boolean val) {
		ZenKit.API.ZkDoor_setIsLocked(getNativeHandle(), val);
	}

	public String getKey() {
		return ZenKit.API.ZkDoor_getKey(getNativeHandle());
	}

	public void setKey(String val) {
		ZenKit.API.ZkDoor_setKey(getNativeHandle(), val);
	}

	public String getPickString() {
		return ZenKit.API.ZkDoor_getPickString(getNativeHandle());
	}

	public void setPickString(String val) {
		ZenKit.API.ZkDoor_setPickString(getNativeHandle(), val);
	}
}
