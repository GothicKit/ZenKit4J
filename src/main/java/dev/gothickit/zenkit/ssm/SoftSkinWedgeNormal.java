package dev.gothickit.zenkit.ssm;

import com.sun.jna.Structure;
import dev.gothickit.zenkit.Vec3f;

@Structure.FieldOrder({"normal", "index"})
public class SoftSkinWedgeNormal extends Structure {
	public Vec3f normal;
	public int index;
}
