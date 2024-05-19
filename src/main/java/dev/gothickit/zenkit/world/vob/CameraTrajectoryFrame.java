package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.Mat4x4;
import dev.gothickit.zenkit.capi.ZenKit;

public final class CameraTrajectoryFrame extends VirtualObject {
	public CameraTrajectoryFrame() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCCamTrj_KeyFrame));
	}

	CameraTrajectoryFrame(Pointer handle) {
		super(handle, ZenKit.API::ZkCameraTrajectoryFrame_del);
	}

	public float getTime() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getTime(getNativeHandle());
	}

	public void setTime(float val) {
		ZenKit.API.ZkCameraTrajectoryFrame_setTime(getNativeHandle(), val);
	}

	public float getRollAngle() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getRollAngle(getNativeHandle());
	}

	public void setRollAngle(float val) {
		ZenKit.API.ZkCameraTrajectoryFrame_setRollAngle(getNativeHandle(), val);
	}

	public float getFovScale() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getFovScale(getNativeHandle());
	}

	public void setFovScale(float val) {
		ZenKit.API.ZkCameraTrajectoryFrame_setFovScale(getNativeHandle(), val);
	}

	public CameraMotion getMotionType() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getMotionType(getNativeHandle());
	}

	public void setMotionType(CameraMotion val) {
		ZenKit.API.ZkCameraTrajectoryFrame_setMotionType(getNativeHandle(), val);
	}

	public CameraMotion getMotionTypeFov() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getMotionTypeFov(getNativeHandle());
	}

	public void setMotionTypeFov(CameraMotion val) {
		ZenKit.API.ZkCameraTrajectoryFrame_setMotionTypeFov(getNativeHandle(), val);
	}

	public CameraMotion getMotionTypeRoll() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getMotionTypeRoll(getNativeHandle());
	}

	public void setMotionTypeRoll(CameraMotion val) {
		ZenKit.API.ZkCameraTrajectoryFrame_setMotionTypeRoll(getNativeHandle(), val);
	}

	public CameraMotion getMotionTypeTimeScale() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getMotionTypeTimeScale(getNativeHandle());
	}

	public void setMotionTypeTimeScale(CameraMotion val) {
		ZenKit.API.ZkCameraTrajectoryFrame_setMotionTypeTimeScale(getNativeHandle(), val);
	}

	public float getTension() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getTension(getNativeHandle());
	}

	public void setTension(float val) {
		ZenKit.API.ZkCameraTrajectoryFrame_setTension(getNativeHandle(), val);
	}

	public float getCamBias() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getCamBias(getNativeHandle());
	}

	public void setCamBias(float val) {
		ZenKit.API.ZkCameraTrajectoryFrame_setCamBias(getNativeHandle(), val);
	}

	public float getContinuity() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getContinuity(getNativeHandle());
	}

	public void setContinuity(float val) {
		ZenKit.API.ZkCameraTrajectoryFrame_setContinuity(getNativeHandle(), val);
	}

	public float getTimeScale() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getTimeScale(getNativeHandle());
	}

	public void setTimeScale(float val) {
		ZenKit.API.ZkCameraTrajectoryFrame_setTimeScale(getNativeHandle(), val);
	}

	public boolean isTimeFixed() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getTimeFixed(getNativeHandle());
	}

	public void setTimeFixed(boolean val) {
		ZenKit.API.ZkCameraTrajectoryFrame_setTimeFixed(getNativeHandle(), val);
	}

	public Mat4x4 getOriginalPose() {
		return ZenKit.API.ZkCameraTrajectoryFrame_getOriginalPose(getNativeHandle());
	}

	public void setOriginalPose(Mat4x4 val) {
		ZenKit.API.ZkCameraTrajectoryFrame_setOriginalPose(getNativeHandle(), new Mat4x4.ByValue(val));
	}
}
