package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.Vec3f;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;

public final class Earthquake extends VirtualObject {
	public Earthquake() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCEarthquake));
	}

	Earthquake(@NotNull NativeRead buf, GameVersion version) {
		super(ZenKit.API.ZkEarthquake_load(buf.getNativeHandle(), version), ZenKit.API::ZkEarthquake_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Earthquake vob");
	}

	Earthquake(String path, GameVersion version) {
		super(ZenKit.API.ZkEarthquake_loadPath(path, version), ZenKit.API::ZkEarthquake_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Earthquake vob");
	}

	Earthquake(Pointer handle) {
		super(handle, ZenKit.API::ZkEarthquake_del);
	}

	public float getRadius() {
		return ZenKit.API.ZkEarthquake_getRadius(getNativeHandle());
	}

	public void setRadius(float val) {
		ZenKit.API.ZkEarthquake_setRadius(getNativeHandle(), val);
	}

	public Duration getDuration() {
		return Duration.ofSeconds((long) ZenKit.API.ZkEarthquake_getDuration(getNativeHandle()));
	}

	public void setDuration(@NotNull Duration val) {
		ZenKit.API.ZkEarthquake_setDuration(getNativeHandle(), val.getSeconds());
	}

	public Vec3f getAmplitude() {
		return ZenKit.API.ZkEarthquake_getAmplitude(getNativeHandle());
	}

	public void setAmplitude(Vec3f val) {
		ZenKit.API.ZkEarthquake_setAmplitude(getNativeHandle(), val);
	}
}
