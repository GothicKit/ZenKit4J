package dev.gothickit.zenkit.daedalus;

import com.sun.jna.Pointer;

public class DaedalusInstance {
	private final Pointer handle;


	DaedalusInstance(Pointer handle) {
		this.handle = handle;
	}

	public Pointer getHandle() {
		return handle;
	}
}
