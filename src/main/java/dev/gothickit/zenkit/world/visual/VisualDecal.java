package dev.gothickit.zenkit.world.visual;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.Vec2f;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.mat.AlphaFunction;

public final class VisualDecal extends Visual {
	VisualDecal(Pointer handle) {
		super(handle);
	}

	public Vec2f getDimension() {
		return ZenKit.API.ZkVisualDecal_getDimension(getNativeHandle());
	}

	public void setDimension(Vec2f val) {
		ZenKit.API.ZkVisualDecal_setDimension(getNativeHandle(), val);
	}

	public Vec2f getOffset() {
		return ZenKit.API.ZkVisualDecal_getOffset(getNativeHandle());
	}

	public void setOffset(Vec2f val) {
		ZenKit.API.ZkVisualDecal_setOffset(getNativeHandle(), val);
	}

	public boolean isTwoSided() {
		return ZenKit.API.ZkVisualDecal_getTwoSided(getNativeHandle());
	}

	public AlphaFunction getAlphaFunction() {
		return ZenKit.API.ZkVisualDecal_getAlphaFunc(getNativeHandle());
	}

	public void setAlphaFunction(AlphaFunction val) {
		ZenKit.API.ZkVisualDecal_setAlphaFunc(getNativeHandle(), val);
	}

	public float getTextureAnimationFps() {
		return ZenKit.API.ZkVisualDecal_getTextureAnimFps(getNativeHandle());
	}

	public void setTextureAnimationFps(float val) {
		ZenKit.API.ZkVisualDecal_setTextureAnimFps(getNativeHandle(), val);
	}

	public byte getAlphaWeight() {
		return ZenKit.API.ZkVisualDecal_getAlphaWeight(getNativeHandle());
	}

	public void setAlphaWeight(byte val) {
		ZenKit.API.ZkVisualDecal_setAlphaWeight(getNativeHandle(), val);
	}

	public boolean getIgnoreDaylight() {
		return ZenKit.API.ZkVisualDecal_getIgnoreDaylight(getNativeHandle());
	}

	public void setIgnoreDaylight(boolean val) {
		ZenKit.API.ZkVisualDecal_setIgnoreDaylight(getNativeHandle(), val);
	}

	public void ssTwoSided(boolean val) {
		ZenKit.API.ZkVisualDecal_setTwoSided(getNativeHandle(), val);
	}
}
