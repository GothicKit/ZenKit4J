package dev.gothickit.zenkit.ssm;

import com.sun.jna.Structure;
import dev.gothickit.zenkit.Vec3f;

@Structure.FieldOrder({"weight", "position", "nodeIndex"})
public class SoftSkinWeightEntry extends Structure {
	public float weight;
	public Vec3f position;
	public byte nodeIndex;
}
