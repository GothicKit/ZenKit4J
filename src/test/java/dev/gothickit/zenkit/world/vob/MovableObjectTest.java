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

class MovableObjectTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void load() {
		var vob = new MovableObject(Util.getResource("G2/VOb/oCMOB.zen"), GameVersion.GOTHIC_2);
		assertEquals("MOBNAME_GRAVE_18", vob.getFocusName());
		assertEquals(10, vob.getHp());
		assertEquals(0, vob.getDamage());
		assertFalse(vob.isMovable());
		assertFalse(vob.isTakable());
		assertFalse(vob.getFocusOverride());
		assertEquals(SoundMaterialType.WOOD, vob.getMaterial());
		assertEquals("", vob.getVisualDestroyed());
		assertEquals("", vob.getOwner());
		assertEquals("", vob.getOwnerGuild());
		assertFalse(vob.isDestroyed());
	}
}