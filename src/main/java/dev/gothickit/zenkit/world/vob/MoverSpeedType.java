package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.utils.EnumNative;

public enum MoverSpeedType implements EnumNative<MoverSpeedType> {
	CONSTANT(0),
	SLOW_START_END(1),
	SLOW_START(2),
	SLOW_END(3),
	SEGMENT_SLOW_START_END(4),
	SEGMENT_SLOW_START(5),
	SEGMENT_SLOW_END(6),
	;

	private final int value;

	MoverSpeedType(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public MoverSpeedType getForValue(int i) {
		return switch (i) {
			case 0 -> CONSTANT;
			case 1 -> SLOW_START_END;
			case 2 -> SLOW_START;
			case 3 -> SLOW_END;
			case 4 -> SEGMENT_SLOW_START_END;
			case 5 -> SEGMENT_SLOW_START;
			case 6 -> SEGMENT_SLOW_END;
			default -> null;
		};
	}
}
