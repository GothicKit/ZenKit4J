package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public class Item extends VirtualObject {
	public Item(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkItem_load(buf.getHandle(), version), ZenKit.API::ZkItem_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Item vob");
	}

	public Item(String path, GameVersion version) {
		super(ZenKit.API.ZkItem_loadPath(path, version), ZenKit.API::ZkItem_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Item vob");
	}

	public Item(Pointer handle) {
		super(handle);
	}

	public String getInstance() {
		return ZenKit.API.ZkItem_getInstance(getHandle());
	}
}
