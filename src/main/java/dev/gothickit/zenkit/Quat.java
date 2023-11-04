package dev.gothickit.zenkit;

import com.sun.jna.Structure;

import java.util.List;

public class Quat extends Structure {
	public float x = 0;
	public float y = 0;
	public float z = 0;
	public float w = 0;

	@Override
	protected List<String> getFieldOrder() {
		return List.of("x", "y", "z", "w");
	}

	public static class ByValue extends Quat implements Structure.ByValue {
	}

	public static class ByReference extends Quat implements Structure.ByReference {
	}
}
