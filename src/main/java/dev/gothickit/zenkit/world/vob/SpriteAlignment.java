package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.utils.EnumNative;

public enum SpriteAlignment implements EnumNative<SpriteAlignment> {
	NONE(0),
	YAW(1),
	FULL(2),
	;

	public final int value;

	SpriteAlignment(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public SpriteAlignment getForValue(int i) {
		return switch (i) {
			case 0 -> NONE;
			case 1 -> YAW;
			case 2 -> FULL;
			default -> null;
		};
	}
}
