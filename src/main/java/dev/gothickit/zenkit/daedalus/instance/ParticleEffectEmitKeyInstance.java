package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public final class ParticleEffectEmitKeyInstance extends DaedalusInstance {
	public ParticleEffectEmitKeyInstance(Pointer handle) {
		super(handle);
	}

	public String getVisNameS() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getVisNameS(getNativeHandle());
	}

	public float getVisSizeScale() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getVisSizeScale(getNativeHandle());
	}

	public float getScaleDuration() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getScaleDuration(getNativeHandle());
	}

	public float getPfxPpsValue() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxPpsValue(getNativeHandle());
	}

	public int getPfxPpsIsSmoothChg() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxPpsIsSmoothChg(getNativeHandle());
	}

	public int getPfxPpsIsLoopingChg() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxPpsIsLoopingChg(getNativeHandle());
	}

	public float getPfxScTime() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxScTime(getNativeHandle());
	}

	public String getPfxFlyGravityS() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxFlyGravityS(getNativeHandle());
	}

	public String getPfxShpDimS() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxShpDimS(getNativeHandle());
	}

	public int getPfxShpIsVolumeChg() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxShpIsVolumeChg(getNativeHandle());
	}

	public float getPfxShpScaleFps() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxShpScaleFps(getNativeHandle());
	}

	public float getPfxShpDistribWalksPeed() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxShpDistribWalksPeed(getNativeHandle());
	}

	public String getPfxShpOffsetVecS() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxShpOffsetVecS(getNativeHandle());
	}

	public String getPfxShpDistribTypeS() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxShpDistribTypeS(getNativeHandle());
	}

	public String getPfxDirModeS() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxDirModeS(getNativeHandle());
	}

	public String getPfxDirForS() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxDirForS(getNativeHandle());
	}

	public String getPfxDirModeTargetForS() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxDirModeTargetForS(getNativeHandle());
	}

	public String getPfxDirModeTargetPosS() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxDirModeTargetPosS(getNativeHandle());
	}

	public float getPfxVelAvg() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxVelAvg(getNativeHandle());
	}

	public float getPfxLspPartAvg() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxLspPartAvg(getNativeHandle());
	}

	public float getPfxVisAlphaStart() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxVisAlphaStart(getNativeHandle());
	}

	public String getLightPresetName() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getLightPresetName(getNativeHandle());
	}

	public float getLightRange() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getLightRange(getNativeHandle());
	}

	public String getSfxId() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getSfxId(getNativeHandle());
	}

	public int getSfxIsAmbient() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getSfxIsAmbient(getNativeHandle());
	}

	public String getEmCreateFxId() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getEmCreateFxId(getNativeHandle());
	}

	public float getEmFlyGravity() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getEmFlyGravity(getNativeHandle());
	}

	public String getEmSelfRotVelS() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getEmSelfRotVelS(getNativeHandle());
	}

	public String getEmTrjModeS() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getEmTrjModeS(getNativeHandle());
	}

	public float getEmTrjEaseVel() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getEmTrjEaseVel(getNativeHandle());
	}

	public int getEmCheckCollision() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getEmCheckCollision(getNativeHandle());
	}

	public float getEmFxLifespan() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getEmFxLifespan(getNativeHandle());
	}
}
