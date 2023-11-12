package dev.gothickit.zenkit.daedalus.instance;

import dev.gothickit.zenkit.utils.EnumNative;

public enum NpcInstanceAttribute implements EnumNative<NpcInstanceAttribute> {
	HITPOINTS(0),
	HITPOINTS_MAX(1),
	MANA(2),
	MANA_MAX(3),
	STRENGTH(4),
	DEXTERITY(5),
	REGENERATE_HP(6),
	REGENERATE_MANA(7),
	;

	private final int value;

	NpcInstanceAttribute(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public NpcInstanceAttribute getForValue(int i) {
		return switch (i) {
			case 0 -> HITPOINTS;
			case 1 -> HITPOINTS_MAX;
			case 2 -> MANA;
			case 3 -> MANA_MAX;
			case 4 -> STRENGTH;
			case 5 -> DEXTERITY;
			case 6 -> REGENERATE_HP;
			case 7 -> REGENERATE_MANA;
			default -> null;
		};
	}
}
