package dev.gothickit.zenkit.mdh;

import dev.gothickit.zenkit.AxisAlignedBoundingBox;
import dev.gothickit.zenkit.Vec3f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Calendar;
import java.util.List;

public record CachedModelHierarchy(
		@NotNull
		AxisAlignedBoundingBox bbox,

		@NotNull
		AxisAlignedBoundingBox collisionBbox,

		@NotNull
		Vec3f rootTranslation,

		long checksum,

		@NotNull
		Calendar sourceDate,

		@NotNull
		String sourcePath,

		@NotNull
		List<@NotNull ModelHierarchyNode> nodes
) implements ModelHierarchy {
	@Override
	public long nodeCount() {
		return nodes.size();
	}

	@Override
	public @Nullable ModelHierarchyNode node(long i) {
		if (i >= nodes.size()) return null;
		return nodes.get((int) i);
	}

	@Override
	public @NotNull CachedModelHierarchy cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
