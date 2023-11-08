package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.utils.EnumNative;

public enum TriggerBatchMode implements EnumNative<TriggerBatchMode> {
	ALL(0),
	NEXT(1),
	RANDOM(2),
	;

	private final int value;

	TriggerBatchMode(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public TriggerBatchMode getForValue(int i) {
		return switch (i) {
			case 0 -> ALL;
			case 1 -> NEXT;
			case 2 -> RANDOM;
			default -> null;
		};
	}
}
