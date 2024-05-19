package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public final class TriggerScript extends Trigger {
	public TriggerScript() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.oCTriggerScript));
	}

	TriggerScript(@NotNull NativeRead buf, GameVersion version) {
		super(ZenKit.API.ZkTriggerScript_load(buf.getNativeHandle(), version), ZenKit.API::ZkTriggerScript_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load TriggerScript vob");
	}

	TriggerScript(String path, GameVersion version) {
		super(ZenKit.API.ZkTriggerScript_loadPath(path, version), ZenKit.API::ZkTriggerScript_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load TriggerScript vob");
	}

	TriggerScript(Pointer handle) {
		super(handle, ZenKit.API::ZkTriggerScript_del);
	}

	public String getFunction() {
		return ZenKit.API.ZkTriggerScript_getFunction(getNativeHandle());
	}

	public void setFunction(String val) {
		ZenKit.API.ZkTriggerScript_setFunction(getNativeHandle(), val);
	}
}
