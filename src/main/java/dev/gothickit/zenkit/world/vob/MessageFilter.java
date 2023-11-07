package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public class MessageFilter extends VirtualObject {
	public MessageFilter(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkMessageFilter_load(buf.getHandle(), version), ZenKit.API::ZkMessageFilter_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Animate vob");
	}

	public MessageFilter(String path, GameVersion version) {
		super(ZenKit.API.ZkMessageFilter_loadPath(path, version), ZenKit.API::ZkMessageFilter_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Animate vob");
	}

	public MessageFilter(Pointer handle) {
		super(handle);
	}

	public String getTarget() {
		return ZenKit.API.ZkMessageFilter_getTarget(getHandle());
	}

	public MessageFilterAction getOnTrigger() {
		return ZenKit.API.ZkMessageFilter_getOnTrigger(getHandle());
	}

	public MessageFilterAction getOnUntrigger() {
		return ZenKit.API.ZkMessageFilter_getOnUntrigger(getHandle());
	}
}
