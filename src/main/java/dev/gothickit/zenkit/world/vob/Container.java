package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class Container extends InteractiveObject {
	public Container(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkContainer_load(buf.getHandle(), version), ZenKit.API::ZkContainer_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Container vob");
	}

	public Container(String path, GameVersion version) {
		super(ZenKit.API.ZkContainer_loadPath(path, version), ZenKit.API::ZkContainer_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Container vob");
	}

	public Container(Pointer handle, Consumer<Pointer> delete) {
		super(handle, delete);
	}

	public Container(Pointer handle) {
		super(handle);
	}

	public boolean isLocked() {
		return ZenKit.API.ZkContainer_getIsLocked(getHandle());
	}

	public String getKey() {
		return ZenKit.API.ZkContainer_getKey(getHandle());
	}

	public String getPickString() {
		return ZenKit.API.ZkContainer_getPickString(getHandle());
	}

	public String getContents() {
		return ZenKit.API.ZkContainer_getContents(getHandle());
	}
}
