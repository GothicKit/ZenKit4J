package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public class CameraInstance extends DaedalusInstance {
	public CameraInstance(Pointer handle) {
		super(handle);
	}

	public float getBestRange() {
		return ZenKit.API.ZkCameraInstance_getBestRange(getHandle());
	}

	public float getMinRange() {
		return ZenKit.API.ZkCameraInstance_getMinRange(getHandle());
	}

	public float getMaxRange() {
		return ZenKit.API.ZkCameraInstance_getMaxRange(getHandle());
	}

	public float getBestElevation() {
		return ZenKit.API.ZkCameraInstance_getBestElevation(getHandle());
	}

	public float getMinElevation() {
		return ZenKit.API.ZkCameraInstance_getMinElevation(getHandle());
	}

	public float getMaxElevation() {
		return ZenKit.API.ZkCameraInstance_getMaxElevation(getHandle());
	}

	public float getBestAzimuth() {
		return ZenKit.API.ZkCameraInstance_getBestAzimuth(getHandle());
	}

	public float getMinAzimuth() {
		return ZenKit.API.ZkCameraInstance_getMinAzimuth(getHandle());
	}

	public float getMaxAzimuth() {
		return ZenKit.API.ZkCameraInstance_getMaxAzimuth(getHandle());
	}

	public float getBestRotZ() {
		return ZenKit.API.ZkCameraInstance_getBestRotZ(getHandle());
	}

	public float getMinRotZ() {
		return ZenKit.API.ZkCameraInstance_getMinRotZ(getHandle());
	}

	public float getMaxRotZ() {
		return ZenKit.API.ZkCameraInstance_getMaxRotZ(getHandle());
	}

	public float getRotOffsetX() {
		return ZenKit.API.ZkCameraInstance_getRotOffsetX(getHandle());
	}

	public float getRotOffsetY() {
		return ZenKit.API.ZkCameraInstance_getRotOffsetY(getHandle());
	}

	public float getRotOffsetZ() {
		return ZenKit.API.ZkCameraInstance_getRotOffsetZ(getHandle());
	}

	public float getTargetOffsetX() {
		return ZenKit.API.ZkCameraInstance_getTargetOffsetX(getHandle());
	}

	public float getTargetOffsetY() {
		return ZenKit.API.ZkCameraInstance_getTargetOffsetY(getHandle());
	}

	public float getTargetOffsetZ() {
		return ZenKit.API.ZkCameraInstance_getTargetOffsetZ(getHandle());
	}

	public float getVeloTrans() {
		return ZenKit.API.ZkCameraInstance_getVeloTrans(getHandle());
	}

	public float getVeloRot() {
		return ZenKit.API.ZkCameraInstance_getVeloRot(getHandle());
	}

	public int getTranslate() {
		return ZenKit.API.ZkCameraInstance_getTranslate(getHandle());
	}

	public int getRotate() {
		return ZenKit.API.ZkCameraInstance_getRotate(getHandle());
	}

	public int getCollision() {
		return ZenKit.API.ZkCameraInstance_getCollision(getHandle());
	}
}
