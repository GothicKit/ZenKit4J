package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public final class NpcInstance extends DaedalusInstance {
	public NpcInstance(Pointer handle) {
		super(handle);
	}

	public int getId() {
		return ZenKit.API.ZkNpcInstance_getId(getNativeHandle());
	}

	public String getSlot() {
		return ZenKit.API.ZkNpcInstance_getSlot(getNativeHandle());
	}

	public String getEffect() {
		return ZenKit.API.ZkNpcInstance_getEffect(getNativeHandle());
	}

	public NpcInstanceType getNpcType() {
		return ZenKit.API.ZkNpcInstance_getType(getNativeHandle());
	}

	public int getFlags() {
		return ZenKit.API.ZkNpcInstance_getFlags(getNativeHandle());
	}

	public int getDamageType() {
		return ZenKit.API.ZkNpcInstance_getDamageType(getNativeHandle());
	}

	public int getGuild() {
		return ZenKit.API.ZkNpcInstance_getGuild(getNativeHandle());
	}

	public int getLevel() {
		return ZenKit.API.ZkNpcInstance_getLevel(getNativeHandle());
	}

	public int getFightTactic() {
		return ZenKit.API.ZkNpcInstance_getFightTactic(getNativeHandle());
	}

	public int getWeapon() {
		return ZenKit.API.ZkNpcInstance_getWeapon(getNativeHandle());
	}

	public int getVoice() {
		return ZenKit.API.ZkNpcInstance_getVoice(getNativeHandle());
	}

	public int getVoicePitch() {
		return ZenKit.API.ZkNpcInstance_getVoicePitch(getNativeHandle());
	}

	public int getBodyMass() {
		return ZenKit.API.ZkNpcInstance_getBodyMass(getNativeHandle());
	}

	public int getDailyRoutine() {
		return ZenKit.API.ZkNpcInstance_getDailyRoutine(getNativeHandle());
	}

	public int getStartAiState() {
		return ZenKit.API.ZkNpcInstance_getStartAiState(getNativeHandle());
	}

	public String getSpawnPoint() {
		return ZenKit.API.ZkNpcInstance_getSpawnPoint(getNativeHandle());
	}

	public int getSpawnDelay() {
		return ZenKit.API.ZkNpcInstance_getSpawnDelay(getNativeHandle());
	}

	public int getSenses() {
		return ZenKit.API.ZkNpcInstance_getSenses(getNativeHandle());
	}

	public int getSensesRange() {
		return ZenKit.API.ZkNpcInstance_getSensesRange(getNativeHandle());
	}

	public String getWp() {
		return ZenKit.API.ZkNpcInstance_getWp(getNativeHandle());
	}

	public int getExp() {
		return ZenKit.API.ZkNpcInstance_getExp(getNativeHandle());
	}

	public int getExpNext() {
		return ZenKit.API.ZkNpcInstance_getExpNext(getNativeHandle());
	}

	public int getLp() {
		return ZenKit.API.ZkNpcInstance_getLp(getNativeHandle());
	}

	public int getBodyStateInterruptableOverride() {
		return ZenKit.API.ZkNpcInstance_getBodyStateInterruptableOverride(getNativeHandle());
	}

	public int getNoFocus() {
		return ZenKit.API.ZkNpcInstance_getNoFocus(getNativeHandle());
	}

	public String getName(NpcInstanceNameSlot slot) {
		return ZenKit.API.ZkNpcInstance_getName(getNativeHandle(), slot);
	}

	public int getMission(NpcInstanceMissionSlot slot) {
		return ZenKit.API.ZkNpcInstance_getMission(getNativeHandle(), slot);
	}

	public int getAttribute(NpcInstanceAttribute attribute) {
		return ZenKit.API.ZkNpcInstance_getAttribute(getNativeHandle(), attribute);
	}

	public int getHitChance(NpcInstanceTalent talent) {
		return ZenKit.API.ZkNpcInstance_getHitChance(getNativeHandle(), talent);
	}

	public int getProtection(DamageType type) {
		return ZenKit.API.ZkNpcInstance_getProtection(getNativeHandle(), type);
	}

	public int getDamage(DamageType type) {
		return ZenKit.API.ZkNpcInstance_getDamage(getNativeHandle(), type);
	}

	public int getAiVar(long i) {
		return ZenKit.API.ZkNpcInstance_getAiVar(getNativeHandle(), i);
	}
}
