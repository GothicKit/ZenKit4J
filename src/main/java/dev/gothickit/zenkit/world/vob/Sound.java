package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class Sound extends VirtualObject {
	public Sound(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkSound_load(buf.getHandle(), version), ZenKit.API::ZkSound_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Sound vob");
	}

	public Sound(String path, GameVersion version) {
		super(ZenKit.API.ZkSound_loadPath(path, version), ZenKit.API::ZkSound_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Sound vob");
	}

	public Sound(Pointer handle, Consumer<Pointer> delete) {
		super(handle, delete);
	}

	public Sound(Pointer handle) {
		super(handle);
	}

	public float getVolume() {
		return ZenKit.API.ZkSound_getVolume(getHandle());
	}

	public SoundMode getMode() {
		return ZenKit.API.ZkSound_getMode(getHandle());
	}

	public float getRandomDelay() {
		return ZenKit.API.ZkSound_getRandomDelay(getHandle());
	}

	public float getRandomDelayVar() {
		return ZenKit.API.ZkSound_getRandomDelayVar(getHandle());
	}

	public boolean getInitiallyPlaying() {
		return ZenKit.API.ZkSound_getInitiallyPlaying(getHandle());
	}

	public boolean isAmbient3d() {
		return ZenKit.API.ZkSound_getAmbient3d(getHandle());
	}

	public boolean getObstruction() {
		return ZenKit.API.ZkSound_getObstruction(getHandle());
	}

	public float getConeAngle() {
		return ZenKit.API.ZkSound_getConeAngle(getHandle());
	}

	public SoundTriggerVolumeType getVolumeType() {
		return ZenKit.API.ZkSound_getVolumeType(getHandle());
	}

	public float getRadius() {
		return ZenKit.API.ZkSound_getRadius(getHandle());
	}

	public String getSoundName() {
		return ZenKit.API.ZkSound_getSoundName(getHandle());
	}
}
