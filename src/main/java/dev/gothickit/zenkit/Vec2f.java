package dev.gothickit.zenkit;

import com.sun.jna.Structure;

@Structure.FieldOrder({"x", "y"})
public final class Vec2f extends Structure implements Structure.ByValue {
	public float x;

	public float y;

	public Vec2f() {
		this.x = 0;
		this.y = 0;
	}

	public Vec2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
}
