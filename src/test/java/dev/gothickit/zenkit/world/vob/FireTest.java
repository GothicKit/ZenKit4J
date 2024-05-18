package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
import dev.gothickit.zenkit.Util;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FireTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void load() {
		var vob = new Fire(Util.getResource("G2/VOb/oCMobFire.zen"), GameVersion.GOTHIC_2);
		assertEquals("BIP01 FIRE", vob.getSlot());
		assertEquals("FIRETREE_LAMP.ZEN", vob.getVobTree());
	}

	@Test
	void set() {
		var vob = new Fire(Util.getResource("G2/VOb/oCMobFire.zen"), GameVersion.GOTHIC_2);
		vob.setSlot("test");
		vob.setVobTree("test");

		assertEquals("test", vob.getSlot());
		assertEquals("test", vob.getVobTree());
	}
}