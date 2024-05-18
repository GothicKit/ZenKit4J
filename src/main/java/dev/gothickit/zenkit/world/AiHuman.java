package dev.gothickit.zenkit.world;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.world.vob.Npc;

public class AiHuman extends Ai {
	public AiHuman() {
		super(ZenKit.API.ZkAi_new(AiType.HUMAN));
	}

	protected AiHuman(Pointer handle) {
		super(handle);
	}

	public float getFloorY() {
		return ZenKit.API.ZkAiHuman_getFloorY(getHandle());
	}

	public void setFloorY(float val) {
		ZenKit.API.ZkAiHuman_setFloorY(getHandle(), val);
	}

	public float getWaterY() {
		return ZenKit.API.ZkAiHuman_getWaterY(getHandle());
	}

	public void setWaterY(float val) {
		ZenKit.API.ZkAiHuman_setWaterY(getHandle(), val);
	}

	public float getCeilY() {
		return ZenKit.API.ZkAiHuman_getCeilY(getHandle());
	}

	public void setCeilY(float val) {
		ZenKit.API.ZkAiHuman_setCeilY(getHandle(), val);
	}

	public float getFeetY() {
		return ZenKit.API.ZkAiHuman_getFeetY(getHandle());
	}

	public void setFeetY(float val) {
		ZenKit.API.ZkAiHuman_setFeetY(getHandle(), val);
	}

	public float getHeadY() {
		return ZenKit.API.ZkAiHuman_getHeadY(getHandle());
	}

	public void setHeadY(float val) {
		ZenKit.API.ZkAiHuman_setHeadY(getHandle(), val);
	}

	public float getFallDistY() {
		return ZenKit.API.ZkAiHuman_getFallDistY(getHandle());
	}

	public void setFallDistY(float val) {
		ZenKit.API.ZkAiHuman_setFallDistY(getHandle(), val);
	}

	public float getFallStartY() {
		return ZenKit.API.ZkAiHuman_getFallStartY(getHandle());
	}

	public void setFallStartY(float val) {
		ZenKit.API.ZkAiHuman_setFallStartY(getHandle(), val);
	}

	public Npc getNpc() {
		var handle = ZenKit.API.ZkAiHuman_getNpc(getHandle());
		if (handle == Pointer.NULL) {
			return null;
		}
		return new Npc(ZenKit.API.ZkObject_takeRef(handle));
	}

	public void setNpc(Npc val) {
		ZenKit.API.ZkAiHuman_setNpc(getHandle(), val != null ? val.getHandle() : Pointer.NULL);
	}

	public int getWalkMode() {
		return ZenKit.API.ZkAiHuman_getWalkMode(getHandle());
	}

	public void setWalkMode(int val) {
		ZenKit.API.ZkAiHuman_setWalkMode(getHandle(), val);
	}

	public int getWeaponMode() {
		return ZenKit.API.ZkAiHuman_getWeaponMode(getHandle());
	}

	public void setWeaponMode(int val) {
		ZenKit.API.ZkAiHuman_setWeaponMode(getHandle(), val);
	}

	public int getWmodeAst() {
		return ZenKit.API.ZkAiHuman_getWmodeAst(getHandle());
	}

	public void setWmodeAst(int val) {
		ZenKit.API.ZkAiHuman_setWmodeAst(getHandle(), val);
	}

	public int getWmodeSelect() {
		return ZenKit.API.ZkAiHuman_getWmodeSelect(getHandle());
	}

	public void setWmodeSelect(int val) {
		ZenKit.API.ZkAiHuman_setWmodeSelect(getHandle(), val);
	}

	public boolean getChangeWeapon() {
		return ZenKit.API.ZkAiHuman_getChangeWeapon(getHandle());
	}

	public void setChangeWeapon(boolean val) {
		ZenKit.API.ZkAiHuman_setChangeWeapon(getHandle(), val);
	}

	public int getActionMode() {
		return ZenKit.API.ZkAiHuman_getActionMode(getHandle());
	}

	public void setActionMode(int val) {
		ZenKit.API.ZkAiHuman_setActionMode(getHandle(), val);
	}
}
