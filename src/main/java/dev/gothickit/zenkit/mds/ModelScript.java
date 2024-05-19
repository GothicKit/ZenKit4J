package dev.gothickit.zenkit.mds;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface ModelScript {
	@NotNull String skeletonName();

	boolean skeletonMeshDisabled();

	long meshCount();

	long disabledAnimationsCount();

	long animationCombineCount();

	long animationBlendCount();

	long animationAliasCount();

	long modelTagCount();

	long animationCount();

	@Nullable
	String disabledAnimation(long i);

	@Nullable
	String mesh(long i);

	@Nullable
	AnimationCombine animationCombine(long i);

	@Nullable
	AnimationBlend animationBlend(long i);

	@Nullable
	AnimationAlias animationAlias(long i);

	@Nullable
	String modelTag(long i);

	@Nullable
	NativeAnimation animation(long i);

	@NotNull
	List<@NotNull AnimationCombine> animationCombines();

	@NotNull
	List<@NotNull String> meshes();

	@NotNull
	List<@NotNull String> disabledAnimations();

	@NotNull
	List<@NotNull AnimationBlend> animationBlends();

	@NotNull
	List<@NotNull AnimationAlias> animationAliases();

	@NotNull
	List<@NotNull String> modelTags();

	@NotNull
	List<@NotNull NativeAnimation> animations();
}
