package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public final class CameraInstance extends DaedalusInstance {
	public CameraInstance(Pointer handle) {
		super(handle);
	}

	public float getBestRange() {
		return ZenKit.API.ZkCameraInstance_getBestRange(getNativeHandle());
	}

	public float getMinRange() {
		return ZenKit.API.ZkCameraInstance_getMinRange(getNativeHandle());
	}

	public float getMaxRange() {
		return ZenKit.API.ZkCameraInstance_getMaxRange(getNativeHandle());
	}

	public float getBestElevation() {
		return ZenKit.API.ZkCameraInstance_getBestElevation(getNativeHandle());
	}

	public float getMinElevation() {
		return ZenKit.API.ZkCameraInstance_getMinElevation(getNativeHandle());
	}

	public float getMaxElevation() {
		return ZenKit.API.ZkCameraInstance_getMaxElevation(getNativeHandle());
	}

	public float getBestAzimuth() {
		return ZenKit.API.ZkCameraInstance_getBestAzimuth(getNativeHandle());
	}

	public float getMinAzimuth() {
		return ZenKit.API.ZkCameraInstance_getMinAzimuth(getNativeHandle());
	}

	public float getMaxAzimuth() {
		return ZenKit.API.ZkCameraInstance_getMaxAzimuth(getNativeHandle());
	}

	public float getBestRotZ() {
		return ZenKit.API.ZkCameraInstance_getBestRotZ(getNativeHandle());
	}

	public float getMinRotZ() {
		return ZenKit.API.ZkCameraInstance_getMinRotZ(getNativeHandle());
	}

	public float getMaxRotZ() {
		return ZenKit.API.ZkCameraInstance_getMaxRotZ(getNativeHandle());
	}

	public float getRotOffsetX() {
		return ZenKit.API.ZkCameraInstance_getRotOffsetX(getNativeHandle());
	}

	public float getRotOffsetY() {
		return ZenKit.API.ZkCameraInstance_getRotOffsetY(getNativeHandle());
	}

	public float getRotOffsetZ() {
		return ZenKit.API.ZkCameraInstance_getRotOffsetZ(getNativeHandle());
	}

	public float getTargetOffsetX() {
		return ZenKit.API.ZkCameraInstance_getTargetOffsetX(getNativeHandle());
	}

	public float getTargetOffsetY() {
		return ZenKit.API.ZkCameraInstance_getTargetOffsetY(getNativeHandle());
	}

	public float getTargetOffsetZ() {
		return ZenKit.API.ZkCameraInstance_getTargetOffsetZ(getNativeHandle());
	}

	public float getVeloTrans() {
		return ZenKit.API.ZkCameraInstance_getVeloTrans(getNativeHandle());
	}

	public float getVeloRot() {
		return ZenKit.API.ZkCameraInstance_getVeloRot(getNativeHandle());
	}

	public int getTranslate() {
		return ZenKit.API.ZkCameraInstance_getTranslate(getNativeHandle());
	}

	public int getRotate() {
		return ZenKit.API.ZkCameraInstance_getRotate(getNativeHandle());
	}

	public int getCollision() {
		return ZenKit.API.ZkCameraInstance_getCollision(getNativeHandle());
	}
}
