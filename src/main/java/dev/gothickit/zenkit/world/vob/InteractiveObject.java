package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class InteractiveObject extends MovableObject {
	public InteractiveObject() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.oCMobInter));
	}

	InteractiveObject(@NotNull NativeRead buf, GameVersion version) {
		super(ZenKit.API.ZkInteractiveObject_load(buf.getNativeHandle(), version), ZenKit.API::ZkInteractiveObject_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load InteractiveObject vob");
	}

	InteractiveObject(String path, GameVersion version) {
		super(ZenKit.API.ZkInteractiveObject_loadPath(path, version), ZenKit.API::ZkInteractiveObject_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load InteractiveObject vob");
	}

	protected InteractiveObject(Pointer handle, Consumer<Pointer> delete) {
		super(handle, delete);
	}

	InteractiveObject(Pointer handle) {
		super(handle, ZenKit.API::ZkInteractiveObject_del);
	}

	public int getState() {
		return ZenKit.API.ZkInteractiveObject_getState(getNativeHandle());
	}

	public void setState(int val) {
		ZenKit.API.ZkInteractiveObject_setState(getNativeHandle(), val);
	}

	public String getTarget() {
		return ZenKit.API.ZkInteractiveObject_getTarget(getNativeHandle());
	}

	public void setTarget(String val) {
		ZenKit.API.ZkInteractiveObject_setTarget(getNativeHandle(), val);
	}

	public String getItem() {
		return ZenKit.API.ZkInteractiveObject_getItem(getNativeHandle());
	}

	public void setItem(String val) {
		ZenKit.API.ZkInteractiveObject_setItem(getNativeHandle(), val);
	}

	public String getConditionFunction() {
		return ZenKit.API.ZkInteractiveObject_getConditionFunction(getNativeHandle());
	}

	public void setConditionFunction(String val) {
		ZenKit.API.ZkInteractiveObject_setConditionFunction(getNativeHandle(), val);
	}

	public String getOnStateChangeFunction() {
		return ZenKit.API.ZkInteractiveObject_getOnStateChangeFunction(getNativeHandle());
	}

	public void setOnStateChangeFunction(String val) {
		ZenKit.API.ZkInteractiveObject_setOnStateChangeFunction(getNativeHandle(), val);
	}

	public boolean getRewind() {
		return ZenKit.API.ZkInteractiveObject_getRewind(getNativeHandle());
	}

	public void setRewind(boolean val) {
		ZenKit.API.ZkInteractiveObject_setRewind(getNativeHandle(), val);
	}
}
