package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;

public class VirtualObject {
	private final Pointer handle;

	public VirtualObject(Pointer handle) {
		this.handle = handle;
	}

	public static VirtualObject fromNative(Pointer ptr) {
		return new VirtualObject(ptr);
	}
}
