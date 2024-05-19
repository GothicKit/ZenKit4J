package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public final class InfoInstance extends DaedalusInstance {
	public InfoInstance(Pointer handle) {
		super(handle);
	}

	public int getNpc() {
		return ZenKit.API.ZkInfoInstance_getNpc(getNativeHandle());
	}

	public int getNr() {
		return ZenKit.API.ZkInfoInstance_getNr(getNativeHandle());
	}

	public int getImportant() {
		return ZenKit.API.ZkInfoInstance_getImportant(getNativeHandle());
	}

	public int getCondition() {
		return ZenKit.API.ZkInfoInstance_getCondition(getNativeHandle());
	}

	public int getInformation() {
		return ZenKit.API.ZkInfoInstance_getInformation(getNativeHandle());
	}

	public String getDescription() {
		return ZenKit.API.ZkInfoInstance_getDescription(getNativeHandle());
	}

	public int getTrade() {
		return ZenKit.API.ZkInfoInstance_getTrade(getNativeHandle());
	}

	public int getPermanent() {
		return ZenKit.API.ZkInfoInstance_getPermanent(getNativeHandle());
	}
}
