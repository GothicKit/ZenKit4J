package dev.gothickit.zenkit.ssm;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import dev.gothickit.zenkit.OrientedBoundingBox;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.mrm.MultiResolutionMesh;

import java.util.ArrayList;
import java.util.List;

public class SoftSkinMesh {
	private final Pointer handle;

	public SoftSkinMesh(Pointer handle) {
		this.handle = handle;
	}

	public Pointer getHandle() {
		return handle;
	}

	public long getNodeCount() {
		return ZenKit.API.ZkSoftSkinMesh_getNodeCount(handle);
	}

	public MultiResolutionMesh getMesh() {
		return new MultiResolutionMesh(ZenKit.API.ZkSoftSkinMesh_getMesh(handle));
	}

	public OrientedBoundingBox getBbox(long node) {
		var obb = ZenKit.API.ZkSoftSkinMesh_getBbox(handle, node);
		if (obb == Pointer.NULL) return null;
		return new OrientedBoundingBox(obb);
	}

	public List<OrientedBoundingBox> getBoundingBoxes() {
		var bboxes = new ArrayList<OrientedBoundingBox>();

		ZenKit.API.ZkSoftSkinMesh_enumerateBoundingBoxes(handle, (ctx, box) -> {
			bboxes.add(new OrientedBoundingBox(box));
			return false;
		}, Pointer.NULL);

		return bboxes;
	}

	public SoftSkinWeightEntry[] getWeights(long node) {
		var count = ZenKit.API.ZkSoftSkinMesh_getWeightCount(handle, node);
		var weights = new SoftSkinWeightEntry[(int) count];

		for (int i = 0; i < count; i++) {
			weights[i] = ZenKit.API.ZkSoftSkinMesh_getWeight(handle, node, i);
		}

		return weights;
	}

	public List<SoftSkinWeightEntry[]> getWeights() {
		var weights = new ArrayList<SoftSkinWeightEntry[]>();
		var count = ZenKit.API.ZkSoftSkinMesh_getWeightTotal(getHandle());

		for (int i = 0; i < count; i++) {
			weights.add(getWeights(i));
		}

		return weights;
	}

	public SoftSkinWedgeNormal[] getWedgeNormals() {
		var count = ZenKit.API.ZkSoftSkinMesh_getWedgeNormalCount(handle);
		var weights = new SoftSkinWedgeNormal[(int) count];

		for (int i = 0; i < count; i++) {
			weights[i] = ZenKit.API.ZkSoftSkinMesh_getWedgeNormal(handle, i);
		}

		return weights;
	}

	public int[] getNodes() {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkSoftSkinMesh_getNodes(handle, count);
		return ptr.getIntArray(0, count.getValue());
	}
}
