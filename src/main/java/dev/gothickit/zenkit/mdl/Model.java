package dev.gothickit.zenkit.mdl;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.mdh.ModelHierarchy;
import dev.gothickit.zenkit.mdm.ModelMesh;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.NotNull;

public class Model {
	private final Handle handle;

	public Model(@NotNull Read buf) {
		this.handle = new Handle(ZenKit.API.ZkModel_load(buf.getHandle()), ZenKit.API::ZkModel_del);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load model");
	}

	public Model(String path) {
		this.handle = new Handle(ZenKit.API.ZkModel_loadPath(path), ZenKit.API::ZkModel_del);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load model");
	}

	public Model(@NotNull Vfs vfs, String name) {
		this.handle = new Handle(ZenKit.API.ZkModel_loadVfs(vfs.getHandle(), name), ZenKit.API::ZkModel_del);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load model");
	}

	public Pointer getHandle() {
		return handle.get();
	}

	public ModelHierarchy getHierarchy() {
		return new ModelHierarchy(ZenKit.API.ZkModel_getHierarchy(this.getHandle()));
	}

	public ModelMesh getMesh() {
		return new ModelMesh(ZenKit.API.ZkModel_getMesh(this.getHandle()));
	}
}
