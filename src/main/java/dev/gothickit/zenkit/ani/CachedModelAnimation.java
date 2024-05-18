package dev.gothickit.zenkit.ani;

import dev.gothickit.zenkit.AxisAlignedBoundingBox;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Calendar;
import java.util.List;

public record CachedModelAnimation(
		@NotNull
		String name,

		@NotNull
		String next,

		int layer,

		int frameCount,

		int nodeCount,

		float fps,

		float fpsSource,

		@NotNull
		AxisAlignedBoundingBox bbox,

		long checksum,

		@NotNull
		String sourcePath,

		@NotNull
		Calendar sourceDate,

		@NotNull
		String sourceScript,

		@NotNull
		List<@NotNull AnimationSample> samples,

		int @NotNull [] nodeIndices
) implements ModelAnimation {
	@Override
	public long sampleCount() {
		return samples.size();
	}

	@Override
	public @Nullable AnimationSample sample(long i) {
		if (i >= samples.size()) {
			return null;
		}

		return samples.get((int) i);
	}

	@Override
	public @NotNull CachedModelAnimation cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
