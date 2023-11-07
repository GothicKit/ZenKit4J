package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.Mat4x4;
import dev.gothickit.zenkit.capi.ZenKit;

public class CameraTrajectoryFrame extends VirtualObject {
	protected CameraTrajectoryFrame(Pointer handle) {
		super(handle);
	}

	public float getTime() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getTime(getHandle());
	}

	public float getRollAngle() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getRollAngle(getHandle());
	}

	public float getFovScale() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getFovScale(getHandle());
	}

	public CameraMotion getMotionType() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getMotionType(getHandle());
	}

	public CameraMotion getMotionTypeFov() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getMotionTypeFov(getHandle());
	}

	public CameraMotion getMotionTypeRoll() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getMotionTypeRoll(getHandle());
	}

	public CameraMotion getMotionTypeTimeScale() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getMotionTypeTimeScale(getHandle());
	}

	public float getTension() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getTension(getHandle());
	}

	public float getCamBias() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getCamBias(getHandle());
	}

	public float getContinuity() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getContinuity(getHandle());
	}

	public float getTimeScale() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getTimeScale(getHandle());
	}

	public boolean isTimeFixed() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getTimeFixed(getHandle());
	}

	public Mat4x4 getOriginalPose() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getOriginalPose(getHandle());
	}
}
