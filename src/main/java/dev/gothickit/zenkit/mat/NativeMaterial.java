package dev.gothickit.zenkit.mat;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NativeMaterial implements NativeObject, Material {
	private final Handle handle;

	NativeMaterial(@NotNull Read buf) throws ResourceIOException {
		this.handle = new Handle(ZenKit.API.ZkMaterial_load(buf.getHandle()), ZenKit.API::ZkMaterial_del);

		if (handle.isNull()) {
			throw new ResourceIOException(Material.class, ResourceIOSource.STREAM, buf.toString());
		}
	}

	NativeMaterial(String path) throws ResourceIOException {
		this.handle = new Handle(ZenKit.API.ZkMaterial_loadPath(path), ZenKit.API::ZkMaterial_del);

		if (handle.isNull()) {
			throw new ResourceIOException(Material.class, ResourceIOSource.DISK, path);
		}
	}

	private NativeMaterial(Pointer handle) {
		this.handle = new Handle(handle, (o) -> {
		});
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable NativeMaterial fromNativeHandle(Pointer handle) {
		if (handle == null) return null;
		return new NativeMaterial(handle);
	}

	@Override
	public @NotNull String name() {
		return ZenKit.API.ZkMaterial_getName(getNativeHandle());
	}

	@Override
	public @NotNull MaterialGroup group() {
		return ZenKit.API.ZkMaterial_getGroup(getNativeHandle());
	}

	@Override
	public @NotNull Color color() {
		return ZenKit.API.ZkMaterial_getColor(getNativeHandle());
	}

	@Override
	public float smoothAngle() {
		return ZenKit.API.ZkMaterial_getSmoothAngle(getNativeHandle());
	}

	@Override
	public @NotNull String texture() {
		return ZenKit.API.ZkMaterial_getTexture(getNativeHandle());
	}

	@Override
	public @NotNull Vec2f textureScale() {
		return ZenKit.API.ZkMaterial_getTextureScale(getNativeHandle());
	}

	@Override
	public float textureAnimationFps() {
		return ZenKit.API.ZkMaterial_getTextureAnimationFps(getNativeHandle());
	}

	@Override
	public @NotNull AnimationMapping textureAnimationMapping() {
		return ZenKit.API.ZkMaterial_getTextureAnimationMapping(getNativeHandle());
	}

	@Override
	public @NotNull Vec2f textureAnimationMappingDirection() {
		return ZenKit.API.ZkMaterial_getTextureAnimationMappingDirection(getNativeHandle());
	}

	@Override
	public boolean disableCollision() {
		return ZenKit.API.ZkMaterial_getDisableCollision(getNativeHandle());
	}

	@Override
	public boolean disableLightmap() {
		return ZenKit.API.ZkMaterial_getDisableLightmap(getNativeHandle());
	}

	@Override
	public boolean dontCollapse() {
		return ZenKit.API.ZkMaterial_getDontCollapse(getNativeHandle());
	}

	@Override
	public @NotNull String detailObject() {
		return ZenKit.API.ZkMaterial_getDetailObject(getNativeHandle());
	}

	@Override
	public float detailObjectScale() {
		return ZenKit.API.ZkMaterial_getDetailObjectScale(getNativeHandle());
	}

	@Override
	public boolean forceOccluder() {
		return ZenKit.API.ZkMaterial_getForceOccluder(getNativeHandle());
	}

	@Override
	public boolean environmentMapping() {
		return ZenKit.API.ZkMaterial_getEnvironmentMapping(getNativeHandle());
	}

	@Override
	public float environmentMappingStrength() {
		return ZenKit.API.ZkMaterial_getEnvironmentMappingStrength(getNativeHandle());
	}

	@Override
	public @NotNull WaveMode waveMode() {
		return ZenKit.API.ZkMaterial_getWaveMode(getNativeHandle());
	}

	@Override
	public @NotNull WaveSpeed waveSpeed() {
		return ZenKit.API.ZkMaterial_getWaveSpeed(getNativeHandle());
	}

	@Override
	public float waveAmplitude() {
		return ZenKit.API.ZkMaterial_getWaveAmplitude(getNativeHandle());
	}

	@Override
	public float waveGridSize() {
		return ZenKit.API.ZkMaterial_getWaveGridSize(getNativeHandle());
	}

	@Override
	public boolean ignoreSun() {
		return ZenKit.API.ZkMaterial_getIgnoreSun(getNativeHandle());
	}

	@Override
	public @NotNull AlphaFunction alphaFunction() {
		return ZenKit.API.ZkMaterial_getAlphaFunction(getNativeHandle());
	}

	@Override
	public @NotNull Vec2f defaultMapping() {
		return ZenKit.API.ZkMaterial_getDefaultMapping(getNativeHandle());
	}

	@Override
	public @NotNull CachedMaterial cache() {
		return new CachedMaterial(
				name(),
				group(),
				color(),
				smoothAngle(),
				texture(),
				textureScale(),
				textureAnimationFps(),
				textureAnimationMapping(),
				textureAnimationMappingDirection(),
				disableCollision(),
				disableLightmap(),
				dontCollapse(),
				detailObject(),
				detailObjectScale(),
				forceOccluder(),
				environmentMapping(),
				environmentMappingStrength(),
				waveMode(),
				waveSpeed(),
				waveAmplitude(),
				waveGridSize(),
				ignoreSun(),
				alphaFunction(),
				defaultMapping()
		);
	}

	@Override
	public boolean isCached() {
		return false;
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle.get();
	}
}
