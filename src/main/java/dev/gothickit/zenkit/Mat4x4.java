package dev.gothickit.zenkit;

import com.sun.jna.Structure;

/**
 * Column-major!
 */
@Structure.FieldOrder({"m00", "m01", "m02", "m03", "m10", "m11", "m12", "m13", "m20", "m21", "m22", "m23", "m30", "m31", "m32", "m33"})
public class Mat4x4 extends Structure {
	public float m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, m30, m31, m32, m33;

	public Mat4x4() {
	}

	public Mat4x4(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33) {
		this.m00 = m00;
		this.m01 = m01;
		this.m02 = m02;
		this.m03 = m03;
		this.m10 = m10;
		this.m11 = m11;
		this.m12 = m12;
		this.m13 = m13;
		this.m20 = m20;
		this.m21 = m21;
		this.m22 = m22;
		this.m23 = m23;
		this.m30 = m30;
		this.m31 = m31;
		this.m32 = m32;
		this.m33 = m33;
	}

	public static class ByValue extends Mat4x4 implements Structure.ByValue {
		public ByValue() {
		}

		public ByValue(Mat4x4 p) {
			super(
					p.m00, p.m01, p.m02, p.m03, p.m10, p.m11, p.m12, p.m13, p.m20, p.m21, p.m22, p.m23, p.m30, p.m31, p.m32, p.m33

			);
		}
	}
}
