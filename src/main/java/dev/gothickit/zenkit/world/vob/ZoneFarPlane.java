package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public class ZoneFarPlane extends VirtualObject {
	public ZoneFarPlane(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkZoneFarPlane_load(buf.getHandle(), version), ZenKit.API::ZkZoneFarPlane_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load ZoneFarPlane vob");
	}

	public ZoneFarPlane(String path, GameVersion version) {
		super(ZenKit.API.ZkZoneFarPlane_loadPath(path, version), ZenKit.API::ZkZoneFarPlane_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load ZoneFarPlane vob");
	}

	public ZoneFarPlane(Pointer handle) {
		super(handle);
	}

	public float getVobFarPlaneZ() {
		return ZenKit.API.ZkZoneFarPlane_getVobFarPlaneZ(getHandle());
	}

	public float getInnerRangePercentage() {
		return ZenKit.API.ZkZoneFarPlane_getInnerRangePercentage(getHandle());
	}
}
