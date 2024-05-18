package dev.gothickit.zenkit.fnt;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import dev.gothickit.zenkit.Vec2f;

@Structure.FieldOrder({"width", "topLeft", "bottomRight"})
public final class FontGlyph extends Structure implements Structure.ByValue {
	public byte width = 0;
	public Vec2f topLeft = new Vec2f();
	public Vec2f bottomRight = new Vec2f();

	public FontGlyph() {
	}

	public FontGlyph(Pointer p) {
		super(p);
		this.autoRead();
	}
}
