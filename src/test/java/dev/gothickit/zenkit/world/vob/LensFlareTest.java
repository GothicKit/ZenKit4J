package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
import dev.gothickit.zenkit.Util;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LensFlareTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void load() {
		var vob = new LensFlare(Util.getResource("G1/VOb/zCVobLensFlare.zen"), GameVersion.GOTHIC_1);
		assertEquals("TORCHFX01", vob.getEffect());
	}

	@Test
	void set() {
		var vob = new LensFlare(Util.getResource("G1/VOb/zCVobLensFlare.zen"), GameVersion.GOTHIC_1);
		vob.setEffect("test");
	}
}