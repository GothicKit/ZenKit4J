package dev.gothickit.zenkit.vfs;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Vfs {
	private final Handle handle;

	public Vfs() {
		var handle = new Handle(ZenKit.API.ZkVfs_new(), ZenKit.API::ZkVfs_del);
		if (handle.isNull()) throw new RuntimeException("Failed to create Vfs");

		ZenKit.CLEANER.register(this, handle);
		this.handle = handle;
	}

	public Pointer getHandle() {
		return this.handle.get();
	}

	public VfsNode getRoot() {
		return new VfsNode(ZenKit.API.ZkVfs_getRoot(this.getHandle()));
	}

	public VfsNode mkdir(String path) {
		return new VfsNode(ZenKit.API.ZkVfs_mkdir(this.getHandle(), path));
	}

	public boolean remove(String path) {
		return ZenKit.API.ZkVfs_remove(this.getHandle(), path);
	}

	public void mount(@NotNull VfsNode node, String parent, VfsOverwriteBehavior overwrite) {
		ZenKit.API.ZkVfs_mount(this.getHandle(), node.getHandle(), parent, overwrite);
	}

	public void mount(String path, String parent, VfsOverwriteBehavior overwrite) {
		ZenKit.API.ZkVfs_mountHost(this.getHandle(), path, parent, overwrite);
	}

	public void mountDisk(@NotNull Read buf, VfsOverwriteBehavior overwrite) {
		ZenKit.API.ZkVfs_mountDisk(this.getHandle(), buf.getHandle(), overwrite);
	}

	public void mountDisk(String path, VfsOverwriteBehavior overwrite) {
		ZenKit.API.ZkVfs_mountDiskHost(this.getHandle(), path, overwrite);
	}

	public @Nullable VfsNode resolve(String path) {
		var node = ZenKit.API.ZkVfs_resolvePath(this.getHandle(), path);
		return node != null ? new VfsNode(node) : null;
	}

	public @Nullable VfsNode find(String name) {
		var node = ZenKit.API.ZkVfs_findNode(this.getHandle(), name);
		return node != null ? new VfsNode(node) : null;
	}
}
