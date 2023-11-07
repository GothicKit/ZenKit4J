package dev.gothickit.zenkit.msh;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import dev.gothickit.zenkit.AxisAlignedBoundingBox;
import dev.gothickit.zenkit.OrientedBoundingBox;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.Vec3f;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.mat.Material;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Mesh {
	private final Handle handle;

	public Mesh(@NotNull Read buf) {
		this.handle = new Handle(ZenKit.API.ZkMesh_load(buf.getHandle()), ZenKit.API::ZkMesh_del);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load mesh");
	}

	public Mesh(String path) {
		this.handle = new Handle(ZenKit.API.ZkMesh_loadPath(path), ZenKit.API::ZkMesh_del);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load mesh");
	}

	public Mesh(@NotNull Vfs vfs, String name) {
		this.handle = new Handle(ZenKit.API.ZkMesh_loadVfs(vfs.getHandle(), name), ZenKit.API::ZkMesh_del);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load mesh");
	}

	public Mesh(Pointer handle) {
		this.handle = new Handle(handle, (o) -> {
		});
	}

	public Pointer getHandle() {
		return handle.get();
	}

	public Calendar getSourceDate() {
		return ZenKit.API.ZkMesh_getSourceDate(getHandle()).toCalendar();
	}

	public String getName() {
		return ZenKit.API.ZkMesh_getName(getHandle());
	}

	public AxisAlignedBoundingBox getBoundingBox() {
		return ZenKit.API.ZkMesh_getBoundingBox(getHandle());
	}

	public OrientedBoundingBox getOrientedBoundingBox() {
		return new OrientedBoundingBox(ZenKit.API.ZkMesh_getOrientedBoundingBox(getHandle()));
	}

	public long getMaterialCount() {
		return ZenKit.API.ZkMesh_getMaterialCount(getHandle());
	}

	public Material getMaterial(long i) {
		var ptr = ZenKit.API.ZkMesh_getMaterial(getHandle(), i);
		if (ptr == Pointer.NULL) return null;
		return new Material(ptr);
	}

	public List<Material> getMaterials() {
		var materials = new ArrayList<Material>();

		ZenKit.API.ZkMesh_enumerateMaterials(getHandle(), (ctx, material) -> {
			materials.add(new Material(material));
			return false;
		}, Pointer.NULL);

		return materials;
	}

	public Vec3f[] getPositions() {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkMesh_getPositions(getHandle(), count);
		if (ptr == null || count.getValue() == 0) return new Vec3f[0];
		return (Vec3f[]) ptr.toArray(count.getValue());
	}

	public Vertex[] getVertices() {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkMesh_getVertices(getHandle(), count);
		if (ptr == null || count.getValue() == 0) return new Vertex[0];
		return (Vertex[]) ptr.toArray(count.getValue());
	}

	public long getLightMapCount() {
		return ZenKit.API.ZkMesh_getLightMapCount(getHandle());
	}

	public LightMap getLightMap(long i) {
		var ptr = ZenKit.API.ZkMesh_getLightMap(getHandle(), i);
		if (ptr == Pointer.NULL) return null;
		return new LightMap(ptr);
	}

	public List<LightMap> getLightMaps() {
		var lightMaps = new ArrayList<LightMap>();

		ZenKit.API.ZkMesh_enumerateLightMaps(getHandle(), (ctx, lightMap) -> {
			lightMaps.add(new LightMap(lightMap));
			return false;
		}, Pointer.NULL);

		return lightMaps;
	}

	public long getPolygonCount() {
		return ZenKit.API.ZkMesh_getPolygonCount(getHandle());
	}

	public Polygon getPolygon(long i) {
		var ptr = ZenKit.API.ZkMesh_getPolygon(getHandle(), i);
		if (ptr == Pointer.NULL) return null;
		return new Polygon(ptr);
	}

	public List<Polygon> getPolygons() {
		var polygons = new ArrayList<Polygon>();

		ZenKit.API.ZkMesh_enumeratePolygons(getHandle(), (ctx, polygon) -> {
			polygons.add(new Polygon(polygon));
			return false;
		}, Pointer.NULL);

		return polygons;
	}
}
