package dev.gothickit.zenkit.bsp;

import com.sun.jna.Structure;
import dev.gothickit.zenkit.AxisAlignedBoundingBox;
import dev.gothickit.zenkit.Vec4f;

@Structure.FieldOrder({"plane", "bbox", "polygonIndex", "polygonCount", "frontIndex", "backIndex", "parentIndex"})
public class BspNode extends Structure {
	public Vec4f plane;
	public AxisAlignedBoundingBox bbox;
	public int polygonIndex;
	public int polygonCount;
	public int frontIndex;
	public int backIndex;
	public int parentIndex;

	public static class ByValue extends BspNode implements Structure.ByValue {
	}
}
