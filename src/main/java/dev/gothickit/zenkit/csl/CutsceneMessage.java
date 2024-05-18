package dev.gothickit.zenkit.csl;

import dev.gothickit.zenkit.CacheableObject;
import org.jetbrains.annotations.NotNull;

public interface CutsceneMessage extends CacheableObject<CachedCutsceneMessage> {
	int type();

	@NotNull
	String text();

	@NotNull
	String name();
}
