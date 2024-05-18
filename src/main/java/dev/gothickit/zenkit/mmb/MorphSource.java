package dev.gothickit.zenkit.mmb;

import dev.gothickit.zenkit.CacheableObject;
import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public interface MorphSource extends CacheableObject<CachedMorphSource> {
	@NotNull
	String fileName();

	@NotNull
	Calendar fileDate();
}
