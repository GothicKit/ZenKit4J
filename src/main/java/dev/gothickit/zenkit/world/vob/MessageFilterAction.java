package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.utils.EnumNative;

public enum MessageFilterAction implements EnumNative<MessageFilterAction> {
	NONE(0),
	TRIGGER(1),
	UNTRIGGER(2),
	ENABLE(3),
	DISABLE(4),
	TOGGLE(5),
	;

	private final int value;

	MessageFilterAction(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public MessageFilterAction getForValue(int i) {
		return switch (i) {
			case 0 -> NONE;
			case 1 -> TRIGGER;
			case 2 -> UNTRIGGER;
			case 3 -> ENABLE;
			case 4 -> DISABLE;
			case 5 -> TOGGLE;
			default -> null;
		};
	}
}
