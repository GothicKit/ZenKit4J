package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public final class TriggerList extends Trigger {
	public TriggerList() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCTriggerList));
	}

	TriggerList(@NotNull NativeRead buf, GameVersion version) {
		super(ZenKit.API.ZkTriggerList_load(buf.getNativeHandle(), version), ZenKit.API::ZkTriggerList_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load TriggerList vob");
	}

	TriggerList(String path, GameVersion version) {
		super(ZenKit.API.ZkTriggerList_loadPath(path, version), ZenKit.API::ZkTriggerList_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load TriggerList vob");
	}

	TriggerList(Pointer handle) {
		super(handle, ZenKit.API::ZkTriggerList_del);
	}

	public TriggerBatchMode getMode() {
		return ZenKit.API.ZkTriggerList_getMode(getNativeHandle());
	}

	public void setMode(TriggerBatchMode val) {
		ZenKit.API.ZkTriggerList_setMode(getNativeHandle(), val);
	}

	public long getTargetCount() {
		return ZenKit.API.ZkTriggerList_getTargetCount(getNativeHandle());
	}

	public TriggerListTarget getTarget(long i) {
		return new TriggerListTarget(ZenKit.API.ZkTriggerList_getTarget(getNativeHandle(), i));
	}

	public List<TriggerListTarget> getTargets() {
		var targets = new ArrayList<TriggerListTarget>();

		ZenKit.API.ZkTriggerList_enumerateTargets(getNativeHandle(), (ctx, target) -> {
			targets.add(new TriggerListTarget(target));
			return false;
		}, Pointer.NULL);

		return targets;
	}

	TriggerListTarget addTarget() {
		return new TriggerListTarget(ZenKit.API.ZkTriggerList_addTarget(getNativeHandle()));
	}

	void removeTarget(long i) {
		ZenKit.API.ZkTriggerList_removeTarget(getNativeHandle(), i);
	}

	public byte getActTarget() {
		return ZenKit.API.ZkTriggerList_getActTarget(getNativeHandle());
	}

	public void setActTarget(byte val) {
		ZenKit.API.ZkTriggerList_setActTarget(getNativeHandle(), val);
	}

	public boolean getSendOnTrigger() {
		return ZenKit.API.ZkTriggerList_getSendOnTrigger(getNativeHandle());
	}

	public void setSendOnTrigger(boolean val) {
		ZenKit.API.ZkTriggerList_setSendOnTrigger(getNativeHandle(), val);
	}
}
