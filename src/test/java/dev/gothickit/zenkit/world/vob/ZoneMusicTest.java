package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
import dev.gothickit.zenkit.Util;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZoneMusicTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void load() {
		var vob = new ZoneMusic(Util.getResource("G2/VOb/oCZoneMusic.zen"), GameVersion.GOTHIC_2);
		assertTrue(vob.isEnabled());
		assertEquals(1, vob.getPriority());
		assertFalse(vob.isEllipsoid());
		assertEquals(-3.2190001f, vob.getReverb());
		assertEquals(1.0f, vob.getVolume());
		assertTrue(vob.isLoop());
	}
}