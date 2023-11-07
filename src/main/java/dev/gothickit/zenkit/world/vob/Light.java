package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import dev.gothickit.zenkit.Color;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public class Light extends VirtualObject {

	public Light(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkLight_load(buf.getHandle(), version), ZenKit.API::ZkLight_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load light vob");
	}

	public Light(String path, GameVersion version) {
		super(ZenKit.API.ZkLight_loadPath(path, version), ZenKit.API::ZkLight_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load light vob");
	}

	public Light(Pointer handle) {
		super(handle);
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
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkLight_getColorAnimationList(getHandle(), count);
		if (ptr == null || count.getValue() == 0) return new Color[0];
		return (Color[]) ptr.toArray(count.getValue());
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
}
