package dev.gothickit.zenkit;

import com.sun.jna.Structure;
import org.jetbrains.annotations.NotNull;

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
		if (!(o instanceof Color color)) return false;
		return r == color.r && g == color.g && b == color.b && a == color.a;
	}

	public static final class ByValue extends Color implements Structure.ByValue {
		public ByValue() {
		}

		public ByValue(@NotNull Color other) {
			super(other.r, other.g, other.b, other.a);
		}
	}

	public static final class ByReference extends Color implements Structure.ByReference {
	}
}
