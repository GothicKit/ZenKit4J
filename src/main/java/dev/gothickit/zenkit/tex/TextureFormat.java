package dev.gothickit.zenkit.tex;

import dev.gothickit.zenkit.utils.EnumNative;

public enum TextureFormat implements EnumNative<TextureFormat> {
	B8G8R8A8(0x0),
	R8G8B8A8(0x1),
	A8B8G8R8(0x2),
	A8R8G8B8(0x3),
	B8G8R8(0x4),
	R8G8B8(0x5),
	A4R4G4B4(0x6),
	A1R5G5B5(0x7),
	R5G6B5(0x8),
	P8(0x9),
	DXT1(0xA),
	DXT2(0xB),
	DXT3(0xC),
	DXT4(0xD),
	DXT5(0xE),
	;

	private final int value;

	TextureFormat(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public TextureFormat getForValue(int i) {
		return switch (i) {
			case 0x0 -> B8G8R8A8;
			case 0x1 -> R8G8B8A8;
			case 0x2 -> A8B8G8R8;
			case 0x3 -> A8R8G8B8;
			case 0x4 -> B8G8R8;
			case 0x5 -> R8G8B8;
			case 0x6 -> A4R4G4B4;
			case 0x7 -> A1R5G5B5;
			case 0x8 -> R5G6B5;
			case 0x9 -> P8;
			case 0xA -> DXT1;
			case 0xB -> DXT2;
			case 0xC -> DXT3;
			case 0xD -> DXT4;
			case 0xE -> DXT5;
			default -> null;
		};
	}
}
