package dev.gothickit.zenkit;

import org.jetbrains.annotations.NotNull;

public class ResourceIOException extends Exception {
	public ResourceIOException(@NotNull Class<?> resource, ResourceIOSource sourceType, String source) {
		super("Failed to load resource of type \"%s\" from %s: %s".formatted(resource.getSimpleName(), sourceType, source));
	}
}
