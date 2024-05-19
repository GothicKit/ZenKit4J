package dev.gothickit.zenkit.mdm;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.mrm.MultiResolutionMesh;
import dev.gothickit.zenkit.mrm.NativeMultiResolutionMesh;
import dev.gothickit.zenkit.ssm.NativeSoftSkinMesh;
import dev.gothickit.zenkit.ssm.SoftSkinMesh;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class NativeModelMesh implements NativeObject, ModelMesh {
	private final Handle handle;

	NativeModelMesh(@NotNull NativeRead buf) throws ResourceIOException {
		this.handle = new Handle(ZenKit.API.ZkModelMesh_load(buf.getNativeHandle()), ZenKit.API::ZkModelMesh_del);

		if (handle.isNull()) {
			throw new ResourceIOException(ModelMesh.class, ResourceIOSource.STREAM, buf.toString());
		}
	}

	NativeModelMesh(@NotNull String path) throws ResourceIOException {
		this.handle = new Handle(ZenKit.API.ZkModelMesh_loadPath(path), ZenKit.API::ZkModelMesh_del);

		if (handle.isNull()) {
			throw new ResourceIOException(ModelMesh.class, ResourceIOSource.DISK, path);
		}
	}

	NativeModelMesh(@NotNull Vfs vfs, @NotNull String name) throws ResourceIOException {
		this.handle = new Handle(ZenKit.API.ZkModelMesh_loadVfs(vfs.getNativeHandle(), name), ZenKit.API::ZkModelMesh_del);

		if (handle.isNull()) {
			throw new ResourceIOException(ModelMesh.class, ResourceIOSource.VFS, name);
		}
	}

	private NativeModelMesh(Pointer handle) {
		this.handle = new Handle(handle, (o) -> {
		});
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable NativeModelMesh fromNativeHandle(Pointer handle) {
		if (handle == null) return null;
		return new NativeModelMesh(handle);
	}

	@Override
	public long meshCount() {
		return ZenKit.API.ZkModelMesh_getMeshCount(getNativeHandle());
	}

	@Override
	public SoftSkinMesh mesh(long i) {
		var mesh = ZenKit.API.ZkModelMesh_getMesh(getNativeHandle(), i);
		if (mesh == Pointer.NULL) return null;
		return NativeSoftSkinMesh.fromNativeHandle(mesh);
	}

	@Override
	public @NotNull List<SoftSkinMesh> meshes() {
		var meshes = new ArrayList<SoftSkinMesh>();

		ZenKit.API.ZkModelMesh_enumerateMeshes(getNativeHandle(), (ctx, ssm) -> {
			meshes.add(NativeSoftSkinMesh.fromNativeHandle(ssm));
			return false;
		}, Pointer.NULL);

		return meshes;
	}

	@Override
	public long attachmentCount() {
		return ZenKit.API.ZkModelMesh_getAttachmentCount(getNativeHandle());
	}

	@Override
	public MultiResolutionMesh attachment(String name) {
		var mesh = ZenKit.API.ZkModelMesh_getAttachment(getNativeHandle(), name);
		return NativeMultiResolutionMesh.fromNativeHandle(mesh);
	}

	@Override
	public @NotNull Map<@NotNull String, @NotNull MultiResolutionMesh> attachments() {
		var attachments = new HashMap<String, MultiResolutionMesh>();

		ZenKit.API.ZkModelMesh_enumerateAttachments(getNativeHandle(), (ctx, name, mesh) -> {
			attachments.put(name, NativeMultiResolutionMesh.fromNativeHandle(mesh));
			return false;
		}, Pointer.NULL);

		return attachments;
	}

	@Override
	public long checksum() {
		return ZenKit.API.ZkModelMesh_getChecksum(getNativeHandle());
	}

	@Override
	public @NotNull CachedModelMesh cache() {
		var attachments = attachments();
		attachments.replaceAll((k, v) -> v.cache());

		return new CachedModelMesh(
				meshes().stream().map(CacheableObject::cache).collect(Collectors.toList()),
				attachments,
				checksum()
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
