package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
import dev.gothickit.zenkit.Util;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZoneFarPlaneTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void load() {
		var vob = new ZoneFarPlane(Util.getResource("G2/VOb/zCZoneVobFarPlane.zen"), GameVersion.GOTHIC_2);
		assertEquals(6500.0f, vob.getVobFarPlaneZ());
		assertEquals(0.699999988f, vob.getInnerRangePercentage());
	}
}