package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public final class ZoneFarPlane extends VirtualObject {
	public ZoneFarPlane() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCZoneVobFarPlane));
	}

	ZoneFarPlane(@NotNull NativeRead buf, GameVersion version) {
		super(ZenKit.API.ZkZoneFarPlane_load(buf.getNativeHandle(), version), ZenKit.API::ZkZoneFarPlane_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load ZoneFarPlane vob");
	}

	ZoneFarPlane(String path, GameVersion version) {
		super(ZenKit.API.ZkZoneFarPlane_loadPath(path, version), ZenKit.API::ZkZoneFarPlane_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load ZoneFarPlane vob");
	}

	ZoneFarPlane(Pointer handle) {
		super(handle, ZenKit.API::ZkZoneFarPlane_del);
	}

	public float getVobFarPlaneZ() {
		return ZenKit.API.ZkZoneFarPlane_getVobFarPlaneZ(getNativeHandle());
	}

	public void setVobFarPlaneZ(float val) {
		ZenKit.API.ZkZoneFarPlane_setVobFarPlaneZ(getNativeHandle(), val);
	}

	public float getInnerRangePercentage() {
		return ZenKit.API.ZkZoneFarPlane_getInnerRangePercentage(getNativeHandle());
	}

	public void setInnerRangePercentage(float val) {
		ZenKit.API.ZkZoneFarPlane_setInnerRangePercentage(getNativeHandle(), val);
	}
}
