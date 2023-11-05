package dev.gothickit.zenkit.mrm;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.mat.Material;

public class MultiResolutionSubMesh {
	private final Pointer handle;

	public MultiResolutionSubMesh(Pointer handle) {
		this.handle = handle;
	}

	public Pointer getHandle() {
		return handle;
	}

	public Material getMaterial() {
		return new Material(ZenKit.API.ZkSubMesh_getMaterial(handle));
	}

	public MeshTriangle[] getTriangles() {
		var count = new IntByReference();
		var arr = ZenKit.API.ZkSubMesh_getTriangles(this.getHandle(), count);
		if (arr == null || count.getValue() == 0) return new MeshTriangle[0];
		return (MeshTriangle[]) arr.toArray(count.getValue());
	}

	public MeshWedge[] getWedges() {
		var count = new IntByReference();
		var arr = ZenKit.API.ZkSubMesh_getWedges(this.getHandle(), count);
		if (arr == null || count.getValue() == 0) return new MeshWedge[0];
		return (MeshWedge[]) arr.toArray(count.getValue());
	}

	public float[] getColors() {
		var count = new IntByReference();
		var arr = ZenKit.API.ZkSubMesh_getColors(this.getHandle(), count);
		if (arr == null || count.getValue() == 0) return new float[0];
		return arr.getFloatArray(0, count.getValue());
	}

	public short[] getTrianglePlaneIndices() {
		var count = new IntByReference();
		var arr = ZenKit.API.ZkSubMesh_getTrianglePlaneIndices(this.getHandle(), count);
		if (arr == null || count.getValue() == 0) return new short[0];
		return arr.getShortArray(0, count.getValue());
	}

	public MeshPlane[] getTrianglePlanes() {
		var count = new IntByReference();
		var arr = ZenKit.API.ZkSubMesh_getTrianglePlanes(this.getHandle(), count);
		if (arr == null || count.getValue() == 0) return new MeshPlane[0];
		return (MeshPlane[]) arr.toArray(count.getValue());
	}

	public MeshTriangleEdge[] getTriangleEdges() {
		var count = new IntByReference();
		var arr = ZenKit.API.ZkSubMesh_getTriangleEdges(this.getHandle(), count);
		if (arr == null || count.getValue() == 0) return new MeshTriangleEdge[0];
		return (MeshTriangleEdge[]) arr.toArray(count.getValue());
	}

	public MeshEdge[] getEdges() {
		var count = new IntByReference();
		var arr = ZenKit.API.ZkSubMesh_getEdges(this.getHandle(), count);
		if (arr == null || count.getValue() == 0) return new MeshEdge[0];
		return (MeshEdge[]) arr.toArray(count.getValue());
	}

	public float[] getEdgeScores() {
		var count = new IntByReference();
		var arr = ZenKit.API.ZkSubMesh_getEdgeScores(this.getHandle(), count);
		if (arr == null || count.getValue() == 0) return new float[0];
		return arr.getFloatArray(0, count.getValue());
	}

	public short[] getWedgeMap() {
		var count = new IntByReference();
		var arr = ZenKit.API.ZkSubMesh_getWedgeMap(this.getHandle(), count);
		if (arr == null || count.getValue() == 0) return new short[0];
		return arr.getShortArray(0, count.getValue());
	}
}
