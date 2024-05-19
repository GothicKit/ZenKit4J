package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public final class CodeMaster extends VirtualObject {
	public CodeMaster() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCCodeMaster));
	}

	CodeMaster(@NotNull NativeRead buf, GameVersion version) {
		super(ZenKit.API.ZkCodeMaster_load(buf.getNativeHandle(), version), ZenKit.API::ZkCodeMaster_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load CodeMaster vob");
	}

	CodeMaster(String path, GameVersion version) {
		super(ZenKit.API.ZkCodeMaster_loadPath(path, version), ZenKit.API::ZkCodeMaster_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load CodeMaster vob");
	}

	CodeMaster(Pointer handle) {
		super(handle, ZenKit.API::ZkCodeMaster_del);
	}

	public String getTarget() {
		return ZenKit.API.ZkCodeMaster_getTarget(getNativeHandle());
	}

	public void setTarget(String val) {
		ZenKit.API.ZkCodeMaster_setTarget(getNativeHandle(), val);
	}

	public boolean isOrdered() {
		return ZenKit.API.ZkCodeMaster_getOrdered(getNativeHandle());
	}

	public void setOrdered(boolean val) {
		ZenKit.API.ZkCodeMaster_setOrdered(getNativeHandle(), val);
	}

	public boolean getFirstFalseIsFailure() {
		return ZenKit.API.ZkCodeMaster_getFirstFalseIsFailure(getNativeHandle());
	}

	public void setFirstFalseIsFailure(boolean val) {
		ZenKit.API.ZkCodeMaster_setFirstFalseIsFailure(getNativeHandle(), val);
	}

	public String getFailureTarget() {
		return ZenKit.API.ZkCodeMaster_getFailureTarget(getNativeHandle());
	}

	public void setFailureTarget(String val) {
		ZenKit.API.ZkCodeMaster_setFailureTarget(getNativeHandle(), val);
	}

	public boolean getUntriggeredCancels() {
		return ZenKit.API.ZkCodeMaster_getUntriggeredCancels(getNativeHandle());
	}

	public void setUntriggeredCancels(boolean val) {
		ZenKit.API.ZkCodeMaster_setUntriggeredCancels(getNativeHandle(), val);
	}

	public long getSlaveCount() {
		return ZenKit.API.ZkCodeMaster_getSlaveCount(getNativeHandle());
	}

	public String getSlave(long i) {
		return ZenKit.API.ZkCodeMaster_getSlave(getNativeHandle(), i);
	}

	public List<String> getSlaves() {
		var slaves = new ArrayList<String>();

		ZenKit.API.ZkCodeMaster_enumerateSlaves(getNativeHandle(), (ctx, evt) -> {
			slaves.add(evt);
			return false;
		}, Pointer.NULL);

		return slaves;
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

	void addSlave(String value) {
		ZenKit.API.ZkCodeMaster_addSlave(getNativeHandle(), value);
	}

	void removeSlave(long i) {
		ZenKit.API.ZkCodeMaster_removeSlave(getNativeHandle(), i);
	}
}
