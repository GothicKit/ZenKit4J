package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.utils.EnumNative;

public enum LightType implements EnumNative<LightType> {
	POINT(0),
	SPOT(1),
	RESERVED0(2),
	RESERVED1(3),
	;

	public final int value;

	LightType(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public LightType getForValue(int i) {
		return switch (i) {
			case 0 -> POINT;
			case 1 -> SPOT;
			case 2 -> RESERVED0;
			case 3 -> RESERVED1;
			default -> null;
		};
	}
}
