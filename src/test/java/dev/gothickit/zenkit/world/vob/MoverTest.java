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

class MoverTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void load() {
		var vob = new Mover(Util.getResource("G2/VOb/zCMover.zen"), GameVersion.GOTHIC_2);
		assertEquals(MoverBehavior.TOGGLE, vob.getBehavior());
		assertEquals(0, vob.getTouchBlockerDamage());
		assertEquals(2, vob.getStayOpenTime().getSeconds());
		assertEquals(0.0500000007f, vob.getSpeed());
		assertEquals(MoverLerpType.CURVE, vob.getLerpType());
		assertEquals(MoverSpeedType.SLOW_START_END, vob.getSpeedType());
		assertEquals(2, vob.getKeyframes().length);
		assertEquals(29785.9609f, vob.getKeyframes()[0].position.x);
		assertEquals(5140.81982f, vob.getKeyframes()[0].position.y);
		assertEquals(-16279.8477f, vob.getKeyframes()[0].position.z);
		assertEquals(0.999809802f, vob.getKeyframes()[0].rotation.w);
		assertEquals(-0.000760567724f, vob.getKeyframes()[0].rotation.x);
		assertEquals(0.0174517576f, vob.getKeyframes()[0].rotation.y);
		assertEquals(0.00869333092f, vob.getKeyframes()[0].rotation.z);
		assertEquals("GATE_START", vob.getSfxOpenStart());
		assertEquals("GATE_STOP", vob.getSfxOpenEnd());
		assertEquals("GATE_LOOP", vob.getSfxTransitioning());
		assertEquals("GATE_START", vob.getSfxCloseStart());
		assertEquals("GATE_STOP", vob.getSfxCloseEnd());
		assertEquals("", vob.getSfxLock());
		assertEquals("", vob.getSfxUnlock());
		assertEquals("", vob.getSfxUseLocked());
		assertFalse(vob.isLocked());
		assertFalse(vob.getAutoLink());
		assertFalse(vob.getAutoRotate());
	}
}