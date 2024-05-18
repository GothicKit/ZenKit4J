package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public class ZoneMusic extends VirtualObject {
	public ZoneMusic() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.oCZoneMusic));
	}

	public ZoneMusic(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkZoneMusic_load(buf.getHandle(), version), ZenKit.API::ZkZoneMusic_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load ZoneMusic vob");
	}

	public ZoneMusic(String path, GameVersion version) {
		super(ZenKit.API.ZkZoneMusic_loadPath(path, version), ZenKit.API::ZkZoneMusic_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load ZoneMusic vob");
	}

	public ZoneMusic(Pointer handle) {
		super(handle, ZenKit.API::ZkZoneMusic_del);
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

	public void setEnabled(boolean val) {
		ZenKit.API.ZkZoneMusic_setIsEnabled(getHandle(), val);
	}

	public void setPriority(int val) {
		ZenKit.API.ZkZoneMusic_setPriority(getHandle(), val);
	}

	public void setEllipsoid(boolean val) {
		ZenKit.API.ZkZoneMusic_setIsEllipsoid(getHandle(), val);
	}

	public void setReverb(float val) {
		ZenKit.API.ZkZoneMusic_setReverb(getHandle(), val);
	}

	public void setVolume(float val) {
		ZenKit.API.ZkZoneMusic_setVolume(getHandle(), val);
	}

	public void setLoop(boolean val) {
		ZenKit.API.ZkZoneMusic_setIsLoop(getHandle(), val);
	}

	public boolean getLocalEnabled() {
		return ZenKit.API.ZkZoneMusic_getLocalEnabled(getHandle());
	}

	public boolean getDayEntranceDone() {
		return ZenKit.API.ZkZoneMusic_getDayEntranceDone(getHandle());
	}

	public boolean getNightEntranceDone() {
		return ZenKit.API.ZkZoneMusic_getNightEntranceDone(getHandle());
	}

	public void setLocalEnabled(boolean val) {
		ZenKit.API.ZkZoneMusic_setLocalEnabled(getHandle(), val);
	}

	public void setDayEntranceDone(boolean val) {
		ZenKit.API.ZkZoneMusic_setDayEntranceDone(getHandle(), val);
	}

	public void setNightEntranceDone(boolean val) {
		ZenKit.API.ZkZoneMusic_setNightEntranceDone(getHandle(), val);
	}
}
