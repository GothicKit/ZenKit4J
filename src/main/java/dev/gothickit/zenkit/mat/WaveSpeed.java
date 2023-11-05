package dev.gothickit.zenkit.mat;

import dev.gothickit.zenkit.utils.EnumNative;

public enum WaveSpeed implements EnumNative<WaveSpeed> {
	NONE(0),
	SLOW(1),
	NORMAL(2),
	FAST(3),
	;

	public final int value;

	WaveSpeed(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public WaveSpeed getForValue(int i) {
		return switch (i) {
			case 0 -> NONE;
			case 1 -> SLOW;
			case 2 -> NORMAL;
			case 3 -> FAST;
			default -> null;
		};
	}
}
