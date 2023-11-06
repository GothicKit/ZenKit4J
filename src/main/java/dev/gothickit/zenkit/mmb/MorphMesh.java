package dev.gothickit.zenkit.mmb;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.Vec3f;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.mrm.MultiResolutionMesh;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MorphMesh {
	private final Handle handle;

	public MorphMesh(@NotNull Read buf) {
		this.handle = new Handle(ZenKit.API.ZkMorphMesh_load(buf.getHandle()), ZenKit.API::ZkMorphMesh_del);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load morph mesh");
	}

	public MorphMesh(String path) {
		this.handle = new Handle(ZenKit.API.ZkMorphMesh_loadPath(path), ZenKit.API::ZkMorphMesh_del);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load morph mesh");
	}

	public MorphMesh(@NotNull Vfs vfs, String name) {
		this.handle = new Handle(ZenKit.API.ZkMorphMesh_loadVfs(vfs.getHandle(), name), ZenKit.API::ZkMorphMesh_del);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load morph mesh");
	}

	public Pointer getHandle() {
		return handle.get();
	}

	public String getName() {
		return ZenKit.API.ZkMorphMesh_getName(this.getHandle());
	}

	public MultiResolutionMesh getMesh() {
		return new MultiResolutionMesh(ZenKit.API.ZkMorphMesh_getMesh(this.getHandle()));
	}

	public Vec3f[] getMorphPositions() {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkMorphMesh_getMorphPositions(this.getHandle(), count);
		if (ptr == null || count.getValue() == 0) return new Vec3f[0];
		return (Vec3f[]) ptr.toArray(count.getValue());
	}

	public long getAnimationCount() {
		return ZenKit.API.ZkMorphMesh_getAnimationCount(this.getHandle());
	}

	public MorphAnimation getAnimation(long i) {
		var ptr = ZenKit.API.ZkMorphMesh_getAnimation(this.getHandle(), i);
		if (ptr == Pointer.NULL) return null;
		return new MorphAnimation(ptr);
	}

	public List<MorphAnimation> getAnimations() {
		var animations = new ArrayList<MorphAnimation>();

		ZenKit.API.ZkMorphMesh_enumerateAnimations(this.getHandle(), (ctx, ani) -> {
			animations.add(new MorphAnimation(ani));
			return false;
		}, Pointer.NULL);

		return animations;
	}

	public long getSourceCount() {
		return ZenKit.API.ZkMorphMesh_getSourceCount(this.getHandle());
	}

	public MorphSource getSource(long i) {
		var ptr = ZenKit.API.ZkMorphMesh_getSource(this.getHandle(), i);
		if (ptr == Pointer.NULL) return null;
		return new MorphSource(ptr);
	}

	public List<MorphSource> getSources() {
		var sources = new ArrayList<MorphSource>();

		ZenKit.API.ZkMorphMesh_enumerateSources(this.getHandle(), (ctx, src) -> {
			sources.add(new MorphSource(src));
			return false;
		}, Pointer.NULL);

		return sources;
	}
}
