package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public class MissionInstance extends DaedalusInstance {
	public MissionInstance(Pointer handle) {
		super(handle);
	}

	public String getName() {
		return ZenKit.API.ZkMissionInstance_getName(getHandle());
	}

	public String getDescription() {
		return ZenKit.API.ZkMissionInstance_getDescription(getHandle());
	}

	public int getDuration() {
		return ZenKit.API.ZkMissionInstance_getDuration(getHandle());
	}

	public int getImportant() {
		return ZenKit.API.ZkMissionInstance_getImportant(getHandle());
	}

	public int getOfferConditions() {
		return ZenKit.API.ZkMissionInstance_getOfferConditions(getHandle());
	}

	public int getOffer() {
		return ZenKit.API.ZkMissionInstance_getOffer(getHandle());
	}

	public int getSuccessConditions() {
		return ZenKit.API.ZkMissionInstance_getSuccessConditions(getHandle());
	}

	public int getSuccess() {
		return ZenKit.API.ZkMissionInstance_getSuccess(getHandle());
	}

	public int getFailureConditions() {
		return ZenKit.API.ZkMissionInstance_getFailureConditions(getHandle());
	}

	public int getFailure() {
		return ZenKit.API.ZkMissionInstance_getFailure(getHandle());
	}

	public int getObsoleteConditions() {
		return ZenKit.API.ZkMissionInstance_getObsoleteConditions(getHandle());
	}

	public int getObsolete() {
		return ZenKit.API.ZkMissionInstance_getObsolete(getHandle());
	}

	public int getRunning() {
		return ZenKit.API.ZkMissionInstance_getRunning(getHandle());
	}

}
