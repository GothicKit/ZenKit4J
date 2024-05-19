package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public final class ZoneMusic extends VirtualObject {
	public ZoneMusic() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.oCZoneMusic));
	}

	ZoneMusic(@NotNull NativeRead buf, GameVersion version) {
		super(ZenKit.API.ZkZoneMusic_load(buf.getNativeHandle(), version), ZenKit.API::ZkZoneMusic_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load ZoneMusic vob");
	}

	ZoneMusic(String path, GameVersion version) {
		super(ZenKit.API.ZkZoneMusic_loadPath(path, version), ZenKit.API::ZkZoneMusic_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load ZoneMusic vob");
	}

	ZoneMusic(Pointer handle) {
		super(handle, ZenKit.API::ZkZoneMusic_del);
	}

	public boolean isEnabled() {
		return ZenKit.API.ZkZoneMusic_getIsEnabled(getNativeHandle());
	}

	public void setEnabled(boolean val) {
		ZenKit.API.ZkZoneMusic_setIsEnabled(getNativeHandle(), val);
	}

	public int getPriority() {
		return ZenKit.API.ZkZoneMusic_getPriority(getNativeHandle());
	}

	public void setPriority(int val) {
		ZenKit.API.ZkZoneMusic_setPriority(getNativeHandle(), val);
	}

	public boolean isEllipsoid() {
		return ZenKit.API.ZkZoneMusic_getIsEllipsoid(getNativeHandle());
	}

	public void setEllipsoid(boolean val) {
		ZenKit.API.ZkZoneMusic_setIsEllipsoid(getNativeHandle(), val);
	}

	public float getReverb() {
		return ZenKit.API.ZkZoneMusic_getReverb(getNativeHandle());
	}

	public void setReverb(float val) {
		ZenKit.API.ZkZoneMusic_setReverb(getNativeHandle(), val);
	}

	public float getVolume() {
		return ZenKit.API.ZkZoneMusic_getVolume(getNativeHandle());
	}

	public void setVolume(float val) {
		ZenKit.API.ZkZoneMusic_setVolume(getNativeHandle(), val);
	}

	public boolean isLoop() {
		return ZenKit.API.ZkZoneMusic_getIsLoop(getNativeHandle());
	}

	public void setLoop(boolean val) {
		ZenKit.API.ZkZoneMusic_setIsLoop(getNativeHandle(), val);
	}

	public boolean getLocalEnabled() {
		return ZenKit.API.ZkZoneMusic_getLocalEnabled(getNativeHandle());
	}

	public void setLocalEnabled(boolean val) {
		ZenKit.API.ZkZoneMusic_setLocalEnabled(getNativeHandle(), val);
	}

	public boolean getDayEntranceDone() {
		return ZenKit.API.ZkZoneMusic_getDayEntranceDone(getNativeHandle());
	}

	public void setDayEntranceDone(boolean val) {
		ZenKit.API.ZkZoneMusic_setDayEntranceDone(getNativeHandle(), val);
	}

	public boolean getNightEntranceDone() {
		return ZenKit.API.ZkZoneMusic_getNightEntranceDone(getNativeHandle());
	}

	public void setNightEntranceDone(boolean val) {
		ZenKit.API.ZkZoneMusic_setNightEntranceDone(getNativeHandle(), val);
	}
}
