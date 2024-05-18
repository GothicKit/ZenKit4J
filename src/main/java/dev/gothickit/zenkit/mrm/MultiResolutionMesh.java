package dev.gothickit.zenkit.mrm;

import com.sun.jna.Pointer;
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
import java.util.List;

public class MultiResolutionMesh {
	private final Handle handle;

	public MultiResolutionMesh(@NotNull Read buf) {
		this.handle = new Handle(
				ZenKit.API.ZkMultiResolutionMesh_load(buf.getHandle()),
				ZenKit.API::ZkMultiResolutionMesh_del
		);

		if (this.handle.isNull()) {
			throw new RuntimeException("Failed to load multi resolution mesh");
		}
	}

	public MultiResolutionMesh(String path) {
		this.handle = new Handle(
				ZenKit.API.ZkMultiResolutionMesh_loadPath(path),
				ZenKit.API::ZkMultiResolutionMesh_del
		);

		if (this.handle.isNull()) {
			throw new RuntimeException("Failed to load multi resolution mesh");
		}
	}

	public MultiResolutionMesh(@NotNull Vfs vfs, String name) {
		this.handle = new Handle(
				ZenKit.API.ZkMultiResolutionMesh_loadVfs(vfs.getHandle(), name),
				ZenKit.API::ZkMultiResolutionMesh_del
		);

		if (this.handle.isNull()) {
			throw new RuntimeException("Failed to load multi resolution mesh");
		}
	}

	public MultiResolutionMesh(Pointer handle) {
		this.handle = new Handle(handle, (o) -> {
		});
	}

	public Pointer getHandle() {
		return handle.get();
	}

	public Vec3f[] getPositions() {
		var count = ZenKit.API.ZkMultiResolutionMesh_getPositionCount(this.getHandle());
		Vec3f[] positions = new Vec3f[(int) count];

		for (int i = 0; i < count; i++) {
			positions[i] = ZenKit.API.ZkMultiResolutionMesh_getPosition(this.getHandle(), i);
		}

		return positions;
	}

	public Vec3f[] getNormals() {
		var count = ZenKit.API.ZkMultiResolutionMesh_getNormalCount(this.getHandle());
		Vec3f[] normals = new Vec3f[(int) count];

		for (int i = 0; i < count; i++) {
			normals[i] = ZenKit.API.ZkMultiResolutionMesh_getNormal(this.getHandle(), i);
		}

		return normals;
	}

	public long getSubMeshCount() {
		return ZenKit.API.ZkMultiResolutionMesh_getSubMeshCount(this.getHandle());
	}

	public MultiResolutionSubMesh getSubMesh(long i) {
		return new MultiResolutionSubMesh(ZenKit.API.ZkMultiResolutionMesh_getSubMesh(this.getHandle(), i));
	}

	public List<MultiResolutionSubMesh> getSubMeshes() {
		var meshes = new ArrayList<MultiResolutionSubMesh>();

		ZenKit.API.ZkMultiResolutionMesh_enumerateSubMeshes(this.getHandle(), (ctx, mesh) -> {
			meshes.add(new MultiResolutionSubMesh(mesh));
			return false;
		}, Pointer.NULL);

		return meshes;
	}

	public long getMaterialCount() {
		return ZenKit.API.ZkMultiResolutionMesh_getMaterialCount(this.getHandle());
	}

	public Material getMaterial(long i) {
		return new Material(ZenKit.API.ZkMultiResolutionMesh_getMaterial(this.getHandle(), i));
	}

	public List<Material> getMaterials() {
		var meshes = new ArrayList<Material>();

		ZenKit.API.ZkMultiResolutionMesh_enumerateMaterials(this.getHandle(), (ctx, mat) -> {
			meshes.add(new Material(mat));
			return false;
		}, Pointer.NULL);

		return meshes;
	}

	public boolean getAlphaTest() {
		return ZenKit.API.ZkMultiResolutionMesh_getAlphaTest(this.getHandle());
	}

	public AxisAlignedBoundingBox getBbox() {
		return ZenKit.API.ZkMultiResolutionMesh_getBbox(this.getHandle());
	}

	public OrientedBoundingBox getOrientedBbox() {
		return new OrientedBoundingBox(ZenKit.API.ZkMultiResolutionMesh_getOrientedBbox(this.getHandle()));
	}
}
