package dev.gothickit.zenkit.mrm;

import com.sun.jna.Structure;
import dev.gothickit.zenkit.Vec3f;

@Structure.FieldOrder({"distance", "normal"})
public class MeshPlane extends Structure {
	public float distance;
	public Vec3f normal;

	public static class ByValue extends MeshPlane implements Structure.ByValue {
	}

	public static class ByReference extends MeshPlane implements Structure.ByValue {
	}
}
