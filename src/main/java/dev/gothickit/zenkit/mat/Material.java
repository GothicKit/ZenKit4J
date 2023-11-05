package dev.gothickit.zenkit.mat;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.Color;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.Vec2f;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import org.jetbrains.annotations.NotNull;

public class Material {
	private final Handle handle;

	public Material(@NotNull Read buf) {
		this.handle = new Handle(ZenKit.API.ZkMaterial_load(buf.getHandle()), ZenKit.API::ZkMaterial_del);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load material");
	}

	public Material(String path) {
		this.handle = new Handle(ZenKit.API.ZkMaterial_loadPath(path), ZenKit.API::ZkMaterial_del);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load material");
	}

	public Material(Pointer handle) {
		this.handle = new Handle(handle, (o) -> {
		});
	}

	public Pointer getHandle() {
		return handle.get();
	}

	public String getName() {
		return ZenKit.API.ZkMaterial_getName(this.getHandle());
	}

	public MaterialGroup getGroup() {
		return ZenKit.API.ZkMaterial_getGroup(this.getHandle());
	}

	public Color getColor() {
		return ZenKit.API.ZkMaterial_getColor(this.getHandle());
	}

	public float getSmoothAngle() {
		return ZenKit.API.ZkMaterial_getSmoothAngle(this.getHandle());
	}

	public String getTexture() {
		return ZenKit.API.ZkMaterial_getTexture(this.getHandle());
	}

	public Vec2f getTextureScale() {
		return ZenKit.API.ZkMaterial_getTextureScale(this.getHandle());
	}

	public float getTextureAnimationFps() {
		return ZenKit.API.ZkMaterial_getTextureAnimationFps(this.getHandle());
	}

	public AnimationMapping getTextureAnimationMapping() {
		return ZenKit.API.ZkMaterial_getTextureAnimationMapping(this.getHandle());
	}

	public Vec2f getTextureAnimationMappingDirection() {
		return ZenKit.API.ZkMaterial_getTextureAnimationMappingDirection(this.getHandle());
	}

	public boolean getDisableCollision() {
		return ZenKit.API.ZkMaterial_getDisableCollision(this.getHandle());
	}

	public boolean getDisableLightmap() {
		return ZenKit.API.ZkMaterial_getDisableLightmap(this.getHandle());
	}

	public boolean getDontCollapse() {
		return ZenKit.API.ZkMaterial_getDontCollapse(this.getHandle());
	}

	public String getDetailObject() {
		return ZenKit.API.ZkMaterial_getDetailObject(this.getHandle());
	}

	public float getDetailObjectScale() {
		return ZenKit.API.ZkMaterial_getDetailObjectScale(this.getHandle());
	}

	public boolean getForceOccluder() {
		return ZenKit.API.ZkMaterial_getForceOccluder(this.getHandle());
	}

	public boolean getEnvironmentMapping() {
		return ZenKit.API.ZkMaterial_getEnvironmentMapping(this.getHandle());
	}

	public float getEnvironmentMappingStrength() {
		return ZenKit.API.ZkMaterial_getEnvironmentMappingStrength(this.getHandle());
	}

	public WaveMode getWaveMode() {
		return ZenKit.API.ZkMaterial_getWaveMode(this.getHandle());
	}

	public WaveSpeed getWaveSpeed() {
		return ZenKit.API.ZkMaterial_getWaveSpeed(this.getHandle());
	}

	public float getWaveAmplitude() {
		return ZenKit.API.ZkMaterial_getWaveAmplitude(this.getHandle());
	}

	public float getWaveGridSize() {
		return ZenKit.API.ZkMaterial_getWaveGridSize(this.getHandle());
	}

	public boolean getIgnoreSun() {
		return ZenKit.API.ZkMaterial_getIgnoreSun(this.getHandle());
	}

	public AlphaFunction getAlphaFunction() {
		return ZenKit.API.ZkMaterial_getAlphaFunction(this.getHandle());
	}

	public Vec2f getDefaultMapping() {
		return ZenKit.API.ZkMaterial_getDefaultMapping(this.getHandle());
	}
}
