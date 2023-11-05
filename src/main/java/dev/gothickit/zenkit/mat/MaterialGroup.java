package dev.gothickit.zenkit.mat;

import dev.gothickit.zenkit.utils.EnumNative;

public enum MaterialGroup implements EnumNative<MaterialGroup> {
	UNDEFINED(0),
	METAL(1),
	STONE(2),
	WOOD(3),
	EARTH(4),
	WATER(5),
	SNOW(6);

	private final int value;

	MaterialGroup(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return this.value;
	}

	@Override
	public MaterialGroup getForValue(int i) {
		return switch (i) {
			case 0 -> UNDEFINED;
			case 1 -> METAL;
			case 2 -> STONE;
			case 3 -> WOOD;
			case 4 -> EARTH;
			case 5 -> WATER;
			case 6 -> SNOW;
			default -> null;
		};
	}
}
