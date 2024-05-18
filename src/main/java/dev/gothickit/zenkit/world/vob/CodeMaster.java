package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CodeMaster extends VirtualObject {
	public CodeMaster() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCCodeMaster));
	}

	public CodeMaster(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkCodeMaster_load(buf.getHandle(), version), ZenKit.API::ZkCodeMaster_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load CodeMaster vob");
	}

	public CodeMaster(String path, GameVersion version) {
		super(ZenKit.API.ZkCodeMaster_loadPath(path, version), ZenKit.API::ZkCodeMaster_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load CodeMaster vob");
	}

	public CodeMaster(Pointer handle) {
		super(handle, ZenKit.API::ZkCodeMaster_del);
	}

	public String getTarget() {
		return ZenKit.API.ZkCodeMaster_getTarget(getHandle());
	}

	public boolean isOrdered() {
		return ZenKit.API.ZkCodeMaster_getOrdered(getHandle());
	}

	public boolean getFirstFalseIsFailure() {
		return ZenKit.API.ZkCodeMaster_getFirstFalseIsFailure(getHandle());
	}

	public String getFailureTarget() {
		return ZenKit.API.ZkCodeMaster_getFailureTarget(getHandle());
	}

	public boolean getUntriggeredCancels() {
		return ZenKit.API.ZkCodeMaster_getUntriggeredCancels(getHandle());
	}

	public void setTarget(String val) {
		ZenKit.API.ZkCodeMaster_setTarget(getHandle(), val);
	}

	public void setOrdered(boolean val) {
		ZenKit.API.ZkCodeMaster_setOrdered(getHandle(), val);
	}

	public void setFirstFalseIsFailure(boolean val) {
		ZenKit.API.ZkCodeMaster_setFirstFalseIsFailure(getHandle(), val);
	}

	public void setFailureTarget(String val) {
		ZenKit.API.ZkCodeMaster_setFailureTarget(getHandle(), val);
	}

	public void setUntriggeredCancels(boolean val) {
		ZenKit.API.ZkCodeMaster_setUntriggeredCancels(getHandle(), val);
	}

	public long getSlaveCount() {
		return ZenKit.API.ZkCodeMaster_getSlaveCount(getHandle());
	}

	public String getSlave(long i) {
		return ZenKit.API.ZkCodeMaster_getSlave(getHandle(), i);
	}

	public List<String> getSlaves() {
		var slaves = new ArrayList<String>();

		ZenKit.API.ZkCodeMaster_enumerateSlaves(getHandle(), (ctx, evt) -> {
			slaves.add(evt);
			return false;
		}, Pointer.NULL);

		return slaves;
	}

	void addSlave(String value) {
		ZenKit.API.ZkCodeMaster_addSlave(getHandle(), value);
	}

	void removeSlave(long i) {
		ZenKit.API.ZkCodeMaster_removeSlave(getHandle(), i);
	}

	void setSlaves(Iterable<String> slaves) {
		for (var i = 0; i < getSlaveCount(); ++i) {
			removeSlave(i);
		}

		slaves.forEach(this::addSlave);
	}

	void setSlaves(String[] slaves) {
		for (var i = 0; i < getSlaveCount(); ++i) {
			removeSlave(i);
		}

		for (String slave : slaves) {
			addSlave(slave);
		}
	}
}
