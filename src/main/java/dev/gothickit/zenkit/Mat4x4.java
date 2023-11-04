package dev.gothickit.zenkit;

import com.sun.jna.Structure;

import java.util.List;

/**
 * Column-major!
 */
public class Mat4x4 extends Structure {
	public float m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, m30, m31, m32, m33;

	@Override
	protected List<String> getFieldOrder() {
		return List.of(
				"m00",
				"m01",
				"m02",
				"m03",
				"m10",
				"m11",
				"m12",
				"m13",
				"m20",
				"m21",
				"m22",
				"m23",
				"m30",
				"m31",
				"m32",
				"m33"
		);
	}
}
