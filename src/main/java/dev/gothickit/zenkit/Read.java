package dev.gothickit.zenkit;

import com.sun.jna.Pointer;
import org.jetbrains.annotations.NotNull;

public interface Read {
	@NotNull
	static Read from(@NotNull String path) {
		return new NativeRead(path);
	}

	@NotNull
	static Read from(byte @NotNull [] bytes) {
		return new NativeRead(bytes);
	}

	@NotNull
	static NativeRead adapt(@NotNull Read javaOrNative) {
		if (javaOrNative instanceof NativeRead n) return n;
		return new NativeRead(javaOrNative);
	}

	long read(Pointer into, long length);

	long seek(long offset, Whence whence);

	long tell();

	boolean eof();
}
