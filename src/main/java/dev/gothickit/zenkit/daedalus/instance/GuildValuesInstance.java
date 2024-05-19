package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public final class GuildValuesInstance extends DaedalusInstance {
	public GuildValuesInstance(Pointer handle) {
		super(handle);
	}

	public int getWaterDepthKnee(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getWaterDepthKnee(getNativeHandle(), i);
	}

	public int getWaterDepthChest(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getWaterDepthChest(getNativeHandle(), i);
	}

	public int getJumpUpHeight(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getJumpUpHeight(getNativeHandle(), i);
	}

	public int getSwimTime(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getSwimTime(getNativeHandle(), i);
	}

	public int getDiveTime(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getDiveTime(getNativeHandle(), i);
	}

	public int getStepHeight(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getStepHeight(getNativeHandle(), i);
	}

	public int getJumpLowHeight(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getJumpLowHeight(getNativeHandle(), i);
	}

	public int getJumpMidHeight(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getJumpMidHeight(getNativeHandle(), i);
	}

	public int getSlideAngle(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getSlideAngle(getNativeHandle(), i);
	}

	public int getSlideAngle2(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getSlideAngle2(getNativeHandle(), i);
	}

	public int getDisableAutoRoll(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getDisableAutoRoll(getNativeHandle(), i);
	}

	public int getSurfaceAlign(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getSurfaceAlign(getNativeHandle(), i);
	}

	public int getClimbHeadingAngle(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getClimbHeadingAngle(getNativeHandle(), i);
	}

	public int getClimbHorizAngle(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getClimbHorizAngle(getNativeHandle(), i);
	}

	public int getClimbGroundAngle(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getClimbGroundAngle(getNativeHandle(), i);
	}

	public int getFightRangeBase(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getFightRangeBase(getNativeHandle(), i);
	}

	public int getFightRangeFist(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getFightRangeFist(getNativeHandle(), i);
	}

	public int getFightRangeG(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getFightRangeG(getNativeHandle(), i);
	}

	public int getFightRange1Hs(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getFightRange1Hs(getNativeHandle(), i);
	}

	public int getFightRange1Ha(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getFightRange1Ha(getNativeHandle(), i);
	}

	public int getFightRange2Hs(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getFightRange2Hs(getNativeHandle(), i);
	}

	public int getFightRange2Ha(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getFightRange2Ha(getNativeHandle(), i);
	}

	public int getFallDownHeight(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getFallDownHeight(getNativeHandle(), i);
	}

	public int getFallDownDamage(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getFallDownDamage(getNativeHandle(), i);
	}

	public int getBloodDisabled(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getBloodDisabled(getNativeHandle(), i);
	}

	public int getBloodMaxDistance(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getBloodMaxDistance(getNativeHandle(), i);
	}

	public int getBloodAmount(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getBloodAmount(getNativeHandle(), i);
	}

	public int getBloodFlow(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getBloodFlow(getNativeHandle(), i);
	}

	public int getTurnSpeed(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getTurnSpeed(getNativeHandle(), i);
	}

	public String getBloodEmitter(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getBloodEmitter(getNativeHandle(), i);
	}

	public String getBloodTexture(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getBloodTexture(getNativeHandle(), i);
	}
}
