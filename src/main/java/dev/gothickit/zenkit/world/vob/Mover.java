package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.Vec3f;
import dev.gothickit.zenkit.ani.AnimationSample;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;

public final class Mover extends Trigger {
	public Mover() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCMover));
	}

	Mover(@NotNull NativeRead buf, GameVersion version) {
		super(ZenKit.API.ZkMover_load(buf.getNativeHandle(), version), ZenKit.API::ZkMover_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Mover vob");
	}

	Mover(String path, GameVersion version) {
		super(ZenKit.API.ZkMover_loadPath(path, version), ZenKit.API::ZkMover_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Mover vob");
	}

	Mover(Pointer handle) {
		super(handle, ZenKit.API::ZkMover_del);
	}

	public MoverBehavior getBehavior() {
		return ZenKit.API.ZkMover_getBehavior(getNativeHandle());
	}

	public void setBehavior(MoverBehavior val) {
		ZenKit.API.ZkMover_setBehavior(getNativeHandle(), val);
	}

	public float getTouchBlockerDamage() {
		return ZenKit.API.ZkMover_getTouchBlockerDamage(getNativeHandle());
	}

	public void setTouchBlockerDamage(float val) {
		ZenKit.API.ZkMover_setTouchBlockerDamage(getNativeHandle(), val);
	}

	public Duration getStayOpenTime() {
		return Duration.ofSeconds((long) ZenKit.API.ZkMover_getStayOpenTimeSeconds(getNativeHandle()));
	}

	public void setStayOpenTime(@NotNull Duration val) {
		ZenKit.API.ZkMover_setStayOpenTimeSeconds(getNativeHandle(), val.getSeconds());
	}

	public boolean isLocked() {
		return ZenKit.API.ZkMover_getIsLocked(getNativeHandle());
	}

	public void setLocked(boolean val) {
		ZenKit.API.ZkMover_setIsLocked(getNativeHandle(), val);
	}

	public boolean getAutoLink() {
		return ZenKit.API.ZkMover_getAutoLink(getNativeHandle());
	}

	public void setAutoLink(boolean val) {
		ZenKit.API.ZkMover_setAutoLink(getNativeHandle(), val);
	}

	public boolean getAutoRotate() {
		return ZenKit.API.ZkMover_getAutoRotate(getNativeHandle());
	}

	public void setAutoRotate(boolean val) {
		ZenKit.API.ZkMover_setAutoRotate(getNativeHandle(), val);
	}

	public float getSpeed() {
		return ZenKit.API.ZkMover_getSpeed(getNativeHandle());
	}

	public void setSpeed(float val) {
		ZenKit.API.ZkMover_setSpeed(getNativeHandle(), val);
	}

	public MoverLerpType getLerpType() {
		return ZenKit.API.ZkMover_getLerpType(getNativeHandle());
	}

	public void setLerpType(MoverLerpType val) {
		ZenKit.API.ZkMover_setLerpType(getNativeHandle(), val);
	}

	public MoverSpeedType getSpeedType() {
		return ZenKit.API.ZkMover_getSpeedType(getNativeHandle());
	}

	public void setSpeedType(MoverSpeedType val) {
		ZenKit.API.ZkMover_setSpeedType(getNativeHandle(), val);
	}

	public AnimationSample[] getKeyframes() {
		var count = ZenKit.API.ZkMover_getKeyframeCount(getNativeHandle());
		var weights = new AnimationSample[(int) count];

		for (int i = 0; i < count; i++) {
			weights[i] = ZenKit.API.ZkMover_getKeyframe(getNativeHandle(), i);
		}

		return weights;
	}

	public String getSfxOpenStart() {
		return ZenKit.API.ZkMover_getSfxOpenStart(getNativeHandle());
	}

	public void setSfxOpenStart(String val) {
		ZenKit.API.ZkMover_setSfxOpenStart(getNativeHandle(), val);
	}

	public String getSfxOpenEnd() {
		return ZenKit.API.ZkMover_getSfxOpenEnd(getNativeHandle());
	}

	public void setSfxOpenEnd(String val) {
		ZenKit.API.ZkMover_setSfxOpenEnd(getNativeHandle(), val);
	}

	public String getSfxTransitioning() {
		return ZenKit.API.ZkMover_getSfxTransitioning(getNativeHandle());
	}

	public void setSfxTransitioning(String val) {
		ZenKit.API.ZkMover_setSfxTransitioning(getNativeHandle(), val);
	}

	public String getSfxCloseStart() {
		return ZenKit.API.ZkMover_getSfxCloseStart(getNativeHandle());
	}

	public void setSfxCloseStart(String val) {
		ZenKit.API.ZkMover_setSfxCloseStart(getNativeHandle(), val);
	}

	public String getSfxCloseEnd() {
		return ZenKit.API.ZkMover_getSfxCloseEnd(getNativeHandle());
	}

	public void setSfxCloseEnd(String val) {
		ZenKit.API.ZkMover_setSfxCloseEnd(getNativeHandle(), val);
	}

	public String getSfxLock() {
		return ZenKit.API.ZkMover_getSfxLock(getNativeHandle());
	}

	public void setSfxLock(String val) {
		ZenKit.API.ZkMover_setSfxLock(getNativeHandle(), val);
	}

	public String getSfxUnlock() {
		return ZenKit.API.ZkMover_getSfxUnlock(getNativeHandle());
	}

	public void setSfxUnlock(String val) {
		ZenKit.API.ZkMover_setSfxUnlock(getNativeHandle(), val);
	}

	public String getSfxUseLocked() {
		return ZenKit.API.ZkMover_getSfxUseLocked(getNativeHandle());
	}

	public void setSfxUseLocked(String val) {
		ZenKit.API.ZkMover_setSfxUseLocked(getNativeHandle(), val);
	}

	public Vec3f getActKeyPosDelta() {
		return ZenKit.API.ZkMover_getActKeyPosDelta(getNativeHandle());
	}

	public void setActKeyPosDelta(Vec3f val) {
		ZenKit.API.ZkMover_setActKeyPosDelta(getNativeHandle(), val);
	}

	public float getActKeyframeF() {
		return ZenKit.API.ZkMover_getActKeyframeF(getNativeHandle());
	}

	public void setActKeyframeF(float val) {
		ZenKit.API.ZkMover_setActKeyframeF(getNativeHandle(), val);
	}

	public int getActKeyframe() {
		return ZenKit.API.ZkMover_getActKeyframe(getNativeHandle());
	}

	public void setActKeyframe(int val) {
		ZenKit.API.ZkMover_setActKeyframe(getNativeHandle(), val);
	}

	public int getNextKeyframe() {
		return ZenKit.API.ZkMover_getNextKeyframe(getNativeHandle());
	}

	public void setNextKeyframe(int val) {
		ZenKit.API.ZkMover_setNextKeyframe(getNativeHandle(), val);
	}

	public float getMoveSpeedUnit() {
		return ZenKit.API.ZkMover_getMoveSpeedUnit(getNativeHandle());
	}

	public void setMoveSpeedUnit(float val) {
		ZenKit.API.ZkMover_setMoveSpeedUnit(getNativeHandle(), val);
	}

	public float getAdvanceDir() {
		return ZenKit.API.ZkMover_getAdvanceDir(getNativeHandle());
	}

	public void setAdvanceDir(float val) {
		ZenKit.API.ZkMover_setAdvanceDir(getNativeHandle(), val);
	}

	public int getMoverState() {
		return ZenKit.API.ZkMover_getMoverState(getNativeHandle());
	}

	public void setMoverState(int val) {
		ZenKit.API.ZkMover_setMoverState(getNativeHandle(), val);
	}

	public int getTriggerEventCount() {
		return ZenKit.API.ZkMover_getTriggerEventCount(getNativeHandle());
	}

	public void setTriggerEventCount(int val) {
		ZenKit.API.ZkMover_setTriggerEventCount(getNativeHandle(), val);
	}

	public float getStayOpenTimeDest() {
		return ZenKit.API.ZkMover_getStayOpenTimeDest(getNativeHandle());
	}

	public void setStayOpenTimeDest(float val) {
		ZenKit.API.ZkMover_setStayOpenTimeDest(getNativeHandle(), val);
	}
}
