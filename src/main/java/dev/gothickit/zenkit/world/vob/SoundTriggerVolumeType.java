package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.utils.EnumNative;

public enum SoundTriggerVolumeType implements EnumNative<SoundTriggerVolumeType> {
	SPHERICAL(0),
	ELLIPSOIDAL(1),
	;

	public final int value;

	SoundTriggerVolumeType(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public SoundTriggerVolumeType getForValue(int i) {
		return switch (i) {
			case 0 -> SPHERICAL;
			case 1 -> ELLIPSOIDAL;
			default -> null;
		};
	}
}
