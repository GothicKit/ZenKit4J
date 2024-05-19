package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public final class MessageFilter extends VirtualObject {
	public MessageFilter() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCMessageFilter));
	}

	MessageFilter(@NotNull NativeRead buf, GameVersion version) {
		super(ZenKit.API.ZkMessageFilter_load(buf.getNativeHandle(), version), ZenKit.API::ZkMessageFilter_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Animate vob");
	}

	MessageFilter(String path, GameVersion version) {
		super(ZenKit.API.ZkMessageFilter_loadPath(path, version), ZenKit.API::ZkMessageFilter_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Animate vob");
	}

	MessageFilter(Pointer handle) {
		super(handle, ZenKit.API::ZkMessageFilter_del);
	}

	public String getTarget() {
		return ZenKit.API.ZkMessageFilter_getTarget(getNativeHandle());
	}

	public void setTarget(String val) {
		ZenKit.API.ZkMessageFilter_setTarget(getNativeHandle(), val);
	}

	public MessageFilterAction getOnTrigger() {
		return ZenKit.API.ZkMessageFilter_getOnTrigger(getNativeHandle());
	}

	public void setOnTrigger(MessageFilterAction val) {
		ZenKit.API.ZkMessageFilter_setOnTrigger(getNativeHandle(), val);
	}

	public MessageFilterAction getOnUntrigger() {
		return ZenKit.API.ZkMessageFilter_getOnUntrigger(getNativeHandle());
	}

	public void setOnUntrigger(MessageFilterAction val) {
		ZenKit.API.ZkMessageFilter_setOnUntrigger(getNativeHandle(), val);
	}
}
