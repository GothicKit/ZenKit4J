package dev.gothickit.zenkit.daedalus.instance;

import dev.gothickit.zenkit.utils.EnumNative;

public enum MusicTransitionEffect implements EnumNative<MusicTransitionEffect> {
	UNKNOWN(0),
	NONE(1),
	GROOVE(2),
	FILL(3),
	BREAK(4),
	INTRO(5),
	END(6),
	END_AND_INTO(7),
	;

	private final int value;

	MusicTransitionEffect(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public MusicTransitionEffect getForValue(int i) {
		return switch (i) {
			case 0 -> UNKNOWN;
			case 1 -> NONE;
			case 2 -> GROOVE;
			case 3 -> FILL;
			case 4 -> BREAK;
			case 5 -> INTRO;
			case 6 -> END;
			case 7 -> END_AND_INTO;
			default -> null;
		};
	}
}
