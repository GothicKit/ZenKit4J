package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public class TriggerScript extends Trigger {
	public TriggerScript() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.oCTriggerScript));
	}

	public TriggerScript(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkTriggerScript_load(buf.getHandle(), version), ZenKit.API::ZkTriggerScript_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load TriggerScript vob");
	}

	public TriggerScript(String path, GameVersion version) {
		super(ZenKit.API.ZkTriggerScript_loadPath(path, version), ZenKit.API::ZkTriggerScript_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load TriggerScript vob");
	}

	public TriggerScript(Pointer handle) {
		super(handle, ZenKit.API::ZkTriggerScript_del);
	}

	public String getFunction() {
		return ZenKit.API.ZkTriggerScript_getFunction(getHandle());
	}

	public void setFunction(String val) {
		ZenKit.API.ZkTriggerScript_setFunction(getHandle(), val);
	}
}
