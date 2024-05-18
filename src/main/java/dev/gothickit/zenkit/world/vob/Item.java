package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public class Item extends VirtualObject {
	public Item() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.oCItem));
	}

	public Item(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkItem_load(buf.getHandle(), version), ZenKit.API::ZkItem_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Item vob");
	}

	public Item(String path, GameVersion version) {
		super(ZenKit.API.ZkItem_loadPath(path, version), ZenKit.API::ZkItem_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Item vob");
	}

	public Item(Pointer handle) {
		super(handle, ZenKit.API::ZkItem_del);
	}

	public String getInstance() {
		return ZenKit.API.ZkItem_getInstance(getHandle());
	}

	public void setInstance(String val) {
		ZenKit.API.ZkItem_setInstance(getHandle(), val);
	}

	public int getAmount() {
		return ZenKit.API.ZkItem_getFlags(getHandle());
	}

	public void setAmount(int val) {
		ZenKit.API.ZkItem_setFlags(getHandle(), val);
	}

	public int getFlags() {
		return ZenKit.API.ZkItem_getAmount(getHandle());
	}

	public void setFlags(int val) {
		ZenKit.API.ZkItem_setAmount(getHandle(), val);
	}
}
