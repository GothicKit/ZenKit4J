package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public class ParticleEffectInstance extends DaedalusInstance {
	public ParticleEffectInstance(Pointer handle) {
		super(handle);
	}

	public float getPpsValue() {
		return ZenKit.API.ZkParticleEffectInstance_getPpsValue(getHandle());
	}

	public String getPpsScaleKeysS() {
		return ZenKit.API.ZkParticleEffectInstance_getPpsScaleKeysS(getHandle());
	}

	public int getPpsIsLooping() {
		return ZenKit.API.ZkParticleEffectInstance_getPpsIsLooping(getHandle());
	}

	public int getPpsIsSmooth() {
		return ZenKit.API.ZkParticleEffectInstance_getPpsIsSmooth(getHandle());
	}

	public float getPpsFps() {
		return ZenKit.API.ZkParticleEffectInstance_getPpsFps(getHandle());
	}

	public String getPpsCreateEmS() {
		return ZenKit.API.ZkParticleEffectInstance_getPpsCreateEmS(getHandle());
	}

	public float getPpsCreateEmDelay() {
		return ZenKit.API.ZkParticleEffectInstance_getPpsCreateEmDelay(getHandle());
	}

	public String getShpTypeS() {
		return ZenKit.API.ZkParticleEffectInstance_getShpTypeS(getHandle());
	}

	public String getShpForS() {
		return ZenKit.API.ZkParticleEffectInstance_getShpForS(getHandle());
	}

	public String getShpOffsetVecS() {
		return ZenKit.API.ZkParticleEffectInstance_getShpOffsetVecS(getHandle());
	}

	public String getShpDistribTypeS() {
		return ZenKit.API.ZkParticleEffectInstance_getShpDistribTypeS(getHandle());
	}

	public float getShpDistribWalkSpeed() {
		return ZenKit.API.ZkParticleEffectInstance_getShpDistribWalkSpeed(getHandle());
	}

	public int getShpIsVolume() {
		return ZenKit.API.ZkParticleEffectInstance_getShpIsVolume(getHandle());
	}

	public String getShpDimS() {
		return ZenKit.API.ZkParticleEffectInstance_getShpDimS(getHandle());
	}

	public String getShpMeshS() {
		return ZenKit.API.ZkParticleEffectInstance_getShpMeshS(getHandle());
	}

	public int getShpMeshRenderB() {
		return ZenKit.API.ZkParticleEffectInstance_getShpMeshRenderB(getHandle());
	}

	public String getShpScaleKeysS() {
		return ZenKit.API.ZkParticleEffectInstance_getShpScaleKeysS(getHandle());
	}

	public int getShpScaleIsLooping() {
		return ZenKit.API.ZkParticleEffectInstance_getShpScaleIsLooping(getHandle());
	}

	public int getShpScaleIsSmooth() {
		return ZenKit.API.ZkParticleEffectInstance_getShpScaleIsSmooth(getHandle());
	}

	public float getShpScaleFps() {
		return ZenKit.API.ZkParticleEffectInstance_getShpScaleFps(getHandle());
	}

	public String getDirModeS() {
		return ZenKit.API.ZkParticleEffectInstance_getDirModeS(getHandle());
	}

	public String getDirForS() {
		return ZenKit.API.ZkParticleEffectInstance_getDirForS(getHandle());
	}

	public String getDirModeTargetForS() {
		return ZenKit.API.ZkParticleEffectInstance_getDirModeTargetForS(getHandle());
	}

	public String getDirModeTargetPosS() {
		return ZenKit.API.ZkParticleEffectInstance_getDirModeTargetPosS(getHandle());
	}

	public float getDirAngleHead() {
		return ZenKit.API.ZkParticleEffectInstance_getDirAngleHead(getHandle());
	}

	public float getDirAngleHeadVar() {
		return ZenKit.API.ZkParticleEffectInstance_getDirAngleHeadVar(getHandle());
	}

	public float getDirAngleElev() {
		return ZenKit.API.ZkParticleEffectInstance_getDirAngleElev(getHandle());
	}

	public float getDirAngleElevVar() {
		return ZenKit.API.ZkParticleEffectInstance_getDirAngleElevVar(getHandle());
	}

	public float getVelAvg() {
		return ZenKit.API.ZkParticleEffectInstance_getVelAvg(getHandle());
	}

	public float getVelVar() {
		return ZenKit.API.ZkParticleEffectInstance_getVelVar(getHandle());
	}

	public float getLspPartAvg() {
		return ZenKit.API.ZkParticleEffectInstance_getLspPartAvg(getHandle());
	}

	public float getLspPartVar() {
		return ZenKit.API.ZkParticleEffectInstance_getLspPartVar(getHandle());
	}

	public String getFlyGravityS() {
		return ZenKit.API.ZkParticleEffectInstance_getFlyGravityS(getHandle());
	}

	public int getFlyColldetB() {
		return ZenKit.API.ZkParticleEffectInstance_getFlyColldetB(getHandle());
	}

	public String getVisNameS() {
		return ZenKit.API.ZkParticleEffectInstance_getVisNameS(getHandle());
	}

	public String getVisOrientationS() {
		return ZenKit.API.ZkParticleEffectInstance_getVisOrientationS(getHandle());
	}

	public int getVisTexIsQuadpoly() {
		return ZenKit.API.ZkParticleEffectInstance_getVisTexIsQuadpoly(getHandle());
	}

	public float getVisTexAniFps() {
		return ZenKit.API.ZkParticleEffectInstance_getVisTexAniFps(getHandle());
	}

	public int getVisTexAniIsLooping() {
		return ZenKit.API.ZkParticleEffectInstance_getVisTexAniIsLooping(getHandle());
	}

	public String getVisTexColorStartS() {
		return ZenKit.API.ZkParticleEffectInstance_getVisTexColorStartS(getHandle());
	}

	public String getVisTexColorEndS() {
		return ZenKit.API.ZkParticleEffectInstance_getVisTexColorEndS(getHandle());
	}

	public String getVisSizeStartS() {
		return ZenKit.API.ZkParticleEffectInstance_getVisSizeStartS(getHandle());
	}

	public float getVisSizeEndScale() {
		return ZenKit.API.ZkParticleEffectInstance_getVisSizeEndScale(getHandle());
	}

	public String getVisAlphaFuncS() {
		return ZenKit.API.ZkParticleEffectInstance_getVisAlphaFuncS(getHandle());
	}

	public float getVisAlphaStart() {
		return ZenKit.API.ZkParticleEffectInstance_getVisAlphaStart(getHandle());
	}

	public float getVisAlphaEnd() {
		return ZenKit.API.ZkParticleEffectInstance_getVisAlphaEnd(getHandle());
	}

	public float getTrlFadeSpeed() {
		return ZenKit.API.ZkParticleEffectInstance_getTrlFadeSpeed(getHandle());
	}

	public String getTrlTextureS() {
		return ZenKit.API.ZkParticleEffectInstance_getTrlTextureS(getHandle());
	}

	public float getTrlWidth() {
		return ZenKit.API.ZkParticleEffectInstance_getTrlWidth(getHandle());
	}

	public float getMrkFadesPeed() {
		return ZenKit.API.ZkParticleEffectInstance_getMrkFadesPeed(getHandle());
	}

	public String getMrktExtureS() {
		return ZenKit.API.ZkParticleEffectInstance_getMrktExtureS(getHandle());
	}

	public float getMrkSize() {
		return ZenKit.API.ZkParticleEffectInstance_getMrkSize(getHandle());
	}

	public String getFlockMode() {
		return ZenKit.API.ZkParticleEffectInstance_getFlockMode(getHandle());
	}

	public float getFlockStrength() {
		return ZenKit.API.ZkParticleEffectInstance_getFlockStrength(getHandle());
	}

	public int getUseEmittersFor() {
		return ZenKit.API.ZkParticleEffectInstance_getUseEmittersFor(getHandle());
	}

	public String getTimeStartEndS() {
		return ZenKit.API.ZkParticleEffectInstance_getTimeStartEndS(getHandle());
	}

	public int getMBiasAmbientPfx() {
		return ZenKit.API.ZkParticleEffectInstance_getMBiasAmbientPfx(getHandle());
	}

}
