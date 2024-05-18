package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
import dev.gothickit.zenkit.Util;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageFilterTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void load() {
		var vob = new MessageFilter(Util.getResource("G2/VOb/zCMessageFilter.zen"), GameVersion.GOTHIC_2);
		assertEquals("EVT_ADDON_TROLLPORTAL_CAMERA_01", vob.getTarget());
		assertEquals(MessageFilterAction.UNTRIGGER, vob.getOnTrigger());
		assertEquals(MessageFilterAction.UNTRIGGER, vob.getOnUntrigger());
	}

	@Test
	void set() {
		var vob = new MessageFilter(Util.getResource("G2/VOb/zCMessageFilter.zen"), GameVersion.GOTHIC_2);
		vob.setTarget("Test");
		vob.setOnTrigger(MessageFilterAction.NONE);
		vob.setOnUntrigger(MessageFilterAction.NONE);
	}
}