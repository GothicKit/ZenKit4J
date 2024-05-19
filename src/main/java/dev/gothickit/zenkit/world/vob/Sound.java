package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class Sound extends VirtualObject {
	public Sound() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCVobSound));
	}

	Sound(@NotNull NativeRead buf, GameVersion version) {
		super(ZenKit.API.ZkSound_load(buf.getNativeHandle(), version), ZenKit.API::ZkSound_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Sound vob");
	}

	Sound(String path, GameVersion version) {
		super(ZenKit.API.ZkSound_loadPath(path, version), ZenKit.API::ZkSound_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Sound vob");
	}

	Sound(Pointer handle, Consumer<Pointer> delete) {
		super(handle, delete);
	}

	Sound(Pointer handle) {
		super(handle, ZenKit.API::ZkSound_del);
	}

	public float getVolume() {
		return ZenKit.API.ZkSound_getVolume(getNativeHandle());
	}

	public void setVolume(float val) {
		ZenKit.API.ZkSound_setVolume(getNativeHandle(), val);
	}

	public SoundMode getMode() {
		return ZenKit.API.ZkSound_getMode(getNativeHandle());
	}

	public void setMode(SoundMode val) {
		ZenKit.API.ZkSound_setMode(getNativeHandle(), val);
	}

	public float getRandomDelay() {
		return ZenKit.API.ZkSound_getRandomDelay(getNativeHandle());
	}

	public void setRandomDelay(float val) {
		ZenKit.API.ZkSound_setRandomDelay(getNativeHandle(), val);
	}

	public float getRandomDelayVar() {
		return ZenKit.API.ZkSound_getRandomDelayVar(getNativeHandle());
	}

	public void setRandomDelayVar(float val) {
		ZenKit.API.ZkSound_setRandomDelayVar(getNativeHandle(), val);
	}

	public boolean getInitiallyPlaying() {
		return ZenKit.API.ZkSound_getInitiallyPlaying(getNativeHandle());
	}

	public void setInitiallyPlaying(boolean val) {
		ZenKit.API.ZkSound_setInitiallyPlaying(getNativeHandle(), val);
	}

	public boolean isAmbient3d() {
		return ZenKit.API.ZkSound_getAmbient3d(getNativeHandle());
	}

	public void setAmbient3d(boolean val) {
		ZenKit.API.ZkSound_setAmbient3d(getNativeHandle(), val);
	}

	public boolean getObstruction() {
		return ZenKit.API.ZkSound_getObstruction(getNativeHandle());
	}

	public void setObstruction(boolean val) {
		ZenKit.API.ZkSound_setObstruction(getNativeHandle(), val);
	}

	public float getConeAngle() {
		return ZenKit.API.ZkSound_getConeAngle(getNativeHandle());
	}

	public void setConeAngle(float val) {
		ZenKit.API.ZkSound_setConeAngle(getNativeHandle(), val);
	}

	public SoundTriggerVolumeType getVolumeType() {
		return ZenKit.API.ZkSound_getVolumeType(getNativeHandle());
	}

	public void setVolumeType(SoundTriggerVolumeType val) {
		ZenKit.API.ZkSound_setVolumeType(getNativeHandle(), val);
	}

	public float getRadius() {
		return ZenKit.API.ZkSound_getRadius(getNativeHandle());
	}

	public void setRadius(float val) {
		ZenKit.API.ZkSound_setRadius(getNativeHandle(), val);
	}

	public String getSoundName() {
		return ZenKit.API.ZkSound_getSoundName(getNativeHandle());
	}

	public void setSoundName(String val) {
		ZenKit.API.ZkSound_setSoundName(getNativeHandle(), val);
	}

	public boolean isRunning() {
		return ZenKit.API.ZkSound_getIsRunning(getNativeHandle());
	}

	public void setRunning(boolean val) {
		ZenKit.API.ZkSound_setIsRunning(getNativeHandle(), val);
	}

	public boolean isAllowedToRun() {
		return ZenKit.API.ZkSound_getIsAllowedToRun(getNativeHandle());
	}

	public void setAllowedToRun(boolean val) {
		ZenKit.API.ZkSound_setIsAllowedToRun(getNativeHandle(), val);
	}
}
