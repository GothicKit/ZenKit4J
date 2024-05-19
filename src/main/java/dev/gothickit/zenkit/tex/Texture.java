package dev.gothickit.zenkit.tex;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public final class Texture implements NativeObject {
	private final Handle handle;

	private Texture(@NotNull NativeRead buf) throws ResourceIOException {
		this.handle = new Handle(ZenKit.API.ZkTexture_load(buf.getNativeHandle()), ZenKit.API::ZkTexture_del);

		if (handle.isNull()) {
			throw new ResourceIOException(Texture.class, ResourceIOSource.STREAM, buf.toString());
		}
	}

	private Texture(String path) throws ResourceIOException {
		this.handle = new Handle(ZenKit.API.ZkTexture_loadPath(path), ZenKit.API::ZkTexture_del);

		if (handle.isNull()) {
			throw new ResourceIOException(Texture.class, ResourceIOSource.DISK, path);
		}
	}

	private Texture(@NotNull Vfs vfs, String name) throws ResourceIOException {
		this.handle = new Handle(ZenKit.API.ZkTexture_loadVfs(vfs.getNativeHandle(), name), ZenKit.API::ZkTexture_del);

		if (handle.isNull()) {
			throw new ResourceIOException(Texture.class, ResourceIOSource.VFS, name);
		}
	}

	private Texture(Pointer handle) {
		this.handle = new Handle(handle, (o) -> {
		});
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable Texture fromNativeHandle(@Nullable Pointer handle) {
		if (handle == null) return null;
		return new Texture(handle);
	}

	@Contract("_ -> new")
	public static @NotNull Texture load(@NotNull String path) throws ResourceIOException {
		return new Texture(path);
	}

	@Contract("_ -> new")
	public static @NotNull Texture load(@NotNull Read buf) throws ResourceIOException {
		return new Texture(Read.adapt(buf));
	}

	@Contract("_, _ -> new")
	public static @NotNull Texture load(@NotNull Vfs vfs, @NotNull String name) throws ResourceIOException {
		return new Texture(vfs, name);
	}

	public @NotNull Pointer getNativeHandle() {
		return handle.get();
	}

	public TextureFormat getFormat() {
		return ZenKit.API.ZkTexture_getFormat(this.getNativeHandle());
	}

	public int getWidth() {
		return ZenKit.API.ZkTexture_getWidth(this.getNativeHandle());
	}

	public int getHeight() {
		return ZenKit.API.ZkTexture_getHeight(this.getNativeHandle());
	}

	public int getWidthRef() {
		return ZenKit.API.ZkTexture_getWidthRef(this.getNativeHandle());
	}

	public int getHeightRef() {
		return ZenKit.API.ZkTexture_getHeightRef(this.getNativeHandle());
	}

	public int getWidth(long level) {
		return ZenKit.API.ZkTexture_getWidthMipmap(this.getNativeHandle(), level);
	}

	public int getHeight(long level) {
		return ZenKit.API.ZkTexture_getHeightMipmap(this.getNativeHandle(), level);
	}

	public int getMipmapCount() {
		return ZenKit.API.ZkTexture_getMipmapCount(this.getNativeHandle());
	}

	public int getAverageColor() {
		return ZenKit.API.ZkTexture_getAverageColor(this.getNativeHandle());
	}

	public @Nullable Color[] getPalette() {
		if (getFormat() != TextureFormat.P8) return null;

		var count = new IntByReference();
		var raw = ZenKit.API.ZkTexture_getPalette(this.getNativeHandle(), count);
		if (raw == null || count.getValue() == 0) return null;
		return (Color[]) raw.toArray(count.getValue());
	}

	public byte[] getMipmapRaw(long level) {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkTexture_getMipmapRaw(this.getNativeHandle(), level, count);
		if (ptr == Pointer.NULL || count.getValue() == 0) return null;
		return ptr.getByteArray(0, count.getValue());
	}

	public byte[] getMipmapRgba(long level) {
		var data = new byte[getHeight(level) * getWidth(level) * 4];
		ZenKit.API.ZkTexture_getMipmapRgba(this.getNativeHandle(), level, data, data.length);
		return data;
	}

	public List<byte[]> getAllMipmapsRaw() {
		var mipmaps = new ArrayList<byte[]>();

		ZenKit.API.ZkTexture_enumerateRawMipmaps(this.getNativeHandle(), (ctx, lvl, data, size) -> {
			mipmaps.add(data.getByteArray(0, (int) size));
			return false;
		}, Pointer.NULL);

		return mipmaps;
	}

	public List<byte[]> getAllMipmapsRgba() {
		var mipmaps = new ArrayList<byte[]>();

		ZenKit.API.ZkTexture_enumerateRgbaMipmaps(this.getNativeHandle(), (ctx, lvl, data, size) -> {
			mipmaps.add(data.getByteArray(0, (int) size));
			return false;
		}, Pointer.NULL);

		return mipmaps;
	}
}
