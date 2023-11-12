package dev.gothickit.zenkit.daedalus.instance;

import dev.gothickit.zenkit.utils.EnumNative;

public enum NpcInstanceTalent implements EnumNative<NpcInstanceTalent> {
	UNKNOWN(0),
	ONE_HANDED(1),
	TWO_HANDED(2),
	BOW(3),
	CROSSBOW(4),
	;

	private final int value;

	NpcInstanceTalent(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public NpcInstanceTalent getForValue(int i) {
		return switch (i) {
			case 0 -> UNKNOWN;
			case 1 -> ONE_HANDED;
			case 2 -> TWO_HANDED;
			case 3 -> BOW;
			case 4 -> CROSSBOW;
			default -> null;
		};
	}
}
