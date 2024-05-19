package dev.gothickit.zenkit.msh;

import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.mat.Material;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Calendar;
import java.util.List;

public interface Mesh extends CacheableObject<CachedMesh> {
	@Contract("_ -> new")
	static @NotNull Mesh load(@NotNull String path) throws ResourceIOException {
		return new NativeMesh(path);
	}

	@Contract("_ -> new")
	static @NotNull Mesh load(@NotNull Read buf) throws ResourceIOException {
		return new NativeMesh(Read.adapt(buf));
	}

	@Contract("_, _ -> new")
	static @NotNull Mesh load(@NotNull Vfs vfs, @NotNull String name) throws ResourceIOException {
		return new NativeMesh(vfs, name);
	}

	@NotNull
	Calendar sourceDate();

	@NotNull
	String name();

	@NotNull
	AxisAlignedBoundingBox boundingBox();

	@NotNull
	OrientedBoundingBox orientedBoundingBox();

	long materialCount();

	@Nullable
	Material material(long i);

	@NotNull
	List<@NotNull Material> materials();

	@NotNull
	Vec3f @NotNull [] positions();

	@NotNull
	Vertex @NotNull [] vertices();

	long lightMapCount();

	@Nullable
	LightMap lightMap(long i);

	@NotNull
	List<@NotNull LightMap> lightMaps();

	long polygonCount();

	@Nullable
	Polygon polygon(long i);

	@NotNull
	List<@NotNull Polygon> polygons();
}
