package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class MovableObject extends VirtualObject {
	public MovableObject(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkMovableObject_load(buf.getHandle(), version), ZenKit.API::ZkMovableObject_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load MovableObject vob");
	}

	public MovableObject(String path, GameVersion version) {
		super(ZenKit.API.ZkMovableObject_loadPath(path, version), ZenKit.API::ZkMovableObject_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load MovableObject vob");
	}

	public MovableObject(Pointer handle, Consumer<Pointer> delete) {
		super(handle, delete);
	}

	public MovableObject(Pointer handle) {
		super(handle);
	}

	public String getFocusName() {
		return ZenKit.API.ZkMovableObject_getName(getHandle());
	}

	public int getHp() {
		return ZenKit.API.ZkMovableObject_getHp(getHandle());
	}

	public int getDamage() {
		return ZenKit.API.ZkMovableObject_getDamage(getHandle());
	}

	public boolean isMovable() {
		return ZenKit.API.ZkMovableObject_getMovable(getHandle());
	}

	public boolean isTakable() {
		return ZenKit.API.ZkMovableObject_getTakable(getHandle());
	}

	public boolean getFocusOverride() {
		return ZenKit.API.ZkMovableObject_getFocusOverride(getHandle());
	}

	public SoundMaterialType getMaterial() {
		return ZenKit.API.ZkMovableObject_getMaterial(getHandle());
	}

	public String getVisualDestroyed() {
		return ZenKit.API.ZkMovableObject_getVisualDestroyed(getHandle());
	}

	public String getOwner() {
		return ZenKit.API.ZkMovableObject_getOwner(getHandle());
	}

	public String getOwnerGuild() {
		return ZenKit.API.ZkMovableObject_getOwnerGuild(getHandle());
	}

	public boolean isDestroyed() {
		return ZenKit.API.ZkMovableObject_getDestroyed(getHandle());
	}
}
