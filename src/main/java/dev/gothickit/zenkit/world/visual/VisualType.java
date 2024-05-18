package dev.gothickit.zenkit.world.visual;

import dev.gothickit.zenkit.utils.EnumNative;

public enum VisualType implements EnumNative<VisualType> {
	DECAL(0),
	MESH(1),
	MULTI_RESOLUTION_MESH(2),
	PARTICLE_EFFECT(3),
	CAMERA(4),
	MODEL(5),
	MORPH_MESH(6),
	UNKNOWN(7),
	;

	public final int value;

	VisualType(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public VisualType getForValue(int i) {
		return switch (i) {
			case 0 -> DECAL;
			case 1 -> MESH;
			case 2 -> MULTI_RESOLUTION_MESH;
			case 3 -> PARTICLE_EFFECT;
			case 4 -> CAMERA;
			case 5 -> MODEL;
			case 6 -> MORPH_MESH;
			case 7 -> UNKNOWN;
			default -> null;
		};
	}
}
