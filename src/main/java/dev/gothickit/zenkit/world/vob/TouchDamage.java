package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;

public class TouchDamage extends VirtualObject {
	public TouchDamage() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.oCTouchDamage));
	}

	public TouchDamage(@NotNull Read buf, GameVersion version) {
		super(ZenKit.API.ZkTouchDamage_load(buf.getHandle(), version), ZenKit.API::ZkTouchDamage_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load TouchDamage vob");
	}

	public TouchDamage(String path, GameVersion version) {
		super(ZenKit.API.ZkTouchDamage_loadPath(path, version), ZenKit.API::ZkTouchDamage_del);
		if (this.getHandle() == Pointer.NULL) throw new RuntimeException("Failed to load TouchDamage vob");
	}

	public TouchDamage(Pointer handle) {
		super(handle, ZenKit.API::ZkTouchDamage_del);
	}

	public float getDamage() {
		return ZenKit.API.ZkTouchDamage_getDamage(getHandle());
	}

	public void setDamage(float val) {
		ZenKit.API.ZkTouchDamage_setDamage(getHandle(), val);
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

	public void setRepeatDelay(@NotNull Duration val) {
		ZenKit.API.ZkTouchDamage_setRepeatDelaySeconds(getHandle(), val.getSeconds());
	}

	public float getVolumeScale() {
		return ZenKit.API.ZkTouchDamage_getVolumeScale(getHandle());
	}

	public void setVolumeScale(float val) {
		ZenKit.API.ZkTouchDamage_setVolumeScale(getHandle(), val);
	}

	public TouchCollisionType getCollisionType() {
		return ZenKit.API.ZkTouchDamage_getCollisionType(getHandle());
	}

	public void setCollisionType(TouchCollisionType val) {
		ZenKit.API.ZkTouchDamage_setCollisionType(getHandle(), val);
	}

	public void setIsBarrier(boolean val) {
		ZenKit.API.ZkTouchDamage_setIsBarrier(getHandle(), val);
	}

	public void setIsBlunt(boolean val) {
		ZenKit.API.ZkTouchDamage_setIsBlunt(getHandle(), val);
	}

	public void setIsEdge(boolean val) {
		ZenKit.API.ZkTouchDamage_setIsEdge(getHandle(), val);
	}

	public void setIsFire(boolean val) {
		ZenKit.API.ZkTouchDamage_setIsFire(getHandle(), val);
	}

	public void setIsFly(boolean val) {
		ZenKit.API.ZkTouchDamage_setIsFly(getHandle(), val);
	}

	public void setIsMagic(boolean val) {
		ZenKit.API.ZkTouchDamage_setIsMagic(getHandle(), val);
	}

	public void setIsPoint(boolean val) {
		ZenKit.API.ZkTouchDamage_setIsPoint(getHandle(), val);
	}

	public void setIsFall(boolean val) {
		ZenKit.API.ZkTouchDamage_setIsFall(getHandle(), val);
	}
}
