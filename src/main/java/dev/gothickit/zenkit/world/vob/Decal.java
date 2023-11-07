package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.Vec2f;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.mat.AlphaFunction;

public class Decal {
	private final Pointer handle;

	public Decal(Pointer handle) {
		this.handle = handle;
	}

	public String getName() {
		return ZenKit.API.ZkDecal_getName(handle);
	}

	public Vec2f getDimension() {
		return ZenKit.API.ZkDecal_getDimension(handle);
	}

	public Vec2f getOffset() {
		return ZenKit.API.ZkDecal_getOffset(handle);
	}

	public boolean isTwoSided() {
		return ZenKit.API.ZkDecal_getTwoSided(handle);
	}

	public AlphaFunction getAlphaFunction() {
		return ZenKit.API.ZkDecal_getAlphaFunc(handle);
	}

	public float getTextureAnimationFps() {
		return ZenKit.API.ZkDecal_getTextureAnimFps(handle);
	}

	public byte getAlphaWeight() {
		return ZenKit.API.ZkDecal_getAlphaWeight(handle);
	}

	public boolean getIgnoreDaylight() {
		return ZenKit.API.ZkDecal_getIgnoreDaylight(handle);
	}
}
