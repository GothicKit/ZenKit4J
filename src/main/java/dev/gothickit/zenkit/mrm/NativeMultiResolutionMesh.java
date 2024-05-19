package dev.gothickit.zenkit.mrm;

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
import java.util.List;
import java.util.stream.Collectors;

public final class NativeMultiResolutionMesh implements NativeObject, MultiResolutionMesh {
	private final Handle handle;

	NativeMultiResolutionMesh(@NotNull NativeRead buf) throws ResourceIOException {
		this.handle = new Handle(
				ZenKit.API.ZkMultiResolutionMesh_load(buf.getNativeHandle()),
				ZenKit.API::ZkMultiResolutionMesh_del
		);

		if (handle.isNull()) {
			throw new ResourceIOException(MultiResolutionMesh.class, ResourceIOSource.STREAM, buf.toString());
		}
	}

	NativeMultiResolutionMesh(String path) throws ResourceIOException {
		this.handle = new Handle(
				ZenKit.API.ZkMultiResolutionMesh_loadPath(path),
				ZenKit.API::ZkMultiResolutionMesh_del
		);

		if (handle.isNull()) {
			throw new ResourceIOException(MultiResolutionMesh.class, ResourceIOSource.DISK, path);
		}
	}

	NativeMultiResolutionMesh(@NotNull Vfs vfs, String name) throws ResourceIOException {
		this.handle = new Handle(
				ZenKit.API.ZkMultiResolutionMesh_loadVfs(vfs.getNativeHandle(), name),
				ZenKit.API::ZkMultiResolutionMesh_del
		);

		if (handle.isNull()) {
			throw new ResourceIOException(MultiResolutionMesh.class, ResourceIOSource.VFS, name);
		}
	}

	private NativeMultiResolutionMesh(Pointer handle) {
		this.handle = new Handle(handle, (o) -> {
		});
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable NativeMultiResolutionMesh fromNativeHandle(Pointer handle) {
		if (handle == null) return null;
		return new NativeMultiResolutionMesh(handle);
	}

	@Override
	public Vec3f @NotNull [] positions() {
		var count = ZenKit.API.ZkMultiResolutionMesh_getPositionCount(getNativeHandle());
		Vec3f[] positions = new Vec3f[(int) count];

		for (int i = 0; i < count; i++) {
			positions[i] = ZenKit.API.ZkMultiResolutionMesh_getPosition(getNativeHandle(), i);
		}

		return positions;
	}

	@Override
	public Vec3f[] normals() {
		var count = ZenKit.API.ZkMultiResolutionMesh_getNormalCount(getNativeHandle());
		Vec3f[] normals = new Vec3f[(int) count];

		for (int i = 0; i < count; i++) {
			normals[i] = ZenKit.API.ZkMultiResolutionMesh_getNormal(getNativeHandle(), i);
		}

		return normals;
	}

	@Override
	public long subMeshCount() {
		return ZenKit.API.ZkMultiResolutionMesh_getSubMeshCount(getNativeHandle());
	}

	@Override
	public MultiResolutionSubMesh subMesh(long i) {
		var ptr = ZenKit.API.ZkMultiResolutionMesh_getSubMesh(getNativeHandle(), i);
		return NativeMultiResolutionSubMesh.fromNativeHandle(ptr);
	}

	@Override
	public @NotNull List<MultiResolutionSubMesh> subMeshes() {
		var meshes = new ArrayList<MultiResolutionSubMesh>();

		ZenKit.API.ZkMultiResolutionMesh_enumerateSubMeshes(getNativeHandle(), (ctx, mesh) -> {
			meshes.add(NativeMultiResolutionSubMesh.fromNativeHandle(mesh));
			return false;
		}, Pointer.NULL);

		return meshes;
	}

	@Override
	public long materialCount() {
		return ZenKit.API.ZkMultiResolutionMesh_getMaterialCount(getNativeHandle());
	}

	@Override
	public @Nullable Material material(long i) {
		var ptr = ZenKit.API.ZkMultiResolutionMesh_getMaterial(getNativeHandle(), i);
		return NativeMaterial.fromNativeHandle(ptr);
	}

	@Override
	public @NotNull List<Material> materials() {
		var meshes = new ArrayList<Material>();

		ZenKit.API.ZkMultiResolutionMesh_enumerateMaterials(getNativeHandle(), (ctx, mat) -> {
			meshes.add(NativeMaterial.fromNativeHandle(mat));
			return false;
		}, Pointer.NULL);

		return meshes;
	}

	@Override
	public boolean alphaTest() {
		return ZenKit.API.ZkMultiResolutionMesh_getAlphaTest(getNativeHandle());
	}

	@Override
	public @NotNull AxisAlignedBoundingBox bbox() {
		return ZenKit.API.ZkMultiResolutionMesh_getBbox(getNativeHandle());
	}

	@Override
	public OrientedBoundingBox orientedBbox() {
		var ptr = ZenKit.API.ZkMultiResolutionMesh_getOrientedBbox(getNativeHandle());
		return NativeOrientedBoundingBox.fromNativeHandle(ptr);
	}

	@Override
	public @NotNull CachedMultiResolutionMesh cache() {
		var obb = orientedBbox();
		return new CachedMultiResolutionMesh(
				positions(),
				normals(),
				subMeshes().stream().map(CacheableObject::cache).collect(Collectors.toList()),
				materials().stream().map(CacheableObject::cache).collect(Collectors.toList()),
				alphaTest(),
				bbox(),
				obb != null ? obb.cache() : null
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
