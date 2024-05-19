package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public final class ItemInstance extends DaedalusInstance {
	public ItemInstance(Pointer handle) {
		super(handle);
	}

	public int getId() {
		return ZenKit.API.ZkItemInstance_getId(getNativeHandle());
	}

	public String getName() {
		return ZenKit.API.ZkItemInstance_getName(getNativeHandle());
	}

	public String getNameId() {
		return ZenKit.API.ZkItemInstance_getNameId(getNativeHandle());
	}

	public int getHp() {
		return ZenKit.API.ZkItemInstance_getHp(getNativeHandle());
	}

	public int getHpMax() {
		return ZenKit.API.ZkItemInstance_getHpMax(getNativeHandle());
	}

	public int getMainFlag() {
		return ZenKit.API.ZkItemInstance_getMainFlag(getNativeHandle());
	}

	public int getFlags() {
		return ZenKit.API.ZkItemInstance_getFlags(getNativeHandle());
	}

	public int getWeight() {
		return ZenKit.API.ZkItemInstance_getWeight(getNativeHandle());
	}

	public int getValue() {
		return ZenKit.API.ZkItemInstance_getValue(getNativeHandle());
	}

	public int getDamageType() {
		return ZenKit.API.ZkItemInstance_getDamageType(getNativeHandle());
	}

	public int getDamageTotal() {
		return ZenKit.API.ZkItemInstance_getDamageTotal(getNativeHandle());
	}

	public int getWear() {
		return ZenKit.API.ZkItemInstance_getWear(getNativeHandle());
	}

	public int getNutrition() {
		return ZenKit.API.ZkItemInstance_getNutrition(getNativeHandle());
	}

	public int getMagic() {
		return ZenKit.API.ZkItemInstance_getMagic(getNativeHandle());
	}

	public int getOnEquip() {
		return ZenKit.API.ZkItemInstance_getOnEquip(getNativeHandle());
	}

	public int getOnUnequip() {
		return ZenKit.API.ZkItemInstance_getOnUnequip(getNativeHandle());
	}

	public int getOwner() {
		return ZenKit.API.ZkItemInstance_getOwner(getNativeHandle());
	}

	public int getOwnerGuild() {
		return ZenKit.API.ZkItemInstance_getOwnerGuild(getNativeHandle());
	}

	public int getDisguiseGuild() {
		return ZenKit.API.ZkItemInstance_getDisguiseGuild(getNativeHandle());
	}

	public String getVisual() {
		return ZenKit.API.ZkItemInstance_getVisual(getNativeHandle());
	}

	public String getVisualChange() {
		return ZenKit.API.ZkItemInstance_getVisualChange(getNativeHandle());
	}

	public String getEffect() {
		return ZenKit.API.ZkItemInstance_getEffect(getNativeHandle());
	}

	public int getVisualSkin() {
		return ZenKit.API.ZkItemInstance_getVisualSkin(getNativeHandle());
	}

	public String getSchemeName() {
		return ZenKit.API.ZkItemInstance_getSchemeName(getNativeHandle());
	}

	public int getMaterial() {
		return ZenKit.API.ZkItemInstance_getMaterial(getNativeHandle());
	}

	public int getMunition() {
		return ZenKit.API.ZkItemInstance_getMunition(getNativeHandle());
	}

	public int getSpell() {
		return ZenKit.API.ZkItemInstance_getSpell(getNativeHandle());
	}

	public int getRange() {
		return ZenKit.API.ZkItemInstance_getRange(getNativeHandle());
	}

	public int getMagCircle() {
		return ZenKit.API.ZkItemInstance_getMagCircle(getNativeHandle());
	}

	public String getDescription() {
		return ZenKit.API.ZkItemInstance_getDescription(getNativeHandle());
	}

	public int getInvZBias() {
		return ZenKit.API.ZkItemInstance_getInvZBias(getNativeHandle());
	}

	public int getInvRotX() {
		return ZenKit.API.ZkItemInstance_getInvRotX(getNativeHandle());
	}

	public int getInvRotY() {
		return ZenKit.API.ZkItemInstance_getInvRotY(getNativeHandle());
	}

	public int getInvRotZ() {
		return ZenKit.API.ZkItemInstance_getInvRotZ(getNativeHandle());
	}

	public int getInvAnimate() {
		return ZenKit.API.ZkItemInstance_getInvAnimate(getNativeHandle());
	}

	public int getDamage(DamageType type) {
		return ZenKit.API.ZkItemInstance_getDamage(getNativeHandle(), type);
	}

	public int getProtection(DamageType type) {
		return ZenKit.API.ZkItemInstance_getProtection(getNativeHandle(), type);
	}

	public int getCondAtr(ItemInstanceConditionSlot slot) {
		return ZenKit.API.ZkItemInstance_getCondAtr(getNativeHandle(), slot);
	}

	public int getCondValue(ItemInstanceConditionSlot slot) {
		return ZenKit.API.ZkItemInstance_getCondValue(getNativeHandle(), slot);
	}

	public int getChangeAtr(ItemInstanceConditionSlot slot) {
		return ZenKit.API.ZkItemInstance_getChangeAtr(getNativeHandle(), slot);
	}

	public int getChangeValue(ItemInstanceConditionSlot slot) {
		return ZenKit.API.ZkItemInstance_getChangeValue(getNativeHandle(), slot);
	}

	public int getOnState(ItemInstanceStateSlot slot) {
		return ZenKit.API.ZkItemInstance_getOnState(getNativeHandle(), slot);
	}

	public String getText(ItemInstanceTextSlot slot) {
		return ZenKit.API.ZkItemInstance_getText(getNativeHandle(), slot);
	}

	public int getCount(ItemInstanceTextSlot slot) {
		return ZenKit.API.ZkItemInstance_getCount(getNativeHandle(), slot);
	}
}
