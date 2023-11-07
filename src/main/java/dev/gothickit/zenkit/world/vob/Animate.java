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

	public Animate(Pointer handle) {
		super(handle);
	}

	public boolean getStartOn() {
		return ZenKit.API.ZkAnimate_getStartOn(getHandle());
	}

}
