package dev.gothickit.zenkit.msh;

import dev.gothickit.zenkit.AxisAlignedBoundingBox;
import dev.gothickit.zenkit.OrientedBoundingBox;
import dev.gothickit.zenkit.Vec3f;
import dev.gothickit.zenkit.mat.Material;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Calendar;
import java.util.List;

public record CachedMesh(
		@NotNull
		Calendar sourceDate,

		@NotNull
		String name,

		@NotNull
		AxisAlignedBoundingBox boundingBox,

		@NotNull
		OrientedBoundingBox orientedBoundingBox,

		@NotNull
		List<@NotNull Material> materials,

		@NotNull
		Vec3f @NotNull [] positions,

		@NotNull
		Vertex @NotNull [] vertices,

		@NotNull
		List<@NotNull LightMap> lightMaps,

		@NotNull
		List<@NotNull Polygon> polygons
) implements Mesh {
	@Override
	public long materialCount() {
		return materials.size();
	}

	@Override
	public @Nullable Material material(long i) {
		if (i >= materials.size()) return null;
		return materials.get((int) i);
	}

	@Override
	public long lightMapCount() {
		return lightMaps.size();
	}

	@Override
	public @Nullable LightMap lightMap(long i) {
		if (i >= lightMaps.size()) return null;
		return lightMaps.get((int) i);
	}

	@Override
	public long polygonCount() {
		return polygons.size();
	}

	@Override
	public @Nullable Polygon polygon(long i) {
		if (i >= polygons.size()) return null;
		return polygons.get((int) i);
	}

	@Override
	public @NotNull CachedMesh cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
