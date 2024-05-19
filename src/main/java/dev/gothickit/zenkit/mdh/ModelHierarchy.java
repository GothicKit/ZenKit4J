package dev.gothickit.zenkit.mdh;

import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Calendar;
import java.util.List;

public interface ModelHierarchy extends CacheableObject<CachedModelHierarchy> {
	@Contract("_ -> new")
	static @NotNull ModelHierarchy load(@NotNull String path) throws ResourceIOException {
		return new NativeModelHierarchy(path);
	}

	@Contract("_ -> new")
	static @NotNull ModelHierarchy load(@NotNull Read buf) throws ResourceIOException {
		return new NativeModelHierarchy(Read.adapt(buf));
	}

	@Contract("_, _ -> new")
	static @NotNull ModelHierarchy load(@NotNull Vfs vfs, @NotNull String name) throws ResourceIOException {
		return new NativeModelHierarchy(vfs, name);
	}

	long nodeCount();

	@Nullable
	ModelHierarchyNode node(long i);

	@NotNull
	AxisAlignedBoundingBox bbox();

	@NotNull
	AxisAlignedBoundingBox collisionBbox();

	@NotNull
	Vec3f rootTranslation();

	long checksum();

	@NotNull
	Calendar sourceDate();

	@NotNull
	String sourcePath();

	@NotNull
	List<@NotNull ModelHierarchyNode> nodes();
}
