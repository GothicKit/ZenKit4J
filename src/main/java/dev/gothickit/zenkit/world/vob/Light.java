package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import dev.gothickit.zenkit.Color;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public final class Light extends VirtualObject {
	public Light() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCVobLight));
	}

	Light(@NotNull NativeRead buf, GameVersion version) {
		super(ZenKit.API.ZkLight_load(buf.getNativeHandle(), version), ZenKit.API::ZkLight_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load light vob");
	}

	Light(String path, GameVersion version) {
		super(ZenKit.API.ZkLight_loadPath(path, version), ZenKit.API::ZkLight_del);
	}

	Light(Pointer handle) {
		super(handle, ZenKit.API::ZkLight_del);
	}

	public String getPreset() {
		return ZenKit.API.ZkLight_getPreset(getNativeHandle());
	}

	public void setPreset(String val) {
		ZenKit.API.ZkLight_setPreset(getNativeHandle(), val);
	}

	public LightType getLightType() {
		return ZenKit.API.ZkLight_getLightType(getNativeHandle());
	}

	public void setLightType(LightType val) {
		ZenKit.API.ZkLight_setLightType(getNativeHandle(), val);
	}

	public float getRange() {
		return ZenKit.API.ZkLight_getRange(getNativeHandle());
	}

	public void setRange(float val) {
		ZenKit.API.ZkLight_setRange(getNativeHandle(), val);
	}

	public Color getColor() {
		return ZenKit.API.ZkLight_getColor(getNativeHandle());
	}

	public void setColor(Color val) {
		ZenKit.API.ZkLight_setColor(getNativeHandle(), val);
	}

	public float getConeAngle() {
		return ZenKit.API.ZkLight_getConeAngle(getNativeHandle());
	}

	public void setConeAngle(float val) {
		ZenKit.API.ZkLight_setConeAngle(getNativeHandle(), val);
	}

	public boolean isLightStatic() {
		return ZenKit.API.ZkLight_getIsStatic(getNativeHandle());
	}

	public LightQuality getQuality() {
		return ZenKit.API.ZkLight_getQuality(getNativeHandle());
	}

	public void setQuality(LightQuality val) {
		ZenKit.API.ZkLight_setQuality(getNativeHandle(), val);
	}

	public String getLensflareFx() {
		return ZenKit.API.ZkLight_getLensflareFx(getNativeHandle());
	}

	public void setLensflareFx(String val) {
		ZenKit.API.ZkLight_setLensflareFx(getNativeHandle(), val);
	}

	public boolean getOn() {
		return ZenKit.API.ZkLight_getOn(getNativeHandle());
	}

	public void setOn(boolean val) {
		ZenKit.API.ZkLight_setOn(getNativeHandle(), val);
	}

	public float[] getRangeAnimationScale() {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkLight_getRangeAnimationScale(getNativeHandle(), count);
		if (ptr == null || count.getValue() == 0) return new float[0];
		return ptr.getFloatArray(0, count.getValue());
	}

	public void setRangeAnimationScale(float[] val) {
		ZenKit.API.ZkLight_setRangeAnimationScale(getNativeHandle(), val, val.length);
	}

	public float getRangeAnimationFps() {
		return ZenKit.API.ZkLight_getRangeAnimationFps(getNativeHandle());
	}

	public void setRangeAnimationFps(float val) {
		ZenKit.API.ZkLight_setRangeAnimationFps(getNativeHandle(), val);
	}

	public boolean getRangeAnimationSmooth() {
		return ZenKit.API.ZkLight_getRangeAnimationSmooth(getNativeHandle());
	}

	public void setRangeAnimationSmooth(boolean val) {
		ZenKit.API.ZkLight_setRangeAnimationSmooth(getNativeHandle(), val);
	}

	public Color[] getColorAnimationList() {
		var count = ZenKit.API.ZkLight_getColorAnimationCount(getNativeHandle());
		var colors = new Color[(int) count];

		for (int i = 0; i < count; i++) {
			colors[i] = ZenKit.API.ZkLight_getColorAnimationItem(getNativeHandle(), i);
		}

		return colors;
	}

	public float getColorAnimationFps() {
		return ZenKit.API.ZkLight_getColorAnimationFps(getNativeHandle());
	}

	public void setColorAnimationFps(float val) {
		ZenKit.API.ZkLight_setColorAnimationFps(getNativeHandle(), val);
	}

	public boolean getColorAnimationSmooth() {
		return ZenKit.API.ZkLight_getColorAnimationSmooth(getNativeHandle());
	}

	public void setColorAnimationSmooth(boolean val) {
		ZenKit.API.ZkLight_setColorAnimationSmooth(getNativeHandle(), val);
	}

	public boolean getCanMove() {
		return ZenKit.API.ZkLight_getCanMove(getNativeHandle());
	}

	public void setCanMove(boolean val) {
		ZenKit.API.ZkLight_setCanMove(getNativeHandle(), val);
	}

	public void setStatic(boolean val) {
		ZenKit.API.ZkLight_setIsStatic(getNativeHandle(), val);
	}
}
