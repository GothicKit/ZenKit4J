package dev.gothickit.zenkit.mds;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NativeEventCameraTremor implements NativeObject, EventCameraTremor {
	private final Pointer handle;

	private NativeEventCameraTremor(Pointer handle) {
		this.handle = handle;
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable NativeEventCameraTremor fromNativeHandle(Pointer handle) {
		if (handle == null) return null;
		return new NativeEventCameraTremor(handle);
	}

	@Override
	public int frame() {
		return ZenKit.API.ZkEventCameraTremor_getFrame(handle);
	}

	@Override
	public int field1() {
		return ZenKit.API.ZkEventCameraTremor_getField1(handle);
	}

	@Override
	public int field2() {
		return ZenKit.API.ZkEventCameraTremor_getField2(handle);
	}

	@Override
	public int field3() {
		return ZenKit.API.ZkEventCameraTremor_getField3(handle);
	}

	@Override
	public int field4() {
		return ZenKit.API.ZkEventCameraTremor_getField4(handle);
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle;
	}

	@Override
	public @NotNull CachedEventCameraTremor cache() {
		return new CachedEventCameraTremor(frame(), field1(), field2(), field3(), field4());
	}

	@Override
	public boolean isCached() {
		return false;
	}
}
