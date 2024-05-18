package dev.gothickit.zenkit;

import com.sun.jna.Pointer;
import org.jetbrains.annotations.NotNull;

public interface NativeObject {
	@NotNull
	Pointer getNativeHandle();
}
