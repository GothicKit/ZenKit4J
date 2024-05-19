package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public final class SpellInstance extends DaedalusInstance {
	public SpellInstance(Pointer handle) {
		super(handle);
	}

	public float getTimePerMana() {
		return ZenKit.API.ZkSpellInstance_getTimePerMana(getNativeHandle());
	}

	public int getDamagePerLevel() {
		return ZenKit.API.ZkSpellInstance_getDamagePerLevel(getNativeHandle());
	}

	public int getDamageType() {
		return ZenKit.API.ZkSpellInstance_getDamageType(getNativeHandle());
	}

	public int getSpellType() {
		return ZenKit.API.ZkSpellInstance_getSpellType(getNativeHandle());
	}

	public int getCanTurnDuringInvest() {
		return ZenKit.API.ZkSpellInstance_getCanTurnDuringInvest(getNativeHandle());
	}

	public int getCanChangeTargetDuringInvest() {
		return ZenKit.API.ZkSpellInstance_getCanChangeTargetDuringInvest(getNativeHandle());
	}

	public int getIsMultiEffect() {
		return ZenKit.API.ZkSpellInstance_getIsMultiEffect(getNativeHandle());
	}

	public int getTargetCollectAlgo() {
		return ZenKit.API.ZkSpellInstance_getTargetCollectAlgo(getNativeHandle());
	}

	public int getTargetCollectType() {
		return ZenKit.API.ZkSpellInstance_getTargetCollectType(getNativeHandle());
	}

	public int getTargetCollectRange() {
		return ZenKit.API.ZkSpellInstance_getTargetCollectRange(getNativeHandle());
	}

	public int getTargetCollectAzi() {
		return ZenKit.API.ZkSpellInstance_getTargetCollectAzi(getNativeHandle());
	}

	public int getTargetCollectElevation() {
		return ZenKit.API.ZkSpellInstance_getTargetCollectElevation(getNativeHandle());
	}
}
