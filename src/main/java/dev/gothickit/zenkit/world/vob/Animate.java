package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public final class Animate extends VirtualObject {
	Animate(@NotNull NativeRead buf, GameVersion version) {
		super(ZenKit.API.ZkAnimate_load(buf.getNativeHandle(), version), ZenKit.API::ZkAnimate_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Animate vob");
	}

	Animate(String path, GameVersion version) {
		super(ZenKit.API.ZkAnimate_loadPath(path, version), ZenKit.API::ZkAnimate_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Animate vob");
	}

	public Animate() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCVobAnimate));
	}

	public Animate(Pointer handle) {
		super(handle, ZenKit.API::ZkAnimate_del);
	}

	public boolean getStartOn() {
		return ZenKit.API.ZkAnimate_getStartOn(getNativeHandle());
	}

	public void setStartOn(boolean val) {
		ZenKit.API.ZkAnimate_setStartOn(getNativeHandle(), val);
	}

	public boolean getRunning() {
		return ZenKit.API.ZkAnimate_getIsRunning(getNativeHandle());
	}

	public void setRunning(boolean val) {
		ZenKit.API.ZkAnimate_setIsRunning(getNativeHandle(), val);
	}
}
