package dev.gothickit.zenkit.csl;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;

public class CutsceneBlock {
	private final Pointer handle;

	CutsceneBlock(Pointer handle) {
		this.handle = handle;
	}

	public String getName() {
		return ZenKit.API.ZkCutsceneBlock_getName(handle);
	}

	public CutsceneMessage getMessage() {
		return new CutsceneMessage(ZenKit.API.ZkCutsceneBlock_getMessage(handle));
	}
}
