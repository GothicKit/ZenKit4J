package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import dev.gothickit.zenkit.Color;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import org.jetbrains.annotations.NotNull;

public class LightPreset {
	private final Handle handle;

	public LightPreset(@NotNull Read buf, GameVersion version) {
		this.handle = new Handle(
				ZenKit.API.ZkLightPreset_load(buf.getHandle(), version),
				ZenKit.API::ZkLightPreset_del
		);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load light preset");
	}

	public LightPreset(String path, GameVersion version) {
		this.handle = new Handle(ZenKit.API.ZkLightPreset_loadPath(path, version), ZenKit.API::ZkLightPreset_del);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load light preset");
	}

	public Pointer getHandle() {
		return handle.get();
	}

	public String getPreset() {
		return ZenKit.API.ZkLightPreset_getPreset(getHandle());
	}

	public LightType getLightType() {
		return ZenKit.API.ZkLightPreset_getLightType(getHandle());
	}

	public float getRange() {
		return ZenKit.API.ZkLightPreset_getRange(getHandle());
	}

	public Color getColor() {
		return ZenKit.API.ZkLightPreset_getColor(getHandle());
	}

	public float getConeAngle() {
		return ZenKit.API.ZkLightPreset_getConeAngle(getHandle());
	}

	public boolean isLightStatic() {
		return ZenKit.API.ZkLightPreset_getIsStatic(getHandle());
	}

	public LightQuality getQuality() {
		return ZenKit.API.ZkLightPreset_getQuality(getHandle());
	}

	public String getLensflareFx() {
		return ZenKit.API.ZkLightPreset_getLensflareFx(getHandle());
	}

	public boolean getOn() {
		return ZenKit.API.ZkLightPreset_getOn(getHandle());
	}

	public float[] getRangeAnimationScale() {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkLightPreset_getRangeAnimationScale(getHandle(), count);
		if (ptr == null || count.getValue() == 0) return new float[0];
		return ptr.getFloatArray(0, count.getValue());

	}

	public float getRangeAnimationFps() {
		return ZenKit.API.ZkLightPreset_getRangeAnimationFps(getHandle());
	}

	public boolean getRangeAnimationSmooth() {
		return ZenKit.API.ZkLightPreset_getRangeAnimationSmooth(getHandle());
	}

	public Color[] getColorAnimationList() {
		var count = ZenKit.API.ZkLightPreset_getColorAnimationCount(getHandle());
		var colors = new Color[(int) count];

		for (int i = 0; i < count; i++) {
			colors[i] = ZenKit.API.ZkLightPreset_getColorAnimationItem(getHandle(), i);
		}

		return colors;
	}

	public float getColorAnimationFps() {
		return ZenKit.API.ZkLightPreset_getColorAnimationFps(getHandle());
	}

	public boolean getColorAnimationSmooth() {
		return ZenKit.API.ZkLightPreset_getColorAnimationSmooth(getHandle());
	}

	public boolean getCanMove() {
		return ZenKit.API.ZkLightPreset_getCanMove(getHandle());
	}

	public void setPreset(String val) {
		ZenKit.API.ZkLightPreset_setPreset(getHandle(), val);
	}

	public void setLightType(LightType val) {
		ZenKit.API.ZkLightPreset_setLightType(getHandle(), val);
	}

	public void setRange(float val) {
		ZenKit.API.ZkLightPreset_setRange(getHandle(), val);
	}

	public void setColor(Color val) {
		ZenKit.API.ZkLightPreset_setColor(getHandle(), (Color.ByValue) val);
	}

	public void setConeAngle(float val) {
		ZenKit.API.ZkLightPreset_setConeAngle(getHandle(), val);
	}

	public void ssLightStatic(boolean val) {
		ZenKit.API.ZkLightPreset_setIsStatic(getHandle(), val);
	}

	public void setQuality(LightQuality val) {
		ZenKit.API.ZkLightPreset_setQuality(getHandle(), val);
	}

	public void setLensflareFx(String val) {
		ZenKit.API.ZkLightPreset_setLensflareFx(getHandle(), val);
	}

	public void setOn(boolean val) {
		ZenKit.API.ZkLightPreset_setOn(getHandle(), val);
	}

	public void getRangeAnimationScale(float[] val) {
		ZenKit.API.ZkLightPreset_setRangeAnimationScale(getHandle(), val, val.length);
	}

	public void setRangeAnimationFps(float val) {
		ZenKit.API.ZkLightPreset_setRangeAnimationFps(getHandle(), val);
	}

	public void setRangeAnimationSmooth(boolean val) {
		ZenKit.API.ZkLightPreset_setRangeAnimationSmooth(getHandle(), val);
	}

	public void setColorAnimationFps(float val) {
		ZenKit.API.ZkLightPreset_setColorAnimationFps(getHandle(), val);
	}

	public void setColorAnimationSmooth(boolean val) {
		ZenKit.API.ZkLightPreset_setColorAnimationSmooth(getHandle(), val);
	}

	public void setCanMove(boolean val) {
		ZenKit.API.ZkLightPreset_setCanMove(getHandle(), val);
	}
}
