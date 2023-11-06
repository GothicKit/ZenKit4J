package dev.gothickit.zenkit.mds;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;

public class EventMorphAnimation {
	private final Pointer handle;

	public EventMorphAnimation(Pointer handle) {
		this.handle = handle;
	}

	public int getFrame() {
		return ZenKit.API.ZkMorphAnimation_getFrame(handle);
	}

	public String getAnimation() {
		return ZenKit.API.ZkMorphAnimation_getAnimation(handle);
	}

	public String getNode() {
		return ZenKit.API.ZkMorphAnimation_getNode(handle);
	}
}
