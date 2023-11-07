package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
import dev.gothickit.zenkit.Util;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SoundDaytimeTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void load() {
		var vob = new SoundDaytime(Util.getResource("G2/VOb/zCVobSoundDaytime.zen"), GameVersion.GOTHIC_2);
		assertEquals(5, vob.getStartTime());
		assertEquals(21, vob.getEndTime());
		assertEquals("InsectsFrogs_Night", vob.getSoundNameDaytime());
	}
}