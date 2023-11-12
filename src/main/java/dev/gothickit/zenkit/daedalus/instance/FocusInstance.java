package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public class FocusInstance extends DaedalusInstance {
	public FocusInstance(Pointer handle) {
		super(handle);
	}

	float getNpcLongrange() {
		return ZenKit.API.ZkFocusInstance_getNpcLongrange(getHandle());
	}

	float getNpcRange1() {
		return ZenKit.API.ZkFocusInstance_getNpcRange1(getHandle());
	}

	float getNpcRange2() {
		return ZenKit.API.ZkFocusInstance_getNpcRange2(getHandle());
	}

	float getNpcAzi() {
		return ZenKit.API.ZkFocusInstance_getNpcAzi(getHandle());
	}

	float getNpcElevdo() {
		return ZenKit.API.ZkFocusInstance_getNpcElevdo(getHandle());
	}

	float getNpcElevup() {
		return ZenKit.API.ZkFocusInstance_getNpcElevup(getHandle());
	}

	int getNpcPrio() {
		return ZenKit.API.ZkFocusInstance_getNpcPrio(getHandle());
	}

	float getItemRange1() {
		return ZenKit.API.ZkFocusInstance_getItemRange1(getHandle());
	}

	float getItemRange2() {
		return ZenKit.API.ZkFocusInstance_getItemRange2(getHandle());
	}

	float getItemAzi() {
		return ZenKit.API.ZkFocusInstance_getItemAzi(getHandle());
	}

	float getItemElevdo() {
		return ZenKit.API.ZkFocusInstance_getItemElevdo(getHandle());
	}

	float getItemElevup() {
		return ZenKit.API.ZkFocusInstance_getItemElevup(getHandle());
	}

	int getItemPrio() {
		return ZenKit.API.ZkFocusInstance_getItemPrio(getHandle());
	}

	float getMobRange1() {
		return ZenKit.API.ZkFocusInstance_getMobRange1(getHandle());
	}

	float getMobRange2() {
		return ZenKit.API.ZkFocusInstance_getMobRange2(getHandle());
	}

	float getMobAzi() {
		return ZenKit.API.ZkFocusInstance_getMobAzi(getHandle());
	}

	float getMobElevdo() {
		return ZenKit.API.ZkFocusInstance_getMobElevdo(getHandle());
	}

	float getMobElevup() {
		return ZenKit.API.ZkFocusInstance_getMobElevup(getHandle());
	}

	int getMobPrio() {
		return ZenKit.API.ZkFocusInstance_getMobPrio(getHandle());
	}

}
