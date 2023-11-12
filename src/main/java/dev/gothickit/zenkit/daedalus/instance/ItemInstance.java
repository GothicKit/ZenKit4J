package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public class ItemInstance extends DaedalusInstance {
	public ItemInstance(Pointer handle) {
		super(handle);
	}

	public int getId() {
		return ZenKit.API.ZkItemInstance_getId(getHandle());
	}

	public String getName() {
		return ZenKit.API.ZkItemInstance_getName(getHandle());
	}

	public String getNameId() {
		return ZenKit.API.ZkItemInstance_getNameId(getHandle());
	}

	public int getHp() {
		return ZenKit.API.ZkItemInstance_getHp(getHandle());
	}

	public int getHpMax() {
		return ZenKit.API.ZkItemInstance_getHpMax(getHandle());
	}

	public int getMainFlag() {
		return ZenKit.API.ZkItemInstance_getMainFlag(getHandle());
	}

	public int getFlags() {
		return ZenKit.API.ZkItemInstance_getFlags(getHandle());
	}

	public int getWeight() {
		return ZenKit.API.ZkItemInstance_getWeight(getHandle());
	}

	public int getValue() {
		return ZenKit.API.ZkItemInstance_getValue(getHandle());
	}

	public int getDamageType() {
		return ZenKit.API.ZkItemInstance_getDamageType(getHandle());
	}

	public int getDamageTotal() {
		return ZenKit.API.ZkItemInstance_getDamageTotal(getHandle());
	}

	public int getWear() {
		return ZenKit.API.ZkItemInstance_getWear(getHandle());
	}

	public int getNutrition() {
		return ZenKit.API.ZkItemInstance_getNutrition(getHandle());
	}

	public int getMagic() {
		return ZenKit.API.ZkItemInstance_getMagic(getHandle());
	}

	public int getOnEquip() {
		return ZenKit.API.ZkItemInstance_getOnEquip(getHandle());
	}

	public int getOnUnequip() {
		return ZenKit.API.ZkItemInstance_getOnUnequip(getHandle());
	}

	public int getOwner() {
		return ZenKit.API.ZkItemInstance_getOwner(getHandle());
	}

	public int getOwnerGuild() {
		return ZenKit.API.ZkItemInstance_getOwnerGuild(getHandle());
	}

	public int getDisguiseGuild() {
		return ZenKit.API.ZkItemInstance_getDisguiseGuild(getHandle());
	}

	public String getVisual() {
		return ZenKit.API.ZkItemInstance_getVisual(getHandle());
	}

	public String getVisualChange() {
		return ZenKit.API.ZkItemInstance_getVisualChange(getHandle());
	}

	public String getEffect() {
		return ZenKit.API.ZkItemInstance_getEffect(getHandle());
	}

	public int getVisualSkin() {
		return ZenKit.API.ZkItemInstance_getVisualSkin(getHandle());
	}

	public String getSchemeName() {
		return ZenKit.API.ZkItemInstance_getSchemeName(getHandle());
	}

	public int getMaterial() {
		return ZenKit.API.ZkItemInstance_getMaterial(getHandle());
	}

	public int getMunition() {
		return ZenKit.API.ZkItemInstance_getMunition(getHandle());
	}

	public int getSpell() {
		return ZenKit.API.ZkItemInstance_getSpell(getHandle());
	}

	public int getRange() {
		return ZenKit.API.ZkItemInstance_getRange(getHandle());
	}

	public int getMagCircle() {
		return ZenKit.API.ZkItemInstance_getMagCircle(getHandle());
	}

	public String getDescription() {
		return ZenKit.API.ZkItemInstance_getDescription(getHandle());
	}

	public int getInvZBias() {
		return ZenKit.API.ZkItemInstance_getInvZBias(getHandle());
	}

	public int getInvRotX() {
		return ZenKit.API.ZkItemInstance_getInvRotX(getHandle());
	}

	public int getInvRotY() {
		return ZenKit.API.ZkItemInstance_getInvRotY(getHandle());
	}

	public int getInvRotZ() {
		return ZenKit.API.ZkItemInstance_getInvRotZ(getHandle());
	}

	public int getInvAnimate() {
		return ZenKit.API.ZkItemInstance_getInvAnimate(getHandle());
	}

	public int getDamage(DamageType type) {
		return ZenKit.API.ZkItemInstance_getDamage(getHandle(), type);
	}

	public int getProtection(DamageType type) {
		return ZenKit.API.ZkItemInstance_getProtection(getHandle(), type);
	}

	public int getCondAtr(ItemInstanceConditionSlot slot) {
		return ZenKit.API.ZkItemInstance_getCondAtr(getHandle(), slot);
	}

	public int getCondValue(ItemInstanceConditionSlot slot) {
		return ZenKit.API.ZkItemInstance_getCondValue(getHandle(), slot);
	}

	public int getChangeAtr(ItemInstanceConditionSlot slot) {
		return ZenKit.API.ZkItemInstance_getChangeAtr(getHandle(), slot);
	}

	public int getChangeValue(ItemInstanceConditionSlot slot) {
		return ZenKit.API.ZkItemInstance_getChangeValue(getHandle(), slot);
	}

	public int getOnState(ItemInstanceStateSlot slot) {
		return ZenKit.API.ZkItemInstance_getOnState(getHandle(), slot);
	}

	public String getText(ItemInstanceTextSlot slot) {
		return ZenKit.API.ZkItemInstance_getText(getHandle(), slot);
	}

	public int getCount(ItemInstanceTextSlot slot) {
		return ZenKit.API.ZkItemInstance_getCount(getHandle(), slot);
	}
}
