package dev.gothickit.zenkit.mrm;

import com.sun.jna.Structure;

@Structure.FieldOrder({"edge0", "edge1"})
public class MeshEdge extends Structure {
	public short edge0, edge1;

	public static class ByValue extends MeshEdge implements Structure.ByValue {
	}

	public static class ByReference extends MeshEdge implements Structure.ByValue {
	}
}
