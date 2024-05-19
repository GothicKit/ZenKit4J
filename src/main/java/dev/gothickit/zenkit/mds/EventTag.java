package dev.gothickit.zenkit.mds;

import dev.gothickit.zenkit.CacheableObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface EventTag extends CacheableObject<CachedEventTag> {
	int frame();

	@NotNull
	EventType type();

	@Nullable
	String slot(long i);

	@NotNull
	List<String> slots();

	@NotNull
	String item();

	int @NotNull [] frames();

	@NotNull
	FightMode fightMode();

	boolean isAttached();
}
