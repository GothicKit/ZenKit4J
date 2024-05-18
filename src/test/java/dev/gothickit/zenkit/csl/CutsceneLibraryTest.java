package dev.gothickit.zenkit.csl;

import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
import dev.gothickit.zenkit.ResourceIOException;
import dev.gothickit.zenkit.Util;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CutsceneLibraryTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void load() throws ResourceIOException {
		var csl = CutsceneLibrary.load(Util.getResource("ou.proprietary.bin"));

		var cslBlocks = csl.blocks();
		assertEquals(7360, csl.blockCount());
		assertEquals(7360, cslBlocks.size());

		var msg20 = csl.block("DIA_ARTO_PERM_15_00");
		var msg100 = csl.block("DIA_BaalKagan_WasDrin_13_01");
		var msg200 = cslBlocks.get(200);
		var msg200_1 = csl.block(200);
		var msgNone = csl.block("nonexistent");

		assertNotNull(msg20);
		assertNotNull(msg100);
		assertNotNull(msg200);
		assertNotNull(msg200_1);
		assertNull(msgNone);

		assertEquals(0, msg20.message().type());
		assertEquals("Du redest nicht viel, was?", msg20.message().text());
		assertEquals("DIA_ARTO_PERM_15_00.WAV", msg20.message().name());

		assertEquals(0, msg100.message().type());
		assertEquals("Ich kann dich auf viele Arten entlohnen.", msg100.message().text());
		assertEquals("DIA_BAALKAGAN_WASDRIN_13_01.WAV", msg100.message().name());

		assertEquals(0, msg200.message().type());
		assertEquals("Stimmt genau.", msg200.message().text());
		assertEquals("DIA_BAALTARAN_INTOCASTLE_EXACTLY_15_00.WAV", msg200.message().name());

		assertEquals(0, msg200_1.message().type());
		assertEquals("Stimmt genau.", msg200_1.message().text());
		assertEquals("DIA_BAALTARAN_INTOCASTLE_EXACTLY_15_00.WAV", msg200_1.message().name());

		// Caching
		csl.cache();
	}
}