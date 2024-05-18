package dev.gothickit.zenkit.mdm;

import dev.gothickit.zenkit.mrm.MultiResolutionMesh;
import dev.gothickit.zenkit.ssm.SoftSkinMesh;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public record CachedModelMesh(
		@NotNull
		List<@NotNull SoftSkinMesh> meshes,

		@NotNull
		Map<@NotNull String, @NotNull MultiResolutionMesh> attachments,

		long checksum
) implements ModelMesh {
	@Override
	public long meshCount() {
		return meshes.size();
	}

	@Override
	public @Nullable SoftSkinMesh mesh(long i) {
		if (i >= meshes.size()) return null;
		return meshes.get((int) i);
	}

	@Override
	public long attachmentCount() {
		return attachments.size();
	}

	@Override
	public @Nullable MultiResolutionMesh attachment(String name) {
		return attachments.get(name);
	}

	@Override
	public @NotNull CachedModelMesh cache() {
		return this;
	}

	@Override
	public boolean isCached() {
		return true;
	}
}
