package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;

public final class TriggerListTarget implements NativeObject {
	private final Pointer handle;

	TriggerListTarget(Pointer handle) {
		this.handle = handle;
	}

	public String getName() {
		return ZenKit.API.ZkTriggerListTarget_getName(handle);
	}

	public void setName(String val) {
		ZenKit.API.ZkTriggerListTarget_setName(handle, val);
	}

	public Duration getDelay() {
		return Duration.ofSeconds((long) ZenKit.API.ZkTriggerListTarget_getDelaySeconds(handle));
	}

	public void setDelay(@NotNull Duration val) {
		ZenKit.API.ZkTriggerListTarget_setDelaySeconds(handle, val.getSeconds());
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle;
	}
}
