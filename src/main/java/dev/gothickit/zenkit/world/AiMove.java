package dev.gothickit.zenkit.world;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.world.vob.Npc;
import dev.gothickit.zenkit.world.vob.VirtualObject;
import org.jetbrains.annotations.Nullable;

public class AiMove extends Ai {
	public AiMove() {
		super(ZenKit.API.ZkAi_new(AiType.MOVE));
	}

	protected AiMove(Pointer handle) {
		super(handle);
	}

	public @Nullable VirtualObject getVob() {
		return VirtualObject.fromNative(ZenKit.API.ZkAiMove_getVob(getHandle()));
	}

	public void setVob(VirtualObject vob) {
		ZenKit.API.ZkAiMove_setVob(getHandle(), vob != null ? vob.getHandle() : Pointer.NULL);
	}

	public @Nullable Npc getOwner() {
		var ptr = ZenKit.API.ZkAiMove_getOwner(getHandle());
		return new Npc(ZenKit.API.ZkObject_takeRef(ptr));
	}

	void ZkAiMove_setOwner(Npc owner) {
		ZenKit.API.ZkAiMove_setOwner(getHandle(), owner != null ? owner.getHandle() : Pointer.NULL);
	}
}
