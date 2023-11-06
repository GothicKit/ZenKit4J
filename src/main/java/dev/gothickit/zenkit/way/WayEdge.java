package dev.gothickit.zenkit.way;

import com.sun.jna.Structure;

@Structure.FieldOrder({"a", "b"})
public class WayEdge extends Structure {
	public int a, b;
}
