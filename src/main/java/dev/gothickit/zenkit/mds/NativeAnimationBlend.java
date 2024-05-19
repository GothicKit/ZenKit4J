package dev.gothickit.zenkit.mds;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NativeAnimationBlend implements NativeObject, AnimationBlend {
	private final Pointer handle;

	private NativeAnimationBlend(Pointer handle) {
		this.handle = handle;
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable NativeAnimationBlend fromNativeHandle(Pointer handle) {
		if (handle == null) return null;
		return new NativeAnimationBlend(handle);
	}

	@Override
	public @NotNull String name() {
		return ZenKit.API.ZkAnimationBlend_getName(handle);
	}

	@Override
	public @NotNull String next() {
		return ZenKit.API.ZkAnimationBlend_getNext(handle);
	}

	@Override
	public float blendIn() {
		return ZenKit.API.ZkAnimationBlend_getBlendIn(handle);
	}

	@Override
	public float blendOut() {
		return ZenKit.API.ZkAnimationBlend_getBlendOut(handle);
	}

	@Override
	public @NotNull CachedAnimationBlend cache() {
		return new CachedAnimationBlend(name(), next(), blendIn(), blendOut());
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
