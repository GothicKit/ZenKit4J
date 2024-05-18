package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.LongByReference;
import dev.gothickit.zenkit.Vec3f;
import dev.gothickit.zenkit.capi.ZenKit;

import java.util.ArrayList;
import java.util.List;

public class Npc extends VirtualObject {
	public Npc() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.oCNpc));
	}

	public Npc(Pointer handle) {
		super(handle);
	}

	public String getNpcInstance() {
		return ZenKit.API.ZkNpc_getNpcInstance(getHandle());
	}

	public void setNpcInstance(String val) {
		ZenKit.API.ZkNpc_setNpcInstance(getHandle(), val);
	}

	public Vec3f getModelScale() {
		return ZenKit.API.ZkNpc_getModelScale(getHandle());
	}

	public void setModelScale(Vec3f val) {
		ZenKit.API.ZkNpc_setModelScale(getHandle(), val);
	}

	public float getModelFatness() {
		return ZenKit.API.ZkNpc_getModelFatness(getHandle());
	}

	public void setModelFatness(float val) {
		ZenKit.API.ZkNpc_setModelFatness(getHandle(), val);
	}

	public int getFlags() {
		return ZenKit.API.ZkNpc_getFlags(getHandle());
	}

	public void setFlags(int val) {
		ZenKit.API.ZkNpc_setFlags(getHandle(), val);
	}

	public int getGuild() {
		return ZenKit.API.ZkNpc_getGuild(getHandle());
	}

	public void setGuild(int val) {
		ZenKit.API.ZkNpc_setGuild(getHandle(), val);
	}

	public int getGuildTrue() {
		return ZenKit.API.ZkNpc_getGuildTrue(getHandle());
	}

	public void setGuildTrue(int val) {
		ZenKit.API.ZkNpc_setGuildTrue(getHandle(), val);
	}

	public int getLevel() {
		return ZenKit.API.ZkNpc_getLevel(getHandle());
	}

	public void setLevel(int val) {
		ZenKit.API.ZkNpc_setLevel(getHandle(), val);
	}

	public int getXp() {
		return ZenKit.API.ZkNpc_getXp(getHandle());
	}

	public void setXp(int val) {
		ZenKit.API.ZkNpc_setXp(getHandle(), val);
	}

	public int getXpNextLevel() {
		return ZenKit.API.ZkNpc_getXpNextLevel(getHandle());
	}

	public void setXpNextLevel(int val) {
		ZenKit.API.ZkNpc_setXpNextLevel(getHandle(), val);
	}

	public int getLp() {
		return ZenKit.API.ZkNpc_getLp(getHandle());
	}

	public void setLp(int val) {
		ZenKit.API.ZkNpc_setLp(getHandle(), val);
	}

	public int getFightTactic() {
		return ZenKit.API.ZkNpc_getFightTactic(getHandle());
	}

	public void setFightTactic(int val) {
		ZenKit.API.ZkNpc_setFightTactic(getHandle(), val);
	}

	public int getFightMode() {
		return ZenKit.API.ZkNpc_getFightMode(getHandle());
	}

	public void setFightMode(int val) {
		ZenKit.API.ZkNpc_setFightMode(getHandle(), val);
	}

	public boolean getWounded() {
		return ZenKit.API.ZkNpc_getWounded(getHandle());
	}

	public void setWounded(boolean val) {
		ZenKit.API.ZkNpc_setWounded(getHandle(), val);
	}

	public boolean getMad() {
		return ZenKit.API.ZkNpc_getMad(getHandle());
	}

	public void setMad(boolean val) {
		ZenKit.API.ZkNpc_setMad(getHandle(), val);
	}

	public int getMadTime() {
		return ZenKit.API.ZkNpc_getMadTime(getHandle());
	}

	public void setMadTime(int val) {
		ZenKit.API.ZkNpc_setMadTime(getHandle(), val);
	}

	public boolean getPlayer() {
		return ZenKit.API.ZkNpc_getPlayer(getHandle());
	}

	public void setPlayer(boolean val) {
		ZenKit.API.ZkNpc_setPlayer(getHandle(), val);
	}

	public String getStartAiState() {
		return ZenKit.API.ZkNpc_getStartAiState(getHandle());
	}

	public void setStartAiState(String val) {
		ZenKit.API.ZkNpc_setStartAiState(getHandle(), val);
	}

	public String getScriptWaypoint() {
		return ZenKit.API.ZkNpc_getScriptWaypoint(getHandle());
	}

	public void setScriptWaypoint(String val) {
		ZenKit.API.ZkNpc_setScriptWaypoint(getHandle(), val);
	}

	public int getAttitude() {
		return ZenKit.API.ZkNpc_getAttitude(getHandle());
	}

	public void setAttitude(int val) {
		ZenKit.API.ZkNpc_setAttitude(getHandle(), val);
	}

	public int getAttitudeTemp() {
		return ZenKit.API.ZkNpc_getAttitudeTemp(getHandle());
	}

	public void setAttitudeTemp(int val) {
		ZenKit.API.ZkNpc_setAttitudeTemp(getHandle(), val);
	}

	public int getNameNr() {
		return ZenKit.API.ZkNpc_getNameNr(getHandle());
	}

	public void setNameNr(int val) {
		ZenKit.API.ZkNpc_setNameNr(getHandle(), val);
	}

	public boolean getMoveLock() {
		return ZenKit.API.ZkNpc_getMoveLock(getHandle());
	}

	public void setMoveLock(boolean val) {
		ZenKit.API.ZkNpc_setMoveLock(getHandle(), val);
	}

	public boolean getCurrentStateValid() {
		return ZenKit.API.ZkNpc_getCurrentStateValid(getHandle());
	}

	public void setCurrentStateValid(boolean val) {
		ZenKit.API.ZkNpc_setCurrentStateValid(getHandle(), val);
	}

	public String getCurrentStateName() {
		return ZenKit.API.ZkNpc_getCurrentStateName(getHandle());
	}

	public void setCurrentStateName(String val) {
		ZenKit.API.ZkNpc_setCurrentStateName(getHandle(), val);
	}

	public int getCurrentStateIndex() {
		return ZenKit.API.ZkNpc_getCurrentStateIndex(getHandle());
	}

	public void setCurrentStateIndex(int val) {
		ZenKit.API.ZkNpc_setCurrentStateIndex(getHandle(), val);
	}

	public boolean getCurrentStateIsRoutine() {
		return ZenKit.API.ZkNpc_getCurrentStateIsRoutine(getHandle());
	}

	public void setCurrentStateIsRoutine(boolean val) {
		ZenKit.API.ZkNpc_setCurrentStateIsRoutine(getHandle(), val);
	}

	public boolean getNextStateValid() {
		return ZenKit.API.ZkNpc_getNextStateValid(getHandle());
	}

	public void setNextStateValid(boolean val) {
		ZenKit.API.ZkNpc_setNextStateValid(getHandle(), val);
	}

	public String getNextStateName() {
		return ZenKit.API.ZkNpc_getNextStateName(getHandle());
	}

	public void setNextStateName(String val) {
		ZenKit.API.ZkNpc_setNextStateName(getHandle(), val);
	}

	public int getNextStateIndex() {
		return ZenKit.API.ZkNpc_getNextStateIndex(getHandle());
	}

	public void setNextStateIndex(int val) {
		ZenKit.API.ZkNpc_setNextStateIndex(getHandle(), val);
	}

	public boolean getNextStateIsRoutine() {
		return ZenKit.API.ZkNpc_getNextStateIsRoutine(getHandle());
	}

	public void setNextStateIsRoutine(boolean val) {
		ZenKit.API.ZkNpc_setNextStateIsRoutine(getHandle(), val);
	}

	public int getLastAiState() {
		return ZenKit.API.ZkNpc_getLastAiState(getHandle());
	}

	public void setLastAiState(int val) {
		ZenKit.API.ZkNpc_setLastAiState(getHandle(), val);
	}

	public boolean getHasRoutine() {
		return ZenKit.API.ZkNpc_getHasRoutine(getHandle());
	}

	public void setHasRoutine(boolean val) {
		ZenKit.API.ZkNpc_setHasRoutine(getHandle(), val);
	}

	public boolean getRoutineChanged() {
		return ZenKit.API.ZkNpc_getRoutineChanged(getHandle());
	}

	public void setRoutineChanged(boolean val) {
		ZenKit.API.ZkNpc_setRoutineChanged(getHandle(), val);
	}

	public boolean getRoutineOverlay() {
		return ZenKit.API.ZkNpc_getRoutineOverlay(getHandle());
	}

	public void setRoutineOverlay(boolean val) {
		ZenKit.API.ZkNpc_setRoutineOverlay(getHandle(), val);
	}

	public int getRoutineOverlayCount() {
		return ZenKit.API.ZkNpc_getRoutineOverlayCount(getHandle());
	}

	public void setRoutineOverlayCount(int val) {
		ZenKit.API.ZkNpc_setRoutineOverlayCount(getHandle(), val);
	}

	public int getWalkmodeRoutine() {
		return ZenKit.API.ZkNpc_getWalkmodeRoutine(getHandle());
	}

	public void setWalkmodeRoutine(int val) {
		ZenKit.API.ZkNpc_setWalkmodeRoutine(getHandle(), val);
	}

	public boolean getWeaponmodeRoutine() {
		return ZenKit.API.ZkNpc_getWeaponmodeRoutine(getHandle());
	}

	public void setWeaponmodeRoutine(boolean val) {
		ZenKit.API.ZkNpc_setWeaponmodeRoutine(getHandle(), val);
	}

	public boolean getStartNewRoutine() {
		return ZenKit.API.ZkNpc_getStartNewRoutine(getHandle());
	}

	public void setStartNewRoutine(boolean val) {
		ZenKit.API.ZkNpc_setStartNewRoutine(getHandle(), val);
	}

	public int getAiStateDriven() {
		return ZenKit.API.ZkNpc_getAiStateDriven(getHandle());
	}

	public void setAiStateDriven(int val) {
		ZenKit.API.ZkNpc_setAiStateDriven(getHandle(), val);
	}

	public Vec3f getAiStatePos() {
		return ZenKit.API.ZkNpc_getAiStatePos(getHandle());
	}

	public void setAiStatePos(Vec3f val) {
		ZenKit.API.ZkNpc_setAiStatePos(getHandle(), val);
	}

	public String getCurrentRoutine() {
		return ZenKit.API.ZkNpc_getCurrentRoutine(getHandle());
	}

	public void setCurrentRoutine(String val) {
		ZenKit.API.ZkNpc_setCurrentRoutine(getHandle(), val);
	}

	public boolean getRespawn() {
		return ZenKit.API.ZkNpc_getRespawn(getHandle());
	}

	public void setRespawn(boolean val) {
		ZenKit.API.ZkNpc_setRespawn(getHandle(), val);
	}

	public int getRespawnTime() {
		return ZenKit.API.ZkNpc_getRespawnTime(getHandle());
	}

	public void setRespawnTime(int val) {
		ZenKit.API.ZkNpc_setRespawnTime(getHandle(), val);
	}

	public int getBsInterruptableOverride() {
		return ZenKit.API.ZkNpc_getBsInterruptableOverride(getHandle());
	}

	public void setBsInterruptableOverride(int val) {
		ZenKit.API.ZkNpc_setBsInterruptableOverride(getHandle(), val);
	}

	public int getNpcType() {
		return ZenKit.API.ZkNpc_getNpcType(getHandle());
	}

	public void setNpcType(int val) {
		ZenKit.API.ZkNpc_setNpcType(getHandle(), val);
	}

	public int getSpellMana() {
		return ZenKit.API.ZkNpc_getSpellMana(getHandle());
	}

	public void setSpellMana(int val) {
		ZenKit.API.ZkNpc_setSpellMana(getHandle(), val);
	}

	public VirtualObject getCarryVob() {
		var ptr = ZenKit.API.ZkNpc_getCarryVob(getHandle());
		return VirtualObject.fromNative(ptr);
	}

	public VirtualObject getEnemy() {
		var ptr = ZenKit.API.ZkNpc_getEnemy(getHandle());
		return VirtualObject.fromNative(ptr);
	}

	public void getCarryVob(VirtualObject val) {
		ZenKit.API.ZkNpc_setCarryVob(getHandle(), val.getHandle());
	}

	public void getEnemy(VirtualObject val) {
		ZenKit.API.ZkNpc_setEnemy(getHandle(), val.getHandle());
	}

	public List<String> getOverlays() {
		var count = ZenKit.API.ZkNpc_getOverlayCount(getHandle());
		var items = new ArrayList<String>((int) count);

		for (int i = 0; i < count; i++) {
			items.add(ZenKit.API.ZkNpc_getOverlay(getHandle(), i));
		}

		return items;
	}

	public void setOverlays(Iterable<String> val) {
		ZenKit.API.ZkNpc_clearOverlays(getHandle());
		val.forEach(v -> ZenKit.API.ZkNpc_addOverlay(getHandle(), v));
	}

	public void removeOverlay(long i) {
		ZenKit.API.ZkNpc_removeOverlay(getHandle(), i);
	}

	public void addOverlay(String val) {
		ZenKit.API.ZkNpc_addOverlay(getHandle(), val);
	}

	public List<NpcTalent> getTalents() {
		var count = ZenKit.API.ZkNpc_getTalentCount(getHandle());
		var items = new ArrayList<NpcTalent>((int) count);

		for (int i = 0; i < count; i++) {
			items.add(new NpcTalent(ZenKit.API.ZkNpc_getTalent(getHandle(), i)));
		}

		return items;
	}

	public void setTalents(Iterable<NpcTalent> val) {
		ZenKit.API.ZkNpc_clearTalents(getHandle());
		val.forEach(v -> ZenKit.API.ZkNpc_addTalent(getHandle(), v.getHandle()));
	}

	public void removeTalent(long i) {
		ZenKit.API.ZkNpc_removeTalent(getHandle(), i);
	}

	public void addTalent(NpcTalent val) {
		ZenKit.API.ZkNpc_addTalent(getHandle(), val.getHandle());
	}

	public List<Item> getItems() {
		var count = ZenKit.API.ZkNpc_getItemCount(getHandle());
		var items = new ArrayList<Item>((int) count);

		for (int i = 0; i < count; i++) {
			var ptr = ZenKit.API.ZkNpc_getItem(getHandle(), i);
			items.add(new Item(ZenKit.API.ZkObject_takeRef(ptr)));
		}

		return items;
	}

	public void setItems(Iterable<Item> val) {
		ZenKit.API.ZkNpc_clearItems(getHandle());
		val.forEach(v -> ZenKit.API.ZkNpc_addItem(getHandle(), v.getHandle()));
	}

	public void removeItem(long i) {
		ZenKit.API.ZkNpc_removeItem(getHandle(), i);
	}

	public void addItem(Item val) {
		ZenKit.API.ZkNpc_addItem(getHandle(), val.getHandle());
	}

	public List<NpcSlot> getSlots() {
		var count = ZenKit.API.ZkNpc_getSlotCount(getHandle());
		var items = new ArrayList<NpcSlot>((int) count);

		for (int i = 0; i < count; i++) {
			items.add(new NpcSlot(ZenKit.API.ZkNpc_getSlot(getHandle(), i)));
		}

		return items;
	}

	public void clearSlots() {
		ZenKit.API.ZkNpc_clearSlots(getHandle());
	}

	public void removeSlot(long i) {
		ZenKit.API.ZkNpc_removeSlot(getHandle(), i);
	}

	public NpcSlot addSlot() {
		var ptr = ZenKit.API.ZkNpc_addSlot(getHandle());
		return new NpcSlot(ptr);
	}

	public int getProtection(long i) {
		return ZenKit.API.ZkNpc_getProtection(getHandle(), i);
	}

	public int getAttribute(long i) {
		return ZenKit.API.ZkNpc_getAttribute(getHandle(), i);
	}

	public int getHitChance(long i) {
		return ZenKit.API.ZkNpc_getHitChance(getHandle(), i);
	}

	public int getMission(long i) {
		return ZenKit.API.ZkNpc_getMission(getHandle(), i);
	}

	public int[] getAiVars() {
		var len = new LongByReference();
		return ZenKit.API.ZkNpc_getAiVars(getHandle(), len).getIntArray(0, (int) len.getValue());
	}

	public void setAiVars(int[] vars) {
		ZenKit.API.ZkNpc_setAiVars(getHandle(), vars, vars.length);
	}

	public String getPacked(long i) {
		return ZenKit.API.ZkNpc_getPacked(getHandle(), i);
	}

	public void setProtection(int val, long i) {
		ZenKit.API.ZkNpc_setProtection(getHandle(), i, val);
	}

	public void setAttribute(int val, long i) {
		ZenKit.API.ZkNpc_setAttribute(getHandle(), i, val);
	}

	public void setHitChance(int val, long i) {
		ZenKit.API.ZkNpc_setHitChance(getHandle(), i, val);
	}

	public void setMission(int val, long i) {
		ZenKit.API.ZkNpc_setMission(getHandle(), i, val);
	}

	public void setPacked(String val, long i) {
		ZenKit.API.ZkNpc_setPacked(getHandle(), i, val);
	}

	// Missing: NPC news
}

