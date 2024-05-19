package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class LightPreset implements NativeObject {
	private final Handle handle;

	private LightPreset(@NotNull NativeRead buf, @NotNull GameVersion version) throws ResourceIOException {
		this.handle = new Handle(
				ZenKit.API.ZkLightPreset_load(buf.getNativeHandle(), version),
				ZenKit.API::ZkLightPreset_del
		);

		if (handle.isNull()) {
			throw new ResourceIOException(LightPreset.class, ResourceIOSource.STREAM, buf.toString());
		}
	}

	private LightPreset(@NotNull Vfs vfs, @NotNull String name, @NotNull GameVersion version) throws ResourceIOException {
		this(Objects.requireNonNull(vfs.find(name)).open(), version);
	}

	private LightPreset(String path, GameVersion version) throws ResourceIOException {
		this.handle = new Handle(ZenKit.API.ZkLightPreset_loadPath(path, version), ZenKit.API::ZkLightPreset_del);

		if (handle.isNull()) {
			throw new ResourceIOException(LightPreset.class, ResourceIOSource.DISK, path);
		}
	}

	@Contract("_, _ -> new")
	public static @NotNull LightPreset load(@NotNull String path, @NotNull GameVersion version) throws ResourceIOException {
		return new LightPreset(path, version);
	}

	@Contract("_, _ -> new")
	public static @NotNull LightPreset load(@NotNull Read buf, @NotNull GameVersion version) throws ResourceIOException {
		return new LightPreset(Read.adapt(buf), version);
	}

	@Contract("_, _, _ -> new")
	public static @NotNull LightPreset load(@NotNull Vfs vfs, @NotNull String name, @NotNull GameVersion version) throws ResourceIOException {
		return new LightPreset(vfs, name, version);
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle.get();
	}

	public String getPreset() {
		return ZenKit.API.ZkLightPreset_getPreset(getNativeHandle());
	}

	public void setPreset(String val) {
		ZenKit.API.ZkLightPreset_setPreset(getNativeHandle(), val);
	}

	public LightType getLightType() {
		return ZenKit.API.ZkLightPreset_getLightType(getNativeHandle());
	}

	public void setLightType(LightType val) {
		ZenKit.API.ZkLightPreset_setLightType(getNativeHandle(), val);
	}

	public float getRange() {
		return ZenKit.API.ZkLightPreset_getRange(getNativeHandle());
	}

	public void setRange(float val) {
		ZenKit.API.ZkLightPreset_setRange(getNativeHandle(), val);
	}

	public Color getColor() {
		return ZenKit.API.ZkLightPreset_getColor(getNativeHandle());
	}

	public void setColor(Color val) {
		ZenKit.API.ZkLightPreset_setColor(getNativeHandle(), val);
	}

	public float getConeAngle() {
		return ZenKit.API.ZkLightPreset_getConeAngle(getNativeHandle());
	}

	public void setConeAngle(float val) {
		ZenKit.API.ZkLightPreset_setConeAngle(getNativeHandle(), val);
	}

	public boolean isLightStatic() {
		return ZenKit.API.ZkLightPreset_getIsStatic(getNativeHandle());
	}

	public LightQuality getQuality() {
		return ZenKit.API.ZkLightPreset_getQuality(getNativeHandle());
	}

	public void setQuality(LightQuality val) {
		ZenKit.API.ZkLightPreset_setQuality(getNativeHandle(), val);
	}

	public String getLensflareFx() {
		return ZenKit.API.ZkLightPreset_getLensflareFx(getNativeHandle());
	}

	public void setLensflareFx(String val) {
		ZenKit.API.ZkLightPreset_setLensflareFx(getNativeHandle(), val);
	}

	public boolean getOn() {
		return ZenKit.API.ZkLightPreset_getOn(getNativeHandle());
	}

	public void setOn(boolean val) {
		ZenKit.API.ZkLightPreset_setOn(getNativeHandle(), val);
	}

	public float[] getRangeAnimationScale() {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkLightPreset_getRangeAnimationScale(getNativeHandle(), count);
		if (ptr == null || count.getValue() == 0) return new float[0];
		return ptr.getFloatArray(0, count.getValue());

	}

	public float getRangeAnimationFps() {
		return ZenKit.API.ZkLightPreset_getRangeAnimationFps(getNativeHandle());
	}

	public void setRangeAnimationFps(float val) {
		ZenKit.API.ZkLightPreset_setRangeAnimationFps(getNativeHandle(), val);
	}

	public boolean getRangeAnimationSmooth() {
		return ZenKit.API.ZkLightPreset_getRangeAnimationSmooth(getNativeHandle());
	}

	public void setRangeAnimationSmooth(boolean val) {
		ZenKit.API.ZkLightPreset_setRangeAnimationSmooth(getNativeHandle(), val);
	}

	public Color @NotNull [] getColorAnimationList() {
		var count = ZenKit.API.ZkLightPreset_getColorAnimationCount(getNativeHandle());
		var colors = new Color[(int) count];

		for (int i = 0; i < count; i++) {
			colors[i] = ZenKit.API.ZkLightPreset_getColorAnimationItem(getNativeHandle(), i);
		}

		return colors;
	}

	public float getColorAnimationFps() {
		return ZenKit.API.ZkLightPreset_getColorAnimationFps(getNativeHandle());
	}

	public void setColorAnimationFps(float val) {
		ZenKit.API.ZkLightPreset_setColorAnimationFps(getNativeHandle(), val);
	}

	public boolean getColorAnimationSmooth() {
		return ZenKit.API.ZkLightPreset_getColorAnimationSmooth(getNativeHandle());
	}

	public void setColorAnimationSmooth(boolean val) {
		ZenKit.API.ZkLightPreset_setColorAnimationSmooth(getNativeHandle(), val);
	}

	public boolean getCanMove() {
		return ZenKit.API.ZkLightPreset_getCanMove(getNativeHandle());
	}

	public void setCanMove(boolean val) {
		ZenKit.API.ZkLightPreset_setCanMove(getNativeHandle(), val);
	}

	public void ssLightStatic(boolean val) {
		ZenKit.API.ZkLightPreset_setIsStatic(getNativeHandle(), val);
	}

	public void getRangeAnimationScale(float[] val) {
		ZenKit.API.ZkLightPreset_setRangeAnimationScale(getNativeHandle(), val, val.length);
	}
}
