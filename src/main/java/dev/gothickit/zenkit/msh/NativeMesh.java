package dev.gothickit.zenkit.msh;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.mat.Material;
import dev.gothickit.zenkit.mat.NativeMaterial;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public final class NativeMesh implements NativeObject, Mesh {
	private final Handle handle;

	NativeMesh(@NotNull Read buf) throws ResourceIOException {
		this.handle = new Handle(ZenKit.API.ZkMesh_load(buf.getHandle()), ZenKit.API::ZkMesh_del);

		if (handle.isNull()) {
			throw new ResourceIOException(Mesh.class, ResourceIOSource.STREAM, buf.toString());
		}
	}

	NativeMesh(String path) throws ResourceIOException {
		this.handle = new Handle(ZenKit.API.ZkMesh_loadPath(path), ZenKit.API::ZkMesh_del);

		if (handle.isNull()) {
			throw new ResourceIOException(Mesh.class, ResourceIOSource.DISK, path);
		}
	}

	NativeMesh(@NotNull Vfs vfs, String name) throws ResourceIOException {
		this.handle = new Handle(ZenKit.API.ZkMesh_loadVfs(vfs.getHandle(), name), ZenKit.API::ZkMesh_del);

		if (handle.isNull()) {
			throw new ResourceIOException(Mesh.class, ResourceIOSource.VFS, name);
		}
	}

	private NativeMesh(Pointer handle) {
		this.handle = new Handle(handle, (o) -> {
		});
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable Mesh fromNativeHandle(Pointer handle) {
		if (handle == null) return null;
		return new NativeMesh(handle);
	}

	@Override
	public @NotNull Calendar sourceDate() {
		return ZenKit.API.ZkMesh_getSourceDate(getNativeHandle()).toCalendar();
	}

	@Override
	public @NotNull String name() {
		return ZenKit.API.ZkMesh_getName(getNativeHandle());
	}

	@Override
	public @NotNull AxisAlignedBoundingBox boundingBox() {
		return ZenKit.API.ZkMesh_getBoundingBox(getNativeHandle());
	}

	@Override
	public @NotNull OrientedBoundingBox orientedBoundingBox() {
		var ptr = ZenKit.API.ZkMesh_getOrientedBoundingBox(getNativeHandle());
		return NativeOrientedBoundingBox.fromNativeHandle(ptr);
	}

	@Override
	public long materialCount() {
		return ZenKit.API.ZkMesh_getMaterialCount(getNativeHandle());
	}

	@Override
	public @Nullable Material material(long i) {
		var ptr = ZenKit.API.ZkMesh_getMaterial(getNativeHandle(), i);
		return NativeMaterial.fromNativeHandle(ptr);
	}

	@Override
	public @NotNull List<@NotNull Material> materials() {
		var materials = new ArrayList<Material>();

		ZenKit.API.ZkMesh_enumerateMaterials(getNativeHandle(), (ctx, material) -> {
			materials.add(NativeMaterial.fromNativeHandle(material));
			return false;
		}, Pointer.NULL);

		return materials;
	}

	@Override
	public Vec3f @NotNull [] positions() {
		var count = ZenKit.API.ZkMesh_getPositionCount(getNativeHandle());
		var weights = new Vec3f[(int) count];

		for (int i = 0; i < count; i++) {
			weights[i] = ZenKit.API.ZkMesh_getPosition(getNativeHandle(), i);
		}

		return weights;
	}

	@Override
	public Vertex @NotNull [] vertices() {
		var count = ZenKit.API.ZkMesh_getVertexCount(getNativeHandle());
		var weights = new Vertex[(int) count];

		for (int i = 0; i < count; i++) {
			weights[i] = ZenKit.API.ZkMesh_getVertex(getNativeHandle(), i);
		}

		return weights;
	}

	@Override
	public long lightMapCount() {
		return ZenKit.API.ZkMesh_getLightMapCount(getNativeHandle());
	}

	@Override
	public LightMap lightMap(long i) {
		var ptr = ZenKit.API.ZkMesh_getLightMap(getNativeHandle(), i);
		return NativeLightMap.fromNativeHandle(ptr);
	}

	@Override
	public @NotNull List<LightMap> lightMaps() {
		var lightMaps = new ArrayList<LightMap>();

		ZenKit.API.ZkMesh_enumerateLightMaps(getNativeHandle(), (ctx, lightMap) -> {
			lightMaps.add(NativeLightMap.fromNativeHandle(lightMap));
			return false;
		}, Pointer.NULL);

		return lightMaps;
	}

	@Override
	public long polygonCount() {
		return ZenKit.API.ZkMesh_getPolygonCount(getNativeHandle());
	}

	@Override
	public Polygon polygon(long i) {
		var ptr = ZenKit.API.ZkMesh_getPolygon(getNativeHandle(), i);
		if (ptr == Pointer.NULL) return null;
		return NativePolygon.fromNativeHandle(ptr);
	}

	@Override
	public @NotNull List<Polygon> polygons() {
		var polygons = new ArrayList<Polygon>();

		ZenKit.API.ZkMesh_enumeratePolygons(getNativeHandle(), (ctx, polygon) -> {
			polygons.add(NativePolygon.fromNativeHandle(polygon));
			return false;
		}, Pointer.NULL);

		return polygons;
	}

	@Override
	public @NotNull CachedMesh cache() {
		return new CachedMesh(
				sourceDate(),
				name(),
				boundingBox(),
				orientedBoundingBox().cache(),
				materials().stream().map(CacheableObject::cache).collect(Collectors.toList()),
				positions(),
				vertices(),
				lightMaps().stream().map(CacheableObject::cache).collect(Collectors.toList()),
				polygons().stream().map(CacheableObject::cache).collect(Collectors.toList())
		);
	}

	@Override
	public boolean isCached() {
		return false;
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle.get();
	}
}
