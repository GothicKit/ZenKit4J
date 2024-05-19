package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public final class TriggerUntouch extends VirtualObject {
	public TriggerUntouch() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCTriggerUntouch));
	}

	TriggerUntouch(@NotNull NativeRead buf, GameVersion version) {
		super(ZenKit.API.ZkTriggerUntouch_load(buf.getNativeHandle(), version), ZenKit.API::ZkTriggerUntouch_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load TriggerUntouch vob");
	}

	TriggerUntouch(String path, GameVersion version) {
		super(ZenKit.API.ZkTriggerUntouch_loadPath(path, version), ZenKit.API::ZkTriggerUntouch_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load TriggerUntouch vob");
	}

	TriggerUntouch(Pointer handle) {
		super(handle, ZenKit.API::ZkTriggerUntouch_del);
	}

	public String getTarget() {
		return ZenKit.API.ZkTriggerUntouch_getTarget(getNativeHandle());
	}

	public void setTarget(String val) {
		ZenKit.API.ZkTriggerUntouch_setTarget(getNativeHandle(), val);
	}
}
