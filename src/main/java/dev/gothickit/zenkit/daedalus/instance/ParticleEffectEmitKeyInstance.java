package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public class ParticleEffectEmitKeyInstance extends DaedalusInstance {
	public ParticleEffectEmitKeyInstance(Pointer handle) {
		super(handle);
	}

	public String getVisNameS() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getVisNameS(getHandle());
	}

	public float getVisSizeScale() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getVisSizeScale(getHandle());
	}

	public float getScaleDuration() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getScaleDuration(getHandle());
	}

	public float getPfxPpsValue() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxPpsValue(getHandle());
	}

	public int getPfxPpsIsSmoothChg() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxPpsIsSmoothChg(getHandle());
	}

	public int getPfxPpsIsLoopingChg() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxPpsIsLoopingChg(getHandle());
	}

	public float getPfxScTime() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxScTime(getHandle());
	}

	public String getPfxFlyGravityS() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxFlyGravityS(getHandle());
	}

	public String getPfxShpDimS() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxShpDimS(getHandle());
	}

	public int getPfxShpIsVolumeChg() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxShpIsVolumeChg(getHandle());
	}

	public float getPfxShpScaleFps() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxShpScaleFps(getHandle());
	}

	public float getPfxShpDistribWalksPeed() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxShpDistribWalksPeed(getHandle());
	}

	public String getPfxShpOffsetVecS() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxShpOffsetVecS(getHandle());
	}

	public String getPfxShpDistribTypeS() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxShpDistribTypeS(getHandle());
	}

	public String getPfxDirModeS() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxDirModeS(getHandle());
	}

	public String getPfxDirForS() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxDirForS(getHandle());
	}

	public String getPfxDirModeTargetForS() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxDirModeTargetForS(getHandle());
	}

	public String getPfxDirModeTargetPosS() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxDirModeTargetPosS(getHandle());
	}

	public float getPfxVelAvg() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxVelAvg(getHandle());
	}

	public float getPfxLspPartAvg() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxLspPartAvg(getHandle());
	}

	public float getPfxVisAlphaStart() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getPfxVisAlphaStart(getHandle());
	}

	public String getLightPresetName() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getLightPresetName(getHandle());
	}

	public float getLightRange() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getLightRange(getHandle());
	}

	public String getSfxId() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getSfxId(getHandle());
	}

	public int getSfxIsAmbient() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getSfxIsAmbient(getHandle());
	}

	public String getEmCreateFxId() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getEmCreateFxId(getHandle());
	}

	public float getEmFlyGravity() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getEmFlyGravity(getHandle());
	}

	public String getEmSelfRotVelS() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getEmSelfRotVelS(getHandle());
	}

	public String getEmTrjModeS() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getEmTrjModeS(getHandle());
	}

	public float getEmTrjEaseVel() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getEmTrjEaseVel(getHandle());
	}

	public int getEmCheckCollision() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getEmCheckCollision(getHandle());
	}

	public float getEmFxLifespan() {
		return ZenKit.API.ZkParticleEffectEmitKeyInstance_getEmFxLifespan(getHandle());
	}
}
