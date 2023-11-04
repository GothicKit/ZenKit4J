package dev.gothickit.zenkit.vfs;

import dev.gothickit.zenkit.utils.EnumNative;

public enum VfsOverwriteBehavior implements EnumNative<VfsOverwriteBehavior> {
	NONE(0),
	ALL(1),
	NEWER(2),
	OLDER(3);

	private final int value;

	VfsOverwriteBehavior(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return this.value;
	}

	@Override
	public VfsOverwriteBehavior getForValue(int i) {
		return switch (i) {
			case 0 -> NONE;
			case 1 -> ALL;
			case 2 -> NEWER;
			case 3 -> OLDER;
			default -> null;
		};
	}
}
