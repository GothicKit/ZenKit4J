package dev.gothickit.zenkit.fnt;

import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
import dev.gothickit.zenkit.ResourceIOException;
import dev.gothickit.zenkit.Util;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FontTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void loadG1() throws ResourceIOException {
		var fnt = Font.load(Util.getResource("G1/FONT_OLD_10_WHITE_HI.FNT"));

		var fntGlyphs = fnt.glyphs();
		assertEquals(256, fntGlyphs.size());

		assertEquals("FONT_OLD_10_WHITE_HI.TGA", fnt.name());
		assertEquals(17, fnt.height());
		assertEquals(256, fnt.glyphCount());

		var glyph = fnt.glyph(0);
		assertEquals(0, glyph.width);
		assertEquals(0, glyph.topLeft.x);
		assertEquals(0, glyph.topLeft.y);
		assertEquals(0, glyph.bottomRight.x);
		assertEquals(0, glyph.bottomRight.y);

		glyph = fntGlyphs.get(127);
		assertEquals(8, glyph.width);
		assertEquals(0.3984375f, glyph.topLeft.x);
		assertEquals(0.23828125f, glyph.topLeft.y);
		assertEquals(0.412109375f, glyph.bottomRight.x);
		assertEquals(0.30859375f, glyph.bottomRight.y);

		glyph = fnt.glyph(255);
		assertEquals(9, glyph.width);
		assertEquals(0.95703125f, glyph.topLeft.x);
		assertEquals(0.55078125f, glyph.topLeft.y);
		assertEquals(0.97265625f, glyph.bottomRight.x);
		assertEquals(0.62109375f, glyph.bottomRight.y);

		// Caching
		fnt.cache();
	}

	@Test
	void loadG2() throws ResourceIOException {
		var fnt = Font.load(Util.getResource("G2/FONT_OLD_10_WHITE_HI.FNT"));

		var fntGlyphs = fnt.glyphs();
		assertEquals(256, fntGlyphs.size());

		assertEquals("FONT_OLD_10_WHITE_HI.TGA", fnt.name());
		assertEquals(18, fnt.height());
		assertEquals(256, fnt.glyphCount());

		var glyph = fnt.glyph(0);
		assertEquals(0, glyph.width);
		assertEquals(0, glyph.topLeft.x);
		assertEquals(0, glyph.topLeft.y);
		assertEquals(0, glyph.bottomRight.x);
		assertEquals(0, glyph.bottomRight.y);

		glyph = fntGlyphs.get(127);
		assertEquals(8, glyph.width);
		assertEquals(0.3984375f, glyph.topLeft.x);
		assertEquals(0.23828125f, glyph.topLeft.y);
		assertEquals(0.412109375f, glyph.bottomRight.x);
		assertEquals(0.30859375f, glyph.bottomRight.y);

		glyph = fnt.glyph(255);
		assertEquals(10, glyph.width);
		assertEquals(0.958984375f, glyph.topLeft.x);
		assertEquals(0.55078125f, glyph.topLeft.y);
		assertEquals(0.9765625f, glyph.bottomRight.x);
		assertEquals(0.62109375f, glyph.bottomRight.y);

		// Caching
		fnt.cache();
	}
}