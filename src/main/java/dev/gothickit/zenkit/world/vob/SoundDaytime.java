package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public class SoundDaytime extends Sound {
	public SoundDaytime(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkSoundDaytime_load(buf.getHandle(), version), ZenKit.API::ZkSoundDaytime_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load SoundDaytime vob");
	}

	public SoundDaytime(String path, GameVersion version) {
		super(ZenKit.API.ZkSoundDaytime_loadPath(path, version), ZenKit.API::ZkSoundDaytime_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load SoundDaytime vob");
	}

	public SoundDaytime(Pointer handle) {
		super(handle);
	}

	public float getStartTime() {
		return ZenKit.API.ZkSoundDaytime_getStartTime(getHandle());
	}

	public float getEndTime() {
		return ZenKit.API.ZkSoundDaytime_getEndTime(getHandle());
	}

	public String getSoundNameDaytime() {
		return ZenKit.API.ZkSoundDaytime_getSoundNameDaytime(getHandle());
	}
}
