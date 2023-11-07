package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.utils.EnumNative;

public enum CameraLoopType implements EnumNative<CameraLoopType> {
	NONE(0),
	RESTART(1),
	PINGPONG(2),
	;

	private final int value;

	CameraLoopType(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public CameraLoopType getForValue(int i) {
		return switch (i) {
			case 0 -> NONE;
			case 1 -> RESTART;
			case 2 -> PINGPONG;
			default -> null;
		};
	}
}
