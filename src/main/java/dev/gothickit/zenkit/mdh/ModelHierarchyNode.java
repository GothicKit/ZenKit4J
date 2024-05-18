package dev.gothickit.zenkit.mdh;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import dev.gothickit.zenkit.Mat4x4;

@Structure.FieldOrder({"parentIndex", "name", "transform"})
public final class ModelHierarchyNode extends Structure implements Structure.ByValue {
	public short parentIndex = 0;
	public String name = "";
	public Mat4x4 transform = new Mat4x4();

	public ModelHierarchyNode(Pointer p) {
		super(p);
		this.autoRead();
	}

	public ModelHierarchyNode() {
	}
}
