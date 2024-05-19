package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.Color;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public final class ZoneFog extends VirtualObject {
	public ZoneFog() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCZoneZFog));
	}

	ZoneFog(@NotNull NativeRead buf, GameVersion version) {
		super(ZenKit.API.ZkZoneFog_load(buf.getNativeHandle(), version), ZenKit.API::ZkZoneFog_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load ZoneFog vob");
	}

	ZoneFog(String path, GameVersion version) {
		super(ZenKit.API.ZkZoneFog_loadPath(path, version), ZenKit.API::ZkZoneFog_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load ZoneFog vob");
	}

	ZoneFog(Pointer handle) {
		super(handle, ZenKit.API::ZkZoneFog_del);
	}

	public float getRangeCenter() {
		return ZenKit.API.ZkZoneFog_getRangeCenter(getNativeHandle());
	}

	public void setRangeCenter(float val) {
		ZenKit.API.ZkZoneFog_setRangeCenter(getNativeHandle(), val);
	}

	public float getInnerRangePercentage() {
		return ZenKit.API.ZkZoneFog_getInnerRangePercentage(getNativeHandle());
	}

	public void setInnerRangePercentage(float val) {
		ZenKit.API.ZkZoneFog_setInnerRangePercentage(getNativeHandle(), val);
	}

	public Color getColor() {
		return ZenKit.API.ZkZoneFog_getColor(getNativeHandle());
	}

	public void setColor(Color val) {
		ZenKit.API.ZkZoneFog_setColor(getNativeHandle(), new Color.ByValue(val));
	}

	public boolean getFadeOutSky() {
		return ZenKit.API.ZkZoneFog_getFadeOutSky(getNativeHandle());
	}

	public void setFadeOutSky(boolean val) {
		ZenKit.API.ZkZoneFog_setFadeOutSky(getNativeHandle(), val);
	}

	public boolean getOverrideColor() {
		return ZenKit.API.ZkZoneFog_getOverrideColor(getNativeHandle());
	}

	public void setOverrideColor(boolean val) {
		ZenKit.API.ZkZoneFog_setOverrideColor(getNativeHandle(), val);
	}
}
