package dev.gothickit.zenkit.mmb;

import dev.gothickit.zenkit.CacheableObject;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.ResourceIOException;
import dev.gothickit.zenkit.Vec3f;
import dev.gothickit.zenkit.mrm.MultiResolutionMesh;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface MorphMesh extends CacheableObject<CachedMorphMesh> {
	@Contract("_ -> new")
	static @NotNull MorphMesh load(@NotNull String path) throws ResourceIOException {
		return new NativeMorphMesh(path);
	}

	@Contract("_ -> new")
	static @NotNull MorphMesh load(@NotNull Read buf) throws ResourceIOException {
		return new NativeMorphMesh(Read.adapt(buf));
	}

	@Contract("_, _ -> new")
	static @NotNull MorphMesh load(@NotNull Vfs vfs, @NotNull String name) throws ResourceIOException {
		return new NativeMorphMesh(vfs, name);
	}

	@NotNull
	String name();

	@Nullable
	MultiResolutionMesh mesh();

	@NotNull
	Vec3f @NotNull [] morphPositions();

	long animationCount();

	@Nullable
	MorphAnimation animation(long i);

	@NotNull
	List<@NotNull MorphAnimation> animations();

	long sourceCount();

	@Nullable
	MorphSource source(long i);

	@NotNull
	List<@NotNull MorphSource> sources();
}
