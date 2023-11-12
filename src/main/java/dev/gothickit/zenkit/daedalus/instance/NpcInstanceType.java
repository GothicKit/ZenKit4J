package dev.gothickit.zenkit.daedalus.instance;

import dev.gothickit.zenkit.utils.EnumNative;

public enum NpcInstanceType implements EnumNative<NpcInstanceType> {
	G1_AMBIENT(0),
	G1_MAIN(1),
	G1_GUARD(2),
	G1_FRIEND(3),
	G1_MINE_AMBIENT(4),
	G1_MINE_GUARD(5),
	G1_OW_AMBIENT(6),
	G1_OW_GUARD(7),
	G1_ROGUE(8),
	G2_AMBIENT(0),
	G2_MAIN(1),
	G2_FRIEND(2),
	G2_OC_AMBIENT(3),
	G2_OC_MAIN(4),
	G2_BL_AMBIENT(5),
	G2_TAL_AMBIENT(6),
	G2_BL_MAIN(7),
	;

	private final int value;

	NpcInstanceType(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public NpcInstanceType getForValue(int i) {
		return switch (i) {
			case 0 -> G1_AMBIENT;
			case 1 -> G1_MAIN;
			case 2 -> G1_GUARD;
			case 3 -> G1_FRIEND;
			case 4 -> G1_MINE_AMBIENT;
			case 5 -> G1_MINE_GUARD;
			case 6 -> G1_OW_AMBIENT;
			case 7 -> G1_OW_GUARD;
			case 8 -> G1_ROGUE;
			default -> null;
		};
	}
}
