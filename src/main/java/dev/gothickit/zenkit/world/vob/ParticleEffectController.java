package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

public class ParticleEffectController extends VirtualObject {
	public ParticleEffectController(@NotNull Read buf, GameVersion version) {
		super(
				ZenKit.API.ZkParticleEffectController_load(buf.getHandle(), version),
				ZenKit.API::ZkParticleEffectController_del
		);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load ParticleEffectController vob");
	}

	public ParticleEffectController(Pointer handle) {
		super(handle);
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

	public boolean getKillWhenDone() {
		return ZenKit.API.ZkParticleEffectController_getKillWhenDone(getHandle());
	}

	public boolean isInitiallyRunning() {
		return ZenKit.API.ZkParticleEffectController_getInitiallyRunning(getHandle());
	}
}
