package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public final class MissionInstance extends DaedalusInstance {
	public MissionInstance(Pointer handle) {
		super(handle);
	}

	public String getName() {
		return ZenKit.API.ZkMissionInstance_getName(getNativeHandle());
	}

	public String getDescription() {
		return ZenKit.API.ZkMissionInstance_getDescription(getNativeHandle());
	}

	public int getDuration() {
		return ZenKit.API.ZkMissionInstance_getDuration(getNativeHandle());
	}

	public int getImportant() {
		return ZenKit.API.ZkMissionInstance_getImportant(getNativeHandle());
	}

	public int getOfferConditions() {
		return ZenKit.API.ZkMissionInstance_getOfferConditions(getNativeHandle());
	}

	public int getOffer() {
		return ZenKit.API.ZkMissionInstance_getOffer(getNativeHandle());
	}

	public int getSuccessConditions() {
		return ZenKit.API.ZkMissionInstance_getSuccessConditions(getNativeHandle());
	}

	public int getSuccess() {
		return ZenKit.API.ZkMissionInstance_getSuccess(getNativeHandle());
	}

	public int getFailureConditions() {
		return ZenKit.API.ZkMissionInstance_getFailureConditions(getNativeHandle());
	}

	public int getFailure() {
		return ZenKit.API.ZkMissionInstance_getFailure(getNativeHandle());
	}

	public int getObsoleteConditions() {
		return ZenKit.API.ZkMissionInstance_getObsoleteConditions(getNativeHandle());
	}

	public int getObsolete() {
		return ZenKit.API.ZkMissionInstance_getObsolete(getNativeHandle());
	}

	public int getRunning() {
		return ZenKit.API.ZkMissionInstance_getRunning(getNativeHandle());
	}

}
