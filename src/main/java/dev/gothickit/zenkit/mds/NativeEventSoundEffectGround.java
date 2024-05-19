package dev.gothickit.zenkit.mds;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NativeEventSoundEffectGround implements NativeObject, EventSoundEffectGround {
	private final Pointer handle;

	private NativeEventSoundEffectGround(Pointer handle) {
		this.handle = handle;
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable NativeEventSoundEffectGround fromNativeHandle(Pointer handle) {
		if (handle == null) return null;
		return new NativeEventSoundEffectGround(handle);
	}

	@Override
	public int frame() {
		return ZenKit.API.ZkEventSoundEffectGround_getFrame(handle);
	}

	@Override
	public @NotNull String name() {
		return ZenKit.API.ZkEventSoundEffectGround_getName(handle);
	}

	@Override
	public float range() {
		return ZenKit.API.ZkEventSoundEffectGround_getRange(handle);
	}

	@Override
	public boolean emptySlot() {
		return ZenKit.API.ZkEventSoundEffectGround_getEmptySlot(handle);
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle;
	}

	@Override
	public @NotNull CachedEventSoundEffectGround cache() {
		return new CachedEventSoundEffectGround(frame(), name(), range(), emptySlot());
	}

	@Override
	public boolean isCached() {
		return false;
	}
}
