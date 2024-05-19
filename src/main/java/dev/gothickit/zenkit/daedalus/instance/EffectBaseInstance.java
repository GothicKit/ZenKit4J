package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public final class EffectBaseInstance extends DaedalusInstance {
	public EffectBaseInstance(Pointer handle) {
		super(handle);
	}

	public String getVisNameS() {
		return ZenKit.API.ZkEffectBaseInstance_getVisNameS(getNativeHandle());
	}

	public String getVisSizeS() {
		return ZenKit.API.ZkEffectBaseInstance_getVisSizeS(getNativeHandle());
	}

	public float getVisAlpha() {
		return ZenKit.API.ZkEffectBaseInstance_getVisAlpha(getNativeHandle());
	}

	public String getVisAlphaBlendFuncS() {
		return ZenKit.API.ZkEffectBaseInstance_getVisAlphaBlendFuncS(getNativeHandle());
	}

	public float getVisTexAniFps() {
		return ZenKit.API.ZkEffectBaseInstance_getVisTexAniFps(getNativeHandle());
	}

	public int getVisTexAniIsLooping() {
		return ZenKit.API.ZkEffectBaseInstance_getVisTexAniIsLooping(getNativeHandle());
	}

	public String getEmTrjModeS() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjModeS(getNativeHandle());
	}

	public String getEmTrjOriginNode() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjOriginNode(getNativeHandle());
	}

	public String getEmTrjTargetNode() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjTargetNode(getNativeHandle());
	}

	public float getEmTrjTargetRange() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjTargetRange(getNativeHandle());
	}

	public float getEmTrjTargetAzi() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjTargetAzi(getNativeHandle());
	}

	public float getEmTrjTargetElev() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjTargetElev(getNativeHandle());
	}

	public int getEmTrjNumKeys() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjNumKeys(getNativeHandle());
	}

	public int getEmTrjNumKeysVar() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjNumKeysVar(getNativeHandle());
	}

	public float getEmTrjAngleElevVar() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjAngleElevVar(getNativeHandle());
	}

	public float getEmTrjAngleHeadVar() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjAngleHeadVar(getNativeHandle());
	}

	public float getEmTrjKeyDistVar() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjKeyDistVar(getNativeHandle());
	}

	public String getEmTrjLoopModeS() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjLoopModeS(getNativeHandle());
	}

	public String getEmTrjEaseFuncS() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjEaseFuncS(getNativeHandle());
	}

	public float getEmTrjEaseVel() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjEaseVel(getNativeHandle());
	}

	public float getEmTrjDynUpdateDelay() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjDynUpdateDelay(getNativeHandle());
	}

	public int getEmTrjDynUpdateTargetOnly() {
		return ZenKit.API.ZkEffectBaseInstance_getEmTrjDynUpdateTargetOnly(getNativeHandle());
	}

	public String getEmFxCreateS() {
		return ZenKit.API.ZkEffectBaseInstance_getEmFxCreateS(getNativeHandle());
	}

	public String getEmFxInvestOriginS() {
		return ZenKit.API.ZkEffectBaseInstance_getEmFxInvestOriginS(getNativeHandle());
	}

	public String getEmFxInvestTargetS() {
		return ZenKit.API.ZkEffectBaseInstance_getEmFxInvestTargetS(getNativeHandle());
	}

	public float getEmFxTriggerDelay() {
		return ZenKit.API.ZkEffectBaseInstance_getEmFxTriggerDelay(getNativeHandle());
	}

	public int getEmFxCreateDownTrj() {
		return ZenKit.API.ZkEffectBaseInstance_getEmFxCreateDownTrj(getNativeHandle());
	}

	public String getEmActionCollDynS() {
		return ZenKit.API.ZkEffectBaseInstance_getEmActionCollDynS(getNativeHandle());
	}

	public String getEmActionCollStatS() {
		return ZenKit.API.ZkEffectBaseInstance_getEmActionCollStatS(getNativeHandle());
	}

	public String getEmFxCollStatS() {
		return ZenKit.API.ZkEffectBaseInstance_getEmFxCollStatS(getNativeHandle());
	}

	public String getEmFxCollDynS() {
		return ZenKit.API.ZkEffectBaseInstance_getEmFxCollDynS(getNativeHandle());
	}

	public String getEmFxCollStatAlignS() {
		return ZenKit.API.ZkEffectBaseInstance_getEmFxCollStatAlignS(getNativeHandle());
	}

	public String getEmFxCollDynAlignS() {
		return ZenKit.API.ZkEffectBaseInstance_getEmFxCollDynAlignS(getNativeHandle());
	}

	public float getEmFxLifespan() {
		return ZenKit.API.ZkEffectBaseInstance_getEmFxLifespan(getNativeHandle());
	}

	public int getEmCheckCollision() {
		return ZenKit.API.ZkEffectBaseInstance_getEmCheckCollision(getNativeHandle());
	}

	public int getEmAdjustShpToOrigin() {
		return ZenKit.API.ZkEffectBaseInstance_getEmAdjustShpToOrigin(getNativeHandle());
	}

	public float getEmInvestNextKeyDuration() {
		return ZenKit.API.ZkEffectBaseInstance_getEmInvestNextKeyDuration(getNativeHandle());
	}

	public float getEmFlyGravity() {
		return ZenKit.API.ZkEffectBaseInstance_getEmFlyGravity(getNativeHandle());
	}

	public String getEmSelfRotVelS() {
		return ZenKit.API.ZkEffectBaseInstance_getEmSelfRotVelS(getNativeHandle());
	}

	public String getLightPresetName() {
		return ZenKit.API.ZkEffectBaseInstance_getLightPresetName(getNativeHandle());
	}

	public String getSfxId() {
		return ZenKit.API.ZkEffectBaseInstance_getSfxId(getNativeHandle());
	}

	public int getSfxIsAmbient() {
		return ZenKit.API.ZkEffectBaseInstance_getSfxIsAmbient(getNativeHandle());
	}

	public int getSendAssessMagic() {
		return ZenKit.API.ZkEffectBaseInstance_getSendAssessMagic(getNativeHandle());
	}

	public float getSecsPerDamage() {
		return ZenKit.API.ZkEffectBaseInstance_getSecsPerDamage(getNativeHandle());
	}

	public String getEmFxCollDynPercS() {
		return ZenKit.API.ZkEffectBaseInstance_getEmFxCollDynPercS(getNativeHandle());
	}

	public String getUserString(long i) {
		return ZenKit.API.ZkEffectBaseInstance_getUserString(getNativeHandle(), i);
	}
}
