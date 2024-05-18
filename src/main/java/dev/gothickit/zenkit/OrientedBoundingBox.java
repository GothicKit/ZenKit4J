package dev.gothickit.zenkit;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface OrientedBoundingBox extends CacheableObject<CachedOrientedBoundingBox> {
	@NotNull
	Vec3f center();

	@NotNull
	Vec3f @NotNull [] axes();

	@NotNull
	Vec3f halfWidth();

	long childCount();

	@Nullable
	OrientedBoundingBox child(long i);

	@NotNull
	List<OrientedBoundingBox> children();
}
