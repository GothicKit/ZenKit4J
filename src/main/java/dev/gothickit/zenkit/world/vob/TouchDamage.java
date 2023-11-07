package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;

public class TouchDamage extends VirtualObject {
	public TouchDamage(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkTouchDamage_load(buf.getHandle(), version), ZenKit.API::ZkTouchDamage_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load TouchDamage vob");
	}

	public TouchDamage(String path, GameVersion version) {
		super(ZenKit.API.ZkTouchDamage_loadPath(path, version), ZenKit.API::ZkTouchDamage_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load TouchDamage vob");
	}

	public TouchDamage(Pointer handle) {
		super(handle);
	}

	public float getDamage() {
		return ZenKit.API.ZkTouchDamage_getDamage(getHandle());
	}

	public boolean isBarrier() {
		return ZenKit.API.ZkTouchDamage_getIsBarrier(getHandle());
	}

	public boolean isBlunt() {
		return ZenKit.API.ZkTouchDamage_getIsBlunt(getHandle());
	}

	public boolean isEdge() {
		return ZenKit.API.ZkTouchDamage_getIsEdge(getHandle());
	}

	public boolean isFire() {
		return ZenKit.API.ZkTouchDamage_getIsFire(getHandle());
	}

	public boolean isFly() {
		return ZenKit.API.ZkTouchDamage_getIsFly(getHandle());
	}

	public boolean isMagic() {
		return ZenKit.API.ZkTouchDamage_getIsMagic(getHandle());
	}

	public boolean isPoint() {
		return ZenKit.API.ZkTouchDamage_getIsPoint(getHandle());
	}

	public boolean isFall() {
		return ZenKit.API.ZkTouchDamage_getIsFall(getHandle());
	}

	public Duration getRepeatDelay() {
		return Duration.ofSeconds((long) ZenKit.API.ZkTouchDamage_getRepeatDelaySeconds(getHandle()));
	}

	public float getVolumeScale() {
		return ZenKit.API.ZkTouchDamage_getVolumeScale(getHandle());
	}

	public TouchCollisionType getCollisionType() {
		return ZenKit.API.ZkTouchDamage_getCollisionType(getHandle());
	}
}
