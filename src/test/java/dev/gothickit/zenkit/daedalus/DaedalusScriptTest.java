package dev.gothickit.zenkit.daedalus;

import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
import dev.gothickit.zenkit.ResourceIOException;
import dev.gothickit.zenkit.Util;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaedalusScriptTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void load() throws ResourceIOException {
		var scr = DaedalusScript.load(Util.getResource("menu.proprietary.dat"));

		var syms = scr.getSymbols();
		assertEquals(1093, syms.size());
		assertEquals(1093, scr.getSymbolCount());

		var classSymbol = scr.getSymbolByIndex(118);
		var prototypeSymbol = scr.getSymbolByIndex(133);
		var externalSymbol = scr.getSymbolByIndex(1);
		var memberSymbol = scr.getSymbolByName("C_MENU.BACKPIC");
		var instanceSymbol = scr.getSymbolByName("MENU_MAIN");
		var functionSymbol = scr.getSymbolByAddress(1877);

		var nonexistentSymbol1 = scr.getSymbolByIndex(syms.size() + 100);
		var nonexistentSymbol2 = scr.getSymbolByName("nonexistent_lol");
		var nonexistentSymbol3 = scr.getSymbolByAddress(0xffffffaaL);

		assertNotNull(classSymbol);
		assertNotNull(memberSymbol);
		assertNotNull(prototypeSymbol);
		assertNotNull(instanceSymbol);
		assertNotNull(functionSymbol);
		assertNotNull(externalSymbol);
		assertNull(nonexistentSymbol1);
		assertNull(nonexistentSymbol2);
		assertNull(nonexistentSymbol3);

		assertEquals("C_MENU", classSymbol.getName());
		assertEquals(13, classSymbol.getSize());
		assertEquals(DaedalusDataType.CLASS, classSymbol.getType());
		assertFalse(classSymbol.hasReturn());

		assertEquals("SHOWINTRO", functionSymbol.getName());
		assertEquals(0, functionSymbol.getSize());
		assertEquals(1877, functionSymbol.getAddress());
		assertEquals(DaedalusDataType.FUNCTION, functionSymbol.getType());
		assertEquals(DaedalusDataType.INT, functionSymbol.getReturnType());
		assertTrue(functionSymbol.hasReturn());
	}
}