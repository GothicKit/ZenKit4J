package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
import dev.gothickit.zenkit.Util;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ZoneFogTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void load() {
		var vob = new ZoneFog(Util.getResource("G2/VOb/zCZoneZFog.zen"), GameVersion.GOTHIC_2);
		assertEquals(16000.0f, vob.getRangeCenter());
		assertEquals(0.699999988f, vob.getInnerRangePercentage());
		assertEquals((byte) 120, vob.getColor().r);
		assertEquals((byte) 120, vob.getColor().g);
		assertEquals((byte) 120, vob.getColor().b);
		assertEquals((byte) 255, vob.getColor().a);
		assertFalse(vob.getFadeOutSky());
		assertFalse(vob.getOverrideColor());
	}
}