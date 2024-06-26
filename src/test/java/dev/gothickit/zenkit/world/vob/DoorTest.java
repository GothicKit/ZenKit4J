package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
import dev.gothickit.zenkit.Util;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoorTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void load() {
		var vob = new Door(Util.getResource("G2/VOb/oCMobDoor.zen"), GameVersion.GOTHIC_2);
		assertFalse(vob.isLocked());
		assertEquals("", vob.getKey());
		assertEquals("", vob.getPickString());
	}

	@Test
	void set() {
		var vob = new Door(Util.getResource("G2/VOb/oCMobDoor.zen"), GameVersion.GOTHIC_2);
		vob.setLocked(true);
		vob.setKey("test");
		vob.setPickString("test");

		assertTrue(vob.isLocked());
		assertEquals("test", vob.getKey());
		assertEquals("test", vob.getPickString());
	}
}