package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.utils.EnumNative;

public enum SoundMaterialType implements EnumNative<SoundMaterialType> {
	WOOD(0),
	STONE(1),
	METAL(2),
	LEATHER(3),
	CLAY(4),
	GLASS(5),
	;

	public final int value;

	SoundMaterialType(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public SoundMaterialType getForValue(int i) {
		return switch (i) {
			case 0 -> WOOD;
			case 1 -> STONE;
			case 2 -> METAL;
			case 3 -> LEATHER;
			case 4 -> CLAY;
			case 5 -> GLASS;
			default -> null;
		};
	}
}
