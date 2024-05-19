package dev.gothickit.zenkit.mdl;

import dev.gothickit.zenkit.CacheableObject;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.ResourceIOException;
import dev.gothickit.zenkit.mdh.ModelHierarchy;
import dev.gothickit.zenkit.mdm.ModelMesh;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface Model extends CacheableObject<CachedModel> {
	@Contract("_ -> new")
	static @NotNull Model load(@NotNull String path) throws ResourceIOException {
		return new NativeModel(path);
	}

	@Contract("_ -> new")
	static @NotNull Model load(@NotNull Read buf) throws ResourceIOException {
		return new NativeModel(Read.adapt(buf));
	}

	@Contract("_, _ -> new")
	static @NotNull Model load(@NotNull Vfs vfs, @NotNull String name) throws ResourceIOException {
		return new NativeModel(vfs, name);
	}

	@Nullable
	ModelHierarchy hierarchy();

	@Nullable
	ModelMesh mesh();
}
