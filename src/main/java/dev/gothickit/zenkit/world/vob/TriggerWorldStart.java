package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class TriggerWorldStart extends VirtualObject {
	public TriggerWorldStart() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCTriggerWorldStart));
	}

	public TriggerWorldStart(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkTriggerWorldStart_load(buf.getHandle(), version), ZenKit.API::ZkTriggerWorldStart_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load TriggerWorldStart vob");
	}

	public TriggerWorldStart(String path, GameVersion version) {
		super(ZenKit.API.ZkTriggerWorldStart_loadPath(path, version), ZenKit.API::ZkTriggerWorldStart_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load TriggerWorldStart vob");
	}

	protected TriggerWorldStart(Pointer handle, Consumer<Pointer> delete) {
		super(handle, delete);
	}

	public TriggerWorldStart(Pointer handle) {
		super(handle, ZenKit.API::ZkTriggerWorldStart_del);
	}

	public String getTarget() {
		return ZenKit.API.ZkTriggerWorldStart_getTarget(getHandle());
	}

	public boolean getFireOnce() {
		return ZenKit.API.ZkTriggerWorldStart_getFireOnce(getHandle());
	}

	public void setTarget(String val) {
		ZenKit.API.ZkTriggerWorldStart_setTarget(getHandle(), val);
	}

	public void setFireOnce(boolean val) {
		ZenKit.API.ZkTriggerWorldStart_setFireOnce(getHandle(), val);
	}

	public boolean getHasFired() {
		return ZenKit.API.ZkTriggerWorldStart_getHasFired(getHandle());
	}

	public void setHasFired(boolean val) {
		ZenKit.API.ZkTriggerWorldStart_setHasFired(getHandle(), val);
	}
}
