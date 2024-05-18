package dev.gothickit.zenkit;

import org.jetbrains.annotations.NotNull;

public interface CacheableObject<T> {
	@NotNull T cache();
	boolean isCached();
}
