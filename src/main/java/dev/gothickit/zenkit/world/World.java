package dev.gothickit.zenkit.world;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.bsp.NativeBinarySpacePartitionTree;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.msh.Mesh;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.vfs.Vfs;
import dev.gothickit.zenkit.way.WayNet;
import dev.gothickit.zenkit.world.vob.VirtualObject;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class World {
	private final Handle handle;

	public World(@NotNull Read buf) {
		this.handle = new Handle(ZenKit.API.ZkWorld_load(buf.getHandle()), ZenKit.API::ZkWorld_del);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load world");
	}

	public World(String path) {
		this.handle = new Handle(ZenKit.API.ZkWorld_loadPath(path), ZenKit.API::ZkWorld_del);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load world");
	}

	public World(@NotNull Vfs vfs, String name) {
		this.handle = new Handle(ZenKit.API.ZkWorld_loadVfs(vfs.getHandle(), name), ZenKit.API::ZkWorld_del);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load world");
	}

	public Pointer getHandle() {
		return handle.get();
	}

	public Mesh getMesh() {
		return new Mesh(ZenKit.API.ZkWorld_getMesh(getHandle()));
	}

	public WayNet getWayNet() {
		return new WayNet(ZenKit.API.ZkWorld_getWayNet(getHandle()));
	}

	public NativeBinarySpacePartitionTree getBspTree() {
		return NativeBinarySpacePartitionTree.fromNativeHandle(ZenKit.API.ZkWorld_getBspTree(getHandle()));
	}

	public long getRootObjectCount() {
		return ZenKit.API.ZkWorld_getRootObjectCount(getHandle());
	}

	public VirtualObject getRootObject(long i) {
		return VirtualObject.fromNative(ZenKit.API.ZkWorld_getRootObject(getHandle(), i));
	}

	public List<VirtualObject> getRootObjects() {
		var objects = new ArrayList<VirtualObject>();
		ZenKit.API.ZkWorld_enumerateRootObjects(getHandle(), (ctx, vob) -> {
			objects.add(VirtualObject.fromNative(vob));
			return false;
		}, Pointer.NULL);
		return objects;
	}
}
