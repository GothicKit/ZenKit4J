package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.Vec3f;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;

public class Earthquake extends VirtualObject {
	public Earthquake() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCEarthquake));
	}

	public Earthquake(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkEarthquake_load(buf.getHandle(), version), ZenKit.API::ZkEarthquake_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Earthquake vob");
	}

	public Earthquake(String path, GameVersion version) {
		super(ZenKit.API.ZkEarthquake_loadPath(path, version), ZenKit.API::ZkEarthquake_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Earthquake vob");
	}

	public Earthquake(Pointer handle) {
		super(handle, ZenKit.API::ZkEarthquake_del);
	}

	public float getRadius() {
		return ZenKit.API.ZkEarthquake_getRadius(getHandle());
	}

	public Duration getDuration() {
		return Duration.ofSeconds((long) ZenKit.API.ZkEarthquake_getDuration(getHandle()));
	}

	public Vec3f getAmplitude() {
		return ZenKit.API.ZkEarthquake_getAmplitude(getHandle());
	}

	public void setRadius(float val) {
		ZenKit.API.ZkEarthquake_setRadius(getHandle(), val);
	}

	public void setDuration(@NotNull Duration val) {
		ZenKit.API.ZkEarthquake_setDuration(getHandle(), val.getSeconds());
	}

	public void setAmplitude(Vec3f val) {
		ZenKit.API.ZkEarthquake_setAmplitude(getHandle(), val);
	}
}
