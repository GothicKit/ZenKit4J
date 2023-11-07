package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.utils.EnumNative;

public enum AnimationType implements EnumNative<AnimationType> {
	NONE(0),
	WIND(1),
	WIND_ALT(2),
	;

	public final int value;

	AnimationType(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public AnimationType getForValue(int i) {
		return switch (i) {
			case 0 -> NONE;
			case 1 -> WIND;
			case 2 -> WIND_ALT;
			default -> null;
		};
	}
}
