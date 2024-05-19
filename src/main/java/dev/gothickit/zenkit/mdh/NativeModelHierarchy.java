package dev.gothickit.zenkit.mdh;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class NativeModelHierarchy implements NativeObject, ModelHierarchy {
	private final Handle handle;

	NativeModelHierarchy(@NotNull String path) throws ResourceIOException {
		var handle = new Handle(ZenKit.API.ZkModelHierarchy_loadPath(path), ZenKit.API::ZkModelHierarchy_del);

		if (handle.isNull()) {
			throw new ResourceIOException(ModelHierarchy.class, ResourceIOSource.DISK, path);
		}

		ZenKit.CLEANER.register(this, handle);
		this.handle = handle;
	}

	NativeModelHierarchy(@NotNull NativeRead buf) throws ResourceIOException {
		var handle = new Handle(ZenKit.API.ZkModelHierarchy_load(buf.getNativeHandle()), ZenKit.API::ZkModelHierarchy_del);

		if (handle.isNull()) {
			throw new ResourceIOException(ModelHierarchy.class, ResourceIOSource.STREAM, buf.toString());
		}

		ZenKit.CLEANER.register(this, handle);
		this.handle = handle;
	}

	NativeModelHierarchy(@NotNull Vfs vfs, String name) throws ResourceIOException {
		var handle = new Handle(
				ZenKit.API.ZkModelHierarchy_loadVfs(vfs.getNativeHandle(), name),
				ZenKit.API::ZkModelHierarchy_del
		);

		if (handle.isNull()) {
			throw new ResourceIOException(ModelHierarchy.class, ResourceIOSource.VFS, name);
		}

		ZenKit.CLEANER.register(this, handle);
		this.handle = handle;
	}

	private NativeModelHierarchy(Pointer handle) {
		this.handle = new Handle(handle, (o) -> {
		});
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable NativeModelHierarchy fromNativeHandle(Pointer handle) {
		if (handle == null) return null;
		return new NativeModelHierarchy(handle);
	}

	@Override
	public long nodeCount() {
		return ZenKit.API.ZkModelHierarchy_getNodeCount(getNativeHandle());
	}

	@Override
	public ModelHierarchyNode node(long i) {
		return ZenKit.API.ZkModelHierarchy_getNode(getNativeHandle(), i);
	}

	@Override
	public @NotNull AxisAlignedBoundingBox bbox() {
		return ZenKit.API.ZkModelHierarchy_getBbox(getNativeHandle());
	}

	@Override
	public @NotNull AxisAlignedBoundingBox collisionBbox() {
		return ZenKit.API.ZkModelHierarchy_getCollisionBbox(getNativeHandle());
	}

	@Override
	public @NotNull Vec3f rootTranslation() {
		return ZenKit.API.ZkModelHierarchy_getRootTranslation(getNativeHandle());
	}

	@Override
	public long checksum() {
		return ZenKit.API.ZkModelHierarchy_getChecksum(getNativeHandle());
	}

	@Override
	public @NotNull Calendar sourceDate() {
		return ZenKit.API.ZkModelHierarchy_getSourceDate(getNativeHandle()).toCalendar();
	}

	@Override
	public @NotNull String sourcePath() {
		return ZenKit.API.ZkModelHierarchy_getSourcePath(getNativeHandle());
	}

	@Override
	public @NotNull List<ModelHierarchyNode> nodes() {
		var nodes = new ArrayList<ModelHierarchyNode>();

		ZenKit.API.ZkModelHierarchy_enumerateNodes(getNativeHandle(), (ctx, node) -> {
			nodes.add(new ModelHierarchyNode(node));
			return false;
		}, Pointer.NULL);

		return nodes;
	}

	@NotNull
	@Override
	public CachedModelHierarchy cache() {
		return new CachedModelHierarchy(
				bbox(),
				collisionBbox(),
				rootTranslation(),
				checksum(),
				sourceDate(),
				sourcePath(),
				nodes()
		);
	}

	@Override
	public boolean isCached() {
		return false;
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle.get();
	}
}
