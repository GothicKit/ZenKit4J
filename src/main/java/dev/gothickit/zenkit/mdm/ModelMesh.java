package dev.gothickit.zenkit.mdm;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.mrm.MultiResolutionMesh;
import dev.gothickit.zenkit.ssm.SoftSkinMesh;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelMesh {
	private final Handle handle;

	public ModelMesh(@NotNull Read buf) {
		this.handle = new Handle(ZenKit.API.ZkModelMesh_load(buf.getHandle()), ZenKit.API::ZkModelMesh_del);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load model mesh");
	}

	public ModelMesh(String path) {
		this.handle = new Handle(ZenKit.API.ZkModelMesh_loadPath(path), ZenKit.API::ZkModelMesh_del);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load model mesh");
	}

	public ModelMesh(@NotNull Vfs vfs, String name) {
		this.handle = new Handle(ZenKit.API.ZkModelMesh_loadVfs(vfs.getHandle(), name), ZenKit.API::ZkModelMesh_del);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load model mesh");
	}

	public Pointer getHandle() {
		return handle.get();
	}

	public long getMeshCount() {
		return ZenKit.API.ZkModelMesh_getMeshCount(this.getHandle());
	}

	public SoftSkinMesh getMesh(long i) {
		var mesh = ZenKit.API.ZkModelMesh_getMesh(this.getHandle(), i);
		if (mesh == Pointer.NULL) return null;
		return new SoftSkinMesh(mesh);
	}

	public List<SoftSkinMesh> getMeshes() {
		var meshes = new ArrayList<SoftSkinMesh>();

		ZenKit.API.ZkModelMesh_enumerateMeshes(this.getHandle(), (ctx, ssm) -> {
			meshes.add(new SoftSkinMesh(ssm));
			return false;
		}, Pointer.NULL);

		return meshes;
	}

	public long getAttachmentCount() {
		return ZenKit.API.ZkModelMesh_getAttachmentCount(this.getHandle());
	}

	public MultiResolutionMesh getAttachment(String name) {
		var mesh = ZenKit.API.ZkModelMesh_getAttachment(this.getHandle(), name);
		if (mesh == Pointer.NULL) return null;
		return new MultiResolutionMesh(mesh);
	}

	public Map<String, MultiResolutionMesh> getAttachments() {
		var attachments = new HashMap<String, MultiResolutionMesh>();

		ZenKit.API.ZkModelMesh_enumerateAttachments(this.getHandle(), (ctx, name, mesh) -> {
			attachments.put(name, new MultiResolutionMesh(mesh));
			return false;
		}, Pointer.NULL);

		return attachments;
	}

	public long getChecksum() {
		return ZenKit.API.ZkModelMesh_getChecksum(this.getHandle());
	}
}
