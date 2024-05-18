package dev.gothickit.zenkit.csl;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NativeCutsceneBlock implements NativeObject, CutsceneBlock {
	private final Pointer handle;

	private NativeCutsceneBlock(Pointer handle) {
		this.handle = handle;
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable NativeCutsceneBlock fromNativeHandle(@Nullable Pointer handle) {
		if (handle == null) return null;
		return new NativeCutsceneBlock(handle);
	}

	public @NotNull String name() {
		return ZenKit.API.ZkCutsceneBlock_getName(handle);
	}

	@Override
	public @NotNull CutsceneMessage message() {
		return NativeCutsceneMessage.fromNativeHandle(ZenKit.API.ZkCutsceneBlock_getMessage(handle));
	}

	@Contract(" -> new")
	@Override
	public @NotNull CachedCutsceneBlock cache() {
		return new CachedCutsceneBlock(
				name(),
				message()
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
