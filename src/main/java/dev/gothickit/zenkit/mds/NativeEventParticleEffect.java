package dev.gothickit.zenkit.mds;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NativeEventParticleEffect implements NativeObject, EventParticleEffect {
	private final Pointer handle;

	private NativeEventParticleEffect(Pointer handle) {
		this.handle = handle;
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable NativeEventParticleEffect fromNativeHandle(Pointer handle) {
		if (handle == null) return null;
		return new NativeEventParticleEffect(handle);
	}

	@Override
	public int frame() {
		return ZenKit.API.ZkEventParticleEffect_getFrame(handle);
	}

	@Override
	public int index() {
		return ZenKit.API.ZkEventParticleEffect_getIndex(handle);
	}

	@Override
	public @NotNull String name() {
		return ZenKit.API.ZkEventParticleEffect_getName(handle);
	}

	@Override
	public @NotNull String position() {
		return ZenKit.API.ZkEventParticleEffect_getPosition(handle);
	}

	@Override
	public boolean isAttached() {
		return ZenKit.API.ZkEventParticleEffect_getIsAttached(handle);
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle;
	}

	@Override
	public @NotNull CachedEventParticleEffect cache() {
		return new CachedEventParticleEffect(frame(), index(), name(), position(), isAttached());
	}

	@Override
	public boolean isCached() {
		return false;
	}
}
