package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public class TriggerScript extends Trigger {
	public TriggerScript(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkTriggerScript_load(buf.getHandle(), version), ZenKit.API::ZkTriggerScript_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load TriggerScript vob");
	}

	public TriggerScript(String path, GameVersion version) {
		super(ZenKit.API.ZkTriggerScript_loadPath(path, version), ZenKit.API::ZkTriggerScript_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load TriggerScript vob");
	}

	public TriggerScript(Pointer handle) {
		super(handle);
	}

	public String getFunction() {
		return ZenKit.API.ZkTriggerScript_getFunction(getHandle());
	}
}
