package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class Sound extends VirtualObject {
	public Sound() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCVobSound));
	}

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
		super(handle, ZenKit.API::ZkSound_del);
	}

	public float getVolume() {
		return ZenKit.API.ZkSound_getVolume(getHandle());
	}

	public void setVolume(float val) {
		ZenKit.API.ZkSound_setVolume(getHandle(), val);
	}

	public SoundMode getMode() {
		return ZenKit.API.ZkSound_getMode(getHandle());
	}

	public void setMode(SoundMode val) {
		ZenKit.API.ZkSound_setMode(getHandle(), val);
	}

	public float getRandomDelay() {
		return ZenKit.API.ZkSound_getRandomDelay(getHandle());
	}

	public void setRandomDelay(float val) {
		ZenKit.API.ZkSound_setRandomDelay(getHandle(), val);
	}

	public float getRandomDelayVar() {
		return ZenKit.API.ZkSound_getRandomDelayVar(getHandle());
	}

	public void setRandomDelayVar(float val) {
		ZenKit.API.ZkSound_setRandomDelayVar(getHandle(), val);
	}

	public boolean getInitiallyPlaying() {
		return ZenKit.API.ZkSound_getInitiallyPlaying(getHandle());
	}

	public void setInitiallyPlaying(boolean val) {
		ZenKit.API.ZkSound_setInitiallyPlaying(getHandle(), val);
	}

	public boolean isAmbient3d() {
		return ZenKit.API.ZkSound_getAmbient3d(getHandle());
	}

	public void setAmbient3d(boolean val) {
		ZenKit.API.ZkSound_setAmbient3d(getHandle(), val);
	}

	public boolean getObstruction() {
		return ZenKit.API.ZkSound_getObstruction(getHandle());
	}

	public void setObstruction(boolean val) {
		ZenKit.API.ZkSound_setObstruction(getHandle(), val);
	}

	public float getConeAngle() {
		return ZenKit.API.ZkSound_getConeAngle(getHandle());
	}

	public void setConeAngle(float val) {
		ZenKit.API.ZkSound_setConeAngle(getHandle(), val);
	}

	public SoundTriggerVolumeType getVolumeType() {
		return ZenKit.API.ZkSound_getVolumeType(getHandle());
	}

	public void setVolumeType(SoundTriggerVolumeType val) {
		ZenKit.API.ZkSound_setVolumeType(getHandle(), val);
	}

	public float getRadius() {
		return ZenKit.API.ZkSound_getRadius(getHandle());
	}

	public void setRadius(float val) {
		ZenKit.API.ZkSound_setRadius(getHandle(), val);
	}

	public String getSoundName() {
		return ZenKit.API.ZkSound_getSoundName(getHandle());
	}

	public void setSoundName(String val) {
		ZenKit.API.ZkSound_setSoundName(getHandle(), val);
	}

	public boolean isRunning() {
		return ZenKit.API.ZkSound_getIsRunning(getHandle());
	}

	public void setRunning(boolean val) {
		ZenKit.API.ZkSound_setIsRunning(getHandle(), val);
	}

	public boolean isAllowedToRun() {
		return ZenKit.API.ZkSound_getIsAllowedToRun(getHandle());
	}

	public void setAllowedToRun(boolean val) {
		ZenKit.API.ZkSound_setIsAllowedToRun(getHandle(), val);
	}
}
