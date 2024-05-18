package dev.gothickit.zenkit.ani;

import dev.gothickit.zenkit.AxisAlignedBoundingBox;
import dev.gothickit.zenkit.CacheableObject;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.ResourceIOException;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Calendar;
import java.util.List;

public interface ModelAnimation extends CacheableObject<CachedModelAnimation> {
	@Contract("_ -> new")
	static @NotNull ModelAnimation load(@NotNull String path) throws ResourceIOException {
		return new NativeModelAnimation(path);
	}

	@Contract("_ -> new")
	static @NotNull ModelAnimation load(@NotNull Read buf) throws ResourceIOException {
		return new NativeModelAnimation(buf);
	}

	@Contract("_, _ -> new")
	static @NotNull ModelAnimation load(@NotNull Vfs vfs, @NotNull String name) throws ResourceIOException {
		return new NativeModelAnimation(vfs, name);
	}

	@NotNull
	String name();

	@NotNull
	String next();

	int layer();

	int frameCount();

	int nodeCount();

	float fps();

	float fpsSource();

	@NotNull
	AxisAlignedBoundingBox bbox();

	long checksum();

	@NotNull
	String sourcePath();

	@NotNull
	Calendar sourceDate();

	@NotNull
	String sourceScript();

	long sampleCount();

	@Nullable
	AnimationSample sample(long i);

	@NotNull
	List<@NotNull AnimationSample> samples();

	int @NotNull [] nodeIndices();
}
