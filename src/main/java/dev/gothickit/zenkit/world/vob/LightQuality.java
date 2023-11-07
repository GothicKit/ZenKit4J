package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.utils.EnumNative;

public enum LightQuality implements EnumNative<LightQuality> {
	HIGH(0),
	MEDIUM(1),
	LOW(2),
	;

	public final int value;

	LightQuality(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public LightQuality getForValue(int i) {
		return switch (i) {
			case 0 -> HIGH;
			case 1 -> MEDIUM;
			case 2 -> LOW;
			default -> null;
		};
	}
}
