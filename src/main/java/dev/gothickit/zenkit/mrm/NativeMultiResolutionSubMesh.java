package dev.gothickit.zenkit.mrm;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.mat.Material;
import dev.gothickit.zenkit.mat.NativeMaterial;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NativeMultiResolutionSubMesh implements NativeObject, MultiResolutionSubMesh {
	private final Pointer handle;

	private NativeMultiResolutionSubMesh(Pointer handle) {
		this.handle = handle;
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable NativeMultiResolutionSubMesh fromNativeHandle(Pointer handle) {
		if (handle == null) return null;
		return new NativeMultiResolutionSubMesh(handle);
	}

	@Override
	public @Nullable Material material() {
		return NativeMaterial.fromNativeHandle(ZenKit.API.ZkSubMesh_getMaterial(handle));
	}

	@Override
	public MeshTriangle @NotNull [] triangles() {
		var count = new IntByReference();
		var arr = ZenKit.API.ZkSubMesh_getTriangles(getNativeHandle(), count);
		if (arr == null || count.getValue() == 0) return new MeshTriangle[0];
		return (MeshTriangle[]) arr.toArray(count.getValue());
	}

	@Override
	public MeshWedge @NotNull [] wedges() {
		var count = ZenKit.API.ZkSubMesh_getWedgeCount(getNativeHandle());
		var weights = new MeshWedge[(int) count];

		for (int i = 0; i < count; i++) {
			weights[i] = ZenKit.API.ZkSubMesh_getWedge(getNativeHandle(), i);
		}

		return weights;
	}

	@Override
	public float @NotNull [] colors() {
		var count = new IntByReference();
		var arr = ZenKit.API.ZkSubMesh_getColors(getNativeHandle(), count);
		if (arr == null || count.getValue() == 0) return new float[0];
		return arr.getFloatArray(0, count.getValue());
	}

	@Override
	public short @NotNull [] trianglePlaneIndices() {
		var count = new IntByReference();
		var arr = ZenKit.API.ZkSubMesh_getTrianglePlaneIndices(getNativeHandle(), count);
		if (arr == null || count.getValue() == 0) return new short[0];
		return arr.getShortArray(0, count.getValue());
	}

	@Override
	public MeshPlane @NotNull [] trianglePlanes() {
		var count = ZenKit.API.ZkSubMesh_getTrianglePlaneCount(getNativeHandle());
		var weights = new MeshPlane[(int) count];

		for (int i = 0; i < count; i++) {
			weights[i] = ZenKit.API.ZkSubMesh_getTrianglePlane(getNativeHandle(), i);
		}

		return weights;
	}

	@Override
	public MeshTriangleEdge @NotNull [] triangleEdges() {
		var count = new IntByReference();
		var arr = ZenKit.API.ZkSubMesh_getTriangleEdges(getNativeHandle(), count);
		if (arr == null || count.getValue() == 0) return new MeshTriangleEdge[0];
		return (MeshTriangleEdge[]) arr.toArray(count.getValue());
	}

	@Override
	public MeshEdge @NotNull [] edges() {
		var count = new IntByReference();
		var arr = ZenKit.API.ZkSubMesh_getEdges(getNativeHandle(), count);
		if (arr == null || count.getValue() == 0) return new MeshEdge[0];
		return (MeshEdge[]) arr.toArray(count.getValue());
	}

	@Override
	public float @NotNull [] edgeScores() {
		var count = new IntByReference();
		var arr = ZenKit.API.ZkSubMesh_getEdgeScores(getNativeHandle(), count);
		if (arr == null || count.getValue() == 0) return new float[0];
		return arr.getFloatArray(0, count.getValue());
	}

	@Override
	public short @NotNull [] wedgeMap() {
		var count = new IntByReference();
		var arr = ZenKit.API.ZkSubMesh_getWedgeMap(getNativeHandle(), count);
		if (arr == null || count.getValue() == 0) return new short[0];
		return arr.getShortArray(0, count.getValue());
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle;
	}

	@Override
	public @NotNull CachedMultiResolutionSubMesh cache() {
		var material = material();
		return new CachedMultiResolutionSubMesh(
				material != null ? material.cache() : null,
				triangles(),
				wedges(),
				colors(),
				trianglePlaneIndices(),
				trianglePlanes(),
				triangleEdges(),
				edges(),
				edgeScores(),
				wedgeMap()
		);
	}

	@Override
	public boolean isCached() {
		return false;
	}
}
