package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;

public class TriggerListTarget {
	private final Pointer handle;

	TriggerListTarget(Pointer handle) {
		this.handle = handle;
	}

	public String getName() {
		return ZenKit.API.ZkTriggerListTarget_getName(handle);
	}

	public Duration getDelay() {
		return Duration.ofSeconds((long) ZenKit.API.ZkTriggerListTarget_getDelaySeconds(handle));
	}

	public void setName(String val) {
		ZenKit.API.ZkTriggerListTarget_setName(handle, val);
	}

	public void setDelay(@NotNull Duration val) {
		ZenKit.API.ZkTriggerListTarget_setDelaySeconds(handle, val.getSeconds());
	}
}
