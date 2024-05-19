package dev.gothickit.zenkit.daedalus;

import dev.gothickit.zenkit.utils.EnumNative;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

public enum DaedalusOpcode implements EnumNative<DaedalusOpcode> {
	ADD(0),
	SUB(1),
	MUL(2),
	DIV(3),
	MOD(4),
	OR(5),
	ANDB(6),
	LT(7),
	GT(8),
	MOVI(9),
	ORR(11),
	AND(12),
	LSL(13),
	LSR(14),
	LTE(15),
	EQ(16),
	NEQ(17),
	GTE(18),
	ADDMOVI(19),
	SUBMOVI(20),
	MULMOVI(21),
	DIVMOVI(22),
	PLUS(30),
	NEGATE(31),
	NOT(32),
	CMPL(33),
	NOP(45),
	RSR(60),
	BL(61),
	BE(62),
	PUSHI(64),
	PUSHV(65),
	PUSHVI(67),
	MOVS(70),
	MOVSS(71),
	MOVVF(72),
	MOVF(73),
	MOVVI(74),
	B(75),
	BZ(76),
	GMOVI(80),
	PUSHVV(245),
	;

	private final int value;

	DaedalusOpcode(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Contract(pure = true)
	@Override
	public @Nullable DaedalusOpcode getForValue(int i) {
		return switch (i) {
			case 0 -> ADD;
			case 1 -> SUB;
			case 2 -> MUL;
			case 3 -> DIV;
			case 4 -> MOD;
			case 5 -> OR;
			case 6 -> ANDB;
			case 7 -> LT;
			case 8 -> GT;
			case 9 -> MOVI;
			case 11 -> ORR;
			case 12 -> AND;
			case 13 -> LSL;
			case 14 -> LSR;
			case 15 -> LTE;
			case 16 -> EQ;
			case 17 -> NEQ;
			case 18 -> GTE;
			case 19 -> ADDMOVI;
			case 20 -> SUBMOVI;
			case 21 -> MULMOVI;
			case 22 -> DIVMOVI;
			case 30 -> PLUS;
			case 31 -> NEGATE;
			case 32 -> NOT;
			case 33 -> CMPL;
			case 45 -> NOP;
			case 60 -> RSR;
			case 61 -> BL;
			case 62 -> BE;
			case 64 -> PUSHI;
			case 65 -> PUSHV;
			case 67 -> PUSHVI;
			case 70 -> MOVS;
			case 71 -> MOVSS;
			case 72 -> MOVVF;
			case 73 -> MOVF;
			case 74 -> MOVVI;
			case 75 -> B;
			case 76 -> BZ;
			case 80 -> GMOVI;
			case 245 -> PUSHVV;
			default -> null;
		};
	}
}
