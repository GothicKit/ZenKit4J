package dev.gothickit.zenkit.daedalus;

import dev.gothickit.zenkit.utils.EnumNative;

public enum DaedalusDataType implements EnumNative<DaedalusDataType> {
	VOID(0),
	FLOAT(1),
	INT(2),
	STRING(3),
	CLASS(4),
	FUNCTION(5),
	PROTOTYPE(6),
	INSTANCE(7),
	;

	private final int value;

	DaedalusDataType(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public DaedalusDataType getForValue(int i) {
		return switch (i) {
			case 0 -> VOID;
			case 1 -> FLOAT;
			case 2 -> INT;
			case 3 -> STRING;
			case 4 -> CLASS;
			case 5 -> FUNCTION;
			case 6 -> PROTOTYPE;
			case 7 -> INSTANCE;
			default -> null;
		};
	}
}
