package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CutsceneCamera extends VirtualObject {
	public CutsceneCamera() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCCSCamera));
	}

	public CutsceneCamera(@NotNull Read buf, GameVersion version) {
		this(ZenKit.API.ZkCutsceneCamera_load(buf.getHandle(), version));
	}

	public CutsceneCamera(String path, GameVersion version) {
		this(ZenKit.API.ZkCutsceneCamera_loadPath(path, version));
	}

	protected CutsceneCamera(Pointer handle) {
		super(handle, ZenKit.API::ZkCutsceneCamera_del);
	}

	protected CutsceneCamera(Pointer handle, Consumer<Pointer> delete) {
		super(handle, delete);
	}

	public CameraTrajectory getTrajectoryFOR() {
		return ZenKit.API.ZkCutsceneCamera_getTrajectoryFOR(getHandle());
	}

	public void setTrajectoryFOR(CameraTrajectory val) {
		ZenKit.API.ZkCutsceneCamera_setTrajectoryFOR(getHandle(), val);
	}

	public CameraTrajectory getTargetTrajectoryFOR() {
		return ZenKit.API.ZkCutsceneCamera_getTargetTrajectoryFOR(getHandle());
	}

	public void setTargetTrajectoryFOR(CameraTrajectory val) {
		ZenKit.API.ZkCutsceneCamera_setTargetTrajectoryFOR(getHandle(), val);
	}

	public CameraLoopType getLoopMode() {
		return ZenKit.API.ZkCutsceneCamera_getLoopMode(getHandle());
	}

	public void setLoopMode(CameraLoopType val) {
		ZenKit.API.ZkCutsceneCamera_setLoopMode(getHandle(), val);
	}

	public CameraLerpType getLerpMode() {
		return ZenKit.API.ZkCutsceneCamera_getLerpMode(getHandle());
	}

	public void setLerpMode(CameraLerpType val) {
		ZenKit.API.ZkCutsceneCamera_setLerpMode(getHandle(), val);
	}

	public boolean getIgnoreFORVobRotation() {
		return ZenKit.API.ZkCutsceneCamera_getIgnoreFORVobRotation(getHandle());
	}

	public void setIgnoreFORVobRotation(boolean val) {
		ZenKit.API.ZkCutsceneCamera_setIgnoreFORVobRotation(getHandle(), val);
	}

	public boolean getIgnoreFORVobRotationTarget() {
		return ZenKit.API.ZkCutsceneCamera_getIgnoreFORVobRotationTarget(getHandle());
	}

	public void setIgnoreFORVobRotationTarget(boolean val) {
		ZenKit.API.ZkCutsceneCamera_setIgnoreFORVobRotationTarget(getHandle(), val);
	}

	public boolean getAdapt() {
		return ZenKit.API.ZkCutsceneCamera_getAdapt(getHandle());
	}

	public void setAdapt(boolean val) {
		ZenKit.API.ZkCutsceneCamera_setAdapt(getHandle(), val);
	}

	public boolean getEaseFirst() {
		return ZenKit.API.ZkCutsceneCamera_getEaseFirst(getHandle());
	}

	public void setEaseFirst(boolean val) {
		ZenKit.API.ZkCutsceneCamera_setEaseFirst(getHandle(), val);
	}

	public boolean getEaseLast() {
		return ZenKit.API.ZkCutsceneCamera_getEaseLast(getHandle());
	}

	public void setEaseLast(boolean val) {
		ZenKit.API.ZkCutsceneCamera_setEaseLast(getHandle(), val);
	}

	public float getTotalDuration() {
		return ZenKit.API.ZkCutsceneCamera_getTotalDuration(getHandle());
	}

	public void setTotalDuration(float val) {
		ZenKit.API.ZkCutsceneCamera_setTotalDuration(getHandle(), val);
	}

	public String getAutoFocusVob() {
		return ZenKit.API.ZkCutsceneCamera_getAutoFocusVob(getHandle());
	}

	public void setAutoFocusVob(String val) {
		ZenKit.API.ZkCutsceneCamera_setAutoFocusVob(getHandle(), val);
	}

	public boolean getAutoPlayerMovable() {
		return ZenKit.API.ZkCutsceneCamera_getAutoPlayerMovable(getHandle());
	}

	public void setAutoPlayerMovable(boolean val) {
		ZenKit.API.ZkCutsceneCamera_setAutoPlayerMovable(getHandle(), val);
	}

	public boolean getAutoUntriggerLast() {
		return ZenKit.API.ZkCutsceneCamera_getAutoUntriggerLast(getHandle());
	}

	public void setAutoUntriggerLast(boolean val) {
		ZenKit.API.ZkCutsceneCamera_setAutoUntriggerLast(getHandle(), val);
	}

	public float getAutoUntriggerLastDelay() {
		return ZenKit.API.ZkCutsceneCamera_getAutoUntriggerLastDelay(getHandle());
	}

	public void setAutoUntriggerLastDelay(float val) {
		ZenKit.API.ZkCutsceneCamera_setAutoUntriggerLastDelay(getHandle(), val);
	}

	public int getPositionCount() {
		return ZenKit.API.ZkCutsceneCamera_getPositionCount(getHandle());
	}

	public int getTargetCount() {
		return ZenKit.API.ZkCutsceneCamera_getTargetCount(getHandle());
	}

	public long getFrameCount() {
		return ZenKit.API.ZkCutsceneCamera_getFrameCount(getHandle());
	}

	public boolean getIsPaused() {
		return ZenKit.API.ZkCutsceneCamera_getIsPaused(getHandle());
	}

	public void setIsPaused(boolean isPaused) {
		ZenKit.API.ZkCutsceneCamera_setIsPaused(getHandle(), isPaused);
	}

	public boolean getIsStarted() {
		return ZenKit.API.ZkCutsceneCamera_getIsStarted(getHandle());
	}

	public void setIsStarted(boolean isStarted) {
		ZenKit.API.ZkCutsceneCamera_setIsStarted(getHandle(), isStarted);
	}

	public boolean getGotoTimeMode() {
		return ZenKit.API.ZkCutsceneCamera_getGotoTimeMode(getHandle());
	}

	public void setGotoTimeMode(boolean gotoTimeMode) {
		ZenKit.API.ZkCutsceneCamera_setGotoTimeMode(getHandle(), gotoTimeMode);
	}

	public float getTime() {
		return ZenKit.API.ZkCutsceneCamera_getTime(getHandle());
	}

	public void setTime(float time) {
		ZenKit.API.ZkCutsceneCamera_setTime(getHandle(), time);
	}

	public CameraTrajectoryFrame getFrame(long i) {
		var ptr = ZenKit.API.ZkCutsceneCamera_getFrame(getHandle(), i);
		return new CameraTrajectoryFrame(ZenKit.API.ZkObject_takeRef(ptr));
	}

	public List<CameraTrajectoryFrame> getFrames() {
		var frames = new ArrayList<CameraTrajectoryFrame>();

		ZenKit.API.ZkCutsceneCamera_enumerateFrames(getHandle(), (ctx, frame) -> {
			frames.add(new CameraTrajectoryFrame(ZenKit.API.ZkObject_takeRef(frame)));
			return false;
		}, Pointer.NULL);

		return frames;
	}
}
