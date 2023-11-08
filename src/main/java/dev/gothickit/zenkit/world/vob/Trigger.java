package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.function.Consumer;

public class Trigger extends VirtualObject {
	public Trigger(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkTrigger_load(buf.getHandle(), version), ZenKit.API::ZkTrigger_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Trigger vob");
	}

	public Trigger(String path, GameVersion version) {
		super(ZenKit.API.ZkTrigger_loadPath(path, version), ZenKit.API::ZkTrigger_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Trigger vob");
	}

	protected Trigger(Pointer handle, Consumer<Pointer> delete) {
		super(handle, delete);
	}

	public Trigger(Pointer handle) {
		super(handle);
	}

	public String getTarget() {
		return ZenKit.API.ZkTrigger_getTarget(getHandle());
	}

	public byte getFlags() {
		return ZenKit.API.ZkTrigger_getFlags(getHandle());
	}

	public byte getFilterFlags() {
		return ZenKit.API.ZkTrigger_getFilterFlags(getHandle());
	}

	public String getVobTarget() {
		return ZenKit.API.ZkTrigger_getVobTarget(getHandle());
	}

	public int getMaxActivationCount() {
		return ZenKit.API.ZkTrigger_getMaxActivationCount(getHandle());
	}

	public Duration getRetriggerDelay() {
		return Duration.ofSeconds((long) ZenKit.API.ZkTrigger_getRetriggerDelaySeconds(getHandle()));
	}

	public float getDamageThreshold() {
		return ZenKit.API.ZkTrigger_getDamageThreshold(getHandle());
	}

	public Duration getFireDelay() {
		return Duration.ofSeconds((long) ZenKit.API.ZkTrigger_getFireDelaySeconds(getHandle()));
	}
}
