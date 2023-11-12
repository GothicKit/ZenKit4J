package dev.gothickit.zenkit.daedalus.instance;

import dev.gothickit.zenkit.utils.EnumNative;

public enum MenuItemType implements EnumNative<MenuItemType> {
	UNKNOWN(0),
	TEXT(1),
	SLIDER(2),
	INPUT(3),
	CURSOR(4),
	CHOICE_BOX(5),
	BUTTON(6),
	LIST_BOX(7),
	;

	private final int value;

	MenuItemType(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public MenuItemType getForValue(int i) {
		return switch (i) {
			case 0 -> UNKNOWN;
			case 1 -> TEXT;
			case 2 -> SLIDER;
			case 3 -> INPUT;
			case 4 -> CURSOR;
			case 5 -> CHOICE_BOX;
			case 6 -> BUTTON;
			case 7 -> LIST_BOX;
			default -> null;
		};
	}
}
