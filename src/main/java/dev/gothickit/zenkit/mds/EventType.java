package dev.gothickit.zenkit.mds;

import dev.gothickit.zenkit.utils.EnumNative;

public enum EventType implements EnumNative<EventType> {
	UNKNOWN(0),
	ITEM_CREATE(1),
	ITEM_INSERT(2),
	ITEM_REMOVE(3),
	ITEM_DESTROY(4),
	ITEM_PLACE(5),
	ITEM_EXCHANGE(6),
	SET_FIGHT_MODE(7),
	MUNITION_PLACE(8),
	MUNITION_REMOVE(9),
	SOUND_DRAW(10),
	SOUND_UNDRAW(11),
	MESH_SWAP(12),
	TORCH_DRAW(13),
	TORCH_INVENTORY(14),
	TORCH_DROP(15),
	HIT_LIMB(16),
	HIT_DIRECTION(17),
	DAMAGE_MULTIPLIER(18),
	PARRY_FRAME(19),
	OPTIMAL_FRAME(20),
	HIT_END(21),
	COMBO_WINDOW(22),
	;

	private final int value;

	EventType(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public EventType getForValue(int i) {
		return switch (i) {
			case 0 -> UNKNOWN;
			case 1 -> ITEM_CREATE;
			case 2 -> ITEM_INSERT;
			case 3 -> ITEM_REMOVE;
			case 4 -> ITEM_DESTROY;
			case 5 -> ITEM_PLACE;
			case 6 -> ITEM_EXCHANGE;
			case 7 -> SET_FIGHT_MODE;
			case 8 -> MUNITION_PLACE;
			case 9 -> MUNITION_REMOVE;
			case 10 -> SOUND_DRAW;
			case 11 -> SOUND_UNDRAW;
			case 12 -> MESH_SWAP;
			case 13 -> TORCH_DRAW;
			case 14 -> TORCH_INVENTORY;
			case 15 -> TORCH_DROP;
			case 16 -> HIT_LIMB;
			case 17 -> HIT_DIRECTION;
			case 18 -> DAMAGE_MULTIPLIER;
			case 19 -> PARRY_FRAME;
			case 20 -> OPTIMAL_FRAME;
			case 21 -> HIT_END;
			case 22 -> COMBO_WINDOW;
			default -> null;
		};
	}
}
