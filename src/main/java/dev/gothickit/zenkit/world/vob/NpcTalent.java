package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;

public class NpcTalent {
	private final Handle handle;

	public NpcTalent() {
		this.handle = new Handle(ZenKit.API.ZkNpcTalent_new(), ZenKit.API::ZkNpcTalent_del);
	}

	public NpcTalent(Pointer handle) {
		this.handle = new Handle(handle, pointer -> {
		});
	}


	public NpcTalent(Handle handle) {
		this.handle = handle;
	}

	public Pointer getHandle() {
		return handle.get();
	}

	public int getTalent() {
		return ZenKit.API.ZkNpcTalent_getTalent(handle.get());
	}

	public void setTalent(int val) {
		ZenKit.API.ZkNpcTalent_setTalent(handle.get(), val);
	}

	public int getValue() {
		return ZenKit.API.ZkNpcTalent_getValue(handle.get());
	}

	public void setValue(int val) {
		ZenKit.API.ZkNpcTalent_setValue(handle.get(), val);
	}

	public int getSkill() {
		return ZenKit.API.ZkNpcTalent_getSkill(handle.get());
	}

	public void setSkill(int val) {
		ZenKit.API.ZkNpcTalent_setSkill(handle.get(), val);
	}
}
