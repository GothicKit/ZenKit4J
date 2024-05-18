package dev.gothickit.zenkit.mrm;

import com.sun.jna.Structure;
import dev.gothickit.zenkit.Vec3f;

@Structure.FieldOrder({"distance", "normal"})
public class MeshPlane extends Structure {
	public float distance = 0;
	public Vec3f normal = new Vec3f();

	public static final class ByValue extends MeshPlane implements Structure.ByValue {
	}

	public static final class ByReference extends MeshPlane implements Structure.ByValue {
	}
}
