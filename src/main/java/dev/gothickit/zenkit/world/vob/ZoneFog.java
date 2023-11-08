package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.Color;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public class ZoneFog extends VirtualObject {
	public ZoneFog(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkZoneFog_load(buf.getHandle(), version), ZenKit.API::ZkZoneFog_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load ZoneFog vob");
	}

	public ZoneFog(String path, GameVersion version) {
		super(ZenKit.API.ZkZoneFog_loadPath(path, version), ZenKit.API::ZkZoneFog_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load ZoneFog vob");
	}

	public ZoneFog(Pointer handle) {
		super(handle);
	}

	public float getRangeCenter() {
		return ZenKit.API.ZkZoneFog_getRangeCenter(getHandle());
	}

	public float getInnerRangePercentage() {
		return ZenKit.API.ZkZoneFog_getInnerRangePercentage(getHandle());
	}

	public Color getColor() {
		return ZenKit.API.ZkZoneFog_getColor(getHandle());
	}

	public boolean getFadeOutSky() {
		return ZenKit.API.ZkZoneFog_getFadeOutSky(getHandle());
	}

	public boolean getOverrideColor() {
		return ZenKit.API.ZkZoneFog_getOverrideColor(getHandle());
	}

}
