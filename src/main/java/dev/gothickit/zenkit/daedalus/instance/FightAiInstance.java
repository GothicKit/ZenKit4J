package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public class FightAiInstance extends DaedalusInstance {
	public FightAiInstance(Pointer handle) {
		super(handle);
	}

	public FightAiMove getMove(long i) {
		return ZenKit.API.ZkFightAiInstance_getMove(getHandle(), i);
	}
}
