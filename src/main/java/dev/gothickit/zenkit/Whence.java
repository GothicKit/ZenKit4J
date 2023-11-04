package dev.gothickit.zenkit;

import dev.gothickit.zenkit.utils.EnumNative;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

public enum Whence implements EnumNative<Whence> {
	BEGIN(0),
	CURRENT(1),
	END(2);

	private final int value;

	@Contract(pure = true)
	Whence(int value) {
		this.value = value;
	}

	@Contract(pure = true)
	@Override
	public int getIntValue() {
		return this.value;
	}

	@Contract(pure = true)
	@Override
	public @Nullable Whence getForValue(int i) {
		return switch (i) {
			case 0 -> BEGIN;
			case 1 -> CURRENT;
			case 2 -> END;
			default -> null;
		};
	}
}
