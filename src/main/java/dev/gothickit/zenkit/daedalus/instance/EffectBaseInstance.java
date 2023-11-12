package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public class EffectBaseInstance extends DaedalusInstance {
	public EffectBaseInstance(Pointer handle) {
		super(handle);
	}

	public String getVisNameS() {
		return ZenKit.API.ZkEffectBaseInstance_getVisNameS(getHandle());
	}

	public String getVisSizeS() {
		return ZenKit.API.ZkEffectBaseInstance_getVisSizeS(getHandle());
	}

	public float getVisAlpha() {
		return ZenKit.API.ZkEffectBaseInstance_getVisAlpha(getHandle());
	}

	public String getVisAlphaBlendFuncS() {
		return ZenKit.API.ZkEffectBaseInstance_getVisAlphaBlendFuncS(getHandle());
	}

	public float getVisTexAniFps() {
		return ZenKit.API.ZkEffectBaseInstance_getVisTexAniFps(getHandle());
	}

	public int getVisTexAniIsLooping() {
		return ZenKit.API.ZkEffectBaseInstance_getVisTexAniIsLooping(getHandle());
	}

	public String getEmTrjModeS() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjModeS(getHandle());
	}

	public String getEmTrjOriginNode() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjOriginNode(getHandle());
	}

	public String getEmTrjTargetNode() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjTargetNode(getHandle());
	}

	public float getEmTrjTargetRange() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjTargetRange(getHandle());
	}

	public float getEmTrjTargetAzi() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjTargetAzi(getHandle());
	}

	public float getEmTrjTargetElev() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjTargetElev(getHandle());
	}

	public int getEmTrjNumKeys() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjNumKeys(getHandle());
	}

	public int getEmTrjNumKeysVar() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjNumKeysVar(getHandle());
	}

	public float getEmTrjAngleElevVar() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjAngleElevVar(getHandle());
	}

	public float getEmTrjAngleHeadVar() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjAngleHeadVar(getHandle());
	}

	public float getEmTrjKeyDistVar() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjKeyDistVar(getHandle());
	}

	public String getEmTrjLoopModeS() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjLoopModeS(getHandle());
	}

	public String getEmTrjEaseFuncS() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjEaseFuncS(getHandle());
	}

	public float getEmTrjEaseVel() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjEaseVel(getHandle());
	}

	public float getEmTrjDynUpdateDelay() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjDynUpdateDelay(getHandle());
	}

	public int getEmTrjDynUpdateTargetOnly() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjDynUpdateTargetOnly(getHandle());
	}

	public String getEmFxCreateS() {
		return ZenKit.API.ZkEffectBaseInstance_getEmFxCreateS(getHandle());
	}

	public String getEmFxInvestOriginS() {
		return ZenKit.API.ZkEffectBaseInstance_getEmFxInvestOriginS(getHandle());
	}

	public String getEmFxInvestTargetS() {
		return ZenKit.API.ZkEffectBaseInstance_getEmFxInvestTargetS(getHandle());
	}

	public float getEmFxTriggerDelay() {
		return ZenKit.API.ZkEffectBaseInstance_getEmFxTriggerDelay(getHandle());
	}

	public int getEmFxCreateDownTrj() {
		return ZenKit.API.ZkEffectBaseInstance_getEmFxCreateDownTrj(getHandle());
	}

	public String getEmActionCollDynS() {
		return ZenKit.API.ZkEffectBaseInstance_getEmActionCollDynS(getHandle());
	}

	public String getEmActionCollStatS() {
		return ZenKit.API.ZkEffectBaseInstance_getEmActionCollStatS(getHandle());
	}

	public String getEmFxCollStatS() {
		return ZenKit.API.ZkEffectBaseInstance_getEmFxCollStatS(getHandle());
	}

	public String getEmFxCollDynS() {
		return ZenKit.API.ZkEffectBaseInstance_getEmFxCollDynS(getHandle());
	}

	public String getEmFxCollStatAlignS() {
		return ZenKit.API.ZkEffectBaseInstance_getEmFxCollStatAlignS(getHandle());
	}

	public String getEmFxCollDynAlignS() {
		return ZenKit.API.ZkEffectBaseInstance_getEmFxCollDynAlignS(getHandle());
	}

	public float getEmFxLifespan() {
		return ZenKit.API.ZkEffectBaseInstance_getEmFxLifespan(getHandle());
	}

	public int getEmCheckCollision() {
		return ZenKit.API.ZkEffectBaseInstance_getEmCheckCollision(getHandle());
	}

	public int getEmAdjustShpToOrigin() {
		return ZenKit.API.ZkEffectBaseInstance_getEmAdjustShpToOrigin(getHandle());
	}

	public float getEmInvestNextKeyDuration() {
		return ZenKit.API.ZkEffectBaseInstance_getEmInvestNextKeyDuration(getHandle());
	}

	public float getEmFlyGravity() {
		return ZenKit.API.ZkEffectBaseInstance_getEmFlyGravity(getHandle());
	}

	public String getEmSelfRotVelS() {
		return ZenKit.API.ZkEffectBaseInstance_getEmSelfRotVelS(getHandle());
	}

	public String getLightPresetName() {
		return ZenKit.API.ZkEffectBaseInstance_getLightPresetName(getHandle());
	}

	public String getSfxId() {
		return ZenKit.API.ZkEffectBaseInstance_getSfxId(getHandle());
	}

	public int getSfxIsAmbient() {
		return ZenKit.API.ZkEffectBaseInstance_getSfxIsAmbient(getHandle());
	}

	public int getSendAssessMagic() {
		return ZenKit.API.ZkEffectBaseInstance_getSendAssessMagic(getHandle());
	}

	public float getSecsPerDamage() {
		return ZenKit.API.ZkEffectBaseInstance_getSecsPerDamage(getHandle());
	}

	public String getEmFxCollDynPercS() {
		return ZenKit.API.ZkEffectBaseInstance_getEmFxCollDynPercS(getHandle());
	}

	public String getUserString(long i) {
		return ZenKit.API.ZkEffectBaseInstance_getUserString(getHandle(), i);
	}
}
