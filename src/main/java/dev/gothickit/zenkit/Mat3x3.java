package dev.gothickit.zenkit;

import com.sun.jna.Structure;

/**
 * Column-major!
 */
@Structure.FieldOrder({"m00", "m01", "m02", "m10", "m11", "m12", "m20", "m21", "m22"})
public class Mat3x3 extends Structure {
	public float m00, m01, m02, m10, m11, m12, m20, m21, m22;

	public static class ByValue extends Mat3x3 implements Structure.ByValue {
	}
}
