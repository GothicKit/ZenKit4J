package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.function.Consumer;

public class Trigger extends VirtualObject {
	public Trigger() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCTrigger));
	}

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
		super(handle, ZenKit.API::ZkTrigger_del);
	}

	public String getTarget() {
		return ZenKit.API.ZkTrigger_getTarget(getHandle());
	}

	public void setTarget(String val) {
		ZenKit.API.ZkTrigger_setTarget(getHandle(), val);
	}

	public String getVobTarget() {
		return ZenKit.API.ZkTrigger_getVobTarget(getHandle());
	}

	public void setVobTarget(String val) {
		ZenKit.API.ZkTrigger_setVobTarget(getHandle(), val);
	}

	public int getMaxActivationCount() {
		return ZenKit.API.ZkTrigger_getMaxActivationCount(getHandle());
	}

	public void setMaxActivationCount(int val) {
		ZenKit.API.ZkTrigger_setMaxActivationCount(getHandle(), val);
	}

	public Duration getRetriggerDelay() {
		return Duration.ofSeconds((long) ZenKit.API.ZkTrigger_getRetriggerDelaySeconds(getHandle()));
	}

	public void setRetriggerDelay(@NotNull Duration val) {
		ZenKit.API.ZkTrigger_setRetriggerDelaySeconds(getHandle(), val.getSeconds());
	}

	public float getDamageThreshold() {
		return ZenKit.API.ZkTrigger_getDamageThreshold(getHandle());
	}

	public void setDamageThreshold(float val) {
		ZenKit.API.ZkTrigger_setDamageThreshold(getHandle(), val);
	}

	public Duration getFireDelay() {
		return Duration.ofSeconds((long) ZenKit.API.ZkTrigger_getFireDelaySeconds(getHandle()));
	}

	public void setFireDelay(@NotNull Duration val) {
		ZenKit.API.ZkTrigger_setFireDelaySeconds(getHandle(), val.getSeconds());
	}

	public boolean getStartEnabled() {
		return ZenKit.API.ZkTrigger_getStartEnabled(getHandle());
	}

	public void setStartEnabled(boolean b) {
		ZenKit.API.ZkTrigger_setStartEnabled(getHandle(), b);
	}

	public boolean getSendUntrigger() {
		return ZenKit.API.ZkTrigger_getSendUntrigger(getHandle());
	}

	public void setSendUntrigger(boolean b) {
		ZenKit.API.ZkTrigger_setSendUntrigger(getHandle(), b);
	}

	public boolean getReactToOnTrigger() {
		return ZenKit.API.ZkTrigger_getReactToOnTrigger(getHandle());
	}

	public void setReactToOnTrigger(boolean b) {
		ZenKit.API.ZkTrigger_setReactToOnTrigger(getHandle(), b);
	}

	public boolean getReactToOnTouch() {
		return ZenKit.API.ZkTrigger_getReactToOnTouch(getHandle());
	}

	public void setReactToOnTouch(boolean b) {
		ZenKit.API.ZkTrigger_setReactToOnTouch(getHandle(), b);
	}

	public boolean getReactToOnDamage() {
		return ZenKit.API.ZkTrigger_getReactToOnDamage(getHandle());
	}

	public void setReactToOnDamage(boolean b) {
		ZenKit.API.ZkTrigger_setReactToOnDamage(getHandle(), b);
	}

	public boolean getRespondToObject() {
		return ZenKit.API.ZkTrigger_getRespondToObject(getHandle());
	}

	public void setRespondToObject(boolean b) {
		ZenKit.API.ZkTrigger_setRespondToObject(getHandle(), b);
	}

	public boolean getRespondToPC() {
		return ZenKit.API.ZkTrigger_getRespondToPC(getHandle());
	}

	public void setRespondToPC(boolean b) {
		ZenKit.API.ZkTrigger_setRespondToPC(getHandle(), b);
	}

	public boolean getRespondToNPC() {
		return ZenKit.API.ZkTrigger_getRespondToNPC(getHandle());
	}

	public void setRespondToNPC(boolean b) {
		ZenKit.API.ZkTrigger_setRespondToNPC(getHandle(), b);
	}

	public float getNextTimeTriggerable() {
		return ZenKit.API.ZkTrigger_getNextTimeTriggerable(getHandle());
	}

	public void setNextTimeTriggerable(float val) {
		ZenKit.API.ZkTrigger_setNextTimeTriggerable(getHandle(), val);
	}

	public VirtualObject getOtherVob() {
		var ptr = ZenKit.API.ZkTrigger_getOtherVob(getHandle());
		return VirtualObject.fromNative(ptr);
	}

	public void setOtherVob(VirtualObject obj) {
		ZenKit.API.ZkTrigger_setOtherVob(getHandle(), obj != null ? obj.getHandle() : Pointer.NULL);
	}

	public int getCountCanBeActivated() {
		return ZenKit.API.ZkTrigger_getCountCanBeActivated(getHandle());
	}

	public void setCountCanBeActivated(int val) {
		ZenKit.API.ZkTrigger_setCountCanBeActivated(getHandle(), val);
	}

	public boolean isEnabled() {
		return ZenKit.API.ZkTrigger_getIsEnabled(getHandle());
	}

	public void setEnabled(boolean val) {
		ZenKit.API.ZkTrigger_setIsEnabled(getHandle(), val);
	}
}
