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

class InteractiveObjectTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void load() {
		var vob = new InteractiveObject(Util.getResource("G2/VOb/oCMobInter.zen"), GameVersion.GOTHIC_2);
		assertEquals(1, vob.getState());
		assertEquals("", vob.getTarget());
		assertEquals("", vob.getItem());
		assertEquals("", vob.getConditionFunction());
		assertEquals("PRAYIDOL", vob.getOnStateChangeFunction());
		assertFalse(vob.getRewind());
	}

	@Test
	void set() {
		var vob = new InteractiveObject(Util.getResource("G2/VOb/oCMobInter.zen"), GameVersion.GOTHIC_2);
		vob.setState(0);
		vob.setTarget("test");
		vob.setItem("test");
		vob.setConditionFunction("test");
		vob.setOnStateChangeFunction("test");
		vob.setRewind(true);
	}
}