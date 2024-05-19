package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public final class TriggerWorldStart extends VirtualObject {
	public TriggerWorldStart() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCTriggerWorldStart));
	}

	TriggerWorldStart(@NotNull NativeRead buf, GameVersion version) {
		super(ZenKit.API.ZkTriggerWorldStart_load(buf.getNativeHandle(), version), ZenKit.API::ZkTriggerWorldStart_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load TriggerWorldStart vob");
	}

	TriggerWorldStart(String path, GameVersion version) {
		super(ZenKit.API.ZkTriggerWorldStart_loadPath(path, version), ZenKit.API::ZkTriggerWorldStart_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load TriggerWorldStart vob");
	}

	TriggerWorldStart(Pointer handle) {
		super(handle, ZenKit.API::ZkTriggerWorldStart_del);
	}

	public String getTarget() {
		return ZenKit.API.ZkTriggerWorldStart_getTarget(getNativeHandle());
	}

	public void setTarget(String val) {
		ZenKit.API.ZkTriggerWorldStart_setTarget(getNativeHandle(), val);
	}

	public boolean getFireOnce() {
		return ZenKit.API.ZkTriggerWorldStart_getFireOnce(getNativeHandle());
	}

	public void setFireOnce(boolean val) {
		ZenKit.API.ZkTriggerWorldStart_setFireOnce(getNativeHandle(), val);
	}

	public boolean getHasFired() {
		return ZenKit.API.ZkTriggerWorldStart_getHasFired(getNativeHandle());
	}

	public void setHasFired(boolean val) {
		ZenKit.API.ZkTriggerWorldStart_setHasFired(getNativeHandle(), val);
	}
}
