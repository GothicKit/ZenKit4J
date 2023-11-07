package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.utils.EnumNative;

public enum CameraLerpType implements EnumNative<CameraLerpType> {
	UNDEFINED(0),
	PATH(1),
	PATH_IGNORE_ROLL(2),
	PATH_ROTATION_SAMPLES(3),
	;

	private final int value;

	CameraLerpType(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public CameraLerpType getForValue(int i) {
		return switch (i) {
			case 0 -> UNDEFINED;
			case 1 -> PATH;
			case 2 -> PATH_IGNORE_ROLL;
			case 3 -> PATH_ROTATION_SAMPLES;
			default -> null;
		};
	}
}
