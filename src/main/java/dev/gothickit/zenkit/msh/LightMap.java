package dev.gothickit.zenkit.msh;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.Vec3f;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.tex.Texture;

public class LightMap {
	private final Pointer handle;

	public LightMap(Pointer handle) {
		this.handle = handle;
	}

	public Texture getImage() {
		return new Texture(ZenKit.API.ZkLightMap_getImage(handle));
	}

	public Vec3f getOrigin() {
		return ZenKit.API.ZkLightMap_getOrigin(handle);
	}

	public Vec3f[] getNormals() {
		return new Vec3f[]{
				ZenKit.API.ZkLightMap_getNormal(handle, 0),
				ZenKit.API.ZkLightMap_getNormal(handle, 1),
		};
	}
}
