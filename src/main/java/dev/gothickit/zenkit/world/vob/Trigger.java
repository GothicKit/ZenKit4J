package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.function.Consumer;

public class Trigger extends VirtualObject {
	public Trigger() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCTrigger));
	}

	Trigger(@NotNull NativeRead buf, GameVersion version) {
		super(ZenKit.API.ZkTrigger_load(buf.getNativeHandle(), version), ZenKit.API::ZkTrigger_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Trigger vob");
	}

	Trigger(String path, GameVersion version) {
		super(ZenKit.API.ZkTrigger_loadPath(path, version), ZenKit.API::ZkTrigger_del);
		if (this.getNativeHandle() == Pointer.NULL) throw new RuntimeException("Failed to load Trigger vob");
	}

	protected Trigger(Pointer handle, Consumer<Pointer> delete) {
		super(handle, delete);
	}

	Trigger(Pointer handle) {
		super(handle, ZenKit.API::ZkTrigger_del);
	}

	public String getTarget() {
		return ZenKit.API.ZkTrigger_getTarget(getNativeHandle());
	}

	public void setTarget(String val) {
		ZenKit.API.ZkTrigger_setTarget(getNativeHandle(), val);
	}

	public String getVobTarget() {
		return ZenKit.API.ZkTrigger_getVobTarget(getNativeHandle());
	}

	public void setVobTarget(String val) {
		ZenKit.API.ZkTrigger_setVobTarget(getNativeHandle(), val);
	}

	public int getMaxActivationCount() {
		return ZenKit.API.ZkTrigger_getMaxActivationCount(getNativeHandle());
	}

	public void setMaxActivationCount(int val) {
		ZenKit.API.ZkTrigger_setMaxActivationCount(getNativeHandle(), val);
	}

	public Duration getRetriggerDelay() {
		return Duration.ofSeconds((long) ZenKit.API.ZkTrigger_getRetriggerDelaySeconds(getNativeHandle()));
	}

	public void setRetriggerDelay(@NotNull Duration val) {
		ZenKit.API.ZkTrigger_setRetriggerDelaySeconds(getNativeHandle(), val.getSeconds());
	}

	public float getDamageThreshold() {
		return ZenKit.API.ZkTrigger_getDamageThreshold(getNativeHandle());
	}

	public void setDamageThreshold(float val) {
		ZenKit.API.ZkTrigger_setDamageThreshold(getNativeHandle(), val);
	}

	public Duration getFireDelay() {
		return Duration.ofSeconds((long) ZenKit.API.ZkTrigger_getFireDelaySeconds(getNativeHandle()));
	}

	public void setFireDelay(@NotNull Duration val) {
		ZenKit.API.ZkTrigger_setFireDelaySeconds(getNativeHandle(), val.getSeconds());
	}

	public boolean getStartEnabled() {
		return ZenKit.API.ZkTrigger_getStartEnabled(getNativeHandle());
	}

	public void setStartEnabled(boolean b) {
		ZenKit.API.ZkTrigger_setStartEnabled(getNativeHandle(), b);
	}

	public boolean getSendUntrigger() {
		return ZenKit.API.ZkTrigger_getSendUntrigger(getNativeHandle());
	}

	public void setSendUntrigger(boolean b) {
		ZenKit.API.ZkTrigger_setSendUntrigger(getNativeHandle(), b);
	}

	public boolean getReactToOnTrigger() {
		return ZenKit.API.ZkTrigger_getReactToOnTrigger(getNativeHandle());
	}

	public void setReactToOnTrigger(boolean b) {
		ZenKit.API.ZkTrigger_setReactToOnTrigger(getNativeHandle(), b);
	}

	public boolean getReactToOnTouch() {
		return ZenKit.API.ZkTrigger_getReactToOnTouch(getNativeHandle());
	}

	public void setReactToOnTouch(boolean b) {
		ZenKit.API.ZkTrigger_setReactToOnTouch(getNativeHandle(), b);
	}

	public boolean getReactToOnDamage() {
		return ZenKit.API.ZkTrigger_getReactToOnDamage(getNativeHandle());
	}

	public void setReactToOnDamage(boolean b) {
		ZenKit.API.ZkTrigger_setReactToOnDamage(getNativeHandle(), b);
	}

	public boolean getRespondToObject() {
		return ZenKit.API.ZkTrigger_getRespondToObject(getNativeHandle());
	}

	public void setRespondToObject(boolean b) {
		ZenKit.API.ZkTrigger_setRespondToObject(getNativeHandle(), b);
	}

	public boolean getRespondToPC() {
		return ZenKit.API.ZkTrigger_getRespondToPC(getNativeHandle());
	}

	public void setRespondToPC(boolean b) {
		ZenKit.API.ZkTrigger_setRespondToPC(getNativeHandle(), b);
	}

	public boolean getRespondToNPC() {
		return ZenKit.API.ZkTrigger_getRespondToNPC(getNativeHandle());
	}

	public void setRespondToNPC(boolean b) {
		ZenKit.API.ZkTrigger_setRespondToNPC(getNativeHandle(), b);
	}

	public float getNextTimeTriggerable() {
		return ZenKit.API.ZkTrigger_getNextTimeTriggerable(getNativeHandle());
	}

	public void setNextTimeTriggerable(float val) {
		ZenKit.API.ZkTrigger_setNextTimeTriggerable(getNativeHandle(), val);
	}

	public VirtualObject getOtherVob() {
		var ptr = ZenKit.API.ZkTrigger_getOtherVob(getNativeHandle());
		return VirtualObject.fromNativeHandle(ptr);
	}

	public void setOtherVob(VirtualObject obj) {
		ZenKit.API.ZkTrigger_setOtherVob(getNativeHandle(), obj != null ? obj.getNativeHandle() : Pointer.NULL);
	}

	public int getCountCanBeActivated() {
		return ZenKit.API.ZkTrigger_getCountCanBeActivated(getNativeHandle());
	}

	public void setCountCanBeActivated(int val) {
		ZenKit.API.ZkTrigger_setCountCanBeActivated(getNativeHandle(), val);
	}

	public boolean isEnabled() {
		return ZenKit.API.ZkTrigger_getIsEnabled(getNativeHandle());
	}

	public void setEnabled(boolean val) {
		ZenKit.API.ZkTrigger_setIsEnabled(getNativeHandle(), val);
	}
}
