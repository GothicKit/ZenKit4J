package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.Vec3f;
import dev.gothickit.zenkit.ani.AnimationSample;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;

public class Mover extends Trigger {
	public Mover() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCMover));
	}

	public Mover(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkMover_load(buf.getHandle(), version), ZenKit.API::ZkMover_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Mover vob");
	}

	public Mover(String path, GameVersion version) {
		super(ZenKit.API.ZkMover_loadPath(path, version), ZenKit.API::ZkMover_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Mover vob");
	}

	public Mover(Pointer handle) {
		super(handle, ZenKit.API::ZkMover_del);
	}

	public MoverBehavior getBehavior() {
		return ZenKit.API.ZkMover_getBehavior(getHandle());
	}

	public void setBehavior(MoverBehavior val) {
		ZenKit.API.ZkMover_setBehavior(getHandle(), val);
	}

	public float getTouchBlockerDamage() {
		return ZenKit.API.ZkMover_getTouchBlockerDamage(getHandle());
	}

	public void setTouchBlockerDamage(float val) {
		ZenKit.API.ZkMover_setTouchBlockerDamage(getHandle(), val);
	}

	public Duration getStayOpenTime() {
		return Duration.ofSeconds((long) ZenKit.API.ZkMover_getStayOpenTimeSeconds(getHandle()));
	}

	public void setStayOpenTime(@NotNull Duration val) {
		ZenKit.API.ZkMover_setStayOpenTimeSeconds(getHandle(), val.getSeconds());
	}

	public boolean isLocked() {
		return ZenKit.API.ZkMover_getIsLocked(getHandle());
	}

	public void setLocked(boolean val) {
		ZenKit.API.ZkMover_setIsLocked(getHandle(), val);
	}

	public boolean getAutoLink() {
		return ZenKit.API.ZkMover_getAutoLink(getHandle());
	}

	public void setAutoLink(boolean val) {
		ZenKit.API.ZkMover_setAutoLink(getHandle(), val);
	}

	public boolean getAutoRotate() {
		return ZenKit.API.ZkMover_getAutoRotate(getHandle());
	}

	public void setAutoRotate(boolean val) {
		ZenKit.API.ZkMover_setAutoRotate(getHandle(), val);
	}

	public float getSpeed() {
		return ZenKit.API.ZkMover_getSpeed(getHandle());
	}

	public void setSpeed(float val) {
		ZenKit.API.ZkMover_setSpeed(getHandle(), val);
	}

	public MoverLerpType getLerpType() {
		return ZenKit.API.ZkMover_getLerpType(getHandle());
	}

	public void setLerpType(MoverLerpType val) {
		ZenKit.API.ZkMover_setLerpType(getHandle(), val);
	}

	public MoverSpeedType getSpeedType() {
		return ZenKit.API.ZkMover_getSpeedType(getHandle());
	}

	public void setSpeedType(MoverSpeedType val) {
		ZenKit.API.ZkMover_setSpeedType(getHandle(), val);
	}

	public AnimationSample[] getKeyframes() {
		var count = ZenKit.API.ZkMover_getKeyframeCount(getHandle());
		var weights = new AnimationSample[(int) count];

		for (int i = 0; i < count; i++) {
			weights[i] = ZenKit.API.ZkMover_getKeyframe(getHandle(), i);
		}

		return weights;
	}

	public String getSfxOpenStart() {
		return ZenKit.API.ZkMover_getSfxOpenStart(getHandle());
	}

	public void setSfxOpenStart(String val) {
		ZenKit.API.ZkMover_setSfxOpenStart(getHandle(), val);
	}

	public String getSfxOpenEnd() {
		return ZenKit.API.ZkMover_getSfxOpenEnd(getHandle());
	}

	public void setSfxOpenEnd(String val) {
		ZenKit.API.ZkMover_setSfxOpenEnd(getHandle(), val);
	}

	public String getSfxTransitioning() {
		return ZenKit.API.ZkMover_getSfxTransitioning(getHandle());
	}

	public void setSfxTransitioning(String val) {
		ZenKit.API.ZkMover_setSfxTransitioning(getHandle(), val);
	}

	public String getSfxCloseStart() {
		return ZenKit.API.ZkMover_getSfxCloseStart(getHandle());
	}

	public void setSfxCloseStart(String val) {
		ZenKit.API.ZkMover_setSfxCloseStart(getHandle(), val);
	}

	public String getSfxCloseEnd() {
		return ZenKit.API.ZkMover_getSfxCloseEnd(getHandle());
	}

	public void setSfxCloseEnd(String val) {
		ZenKit.API.ZkMover_setSfxCloseEnd(getHandle(), val);
	}

	public String getSfxLock() {
		return ZenKit.API.ZkMover_getSfxLock(getHandle());
	}

	public void setSfxLock(String val) {
		ZenKit.API.ZkMover_setSfxLock(getHandle(), val);
	}

	public String getSfxUnlock() {
		return ZenKit.API.ZkMover_getSfxUnlock(getHandle());
	}

	public void setSfxUnlock(String val) {
		ZenKit.API.ZkMover_setSfxUnlock(getHandle(), val);
	}

	public String getSfxUseLocked() {
		return ZenKit.API.ZkMover_getSfxUseLocked(getHandle());
	}

	public void setSfxUseLocked(String val) {
		ZenKit.API.ZkMover_setSfxUseLocked(getHandle(), val);
	}

	public Vec3f getActKeyPosDelta() {
		return ZenKit.API.ZkMover_getActKeyPosDelta(getHandle());
	}

	public float getActKeyframeF() {
		return ZenKit.API.ZkMover_getActKeyframeF(getHandle());
	}

	public int getActKeyframe() {
		return ZenKit.API.ZkMover_getActKeyframe(getHandle());
	}

	public int getNextKeyframe() {
		return ZenKit.API.ZkMover_getNextKeyframe(getHandle());
	}

	public float getMoveSpeedUnit() {
		return ZenKit.API.ZkMover_getMoveSpeedUnit(getHandle());
	}

	public float getAdvanceDir() {
		return ZenKit.API.ZkMover_getAdvanceDir(getHandle());
	}

	public int getMoverState() {
		return ZenKit.API.ZkMover_getMoverState(getHandle());
	}

	public int getTriggerEventCount() {
		return ZenKit.API.ZkMover_getTriggerEventCount(getHandle());
	}

	public float getStayOpenTimeDest() {
		return ZenKit.API.ZkMover_getStayOpenTimeDest(getHandle());
	}

	public void setActKeyPosDelta(Vec3f val) {
		ZenKit.API.ZkMover_setActKeyPosDelta(getHandle(), val);
	}

	public void setActKeyframeF(float val) {
		ZenKit.API.ZkMover_setActKeyframeF(getHandle(), val);
	}

	public void setActKeyframe(int val) {
		ZenKit.API.ZkMover_setActKeyframe(getHandle(), val);
	}

	public void setNextKeyframe(int val) {
		ZenKit.API.ZkMover_setNextKeyframe(getHandle(), val);
	}

	public void setMoveSpeedUnit(float val) {
		ZenKit.API.ZkMover_setMoveSpeedUnit(getHandle(), val);
	}

	public void setAdvanceDir(float val) {
		ZenKit.API.ZkMover_setAdvanceDir(getHandle(), val);
	}

	public void setMoverState(int val) {
		ZenKit.API.ZkMover_setMoverState(getHandle(), val);
	}

	public void setTriggerEventCount(int val) {
		ZenKit.API.ZkMover_setTriggerEventCount(getHandle(), val);
	}

	public void setStayOpenTimeDest(float val) {
		ZenKit.API.ZkMover_setStayOpenTimeDest(getHandle(), val);
	}
}
