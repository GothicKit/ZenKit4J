package dev.gothickit.zenkit.mat;

import dev.gothickit.zenkit.utils.EnumNative;

public enum AlphaFunction implements EnumNative<AlphaFunction> {
	DEFAULT(0),
	NONE(1),
	BLEND(2),
	ADD(3),
	SUBTRACT(4),
	MULTIPLY(5),
	MULTIPLY_ALT(6),
	;

	public final int value;

	AlphaFunction(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public AlphaFunction getForValue(int i) {
		return switch (i) {
			case 0 -> DEFAULT;
			case 1 -> NONE;
			case 2 -> BLEND;
			case 3 -> ADD;
			case 4 -> SUBTRACT;
			case 5 -> MULTIPLY;
			case 6 -> MULTIPLY_ALT;
			default -> null;
		};
	}
}
