package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class MovableObject extends VirtualObject {
	public MovableObject() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.oCMOB));
	}

	MovableObject(@NotNull NativeRead buf, GameVersion version) {
		super(ZenKit.API.ZkMovableObject_load(buf.getNativeHandle(), version), ZenKit.API::ZkMovableObject_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load MovableObject vob");
	}

	MovableObject(String path, GameVersion version) {
		super(ZenKit.API.ZkMovableObject_loadPath(path, version), ZenKit.API::ZkMovableObject_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load MovableObject vob");
	}

	MovableObject(Pointer handle, Consumer<Pointer> delete) {
		super(handle, delete);
	}

	MovableObject(Pointer handle) {
		super(handle, ZenKit.API::ZkMovableObject_del);
	}

	public String getFocusName() {
		return ZenKit.API.ZkMovableObject_getName(getNativeHandle());
	}

	public void setFocusName(String val) {
		ZenKit.API.ZkMovableObject_setName(getNativeHandle(), val);
	}

	public int getHp() {
		return ZenKit.API.ZkMovableObject_getHp(getNativeHandle());
	}

	public void setHp(int val) {
		ZenKit.API.ZkMovableObject_setHp(getNativeHandle(), val);
	}

	public int getDamage() {
		return ZenKit.API.ZkMovableObject_getDamage(getNativeHandle());
	}

	public void setDamage(int val) {
		ZenKit.API.ZkMovableObject_setDamage(getNativeHandle(), val);
	}

	public boolean isMovable() {
		return ZenKit.API.ZkMovableObject_getMovable(getNativeHandle());
	}

	public void setMovable(boolean val) {
		ZenKit.API.ZkMovableObject_setMovable(getNativeHandle(), val);
	}

	public boolean isTakable() {
		return ZenKit.API.ZkMovableObject_getTakable(getNativeHandle());
	}

	public void setTakable(boolean val) {
		ZenKit.API.ZkMovableObject_setTakable(getNativeHandle(), val);
	}

	public boolean getFocusOverride() {
		return ZenKit.API.ZkMovableObject_getFocusOverride(getNativeHandle());
	}

	public void setFocusOverride(boolean val) {
		ZenKit.API.ZkMovableObject_setFocusOverride(getNativeHandle(), val);
	}

	public SoundMaterialType getMaterial() {
		return ZenKit.API.ZkMovableObject_getMaterial(getNativeHandle());
	}

	public void setMaterial(SoundMaterialType val) {
		ZenKit.API.ZkMovableObject_setMaterial(getNativeHandle(), val);
	}

	public String getVisualDestroyed() {
		return ZenKit.API.ZkMovableObject_getVisualDestroyed(getNativeHandle());
	}

	public void setVisualDestroyed(String val) {
		ZenKit.API.ZkMovableObject_setVisualDestroyed(getNativeHandle(), val);
	}

	public String getOwner() {
		return ZenKit.API.ZkMovableObject_getOwner(getNativeHandle());
	}

	public void setOwner(String val) {
		ZenKit.API.ZkMovableObject_setOwner(getNativeHandle(), val);
	}

	public String getOwnerGuild() {
		return ZenKit.API.ZkMovableObject_getOwnerGuild(getNativeHandle());
	}

	public void setOwnerGuild(String val) {
		ZenKit.API.ZkMovableObject_setOwnerGuild(getNativeHandle(), val);
	}

	public boolean isDestroyed() {
		return ZenKit.API.ZkMovableObject_getDestroyed(getNativeHandle());
	}

	public void setDestroyed(boolean val) {
		ZenKit.API.ZkMovableObject_setDestroyed(getNativeHandle(), val);
	}
}
