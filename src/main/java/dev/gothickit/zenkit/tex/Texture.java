package dev.gothickit.zenkit.tex;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import dev.gothickit.zenkit.Color;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Texture {
	private final Handle handle;

	public Texture(@NotNull Read buf) {
		this.handle = new Handle(ZenKit.API.ZkTexture_load(buf.getHandle()), ZenKit.API::ZkTexture_del);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load texture");
	}

	public Texture(String path) {
		this.handle = new Handle(ZenKit.API.ZkTexture_loadPath(path), ZenKit.API::ZkTexture_del);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load texture");
	}

	public Texture(@NotNull Vfs vfs, String name) {
		this.handle = new Handle(ZenKit.API.ZkTexture_loadVfs(vfs.getHandle(), name), ZenKit.API::ZkTexture_del);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load texture");
	}

	public Pointer getHandle() {
		return handle.get();
	}

	public TextureFormat getFormat() {
		return ZenKit.API.ZkTexture_getFormat(this.getHandle());
	}

	public int getWidth() {
		return ZenKit.API.ZkTexture_getWidth(this.getHandle());
	}

	public int getHeight() {
		return ZenKit.API.ZkTexture_getHeight(this.getHandle());
	}

	public int getWidthRef() {
		return ZenKit.API.ZkTexture_getWidthRef(this.getHandle());
	}

	public int getHeightRef() {
		return ZenKit.API.ZkTexture_getHeightRef(this.getHandle());
	}

	public int getWidth(long level) {
		return ZenKit.API.ZkTexture_getWidthMipmap(this.getHandle(), level);
	}

	public int getHeight(long level) {
		return ZenKit.API.ZkTexture_getHeightMipmap(this.getHandle(), level);
	}

	public int getMipmapCount() {
		return ZenKit.API.ZkTexture_getMipmapCount(this.getHandle());
	}

	public int getAverageColor() {
		return ZenKit.API.ZkTexture_getAverageColor(this.getHandle());
	}

	public @Nullable Color[] getPalette() {
		if (getFormat() != TextureFormat.P8) return null;

		var count = new IntByReference();
		var raw = ZenKit.API.ZkTexture_getPalette(this.getHandle(), count);
		if (raw == null || count.getValue() == 0) return null;
		return (Color[]) raw.toArray(count.getValue());
	}

	public byte[] getMipmapRaw(long level) {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkTexture_getMipmapRaw(this.getHandle(), level, count);
		if (ptr == Pointer.NULL || count.getValue() == 0) return null;
		return ptr.getByteArray(0, count.getValue());
	}

	public byte[] getMipmapRgba(long level) {
		var data = new byte[getHeight(level) * getWidth(level) * 4];
		ZenKit.API.ZkTexture_getMipmapRgba(this.getHandle(), level, data, data.length);
		return data;
	}

	public List<byte[]> getAllMipmapsRaw() {
		var mipmaps = new ArrayList<byte[]>();

		ZenKit.API.ZkTexture_enumerateRawMipmaps(this.getHandle(), (ctx, lvl, data, size) -> {
			mipmaps.add(data.getByteArray(0, (int) size));
			return false;
		}, Pointer.NULL);

		return mipmaps;
	}

	public List<byte[]> getAllMipmapsRgba() {
		var mipmaps = new ArrayList<byte[]>();

		ZenKit.API.ZkTexture_enumerateRgbaMipmaps(this.getHandle(), (ctx, lvl, data, size) -> {
			mipmaps.add(data.getByteArray(0, (int) size));
			return false;
		}, Pointer.NULL);

		return mipmaps;
	}
}
