package dev.gothickit.zenkit.mdl;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.ResourceIOException;
import dev.gothickit.zenkit.ResourceIOSource;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.mdh.ModelHierarchy;
import dev.gothickit.zenkit.mdh.NativeModelHierarchy;
import dev.gothickit.zenkit.mdm.ModelMesh;
import dev.gothickit.zenkit.mdm.NativeModelMesh;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NativeModel implements NativeObject, Model {
	private final Handle handle;

	NativeModel(@NotNull NativeRead buf) throws ResourceIOException {
		this.handle = new Handle(ZenKit.API.ZkModel_load(buf.getNativeHandle()), ZenKit.API::ZkModel_del);

		if (handle.isNull()) {
			throw new ResourceIOException(Model.class, ResourceIOSource.STREAM, buf.toString());
		}
	}

	NativeModel(@NotNull String path) throws ResourceIOException {
		this.handle = new Handle(ZenKit.API.ZkModel_loadPath(path), ZenKit.API::ZkModel_del);

		if (handle.isNull()) {
			throw new ResourceIOException(Model.class, ResourceIOSource.DISK, path);
		}
	}

	NativeModel(@NotNull Vfs vfs, @NotNull String name) throws ResourceIOException {
		this.handle = new Handle(ZenKit.API.ZkModel_loadVfs(vfs.getNativeHandle(), name), ZenKit.API::ZkModel_del);

		if (handle.isNull()) {
			throw new ResourceIOException(Model.class, ResourceIOSource.VFS, name);
		}
	}

	@Override
	public @Nullable ModelHierarchy hierarchy() {
		var ptr = ZenKit.API.ZkModel_getHierarchy(getNativeHandle());
		return NativeModelHierarchy.fromNativeHandle(ptr);
	}

	@Override
	public ModelMesh mesh() {
		var ptr = ZenKit.API.ZkModel_getMesh(getNativeHandle());
		return NativeModelMesh.fromNativeHandle(ptr);
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle.get();
	}

	@Override
	public @NotNull CachedModel cache() {
		var hierarchy = hierarchy();
		var mesh = mesh();

		return new CachedModel(
				hierarchy != null ? hierarchy.cache() : null,
				mesh != null ? mesh.cache() : null
		);
	}

	@Override
	public boolean isCached() {
		return false;
	}
}
