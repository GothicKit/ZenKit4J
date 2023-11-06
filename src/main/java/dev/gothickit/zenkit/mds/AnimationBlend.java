package dev.gothickit.zenkit.mds;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;

public class AnimationBlend {
	private final Pointer handle;

	public AnimationBlend(Pointer handle) {
		this.handle = handle;
	}

	public String getName() {
		return ZenKit.API.ZkAnimationBlend_getName(handle);
	}

	public String getNext() {
		return ZenKit.API.ZkAnimationBlend_getNext(handle);
	}

	public float getBlendIn() {
		return ZenKit.API.ZkAnimationBlend_getBlendIn(handle);
	}

	public float getBlendOut() {
		return ZenKit.API.ZkAnimationBlend_getBlendOut(handle);
	}
}
