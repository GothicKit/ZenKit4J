package dev.gothickit.zenkit.world;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.world.vob.Npc;
import dev.gothickit.zenkit.world.vob.VirtualObject;
import org.jetbrains.annotations.Nullable;

public final class AiMove extends Ai {
	public AiMove() {
		super(ZenKit.API.ZkAi_new(AiType.MOVE));
	}

	AiMove(Pointer handle) {
		super(handle);
	}

	public @Nullable VirtualObject getVob() {
		return VirtualObject.fromNativeHandle(ZenKit.API.ZkAiMove_getVob(getNativeHandle()));
	}

	public void setVob(VirtualObject vob) {
		ZenKit.API.ZkAiMove_setVob(getNativeHandle(), vob != null ? vob.getNativeHandle() : Pointer.NULL);
	}

	public @Nullable Npc getOwner() {
		var ptr = ZenKit.API.ZkAiMove_getOwner(getNativeHandle());
		return (Npc) VirtualObject.fromNativeHandle(ptr);
	}

	public void setOwner(@Nullable Npc owner) {
		ZenKit.API.ZkAiMove_setOwner(getNativeHandle(), owner != null ? owner.getNativeHandle() : Pointer.NULL);
	}
}
