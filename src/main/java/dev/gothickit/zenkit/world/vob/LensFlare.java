package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public final class LensFlare extends VirtualObject {
	public LensFlare() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCVobLensFlare));
	}

	LensFlare(@NotNull NativeRead buf, GameVersion version) {
		super(ZenKit.API.ZkLensFlare_load(buf.getNativeHandle(), version), ZenKit.API::ZkLensFlare_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load LensFlare vob");
	}

	LensFlare(String path, GameVersion version) {
		super(ZenKit.API.ZkLensFlare_loadPath(path, version), ZenKit.API::ZkLensFlare_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load LensFlare vob");
	}

	LensFlare(Pointer handle) {
		super(handle, ZenKit.API::ZkLensFlare_del);
	}

	public String getEffect() {
		return ZenKit.API.ZkLensFlare_getEffect(getNativeHandle());
	}

	public void setEffect(String val) {
		ZenKit.API.ZkLensFlare_setEffect(getNativeHandle(), val);
	}
}
