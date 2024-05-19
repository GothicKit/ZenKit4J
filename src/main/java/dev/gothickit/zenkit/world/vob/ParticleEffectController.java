package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public final class ParticleEffectController extends VirtualObject {
	public ParticleEffectController() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCPFXController));
	}

	ParticleEffectController(@NotNull NativeRead buf, GameVersion version) {
		super(
				ZenKit.API.ZkParticleEffectController_load(buf.getNativeHandle(), version),
				ZenKit.API::ZkParticleEffectController_del
		);
		if (this.getNativeHandle() == Pointer.NULL)
			throw new RuntimeException("Failed to load ParticleEffectController vob");
	}

	ParticleEffectController(String path, GameVersion version) {
		super(
				ZenKit.API.ZkParticleEffectController_loadPath(path, version),
				ZenKit.API::ZkParticleEffectController_del
		);
		if (this.getNativeHandle() == Pointer.NULL)
			throw new RuntimeException("Failed to load ParticleEffectController vob");
	}

	ParticleEffectController(Pointer handle) {
		super(
				handle,
				ZenKit.API::ZkParticleEffectController_del
		);
	}

	public String getEffectName() {
		return ZenKit.API.ZkParticleEffectController_getEffectName(getNativeHandle());
	}

	public void setEffectName(String val) {
		ZenKit.API.ZkParticleEffectController_setEffectName(getNativeHandle(), val);
	}

	public boolean getKillWhenDone() {
		return ZenKit.API.ZkParticleEffectController_getKillWhenDone(getNativeHandle());
	}

	public void setKillWhenDone(boolean val) {
		ZenKit.API.ZkParticleEffectController_setKillWhenDone(getNativeHandle(), val);
	}

	public boolean isInitiallyRunning() {
		return ZenKit.API.ZkParticleEffectController_getInitiallyRunning(getNativeHandle());
	}

	public void setInitiallyRunning(boolean val) {
		ZenKit.API.ZkParticleEffectController_setInitiallyRunning(getNativeHandle(), val);
	}
}
