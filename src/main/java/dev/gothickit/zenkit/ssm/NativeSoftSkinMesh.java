package dev.gothickit.zenkit.ssm;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.LongByReference;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.NativeOrientedBoundingBox;
import dev.gothickit.zenkit.OrientedBoundingBox;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.mrm.MultiResolutionMesh;
import dev.gothickit.zenkit.mrm.NativeMultiResolutionMesh;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public final class NativeSoftSkinMesh implements NativeObject, SoftSkinMesh {
	private final Pointer handle;

	private NativeSoftSkinMesh(Pointer handle) {
		this.handle = handle;
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable NativeSoftSkinMesh fromNativeHandle(Pointer handle) {
		if (handle == null) return null;
		return new NativeSoftSkinMesh(handle);
	}

	@Override
	public long nodeCount() {
		return ZenKit.API.ZkSoftSkinMesh_getNodeCount(handle);
	}

	@Override
	public @NotNull MultiResolutionMesh mesh() {
		return NativeMultiResolutionMesh.fromNativeHandle(ZenKit.API.ZkSoftSkinMesh_getMesh(handle));
	}

	@Override
	public OrientedBoundingBox bbox(long node) {
		var obb = ZenKit.API.ZkSoftSkinMesh_getBbox(handle, node);
		if (obb == Pointer.NULL) return null;
		return NativeOrientedBoundingBox.fromNativeHandle(obb);
	}

	@Override
	public @NotNull List<OrientedBoundingBox> boundingBoxes() {
		var bboxes = new ArrayList<OrientedBoundingBox>();

		ZenKit.API.ZkSoftSkinMesh_enumerateBoundingBoxes(handle, (ctx, box) -> {
			bboxes.add(NativeOrientedBoundingBox.fromNativeHandle(box));
			return false;
		}, Pointer.NULL);

		return bboxes;
	}

	@Override
	public SoftSkinWeightEntry @NotNull [] weights(long node) {
		var count = ZenKit.API.ZkSoftSkinMesh_getWeightCount(handle, node);
		var weights = new SoftSkinWeightEntry[(int) count];

		for (int i = 0; i < count; i++) {
			weights[i] = ZenKit.API.ZkSoftSkinMesh_getWeight(handle, node, i);
		}

		return weights;
	}

	@Override
	public @NotNull List<SoftSkinWeightEntry[]> weights() {
		var weights = new ArrayList<SoftSkinWeightEntry[]>();
		var count = ZenKit.API.ZkSoftSkinMesh_getWeightTotal(handle);

		for (int i = 0; i < count; i++) {
			weights.add(weights(i));
		}

		return weights;
	}

	@Override
	public SoftSkinWedgeNormal @NotNull [] wedgeNormals() {
		var count = ZenKit.API.ZkSoftSkinMesh_getWedgeNormalCount(handle);
		var weights = new SoftSkinWedgeNormal[(int) count];

		for (int i = 0; i < count; i++) {
			weights[i] = ZenKit.API.ZkSoftSkinMesh_getWedgeNormal(handle, i);
		}

		return weights;
	}

	@Override
	public int[] nodes() {
		var count = new LongByReference();
		var ptr = ZenKit.API.ZkSoftSkinMesh_getNodes(handle, count);
		return ptr.getIntArray(0, (int) count.getValue());
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle;
	}

	@Override
	public @NotNull CachedSoftSkinMesh cache() {
		return new CachedSoftSkinMesh(
				mesh().cache(),
				boundingBoxes(),
				weights(),
				wedgeNormals(),
				nodes()
		);
	}

	@Override
	public boolean isCached() {
		return false;
	}
}
