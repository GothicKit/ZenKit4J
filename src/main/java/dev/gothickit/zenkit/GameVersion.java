package dev.gothickit.zenkit;

import dev.gothickit.zenkit.utils.EnumNative;

public enum GameVersion implements EnumNative<GameVersion> {
	GOTHIC_1(0),
	GOTHIC_2(1);

	public final int value;

	GameVersion(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public GameVersion getForValue(int i) {
		return switch (i) {
			case 0 -> GOTHIC_1;
			case 1 -> GOTHIC_2;
			default -> null;
		};
	}
}
