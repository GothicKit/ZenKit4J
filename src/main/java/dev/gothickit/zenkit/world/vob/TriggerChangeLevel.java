package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public final class TriggerChangeLevel extends Trigger {
	public TriggerChangeLevel() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.oCTriggerChangeLevel));
	}

	TriggerChangeLevel(@NotNull NativeRead buf, GameVersion version) {
		super(ZenKit.API.ZkTriggerChangeLevel_load(buf.getNativeHandle(), version), ZenKit.API::ZkTriggerChangeLevel_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load TriggerChangeLevel vob");
	}

	TriggerChangeLevel(String path, GameVersion version) {
		super(ZenKit.API.ZkTriggerChangeLevel_loadPath(path, version), ZenKit.API::ZkTriggerChangeLevel_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load TriggerChangeLevel vob");
	}

	TriggerChangeLevel(Pointer handle) {
		super(handle, ZenKit.API::ZkTriggerChangeLevel_del);
	}

	public String getLevelName() {
		return ZenKit.API.ZkTriggerChangeLevel_getLevelName(getNativeHandle());
	}

	public void setLevelName(String val) {
		ZenKit.API.ZkTriggerChangeLevel_setLevelName(getNativeHandle(), val);
	}

	public String getStartVob() {
		return ZenKit.API.ZkTriggerChangeLevel_getStartVob(getNativeHandle());
	}

	public void setStartVob(String val) {
		ZenKit.API.ZkTriggerChangeLevel_setStartVob(getNativeHandle(), val);
	}
}
