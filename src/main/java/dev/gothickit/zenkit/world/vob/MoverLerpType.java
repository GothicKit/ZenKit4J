package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.utils.EnumNative;

public enum MoverLerpType implements EnumNative<MoverLerpType> {
	CURVE(0),
	LINEAR(1),
	;

	private final int value;

	MoverLerpType(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public MoverLerpType getForValue(int i) {
		return switch (i) {
			case 0 -> CURVE;
			case 1 -> LINEAR;
			default -> null;
		};
	}
}
