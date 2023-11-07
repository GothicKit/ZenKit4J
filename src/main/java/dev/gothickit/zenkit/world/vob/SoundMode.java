package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.utils.EnumNative;

public enum SoundMode implements EnumNative<SoundMode> {
	LOOP(0),
	ONCE(1),
	RANDOM(2),
	;

	public final int value;

	SoundMode(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public SoundMode getForValue(int i) {
		return switch (i) {
			case 0 -> LOOP;
			case 1 -> ONCE;
			case 2 -> RANDOM;
			default -> null;
		};
	}
}
