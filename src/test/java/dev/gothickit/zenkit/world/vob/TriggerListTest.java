package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
import dev.gothickit.zenkit.Util;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriggerListTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void load() {
		var vob = new TriggerList(Util.getResource("G2/VOb/zCTriggerList.zen"), GameVersion.GOTHIC_2);
		assertEquals(TriggerBatchMode.ALL, vob.getMode());
		assertEquals(2, vob.getTargets().size());
		assertEquals("EVT_ADDON_TROLLPORTAL_MASTERTRIGGERLIST_ALPHA_01", vob.getTargets().get(0).getName());
		assertEquals(0, vob.getTargets().get(0).getDelay().getSeconds());
		assertEquals("EVT_ADDON_TROLLPORTAL_TRIGGERSCRIPT_01", vob.getTargets().get(1).getName());
		assertEquals(0, vob.getTargets().get(1).getDelay().getSeconds());
	}

	@Test
	void set() {
		var vob = new TriggerList(Util.getResource("G2/VOb/zCTriggerList.zen"), GameVersion.GOTHIC_2);
		vob.setMode(TriggerBatchMode.NEXT);

		var target = vob.addTarget();
		target.setDelay(Duration.ofSeconds(1));
		target.setName("test");

		assertEquals(TriggerBatchMode.NEXT, vob.getMode());
		assertEquals(3, vob.getTargets().size());
		assertEquals("test", vob.getTargets().get(2).getName());
		assertEquals(1, vob.getTargets().get(2).getDelay().getSeconds());
	}
}