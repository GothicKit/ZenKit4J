package dev.gothickit.zenkit.vfs;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Vfs implements NativeObject {
	private final Handle handle;

	public Vfs() {
		var handle = new Handle(ZenKit.API.ZkVfs_new(), ZenKit.API::ZkVfs_del);
		if (handle.isNull()) throw new RuntimeException("Failed to create Vfs");

		ZenKit.CLEANER.register(this, handle);
		this.handle = handle;
	}

	@Contract(" -> new")
	public @NotNull VfsNode getRoot() {
		return VfsNode.fromNativeHandle(ZenKit.API.ZkVfs_getRoot(getNativeHandle()));
	}

	@Contract("_ -> new")
	public @NotNull VfsNode mkdir(String path) {
		return VfsNode.fromNativeHandle(ZenKit.API.ZkVfs_mkdir(getNativeHandle(), path));
	}

	public boolean remove(String path) {
		return ZenKit.API.ZkVfs_remove(getNativeHandle(), path);
	}

	public void mount(@NotNull VfsNode node, String parent, VfsOverwriteBehavior overwrite) {
		ZenKit.API.ZkVfs_mount(getNativeHandle(), node.getNativeHandle(), parent, overwrite);
	}

	public void mount(String path, String parent, VfsOverwriteBehavior overwrite) {
		ZenKit.API.ZkVfs_mountHost(getNativeHandle(), path, parent, overwrite);
	}

	public void mountDisk(@NotNull NativeRead buf, VfsOverwriteBehavior overwrite) {
		ZenKit.API.ZkVfs_mountDisk(getNativeHandle(), buf.getNativeHandle(), overwrite);
	}

	public void mountDisk(String path, VfsOverwriteBehavior overwrite) {
		ZenKit.API.ZkVfs_mountDiskHost(getNativeHandle(), path, overwrite);
	}

	public @Nullable VfsNode resolve(String path) {
		var node = ZenKit.API.ZkVfs_resolvePath(getNativeHandle(), path);
		return VfsNode.fromNativeHandle(node);
	}

	public @Nullable VfsNode find(String name) {
		var node = ZenKit.API.ZkVfs_findNode(getNativeHandle(), name);
		return VfsNode.fromNativeHandle(node);
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle.get();
	}
}
