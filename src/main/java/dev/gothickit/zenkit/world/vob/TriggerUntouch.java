package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class TriggerUntouch extends VirtualObject {
	public TriggerUntouch(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkTriggerUntouch_load(buf.getHandle(), version), ZenKit.API::ZkTriggerUntouch_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load TriggerUntouch vob");
	}

	public TriggerUntouch(String path, GameVersion version) {
		super(ZenKit.API.ZkTriggerUntouch_loadPath(path, version), ZenKit.API::ZkTriggerUntouch_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load TriggerUntouch vob");
	}

	protected TriggerUntouch(Pointer handle, Consumer<Pointer> delete) {
		super(handle, delete);
	}

	public TriggerUntouch(Pointer handle) {
		super(handle);
	}

	public String getTarget() {
		return ZenKit.API.ZkTriggerUntouch_getTarget(getHandle());
	}
}
