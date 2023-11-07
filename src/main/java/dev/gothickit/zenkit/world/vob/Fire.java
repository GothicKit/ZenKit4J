package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class Fire extends InteractiveObject {
	public Fire(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkFire_load(buf.getHandle(), version), ZenKit.API::ZkFire_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Fire vob");
	}

	public Fire(String path, GameVersion version) {
		super(ZenKit.API.ZkFire_loadPath(path, version), ZenKit.API::ZkFire_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Fire vob");
	}

	public Fire(Pointer handle, Consumer<Pointer> delete) {
		super(handle, delete);
	}

	public Fire(Pointer handle) {
		super(handle);
	}

	public String getSlot() {
		return ZenKit.API.ZkFire_getSlot(getHandle());
	}

	public String getVobTree() {
		return ZenKit.API.ZkFire_getVobTree(getHandle());
	}
}
