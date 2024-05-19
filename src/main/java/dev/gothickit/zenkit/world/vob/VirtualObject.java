package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.world.Ai;
import dev.gothickit.zenkit.world.EventManager;
import dev.gothickit.zenkit.world.visual.Visual;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class VirtualObject implements NativeObject {
	private final Handle handle;

	public VirtualObject() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCVob));
	}

	VirtualObject(@NotNull NativeRead buf, GameVersion version) {
		this.handle = new Handle(
				ZenKit.API.ZkVirtualObject_load(buf.getNativeHandle(), version),
				ZenKit.API::ZkVirtualObject_del
		);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load virtual object");
	}

	VirtualObject(String path, GameVersion version) {
		this.handle = new Handle(ZenKit.API.ZkVirtualObject_loadPath(path, version), ZenKit.API::ZkVirtualObject_del);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load virtual object");
	}

	protected VirtualObject(Pointer handle) {
		this(handle, ZenKit.API::ZkVirtualObject_del);
	}

	protected VirtualObject(Pointer handle, Consumer<Pointer> delete) {
		this.handle = new Handle(handle, delete);
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable VirtualObject fromNativeHandle(@Nullable Pointer ptr) {
		if (ptr == null) return null;

		ptr = ZenKit.API.ZkObject_takeRef(ptr);
		return switch (ZenKit.API.ZkVirtualObject_getType(ptr)) {
			case zCCSCamera -> new CutsceneCamera(ptr);
			case zCVobLight -> new Light(ptr);
			case zCVobAnimate -> new Animate(ptr);
			case zCCodeMaster -> new CodeMaster(ptr);
			case zCEarthquake -> new Earthquake(ptr);
			case oCItem -> new Item(ptr);
			case zCVobLensFlare -> new LensFlare(ptr);
			case zCMessageFilter -> new MessageFilter(ptr);
			case zCMoverController -> new MoverController(ptr);
			case zCPFXController -> new ParticleEffectController(ptr);
			case oCTouchDamage -> new TouchDamage(ptr);
			case oCMobContainer -> new Container(ptr);
			case oCMobDoor -> new Door(ptr);
			case oCMobFire -> new Fire(ptr);
			case oCMobInter, oCMobLadder, oCMobSwitch, oCMobWheel, oCMobBed -> new InteractiveObject(ptr);
			case oCMOB -> new MovableObject(ptr);
			case zCVobSound -> new Sound(ptr);
			case zCVobSoundDaytime -> new SoundDaytime(ptr);
			case zCTrigger, oCCSTrigger -> new Trigger(ptr);
			case zCTriggerList -> new TriggerList(ptr);
			case oCTriggerScript -> new TriggerScript(ptr);
			case zCMover -> new Mover(ptr);
			case oCTriggerChangeLevel -> new TriggerChangeLevel(ptr);
			case zCTriggerWorldStart -> new TriggerWorldStart(ptr);
			case zCTriggerUntouch -> new TriggerUntouch(ptr);
			case oCZoneMusic, oCZoneMusicDefault -> new ZoneMusic(ptr);
			case zCZoneZFog, zCZoneZFogDefault -> new ZoneFog(ptr);
			case zCZoneVobFarPlane, zCZoneVobFarPlaneDefault -> new ZoneFarPlane(ptr);
			default -> new VirtualObject(ptr);
		};
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle.get();
	}

	public Vec3f getPosition() {
		return ZenKit.API.ZkVirtualObject_getPosition(getNativeHandle());
	}

	public void setPosition(Vec3f val) {
		ZenKit.API.ZkVirtualObject_setPosition(getNativeHandle(), val);
	}

	public Mat3x3 getRotation() {
		return ZenKit.API.ZkVirtualObject_getRotation(getNativeHandle());
	}

	public void setRotation(Mat3x3 val) {
		ZenKit.API.ZkVirtualObject_setRotation(getNativeHandle(), new Mat3x3.ByValue(val));
	}

	public AxisAlignedBoundingBox getBoundingBox() {
		return ZenKit.API.ZkVirtualObject_getBbox(getNativeHandle());
	}

	public void setBoundingBox(AxisAlignedBoundingBox val) {
		ZenKit.API.ZkVirtualObject_setBbox(getNativeHandle(), new AxisAlignedBoundingBox.ByValue(val));
	}

	public VirtualObjectType getType() {
		return ZenKit.API.ZkVirtualObject_getType(getNativeHandle());
	}

	public int getId() {
		return ZenKit.API.ZkVirtualObject_getId(getNativeHandle());
	}

	public boolean getShowVisual() {
		return ZenKit.API.ZkVirtualObject_getShowVisual(getNativeHandle());
	}

	public void setShowVisual(boolean val) {
		ZenKit.API.ZkVirtualObject_setShowVisual(getNativeHandle(), val);
	}

	public SpriteAlignment getSpriteCameraFacingMode() {
		return ZenKit.API.ZkVirtualObject_getSpriteCameraFacingMode(getNativeHandle());
	}

	public void setSpriteCameraFacingMode(SpriteAlignment val) {
		ZenKit.API.ZkVirtualObject_setSpriteCameraFacingMode(getNativeHandle(), val);
	}

	public boolean isCdStatic() {
		return ZenKit.API.ZkVirtualObject_getCdStatic(getNativeHandle());
	}

	public void setCdStatic(boolean val) {
		ZenKit.API.ZkVirtualObject_setCdStatic(getNativeHandle(), val);
	}

	public boolean isCdDynamic() {
		return ZenKit.API.ZkVirtualObject_getCdDynamic(getNativeHandle());
	}

	public void setCdDynamic(boolean val) {
		ZenKit.API.ZkVirtualObject_setCdDynamic(getNativeHandle(), val);
	}

	public boolean isStatic() {
		return ZenKit.API.ZkVirtualObject_getVobStatic(getNativeHandle());
	}

	public void setStatic(boolean val) {
		ZenKit.API.ZkVirtualObject_setVobStatic(getNativeHandle(), val);
	}

	public ShadowType getDynamicShadows() {
		return ZenKit.API.ZkVirtualObject_getDynamicShadows(getNativeHandle());
	}

	public void setDynamicShadows(ShadowType val) {
		ZenKit.API.ZkVirtualObject_setDynamicShadows(getNativeHandle(), val);
	}

	public boolean isPhysicsEnabled() {
		return ZenKit.API.ZkVirtualObject_getPhysicsEnabled(getNativeHandle());
	}

	public void setPhysicsEnabled(boolean val) {
		ZenKit.API.ZkVirtualObject_setPhysicsEnabled(getNativeHandle(), val);
	}

	public AnimationType getAnimationType() {
		return ZenKit.API.ZkVirtualObject_getAnimMode(getNativeHandle());
	}

	public void setAnimationType(AnimationType val) {
		ZenKit.API.ZkVirtualObject_setAnimMode(getNativeHandle(), val);
	}

	public int getBias() {
		return ZenKit.API.ZkVirtualObject_getBias(getNativeHandle());
	}

	public void setBias(int val) {
		ZenKit.API.ZkVirtualObject_setBias(getNativeHandle(), val);
	}

	public boolean getAmbient() {
		return ZenKit.API.ZkVirtualObject_getAmbient(getNativeHandle());
	}

	public void setAmbient(boolean val) {
		ZenKit.API.ZkVirtualObject_setAmbient(getNativeHandle(), val);
	}

	public float getAnimationStrength() {
		return ZenKit.API.ZkVirtualObject_getAnimStrength(getNativeHandle());
	}

	public void setAnimationStrength(float val) {
		ZenKit.API.ZkVirtualObject_setAnimStrength(getNativeHandle(), val);
	}

	public float getFarClipScale() {
		return ZenKit.API.ZkVirtualObject_getFarClipScale(getNativeHandle());
	}

	public void setFarClipScale(float val) {
		ZenKit.API.ZkVirtualObject_setFarClipScale(getNativeHandle(), val);
	}

	public String getPresetName() {
		return ZenKit.API.ZkVirtualObject_getPresetName(getNativeHandle());
	}

	public void setPresetName(String val) {
		ZenKit.API.ZkVirtualObject_setPresetName(getNativeHandle(), val);
	}

	public String getName() {
		return ZenKit.API.ZkVirtualObject_getName(getNativeHandle());
	}

	public void setName(String val) {
		ZenKit.API.ZkVirtualObject_setName(getNativeHandle(), val);
	}

	public @NotNull Visual getVisual() {
		var visual = ZenKit.API.ZkVirtualObject_getVisual(getNativeHandle());
		return Visual.fromNativeHandle(visual);
	}

	public void setVisual(@Nullable Visual val) {
		ZenKit.API.ZkVirtualObject_setVisual(getNativeHandle(), val != null ? val.getNativeHandle() : Pointer.NULL);
	}

	public long getChildCount() {
		return ZenKit.API.ZkVirtualObject_getChildCount(getNativeHandle());
	}

	public @Nullable VirtualObject getChild(long i) {
		return fromNativeHandle(ZenKit.API.ZkVirtualObject_getChild(getNativeHandle(), i));
	}

	public @NotNull List<@NotNull VirtualObject> getChildren() {
		var children = new ArrayList<VirtualObject>();

		ZenKit.API.ZkVirtualObject_enumerateChildren(getNativeHandle(), (ctx, vob) -> {
			children.add(new VirtualObject(vob));
			return false;
		}, Pointer.NULL);

		return children;
	}

	public void addChild(@NotNull VirtualObject child) {
		ZenKit.API.ZkVirtualObject_addChild(getNativeHandle(), child.getNativeHandle());
	}

	public byte getSleepMode() {
		return ZenKit.API.ZkVirtualObject_getSleepMode(getNativeHandle());
	}

	public void setSleepMode(byte val) {
		ZenKit.API.ZkVirtualObject_setSleepMode(getNativeHandle(), val);
	}

	public float getNextOnTimer() {
		return ZenKit.API.ZkVirtualObject_getNextOnTimer(getNativeHandle());
	}

	public void setNextOnTimer(float val) {
		ZenKit.API.ZkVirtualObject_setNextOnTimer(getNativeHandle(), val);
	}

	public @Nullable Ai getAi() {
		var ptr = ZenKit.API.ZkVirtualObject_getAi(getNativeHandle());
		return Ai.fromNativeHandle(ptr);
	}

	public void setAi(@Nullable Ai val) {
		ZenKit.API.ZkVirtualObject_setAi(getNativeHandle(), val != null ? val.getNativeHandle() : Pointer.NULL);
	}

	public @Nullable EventManager getEventManager() {
		var ptr = ZenKit.API.ZkVirtualObject_getEventManager(getNativeHandle());
		return EventManager.fromNativeHandle(ptr);
	}

	public void setEventManager(@Nullable EventManager val) {
		ZenKit.API.ZkVirtualObject_setEventManager(getNativeHandle(), val != null ? val.getNativeHandle() : Pointer.NULL);
	}
}
