package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
import dev.gothickit.zenkit.Util;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

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

		assertTrue(vob.getStartEnabled());
		assertFalse(vob.getSendUntrigger());
		assertFalse(vob.getReactToOnTrigger());
		assertFalse(vob.getReactToOnTouch());
		assertFalse(vob.getReactToOnDamage());
		assertFalse(vob.getRespondToObject());
		assertFalse(vob.getRespondToPC());
		assertFalse(vob.getRespondToNPC());

		assertEquals("", vob.getVobTarget());
		assertEquals(-1, vob.getMaxActivationCount());
		assertEquals(0.0f, vob.getDamageThreshold());
		assertEquals(0.0f, vob.getRetriggerDelay().getSeconds());
		assertEquals(0.0f, vob.getFireDelay().getSeconds());
	}

	@Test
	void set() {
		var vob = new Trigger(Util.getResource("G2/VOb/zCTrigger.zen"), GameVersion.GOTHIC_2);
		vob.setTarget("test");

		vob.setStartEnabled(false);
		vob.setSendUntrigger(true);
		vob.setReactToOnTrigger(true);
		vob.setReactToOnTouch(true);
		vob.setReactToOnDamage(true);
		vob.setRespondToObject(true);
		vob.setRespondToPC(true);
		vob.setRespondToNPC(true);

		vob.setVobTarget("test");
		vob.setMaxActivationCount(1);
		vob.setDamageThreshold(1);
		vob.setRetriggerDelay(Duration.ofSeconds(1));
		vob.setFireDelay(Duration.ofSeconds(1));

		assertEquals("test", vob.getTarget());
		assertEquals("test", vob.getVobTarget());
		assertEquals(1, vob.getMaxActivationCount());
		assertEquals(1.0f, vob.getDamageThreshold());
		assertEquals(1.0f, vob.getRetriggerDelay().getSeconds());
		assertEquals(1.0f, vob.getFireDelay().getSeconds());
		assertFalse(vob.getStartEnabled());
		assertTrue(vob.getSendUntrigger());
		assertTrue(vob.getReactToOnTrigger());
		assertTrue(vob.getReactToOnTouch());
		assertTrue(vob.getReactToOnDamage());
		assertTrue(vob.getRespondToObject());
		assertTrue(vob.getRespondToPC());
		assertTrue(vob.getRespondToNPC());
	}
}