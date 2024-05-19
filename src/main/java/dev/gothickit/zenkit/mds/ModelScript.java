package dev.gothickit.zenkit.mds;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusScript;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public final class ModelScript implements NativeObject {
	private final Handle handle;

	private ModelScript(@NotNull NativeRead buf) throws ResourceIOException {
		this.handle = new Handle(ZenKit.API.ZkModelScript_load(buf.getNativeHandle()), ZenKit.API::ZkModelScript_del);

		if (handle.isNull()) {
			throw new ResourceIOException(DaedalusScript.class, ResourceIOSource.STREAM, buf.toString());
		}
	}

	private ModelScript(String path) throws ResourceIOException {
		this.handle = new Handle(ZenKit.API.ZkModelScript_loadPath(path), ZenKit.API::ZkModelScript_del);

		if (handle.isNull()) {
			throw new ResourceIOException(DaedalusScript.class, ResourceIOSource.DISK, path);
		}
	}

	private ModelScript(@NotNull Vfs vfs, String name) throws ResourceIOException {
		this.handle = new Handle(
				ZenKit.API.ZkModelScript_loadVfs(vfs.getNativeHandle(), name),
				ZenKit.API::ZkModelScript_del
		);

		if (handle.isNull()) {
			throw new ResourceIOException(DaedalusScript.class, ResourceIOSource.VFS, name);
		}
	}

	@Contract("_ -> new")
	public static @NotNull ModelScript load(@NotNull String path) throws ResourceIOException {
		return new ModelScript(path);
	}

	@Contract("_ -> new")
	public static @NotNull ModelScript load(@NotNull Read buf) throws ResourceIOException {
		return new ModelScript(Read.adapt(buf));
	}

	@Contract("_, _ -> new")
	public static @NotNull ModelScript load(@NotNull Vfs vfs, @NotNull String name) throws ResourceIOException {
		return new ModelScript(vfs, name);
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle.get();
	}

	public String getSkeletonName() {
		return ZenKit.API.ZkModelScript_getSkeletonName(getNativeHandle());
	}

	public boolean getSkeletonMeshDisabled() {
		return ZenKit.API.ZkModelScript_getSkeletonMeshDisabled(getNativeHandle());
	}

	public long getMeshCount() {
		return ZenKit.API.ZkModelScript_getMeshCount(getNativeHandle());
	}

	public long getDisabledAnimationsCount() {
		return ZenKit.API.ZkModelScript_getDisabledAnimationsCount(getNativeHandle());
	}

	public long getAnimationCombineCount() {
		return ZenKit.API.ZkModelScript_getAnimationCombineCount(getNativeHandle());
	}

	public long getAnimationBlendCount() {
		return ZenKit.API.ZkModelScript_getAnimationBlendCount(getNativeHandle());
	}

	public long getAnimationAliasCount() {
		return ZenKit.API.ZkModelScript_getAnimationAliasCount(getNativeHandle());
	}

	public long getModelTagCount() {
		return ZenKit.API.ZkModelScript_getModelTagCount(getNativeHandle());
	}

	public long getAnimationCount() {
		return ZenKit.API.ZkModelScript_getAnimationCount(getNativeHandle());
	}

	public String getDisabledAnimation(long i) {
		return ZenKit.API.ZkModelScript_getDisabledAnimation(getNativeHandle(), i);
	}

	public String getMesh(long i) {
		return ZenKit.API.ZkModelScript_getMesh(getNativeHandle(), i);
	}

	public AnimationCombine getAnimationCombine(long i) {
		return new AnimationCombine(ZenKit.API.ZkModelScript_getAnimationCombine(getNativeHandle(), i));
	}

	public AnimationBlend getAnimationBlend(long i) {
		return new AnimationBlend(ZenKit.API.ZkModelScript_getAnimationBlend(getNativeHandle(), i));
	}

	public AnimationAlias getAnimationAlias(long i) {
		return new AnimationAlias(ZenKit.API.ZkModelScript_getAnimationAlias(getNativeHandle(), i));
	}

	public String getModelTag(long i) {
		return ZenKit.API.ZkModelScript_getModelTag(getNativeHandle(), i);
	}

	public Animation getAnimation(long i) {
		return new Animation(ZenKit.API.ZkModelScript_getAnimation(getNativeHandle(), i));
	}

	public List<AnimationCombine> getAnimationCombines() {
		var arr = new ArrayList<AnimationCombine>();

		ZenKit.API.ZkModelScript_enumerateAnimationCombines(getNativeHandle(), (ctx, evt) -> {
			arr.add(new AnimationCombine(evt));
			return false;
		}, Pointer.NULL);

		return arr;
	}

	public List<String> getMeshes() {
		var arr = new ArrayList<String>();

		ZenKit.API.ZkModelScript_enumerateMeshes(getNativeHandle(), (ctx, evt) -> {
			arr.add(evt);
			return false;
		}, Pointer.NULL);

		return arr;
	}

	public List<String> getDisabledAnimations() {
		var arr = new ArrayList<String>();

		ZenKit.API.ZkModelScript_enumerateDisabledAnimations(getNativeHandle(), (ctx, evt) -> {
			arr.add(evt);
			return false;
		}, Pointer.NULL);

		return arr;
	}

	public List<AnimationBlend> getAnimationBlends() {
		var arr = new ArrayList<AnimationBlend>();

		ZenKit.API.ZkModelScript_enumerateAnimationBlends(getNativeHandle(), (ctx, evt) -> {
			arr.add(new AnimationBlend(evt));
			return false;
		}, Pointer.NULL);

		return arr;
	}

	public List<AnimationAlias> getAnimationAliases() {
		var arr = new ArrayList<AnimationAlias>();

		ZenKit.API.ZkModelScript_enumerateAnimationAliases(getNativeHandle(), (ctx, evt) -> {
			arr.add(new AnimationAlias(evt));
			return false;
		}, Pointer.NULL);

		return arr;
	}

	public List<String> getModelTags() {
		var arr = new ArrayList<String>();

		ZenKit.API.ZkModelScript_enumerateModelTags(getNativeHandle(), (ctx, evt) -> {
			arr.add(evt);
			return false;
		}, Pointer.NULL);

		return arr;
	}

	public List<Animation> getAnimations() {
		var arr = new ArrayList<Animation>();

		ZenKit.API.ZkModelScript_enumerateAnimations(getNativeHandle(), (ctx, evt) -> {
			arr.add(new Animation(evt));
			return false;
		}, Pointer.NULL);

		return arr;
	}
}
