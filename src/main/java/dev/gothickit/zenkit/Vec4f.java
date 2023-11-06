package dev.gothickit.zenkit;

import com.sun.jna.Structure;

import java.util.List;

@Structure.FieldOrder({"x", "y", "z", "w"})
public class Vec4f extends Structure {
	public float x;

	public float y;
	public float z;
	public float w;

	public Vec4f() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
		this.w = 0;
	}

	public Vec4f(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	public static class ByValue extends Vec4f implements Structure.ByValue {
	}

	public static class ByReference extends Vec4f implements Structure.ByReference {
	}
}
