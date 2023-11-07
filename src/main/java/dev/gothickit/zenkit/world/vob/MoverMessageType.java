package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.utils.EnumNative;

public enum MoverMessageType implements EnumNative<MoverMessageType> {
	FIXED_DIRECT(0),
	FIXED_ORDER(1),
	NEXT(2),
	PREVIOUS(3),
	;

	public final int value;

	MoverMessageType(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public MoverMessageType getForValue(int i) {
		return switch (i) {
			case 0 -> FIXED_DIRECT;
			case 1 -> FIXED_ORDER;
			case 2 -> NEXT;
			case 3 -> PREVIOUS;
			default -> null;
		};
	}
}
