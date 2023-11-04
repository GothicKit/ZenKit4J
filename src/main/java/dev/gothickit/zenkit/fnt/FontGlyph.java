package dev.gothickit.zenkit.fnt;

import com.sun.jna.Structure;
import dev.gothickit.zenkit.Vec2f;

import java.util.List;

public class FontGlyph extends Structure {
	public byte width;
	public Vec2f topLeft;
	public Vec2f bottomRight;

	public FontGlyph() {
		width = 0;
		topLeft = new Vec2f();
		bottomRight = new Vec2f();
	}

	public FontGlyph(byte width, Vec2f topLeft, Vec2f bottomRight) {
		this.width = width;
		this.topLeft = topLeft;
		this.bottomRight = bottomRight;
	}

	@Override
	protected List<String> getFieldOrder() {
		return List.of("width", "topLeft", "bottomRight");
	}

	public static class ByValue extends FontGlyph implements Structure.ByValue {
	}

	public static class ByReference extends FontGlyph implements Structure.ByReference {
	}
}
