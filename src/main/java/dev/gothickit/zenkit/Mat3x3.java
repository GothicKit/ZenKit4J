package dev.gothickit.zenkit;

import com.sun.jna.Structure;
import org.jetbrains.annotations.NotNull;

/**
 * Column-major!
 */
@Structure.FieldOrder({"m00", "m01", "m02", "m10", "m11", "m12", "m20", "m21", "m22"})
public class Mat3x3 extends Structure {
	public float m00, m01, m02, m10, m11, m12, m20, m21, m22;

	public Mat3x3() {
	}

	public Mat3x3(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
		this.m00 = m00;
		this.m01 = m01;
		this.m02 = m02;
		this.m10 = m10;
		this.m11 = m11;
		this.m12 = m12;
		this.m20 = m20;
		this.m21 = m21;
		this.m22 = m22;
	}

	public static class ByValue extends Mat3x3 implements Structure.ByValue {
		public ByValue() {
		}

		public ByValue(@NotNull Mat3x3 m) {
			super(m.m00, m.m01, m.m02, m.m10, m.m11, m.m12, m.m20, m.m21, m.m22);
		}
	}
}
