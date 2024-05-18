package dev.gothickit.zenkit.bsp;

import dev.gothickit.zenkit.utils.EnumNative;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

public enum BinarySpacePartitionType implements EnumNative<BinarySpacePartitionType> {
	INDOOR(0),
	OUTDOOR(1);

	public final int value;

	BinarySpacePartitionType(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Contract(pure = true)
	@Override
	public @Nullable BinarySpacePartitionType getForValue(int i) {
		return switch (i) {
			case 0 -> INDOOR;
			case 1 -> OUTDOOR;
			default -> null;
		};
	}
}
