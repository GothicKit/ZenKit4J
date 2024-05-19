package dev.gothickit.zenkit.mds;

import dev.gothickit.zenkit.CacheableObject;
import org.jetbrains.annotations.NotNull;

public interface EventSoundEffect extends CacheableObject<CachedEventSoundEffect> {
	int frame();

	@NotNull
	String name();

	float range();

	boolean emptySlot();
}
