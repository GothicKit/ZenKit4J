package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public final class FocusInstance extends DaedalusInstance {
	public FocusInstance(Pointer handle) {
		super(handle);
	}

	float getNpcLongrange() {
		return ZenKit.API.ZkFocusInstance_getNpcLongrange(getNativeHandle());
	}

	float getNpcRange1() {
		return ZenKit.API.ZkFocusInstance_getNpcRange1(getNativeHandle());
	}

	float getNpcRange2() {
		return ZenKit.API.ZkFocusInstance_getNpcRange2(getNativeHandle());
	}

	float getNpcAzi() {
		return ZenKit.API.ZkFocusInstance_getNpcAzi(getNativeHandle());
	}

	float getNpcElevdo() {
		return ZenKit.API.ZkFocusInstance_getNpcElevdo(getNativeHandle());
	}

	float getNpcElevup() {
		return ZenKit.API.ZkFocusInstance_getNpcElevup(getNativeHandle());
	}

	int getNpcPrio() {
		return ZenKit.API.ZkFocusInstance_getNpcPrio(getNativeHandle());
	}

	float getItemRange1() {
		return ZenKit.API.ZkFocusInstance_getItemRange1(getNativeHandle());
	}

	float getItemRange2() {
		return ZenKit.API.ZkFocusInstance_getItemRange2(getNativeHandle());
	}

	float getItemAzi() {
		return ZenKit.API.ZkFocusInstance_getItemAzi(getNativeHandle());
	}

	float getItemElevdo() {
		return ZenKit.API.ZkFocusInstance_getItemElevdo(getNativeHandle());
	}

	float getItemElevup() {
		return ZenKit.API.ZkFocusInstance_getItemElevup(getNativeHandle());
	}

	int getItemPrio() {
		return ZenKit.API.ZkFocusInstance_getItemPrio(getNativeHandle());
	}

	float getMobRange1() {
		return ZenKit.API.ZkFocusInstance_getMobRange1(getNativeHandle());
	}

	float getMobRange2() {
		return ZenKit.API.ZkFocusInstance_getMobRange2(getNativeHandle());
	}

	float getMobAzi() {
		return ZenKit.API.ZkFocusInstance_getMobAzi(getNativeHandle());
	}

	float getMobElevdo() {
		return ZenKit.API.ZkFocusInstance_getMobElevdo(getNativeHandle());
	}

	float getMobElevup() {
		return ZenKit.API.ZkFocusInstance_getMobElevup(getNativeHandle());
	}

	int getMobPrio() {
		return ZenKit.API.ZkFocusInstance_getMobPrio(getNativeHandle());
	}

}
