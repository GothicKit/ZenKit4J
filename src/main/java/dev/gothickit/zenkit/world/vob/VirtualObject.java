package dev.gothickit.zenkit.world.vob;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class VirtualObject {
	private final Handle handle;

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
		this(handle, pointer -> {
		});
	}

	protected VirtualObject(Pointer handle, Consumer<Pointer> delete) {
		this.handle = new Handle(handle, delete);
	}

	public static VirtualObject fromNative(Pointer ptr) {
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
			default -> new VirtualObject(ptr);
		};
	}

	public Pointer getHandle() {
		return handle.get();
	}

	public Vec3f getPosition() {
		return ZenKit.API.ZkVirtualObject_getPosition(getHandle());
	}

	public Mat3x3 getRotation() {
		return ZenKit.API.ZkVirtualObject_getRotation(getHandle());
	}

	public AxisAlignedBoundingBox getBoundingBox() {
		return ZenKit.API.ZkVirtualObject_getBbox(getHandle());
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

	public SpriteAlignment getSpriteCameraFacingMode() {
		return ZenKit.API.ZkVirtualObject_getSpriteCameraFacingMode(getHandle());
	}

	public boolean isCdStatic() {
		return ZenKit.API.ZkVirtualObject_getCdStatic(getHandle());
	}

	public boolean isCdDynamic() {
		return ZenKit.API.ZkVirtualObject_getCdDynamic(getHandle());
	}

	public boolean isStatic() {
		return ZenKit.API.ZkVirtualObject_getVobStatic(getHandle());
	}

	public ShadowType getDynamicShadows() {
		return ZenKit.API.ZkVirtualObject_getDynamicShadows(getHandle());
	}

	public boolean isPhysicsEnabled() {
		return ZenKit.API.ZkVirtualObject_getPhysicsEnabled(getHandle());
	}

	public AnimationType getAnimationType() {
		return ZenKit.API.ZkVirtualObject_getAnimMode(getHandle());

	}

	public int getBias() {
		return ZenKit.API.ZkVirtualObject_getBias(getHandle());
	}

	public boolean getAmbient() {
		return ZenKit.API.ZkVirtualObject_getAmbient(getHandle());
	}

	public float getAnimationStrength() {
		return ZenKit.API.ZkVirtualObject_getAnimStrength(getHandle());
	}

	public float getFarClipScale() {
		return ZenKit.API.ZkVirtualObject_getFarClipScale(getHandle());
	}

	public String getPresetName() {
		return ZenKit.API.ZkVirtualObject_getPresetName(getHandle());
	}

	public String getName() {
		return ZenKit.API.ZkVirtualObject_getName(getHandle());
	}

	public String getVisualName() {
		return ZenKit.API.ZkVirtualObject_getVisualName(getHandle());
	}

	public VisualType getVisualType() {
		return ZenKit.API.ZkVirtualObject_getVisualType(getHandle());
	}

	public @Nullable Decal getVisualDecal() {
		var ptr = ZenKit.API.ZkVirtualObject_getVisualDecal(getHandle());
		if (ptr == Pointer.NULL) return null;
		return new Decal(ptr);
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
}
