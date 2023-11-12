package dev.gothickit.zenkit.daedalus.instance;

import dev.gothickit.zenkit.utils.EnumNative;

public enum MusicTransitionType implements EnumNative<MusicTransitionType> {
	UNKNOWN(0),
	IMMEDIATE(1),
	BEAT(2),
	MEASURE(3),
	;

	private final int value;

	MusicTransitionType(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public MusicTransitionType getForValue(int i) {
		return switch (i) {
			case 0 -> UNKNOWN;
			case 1 -> IMMEDIATE;
			case 2 -> BEAT;
			case 3 -> MEASURE;
			default -> null;
		};
	}
}
