package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public final class CutsceneCamera extends VirtualObject {
	public CutsceneCamera() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCCSCamera));
	}

	CutsceneCamera(@NotNull NativeRead buf, GameVersion version) {
		this(ZenKit.API.ZkCutsceneCamera_load(buf.getNativeHandle(), version));
	}

	CutsceneCamera(String path, GameVersion version) {
		this(ZenKit.API.ZkCutsceneCamera_loadPath(path, version));
	}

	CutsceneCamera(Pointer handle) {
		super(handle, ZenKit.API::ZkCutsceneCamera_del);
	}

	public CameraTrajectory getTrajectoryFOR() {
		return ZenKit.API.ZkCutsceneCamera_getTrajectoryFOR(getNativeHandle());
	}

	public void setTrajectoryFOR(CameraTrajectory val) {
		ZenKit.API.ZkCutsceneCamera_setTrajectoryFOR(getNativeHandle(), val);
	}

	public CameraTrajectory getTargetTrajectoryFOR() {
		return ZenKit.API.ZkCutsceneCamera_getTargetTrajectoryFOR(getNativeHandle());
	}

	public void setTargetTrajectoryFOR(CameraTrajectory val) {
		ZenKit.API.ZkCutsceneCamera_setTargetTrajectoryFOR(getNativeHandle(), val);
	}

	public CameraLoopType getLoopMode() {
		return ZenKit.API.ZkCutsceneCamera_getLoopMode(getNativeHandle());
	}

	public void setLoopMode(CameraLoopType val) {
		ZenKit.API.ZkCutsceneCamera_setLoopMode(getNativeHandle(), val);
	}

	public CameraLerpType getLerpMode() {
		return ZenKit.API.ZkCutsceneCamera_getLerpMode(getNativeHandle());
	}

	public void setLerpMode(CameraLerpType val) {
		ZenKit.API.ZkCutsceneCamera_setLerpMode(getNativeHandle(), val);
	}

	public boolean getIgnoreFORVobRotation() {
		return ZenKit.API.ZkCutsceneCamera_getIgnoreFORVobRotation(getNativeHandle());
	}

	public void setIgnoreFORVobRotation(boolean val) {
		ZenKit.API.ZkCutsceneCamera_setIgnoreFORVobRotation(getNativeHandle(), val);
	}

	public boolean getIgnoreFORVobRotationTarget() {
		return ZenKit.API.ZkCutsceneCamera_getIgnoreFORVobRotationTarget(getNativeHandle());
	}

	public void setIgnoreFORVobRotationTarget(boolean val) {
		ZenKit.API.ZkCutsceneCamera_setIgnoreFORVobRotationTarget(getNativeHandle(), val);
	}

	public boolean getAdapt() {
		return ZenKit.API.ZkCutsceneCamera_getAdapt(getNativeHandle());
	}

	public void setAdapt(boolean val) {
		ZenKit.API.ZkCutsceneCamera_setAdapt(getNativeHandle(), val);
	}

	public boolean getEaseFirst() {
		return ZenKit.API.ZkCutsceneCamera_getEaseFirst(getNativeHandle());
	}

	public void setEaseFirst(boolean val) {
		ZenKit.API.ZkCutsceneCamera_setEaseFirst(getNativeHandle(), val);
	}

	public boolean getEaseLast() {
		return ZenKit.API.ZkCutsceneCamera_getEaseLast(getNativeHandle());
	}

	public void setEaseLast(boolean val) {
		ZenKit.API.ZkCutsceneCamera_setEaseLast(getNativeHandle(), val);
	}

	public float getTotalDuration() {
		return ZenKit.API.ZkCutsceneCamera_getTotalDuration(getNativeHandle());
	}

	public void setTotalDuration(float val) {
		ZenKit.API.ZkCutsceneCamera_setTotalDuration(getNativeHandle(), val);
	}

	public String getAutoFocusVob() {
		return ZenKit.API.ZkCutsceneCamera_getAutoFocusVob(getNativeHandle());
	}

	public void setAutoFocusVob(String val) {
		ZenKit.API.ZkCutsceneCamera_setAutoFocusVob(getNativeHandle(), val);
	}

	public boolean getAutoPlayerMovable() {
		return ZenKit.API.ZkCutsceneCamera_getAutoPlayerMovable(getNativeHandle());
	}

	public void setAutoPlayerMovable(boolean val) {
		ZenKit.API.ZkCutsceneCamera_setAutoPlayerMovable(getNativeHandle(), val);
	}

	public boolean getAutoUntriggerLast() {
		return ZenKit.API.ZkCutsceneCamera_getAutoUntriggerLast(getNativeHandle());
	}

	public void setAutoUntriggerLast(boolean val) {
		ZenKit.API.ZkCutsceneCamera_setAutoUntriggerLast(getNativeHandle(), val);
	}

	public float getAutoUntriggerLastDelay() {
		return ZenKit.API.ZkCutsceneCamera_getAutoUntriggerLastDelay(getNativeHandle());
	}

	public void setAutoUntriggerLastDelay(float val) {
		ZenKit.API.ZkCutsceneCamera_setAutoUntriggerLastDelay(getNativeHandle(), val);
	}

	public int getPositionCount() {
		return ZenKit.API.ZkCutsceneCamera_getPositionCount(getNativeHandle());
	}

	public int getTargetCount() {
		return ZenKit.API.ZkCutsceneCamera_getTargetCount(getNativeHandle());
	}

	public long getFrameCount() {
		return ZenKit.API.ZkCutsceneCamera_getFrameCount(getNativeHandle());
	}

	public boolean getIsPaused() {
		return ZenKit.API.ZkCutsceneCamera_getIsPaused(getNativeHandle());
	}

	public void setIsPaused(boolean isPaused) {
		ZenKit.API.ZkCutsceneCamera_setIsPaused(getNativeHandle(), isPaused);
	}

	public boolean getIsStarted() {
		return ZenKit.API.ZkCutsceneCamera_getIsStarted(getNativeHandle());
	}

	public void setIsStarted(boolean isStarted) {
		ZenKit.API.ZkCutsceneCamera_setIsStarted(getNativeHandle(), isStarted);
	}

	public boolean getGotoTimeMode() {
		return ZenKit.API.ZkCutsceneCamera_getGotoTimeMode(getNativeHandle());
	}

	public void setGotoTimeMode(boolean gotoTimeMode) {
		ZenKit.API.ZkCutsceneCamera_setGotoTimeMode(getNativeHandle(), gotoTimeMode);
	}

	public float getTime() {
		return ZenKit.API.ZkCutsceneCamera_getTime(getNativeHandle());
	}

	public void setTime(float time) {
		ZenKit.API.ZkCutsceneCamera_setTime(getNativeHandle(), time);
	}

	public CameraTrajectoryFrame getFrame(long i) {
		var ptr = ZenKit.API.ZkCutsceneCamera_getFrame(getNativeHandle(), i);
		return new CameraTrajectoryFrame(ZenKit.API.ZkObject_takeRef(ptr));
	}

	public List<CameraTrajectoryFrame> getFrames() {
		var frames = new ArrayList<CameraTrajectoryFrame>();

		ZenKit.API.ZkCutsceneCamera_enumerateFrames(getNativeHandle(), (ctx, frame) -> {
			frames.add(new CameraTrajectoryFrame(ZenKit.API.ZkObject_takeRef(frame)));
			return false;
		}, Pointer.NULL);

		return frames;
	}
}
