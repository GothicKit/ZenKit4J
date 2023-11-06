package dev.gothickit.zenkit.bsp;

import dev.gothickit.zenkit.utils.EnumNative;

public enum BspTreeType implements EnumNative<BspTreeType> {
	INDOOR(0),
	OUTDOOR(1);

	public final int value;

	BspTreeType(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public BspTreeType getForValue(int i) {
		return switch (i) {
			case 0 -> INDOOR;
			case 1 -> OUTDOOR;
			default -> null;
		};
	}
}
