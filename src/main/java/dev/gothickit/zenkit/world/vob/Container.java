package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Container extends InteractiveObject {
	public Container() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.oCMobContainer));
	}

	Container(@NotNull NativeRead buf, GameVersion version) {
		super(ZenKit.API.ZkContainer_load(buf.getNativeHandle(), version), ZenKit.API::ZkContainer_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Container vob");
	}

	Container(String path, GameVersion version) {
		super(ZenKit.API.ZkContainer_loadPath(path, version), ZenKit.API::ZkContainer_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Container vob");
	}

	Container(Pointer handle) {
		super(handle, ZenKit.API::ZkContainer_del);
	}

	public boolean isLocked() {
		return ZenKit.API.ZkContainer_getIsLocked(getNativeHandle());
	}

	public void setLocked(boolean val) {
		ZenKit.API.ZkContainer_setIsLocked(getNativeHandle(), val);
	}

	public String getKey() {
		return ZenKit.API.ZkContainer_getKey(getNativeHandle());
	}

	public void setKey(String val) {
		ZenKit.API.ZkContainer_setKey(getNativeHandle(), val);
	}

	public String getPickString() {
		return ZenKit.API.ZkContainer_getPickString(getNativeHandle());
	}

	public void setPickString(String val) {
		ZenKit.API.ZkContainer_setPickString(getNativeHandle(), val);
	}

	public String getContents() {
		return ZenKit.API.ZkContainer_getContents(getNativeHandle());
	}

	public void setContents(String val) {
		ZenKit.API.ZkContainer_setContents(getNativeHandle(), val);
	}

	public long getItemCount() {
		return ZenKit.API.ZkContainer_getItemCount(getNativeHandle());
	}

	public @Nullable Item getItem(long i) {
		var ptr = ZenKit.API.ZkContainer_getItem(getNativeHandle(), i);
		if (ptr == null) return null;
		return new Item(ZenKit.API.ZkObject_takeRef(ptr));
	}

	public void addItem(@NotNull Item item) {
		ZenKit.API.ZkContainer_addItem(getNativeHandle(), item.getNativeHandle());
	}

	public void removeItem(long i) {
		ZenKit.API.ZkContainer_removeItem(getNativeHandle(), i);
	}
}
