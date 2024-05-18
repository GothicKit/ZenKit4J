package dev.gothickit.zenkit.fnt;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.ResourceIOException;
import dev.gothickit.zenkit.ResourceIOSource;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public final class NativeFont implements NativeObject, Font {
	private final Handle handle;

	NativeFont(String path) throws ResourceIOException {
		var handle = new Handle(ZenKit.API.ZkFont_loadPath(path), ZenKit.API::ZkFont_del);

		if (handle.isNull()) {
			throw new ResourceIOException(Font.class, ResourceIOSource.DISK, path);
		}

		ZenKit.CLEANER.register(this, handle);
		this.handle = handle;
	}

	NativeFont(@NotNull Read buf) throws ResourceIOException {
		var handle = new Handle(ZenKit.API.ZkFont_load(buf.getHandle()), ZenKit.API::ZkFont_del);

		if (handle.isNull()) {
			throw new ResourceIOException(Font.class, ResourceIOSource.STREAM, buf.getHandle().toString());
		}

		ZenKit.CLEANER.register(this, handle);
		this.handle = handle;
	}

	NativeFont(@NotNull Vfs vfs, String name) throws ResourceIOException {
		var handle = new Handle(ZenKit.API.ZkFont_loadVfs(vfs.getHandle(), name), ZenKit.API::ZkFont_del);

		if (handle.isNull()) {
			throw new ResourceIOException(Font.class, ResourceIOSource.VFS, name);
		}

		ZenKit.CLEANER.register(this, handle);
		this.handle = handle;
	}

	@Override
	public @NotNull String name() {
		return ZenKit.API.ZkFont_getName(getNativeHandle());
	}

	@Override
	public int height() {
		return ZenKit.API.ZkFont_getHeight(getNativeHandle());
	}

	@Override
	public long glyphCount() {
		return ZenKit.API.ZkFont_getGlyphCount(getNativeHandle());
	}

	@Override
	public @Nullable FontGlyph glyph(long i) {
		return ZenKit.API.ZkFont_getGlyph(getNativeHandle(), i);
	}

	@Override
	public @NotNull List<FontGlyph> glyphs() {
		var glyphs = new ArrayList<FontGlyph>();

		ZenKit.API.ZkFont_enumerateGlyphs(getNativeHandle(), (ctx, glyph) -> {
			glyphs.add(new FontGlyph(glyph));
			return false;
		}, Pointer.NULL);

		return glyphs;
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle.get();
	}

	@Override
	public @NotNull CachedFont cache() {
		return new CachedFont(name(), height(), glyphs());
	}

	@Override
	public boolean isCached() {
		return false;
	}
}
