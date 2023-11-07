package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class Door extends InteractiveObject {
	public Door(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkDoor_load(buf.getHandle(), version), ZenKit.API::ZkDoor_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Door vob");
	}

	public Door(String path, GameVersion version) {
		super(ZenKit.API.ZkDoor_loadPath(path, version), ZenKit.API::ZkFire_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Door vob");
	}

	public Door(Pointer handle, Consumer<Pointer> delete) {
		super(handle, delete);
	}

	public Door(Pointer handle) {
		super(handle);
	}

	public boolean isLocked() {
		return ZenKit.API.ZkDoor_getIsLocked(getHandle());
	}

	public String getKey() {
		return ZenKit.API.ZkDoor_getKey(getHandle());
	}

	public String getPickString() {
		return ZenKit.API.ZkDoor_getPickString(getHandle());
	}
}
