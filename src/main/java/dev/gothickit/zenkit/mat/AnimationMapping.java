package dev.gothickit.zenkit.mat;

import dev.gothickit.zenkit.utils.EnumNative;

public enum AnimationMapping implements EnumNative<AnimationMapping> {
	NONE(0),
	LINEAR(1);

	private final int value;

	AnimationMapping(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public AnimationMapping getForValue(int i) {
		return switch (i) {
			case 0 -> NONE;
			case 1 -> LINEAR;
			default -> null;
		};
	}
}
