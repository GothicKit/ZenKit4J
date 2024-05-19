package dev.gothickit.zenkit.mds;

import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;

public enum AnimationFlag {
	MOVE(1),
	ROTATE(2),
	QUEUE(4),
	FLY(8),
	IDLE(16),
	INPLACE(32);

	private final int value;

	AnimationFlag(int value) {
		this.value = value;
	}

	public static @NotNull EnumSet<AnimationFlag> fromInt(int value) {
		var flags = EnumSet.noneOf(AnimationFlag.class);

		if ((value & MOVE.value) != 0) {
			flags.add(AnimationFlag.MOVE);
		}

		if ((value & ROTATE.value) != 0) {
			flags.add(AnimationFlag.ROTATE);
		}

		if ((value & QUEUE.value) != 0) {
			flags.add(AnimationFlag.QUEUE);
		}

		if ((value & FLY.value) != 0) {
			flags.add(AnimationFlag.FLY);
		}

		if ((value & IDLE.value) != 0) {
			flags.add(AnimationFlag.IDLE);
		}

		if ((value & INPLACE.value) != 0) {
			flags.add(AnimationFlag.INPLACE);
		}

		return flags;
	}
}
