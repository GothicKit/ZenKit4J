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
	public CutsceneCamera(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkCutsceneCamera_load(buf.getHandle(), version), ZenKit.API::ZkCutsceneCamera_del);
	}

	public CutsceneCamera(String path, GameVersion version) {
		super(ZenKit.API.ZkCutsceneCamera_loadPath(path, version), ZenKit.API::ZkCutsceneCamera_del);
	}

	protected CutsceneCamera(Pointer handle) {
		super(handle);
	}

	protected CutsceneCamera(Pointer handle, Consumer<Pointer> delete) {
		super(handle, delete);
	}

	public CameraTrajectory getTrajectoryFOR() {
		return ZenKit.API.ZkCutsceneCamera_getTrajectoryFOR(getHandle());
	}

	public CameraTrajectory getTargetTrajectoryFOR() {
		return ZenKit.API.ZkCutsceneCamera_getTargetTrajectoryFOR(getHandle());
	}

	public CameraLoopType getLoopMode() {
		return ZenKit.API.ZkCutsceneCamera_getLoopMode(getHandle());
	}

	public CameraLerpType getLerpMode() {
		return ZenKit.API.ZkCutsceneCamera_getLerpMode(getHandle());
	}

	public boolean getIgnoreFORVobRotation() {
		return ZenKit.API.ZkCutsceneCamera_getIgnoreFORVobRotation(getHandle());
	}

	public boolean getIgnoreFORVobRotationTarget() {
		return ZenKit.API.ZkCutsceneCamera_getIgnoreFORVobRotationTarget(getHandle());
	}

	public boolean getAdapt() {
		return ZenKit.API.ZkCutsceneCamera_getAdapt(getHandle());
	}

	public boolean getEaseFirst() {
		return ZenKit.API.ZkCutsceneCamera_getEaseFirst(getHandle());
	}

	public boolean getEaseLast() {
		return ZenKit.API.ZkCutsceneCamera_getEaseLast(getHandle());
	}

	public float getTotalDuration() {
		return ZenKit.API.ZkCutsceneCamera_getTotalDuration(getHandle());
	}

	public String getAutoFocusVob() {
		return ZenKit.API.ZkCutsceneCamera_getAutoFocusVob(getHandle());
	}

	public boolean getAutoPlayerMovable() {
		return ZenKit.API.ZkCutsceneCamera_getAutoPlayerMovable(getHandle());
	}

	public boolean getAutoUntriggerLast() {
		return ZenKit.API.ZkCutsceneCamera_getAutoUntriggerLast(getHandle());
	}

	public float getAutoUntriggerLastDelay() {
		return ZenKit.API.ZkCutsceneCamera_getAutoUntriggerLastDelay(getHandle());
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

	public CameraTrajectoryFrame getFrame(long i) {
		return new CameraTrajectoryFrame(ZenKit.API.ZkCutsceneCamera_getFrame(getHandle(), i));
	}

	public List<CameraTrajectoryFrame> getFrames() {
		var frames = new ArrayList<CameraTrajectoryFrame>();

		ZenKit.API.ZkCutsceneCamera_enumerateFrames(getHandle(), (ctx, frame) -> {
			frames.add(new CameraTrajectoryFrame(frame));
			return false;
		}, Pointer.NULL);

		return frames;
	}
}
