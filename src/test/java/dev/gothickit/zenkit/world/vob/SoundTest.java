package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
import dev.gothickit.zenkit.Util;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoundTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void load() {
		var vob = new Sound(Util.getResource("G2/VOb/zCVobSound.zen"), GameVersion.GOTHIC_2);
		assertEquals(80.0f, vob.getVolume());
		assertEquals(SoundMode.RANDOM, vob.getMode());
		assertEquals(30.0f, vob.getRandomDelay());
		assertEquals(20.0f, vob.getRandomDelayVar());
		assertTrue(vob.getInitiallyPlaying());
		assertFalse(vob.isAmbient3d());
		assertFalse(vob.getObstruction());
		assertEquals(0.0f, vob.getConeAngle());
		assertEquals(SoundTriggerVolumeType.SPHERICAL, vob.getVolumeType());
		assertEquals(3000.0f, vob.getRadius());
		assertEquals("OW_CROW", vob.getSoundName());
	}

	@Test
	void set() {
		var vob = new Sound(Util.getResource("G2/VOb/zCVobSound.zen"), GameVersion.GOTHIC_2);
		vob.setVolume(0);
		vob.setMode(SoundMode.LOOP);
		vob.setRandomDelay(0);
		vob.setRandomDelayVar(0);
		vob.setInitiallyPlaying(false);
		vob.setAmbient3d(true);
		vob.setObstruction(true);
		vob.setConeAngle(1);
		vob.setVolumeType(SoundTriggerVolumeType.ELLIPSOIDAL);
		vob.setRadius(0);
		vob.setSoundName("test");

		assertEquals(0.0f, vob.getVolume());
		assertEquals(SoundMode.LOOP, vob.getMode());
		assertEquals(0.0f, vob.getRandomDelay());
		assertEquals(0.0f, vob.getRandomDelayVar());
		assertFalse(vob.getInitiallyPlaying());
		assertTrue(vob.isAmbient3d());
		assertTrue(vob.getObstruction());
		assertEquals(1.0f, vob.getConeAngle());
		assertEquals(SoundTriggerVolumeType.ELLIPSOIDAL, vob.getVolumeType());
		assertEquals(0.0f, vob.getRadius());
		assertEquals("test", vob.getSoundName());
	}
}