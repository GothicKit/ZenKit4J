package dev.gothickit.zenkit.fnt;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Font {
	private final Handle handle;

	public Font(String path) {
		var handle = new Handle(ZenKit.API.ZkFont_loadPath(path), ZenKit.API::ZkFont_del);
		if (handle.isNull()) throw new RuntimeException("Failed to load font");
		ZenKit.CLEANER.register(this, handle);
		this.handle = handle;
	}

	public Font(@NotNull Read buf) {
		var handle = new Handle(ZenKit.API.ZkFont_load(buf.getHandle()), ZenKit.API::ZkFont_del);
		if (handle.isNull()) throw new RuntimeException("Failed to load font");
		ZenKit.CLEANER.register(this, handle);
		this.handle = handle;
	}

	public Font(@NotNull Vfs vfs, String name) {
		var handle = new Handle(ZenKit.API.ZkFont_loadVfs(vfs.getHandle(), name), ZenKit.API::ZkFont_del);
		if (handle.isNull()) throw new RuntimeException("Failed to load font");
		ZenKit.CLEANER.register(this, handle);
		this.handle = handle;
	}

	public Pointer getHandle() {
		return this.handle.get();
	}

	public String getName() {
		return ZenKit.API.ZkFont_getName(this.getHandle());
	}

	public int getHeight() {
		return ZenKit.API.ZkFont_getHeight(this.getHandle());
	}

	public long getGlyphCount() {
		return ZenKit.API.ZkFont_getGlyphCount(this.getHandle());
	}

	public FontGlyph getGlyph(long i) {
		return ZenKit.API.ZkFont_getGlyph(this.getHandle(), i);
	}

	public List<FontGlyph> getGlyphs() {
		var glyphs = new ArrayList<FontGlyph>();

		ZenKit.API.ZkFont_enumerateGlyphs(this.getHandle(), (ctx, glyph) -> {
			glyphs.add(glyph);
			return false;
		}, Pointer.NULL);

		return glyphs;
	}
}
