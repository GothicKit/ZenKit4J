package dev.gothickit.zenkit.mds;

import dev.gothickit.zenkit.CacheableObject;
import org.jetbrains.annotations.NotNull;

public interface EventSoundEffectGround extends CacheableObject<CachedEventSoundEffectGround> {
	int frame();

	@NotNull
	String name();

	float range();

	boolean emptySlot();
}
