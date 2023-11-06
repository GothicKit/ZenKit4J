package dev.gothickit.zenkit.mds;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ModelScript {
	private final Handle handle;

	public ModelScript(@NotNull Read buf) {
		this.handle = new Handle(ZenKit.API.ZkModelScript_load(buf.getHandle()), ZenKit.API::ZkModelScript_del);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load model script");
	}

	public ModelScript(String path) {
		this.handle = new Handle(ZenKit.API.ZkModelScript_loadPath(path), ZenKit.API::ZkModelScript_del);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load model script");
	}

	public ModelScript(@NotNull Vfs vfs, String name) {
		this.handle = new Handle(
				ZenKit.API.ZkModelScript_loadVfs(vfs.getHandle(), name),
				ZenKit.API::ZkModelScript_del
		);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load model script");
	}

	public Pointer getHandle() {
		return handle.get();
	}

	public String getSkeletonName() {
		return ZenKit.API.ZkModelScript_getSkeletonName(getHandle());
	}

	public boolean getSkeletonMeshDisabled() {
		return ZenKit.API.ZkModelScript_getSkeletonMeshDisabled(getHandle());
	}

	public long getMeshCount() {
		return ZenKit.API.ZkModelScript_getMeshCount(getHandle());
	}

	public long getDisabledAnimationsCount() {
		return ZenKit.API.ZkModelScript_getDisabledAnimationsCount(getHandle());
	}

	public long getAnimationCombineCount() {
		return ZenKit.API.ZkModelScript_getAnimationCombineCount(getHandle());
	}

	public long getAnimationBlendCount() {
		return ZenKit.API.ZkModelScript_getAnimationBlendCount(getHandle());
	}

	public long getAnimationAliasCount() {
		return ZenKit.API.ZkModelScript_getAnimationAliasCount(getHandle());
	}

	public long getModelTagCount() {
		return ZenKit.API.ZkModelScript_getModelTagCount(getHandle());
	}

	public long getAnimationCount() {
		return ZenKit.API.ZkModelScript_getAnimationCount(getHandle());
	}

	public String getDisabledAnimation(long i) {
		return ZenKit.API.ZkModelScript_getDisabledAnimation(getHandle(), i);
	}

	public String getMesh(long i) {
		return ZenKit.API.ZkModelScript_getMesh(getHandle(), i);
	}

	public AnimationCombine getAnimationCombine(long i) {
		return new AnimationCombine(ZenKit.API.ZkModelScript_getAnimationCombine(getHandle(), i));
	}

	public AnimationBlend getAnimationBlend(long i) {
		return new AnimationBlend(ZenKit.API.ZkModelScript_getAnimationBlend(getHandle(), i));
	}

	public AnimationAlias getAnimationAlias(long i) {
		return new AnimationAlias(ZenKit.API.ZkModelScript_getAnimationAlias(getHandle(), i));
	}

	public String getModelTag(long i) {
		return ZenKit.API.ZkModelScript_getModelTag(getHandle(), i);
	}

	public Animation getAnimation(long i) {
		return new Animation(ZenKit.API.ZkModelScript_getAnimation(getHandle(), i));
	}

	public List<AnimationCombine> getAnimationCombines() {
		var arr = new ArrayList<AnimationCombine>();

		ZenKit.API.ZkModelScript_enumerateAnimationCombines(getHandle(), (ctx, evt) -> {
			arr.add(new AnimationCombine(evt));
			return false;
		}, Pointer.NULL);

		return arr;
	}

	public List<String> getMeshes() {
		var arr = new ArrayList<String>();

		ZenKit.API.ZkModelScript_enumerateMeshes(getHandle(), (ctx, evt) -> {
			arr.add(evt);
			return false;
		}, Pointer.NULL);

		return arr;
	}

	public List<String> getDisabledAnimations() {
		var arr = new ArrayList<String>();

		ZenKit.API.ZkModelScript_enumerateDisabledAnimations(getHandle(), (ctx, evt) -> {
			arr.add(evt);
			return false;
		}, Pointer.NULL);

		return arr;
	}

	public List<AnimationBlend> getAnimationBlends() {
		var arr = new ArrayList<AnimationBlend>();

		ZenKit.API.ZkModelScript_enumerateAnimationBlends(getHandle(), (ctx, evt) -> {
			arr.add(new AnimationBlend(evt));
			return false;
		}, Pointer.NULL);

		return arr;
	}

	public List<AnimationAlias> getAnimationAliases() {
		var arr = new ArrayList<AnimationAlias>();

		ZenKit.API.ZkModelScript_enumerateAnimationAliases(getHandle(), (ctx, evt) -> {
			arr.add(new AnimationAlias(evt));
			return false;
		}, Pointer.NULL);

		return arr;
	}

	public List<String> getModelTags() {
		var arr = new ArrayList<String>();

		ZenKit.API.ZkModelScript_enumerateModelTags(getHandle(), (ctx, evt) -> {
			arr.add(evt);
			return false;
		}, Pointer.NULL);

		return arr;
	}

	public List<Animation> getAnimations() {
		var arr = new ArrayList<Animation>();

		ZenKit.API.ZkModelScript_enumerateAnimations(getHandle(), (ctx, evt) -> {
			arr.add(new Animation(evt));
			return false;
		}, Pointer.NULL);

		return arr;
	}
}
