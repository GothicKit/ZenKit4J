package dev.gothickit.zenkit.bsp;

import com.sun.jna.Structure;
import dev.gothickit.zenkit.AxisAlignedBoundingBox;
import dev.gothickit.zenkit.Vec4f;

@Structure.FieldOrder({"plane", "bbox", "polygonIndex", "polygonCount", "frontIndex", "backIndex", "parentIndex"})
public final class BinarySpacePartitionNode extends Structure implements Structure.ByValue {
	public Vec4f plane = new Vec4f();
	public AxisAlignedBoundingBox bbox = new AxisAlignedBoundingBox();
	public int polygonIndex = 0;
	public int polygonCount = 0;
	public int frontIndex = -1;
	public int backIndex = -1;
	public int parentIndex = -1;
}
