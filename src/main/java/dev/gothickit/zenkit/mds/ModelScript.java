package dev.gothickit.zenkit.mds;

import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.ResourceIOException;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface ModelScript {
	@Contract("_ -> new")
	static @NotNull ModelScript load(@NotNull String path) throws ResourceIOException {
		return new NativeModelScript(path);
	}

	@Contract("_ -> new")
	static @NotNull ModelScript load(@NotNull Read buf) throws ResourceIOException {
		return new NativeModelScript(Read.adapt(buf));
	}

	@Contract("_, _ -> new")
	static @NotNull ModelScript load(@NotNull Vfs vfs, @NotNull String name) throws ResourceIOException {
		return new NativeModelScript(vfs, name);
	}

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
