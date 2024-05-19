package dev.gothickit.zenkit.world;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.bsp.NativeBinarySpacePartitionTree;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.msh.Mesh;
import dev.gothickit.zenkit.msh.NativeMesh;
import dev.gothickit.zenkit.tex.Texture;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.vfs.Vfs;
import dev.gothickit.zenkit.way.NativeWayNet;
import dev.gothickit.zenkit.way.WayNet;
import dev.gothickit.zenkit.world.vob.VirtualObject;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public final class World implements NativeObject {
	private final Handle handle;

	private World(@NotNull NativeRead buf) throws ResourceIOException {
		this.handle = new Handle(ZenKit.API.ZkWorld_load(buf.getNativeHandle()), ZenKit.API::ZkWorld_del);

		if (handle.isNull()) {
			throw new ResourceIOException(Texture.class, ResourceIOSource.STREAM, buf.toString());
		}
	}

	private World(@NotNull String path) throws ResourceIOException {
		this.handle = new Handle(ZenKit.API.ZkWorld_loadPath(path), ZenKit.API::ZkWorld_del);

		if (handle.isNull()) {
			throw new ResourceIOException(Texture.class, ResourceIOSource.DISK, path);
		}
	}

	private World(@NotNull Vfs vfs, @NotNull String name) throws ResourceIOException {
		this.handle = new Handle(ZenKit.API.ZkWorld_loadVfs(vfs.getNativeHandle(), name), ZenKit.API::ZkWorld_del);

		if (handle.isNull()) {
			throw new ResourceIOException(Texture.class, ResourceIOSource.VFS, name);
		}
	}

	@Contract("_ -> new")
	public static @NotNull World load(@NotNull String path) throws ResourceIOException {
		return new World(path);
	}

	@Contract("_ -> new")
	public static @NotNull World load(@NotNull Read buf) throws ResourceIOException {
		return new World(Read.adapt(buf));
	}

	@Contract("_, _ -> new")
	public static @NotNull World load(@NotNull Vfs vfs, @NotNull String name) throws ResourceIOException {
		return new World(vfs, name);
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle.get();
	}

	public Mesh getMesh() {
		return NativeMesh.fromNativeHandle(ZenKit.API.ZkWorld_getMesh(getNativeHandle()));
	}

	public WayNet getWayNet() {
		return NativeWayNet.fromNativeHandle(ZenKit.API.ZkWorld_getWayNet(getNativeHandle()));
	}

	public NativeBinarySpacePartitionTree getBspTree() {
		return NativeBinarySpacePartitionTree.fromNativeHandle(ZenKit.API.ZkWorld_getBspTree(getNativeHandle()));
	}

	public long getRootObjectCount() {
		return ZenKit.API.ZkWorld_getRootObjectCount(getNativeHandle());
	}

	public VirtualObject getRootObject(long i) {
		return VirtualObject.fromNativeHandle(ZenKit.API.ZkWorld_getRootObject(getNativeHandle(), i));
	}

	public List<VirtualObject> getRootObjects() {
		var objects = new ArrayList<VirtualObject>();
		ZenKit.API.ZkWorld_enumerateRootObjects(getNativeHandle(), (ctx, vob) -> {
			objects.add(VirtualObject.fromNativeHandle(vob));
			return false;
		}, Pointer.NULL);
		return objects;
	}
}
