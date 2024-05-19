package dev.gothickit.zenkit.world.visual;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Visual implements NativeObject {
	private final Handle handle;

	protected Visual(Pointer handle) {
		this.handle = new Handle(handle, ZenKit.API::ZkVisual_del);
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable Visual fromNativeHandle(@Nullable Pointer handle) {
		if (handle == null) return null;

		handle = ZenKit.API.ZkObject_takeRef(handle);
		return switch (ZenKit.API.ZkVisual_getType(handle)) {
			case DECAL -> new VisualDecal(handle);
			default -> new Visual(handle);
		};
	}

	public static @NotNull Visual create(VisualType type) {
		var ptr = ZenKit.API.ZkVisual_new(type);
		return switch (type) {
			case DECAL -> new VisualDecal(ptr);
			default -> new Visual(ptr);
		};
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle.get();
	}

	public String getName() {
		return ZenKit.API.ZkVisual_getName(getNativeHandle());
	}

	public void setName(String val) {
		ZenKit.API.ZkVisual_setName(getNativeHandle(), val);
	}

	public VisualType getType() {
		return ZenKit.API.ZkVisual_getType(getNativeHandle());
	}
}
