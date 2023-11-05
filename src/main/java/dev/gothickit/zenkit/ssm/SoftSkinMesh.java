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
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkSoftSkinMesh_getWeights(handle, node, count);
		if (ptr == null || count.getValue() == 0) return new SoftSkinWeightEntry[0];
		return (SoftSkinWeightEntry[]) ptr.toArray(count.getValue());
	}

	public List<SoftSkinWeightEntry[]> getWeights() {
		var weights = new ArrayList<SoftSkinWeightEntry[]>();

		ZenKit.API.ZkSoftSkinMesh_enumerateWeights(handle, (ctx, entry, count) -> {
			weights.add((SoftSkinWeightEntry[]) entry.toArray((int) count));
			return false;
		}, Pointer.NULL);

		return weights;
	}

	public SoftSkinWedgeNormal[] getWedgeNormals() {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkSoftSkinMesh_getWedgeNormals(handle, count);
		if (ptr == null || count.getValue() == 0) return new SoftSkinWedgeNormal[0];
		return (SoftSkinWedgeNormal[]) ptr.toArray(count.getValue());
	}

	public int[] getNodes() {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkSoftSkinMesh_getNodes(handle, count);
		return ptr.getIntArray(0, count.getValue());
	}
}
