package dev.gothickit.zenkit.mds;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NativeEventParticleEffectStop implements NativeObject, EventParticleEffectStop {
	private final Pointer handle;

	private NativeEventParticleEffectStop(Pointer handle) {
		this.handle = handle;
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable NativeEventParticleEffectStop fromNativeHandle(Pointer handle) {
		if (handle == null) return null;
		return new NativeEventParticleEffectStop(handle);
	}

	@Override
	public int frame() {
		return ZenKit.API.ZkEventParticleEffectStop_getFrame(handle);
	}

	@Override
	public int index() {
		return ZenKit.API.ZkEventParticleEffectStop_getIndex(handle);
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle;
	}

	@Override
	public @NotNull CachedEventParticleEffectStop cache() {
		return new CachedEventParticleEffectStop(frame(), index());
	}

	@Override
	public boolean isCached() {
		return false;
	}
}
