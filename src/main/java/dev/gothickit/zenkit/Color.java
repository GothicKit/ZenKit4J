package dev.gothickit.zenkit;

import com.sun.jna.Structure;

import java.util.List;

public class Color extends Structure {
	public byte r = 0, g = 0, b = 0, a = 0;

	@Override
	protected List<String> getFieldOrder() {
		return List.of("r", "g", "b", "a");
	}

	public static class ByValue extends Color implements Structure.ByValue {
	}

	public static class ByReference extends Color implements Structure.ByReference {
	}
}
