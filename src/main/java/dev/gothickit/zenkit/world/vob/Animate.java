package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public class Animate extends VirtualObject {
	public Animate(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkAnimate_load(buf.getHandle(), version), ZenKit.API::ZkAnimate_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Animate vob");
	}

	public Animate(String path, GameVersion version) {
		super(ZenKit.API.ZkAnimate_loadPath(path, version), ZenKit.API::ZkAnimate_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Animate vob");
	}

	public Animate() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCVobAnimate));
	}

	public Animate(Pointer handle) {
		super(handle, ZenKit.API::ZkAnimate_del);
	}

	public boolean getStartOn() {
		return ZenKit.API.ZkAnimate_getStartOn(getHandle());
	}

	public void setStartOn(boolean val) {
		ZenKit.API.ZkAnimate_setStartOn(getHandle(), val);
	}

	public boolean getRunning() {
		return ZenKit.API.ZkAnimate_getIsRunning(getHandle());
	}

	public void setRunning(boolean val) {
		ZenKit.API.ZkAnimate_setIsRunning(getHandle(), val);
	}
}
