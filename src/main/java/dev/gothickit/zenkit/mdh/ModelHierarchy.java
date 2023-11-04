package dev.gothickit.zenkit.mdh;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.AxisAlignedBoundingBox;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.Vec3f;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.NotNull;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ModelHierarchy {
	private final Handle handle;

	public ModelHierarchy(String path) {
		var handle = new Handle(ZenKit.API.ZkModelHierarchy_loadPath(path), ZenKit.API::ZkModelHierarchy_del);
		if (handle.isNull()) throw new RuntimeException("Failed to load model hierarchy");
		ZenKit.CLEANER.register(this, handle);
		this.handle = handle;
	}

	public ModelHierarchy(@NotNull Read buf) {
		var handle = new Handle(ZenKit.API.ZkModelHierarchy_load(buf.getHandle()), ZenKit.API::ZkModelHierarchy_del);
		if (handle.isNull()) throw new RuntimeException("Failed to load model hierarchy");
		ZenKit.CLEANER.register(this, handle);
		this.handle = handle;
	}

	public ModelHierarchy(@NotNull Vfs vfs, String name) {
		var handle = new Handle(
				ZenKit.API.ZkModelHierarchy_loadVfs(vfs.getHandle(), name),
				ZenKit.API::ZkModelHierarchy_del
		);

		if (handle.isNull()) {
			throw new RuntimeException("Failed to load model hierarchy");
		}

		ZenKit.CLEANER.register(this, handle);
		this.handle = handle;
	}

	public Pointer getHandle() {
		return handle.get();
	}

	public long getNodeCount() {
		return ZenKit.API.ZkModelHierarchy_getNodeCount(this.getHandle());
	}

	public ModelHierarchyNode getNode(long i) {
		return ZenKit.API.ZkModelHierarchy_getNode(this.getHandle(), i);
	}

	public AxisAlignedBoundingBox getBbox() {
		return ZenKit.API.ZkModelHierarchy_getBbox(this.getHandle());
	}

	public AxisAlignedBoundingBox getCollisionBbox() {
		return ZenKit.API.ZkModelHierarchy_getCollisionBbox(this.getHandle());
	}

	public Vec3f getRootTranslation() {
		return ZenKit.API.ZkModelHierarchy_getRootTranslation(this.getHandle());
	}

	public long getChecksum() {
		return ZenKit.API.ZkModelHierarchy_getChecksum(this.getHandle());
	}

	public Instant getSourceDate() {
		return ZenKit.API.ZkModelHierarchy_getSourceDate(this.getHandle()).toInstant();
	}

	public String getSourcePath() {
		return ZenKit.API.ZkModelHierarchy_getSourcePath(this.getHandle());
	}

	public List<ModelHierarchyNode> getNodes() {
		var nodes = new ArrayList<ModelHierarchyNode>();

		ZenKit.API.ZkModelHierarchy_enumerateNodes(this.getHandle(), (ctx, node) -> {
			nodes.add(node);
			return false;
		}, Pointer.NULL);

		return nodes;
	}
}
