package dev.gothickit.zenkit.mrm;

import com.sun.jna.Structure;

@Structure.FieldOrder({"edge0", "edge1", "edge2"})
public class MeshTriangleEdge extends Structure {
	public short edge0, edge1, edge2;

	public static final class ByValue extends MeshTriangleEdge implements Structure.ByValue {
	}

	public static final class ByReference extends MeshTriangleEdge implements Structure.ByValue {
	}
}
