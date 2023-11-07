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
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkLightPreset_getColorAnimationList(getHandle(), count);
		if (ptr == null || count.getValue() == 0) return new Color[0];
		return (Color[]) ptr.toArray(count.getValue());
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
}
