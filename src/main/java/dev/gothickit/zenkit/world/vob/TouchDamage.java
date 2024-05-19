package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;

public final class TouchDamage extends VirtualObject {
	public TouchDamage() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.oCTouchDamage));
	}

	TouchDamage(@NotNull NativeRead buf, GameVersion version) {
		super(ZenKit.API.ZkTouchDamage_load(buf.getNativeHandle(), version), ZenKit.API::ZkTouchDamage_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load TouchDamage vob");
	}

	TouchDamage(String path, GameVersion version) {
		super(ZenKit.API.ZkTouchDamage_loadPath(path, version), ZenKit.API::ZkTouchDamage_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load TouchDamage vob");
	}

	TouchDamage(Pointer handle) {
		super(handle, ZenKit.API::ZkTouchDamage_del);
	}

	public float getDamage() {
		return ZenKit.API.ZkTouchDamage_getDamage(getNativeHandle());
	}

	public void setDamage(float val) {
		ZenKit.API.ZkTouchDamage_setDamage(getNativeHandle(), val);
	}

	public boolean isBarrier() {
		return ZenKit.API.ZkTouchDamage_getIsBarrier(getNativeHandle());
	}

	public boolean isBlunt() {
		return ZenKit.API.ZkTouchDamage_getIsBlunt(getNativeHandle());
	}

	public boolean isEdge() {
		return ZenKit.API.ZkTouchDamage_getIsEdge(getNativeHandle());
	}

	public boolean isFire() {
		return ZenKit.API.ZkTouchDamage_getIsFire(getNativeHandle());
	}

	public boolean isFly() {
		return ZenKit.API.ZkTouchDamage_getIsFly(getNativeHandle());
	}

	public boolean isMagic() {
		return ZenKit.API.ZkTouchDamage_getIsMagic(getNativeHandle());
	}

	public boolean isPoint() {
		return ZenKit.API.ZkTouchDamage_getIsPoint(getNativeHandle());
	}

	public boolean isFall() {
		return ZenKit.API.ZkTouchDamage_getIsFall(getNativeHandle());
	}

	public Duration getRepeatDelay() {
		return Duration.ofSeconds((long) ZenKit.API.ZkTouchDamage_getRepeatDelaySeconds(getNativeHandle()));
	}

	public void setRepeatDelay(@NotNull Duration val) {
		ZenKit.API.ZkTouchDamage_setRepeatDelaySeconds(getNativeHandle(), val.getSeconds());
	}

	public float getVolumeScale() {
		return ZenKit.API.ZkTouchDamage_getVolumeScale(getNativeHandle());
	}

	public void setVolumeScale(float val) {
		ZenKit.API.ZkTouchDamage_setVolumeScale(getNativeHandle(), val);
	}

	public TouchCollisionType getCollisionType() {
		return ZenKit.API.ZkTouchDamage_getCollisionType(getNativeHandle());
	}

	public void setCollisionType(TouchCollisionType val) {
		ZenKit.API.ZkTouchDamage_setCollisionType(getNativeHandle(), val);
	}

	public void setIsBarrier(boolean val) {
		ZenKit.API.ZkTouchDamage_setIsBarrier(getNativeHandle(), val);
	}

	public void setIsBlunt(boolean val) {
		ZenKit.API.ZkTouchDamage_setIsBlunt(getNativeHandle(), val);
	}

	public void setIsEdge(boolean val) {
		ZenKit.API.ZkTouchDamage_setIsEdge(getNativeHandle(), val);
	}

	public void setIsFire(boolean val) {
		ZenKit.API.ZkTouchDamage_setIsFire(getNativeHandle(), val);
	}

	public void setIsFly(boolean val) {
		ZenKit.API.ZkTouchDamage_setIsFly(getNativeHandle(), val);
	}

	public void setIsMagic(boolean val) {
		ZenKit.API.ZkTouchDamage_setIsMagic(getNativeHandle(), val);
	}

	public void setIsPoint(boolean val) {
		ZenKit.API.ZkTouchDamage_setIsPoint(getNativeHandle(), val);
	}

	public void setIsFall(boolean val) {
		ZenKit.API.ZkTouchDamage_setIsFall(getNativeHandle(), val);
	}
}
