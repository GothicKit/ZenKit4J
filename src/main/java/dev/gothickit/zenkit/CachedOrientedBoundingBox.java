package dev.gothickit.zenkit;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public record CachedOrientedBoundingBox(
		@NotNull Vec3f center,

		@NotNull Vec3f @NotNull [] axes,

		@NotNull Vec3f halfWidth,

		@NotNull
		List<OrientedBoundingBox> children
) implements OrientedBoundingBox {
	@Override
	public long childCount() {
		return children.size();
	}

	@Override
	public @Nullable OrientedBoundingBox child(long i) {
		if (i >= children.size()) return null;
		return children.get((int) i);
	}

	@Override
	public @NotNull CachedOrientedBoundingBox cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
