package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public final class Fire extends InteractiveObject {
	public Fire() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.oCMobFire));
	}

	Fire(@NotNull NativeRead buf, GameVersion version) {
		super(ZenKit.API.ZkFire_load(buf.getNativeHandle(), version), ZenKit.API::ZkFire_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Fire vob");
	}

	Fire(String path, GameVersion version) {
		super(ZenKit.API.ZkFire_loadPath(path, version), ZenKit.API::ZkFire_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Fire vob");
	}

	Fire(Pointer handle) {
		super(handle, ZenKit.API::ZkFire_del);
	}

	public String getSlot() {
		return ZenKit.API.ZkFire_getSlot(getNativeHandle());
	}

	public void setSlot(String val) {
		ZenKit.API.ZkFire_setSlot(getNativeHandle(), val);
	}

	public String getVobTree() {
		return ZenKit.API.ZkFire_getVobTree(getNativeHandle());
	}

	public void setVobTree(String val) {
		ZenKit.API.ZkFire_setVobTree(getNativeHandle(), val);
	}
}
