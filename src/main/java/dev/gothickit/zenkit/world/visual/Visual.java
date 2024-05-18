package dev.gothickit.zenkit.world.visual;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import org.jetbrains.annotations.NotNull;

public class Visual {
	private final Handle handle;

	public Visual(Pointer handle) {
		this.handle = new Handle(handle, ZenKit.API::ZkVisual_del);
	}

	public static @NotNull Visual create(VisualType type) {
		var ptr = ZenKit.API.ZkVisual_new(type);
		return switch (type) {
			case DECAL -> new VisualDecal(ptr);
			default -> new Visual(ptr);
		};
	}

	public Pointer getHandle() {
		return handle.get();
	}

	public String getName() {
		return ZenKit.API.ZkVisual_getName(getHandle());
	}

	public void setName(String val) {
		ZenKit.API.ZkVisual_setName(getHandle(), val);
	}

	public VisualType getType() {
		return ZenKit.API.ZkVisual_getType(getHandle());
	}
}
