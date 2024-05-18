package dev.gothickit.zenkit.mdl;

import dev.gothickit.zenkit.mdh.ModelHierarchy;
import dev.gothickit.zenkit.mdm.ModelMesh;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record CachedModel(
		@Nullable
		ModelHierarchy hierarchy,

		@Nullable
		ModelMesh mesh
) implements Model {
	@Override
	public @NotNull CachedModel cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
