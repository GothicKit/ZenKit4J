package dev.gothickit.zenkit.mrm;

import com.sun.jna.Structure;

@Structure.FieldOrder({"wedge0", "wedge1", "wedge2"})
public class MeshTriangle extends Structure {
	public short wedge0, wedge1, wedge2;

	public static class ByValue extends MeshTriangle implements Structure.ByValue {
	}

	public static class ByReference extends MeshTriangle implements Structure.ByValue {
	}
}
