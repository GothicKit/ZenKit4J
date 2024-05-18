package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public class LensFlare extends VirtualObject {
	public LensFlare() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCVobLensFlare));
	}

	public LensFlare(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkLensFlare_load(buf.getHandle(), version), ZenKit.API::ZkLensFlare_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load LensFlare vob");
	}

	public LensFlare(String path, GameVersion version) {
		super(ZenKit.API.ZkLensFlare_loadPath(path, version), ZenKit.API::ZkLensFlare_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load LensFlare vob");
	}

	public LensFlare(Pointer handle) {
		super(handle, ZenKit.API::ZkLensFlare_del);
	}

	public String getEffect() {
		return ZenKit.API.ZkLensFlare_getEffect(getHandle());
	}

	public void setEffect(String val) {
		ZenKit.API.ZkLensFlare_setEffect(getHandle(), val);
	}
}
