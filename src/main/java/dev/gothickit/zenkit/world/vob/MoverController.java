package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public class MoverController extends VirtualObject {
	public MoverController() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCMoverController));
	}

	public MoverController(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkMoverController_load(buf.getHandle(), version), ZenKit.API::ZkMoverController_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load MoverController vob");
	}

	public MoverController(String path, GameVersion version) {
		super(ZenKit.API.ZkMoverController_loadPath(path, version), ZenKit.API::ZkMoverController_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load MoverController vob");
	}

	public MoverController(Pointer handle) {
		super(handle, ZenKit.API::ZkMoverController_del);
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

	public void setTarget(String val) {
		ZenKit.API.ZkMoverController_setTarget(getHandle(), val);
	}

	public void setMessage(MoverMessageType val) {
		ZenKit.API.ZkMoverController_setMessage(getHandle(), val);
	}

	public void setKey(int val) {
		ZenKit.API.ZkMoverController_setKey(getHandle(), val);
	}
}
