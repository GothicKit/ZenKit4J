package dev.gothickit.zenkit.mds;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusScript;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public final class NativeModelScript implements NativeObject, ModelScript {
	private final Handle handle;

	NativeModelScript(@NotNull NativeRead buf) throws ResourceIOException {
		this.handle = new Handle(ZenKit.API.ZkModelScript_load(buf.getNativeHandle()), ZenKit.API::ZkModelScript_del);

		if (handle.isNull()) {
			throw new ResourceIOException(DaedalusScript.class, ResourceIOSource.STREAM, buf.toString());
		}
	}

	NativeModelScript(String path) throws ResourceIOException {
		this.handle = new Handle(ZenKit.API.ZkModelScript_loadPath(path), ZenKit.API::ZkModelScript_del);

		if (handle.isNull()) {
			throw new ResourceIOException(DaedalusScript.class, ResourceIOSource.DISK, path);
		}
	}

	NativeModelScript(@NotNull Vfs vfs, String name) throws ResourceIOException {
		this.handle = new Handle(
				ZenKit.API.ZkModelScript_loadVfs(vfs.getNativeHandle(), name),
				ZenKit.API::ZkModelScript_del
		);

		if (handle.isNull()) {
			throw new ResourceIOException(DaedalusScript.class, ResourceIOSource.VFS, name);
		}
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle.get();
	}

	@Override
	public @NotNull String skeletonName() {
		return ZenKit.API.ZkModelScript_getSkeletonName(getNativeHandle());
	}

	@Override
	public boolean skeletonMeshDisabled() {
		return ZenKit.API.ZkModelScript_getSkeletonMeshDisabled(getNativeHandle());
	}

	@Override
	public long meshCount() {
		return ZenKit.API.ZkModelScript_getMeshCount(getNativeHandle());
	}

	@Override
	public long disabledAnimationsCount() {
		return ZenKit.API.ZkModelScript_getDisabledAnimationsCount(getNativeHandle());
	}

	@Override
	public long animationCombineCount() {
		return ZenKit.API.ZkModelScript_getAnimationCombineCount(getNativeHandle());
	}

	@Override
	public long animationBlendCount() {
		return ZenKit.API.ZkModelScript_getAnimationBlendCount(getNativeHandle());
	}

	@Override
	public long animationAliasCount() {
		return ZenKit.API.ZkModelScript_getAnimationAliasCount(getNativeHandle());
	}

	@Override
	public long modelTagCount() {
		return ZenKit.API.ZkModelScript_getModelTagCount(getNativeHandle());
	}

	@Override
	public long animationCount() {
		return ZenKit.API.ZkModelScript_getAnimationCount(getNativeHandle());
	}

	@Override
	public @NotNull String disabledAnimation(long i) {
		return ZenKit.API.ZkModelScript_getDisabledAnimation(getNativeHandle(), i);
	}

	@Override
	public @Nullable String mesh(long i) {
		return ZenKit.API.ZkModelScript_getMesh(getNativeHandle(), i);
	}

	@Override
	public @Nullable AnimationCombine animationCombine(long i) {
		var ptr = ZenKit.API.ZkModelScript_getAnimationCombine(getNativeHandle(), i);
		return NativeAnimationCombine.fromNativeHandle(ptr);
	}

	@Override
	public @Nullable AnimationBlend animationBlend(long i) {
		var ptr = ZenKit.API.ZkModelScript_getAnimationBlend(getNativeHandle(), i);
		return NativeAnimationBlend.fromNativeHandle(ptr);
	}

	@Override
	public @Nullable AnimationAlias animationAlias(long i) {
		var ptr = ZenKit.API.ZkModelScript_getAnimationAlias(getNativeHandle(), i);
		return NativeAnimationAlias.fromNativeHandle(ptr);
	}

	@Override
	public @NotNull String modelTag(long i) {
		return ZenKit.API.ZkModelScript_getModelTag(getNativeHandle(), i);
	}

	@Override
	public @Nullable NativeAnimation animation(long i) {
		var ptr = ZenKit.API.ZkModelScript_getAnimation(getNativeHandle(), i);
		return NativeAnimation.fromNativeHandle(ptr);
	}

	@Override
	public @NotNull List<@NotNull AnimationCombine> animationCombines() {
		var arr = new ArrayList<AnimationCombine>();

		ZenKit.API.ZkModelScript_enumerateAnimationCombines(getNativeHandle(), (ctx, evt) -> {
			arr.add(NativeAnimationCombine.fromNativeHandle(evt));
			return false;
		}, Pointer.NULL);

		return arr;
	}

	@Override
	public @NotNull List<@NotNull String> meshes() {
		var arr = new ArrayList<String>();

		ZenKit.API.ZkModelScript_enumerateMeshes(getNativeHandle(), (ctx, evt) -> {
			arr.add(evt);
			return false;
		}, Pointer.NULL);

		return arr;
	}

	@Override
	public @NotNull List<@NotNull String> disabledAnimations() {
		var arr = new ArrayList<String>();

		ZenKit.API.ZkModelScript_enumerateDisabledAnimations(getNativeHandle(), (ctx, evt) -> {
			arr.add(evt);
			return false;
		}, Pointer.NULL);

		return arr;
	}

	@Override
	public @NotNull List<@NotNull AnimationBlend> animationBlends() {
		var arr = new ArrayList<AnimationBlend>();

		ZenKit.API.ZkModelScript_enumerateAnimationBlends(getNativeHandle(), (ctx, evt) -> {
			arr.add(NativeAnimationBlend.fromNativeHandle(evt));
			return false;
		}, Pointer.NULL);

		return arr;
	}

	@Override
	public @NotNull List<@NotNull AnimationAlias> animationAliases() {
		var arr = new ArrayList<AnimationAlias>();

		ZenKit.API.ZkModelScript_enumerateAnimationAliases(getNativeHandle(), (ctx, evt) -> {
			arr.add(NativeAnimationAlias.fromNativeHandle(evt));
			return false;
		}, Pointer.NULL);

		return arr;
	}

	@Override
	public @NotNull List<@NotNull String> modelTags() {
		var arr = new ArrayList<String>();

		ZenKit.API.ZkModelScript_enumerateModelTags(getNativeHandle(), (ctx, evt) -> {
			arr.add(evt);
			return false;
		}, Pointer.NULL);

		return arr;
	}

	@Override
	public @NotNull List<@NotNull NativeAnimation> animations() {
		var arr = new ArrayList<NativeAnimation>();

		ZenKit.API.ZkModelScript_enumerateAnimations(getNativeHandle(), (ctx, evt) -> {
			arr.add(NativeAnimation.fromNativeHandle(evt));
			return false;
		}, Pointer.NULL);

		return arr;
	}
}
