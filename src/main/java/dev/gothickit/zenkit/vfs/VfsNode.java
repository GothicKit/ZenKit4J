package dev.gothickit.zenkit.vfs;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VfsNode {
	private final Handle handle;
	private final byte[] content;

	public VfsNode(String name, byte[] content, Date timestamp) {
		var handle = new Handle(ZenKit.API.ZkVfsNode_newFile(
				name,
				content,
				content.length,
				timestamp.getTime() / 1000
		), ZenKit.API::ZkVfsNode_del);

		if (handle.isNull()) {
			throw new RuntimeException("Failed to create Vfs node");
		}

		ZenKit.CLEANER.register(this, handle);

		this.handle = handle;
		this.content = content;
	}

	public VfsNode(String name, Date timestamp) {
		var handle = new Handle(
				ZenKit.API.ZkVfsNode_newDir(name, timestamp.getTime() / 1000),
				ZenKit.API::ZkVfsNode_del
		);

		if (handle.isNull()) {
			throw new RuntimeException("Failed to create Vfs node");
		}

		ZenKit.CLEANER.register(this, handle);

		this.handle = handle;
		this.content = null;
	}

	VfsNode(Pointer handle) {
		this.handle = new Handle(handle, (o) -> {
		});
		this.content = null;
	}

	public Pointer getHandle() {
		return this.handle.get();
	}

	public boolean isFile() {
		return ZenKit.API.ZkVfsNode_isFile(this.getHandle());
	}

	public boolean isDir() {
		return ZenKit.API.ZkVfsNode_isDir(this.getHandle());
	}

	public Date getTimestamp() {
		return new Date(ZenKit.API.ZkVfsNode_getTime(this.getHandle()) * 1000);
	}

	public String getName() {
		return ZenKit.API.ZkVfsNode_getName(this.getHandle());
	}

	public @Nullable VfsNode getChild(String name) {
		if (!this.isDir()) return null;
		var child = ZenKit.API.ZkVfsNode_getChild(this.getHandle(), name);
		return child != null ? new VfsNode(child) : null;
	}

	public List<VfsNode> getChildren() {
		var children = new ArrayList<VfsNode>();

		if (this.isDir()) {
			ZenKit.API.ZkVfsNode_enumerateChildren(this.getHandle(), (ctx, node) -> {
				children.add(new VfsNode(node));
				return false;
			}, Pointer.NULL);
		}

		return children;
	}

	public VfsNode create(VfsNode node) {
		if (!this.isDir()) {
			throw new RuntimeException("create() is only available on directory nodes");
		}

		return new VfsNode(ZenKit.API.ZkVfsNode_create(this.getHandle(), node.getHandle()));
	}

	public boolean remove(String name) {
		return ZenKit.API.ZkVfsNode_remove(this.getHandle(), name);
	}

	public Read open() {
		if (!this.isFile()) {
			throw new RuntimeException("open() is only available on file nodes");
		}

		return new Read(ZenKit.API.ZkVfsNode_open(this.getHandle()));
	}
}
