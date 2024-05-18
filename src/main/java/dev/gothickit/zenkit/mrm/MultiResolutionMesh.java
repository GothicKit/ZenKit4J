package dev.gothickit.zenkit.mrm;

import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.mat.Material;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface MultiResolutionMesh extends CacheableObject<CachedMultiResolutionMesh> {
	@Contract("_ -> new")
	static @NotNull MultiResolutionMesh load(@NotNull String path) throws ResourceIOException {
		return new NativeMultiResolutionMesh(path);
	}

	@Contract("_ -> new")
	static @NotNull MultiResolutionMesh load(@NotNull Read buf) throws ResourceIOException {
		return new NativeMultiResolutionMesh(buf);
	}

	@Contract("_, _ -> new")
	static @NotNull MultiResolutionMesh load(@NotNull Vfs vfs, @NotNull String name) throws ResourceIOException {
		return new NativeMultiResolutionMesh(vfs, name);
	}

	@NotNull
	Vec3f @NotNull [] positions();

	@NotNull
	Vec3f[] normals();

	long subMeshCount();

	@Nullable
	MultiResolutionSubMesh subMesh(long i);

	@NotNull
	List<@NotNull MultiResolutionSubMesh> subMeshes();

	long materialCount();

	@Nullable
	Material material(long i);

	@NotNull
	List<@NotNull Material> materials();

	boolean alphaTest();

	@NotNull
	AxisAlignedBoundingBox bbox();

	@Nullable
	OrientedBoundingBox orientedBbox();
}
