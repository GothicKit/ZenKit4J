package dev.gothickit.zenkit.mdm;

import dev.gothickit.zenkit.CacheableObject;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.ResourceIOException;
import dev.gothickit.zenkit.mrm.MultiResolutionMesh;
import dev.gothickit.zenkit.ssm.SoftSkinMesh;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public interface ModelMesh extends CacheableObject<CachedModelMesh> {
	@Contract("_ -> new")
	static @NotNull ModelMesh load(@NotNull String path) throws ResourceIOException {
		return new NativeModelMesh(path);
	}

	@Contract("_ -> new")
	static @NotNull ModelMesh load(@NotNull Read buf) throws ResourceIOException {
		return new NativeModelMesh(Read.adapt(buf));
	}

	@Contract("_, _ -> new")
	static @NotNull ModelMesh load(@NotNull Vfs vfs, @NotNull String name) throws ResourceIOException {
		return new NativeModelMesh(vfs, name);
	}

	long meshCount();

	@Nullable
	SoftSkinMesh mesh(long i);

	@NotNull
	List<@NotNull SoftSkinMesh> meshes();

	long attachmentCount();

	@Nullable
	MultiResolutionMesh attachment(String name);

	@NotNull
	Map<@NotNull String, @NotNull MultiResolutionMesh> attachments();

	long checksum();
}
