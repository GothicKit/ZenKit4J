package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class Container extends InteractiveObject {
	public Container() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.oCMobContainer));
	}

	public Container(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkContainer_load(buf.getHandle(), version), ZenKit.API::ZkContainer_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Container vob");
	}

	public Container(String path, GameVersion version) {
		super(ZenKit.API.ZkContainer_loadPath(path, version), ZenKit.API::ZkContainer_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Container vob");
	}

	public Container(Pointer handle, Consumer<Pointer> delete) {
		super(handle, delete);
	}

	public Container(Pointer handle) {
		super(handle, ZenKit.API::ZkContainer_del);
	}

	public boolean isLocked() {
		return ZenKit.API.ZkContainer_getIsLocked(getHandle());
	}

	public void setLocked(boolean val) {
		ZenKit.API.ZkContainer_setIsLocked(getHandle(), val);
	}

	public String getKey() {
		return ZenKit.API.ZkContainer_getKey(getHandle());
	}

	public void setKey(String val) {
		ZenKit.API.ZkContainer_setKey(getHandle(), val);
	}

	public String getPickString() {
		return ZenKit.API.ZkContainer_getPickString(getHandle());
	}

	public void setPickString(String val) {
		ZenKit.API.ZkContainer_setPickString(getHandle(), val);
	}

	public String getContents() {
		return ZenKit.API.ZkContainer_getContents(getHandle());
	}

	public void setContents(String val) {
		ZenKit.API.ZkContainer_setContents(getHandle(), val);
	}

	public long getItemCount() {
		return ZenKit.API.ZkContainer_getItemCount(getHandle());
	}

	public Item getItem(long i) {
		var ptr = ZenKit.API.ZkContainer_getItem(getHandle(), i);
		return new Item(ZenKit.API.ZkObject_takeRef(ptr));
	}

	public void addItem(@NotNull Item item) {
		ZenKit.API.ZkContainer_addItem(getHandle(), item.getHandle());
	}

	public void removeItem(long i) {
		ZenKit.API.ZkContainer_removeItem(getHandle(), i);
	}
}
