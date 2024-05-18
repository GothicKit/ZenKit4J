package dev.gothickit.zenkit.msh;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.Vec3f;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.tex.Texture;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NativeLightMap implements NativeObject, LightMap {
	private final Pointer handle;

	private NativeLightMap(Pointer handle) {
		this.handle = handle;
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable LightMap fromNativeHandle(Pointer handle) {
		if (handle == null) return null;
		return new NativeLightMap(handle);
	}

	@Override
	public @NotNull Texture image() {
		return new Texture(ZenKit.API.ZkLightMap_getImage(handle));
	}

	@Override
	public @NotNull Vec3f origin() {
		return ZenKit.API.ZkLightMap_getOrigin(handle);
	}

	@Override
	public Vec3f @NotNull [] normals() {
		return new Vec3f[]{
				ZenKit.API.ZkLightMap_getNormal(handle, 0),
				ZenKit.API.ZkLightMap_getNormal(handle, 1),
		};
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle;
	}

	@Override
	public @NotNull CachedLightMap cache() {
		return new CachedLightMap(
				image(),
				origin(),
				normals()
		);
	}

	@Override
	public boolean isCached() {
		return false;
	}
}
