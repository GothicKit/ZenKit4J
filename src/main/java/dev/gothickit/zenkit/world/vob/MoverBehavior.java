package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.utils.EnumNative;

public enum MoverBehavior implements EnumNative<MoverBehavior> {
	TOGGLE(0),
	TRIGGER_CONTROL(1),
	OPEN_TIME(2),
	LOOP(3),
	SINGLE_KEYS(4),
	;

	private final int value;

	MoverBehavior(int value) {

		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public MoverBehavior getForValue(int i) {
		return switch (i) {
			case 0 -> TOGGLE;
			case 1 -> TRIGGER_CONTROL;
			case 2 -> OPEN_TIME;
			case 3 -> LOOP;
			case 4 -> SINGLE_KEYS;
			default -> null;
		};
	}
}
