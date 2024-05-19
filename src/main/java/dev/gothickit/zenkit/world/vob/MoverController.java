package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public final class MoverController extends VirtualObject {
	public MoverController() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCMoverController));
	}

	MoverController(@NotNull NativeRead buf, GameVersion version) {
		super(ZenKit.API.ZkMoverController_load(buf.getNativeHandle(), version), ZenKit.API::ZkMoverController_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load MoverController vob");
	}

	MoverController(String path, GameVersion version) {
		super(ZenKit.API.ZkMoverController_loadPath(path, version), ZenKit.API::ZkMoverController_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load MoverController vob");
	}

	MoverController(Pointer handle) {
		super(handle, ZenKit.API::ZkMoverController_del);
	}

	public String getTarget() {
		return ZenKit.API.ZkMoverController_getTarget(getNativeHandle());
	}

	public void setTarget(String val) {
		ZenKit.API.ZkMoverController_setTarget(getNativeHandle(), val);
	}

	public MoverMessageType getMessage() {
		return ZenKit.API.ZkMoverController_getMessage(getNativeHandle());
	}

	public void setMessage(MoverMessageType val) {
		ZenKit.API.ZkMoverController_setMessage(getNativeHandle(), val);
	}

	public int getKey() {
		return ZenKit.API.ZkMoverController_getKey(getNativeHandle());
	}

	public void setKey(int val) {
		ZenKit.API.ZkMoverController_setKey(getNativeHandle(), val);
	}
}
