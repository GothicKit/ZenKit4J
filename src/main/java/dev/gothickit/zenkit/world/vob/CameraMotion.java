package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.utils.EnumNative;

public enum CameraMotion implements EnumNative<CameraMotion> {
	UNDEFINED(0),
	SMOOTH(1),
	LINEAR(2),
	STEP(3),
	SLOW(4),
	FAST(5),
	CUSTOM(6),
	;

	private final int value;

	CameraMotion(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public CameraMotion getForValue(int i) {
		return switch (i) {
			case 0 -> UNDEFINED;
			case 1 -> SMOOTH;
			case 2 -> LINEAR;
			case 3 -> STEP;
			case 4 -> SLOW;
			case 5 -> FAST;
			case 6 -> CUSTOM;
			default -> null;
		};
	}
}
