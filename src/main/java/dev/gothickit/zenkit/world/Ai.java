package dev.gothickit.zenkit.world;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Ai implements NativeObject {
	private final Handle handle;

	protected Ai(Pointer handle) {
		this.handle = new Handle(handle, ZenKit.API::ZkAi_del);
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable Ai fromNativeHandle(@Nullable Pointer handle) {
		if (handle == null) return null;

		handle = ZenKit.API.ZkObject_takeRef(handle);
		return switch (ZenKit.API.ZkAi_getType(handle)) {
			case HUMAN -> new AiHuman(handle);
			case MOVE -> new AiMove(handle);
		};
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle.get();
	}

	public AiType getType() {
		return ZenKit.API.ZkAi_getType(getNativeHandle());
	}
}
