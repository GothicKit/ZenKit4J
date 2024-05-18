package dev.gothickit.zenkit.world.visual;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.Vec2f;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.mat.AlphaFunction;

public class VisualDecal extends Visual {
	public VisualDecal(Pointer handle) {
		super(handle);
	}

	public Vec2f getDimension() {
		return ZenKit.API.ZkVisualDecal_getDimension(getHandle());
	}

	public Vec2f getOffset() {
		return ZenKit.API.ZkVisualDecal_getOffset(getHandle());
	}

	public boolean isTwoSided() {
		return ZenKit.API.ZkVisualDecal_getTwoSided(getHandle());
	}

	public AlphaFunction getAlphaFunction() {
		return ZenKit.API.ZkVisualDecal_getAlphaFunc(getHandle());
	}

	public float getTextureAnimationFps() {
		return ZenKit.API.ZkVisualDecal_getTextureAnimFps(getHandle());
	}

	public byte getAlphaWeight() {
		return ZenKit.API.ZkVisualDecal_getAlphaWeight(getHandle());
	}

	public boolean getIgnoreDaylight() {
		return ZenKit.API.ZkVisualDecal_getIgnoreDaylight(getHandle());
	}

	public void setDimension(Vec2f val) {
		ZenKit.API.ZkVisualDecal_setDimension(getHandle(), val);
	}

	public void setOffset(Vec2f val) {
		ZenKit.API.ZkVisualDecal_setOffset(getHandle(), val);
	}

	public void ssTwoSided(boolean val) {
		ZenKit.API.ZkVisualDecal_setTwoSided(getHandle(), val);
	}

	public void setAlphaFunction(AlphaFunction val) {
		ZenKit.API.ZkVisualDecal_setAlphaFunc(getHandle(), val);
	}

	public void setTextureAnimationFps(float val) {
		ZenKit.API.ZkVisualDecal_setTextureAnimFps(getHandle(), val);
	}

	public void setAlphaWeight(byte val) {
		ZenKit.API.ZkVisualDecal_setAlphaWeight(getHandle(), val);
	}

	public void setIgnoreDaylight(boolean val) {
		ZenKit.API.ZkVisualDecal_setIgnoreDaylight(getHandle(), val);
	}
}
