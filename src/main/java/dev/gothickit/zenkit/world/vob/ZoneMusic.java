package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public class ZoneMusic extends VirtualObject {
	public ZoneMusic(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkZoneMusic_load(buf.getHandle(), version), ZenKit.API::ZkZoneMusic_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load ZoneMusic vob");
	}

	public ZoneMusic(String path, GameVersion version) {
		super(ZenKit.API.ZkZoneMusic_loadPath(path, version), ZenKit.API::ZkZoneMusic_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load ZoneMusic vob");
	}

	public ZoneMusic(Pointer handle) {
		super(handle);
	}

	public boolean isEnabled() {
		return ZenKit.API.ZkZoneMusic_getIsEnabled(getHandle());
	}

	public int getPriority() {
		return ZenKit.API.ZkZoneMusic_getPriority(getHandle());
	}

	public boolean isEllipsoid() {
		return ZenKit.API.ZkZoneMusic_getIsEllipsoid(getHandle());
	}

	public float getReverb() {
		return ZenKit.API.ZkZoneMusic_getReverb(getHandle());
	}

	public float getVolume() {
		return ZenKit.API.ZkZoneMusic_getVolume(getHandle());
	}

	public boolean isLoop() {
		return ZenKit.API.ZkZoneMusic_getIsLoop(getHandle());
	}
}
