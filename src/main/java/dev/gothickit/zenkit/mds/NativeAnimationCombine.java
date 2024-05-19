package dev.gothickit.zenkit.mds;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public final class NativeAnimationCombine implements NativeObject, AnimationCombine {
	private final Pointer handle;

	private NativeAnimationCombine(Pointer handle) {
		this.handle = handle;
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable NativeAnimationCombine fromNativeHandle(Pointer handle) {
		if (handle == null) return null;
		return new NativeAnimationCombine(handle);
	}

	@Override
	public @NotNull String name() {
		return ZenKit.API.ZkAnimationCombine_getName(handle);
	}

	@Override
	public int layer() {
		return ZenKit.API.ZkAnimationCombine_getLayer(handle);
	}

	@Override
	public @NotNull String next() {
		return ZenKit.API.ZkAnimationCombine_getNext(handle);
	}

	@Override
	public float blendIn() {
		return ZenKit.API.ZkAnimationCombine_getBlendIn(handle);
	}

	@Override
	public float blendOut() {
		return ZenKit.API.ZkAnimationCombine_getBlendOut(handle);
	}

	@Override
	public @NotNull EnumSet<AnimationFlag> flags() {
		return AnimationFlag.fromInt(ZenKit.API.ZkAnimationCombine_getFlags(handle));
	}

	@Override
	public @NotNull String model() {
		return ZenKit.API.ZkAnimationCombine_getModel(handle);
	}

	@Override
	public int lastFrame() {
		return ZenKit.API.ZkAnimationCombine_getLastFrame(handle);
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle;
	}

	@Override
	public @NotNull CachedAnimationCombine cache() {
		return new CachedAnimationCombine(name(), layer(), next(), blendIn(), blendOut(), flags(), model(), lastFrame());
	}

	@Override
	public boolean isCached() {
		return false;
	}
}
