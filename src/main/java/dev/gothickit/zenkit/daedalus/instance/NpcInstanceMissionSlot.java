package dev.gothickit.zenkit.daedalus.instance;

import dev.gothickit.zenkit.utils.EnumNative;

public enum NpcInstanceMissionSlot implements EnumNative<NpcInstanceMissionSlot> {
	SLOT0(0),
	SLOT1(1),
	SLOT2(2),
	SLOT3(3),
	SLOT4(4),
	;

	private final int value;

	NpcInstanceMissionSlot(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public NpcInstanceMissionSlot getForValue(int i) {
		return switch (i) {
			case 0 -> SLOT0;
			case 1 -> SLOT1;
			case 2 -> SLOT2;
			case 3 -> SLOT3;
			case 4 -> SLOT4;
			default -> null;
		};
	}
}
