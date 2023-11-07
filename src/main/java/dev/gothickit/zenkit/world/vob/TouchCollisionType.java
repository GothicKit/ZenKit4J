package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.utils.EnumNative;

public enum TouchCollisionType implements EnumNative<TouchCollisionType> {
	NONE(0),
	BOX(1),
	POINT(2),
	;

	private final int value;

	TouchCollisionType(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public TouchCollisionType getForValue(int i) {
		return switch (i) {
			case 0 -> NONE;
			case 1 -> BOX;
			case 2 -> POINT;
			default -> null;
		};
	}
}
