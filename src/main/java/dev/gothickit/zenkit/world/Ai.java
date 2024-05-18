package dev.gothickit.zenkit.world;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;

public class Ai {
	private final Handle handle;

	protected Ai(Pointer handle) {
		this.handle = new Handle(handle, ZenKit.API::ZkAi_del);
	}

	public static Ai fromNative(Pointer handle) {
		handle = ZenKit.API.ZkObject_takeRef(handle);

		return switch (ZenKit.API.ZkAi_getType(handle)) {
			case HUMAN -> new AiHuman(handle);
			case MOVE -> new AiMove(handle);
		};
	}

	public Pointer getHandle() {
		return handle.get();
	}

	public AiType getType() {
		return ZenKit.API.ZkAi_getType(getHandle());
	}
}
