package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class InteractiveObject extends MovableObject {
	public InteractiveObject(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkInteractiveObject_load(buf.getHandle(), version), ZenKit.API::ZkInteractiveObject_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load InteractiveObject vob");
	}

	public InteractiveObject(String path, GameVersion version) {
		super(ZenKit.API.ZkInteractiveObject_loadPath(path, version), ZenKit.API::ZkInteractiveObject_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load InteractiveObject vob");
	}

	public InteractiveObject(Pointer handle, Consumer<Pointer> delete) {
		super(handle, delete);
	}

	public InteractiveObject(Pointer handle) {
		super(handle);
	}

	public int getState() {
		return ZenKit.API.ZkInteractiveObject_getState(getHandle());
	}

	public String getTarget() {
		return ZenKit.API.ZkInteractiveObject_getTarget(getHandle());
	}

	public String getItem() {
		return ZenKit.API.ZkInteractiveObject_getItem(getHandle());
	}

	public String getConditionFunction() {
		return ZenKit.API.ZkInteractiveObject_getConditionFunction(getHandle());
	}

	public String getOnStateChangeFunction() {
		return ZenKit.API.ZkInteractiveObject_getOnStateChangeFunction(getHandle());
	}

	public boolean getRewind() {
		return ZenKit.API.ZkInteractiveObject_getRewind(getHandle());
	}
}
