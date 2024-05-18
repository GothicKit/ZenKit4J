package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TriggerList extends Trigger {
	public TriggerList() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCTriggerList));
	}

	public TriggerList(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkTriggerList_load(buf.getHandle(), version), ZenKit.API::ZkTriggerList_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load TriggerList vob");
	}

	public TriggerList(String path, GameVersion version) {
		super(ZenKit.API.ZkTriggerList_loadPath(path, version), ZenKit.API::ZkTriggerList_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load TriggerList vob");
	}

	public TriggerList(Pointer handle) {
		super(handle, ZenKit.API::ZkTriggerList_del);
	}

	public TriggerBatchMode getMode() {
		return ZenKit.API.ZkTriggerList_getMode(getHandle());
	}

	public void setMode(TriggerBatchMode val) {
		ZenKit.API.ZkTriggerList_setMode(getHandle(), val);
	}

	public long getTargetCount() {
		return ZenKit.API.ZkTriggerList_getTargetCount(getHandle());
	}

	public TriggerListTarget getTarget(long i) {
		return new TriggerListTarget(ZenKit.API.ZkTriggerList_getTarget(getHandle(), i));
	}

	public List<TriggerListTarget> getTargets() {
		var targets = new ArrayList<TriggerListTarget>();

		ZenKit.API.ZkTriggerList_enumerateTargets(getHandle(), (ctx, target) -> {
			targets.add(new TriggerListTarget(target));
			return false;
		}, Pointer.NULL);

		return targets;
	}

	TriggerListTarget addTarget() {
		return new TriggerListTarget(ZenKit.API.ZkTriggerList_addTarget(getHandle()));
	}

	void removeTarget(long i) {
		ZenKit.API.ZkTriggerList_removeTarget(getHandle(), i);
	}

	public byte getActTarget() {
		return ZenKit.API.ZkTriggerList_getActTarget(getHandle());
	}

	public void setActTarget(byte val) {
		ZenKit.API.ZkTriggerList_setActTarget(getHandle(), val);
	}

	public boolean getSendOnTrigger() {
		return ZenKit.API.ZkTriggerList_getSendOnTrigger(getHandle());
	}

	public void setSendOnTrigger(boolean val) {
		ZenKit.API.ZkTriggerList_setSendOnTrigger(getHandle(), val);
	}
}
