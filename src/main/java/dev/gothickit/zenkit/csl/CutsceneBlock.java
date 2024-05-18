package dev.gothickit.zenkit.csl;

import dev.gothickit.zenkit.CacheableObject;
import org.jetbrains.annotations.NotNull;

public interface CutsceneBlock extends CacheableObject<CachedCutsceneBlock> {
	@NotNull
	String name();

	@NotNull
	CutsceneMessage message();
}
