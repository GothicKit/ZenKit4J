package dev.gothickit.zenkit.mds;

import dev.gothickit.zenkit.utils.EnumNative;

public enum AnimationDirection implements EnumNative<AnimationDirection> {
	FORWARD(0),
	BACKWARD(1),
	;

	private final int value;

	AnimationDirection(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public AnimationDirection getForValue(int i) {
		return switch (i) {
			case 0 -> FORWARD;
			case 1 -> BACKWARD;
			default -> null;
		};
	}
}
