package dev.gothickit.zenkit.vfs;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

public final class VfsNode implements NativeObject {
	private final @NotNull Handle handle;

	private VfsNode(@NotNull Pointer handle, Consumer<Pointer> delete) {
		this.handle = new Handle(handle, delete);
		ZenKit.CLEANER.register(this, this.handle);
	}

	private VfsNode(@NotNull Pointer handle) {
		this(handle, (o) -> {
		});
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable VfsNode fromNativeHandle(Pointer handle) {
		if (handle == null) return null;
		return new VfsNode(handle);
	}

	@NotNull
	public static VfsNode createFile(@NotNull String name, byte @NotNull [] content) {
		return createFile(name, content, Date.from(Instant.now()));
	}

	@NotNull
	public static VfsNode createFile(@NotNull String name, byte @NotNull [] content, @NotNull Date timestamp) {
		var handle = ZenKit.API.ZkVfsNode_newFile(
				name,
				content,
				content.length,
				timestamp.getTime() / 1000
		);

		if (handle == Pointer.NULL) {
			throw new RuntimeException("Failed to create Vfs node");
		}

		return new VfsNode(handle, ZenKit.API::ZkVfsNode_del);
	}

	@NotNull
	public static VfsNode createDirectory(@NotNull String name) {
		return createDirectory(name, Date.from(Instant.now()));
	}

	@NotNull
	public static VfsNode createDirectory(@NotNull String name, @NotNull Date timestamp) {
		var handle = ZenKit.API.ZkVfsNode_newDir(name, timestamp.getTime() / 1000);

		if (handle == Pointer.NULL) {
			throw new RuntimeException("Failed to create Vfs node");
		}

		return new VfsNode(handle, ZenKit.API::ZkVfsNode_del);
	}

	public boolean isFile() {
		return ZenKit.API.ZkVfsNode_isFile(getNativeHandle());
	}

	public boolean isDirectory() {
		return ZenKit.API.ZkVfsNode_isDir(getNativeHandle());
	}

	public Date timestamp() {
		return new Date(ZenKit.API.ZkVfsNode_getTime(getNativeHandle()) * 1000);
	}

	public @NotNull String name() {
		return ZenKit.API.ZkVfsNode_getName(getNativeHandle());
	}

	public @Nullable VfsNode get(@NotNull String name) {
		if (!this.isDirectory()) return null;
		var child = ZenKit.API.ZkVfsNode_getChild(getNativeHandle(), name);
		return VfsNode.fromNativeHandle(child);
	}

	public @NotNull List<@NotNull VfsNode> children() {
		var children = new ArrayList<VfsNode>();

		if (this.isDirectory()) {
			ZenKit.API.ZkVfsNode_enumerateChildren(getNativeHandle(), (ctx, node) -> {
				children.add(VfsNode.fromNativeHandle(node));
				return false;
			}, Pointer.NULL);
		}

		return children;
	}

	public @NotNull VfsNode create(@NotNull VfsNode node) {
		if (!this.isDirectory()) {
			throw new RuntimeException("create() is only available on directory nodes");
		}

		var ptr = ZenKit.API.ZkVfsNode_create(getNativeHandle(), node.getNativeHandle());
		return VfsNode.fromNativeHandle(ptr);
	}

	public boolean remove(@NotNull String name) {
		return ZenKit.API.ZkVfsNode_remove(getNativeHandle(), name);
	}

	public @NotNull NativeRead open() {
		if (!this.isFile()) {
			throw new RuntimeException("open() is only available on file nodes");
		}

		return NativeRead.fromNativeHandle(ZenKit.API.ZkVfsNode_open(getNativeHandle()));
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle.get();
	}
}
