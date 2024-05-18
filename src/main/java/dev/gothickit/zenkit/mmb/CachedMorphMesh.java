package dev.gothickit.zenkit.mmb;

import dev.gothickit.zenkit.Vec3f;
import dev.gothickit.zenkit.mrm.MultiResolutionMesh;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public record CachedMorphMesh(
		@NotNull
		String name,

		@Nullable
		MultiResolutionMesh mesh,

		@NotNull
		Vec3f @NotNull [] morphPositions,

		@NotNull
		List<@NotNull MorphAnimation> animations,

		@NotNull
		List<@NotNull MorphSource> sources
) implements MorphMesh {
	@Override
	public long animationCount() {
		return animations.size();
	}

	@Override
	public @Nullable MorphAnimation animation(long i) {
		if (i >= animations.size()) return null;
		return animations.get((int) i);
	}

	@Override
	public long sourceCount() {
		return sources.size();
	}

	@Override
	public @Nullable MorphSource source(long i) {
		if (i >= sources.size()) return null;
		return sources.get((int) i);
	}

	@Override
	public @NotNull CachedMorphMesh cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
