package dev.gothickit.zenkit.world;

import dev.gothickit.zenkit.utils.EnumNative;
import org.jetbrains.annotations.Contract;

public enum AiType implements EnumNative<AiType> {
	HUMAN(0),
	MOVE(1);

	final int value;

	AiType(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Contract(pure = true)
	@Override
	public AiType getForValue(int i) {
		return switch (i) {
			case 0 -> HUMAN;
			case 1 -> MOVE;
			default -> null;
		};
	}
}
