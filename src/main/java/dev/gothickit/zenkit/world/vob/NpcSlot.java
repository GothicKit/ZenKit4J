package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;

public class NpcSlot {
	private final Handle handle;

	public NpcSlot(Pointer handle) {
		this.handle = new Handle(handle, pointer -> {
		});
	}

	public boolean getUsed() {
		return ZenKit.API.ZkNpcSlot_getUsed(handle.get());
	}

	public void setUsed(boolean val) {
		ZenKit.API.ZkNpcSlot_setUsed(handle.get(), val);
	}

	public String getName() {
		return ZenKit.API.ZkNpcSlot_getName(handle.get());
	}

	public void setName(String val) {
		ZenKit.API.ZkNpcSlot_setName(handle.get(), val);
	}

	public Item getItem() {
		var ptr = ZenKit.API.ZkNpcSlot_getItem(handle.get());
		if (ptr == Pointer.NULL) {
			return null;
		}

		return new Item(ZenKit.API.ZkObject_takeRef(ptr));
	}

	public boolean getInInventory() {
		return ZenKit.API.ZkNpcSlot_getInInventory(handle.get());
	}

	public void setInInventory(boolean val) {
		ZenKit.API.ZkNpcSlot_setInInventory(handle.get(), val);
	}

	public void getItem(Item val) {
		ZenKit.API.ZkNpcSlot_setItem(handle.get(), val != null ? val.getHandle() : Pointer.NULL);
	}
}
