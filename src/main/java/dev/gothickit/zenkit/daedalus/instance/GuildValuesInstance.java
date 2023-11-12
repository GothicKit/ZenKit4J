package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public class GuildValuesInstance extends DaedalusInstance {
	public GuildValuesInstance(Pointer handle) {
		super(handle);
	}

	public int getWaterDepthKnee(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getWaterDepthKnee(getHandle(), i);
	}

	public int getWaterDepthChest(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getWaterDepthChest(getHandle(), i);
	}

	public int getJumpUpHeight(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getJumpUpHeight(getHandle(), i);
	}

	public int getSwimTime(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getSwimTime(getHandle(), i);
	}

	public int getDiveTime(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getDiveTime(getHandle(), i);
	}

	public int getStepHeight(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getStepHeight(getHandle(), i);
	}

	public int getJumpLowHeight(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getJumpLowHeight(getHandle(), i);
	}

	public int getJumpMidHeight(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getJumpMidHeight(getHandle(), i);
	}

	public int getSlideAngle(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getSlideAngle(getHandle(), i);
	}

	public int getSlideAngle2(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getSlideAngle2(getHandle(), i);
	}

	public int getDisableAutoRoll(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getDisableAutoRoll(getHandle(), i);
	}

	public int getSurfaceAlign(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getSurfaceAlign(getHandle(), i);
	}

	public int getClimbHeadingAngle(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getClimbHeadingAngle(getHandle(), i);
	}

	public int getClimbHorizAngle(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getClimbHorizAngle(getHandle(), i);
	}

	public int getClimbGroundAngle(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getClimbGroundAngle(getHandle(), i);
	}

	public int getFightRangeBase(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getFightRangeBase(getHandle(), i);
	}

	public int getFightRangeFist(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getFightRangeFist(getHandle(), i);
	}

	public int getFightRangeG(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getFightRangeG(getHandle(), i);
	}

	public int getFightRange1Hs(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getFightRange1Hs(getHandle(), i);
	}

	public int getFightRange1Ha(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getFightRange1Ha(getHandle(), i);
	}

	public int getFightRange2Hs(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getFightRange2Hs(getHandle(), i);
	}

	public int getFightRange2Ha(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getFightRange2Ha(getHandle(), i);
	}

	public int getFallDownHeight(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getFallDownHeight(getHandle(), i);
	}

	public int getFallDownDamage(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getFallDownDamage(getHandle(), i);
	}

	public int getBloodDisabled(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getBloodDisabled(getHandle(), i);
	}

	public int getBloodMaxDistance(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getBloodMaxDistance(getHandle(), i);
	}

	public int getBloodAmount(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getBloodAmount(getHandle(), i);
	}

	public int getBloodFlow(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getBloodFlow(getHandle(), i);
	}

	public int getTurnSpeed(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getTurnSpeed(getHandle(), i);
	}

	public String getBloodEmitter(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getBloodEmitter(getHandle(), i);
	}

	public String getBloodTexture(long i) {
		return ZenKit.API.ZkGuildValuesInstance_getBloodTexture(getHandle(), i);
	}
}
