package dev.gothickit.zenkit.mds;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NativeEventMorphAnimation implements NativeObject, EventMorphAnimation {
	private final Pointer handle;

	private NativeEventMorphAnimation(Pointer handle) {
		this.handle = handle;
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable NativeEventMorphAnimation fromNativeHandle(Pointer handle) {
		if (handle == null) return null;
		return new NativeEventMorphAnimation(handle);
	}

	@Override
	public int frame() {
		return ZenKit.API.ZkMorphAnimation_getFrame(handle);
	}

	@Override
	public @NotNull String animation() {
		return ZenKit.API.ZkMorphAnimation_getAnimation(handle);
	}

	@Override
	public @NotNull String node() {
		return ZenKit.API.ZkMorphAnimation_getNode(handle);
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle;
	}

	@Override
	public @NotNull CachedEventMorphAnimation cache() {
		return new CachedEventMorphAnimation(frame(), animation(), node());
	}

	@Override
	public boolean isCached() {
		return false;
	}
}
