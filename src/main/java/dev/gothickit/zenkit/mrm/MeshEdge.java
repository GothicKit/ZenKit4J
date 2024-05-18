package dev.gothickit.zenkit.mrm;

import com.sun.jna.Structure;

@Structure.FieldOrder({"edge0", "edge1"})
public class MeshEdge extends Structure {
	public short edge0 = 0, edge1 = 0;

	public static final class ByValue extends MeshEdge implements Structure.ByValue {
	}

	public static final class ByReference extends MeshEdge implements Structure.ByValue {
	}
}
