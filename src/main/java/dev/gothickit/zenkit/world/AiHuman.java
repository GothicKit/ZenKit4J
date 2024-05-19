package dev.gothickit.zenkit.world;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.world.vob.Npc;
import dev.gothickit.zenkit.world.vob.VirtualObject;

public final class AiHuman extends Ai {
	public AiHuman() {
		super(ZenKit.API.ZkAi_new(AiType.HUMAN));
	}

	AiHuman(Pointer handle) {
		super(handle);
	}

	public float getFloorY() {
		return ZenKit.API.ZkAiHuman_getFloorY(getNativeHandle());
	}

	public void setFloorY(float val) {
		ZenKit.API.ZkAiHuman_setFloorY(getNativeHandle(), val);
	}

	public float getWaterY() {
		return ZenKit.API.ZkAiHuman_getWaterY(getNativeHandle());
	}

	public void setWaterY(float val) {
		ZenKit.API.ZkAiHuman_setWaterY(getNativeHandle(), val);
	}

	public float getCeilY() {
		return ZenKit.API.ZkAiHuman_getCeilY(getNativeHandle());
	}

	public void setCeilY(float val) {
		ZenKit.API.ZkAiHuman_setCeilY(getNativeHandle(), val);
	}

	public float getFeetY() {
		return ZenKit.API.ZkAiHuman_getFeetY(getNativeHandle());
	}

	public void setFeetY(float val) {
		ZenKit.API.ZkAiHuman_setFeetY(getNativeHandle(), val);
	}

	public float getHeadY() {
		return ZenKit.API.ZkAiHuman_getHeadY(getNativeHandle());
	}

	public void setHeadY(float val) {
		ZenKit.API.ZkAiHuman_setHeadY(getNativeHandle(), val);
	}

	public float getFallDistY() {
		return ZenKit.API.ZkAiHuman_getFallDistY(getNativeHandle());
	}

	public void setFallDistY(float val) {
		ZenKit.API.ZkAiHuman_setFallDistY(getNativeHandle(), val);
	}

	public float getFallStartY() {
		return ZenKit.API.ZkAiHuman_getFallStartY(getNativeHandle());
	}

	public void setFallStartY(float val) {
		ZenKit.API.ZkAiHuman_setFallStartY(getNativeHandle(), val);
	}

	public Npc getNpc() {
		var handle = ZenKit.API.ZkAiHuman_getNpc(getNativeHandle());
		return (Npc) VirtualObject.fromNativeHandle(handle);
	}

	public void setNpc(Npc val) {
		ZenKit.API.ZkAiHuman_setNpc(getNativeHandle(), val != null ? val.getNativeHandle() : Pointer.NULL);
	}

	public int getWalkMode() {
		return ZenKit.API.ZkAiHuman_getWalkMode(getNativeHandle());
	}

	public void setWalkMode(int val) {
		ZenKit.API.ZkAiHuman_setWalkMode(getNativeHandle(), val);
	}

	public int getWeaponMode() {
		return ZenKit.API.ZkAiHuman_getWeaponMode(getNativeHandle());
	}

	public void setWeaponMode(int val) {
		ZenKit.API.ZkAiHuman_setWeaponMode(getNativeHandle(), val);
	}

	public int getWmodeAst() {
		return ZenKit.API.ZkAiHuman_getWmodeAst(getNativeHandle());
	}

	public void setWmodeAst(int val) {
		ZenKit.API.ZkAiHuman_setWmodeAst(getNativeHandle(), val);
	}

	public int getWmodeSelect() {
		return ZenKit.API.ZkAiHuman_getWmodeSelect(getNativeHandle());
	}

	public void setWmodeSelect(int val) {
		ZenKit.API.ZkAiHuman_setWmodeSelect(getNativeHandle(), val);
	}

	public boolean getChangeWeapon() {
		return ZenKit.API.ZkAiHuman_getChangeWeapon(getNativeHandle());
	}

	public void setChangeWeapon(boolean val) {
		ZenKit.API.ZkAiHuman_setChangeWeapon(getNativeHandle(), val);
	}

	public int getActionMode() {
		return ZenKit.API.ZkAiHuman_getActionMode(getNativeHandle());
	}

	public void setActionMode(int val) {
		ZenKit.API.ZkAiHuman_setActionMode(getNativeHandle(), val);
	}
}
