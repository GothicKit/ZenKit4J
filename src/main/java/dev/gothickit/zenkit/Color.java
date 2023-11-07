package dev.gothickit.zenkit;

import com.sun.jna.Structure;

@Structure.FieldOrder({"r", "g", "b", "a"})
public class Color extends Structure {
	public byte r = 0, g = 0, b = 0, a = 0;

	public Color() {
	}

	public Color(int r, int g, int b, int a) {
		this.r = (byte) r;
		this.g = (byte) g;
		this.b = (byte) b;
		this.a = (byte) a;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Color color = (Color) o;
		return r == color.r && g == color.g && b == color.b && a == color.a;
	}

	public static class ByValue extends Color implements Structure.ByValue {
	}

	public static class ByReference extends Color implements Structure.ByReference {
	}
}
