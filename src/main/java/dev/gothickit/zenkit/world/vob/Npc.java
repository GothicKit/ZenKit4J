package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.LongByReference;
import dev.gothickit.zenkit.Vec3f;
import dev.gothickit.zenkit.capi.ZenKit;

import java.util.ArrayList;
import java.util.List;

public final class Npc extends VirtualObject {
	public Npc() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.oCNpc));
	}

	Npc(Pointer handle) {
		super(handle);
	}

	public String getNpcInstance() {
		return ZenKit.API.ZkNpc_getNpcInstance(getNativeHandle());
	}

	public void setNpcInstance(String val) {
		ZenKit.API.ZkNpc_setNpcInstance(getNativeHandle(), val);
	}

	public Vec3f getModelScale() {
		return ZenKit.API.ZkNpc_getModelScale(getNativeHandle());
	}

	public void setModelScale(Vec3f val) {
		ZenKit.API.ZkNpc_setModelScale(getNativeHandle(), val);
	}

	public float getModelFatness() {
		return ZenKit.API.ZkNpc_getModelFatness(getNativeHandle());
	}

	public void setModelFatness(float val) {
		ZenKit.API.ZkNpc_setModelFatness(getNativeHandle(), val);
	}

	public int getFlags() {
		return ZenKit.API.ZkNpc_getFlags(getNativeHandle());
	}

	public void setFlags(int val) {
		ZenKit.API.ZkNpc_setFlags(getNativeHandle(), val);
	}

	public int getGuild() {
		return ZenKit.API.ZkNpc_getGuild(getNativeHandle());
	}

	public void setGuild(int val) {
		ZenKit.API.ZkNpc_setGuild(getNativeHandle(), val);
	}

	public int getGuildTrue() {
		return ZenKit.API.ZkNpc_getGuildTrue(getNativeHandle());
	}

	public void setGuildTrue(int val) {
		ZenKit.API.ZkNpc_setGuildTrue(getNativeHandle(), val);
	}

	public int getLevel() {
		return ZenKit.API.ZkNpc_getLevel(getNativeHandle());
	}

	public void setLevel(int val) {
		ZenKit.API.ZkNpc_setLevel(getNativeHandle(), val);
	}

	public int getXp() {
		return ZenKit.API.ZkNpc_getXp(getNativeHandle());
	}

	public void setXp(int val) {
		ZenKit.API.ZkNpc_setXp(getNativeHandle(), val);
	}

	public int getXpNextLevel() {
		return ZenKit.API.ZkNpc_getXpNextLevel(getNativeHandle());
	}

	public void setXpNextLevel(int val) {
		ZenKit.API.ZkNpc_setXpNextLevel(getNativeHandle(), val);
	}

	public int getLp() {
		return ZenKit.API.ZkNpc_getLp(getNativeHandle());
	}

	public void setLp(int val) {
		ZenKit.API.ZkNpc_setLp(getNativeHandle(), val);
	}

	public int getFightTactic() {
		return ZenKit.API.ZkNpc_getFightTactic(getNativeHandle());
	}

	public void setFightTactic(int val) {
		ZenKit.API.ZkNpc_setFightTactic(getNativeHandle(), val);
	}

	public int getFightMode() {
		return ZenKit.API.ZkNpc_getFightMode(getNativeHandle());
	}

	public void setFightMode(int val) {
		ZenKit.API.ZkNpc_setFightMode(getNativeHandle(), val);
	}

	public boolean getWounded() {
		return ZenKit.API.ZkNpc_getWounded(getNativeHandle());
	}

	public void setWounded(boolean val) {
		ZenKit.API.ZkNpc_setWounded(getNativeHandle(), val);
	}

	public boolean getMad() {
		return ZenKit.API.ZkNpc_getMad(getNativeHandle());
	}

	public void setMad(boolean val) {
		ZenKit.API.ZkNpc_setMad(getNativeHandle(), val);
	}

	public int getMadTime() {
		return ZenKit.API.ZkNpc_getMadTime(getNativeHandle());
	}

	public void setMadTime(int val) {
		ZenKit.API.ZkNpc_setMadTime(getNativeHandle(), val);
	}

	public boolean getPlayer() {
		return ZenKit.API.ZkNpc_getPlayer(getNativeHandle());
	}

	public void setPlayer(boolean val) {
		ZenKit.API.ZkNpc_setPlayer(getNativeHandle(), val);
	}

	public String getStartAiState() {
		return ZenKit.API.ZkNpc_getStartAiState(getNativeHandle());
	}

	public void setStartAiState(String val) {
		ZenKit.API.ZkNpc_setStartAiState(getNativeHandle(), val);
	}

	public String getScriptWaypoint() {
		return ZenKit.API.ZkNpc_getScriptWaypoint(getNativeHandle());
	}

	public void setScriptWaypoint(String val) {
		ZenKit.API.ZkNpc_setScriptWaypoint(getNativeHandle(), val);
	}

	public int getAttitude() {
		return ZenKit.API.ZkNpc_getAttitude(getNativeHandle());
	}

	public void setAttitude(int val) {
		ZenKit.API.ZkNpc_setAttitude(getNativeHandle(), val);
	}

	public int getAttitudeTemp() {
		return ZenKit.API.ZkNpc_getAttitudeTemp(getNativeHandle());
	}

	public void setAttitudeTemp(int val) {
		ZenKit.API.ZkNpc_setAttitudeTemp(getNativeHandle(), val);
	}

	public int getNameNr() {
		return ZenKit.API.ZkNpc_getNameNr(getNativeHandle());
	}

	public void setNameNr(int val) {
		ZenKit.API.ZkNpc_setNameNr(getNativeHandle(), val);
	}

	public boolean getMoveLock() {
		return ZenKit.API.ZkNpc_getMoveLock(getNativeHandle());
	}

	public void setMoveLock(boolean val) {
		ZenKit.API.ZkNpc_setMoveLock(getNativeHandle(), val);
	}

	public boolean getCurrentStateValid() {
		return ZenKit.API.ZkNpc_getCurrentStateValid(getNativeHandle());
	}

	public void setCurrentStateValid(boolean val) {
		ZenKit.API.ZkNpc_setCurrentStateValid(getNativeHandle(), val);
	}

	public String getCurrentStateName() {
		return ZenKit.API.ZkNpc_getCurrentStateName(getNativeHandle());
	}

	public void setCurrentStateName(String val) {
		ZenKit.API.ZkNpc_setCurrentStateName(getNativeHandle(), val);
	}

	public int getCurrentStateIndex() {
		return ZenKit.API.ZkNpc_getCurrentStateIndex(getNativeHandle());
	}

	public void setCurrentStateIndex(int val) {
		ZenKit.API.ZkNpc_setCurrentStateIndex(getNativeHandle(), val);
	}

	public boolean getCurrentStateIsRoutine() {
		return ZenKit.API.ZkNpc_getCurrentStateIsRoutine(getNativeHandle());
	}

	public void setCurrentStateIsRoutine(boolean val) {
		ZenKit.API.ZkNpc_setCurrentStateIsRoutine(getNativeHandle(), val);
	}

	public boolean getNextStateValid() {
		return ZenKit.API.ZkNpc_getNextStateValid(getNativeHandle());
	}

	public void setNextStateValid(boolean val) {
		ZenKit.API.ZkNpc_setNextStateValid(getNativeHandle(), val);
	}

	public String getNextStateName() {
		return ZenKit.API.ZkNpc_getNextStateName(getNativeHandle());
	}

	public void setNextStateName(String val) {
		ZenKit.API.ZkNpc_setNextStateName(getNativeHandle(), val);
	}

	public int getNextStateIndex() {
		return ZenKit.API.ZkNpc_getNextStateIndex(getNativeHandle());
	}

	public void setNextStateIndex(int val) {
		ZenKit.API.ZkNpc_setNextStateIndex(getNativeHandle(), val);
	}

	public boolean getNextStateIsRoutine() {
		return ZenKit.API.ZkNpc_getNextStateIsRoutine(getNativeHandle());
	}

	public void setNextStateIsRoutine(boolean val) {
		ZenKit.API.ZkNpc_setNextStateIsRoutine(getNativeHandle(), val);
	}

	public int getLastAiState() {
		return ZenKit.API.ZkNpc_getLastAiState(getNativeHandle());
	}

	public void setLastAiState(int val) {
		ZenKit.API.ZkNpc_setLastAiState(getNativeHandle(), val);
	}

	public boolean getHasRoutine() {
		return ZenKit.API.ZkNpc_getHasRoutine(getNativeHandle());
	}

	public void setHasRoutine(boolean val) {
		ZenKit.API.ZkNpc_setHasRoutine(getNativeHandle(), val);
	}

	public boolean getRoutineChanged() {
		return ZenKit.API.ZkNpc_getRoutineChanged(getNativeHandle());
	}

	public void setRoutineChanged(boolean val) {
		ZenKit.API.ZkNpc_setRoutineChanged(getNativeHandle(), val);
	}

	public boolean getRoutineOverlay() {
		return ZenKit.API.ZkNpc_getRoutineOverlay(getNativeHandle());
	}

	public void setRoutineOverlay(boolean val) {
		ZenKit.API.ZkNpc_setRoutineOverlay(getNativeHandle(), val);
	}

	public int getRoutineOverlayCount() {
		return ZenKit.API.ZkNpc_getRoutineOverlayCount(getNativeHandle());
	}

	public void setRoutineOverlayCount(int val) {
		ZenKit.API.ZkNpc_setRoutineOverlayCount(getNativeHandle(), val);
	}

	public int getWalkmodeRoutine() {
		return ZenKit.API.ZkNpc_getWalkmodeRoutine(getNativeHandle());
	}

	public void setWalkmodeRoutine(int val) {
		ZenKit.API.ZkNpc_setWalkmodeRoutine(getNativeHandle(), val);
	}

	public boolean getWeaponmodeRoutine() {
		return ZenKit.API.ZkNpc_getWeaponmodeRoutine(getNativeHandle());
	}

	public void setWeaponmodeRoutine(boolean val) {
		ZenKit.API.ZkNpc_setWeaponmodeRoutine(getNativeHandle(), val);
	}

	public boolean getStartNewRoutine() {
		return ZenKit.API.ZkNpc_getStartNewRoutine(getNativeHandle());
	}

	public void setStartNewRoutine(boolean val) {
		ZenKit.API.ZkNpc_setStartNewRoutine(getNativeHandle(), val);
	}

	public int getAiStateDriven() {
		return ZenKit.API.ZkNpc_getAiStateDriven(getNativeHandle());
	}

	public void setAiStateDriven(int val) {
		ZenKit.API.ZkNpc_setAiStateDriven(getNativeHandle(), val);
	}

	public Vec3f getAiStatePos() {
		return ZenKit.API.ZkNpc_getAiStatePos(getNativeHandle());
	}

	public void setAiStatePos(Vec3f val) {
		ZenKit.API.ZkNpc_setAiStatePos(getNativeHandle(), val);
	}

	public String getCurrentRoutine() {
		return ZenKit.API.ZkNpc_getCurrentRoutine(getNativeHandle());
	}

	public void setCurrentRoutine(String val) {
		ZenKit.API.ZkNpc_setCurrentRoutine(getNativeHandle(), val);
	}

	public boolean getRespawn() {
		return ZenKit.API.ZkNpc_getRespawn(getNativeHandle());
	}

	public void setRespawn(boolean val) {
		ZenKit.API.ZkNpc_setRespawn(getNativeHandle(), val);
	}

	public int getRespawnTime() {
		return ZenKit.API.ZkNpc_getRespawnTime(getNativeHandle());
	}

	public void setRespawnTime(int val) {
		ZenKit.API.ZkNpc_setRespawnTime(getNativeHandle(), val);
	}

	public int getBsInterruptableOverride() {
		return ZenKit.API.ZkNpc_getBsInterruptableOverride(getNativeHandle());
	}

	public void setBsInterruptableOverride(int val) {
		ZenKit.API.ZkNpc_setBsInterruptableOverride(getNativeHandle(), val);
	}

	public int getNpcType() {
		return ZenKit.API.ZkNpc_getNpcType(getNativeHandle());
	}

	public void setNpcType(int val) {
		ZenKit.API.ZkNpc_setNpcType(getNativeHandle(), val);
	}

	public int getSpellMana() {
		return ZenKit.API.ZkNpc_getSpellMana(getNativeHandle());
	}

	public void setSpellMana(int val) {
		ZenKit.API.ZkNpc_setSpellMana(getNativeHandle(), val);
	}

	public VirtualObject getCarryVob() {
		var ptr = ZenKit.API.ZkNpc_getCarryVob(getNativeHandle());
		return VirtualObject.fromNativeHandle(ptr);
	}

	public VirtualObject getEnemy() {
		var ptr = ZenKit.API.ZkNpc_getEnemy(getNativeHandle());
		return VirtualObject.fromNativeHandle(ptr);
	}

	public void getCarryVob(VirtualObject val) {
		ZenKit.API.ZkNpc_setCarryVob(getNativeHandle(), val.getNativeHandle());
	}

	public void getEnemy(VirtualObject val) {
		ZenKit.API.ZkNpc_setEnemy(getNativeHandle(), val.getNativeHandle());
	}

	public List<String> getOverlays() {
		var count = ZenKit.API.ZkNpc_getOverlayCount(getNativeHandle());
		var items = new ArrayList<String>((int) count);

		for (int i = 0; i < count; i++) {
			items.add(ZenKit.API.ZkNpc_getOverlay(getNativeHandle(), i));
		}

		return items;
	}

	public void setOverlays(Iterable<String> val) {
		ZenKit.API.ZkNpc_clearOverlays(getNativeHandle());
		val.forEach(v -> ZenKit.API.ZkNpc_addOverlay(getNativeHandle(), v));
	}

	public void removeOverlay(long i) {
		ZenKit.API.ZkNpc_removeOverlay(getNativeHandle(), i);
	}

	public void addOverlay(String val) {
		ZenKit.API.ZkNpc_addOverlay(getNativeHandle(), val);
	}

	public List<NpcTalent> getTalents() {
		var count = ZenKit.API.ZkNpc_getTalentCount(getNativeHandle());
		var items = new ArrayList<NpcTalent>((int) count);

		for (int i = 0; i < count; i++) {
			items.add(new NpcTalent(ZenKit.API.ZkNpc_getTalent(getNativeHandle(), i)));
		}

		return items;
	}

	public void setTalents(Iterable<NpcTalent> val) {
		ZenKit.API.ZkNpc_clearTalents(getNativeHandle());
		val.forEach(v -> ZenKit.API.ZkNpc_addTalent(getNativeHandle(), v.getNativeHandle()));
	}

	public void removeTalent(long i) {
		ZenKit.API.ZkNpc_removeTalent(getNativeHandle(), i);
	}

	public void addTalent(NpcTalent val) {
		ZenKit.API.ZkNpc_addTalent(getNativeHandle(), val.getNativeHandle());
	}

	public List<Item> getItems() {
		var count = ZenKit.API.ZkNpc_getItemCount(getNativeHandle());
		var items = new ArrayList<Item>((int) count);

		for (int i = 0; i < count; i++) {
			var ptr = ZenKit.API.ZkNpc_getItem(getNativeHandle(), i);
			items.add(new Item(ZenKit.API.ZkObject_takeRef(ptr)));
		}

		return items;
	}

	public void setItems(Iterable<Item> val) {
		ZenKit.API.ZkNpc_clearItems(getNativeHandle());
		val.forEach(v -> ZenKit.API.ZkNpc_addItem(getNativeHandle(), v.getNativeHandle()));
	}

	public void removeItem(long i) {
		ZenKit.API.ZkNpc_removeItem(getNativeHandle(), i);
	}

	public void addItem(Item val) {
		ZenKit.API.ZkNpc_addItem(getNativeHandle(), val.getNativeHandle());
	}

	public List<NpcSlot> getSlots() {
		var count = ZenKit.API.ZkNpc_getSlotCount(getNativeHandle());
		var items = new ArrayList<NpcSlot>((int) count);

		for (int i = 0; i < count; i++) {
			items.add(new NpcSlot(ZenKit.API.ZkNpc_getSlot(getNativeHandle(), i)));
		}

		return items;
	}

	public void clearSlots() {
		ZenKit.API.ZkNpc_clearSlots(getNativeHandle());
	}

	public void removeSlot(long i) {
		ZenKit.API.ZkNpc_removeSlot(getNativeHandle(), i);
	}

	public NpcSlot addSlot() {
		var ptr = ZenKit.API.ZkNpc_addSlot(getNativeHandle());
		return new NpcSlot(ptr);
	}

	public int getProtection(long i) {
		return ZenKit.API.ZkNpc_getProtection(getNativeHandle(), i);
	}

	public int getAttribute(long i) {
		return ZenKit.API.ZkNpc_getAttribute(getNativeHandle(), i);
	}

	public int getHitChance(long i) {
		return ZenKit.API.ZkNpc_getHitChance(getNativeHandle(), i);
	}

	public int getMission(long i) {
		return ZenKit.API.ZkNpc_getMission(getNativeHandle(), i);
	}

	public int[] getAiVars() {
		var len = new LongByReference();
		return ZenKit.API.ZkNpc_getAiVars(getNativeHandle(), len).getIntArray(0, (int) len.getValue());
	}

	public void setAiVars(int[] vars) {
		ZenKit.API.ZkNpc_setAiVars(getNativeHandle(), vars, vars.length);
	}

	public String getPacked(long i) {
		return ZenKit.API.ZkNpc_getPacked(getNativeHandle(), i);
	}

	public void setProtection(int val, long i) {
		ZenKit.API.ZkNpc_setProtection(getNativeHandle(), i, val);
	}

	public void setAttribute(int val, long i) {
		ZenKit.API.ZkNpc_setAttribute(getNativeHandle(), i, val);
	}

	public void setHitChance(int val, long i) {
		ZenKit.API.ZkNpc_setHitChance(getNativeHandle(), i, val);
	}

	public void setMission(int val, long i) {
		ZenKit.API.ZkNpc_setMission(getNativeHandle(), i, val);
	}

	public void setPacked(String val, long i) {
		ZenKit.API.ZkNpc_setPacked(getNativeHandle(), i, val);
	}

	// Missing: NPC news
}

