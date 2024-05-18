package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.Color;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public class ZoneFog extends VirtualObject {
	public ZoneFog() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCZoneZFog));
	}

	public ZoneFog(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkZoneFog_load(buf.getHandle(), version), ZenKit.API::ZkZoneFog_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load ZoneFog vob");
	}

	public ZoneFog(String path, GameVersion version) {
		super(ZenKit.API.ZkZoneFog_loadPath(path, version), ZenKit.API::ZkZoneFog_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load ZoneFog vob");
	}

	public ZoneFog(Pointer handle) {
		super(handle, ZenKit.API::ZkZoneFog_del);
	}

	public float getRangeCenter() {
		return ZenKit.API.ZkZoneFog_getRangeCenter(getHandle());
	}

	public void setRangeCenter(float val) {
		ZenKit.API.ZkZoneFog_setRangeCenter(getHandle(), val);
	}

	public float getInnerRangePercentage() {
		return ZenKit.API.ZkZoneFog_getInnerRangePercentage(getHandle());
	}

	public void setInnerRangePercentage(float val) {
		ZenKit.API.ZkZoneFog_setInnerRangePercentage(getHandle(), val);
	}

	public Color getColor() {
		return ZenKit.API.ZkZoneFog_getColor(getHandle());
	}

	public void setColor(Color val) {
		ZenKit.API.ZkZoneFog_setColor(getHandle(), new Color.ByValue(val));
	}

	public boolean getFadeOutSky() {
		return ZenKit.API.ZkZoneFog_getFadeOutSky(getHandle());
	}

	public void setFadeOutSky(boolean val) {
		ZenKit.API.ZkZoneFog_setFadeOutSky(getHandle(), val);
	}

	public boolean getOverrideColor() {
		return ZenKit.API.ZkZoneFog_getOverrideColor(getHandle());
	}

	public void setOverrideColor(boolean val) {
		ZenKit.API.ZkZoneFog_setOverrideColor(getHandle(), val);
	}
}
