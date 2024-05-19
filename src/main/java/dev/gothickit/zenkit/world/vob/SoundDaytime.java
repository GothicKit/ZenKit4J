package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public final class SoundDaytime extends Sound {
	public SoundDaytime() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCVobSoundDaytime));
	}

	SoundDaytime(@NotNull NativeRead buf, GameVersion version) {
		super(ZenKit.API.ZkSoundDaytime_load(buf.getNativeHandle(), version), ZenKit.API::ZkSoundDaytime_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load SoundDaytime vob");
	}

	SoundDaytime(String path, GameVersion version) {
		super(ZenKit.API.ZkSoundDaytime_loadPath(path, version), ZenKit.API::ZkSoundDaytime_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load SoundDaytime vob");
	}

	SoundDaytime(Pointer handle) {
		super(handle, ZenKit.API::ZkSoundDaytime_del);
	}

	public float getStartTime() {
		return ZenKit.API.ZkSoundDaytime_getStartTime(getNativeHandle());
	}

	public void setStartTime(float val) {
		ZenKit.API.ZkSoundDaytime_setStartTime(getNativeHandle(), val);
	}

	public float getEndTime() {
		return ZenKit.API.ZkSoundDaytime_getEndTime(getNativeHandle());
	}

	public void setEndTime(float val) {
		ZenKit.API.ZkSoundDaytime_setEndTime(getNativeHandle(), val);
	}

	public String getSoundNameDaytime() {
		return ZenKit.API.ZkSoundDaytime_getSoundNameDaytime(getNativeHandle());
	}

	public void setSoundNameDaytime(String val) {
		ZenKit.API.ZkSoundDaytime_setSoundNameDaytime(getNativeHandle(), val);
	}
}
