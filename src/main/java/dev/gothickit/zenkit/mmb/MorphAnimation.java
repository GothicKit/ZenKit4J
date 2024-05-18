package dev.gothickit.zenkit.mmb;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import dev.gothickit.zenkit.Vec3f;
import dev.gothickit.zenkit.capi.ZenKit;

public class MorphAnimation {
	private final Pointer handle;

	public MorphAnimation(Pointer handle) {
		this.handle = handle;
	}

	public String getName() {
		return ZenKit.API.ZkMorphAnimation_getName(handle);
	}

	public int getLayer() {
		return ZenKit.API.ZkMorphAnimation_getLayer(handle);
	}

	public float getBlendIn() {
		return ZenKit.API.ZkMorphAnimation_getBlendIn(handle);
	}

	public float getBlendOut() {
		return ZenKit.API.ZkMorphAnimation_getBlendOut(handle);
	}

	public float getDuration() {
		return ZenKit.API.ZkMorphAnimation_getDuration(handle);
	}

	public float getSpeed() {
		return ZenKit.API.ZkMorphAnimation_getSpeed(handle);
	}

	public byte getFlags() {
		return ZenKit.API.ZkMorphAnimation_getFlags(handle);
	}

	public int getFrameCount() {
		return ZenKit.API.ZkMorphAnimation_getFrameCount(handle);
	}

	public int[] getVertices() {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkMorphAnimation_getVertices(handle, count);
		if (ptr == Pointer.NULL || count.getValue() == 0) return new int[0];
		return ptr.getIntArray(0, count.getValue());
	}

	public Vec3f[] getSamples() {
		var count = ZenKit.API.ZkMorphAnimation_getSampleCount(handle);
		var weights = new Vec3f[(int) count];

		for (int i = 0; i < count; i++) {
			weights[i] = ZenKit.API.ZkMorphAnimation_getSample(handle, i);
		}

		return weights;
	}
}
