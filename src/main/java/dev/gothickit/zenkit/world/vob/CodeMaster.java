package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CodeMaster extends VirtualObject {
	public CodeMaster(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkCodeMaster_load(buf.getHandle(), version), ZenKit.API::ZkCodeMaster_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load CodeMaster vob");
	}

	public CodeMaster(String path, GameVersion version) {
		super(ZenKit.API.ZkCodeMaster_loadPath(path, version), ZenKit.API::ZkCodeMaster_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load CodeMaster vob");
	}

	public CodeMaster(Pointer handle) {
		super(handle);
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

}
