package dev.gothickit.zenkit.daedalus;

import dev.gothickit.zenkit.utils.EnumNative;

public enum DaedalusInstanceType implements EnumNative<DaedalusInstanceType> {
	GUILD_VALUES(0),
	NPC(1),
	MISSION(2),
	ITEM(3),
	FOCUS(4),
	INFO(5),
	ITEM_REACT(6),
	SPELL(7),
	SVM(8),
	MENU(9),
	MENU_ITEM(10),
	CAMERA(11),
	MUSIC_SYSTEM(12),
	MUSIC_THEME(13),
	MUSIC_JINGLE(14),
	PARTICLE_EFFECT(15),
	EFFECT_BASE(16),
	PARTICLE_EFFECT_EMIT_KEY(17),
	FIGHT_AI(18),
	SOUND_EFFECT(19),
	SOUND_SYSTEM(20),
	INVALID(21),
	;
	private final int value;

	DaedalusInstanceType(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public DaedalusInstanceType getForValue(int i) {
		return switch (i) {
			case 0 -> GUILD_VALUES;
			case 1 -> NPC;
			case 2 -> MISSION;
			case 3 -> ITEM;
			case 4 -> FOCUS;
			case 5 -> INFO;
			case 6 -> ITEM_REACT;
			case 7 -> SPELL;
			case 8 -> SVM;
			case 9 -> MENU;
			case 10 -> MENU_ITEM;
			case 11 -> CAMERA;
			case 12 -> MUSIC_SYSTEM;
			case 13 -> MUSIC_THEME;
			case 14 -> MUSIC_JINGLE;
			case 15 -> PARTICLE_EFFECT;
			case 16 -> EFFECT_BASE;
			case 17 -> PARTICLE_EFFECT_EMIT_KEY;
			case 18 -> FIGHT_AI;
			case 19 -> SOUND_EFFECT;
			case 20 -> SOUND_SYSTEM;
			case 21 -> INVALID;
			default -> null;
		};
	}
}
