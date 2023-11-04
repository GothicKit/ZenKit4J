package dev.gothickit.zenkit.csl;

import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
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
	void load() {
		var csl = new CutsceneLibrary(Util.getResource("ou.proprietary.bin"));

		var cslBlocks = csl.getBlocks();
		assertEquals(7360, cslBlocks.size());

		var msg20 = csl.getBlock("DIA_ARTO_PERM_15_00");
		var msg100 = csl.getBlock("DIA_BaalKagan_WasDrin_13_01");
		var msg200 = cslBlocks.get(200);
		var msgNone = csl.getBlock("nonexistent");

		assertNotNull(msg20);
		assertNotNull(msg100);
		assertNotNull(msg200);
		assertNull(msgNone);

		assertEquals(0, msg20.getMessage().getType());
		assertEquals("Du redest nicht viel, was?", msg20.getMessage().getText());
		assertEquals("DIA_ARTO_PERM_15_00.WAV", msg20.getMessage().getName());

		assertEquals(0, msg100.getMessage().getType());
		assertEquals("Ich kann dich auf viele Arten entlohnen.", msg100.getMessage().getText());
		assertEquals("DIA_BAALKAGAN_WASDRIN_13_01.WAV", msg100.getMessage().getName());

		assertEquals(0, msg200.getMessage().getType());
		assertEquals("Stimmt genau.", msg200.getMessage().getText());
		assertEquals("DIA_BAALTARAN_INTOCASTLE_EXACTLY_15_00.WAV", msg200.getMessage().getName());
	}
}