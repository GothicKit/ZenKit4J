package dev.gothickit.zenkit.mds;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;

public class AnimationCombine {
	private final Pointer handle;

	public AnimationCombine(Pointer handle) {

		this.handle = handle;
	}

	public String getName() {
		return ZenKit.API.ZkAnimationCombine_getName(handle);
	}

	public int getLayer() {
		return ZenKit.API.ZkAnimationCombine_getLayer(handle);
	}

	public String getNext() {
		return ZenKit.API.ZkAnimationCombine_getNext(handle);
	}

	public float getBlendIn() {
		return ZenKit.API.ZkAnimationCombine_getBlendIn(handle);
	}

	public float getBlendOut() {
		return ZenKit.API.ZkAnimationCombine_getBlendOut(handle);
	}

	public int getFlags() {
		return ZenKit.API.ZkAnimationCombine_getFlags(handle);
	}

	public String getModel() {
		return ZenKit.API.ZkAnimationCombine_getModel(handle);
	}

	public int getLastFrame() {
		return ZenKit.API.ZkAnimationCombine_getLastFrame(handle);
	}
}
