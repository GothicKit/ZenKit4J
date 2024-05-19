package dev.gothickit.zenkit.way;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.Vec3f;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NativeWayPoint implements NativeObject, WayPoint {
	private final Pointer handle;

	private NativeWayPoint(Pointer handle) {
		this.handle = handle;
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable NativeWayPoint fromNativeHandle(Pointer handle) {
		if (handle == null) return null;
		return new NativeWayPoint(handle);
	}

	@Override
	public @NotNull String name() {
		return ZenKit.API.ZkWayPoint_getName(handle);
	}

	@Override
	public int waterDepth() {
		return ZenKit.API.ZkWayPoint_getWaterDepth(handle);
	}

	@Override
	public boolean underWater() {
		return ZenKit.API.ZkWayPoint_getUnderWater(handle);
	}

	@Override
	public @NotNull Vec3f position() {
		return ZenKit.API.ZkWayPoint_getPosition(handle);
	}

	@Override
	public @NotNull Vec3f direction() {
		return ZenKit.API.ZkWayPoint_getDirection(handle);
	}

	@Override
	public boolean freePoint() {
		return ZenKit.API.ZkWayPoint_getFreePoint(handle);
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle;
	}

	@Override
	public @NotNull CachedWayPoint cache() {
		return new CachedWayPoint(
				name(),
				waterDepth(),
				underWater(),
				position(),
				direction(),
				freePoint()
		);
	}

	@Override
	public boolean isCached() {
		return false;
	}
}
