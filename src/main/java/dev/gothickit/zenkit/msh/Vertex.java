package dev.gothickit.zenkit.msh;

import com.sun.jna.Structure;
import dev.gothickit.zenkit.Vec2f;
import dev.gothickit.zenkit.Vec3f;

@Structure.FieldOrder({"texture", "light", "normal"})
public class Vertex extends Structure {
	public Vec2f texture;
	public int light;
	public Vec3f normal;

	public static class ByValue extends Vertex implements Structure.ByValue {
	}
}
