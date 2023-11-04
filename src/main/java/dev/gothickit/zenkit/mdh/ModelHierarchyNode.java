package dev.gothickit.zenkit.mdh;

import com.sun.jna.Structure;
import dev.gothickit.zenkit.Mat4x4;

import java.util.List;

public class ModelHierarchyNode extends Structure {
	public short parentIndex;
	public String name;
	public Mat4x4 transform;

	@Override
	protected List<String> getFieldOrder() {
		return List.of("parentIndex", "name", "transform");
	}

	public static class ByValue extends ModelHierarchyNode implements Structure.ByValue {
	}

	public static class ByReference extends ModelHierarchyNode implements Structure.ByReference {
	}
}
