package dev.gothickit.zenkit.mds;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NativeEventSoundEffect implements NativeObject, EventSoundEffect {
	private final Pointer handle;

	private NativeEventSoundEffect(Pointer handle) {
		this.handle = handle;
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable NativeEventSoundEffect fromNativeHandle(Pointer handle) {
		if (handle == null) return null;
		return new NativeEventSoundEffect(handle);
	}

	@Override
	public int frame() {
		return ZenKit.API.ZkEventSoundEffect_getFrame(handle);
	}

	@Override
	public @NotNull String name() {
		return ZenKit.API.ZkEventSoundEffect_getName(handle);
	}

	@Override
	public float range() {
		return ZenKit.API.ZkEventSoundEffect_getRange(handle);
	}

	@Override
	public boolean emptySlot() {
		return ZenKit.API.ZkEventSoundEffect_getEmptySlot(handle);
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle;
	}

	@Override
	public @NotNull CachedEventSoundEffect cache() {
		return new CachedEventSoundEffect(frame(), name(), range(), emptySlot());
	}

	@Override
	public boolean isCached() {
		return false;
	}
}
