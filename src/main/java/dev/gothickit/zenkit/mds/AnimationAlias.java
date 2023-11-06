package dev.gothickit.zenkit.mds;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;

public class AnimationAlias {
	private final Pointer handle;

	public AnimationAlias(Pointer handle) {
		this.handle = handle;
	}

	public String getName() {
		return ZenKit.API.ZkAnimationAlias_getName(handle);
	}

	public int getLayer() {
		return ZenKit.API.ZkAnimationAlias_getLayer(handle);
	}

	public String getNext() {
		return ZenKit.API.ZkAnimationAlias_getNext(handle);
	}

	public float getBlendIn() {
		return ZenKit.API.ZkAnimationAlias_getBlendIn(handle);
	}

	public float getBlendOut() {
		return ZenKit.API.ZkAnimationAlias_getBlendOut(handle);
	}

	public int getFlags() {
		return ZenKit.API.ZkAnimationAlias_getFlags(handle);
	}

	public String getAlias() {
		return ZenKit.API.ZkAnimationAlias_getAlias(handle);
	}

	public AnimationDirection getDirection() {
		return ZenKit.API.ZkAnimationAlias_getDirection(handle);
	}
}
