package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public final class Item extends VirtualObject {
	public Item() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.oCItem));
	}

	Item(@NotNull NativeRead buf, GameVersion version) {
		super(ZenKit.API.ZkItem_load(buf.getNativeHandle(), version), ZenKit.API::ZkItem_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Item vob");
	}

	Item(String path, GameVersion version) {
		super(ZenKit.API.ZkItem_loadPath(path, version), ZenKit.API::ZkItem_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Item vob");
	}

	Item(Pointer handle) {
		super(handle, ZenKit.API::ZkItem_del);
	}

	public String getInstance() {
		return ZenKit.API.ZkItem_getInstance(getNativeHandle());
	}

	public void setInstance(String val) {
		ZenKit.API.ZkItem_setInstance(getNativeHandle(), val);
	}

	public int getAmount() {
		return ZenKit.API.ZkItem_getFlags(getNativeHandle());
	}

	public void setAmount(int val) {
		ZenKit.API.ZkItem_setFlags(getNativeHandle(), val);
	}

	public int getFlags() {
		return ZenKit.API.ZkItem_getAmount(getNativeHandle());
	}

	public void setFlags(int val) {
		ZenKit.API.ZkItem_setAmount(getNativeHandle(), val);
	}
}
