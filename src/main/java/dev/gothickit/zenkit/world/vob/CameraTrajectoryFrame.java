package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.Mat4x4;
import dev.gothickit.zenkit.capi.ZenKit;

public class CameraTrajectoryFrame extends VirtualObject {
	public CameraTrajectoryFrame() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCCamTrj_KeyFrame));
	}

	protected CameraTrajectoryFrame(Pointer handle) {
		super(handle, ZenKit.API::ZkCameraTrajectoryFrame_del);
	}

	public float getTime() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getTime(getHandle());
	}

	public void setTime(float val) {
		ZenKit.API.ZkCameraTrajectoryFrame_setTime(getHandle(), val);
	}

	public float getRollAngle() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getRollAngle(getHandle());
	}

	public void setRollAngle(float val) {
		ZenKit.API.ZkCameraTrajectoryFrame_setRollAngle(getHandle(), val);
	}

	public float getFovScale() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getFovScale(getHandle());
	}

	public void setFovScale(float val) {
		ZenKit.API.ZkCameraTrajectoryFrame_setFovScale(getHandle(), val);
	}

	public CameraMotion getMotionType() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getMotionType(getHandle());
	}

	public void setMotionType(CameraMotion val) {
		ZenKit.API.ZkCameraTrajectoryFrame_setMotionType(getHandle(), val);
	}

	public CameraMotion getMotionTypeFov() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getMotionTypeFov(getHandle());
	}

	public void setMotionTypeFov(CameraMotion val) {
		ZenKit.API.ZkCameraTrajectoryFrame_setMotionTypeFov(getHandle(), val);
	}

	public CameraMotion getMotionTypeRoll() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getMotionTypeRoll(getHandle());
	}

	public void setMotionTypeRoll(CameraMotion val) {
		ZenKit.API.ZkCameraTrajectoryFrame_setMotionTypeRoll(getHandle(), val);
	}

	public CameraMotion getMotionTypeTimeScale() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getMotionTypeTimeScale(getHandle());
	}

	public void setMotionTypeTimeScale(CameraMotion val) {
		ZenKit.API.ZkCameraTrajectoryFrame_setMotionTypeTimeScale(getHandle(), val);
	}

	public float getTension() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getTension(getHandle());
	}

	public void setTension(float val) {
		ZenKit.API.ZkCameraTrajectoryFrame_setTension(getHandle(), val);
	}

	public float getCamBias() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getCamBias(getHandle());
	}

	public void setCamBias(float val) {
		ZenKit.API.ZkCameraTrajectoryFrame_setCamBias(getHandle(), val);
	}

	public float getContinuity() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getContinuity(getHandle());
	}

	public void setContinuity(float val) {
		ZenKit.API.ZkCameraTrajectoryFrame_setContinuity(getHandle(), val);
	}

	public float getTimeScale() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getTimeScale(getHandle());
	}

	public void setTimeScale(float val) {
		ZenKit.API.ZkCameraTrajectoryFrame_setTimeScale(getHandle(), val);
	}

	public boolean isTimeFixed() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getTimeFixed(getHandle());
	}

	public void setTimeFixed(boolean val) {
		ZenKit.API.ZkCameraTrajectoryFrame_setTimeFixed(getHandle(), val);
	}

	public Mat4x4 getOriginalPose() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getOriginalPose(getHandle());
	}

	public void setOriginalPose(Mat4x4 val) {
		ZenKit.API.ZkCameraTrajectoryFrame_setOriginalPose(getHandle(), new Mat4x4.ByValue(val));
	}
}
