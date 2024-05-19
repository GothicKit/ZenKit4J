package dev.gothickit.zenkit.mds;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.LongByReference;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.List;
import java.util.Objects;

public final class NativeEventTag implements NativeObject, EventTag {
	private final Pointer handle;

	private NativeEventTag(Pointer handle) {
		this.handle = handle;
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable EventTag fromNativeHandle(Pointer handle) {
		if (handle == null) return null;
		return new NativeEventTag(handle);
	}

	@Override
	public int frame() {
		return ZenKit.API.ZkEventTag_getFrame(handle);
	}

	@Override
	public @NotNull EventType type() {
		return ZenKit.API.ZkEventTag_getType(handle);
	}

	@Override
	public @Nullable String slot(long i) {
		return ZenKit.API.ZkEventTag_getSlot(handle, i);
	}

	@Override
	public @NotNull @Unmodifiable List<@NotNull String> slots() {
		return List.of(Objects.requireNonNull(slot(0)), Objects.requireNonNull(slot(1)));
	}

	@Override
	public @NotNull String item() {
		return ZenKit.API.ZkEventTag_getItem(handle);
	}

	@Override
	public int @NotNull [] frames() {
		var count = new LongByReference();
		var ptr = ZenKit.API.ZkEventTag_getFrames(handle, count);
		if (ptr == Pointer.NULL || count.getValue() == 0) return new int[0];
		return ptr.getIntArray(0, (int) count.getValue());
	}

	@Override
	public @NotNull FightMode fightMode() {
		return ZenKit.API.ZkEventTag_getFightMode(handle);
	}

	@Override
	public boolean isAttached() {
		return ZenKit.API.ZkEventTag_getIsAttached(handle);
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle;
	}

	@Override
	public @NotNull CachedEventTag cache() {
		return new CachedEventTag(frame(), type(), item(), slots(), frames(), fightMode(), isAttached());
	}

	@Override
	public boolean isCached() {
		return false;
	}
}
