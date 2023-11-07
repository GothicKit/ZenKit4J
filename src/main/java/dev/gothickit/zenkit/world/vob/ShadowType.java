package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.utils.EnumNative;

public enum ShadowType implements EnumNative<ShadowType> {
	NONE(0),
	BLOB(1);
	private final int value;

	ShadowType(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public ShadowType getForValue(int i) {
		return switch (i) {
			case 0 -> NONE;
			case 1 -> BLOB;
			default -> null;
		};
	}
}
