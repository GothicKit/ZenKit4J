package dev.gothickit.zenkit.daedalus.instance;

import dev.gothickit.zenkit.utils.EnumNative;

public enum ItemInstanceConditionSlot implements EnumNative<ItemInstanceConditionSlot> {
	SLOT0(0),
	SLOT1(1),
	SLOT2(2),
	;

	private final int value;

	ItemInstanceConditionSlot(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public ItemInstanceConditionSlot getForValue(int i) {
		return switch (i) {
			case 0 -> SLOT0;
			case 1 -> SLOT1;
			case 2 -> SLOT2;
			default -> null;
		};
	}
}
