package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import dev.gothickit.zenkit.Color;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public class Light extends VirtualObject {
	public Light() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCVobLight));
	}

	public Light(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkLight_load(buf.getHandle(), version), ZenKit.API::ZkLight_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load light vob");
	}

	public Light(String path, GameVersion version) {
		super(ZenKit.API.ZkLight_loadPath(path, version), ZenKit.API::ZkLight_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load light vob");
	}

	public Light(Pointer handle) {
		super(handle, ZenKit.API::ZkLight_del);
	}

	public String getPreset() {
		return ZenKit.API.ZkLight_getPreset(getHandle());
	}

	public LightType getLightType() {
		return ZenKit.API.ZkLight_getLightType(getHandle());
	}

	public float getRange() {
		return ZenKit.API.ZkLight_getRange(getHandle());
	}

	public Color getColor() {
		return ZenKit.API.ZkLight_getColor(getHandle());
	}

	public float getConeAngle() {
		return ZenKit.API.ZkLight_getConeAngle(getHandle());
	}

	public boolean isLightStatic() {
		return ZenKit.API.ZkLight_getIsStatic(getHandle());
	}

	public LightQuality getQuality() {
		return ZenKit.API.ZkLight_getQuality(getHandle());
	}

	public String getLensflareFx() {
		return ZenKit.API.ZkLight_getLensflareFx(getHandle());
	}

	public boolean getOn() {
		return ZenKit.API.ZkLight_getOn(getHandle());
	}

	public float[] getRangeAnimationScale() {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkLight_getRangeAnimationScale(getHandle(), count);
		if (ptr == null || count.getValue() == 0) return new float[0];
		return ptr.getFloatArray(0, count.getValue());
	}

	public float getRangeAnimationFps() {
		return ZenKit.API.ZkLight_getRangeAnimationFps(getHandle());
	}

	public boolean getRangeAnimationSmooth() {
		return ZenKit.API.ZkLight_getRangeAnimationSmooth(getHandle());
	}

	public Color[] getColorAnimationList() {
		var count = ZenKit.API.ZkLight_getColorAnimationCount(getHandle());
		var colors = new Color[(int) count];

		for (int i = 0; i < count; i++) {
			colors[i] = ZenKit.API.ZkLight_getColorAnimationItem(getHandle(), i);
		}

		return colors;
	}

	public float getColorAnimationFps() {
		return ZenKit.API.ZkLight_getColorAnimationFps(getHandle());
	}

	public boolean getColorAnimationSmooth() {
		return ZenKit.API.ZkLight_getColorAnimationSmooth(getHandle());
	}

	public boolean getCanMove() {
		return ZenKit.API.ZkLight_getCanMove(getHandle());
	}

	public void setPreset(String val) {
		ZenKit.API.ZkLight_setPreset(getHandle(), val);
	}

	public void setLightType(LightType val) {
		ZenKit.API.ZkLight_setLightType(getHandle(), val);
	}

	public void setRange(float val) {
		ZenKit.API.ZkLight_setRange(getHandle(), val);
	}

	public void setColor(Color val) {
		ZenKit.API.ZkLight_setColor(getHandle(), val);
	}

	public void setConeAngle(float val) {
		ZenKit.API.ZkLight_setConeAngle(getHandle(), val);
	}

	public void setStatic(boolean val) {
		ZenKit.API.ZkLight_setIsStatic(getHandle(), val);
	}

	public void setQuality(LightQuality val) {
		ZenKit.API.ZkLight_setQuality(getHandle(), val);
	}

	public void setLensflareFx(String val) {
		ZenKit.API.ZkLight_setLensflareFx(getHandle(), val);
	}

	public void setOn(boolean val) {
		ZenKit.API.ZkLight_setOn(getHandle(), val);
	}

	public void setRangeAnimationScale(float[] val) {
		ZenKit.API.ZkLight_setRangeAnimationScale(getHandle(), val, val.length);
	}

	public void setRangeAnimationFps(float val) {
		ZenKit.API.ZkLight_setRangeAnimationFps(getHandle(), val);
	}

	public void setRangeAnimationSmooth(boolean val) {
		ZenKit.API.ZkLight_setRangeAnimationSmooth(getHandle(), val);
	}

	public void setColorAnimationFps(float val) {
		ZenKit.API.ZkLight_setColorAnimationFps(getHandle(), val);
	}

	public void setColorAnimationSmooth(boolean val) {
		ZenKit.API.ZkLight_setColorAnimationSmooth(getHandle(), val);
	}

	public void setCanMove(boolean val) {
		ZenKit.API.ZkLight_setCanMove(getHandle(), val);
	}
}
