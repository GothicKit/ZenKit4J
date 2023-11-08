package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.ani.AnimationSample;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;

public class Mover extends Trigger {
	public Mover(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkMover_load(buf.getHandle(), version), ZenKit.API::ZkMover_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Mover vob");
	}

	public Mover(String path, GameVersion version) {
		super(ZenKit.API.ZkMover_loadPath(path, version), ZenKit.API::ZkMover_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Mover vob");
	}

	public Mover(Pointer handle) {
		super(handle);
	}

	public MoverBehavior getBehavior() {
		return ZenKit.API.ZkMover_getBehavior(getHandle());
	}

	public float getTouchBlockerDamage() {
		return ZenKit.API.ZkMover_getTouchBlockerDamage(getHandle());
	}

	public Duration getStayOpenTime() {
		return Duration.ofSeconds((long) ZenKit.API.ZkMover_getStayOpenTimeSeconds(getHandle()));
	}

	public boolean isLocked() {
		return ZenKit.API.ZkMover_getIsLocked(getHandle());
	}

	public boolean getAutoLink() {
		return ZenKit.API.ZkMover_getAutoLink(getHandle());
	}

	public boolean getAutoRotate() {
		return ZenKit.API.ZkMover_getAutoRotate(getHandle());
	}

	public float getSpeed() {
		return ZenKit.API.ZkMover_getSpeed(getHandle());
	}

	public MoverLerpType getLerpType() {
		return ZenKit.API.ZkMover_getLerpType(getHandle());
	}

	public MoverSpeedType getSpeedType() {
		return ZenKit.API.ZkMover_getSpeedType(getHandle());
	}

	public AnimationSample[] getKeyframes() {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkMover_getKeyframes(getHandle(), count);
		if (ptr == null || count.getValue() == 0) return new AnimationSample[0];
		return (AnimationSample[]) ptr.toArray(count.getValue());
	}

	public String getSfxOpenStart() {
		return ZenKit.API.ZkMover_getSfxOpenStart(getHandle());
	}

	public String getSfxOpenEnd() {
		return ZenKit.API.ZkMover_getSfxOpenEnd(getHandle());
	}

	public String getSfxTransitioning() {
		return ZenKit.API.ZkMover_getSfxTransitioning(getHandle());
	}

	public String getSfxCloseStart() {
		return ZenKit.API.ZkMover_getSfxCloseStart(getHandle());
	}

	public String getSfxCloseEnd() {
		return ZenKit.API.ZkMover_getSfxCloseEnd(getHandle());
	}

	public String getSfxLock() {
		return ZenKit.API.ZkMover_getSfxLock(getHandle());
	}

	public String getSfxUnlock() {
		return ZenKit.API.ZkMover_getSfxUnlock(getHandle());
	}

	public String getSfxUseLocked() {
		return ZenKit.API.ZkMover_getSfxUseLocked(getHandle());
	}
}
