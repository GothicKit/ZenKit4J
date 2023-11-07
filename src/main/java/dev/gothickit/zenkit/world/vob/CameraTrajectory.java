package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.utils.EnumNative;

public enum CameraTrajectory implements EnumNative<CameraTrajectory> {
	WORLD(0),
	OBJECT(1),
	;

	private final int value;

	CameraTrajectory(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public CameraTrajectory getForValue(int i) {
		return switch (i) {
			case 0 -> WORLD;
			case 1 -> OBJECT;
			default -> null;
		};
	}
}
