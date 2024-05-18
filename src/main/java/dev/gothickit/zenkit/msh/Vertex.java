package dev.gothickit.zenkit.msh;

import com.sun.jna.Structure;
import dev.gothickit.zenkit.Vec2f;
import dev.gothickit.zenkit.Vec3f;

@Structure.FieldOrder({"texture", "light", "normal"})
public class Vertex extends Structure implements Structure.ByValue {
	public Vec2f texture;
	public int light;
	public Vec3f normal;
}
