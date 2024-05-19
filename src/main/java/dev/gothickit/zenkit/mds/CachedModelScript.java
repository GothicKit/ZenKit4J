package dev.gothickit.zenkit.mds;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public record CachedModelScript(
		@NotNull String skeletonName,

		boolean skeletonMeshDisabled,

		@NotNull
		List<@NotNull AnimationCombine> animationCombines,

		@NotNull
		List<@NotNull String> meshes,

		@NotNull
		List<@NotNull String> disabledAnimations,

		@NotNull
		List<@NotNull AnimationBlend> animationBlends,

		@NotNull
		List<@NotNull AnimationAlias> animationAliases,

		@NotNull
		List<@NotNull String> modelTags,

		@NotNull
		List<@NotNull NativeAnimation> animations
) implements ModelScript {
	@Override
	public long meshCount() {
		return meshes.size();
	}

	@Override
	public long disabledAnimationsCount() {
		return disabledAnimations.size();
	}

	@Override
	public long animationCombineCount() {
		return animationCombines.size();
	}

	@Override
	public long animationBlendCount() {
		return animationBlends.size();
	}

	@Override
	public long animationAliasCount() {
		return animationAliases.size();
	}

	@Override
	public long modelTagCount() {
		return modelTags.size();
	}

	@Override
	public long animationCount() {
		return animations.size();
	}

	@Override
	public @Nullable String disabledAnimation(long i) {
		if (i >= disabledAnimations.size()) return null;
		return disabledAnimations.get((int) i);
	}

	@Override
	public @Nullable String mesh(long i) {
		if (i >= meshes.size()) return null;
		return meshes.get((int) i);
	}

	@Override
	public @Nullable AnimationCombine animationCombine(long i) {
		if (i >= animationCombines.size()) return null;
		return animationCombines.get((int) i);
	}

	@Override
	public @Nullable AnimationBlend animationBlend(long i) {
		if (i >= animationBlends.size()) return null;
		return animationBlends.get((int) i);
	}

	@Override
	public @Nullable AnimationAlias animationAlias(long i) {
		if (i >= animationAliases.size()) return null;
		return animationAliases.get((int) i);
	}

	@Override
	public @Nullable String modelTag(long i) {
		if (i >= modelTags.size()) return null;
		return modelTags.get((int) i);
	}

	@Override
	public @Nullable NativeAnimation animation(long i) {
		if (i >= animations.size()) return null;
		return animations.get((int) i);
	}
}
