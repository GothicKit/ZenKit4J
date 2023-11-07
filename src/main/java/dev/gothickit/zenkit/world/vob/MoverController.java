package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public class MoverController extends VirtualObject {
	public MoverController(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkMoverController_load(buf.getHandle(), version), ZenKit.API::ZkMoverController_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load MoverController vob");
	}

	public MoverController(String path, GameVersion version) {
		super(ZenKit.API.ZkMoverController_loadPath(path, version), ZenKit.API::ZkMoverController_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load MoverController vob");
	}

	public MoverController(Pointer handle) {
		super(handle);
	}

	public String getTarget() {
		return ZenKit.API.ZkMoverController_getTarget(getHandle());
	}

	public MoverMessageType getMessage() {
		return ZenKit.API.ZkMoverController_getMessage(getHandle());
	}

	public int getKey() {
		return ZenKit.API.ZkMoverController_getKey(getHandle());
	}
}
