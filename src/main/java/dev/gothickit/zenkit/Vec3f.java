package dev.gothickit.zenkit;

import com.sun.jna.Structure;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Vec3f extends Structure implements Structure.ByValue {
	public float x;
	public float y;
	public float z;

	public Vec3f() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}

	public Vec3f(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	protected List<String> getFieldOrder() {
		return List.of("x", "y", "z");
	}
}
