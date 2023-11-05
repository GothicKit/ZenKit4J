package dev.gothickit.zenkit.tex;

import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
import dev.gothickit.zenkit.Util;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextureTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void load() {
		var tex = new Texture(Util.getResource("erz.tex"));

		assertEquals(128, tex.getWidth());
		assertEquals(128, tex.getHeight());
		assertEquals(128, tex.getWidthRef());
		assertEquals(128, tex.getHeightRef());
		assertEquals(128, tex.getWidth(0));
		assertEquals(128, tex.getHeight(0));
		assertEquals(64, tex.getWidth(1));
		assertEquals(64, tex.getHeight(1));
		assertEquals(32, tex.getWidth(2));
		assertEquals(32, tex.getHeight(2));
		assertEquals(0xff443a3c, tex.getAverageColor());
		assertEquals(5, tex.getMipmapCount());
		assertEquals(5, tex.getAllMipmapsRaw().size());
		assertEquals(5, tex.getAllMipmapsRgba().size());
		assertEquals(TextureFormat.DXT1, tex.getFormat());
	}
}