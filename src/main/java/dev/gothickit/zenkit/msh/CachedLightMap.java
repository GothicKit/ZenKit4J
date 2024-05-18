package dev.gothickit.zenkit.msh;

import dev.gothickit.zenkit.Vec3f;
import dev.gothickit.zenkit.tex.Texture;
import org.jetbrains.annotations.NotNull;

public record CachedLightMap(
		@NotNull Texture image,

		@NotNull
		Vec3f origin,

		@NotNull Vec3f @NotNull [] normals
) implements LightMap {
	@Override
	public @NotNull CachedLightMap cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
