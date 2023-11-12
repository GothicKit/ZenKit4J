package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public class InfoInstance extends DaedalusInstance {
	public InfoInstance(Pointer handle) {
		super(handle);
	}

	public int getNpc() {
		return ZenKit.API.ZkInfoInstance_getNpc(getHandle());
	}

	public int getNr() {
		return ZenKit.API.ZkInfoInstance_getNr(getHandle());
	}

	public int getImportant() {
		return ZenKit.API.ZkInfoInstance_getImportant(getHandle());
	}

	public int getCondition() {
		return ZenKit.API.ZkInfoInstance_getCondition(getHandle());
	}

	public int getInformation() {
		return ZenKit.API.ZkInfoInstance_getInformation(getHandle());
	}

	public String getDescription() {
		return ZenKit.API.ZkInfoInstance_getDescription(getHandle());
	}

	public int getTrade() {
		return ZenKit.API.ZkInfoInstance_getTrade(getHandle());
	}

	public int getPermanent() {
		return ZenKit.API.ZkInfoInstance_getPermanent(getHandle());
	}
}
