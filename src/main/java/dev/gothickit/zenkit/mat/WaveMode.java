package dev.gothickit.zenkit.mat;

import dev.gothickit.zenkit.utils.EnumNative;

public enum WaveMode implements EnumNative<WaveMode> {
	NONE(0),
	GROUND_AMBIENT(1),
	GROUND(2),
	WALL_AMBIENT(3),
	WALL(4),
	ENVIRONMENT(5),
	WIND_AMBIENT(6),
	WIND(7);

	public final int value;

	WaveMode(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public WaveMode getForValue(int i) {
		return switch (i) {
			case 0 -> NONE;
			case 1 -> GROUND_AMBIENT;
			case 2 -> GROUND;
			case 3 -> WALL_AMBIENT;
			case 4 -> WALL;
			case 5 -> ENVIRONMENT;
			case 6 -> WIND_AMBIENT;
			case 7 -> WIND;
			default -> null;
		};
	}
}
