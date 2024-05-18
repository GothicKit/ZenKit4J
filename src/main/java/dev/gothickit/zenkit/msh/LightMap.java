package dev.gothickit.zenkit.msh;

import dev.gothickit.zenkit.CacheableObject;
import dev.gothickit.zenkit.Vec3f;
import dev.gothickit.zenkit.tex.Texture;
import org.jetbrains.annotations.NotNull;

public interface LightMap extends CacheableObject<CachedLightMap> {
	@NotNull
	Texture image();

	@NotNull
	Vec3f origin();

	@NotNull
	Vec3f @NotNull [] normals();
}
