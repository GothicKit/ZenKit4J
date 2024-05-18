package dev.gothickit.zenkit;

import com.sun.jna.Structure;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AxisAlignedBoundingBox extends Structure {
	public Vec3f min;
	public Vec3f max;

	public AxisAlignedBoundingBox(Vec3f min, Vec3f max) {
		this.min = min;
		this.max = max;
	}

	public AxisAlignedBoundingBox() {
		this.min = new Vec3f();
		this.max = new Vec3f();
	}

	@Override
	protected List<String> getFieldOrder() {
		return List.of("min", "max");
	}

	public static class ByValue extends AxisAlignedBoundingBox implements Structure.ByValue {
		public ByValue(@NotNull AxisAlignedBoundingBox bbox) {
			super(bbox.min, bbox.max);
		}

		public ByValue() {
		}
	}

	public static class ByReference extends AxisAlignedBoundingBox implements Structure.ByReference {
	}
}
