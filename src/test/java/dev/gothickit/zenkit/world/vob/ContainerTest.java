package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
import dev.gothickit.zenkit.Util;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void load() {
		var vob = new Container(Util.getResource("G2/VOb/oCMobContainer.zen"), GameVersion.GOTHIC_2);
		assertFalse(vob.isLocked());
		assertEquals("", vob.getKey());
		assertEquals("", vob.getPickString());
		assertEquals("ItMi_Gold:35", vob.getContents());
	}

	@Test
	void set() {
		var vob = new Container(Util.getResource("G2/VOb/oCMobContainer.zen"), GameVersion.GOTHIC_2);
		vob.setLocked(true);
		vob.setKey("test");
		vob.setPickString("LLRR");
		vob.setContents("None:1");

		assertTrue(vob.isLocked());
		assertEquals("test", vob.getKey());
		assertEquals("LLRR", vob.getPickString());
		assertEquals("None:1", vob.getContents());
	}
}