package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public class SpellInstance extends DaedalusInstance {
	public SpellInstance(Pointer handle) {
		super(handle);
	}

	public float getTimePerMana() {
		return ZenKit.API.ZkSpellInstance_getTimePerMana(getHandle());
	}

	public int getDamagePerLevel() {
		return ZenKit.API.ZkSpellInstance_getDamagePerLevel(getHandle());
	}

	public int getDamageType() {
		return ZenKit.API.ZkSpellInstance_getDamageType(getHandle());
	}

	public int getSpellType() {
		return ZenKit.API.ZkSpellInstance_getSpellType(getHandle());
	}

	public int getCanTurnDuringInvest() {
		return ZenKit.API.ZkSpellInstance_getCanTurnDuringInvest(getHandle());
	}

	public int getCanChangeTargetDuringInvest() {
		return ZenKit.API.ZkSpellInstance_getCanChangeTargetDuringInvest(getHandle());
	}

	public int getIsMultiEffect() {
		return ZenKit.API.ZkSpellInstance_getIsMultiEffect(getHandle());
	}

	public int getTargetCollectAlgo() {
		return ZenKit.API.ZkSpellInstance_getTargetCollectAlgo(getHandle());
	}

	public int getTargetCollectType() {
		return ZenKit.API.ZkSpellInstance_getTargetCollectType(getHandle());
	}

	public int getTargetCollectRange() {
		return ZenKit.API.ZkSpellInstance_getTargetCollectRange(getHandle());
	}

	public int getTargetCollectAzi() {
		return ZenKit.API.ZkSpellInstance_getTargetCollectAzi(getHandle());
	}

	public int getTargetCollectElevation() {
		return ZenKit.API.ZkSpellInstance_getTargetCollectElevation(getHandle());
	}
}
