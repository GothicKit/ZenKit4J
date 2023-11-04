package dev.gothickit.zenkit;

import dev.gothickit.zenkit.utils.EnumNative;
import org.jetbrains.annotations.Contract;

public enum LogLevel implements EnumNative<LogLevel> {
	ERROR(0),
	WARNING(1),
	INFO(2),
	DEBUG(3),
	TRACE(4);

	private final int value;

	@Contract(pure = true)
	LogLevel(int value) {
		this.value = value;
	}

	@Contract(pure = true)
	@Override
	public int getIntValue() {
		return this.value;
	}

	@Contract(pure = true)
	@Override
	public LogLevel getForValue(int i) {
		return switch (i) {
			case 0 -> ERROR;
			case 1 -> WARNING;
			case 2 -> INFO;
			case 3 -> DEBUG;
			case 4 -> TRACE;
			default -> null;
		};
	}
}
