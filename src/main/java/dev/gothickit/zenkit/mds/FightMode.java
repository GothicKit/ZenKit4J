package dev.gothickit.zenkit.mds;

import dev.gothickit.zenkit.utils.EnumNative;

public enum FightMode implements EnumNative<FightMode> {
	FIST(0),
	SINGLE_HANDED(1),
	DUAL_HANDED(2),
	BOW(3),
	CROSSBOW(4),
	MAGIC(5),
	NONE(6),
	INVALID(0xFF),
	;

	private final int value;

	FightMode(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public FightMode getForValue(int i) {
		return switch (i) {
			case 0 -> FIST;
			case 1 -> SINGLE_HANDED;
			case 2 -> DUAL_HANDED;
			case 3 -> BOW;
			case 4 -> CROSSBOW;
			case 5 -> MAGIC;
			case 6 -> NONE;
			case 0xFF -> INVALID;
			default -> null;
		};
	}
}
