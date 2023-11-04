package dev.gothickit.zenkit.utils;

import com.sun.jna.Pointer;

import java.util.function.Consumer;

public class Handle implements Runnable {
	private final Pointer handle;
	private final Consumer<Pointer> delete;

	public Handle(Pointer handle, Consumer<Pointer> delete) {
		this.handle = handle;
		this.delete = delete;
	}

	public boolean isNull() {
		return handle == Pointer.NULL;
	}

	public Pointer get() {
		return handle;
	}

	@Override
	public void run() {
		delete.accept(handle);
	}
}
