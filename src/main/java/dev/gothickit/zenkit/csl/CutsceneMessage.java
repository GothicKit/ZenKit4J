package dev.gothickit.zenkit.csl;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;

public class CutsceneMessage {
	private final Pointer handle;

	CutsceneMessage(Pointer handle) {
		this.handle = handle;
	}

	public int getType() {
		return ZenKit.API.ZkCutsceneMessage_getType(handle);
	}

	public String getText() {
		return ZenKit.API.ZkCutsceneMessage_getText(handle);
	}

	public String getName() {
		return ZenKit.API.ZkCutsceneMessage_getName(handle);
	}
}
