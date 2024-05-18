package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public class ZoneFarPlane extends VirtualObject {
	public ZoneFarPlane() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCZoneVobFarPlane));
	}

	public ZoneFarPlane(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkZoneFarPlane_load(buf.getHandle(), version), ZenKit.API::ZkZoneFarPlane_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load ZoneFarPlane vob");
	}

	public ZoneFarPlane(String path, GameVersion version) {
		super(ZenKit.API.ZkZoneFarPlane_loadPath(path, version), ZenKit.API::ZkZoneFarPlane_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load ZoneFarPlane vob");
	}

	public ZoneFarPlane(Pointer handle) {
		super(handle, ZenKit.API::ZkZoneFarPlane_del);
	}

	public float getVobFarPlaneZ() {
		return ZenKit.API.ZkZoneFarPlane_getVobFarPlaneZ(getHandle());
	}

	public void setVobFarPlaneZ(float val) {
		ZenKit.API.ZkZoneFarPlane_setVobFarPlaneZ(getHandle(), val);
	}

	public float getInnerRangePercentage() {
		return ZenKit.API.ZkZoneFarPlane_getInnerRangePercentage(getHandle());
	}

	public void setInnerRangePercentage(float val) {
		ZenKit.API.ZkZoneFarPlane_setInnerRangePercentage(getHandle(), val);
	}
}
