package dev.gothickit.zenkit.daedalus.instance;

import dev.gothickit.zenkit.utils.EnumNative;

public enum DamageType implements EnumNative<DamageType> {
	BARRIER(0),
	BLUNT(1),
	EDGE(2),
	FIRE(3),
	FLY(4),
	MAGIC(5),
	POINT(6),
	FALL(7),
	;

	private final int value;

	DamageType(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public DamageType getForValue(int i) {
		return switch (i) {
			case 0 -> BARRIER;
			case 1 -> BLUNT;
			case 2 -> EDGE;
			case 3 -> FIRE;
			case 4 -> FLY;
			case 5 -> MAGIC;
			case 6 -> POINT;
			case 7 -> FALL;
			default -> null;
		};
	}
}
