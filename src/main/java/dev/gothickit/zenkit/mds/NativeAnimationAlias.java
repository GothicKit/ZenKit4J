package dev.gothickit.zenkit.mds;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public final class NativeAnimationAlias implements NativeObject, AnimationAlias {
	private final Pointer handle;

	private NativeAnimationAlias(Pointer handle) {
		this.handle = handle;
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable NativeAnimationAlias fromNativeHandle(Pointer handle) {
		if (handle == null) return null;
		return new NativeAnimationAlias(handle);
	}

	@Override
	public @NotNull String name() {
		return ZenKit.API.ZkAnimationAlias_getName(handle);
	}

	@Override
	public int layer() {
		return ZenKit.API.ZkAnimationAlias_getLayer(handle);
	}

	@Override
	public @NotNull String next() {
		return ZenKit.API.ZkAnimationAlias_getNext(handle);
	}

	@Override
	public float blendIn() {
		return ZenKit.API.ZkAnimationAlias_getBlendIn(handle);
	}

	@Override
	public float blendOut() {
		return ZenKit.API.ZkAnimationAlias_getBlendOut(handle);
	}

	@Override
	public @NotNull EnumSet<AnimationFlag> flags() {
		return AnimationFlag.fromInt(ZenKit.API.ZkAnimationAlias_getFlags(handle));
	}

	@Override
	public @NotNull String alias() {
		return ZenKit.API.ZkAnimationAlias_getAlias(handle);
	}

	@Override
	public @NotNull AnimationDirection direction() {
		return ZenKit.API.ZkAnimationAlias_getDirection(handle);
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle;
	}

	@Override
	public @NotNull CachedAnimationAlias cache() {
		return new CachedAnimationAlias(name(), layer(), next(), blendIn(), blendOut(), flags(), alias(), direction());
	}

	@Override
	public boolean isCached() {
		return false;
	}
}
