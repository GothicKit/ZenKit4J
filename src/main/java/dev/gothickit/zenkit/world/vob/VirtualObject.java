package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.world.Ai;
import dev.gothickit.zenkit.world.EventManager;
import dev.gothickit.zenkit.world.visual.Visual;
import dev.gothickit.zenkit.world.visual.VisualDecal;
import dev.gothickit.zenkit.world.visual.VisualType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class VirtualObject {
	private final Handle handle;

	public VirtualObject() {
		this(ZenKit.API.ZkVirtualObject_new(VirtualObjectType.zCVob));
	}

	public VirtualObject(@NotNull Read buf, GameVersion version) {
		this.handle = new Handle(
				ZenKit.API.ZkVirtualObject_load(buf.getHandle(), version),
				ZenKit.API::ZkVirtualObject_del
		);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load virtual object");
	}

	public VirtualObject(String path, GameVersion version) {
		this.handle = new Handle(ZenKit.API.ZkVirtualObject_loadPath(path, version), ZenKit.API::ZkVirtualObject_del);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load virtual object");
	}

	protected VirtualObject(Pointer handle) {
		this(handle, ZenKit.API::ZkVirtualObject_del);
	}

	protected VirtualObject(Pointer handle, Consumer<Pointer> delete) {
		this.handle = new Handle(handle, delete);
	}

	public static @Nullable VirtualObject fromNative(Pointer ptr) {
		if (ptr == Pointer.NULL) {
			return null;
		}

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

	public Pointer getHandle() {
		return handle.get();
	}

	public Vec3f getPosition() {
		return ZenKit.API.ZkVirtualObject_getPosition(getHandle());
	}

	public void setPosition(Vec3f val) {
		ZenKit.API.ZkVirtualObject_setPosition(getHandle(), val);
	}

	public Mat3x3 getRotation() {
		return ZenKit.API.ZkVirtualObject_getRotation(getHandle());
	}

	public void setRotation(Mat3x3 val) {
		ZenKit.API.ZkVirtualObject_setRotation(getHandle(), new Mat3x3.ByValue(val));
	}

	public AxisAlignedBoundingBox getBoundingBox() {
		return ZenKit.API.ZkVirtualObject_getBbox(getHandle());
	}

	public void setBoundingBox(AxisAlignedBoundingBox val) {
		ZenKit.API.ZkVirtualObject_setBbox(getHandle(), new AxisAlignedBoundingBox.ByValue(val));
	}

	public VirtualObjectType getType() {
		return ZenKit.API.ZkVirtualObject_getType(getHandle());
	}

	public int getId() {
		return ZenKit.API.ZkVirtualObject_getId(getHandle());
	}

	public boolean getShowVisual() {
		return ZenKit.API.ZkVirtualObject_getShowVisual(getHandle());
	}

	public void setShowVisual(boolean val) {
		ZenKit.API.ZkVirtualObject_setShowVisual(getHandle(), val);
	}

	public SpriteAlignment getSpriteCameraFacingMode() {
		return ZenKit.API.ZkVirtualObject_getSpriteCameraFacingMode(getHandle());
	}

	public void setSpriteCameraFacingMode(SpriteAlignment val) {
		ZenKit.API.ZkVirtualObject_setSpriteCameraFacingMode(getHandle(), val);
	}

	public boolean isCdStatic() {
		return ZenKit.API.ZkVirtualObject_getCdStatic(getHandle());
	}

	public void setCdStatic(boolean val) {
		ZenKit.API.ZkVirtualObject_setCdStatic(getHandle(), val);
	}

	public boolean isCdDynamic() {
		return ZenKit.API.ZkVirtualObject_getCdDynamic(getHandle());
	}

	public void setCdDynamic(boolean val) {
		ZenKit.API.ZkVirtualObject_setCdDynamic(getHandle(), val);
	}

	public boolean isStatic() {
		return ZenKit.API.ZkVirtualObject_getVobStatic(getHandle());
	}

	public void setStatic(boolean val) {
		ZenKit.API.ZkVirtualObject_setVobStatic(getHandle(), val);
	}

	public ShadowType getDynamicShadows() {
		return ZenKit.API.ZkVirtualObject_getDynamicShadows(getHandle());
	}

	public void setDynamicShadows(ShadowType val) {
		ZenKit.API.ZkVirtualObject_setDynamicShadows(getHandle(), val);
	}

	public boolean isPhysicsEnabled() {
		return ZenKit.API.ZkVirtualObject_getPhysicsEnabled(getHandle());
	}

	public void setPhysicsEnabled(boolean val) {
		ZenKit.API.ZkVirtualObject_setPhysicsEnabled(getHandle(), val);
	}

	public AnimationType getAnimationType() {
		return ZenKit.API.ZkVirtualObject_getAnimMode(getHandle());
	}

	public void setAnimationType(AnimationType val) {
		ZenKit.API.ZkVirtualObject_setAnimMode(getHandle(), val);
	}

	public int getBias() {
		return ZenKit.API.ZkVirtualObject_getBias(getHandle());
	}

	public void setBias(int val) {
		ZenKit.API.ZkVirtualObject_setBias(getHandle(), val);
	}

	public boolean getAmbient() {
		return ZenKit.API.ZkVirtualObject_getAmbient(getHandle());
	}

	public void setAmbient(boolean val) {
		ZenKit.API.ZkVirtualObject_setAmbient(getHandle(), val);
	}

	public float getAnimationStrength() {
		return ZenKit.API.ZkVirtualObject_getAnimStrength(getHandle());
	}

	public void setAnimationStrength(float val) {
		ZenKit.API.ZkVirtualObject_setAnimStrength(getHandle(), val);
	}

	public float getFarClipScale() {
		return ZenKit.API.ZkVirtualObject_getFarClipScale(getHandle());
	}

	public void setFarClipScale(float val) {
		ZenKit.API.ZkVirtualObject_setFarClipScale(getHandle(), val);
	}

	public String getPresetName() {
		return ZenKit.API.ZkVirtualObject_getPresetName(getHandle());
	}

	public void setPresetName(String val) {
		ZenKit.API.ZkVirtualObject_setPresetName(getHandle(), val);
	}

	public String getName() {
		return ZenKit.API.ZkVirtualObject_getName(getHandle());
	}

	public void setName(String val) {
		ZenKit.API.ZkVirtualObject_setName(getHandle(), val);
	}

	public Visual getVisual() {
		var visual = ZenKit.API.ZkVirtualObject_getVisual(getHandle());
		var type = ZenKit.API.ZkVisual_getType(visual);

		if (type == VisualType.DECAL) {
			return new VisualDecal(visual);
		}

		return new Visual(visual);
	}

	public void setVisual(Visual val) {
		ZenKit.API.ZkVirtualObject_setVisual(getHandle(), val != null ? val.getHandle() : Pointer.NULL);
	}

	public long getChildCount() {
		return ZenKit.API.ZkVirtualObject_getChildCount(getHandle());
	}

	public VirtualObject getChild(long i) {
		return fromNative(ZenKit.API.ZkVirtualObject_getChild(getHandle(), i));
	}

	public List<VirtualObject> getChildren() {
		var children = new ArrayList<VirtualObject>();

		ZenKit.API.ZkVirtualObject_enumerateChildren(getHandle(), (ctx, vob) -> {
			children.add(new VirtualObject(vob));
			return false;
		}, Pointer.NULL);

		return children;
	}

	public void addChild(@NotNull VirtualObject child) {
		ZenKit.API.ZkVirtualObject_addChild(getHandle(), child.getHandle());
	}

	public byte getSleepMode() {
		return ZenKit.API.ZkVirtualObject_getSleepMode(getHandle());
	}

	public void setSleepMode(byte val) {
		ZenKit.API.ZkVirtualObject_setSleepMode(getHandle(), val);
	}

	public float getNextOnTimer() {
		return ZenKit.API.ZkVirtualObject_getNextOnTimer(getHandle());
	}

	public void setNextOnTimer(float val) {
		ZenKit.API.ZkVirtualObject_setNextOnTimer(getHandle(), val);
	}

	public Ai getAi() {
		var ptr = ZenKit.API.ZkVirtualObject_getAi(getHandle());
		return Ai.fromNative(ptr);
	}

	public void setAi(Ai val) {
		ZenKit.API.ZkVirtualObject_setAi(getHandle(), val != null ? val.getHandle() : Pointer.NULL);
	}

	public EventManager getEventManager() {
		var ptr = ZenKit.API.ZkVirtualObject_getEventManager(getHandle());
		return new EventManager(ZenKit.API.ZkObject_takeRef(ptr));
	}

	public void setEventManager(EventManager val) {
		ZenKit.API.ZkVirtualObject_setEventManager(getHandle(), val != null ? val.getHandle() : Pointer.NULL);
	}
}
