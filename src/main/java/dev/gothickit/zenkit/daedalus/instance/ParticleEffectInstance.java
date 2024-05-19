package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public final class ParticleEffectInstance extends DaedalusInstance {
	public ParticleEffectInstance(Pointer handle) {
		super(handle);
	}

	public float getPpsValue() {
		return ZenKit.API.ZkParticleEffectInstance_getPpsValue(getNativeHandle());
	}

	public String getPpsScaleKeysS() {
		return ZenKit.API.ZkParticleEffectInstance_getPpsScaleKeysS(getNativeHandle());
	}

	public int getPpsIsLooping() {
		return ZenKit.API.ZkParticleEffectInstance_getPpsIsLooping(getNativeHandle());
	}

	public int getPpsIsSmooth() {
		return ZenKit.API.ZkParticleEffectInstance_getPpsIsSmooth(getNativeHandle());
	}

	public float getPpsFps() {
		return ZenKit.API.ZkParticleEffectInstance_getPpsFps(getNativeHandle());
	}

	public String getPpsCreateEmS() {
		return ZenKit.API.ZkParticleEffectInstance_getPpsCreateEmS(getNativeHandle());
	}

	public float getPpsCreateEmDelay() {
		return ZenKit.API.ZkParticleEffectInstance_getPpsCreateEmDelay(getNativeHandle());
	}

	public String getShpTypeS() {
		return ZenKit.API.ZkParticleEffectInstance_getShpTypeS(getNativeHandle());
	}

	public String getShpForS() {
		return ZenKit.API.ZkParticleEffectInstance_getShpForS(getNativeHandle());
	}

	public String getShpOffsetVecS() {
		return ZenKit.API.ZkParticleEffectInstance_getShpOffsetVecS(getNativeHandle());
	}

	public String getShpDistribTypeS() {
		return ZenKit.API.ZkParticleEffectInstance_getShpDistribTypeS(getNativeHandle());
	}

	public float getShpDistribWalkSpeed() {
		return ZenKit.API.ZkParticleEffectInstance_getShpDistribWalkSpeed(getNativeHandle());
	}

	public int getShpIsVolume() {
		return ZenKit.API.ZkParticleEffectInstance_getShpIsVolume(getNativeHandle());
	}

	public String getShpDimS() {
		return ZenKit.API.ZkParticleEffectInstance_getShpDimS(getNativeHandle());
	}

	public String getShpMeshS() {
		return ZenKit.API.ZkParticleEffectInstance_getShpMeshS(getNativeHandle());
	}

	public int getShpMeshRenderB() {
		return ZenKit.API.ZkParticleEffectInstance_getShpMeshRenderB(getNativeHandle());
	}

	public String getShpScaleKeysS() {
		return ZenKit.API.ZkParticleEffectInstance_getShpScaleKeysS(getNativeHandle());
	}

	public int getShpScaleIsLooping() {
		return ZenKit.API.ZkParticleEffectInstance_getShpScaleIsLooping(getNativeHandle());
	}

	public int getShpScaleIsSmooth() {
		return ZenKit.API.ZkParticleEffectInstance_getShpScaleIsSmooth(getNativeHandle());
	}

	public float getShpScaleFps() {
		return ZenKit.API.ZkParticleEffectInstance_getShpScaleFps(getNativeHandle());
	}

	public String getDirModeS() {
		return ZenKit.API.ZkParticleEffectInstance_getDirModeS(getNativeHandle());
	}

	public String getDirForS() {
		return ZenKit.API.ZkParticleEffectInstance_getDirForS(getNativeHandle());
	}

	public String getDirModeTargetForS() {
		return ZenKit.API.ZkParticleEffectInstance_getDirModeTargetForS(getNativeHandle());
	}

	public String getDirModeTargetPosS() {
		return ZenKit.API.ZkParticleEffectInstance_getDirModeTargetPosS(getNativeHandle());
	}

	public float getDirAngleHead() {
		return ZenKit.API.ZkParticleEffectInstance_getDirAngleHead(getNativeHandle());
	}

	public float getDirAngleHeadVar() {
		return ZenKit.API.ZkParticleEffectInstance_getDirAngleHeadVar(getNativeHandle());
	}

	public float getDirAngleElev() {
		return ZenKit.API.ZkParticleEffectInstance_getDirAngleElev(getNativeHandle());
	}

	public float getDirAngleElevVar() {
		return ZenKit.API.ZkParticleEffectInstance_getDirAngleElevVar(getNativeHandle());
	}

	public float getVelAvg() {
		return ZenKit.API.ZkParticleEffectInstance_getVelAvg(getNativeHandle());
	}

	public float getVelVar() {
		return ZenKit.API.ZkParticleEffectInstance_getVelVar(getNativeHandle());
	}

	public float getLspPartAvg() {
		return ZenKit.API.ZkParticleEffectInstance_getLspPartAvg(getNativeHandle());
	}

	public float getLspPartVar() {
		return ZenKit.API.ZkParticleEffectInstance_getLspPartVar(getNativeHandle());
	}

	public String getFlyGravityS() {
		return ZenKit.API.ZkParticleEffectInstance_getFlyGravityS(getNativeHandle());
	}

	public int getFlyColldetB() {
		return ZenKit.API.ZkParticleEffectInstance_getFlyColldetB(getNativeHandle());
	}

	public String getVisNameS() {
		return ZenKit.API.ZkParticleEffectInstance_getVisNameS(getNativeHandle());
	}

	public String getVisOrientationS() {
		return ZenKit.API.ZkParticleEffectInstance_getVisOrientationS(getNativeHandle());
	}

	public int getVisTexIsQuadpoly() {
		return ZenKit.API.ZkParticleEffectInstance_getVisTexIsQuadpoly(getNativeHandle());
	}

	public float getVisTexAniFps() {
		return ZenKit.API.ZkParticleEffectInstance_getVisTexAniFps(getNativeHandle());
	}

	public int getVisTexAniIsLooping() {
		return ZenKit.API.ZkParticleEffectInstance_getVisTexAniIsLooping(getNativeHandle());
	}

	public String getVisTexColorStartS() {
		return ZenKit.API.ZkParticleEffectInstance_getVisTexColorStartS(getNativeHandle());
	}

	public String getVisTexColorEndS() {
		return ZenKit.API.ZkParticleEffectInstance_getVisTexColorEndS(getNativeHandle());
	}

	public String getVisSizeStartS() {
		return ZenKit.API.ZkParticleEffectInstance_getVisSizeStartS(getNativeHandle());
	}

	public float getVisSizeEndScale() {
		return ZenKit.API.ZkParticleEffectInstance_getVisSizeEndScale(getNativeHandle());
	}

	public String getVisAlphaFuncS() {
		return ZenKit.API.ZkParticleEffectInstance_getVisAlphaFuncS(getNativeHandle());
	}

	public float getVisAlphaStart() {
		return ZenKit.API.ZkParticleEffectInstance_getVisAlphaStart(getNativeHandle());
	}

	public float getVisAlphaEnd() {
		return ZenKit.API.ZkParticleEffectInstance_getVisAlphaEnd(getNativeHandle());
	}

	public float getTrlFadeSpeed() {
		return ZenKit.API.ZkParticleEffectInstance_getTrlFadeSpeed(getNativeHandle());
	}

	public String getTrlTextureS() {
		return ZenKit.API.ZkParticleEffectInstance_getTrlTextureS(getNativeHandle());
	}

	public float getTrlWidth() {
		return ZenKit.API.ZkParticleEffectInstance_getTrlWidth(getNativeHandle());
	}

	public float getMrkFadesPeed() {
		return ZenKit.API.ZkParticleEffectInstance_getMrkFadesPeed(getNativeHandle());
	}

	public String getMrktExtureS() {
		return ZenKit.API.ZkParticleEffectInstance_getMrktExtureS(getNativeHandle());
	}

	public float getMrkSize() {
		return ZenKit.API.ZkParticleEffectInstance_getMrkSize(getNativeHandle());
	}

	public String getFlockMode() {
		return ZenKit.API.ZkParticleEffectInstance_getFlockMode(getNativeHandle());
	}

	public float getFlockStrength() {
		return ZenKit.API.ZkParticleEffectInstance_getFlockStrength(getNativeHandle());
	}

	public int getUseEmittersFor() {
		return ZenKit.API.ZkParticleEffectInstance_getUseEmittersFor(getNativeHandle());
	}

	public String getTimeStartEndS() {
		return ZenKit.API.ZkParticleEffectInstance_getTimeStartEndS(getNativeHandle());
	}

	public int getMBiasAmbientPfx() {
		return ZenKit.API.ZkParticleEffectInstance_getMBiasAmbientPfx(getNativeHandle());
	}
}
