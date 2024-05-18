package dev.gothickit.zenkit.csl;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NativeCutsceneMessage implements NativeObject, CutsceneMessage {
	private final Pointer handle;

	private NativeCutsceneMessage(Pointer handle) {
		this.handle = handle;
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable NativeCutsceneMessage fromNativeHandle(@Nullable Pointer handle) {
		if (handle == null) return null;
		return new NativeCutsceneMessage(handle);
	}

	@Override
	public int type() {
		return ZenKit.API.ZkCutsceneMessage_getType(handle);
	}

	@Override
	public @NotNull String text() {
		return ZenKit.API.ZkCutsceneMessage_getText(handle);
	}

	@Override
	public @NotNull String name() {
		return ZenKit.API.ZkCutsceneMessage_getName(handle);
	}

	@NotNull
	@Override
	public CachedCutsceneMessage cache() {
		return new CachedCutsceneMessage(
				type(),
				text(),
				name()
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
