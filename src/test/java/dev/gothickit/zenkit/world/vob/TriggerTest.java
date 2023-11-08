package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
import dev.gothickit.zenkit.Util;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriggerTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void load() {
		var vob = new Trigger(Util.getResource("G2/VOb/zCTrigger.zen"), GameVersion.GOTHIC_2);
		assertEquals("", vob.getTarget());
		assertEquals(3, vob.getFlags());
		assertEquals(0, vob.getFilterFlags());
		assertEquals("", vob.getVobTarget());
		assertEquals(-1, vob.getMaxActivationCount());
		assertEquals(0.0f, vob.getDamageThreshold());
		assertEquals(0.0f, vob.getRetriggerDelay().getSeconds());
		assertEquals(0.0f, vob.getFireDelay().getSeconds());
	}
}