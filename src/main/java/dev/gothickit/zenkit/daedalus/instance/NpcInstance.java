package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public class NpcInstance extends DaedalusInstance {
	public NpcInstance(Pointer handle) {
		super(handle);
	}

	public int getId() {
		return ZenKit.API.ZkNpcInstance_getId(getHandle());
	}

	public String getSlot() {
		return ZenKit.API.ZkNpcInstance_getSlot(getHandle());
	}

	public String getEffect() {
		return ZenKit.API.ZkNpcInstance_getEffect(getHandle());
	}

	public NpcInstanceType getNpcType() {
		return ZenKit.API.ZkNpcInstance_getType(getHandle());
	}

	public int getFlags() {
		return ZenKit.API.ZkNpcInstance_getFlags(getHandle());
	}

	public int getDamageType() {
		return ZenKit.API.ZkNpcInstance_getDamageType(getHandle());
	}

	public int getGuild() {
		return ZenKit.API.ZkNpcInstance_getGuild(getHandle());
	}

	public int getLevel() {
		return ZenKit.API.ZkNpcInstance_getLevel(getHandle());
	}

	public int getFightTactic() {
		return ZenKit.API.ZkNpcInstance_getFightTactic(getHandle());
	}

	public int getWeapon() {
		return ZenKit.API.ZkNpcInstance_getWeapon(getHandle());
	}

	public int getVoice() {
		return ZenKit.API.ZkNpcInstance_getVoice(getHandle());
	}

	public int getVoicePitch() {
		return ZenKit.API.ZkNpcInstance_getVoicePitch(getHandle());
	}

	public int getBodyMass() {
		return ZenKit.API.ZkNpcInstance_getBodyMass(getHandle());
	}

	public int getDailyRoutine() {
		return ZenKit.API.ZkNpcInstance_getDailyRoutine(getHandle());
	}

	public int getStartAiState() {
		return ZenKit.API.ZkNpcInstance_getStartAiState(getHandle());
	}

	public String getSpawnPoint() {
		return ZenKit.API.ZkNpcInstance_getSpawnPoint(getHandle());
	}

	public int getSpawnDelay() {
		return ZenKit.API.ZkNpcInstance_getSpawnDelay(getHandle());
	}

	public int getSenses() {
		return ZenKit.API.ZkNpcInstance_getSenses(getHandle());
	}

	public int getSensesRange() {
		return ZenKit.API.ZkNpcInstance_getSensesRange(getHandle());
	}

	public String getWp() {
		return ZenKit.API.ZkNpcInstance_getWp(getHandle());
	}

	public int getExp() {
		return ZenKit.API.ZkNpcInstance_getExp(getHandle());
	}

	public int getExpNext() {
		return ZenKit.API.ZkNpcInstance_getExpNext(getHandle());
	}

	public int getLp() {
		return ZenKit.API.ZkNpcInstance_getLp(getHandle());
	}

	public int getBodyStateInterruptableOverride() {
		return ZenKit.API.ZkNpcInstance_getBodyStateInterruptableOverride(getHandle());
	}

	public int getNoFocus() {
		return ZenKit.API.ZkNpcInstance_getNoFocus(getHandle());
	}

	public String getName(NpcInstanceNameSlot slot) {
		return ZenKit.API.ZkNpcInstance_getName(getHandle(), slot);
	}

	public int getMission(NpcInstanceMissionSlot slot) {
		return ZenKit.API.ZkNpcInstance_getMission(getHandle(), slot);
	}

	public int getAttribute(NpcInstanceAttribute attribute) {
		return ZenKit.API.ZkNpcInstance_getAttribute(getHandle(), attribute);
	}

	public int getHitChance(NpcInstanceTalent talent) {
		return ZenKit.API.ZkNpcInstance_getHitChance(getHandle(), talent);
	}

	public int getProtection(DamageType type) {
		return ZenKit.API.ZkNpcInstance_getProtection(getHandle(), type);
	}

	public int getDamage(DamageType type) {
		return ZenKit.API.ZkNpcInstance_getDamage(getHandle(), type);
	}

	public int getAiVar(long i) {
		return ZenKit.API.ZkNpcInstance_getAiVar(getHandle(), i);
	}
}
