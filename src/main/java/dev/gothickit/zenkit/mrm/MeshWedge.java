package dev.gothickit.zenkit.mrm;

import com.sun.jna.Structure;
import dev.gothickit.zenkit.Vec2f;
import dev.gothickit.zenkit.Vec3f;

@Structure.FieldOrder({"normal", "texture", "index"})
public class MeshWedge extends Structure {
	public Vec3f normal;
	public Vec2f texture;
	public short index;

	public static final class ByValue extends MeshWedge implements Structure.ByValue {
	}

	public static final class ByReference extends MeshWedge implements Structure.ByValue {
	}
}
