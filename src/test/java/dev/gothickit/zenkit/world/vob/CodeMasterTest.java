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

class CodeMasterTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void load() {
		var vob = new CodeMaster(Util.getResource("G2/VOb/zCCodeMaster.zen"), GameVersion.GOTHIC_2);
		assertEquals("EVT_ORNAMENT_TRIGGER_BIGFARM_01", vob.getTarget());
		assertFalse(vob.isOrdered());
		assertFalse(vob.getFirstFalseIsFailure());
		assertEquals("", vob.getFailureTarget());
		assertFalse(vob.getUntriggeredCancels());
		assertEquals("EVT_ORNAMENT_SWITCH_BIGFARM_01", vob.getSlave(0));
		assertEquals("EVT_ORNAMENT_SWITCH_BIGFARM_02", vob.getSlave(1));
		assertEquals("EVT_ORNAMENT_SWITCH_BIGFARM_03", vob.getSlave(2));
	}
}