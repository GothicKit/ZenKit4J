package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public class TriggerChangeLevel extends Trigger {
	public TriggerChangeLevel() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.oCTriggerChangeLevel));
	}

	public TriggerChangeLevel(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkTriggerChangeLevel_load(buf.getHandle(), version), ZenKit.API::ZkTriggerChangeLevel_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load TriggerChangeLevel vob");
	}

	public TriggerChangeLevel(String path, GameVersion version) {
		super(ZenKit.API.ZkTriggerChangeLevel_loadPath(path, version), ZenKit.API::ZkTriggerChangeLevel_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load TriggerChangeLevel vob");
	}

	public TriggerChangeLevel(Pointer handle) {
		super(handle, ZenKit.API::ZkTriggerChangeLevel_del);
	}

	public String getLevelName() {
		return ZenKit.API.ZkTriggerChangeLevel_getLevelName(getHandle());
	}

	public String getStartVob() {
		return ZenKit.API.ZkTriggerChangeLevel_getStartVob(getHandle());
	}

	public void setLevelName(String val) {
		ZenKit.API.ZkTriggerChangeLevel_setLevelName(getHandle(), val);
	}

	public void setStartVob(String val) {
		ZenKit.API.ZkTriggerChangeLevel_setStartVob(getHandle(), val);
	}
}
