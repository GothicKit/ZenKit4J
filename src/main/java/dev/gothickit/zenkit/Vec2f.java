package dev.gothickit.zenkit;

import com.sun.jna.Structure;

import java.util.List;

public class Vec2f extends Structure {
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

	@Override
	protected List<String> getFieldOrder() {
		return List.of("x", "y");
	}
}
