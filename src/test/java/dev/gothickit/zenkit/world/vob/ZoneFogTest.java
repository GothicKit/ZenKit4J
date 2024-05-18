package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

	@Test
	void set() {
		var vob = new ZoneFog(Util.getResource("G2/VOb/zCZoneZFog.zen"), GameVersion.GOTHIC_2);
		vob.setRangeCenter(0);
		vob.setInnerRangePercentage(0);
		vob.setColor(new Color(0, 0, 0, 0));
		vob.setFadeOutSky(true);
		vob.setOverrideColor(true);

		assertEquals(0, vob.getRangeCenter());
		assertEquals(0, vob.getInnerRangePercentage());
		assertEquals((byte) 0, vob.getColor().r);
		assertEquals((byte) 0, vob.getColor().g);
		assertEquals((byte) 0, vob.getColor().b);
		assertEquals((byte) 0, vob.getColor().a);
		assertTrue(vob.getFadeOutSky());
		assertTrue(vob.getOverrideColor());
	}
}