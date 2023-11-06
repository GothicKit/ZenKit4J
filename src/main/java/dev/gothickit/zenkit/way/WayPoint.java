package dev.gothickit.zenkit.way;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.Vec3f;
import dev.gothickit.zenkit.capi.ZenKit;

public class WayPoint {
	private final Pointer handle;

	public WayPoint(Pointer handle) {
		this.handle = handle;
	}

	public String getName() {
		return ZenKit.API.ZkWayPoint_getName(handle);
	}

	public int getWaterDepth() {
		return ZenKit.API.ZkWayPoint_getWaterDepth(handle);
	}

	public boolean isUnderWater() {
		return ZenKit.API.ZkWayPoint_getUnderWater(handle);
	}

	public Vec3f getPosition() {
		return ZenKit.API.ZkWayPoint_getPosition(handle);
	}

	public Vec3f getDirection() {
		return ZenKit.API.ZkWayPoint_getDirection(handle);
	}

	public boolean isFreePoint() {
		return ZenKit.API.ZkWayPoint_getFreePoint(handle);
	}
}
