package dev.gothickit.zenkit.fnt;

import dev.gothickit.zenkit.CacheableObject;
import dev.gothickit.zenkit.NativeRead;
import dev.gothickit.zenkit.ResourceIOException;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface Font extends CacheableObject<CachedFont> {
	@Contract("_ -> new")
	static @NotNull Font load(@NotNull String path) throws ResourceIOException {
		return new NativeFont(path);
	}

	@Contract("_ -> new")
	static @NotNull Font load(@NotNull NativeRead buf) throws ResourceIOException {
		return new NativeFont(buf);
	}

	@Contract("_, _ -> new")
	static @NotNull Font load(@NotNull Vfs vfs, @NotNull String name) throws ResourceIOException {
		return new NativeFont(vfs, name);
	}

	@NotNull
	String name();

	int height();

	long glyphCount();

	@Nullable
	FontGlyph glyph(long i);

	@NotNull
	List<@NotNull FontGlyph> glyphs();
}
