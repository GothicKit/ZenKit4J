package dev.gothickit.zenkit.mmb;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Calendar;

public final class NativeMorphSource implements NativeObject, MorphSource {
	private final Pointer handle;

	private NativeMorphSource(Pointer handle) {
		this.handle = handle;
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable MorphSource fromNativeHandle(Pointer handle) {
		if (handle == null) return null;
		return new NativeMorphSource(handle);
	}

	@Override
	public @NotNull String fileName() {
		return ZenKit.API.ZkMorphSource_getFileName(handle);
	}

	@Override
	public @NotNull Calendar fileDate() {
		return ZenKit.API.ZkMorphSource_getFileDate(handle).toCalendar();
	}

	@Override
	public @NotNull CachedMorphSource cache() {
		return new CachedMorphSource(
				fileName(),
				fileDate()
		);
	}

	@Override
	public boolean isCached() {
		return false;
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle;
	}
}
