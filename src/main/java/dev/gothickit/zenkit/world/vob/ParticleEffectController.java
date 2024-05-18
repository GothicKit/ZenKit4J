package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public class ParticleEffectController extends VirtualObject {
	public ParticleEffectController() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCPFXController));
	}

	public ParticleEffectController(@NotNull Read buf, GameVersion version) {
		super(
				ZenKit.API.ZkParticleEffectController_load(buf.getHandle(), version),
				ZenKit.API::ZkParticleEffectController_del
		);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load ParticleEffectController vob");
	}

	public ParticleEffectController(Pointer handle) {
		super(
				handle,
				ZenKit.API::ZkParticleEffectController_del
		);
	}

	public ParticleEffectController(String path, GameVersion version) {
		super(
				ZenKit.API.ZkParticleEffectController_loadPath(path, version),
				ZenKit.API::ZkParticleEffectController_del
		);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load ParticleEffectController vob");
	}

	public String getEffectName() {
		return ZenKit.API.ZkParticleEffectController_getEffectName(getHandle());
	}

	public void setEffectName(String val) {
		ZenKit.API.ZkParticleEffectController_setEffectName(getHandle(), val);
	}

	public boolean getKillWhenDone() {
		return ZenKit.API.ZkParticleEffectController_getKillWhenDone(getHandle());
	}

	public void setKillWhenDone(boolean val) {
		ZenKit.API.ZkParticleEffectController_setKillWhenDone(getHandle(), val);
	}

	public boolean isInitiallyRunning() {
		return ZenKit.API.ZkParticleEffectController_getInitiallyRunning(getHandle());
	}

	public void setInitiallyRunning(boolean val) {
		ZenKit.API.ZkParticleEffectController_setInitiallyRunning(getHandle(), val);
	}
}
