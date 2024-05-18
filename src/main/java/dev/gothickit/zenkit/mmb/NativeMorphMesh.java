package dev.gothickit.zenkit.mmb;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.mrm.MultiResolutionMesh;
import dev.gothickit.zenkit.mrm.NativeMultiResolutionMesh;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class NativeMorphMesh implements NativeObject, MorphMesh {
	private final Handle handle;

	NativeMorphMesh(@NotNull Read buf) throws ResourceIOException {
		this.handle = new Handle(ZenKit.API.ZkMorphMesh_load(buf.getHandle()), ZenKit.API::ZkMorphMesh_del);

		if (handle.isNull()) {
			throw new ResourceIOException(MorphMesh.class, ResourceIOSource.STREAM, buf.toString());
		}
	}

	NativeMorphMesh(String path) throws ResourceIOException {
		this.handle = new Handle(ZenKit.API.ZkMorphMesh_loadPath(path), ZenKit.API::ZkMorphMesh_del);

		if (handle.isNull()) {
			throw new ResourceIOException(MorphMesh.class, ResourceIOSource.DISK, path);
		}
	}

	NativeMorphMesh(@NotNull Vfs vfs, String name) throws ResourceIOException {
		this.handle = new Handle(ZenKit.API.ZkMorphMesh_loadVfs(vfs.getHandle(), name), ZenKit.API::ZkMorphMesh_del);

		if (handle.isNull()) {
			throw new ResourceIOException(MorphMesh.class, ResourceIOSource.VFS, name);
		}
	}


	@Override
	public @NotNull String name() {
		return ZenKit.API.ZkMorphMesh_getName(getNativeHandle());
	}

	@Override
	public MultiResolutionMesh mesh() {
		var ptr = ZenKit.API.ZkMorphMesh_getMesh(getNativeHandle());
		return NativeMultiResolutionMesh.fromNativeHandle(ptr);
	}

	@Override
	public Vec3f @NotNull [] morphPositions() {
		var count = ZenKit.API.ZkMorphMesh_getMorphPositionCount(getNativeHandle());
		var weights = new Vec3f[(int) count];

		for (int i = 0; i < count; i++) {
			weights[i] = ZenKit.API.ZkMorphMesh_getMorphPosition(getNativeHandle(), i);
		}

		return weights;
	}

	@Override
	public long animationCount() {
		return ZenKit.API.ZkMorphMesh_getAnimationCount(getNativeHandle());
	}

	@Override
	public MorphAnimation animation(long i) {
		var ptr = ZenKit.API.ZkMorphMesh_getAnimation(getNativeHandle(), i);
		if (ptr == Pointer.NULL) return null;
		return NativeMorphAnimation.fromNativeHandle(ptr);
	}

	@Override
	public @NotNull List<MorphAnimation> animations() {
		var animations = new ArrayList<MorphAnimation>();

		ZenKit.API.ZkMorphMesh_enumerateAnimations(getNativeHandle(), (ctx, ani) -> {
			animations.add(NativeMorphAnimation.fromNativeHandle(ani));
			return false;
		}, Pointer.NULL);

		return animations;
	}

	@Override
	public long sourceCount() {
		return ZenKit.API.ZkMorphMesh_getSourceCount(getNativeHandle());
	}

	@Override
	public MorphSource source(long i) {
		var ptr = ZenKit.API.ZkMorphMesh_getSource(getNativeHandle(), i);
		return NativeMorphSource.fromNativeHandle(ptr);
	}

	@Override
	public @NotNull List<MorphSource> sources() {
		var sources = new ArrayList<MorphSource>();

		ZenKit.API.ZkMorphMesh_enumerateSources(getNativeHandle(), (ctx, src) -> {
			sources.add(NativeMorphSource.fromNativeHandle(src));
			return false;
		}, Pointer.NULL);

		return sources;
	}

	@Override
	public @NotNull CachedMorphMesh cache() {
		var mesh = mesh();
		return new CachedMorphMesh(
				name(),
				mesh != null ? mesh.cache() : null,
				morphPositions(),
				animations().stream().map(CacheableObject::cache).collect(Collectors.toList()),
				sources().stream().map(CacheableObject::cache).collect(Collectors.toList())
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
