package dev.gothickit.zenkit.daedalus.instance;

import dev.gothickit.zenkit.utils.EnumNative;

public enum FightAiMove implements EnumNative<FightAiMove> {
	NOP(0),
	RUN(1),
	RUN_BACK(2),
	JUMP_BACK(3),
	TURN(4),
	STRAFE(5),
	ATTACK(6),
	ATTACK_SIDE(7),
	ATTACK_FRONT(8),
	ATTACK_TRIPLE(9),
	ATTACK_WHIRL(10),
	ATTACK_MASTER(11),
	TURN_TO_HIT(15),
	PARRY(17),
	STAND_UP(18),
	WAIT(19),
	WAIT_LONGER(23),
	WAIT_EXT(24),
	;

	private final int value;

	FightAiMove(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public FightAiMove getForValue(int i) {
		return switch (i) {
			case 0 -> NOP;
			case 1 -> RUN;
			case 2 -> RUN_BACK;
			case 3 -> JUMP_BACK;
			case 4 -> TURN;
			case 5 -> STRAFE;
			case 6 -> ATTACK;
			case 7 -> ATTACK_SIDE;
			case 8 -> ATTACK_FRONT;
			case 9 -> ATTACK_TRIPLE;
			case 10 -> ATTACK_WHIRL;
			case 11 -> ATTACK_MASTER;
			case 15 -> TURN_TO_HIT;
			case 17 -> PARRY;
			case 18 -> STAND_UP;
			case 19 -> WAIT;
			case 23 -> WAIT_LONGER;
			case 24 -> WAIT_EXT;
			default -> null;
		};
	}
}
