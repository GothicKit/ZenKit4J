package dev.gothickit.zenkit.csl;

import dev.gothickit.zenkit.CacheableObject;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.ResourceIOException;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface CutsceneLibrary extends CacheableObject<CachedCutsceneLibrary> {
	@Contract("_ -> new")
	static @NotNull CutsceneLibrary load(@NotNull String path) throws ResourceIOException {
		return new NativeCutsceneLibrary(path);
	}

	@Contract("_ -> new")
	static @NotNull CutsceneLibrary load(@NotNull Read buf) throws ResourceIOException {
		return new NativeCutsceneLibrary(Read.adapt(buf));
	}

	@Contract("_, _ -> new")
	static @NotNull CutsceneLibrary load(@NotNull Vfs vfs, @NotNull String name) throws ResourceIOException {
		return new NativeCutsceneLibrary(vfs, name);
	}

	long blockCount();

	@Nullable
	CutsceneBlock block(String name);

	@Nullable
	CutsceneBlock block(long i);

	@NotNull
	List<@NotNull CutsceneBlock> blocks();
}
