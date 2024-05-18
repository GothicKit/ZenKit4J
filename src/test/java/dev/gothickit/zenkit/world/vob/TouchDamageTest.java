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

class TouchDamageTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void load() {
		var vob = new TouchDamage(Util.getResource("G2/VOb/oCTouchDamage.zen"), GameVersion.GOTHIC_2);
		assertEquals(1000.0f, vob.getDamage());
		assertTrue(vob.isBarrier());
		assertFalse(vob.isBlunt());
		assertTrue(vob.isEdge());
		assertFalse(vob.isFire());
		assertFalse(vob.isFall());
		assertFalse(vob.isFly());
		assertFalse(vob.isMagic());
		assertFalse(vob.isPoint());
		assertEquals(0, vob.getRepeatDelay().getSeconds());
		assertEquals(1, vob.getVolumeScale());
		assertEquals(TouchCollisionType.BOX, vob.getCollisionType());
	}

	@Test
	void set() {
		var vob = new TouchDamage(Util.getResource("G2/VOb/oCTouchDamage.zen"), GameVersion.GOTHIC_2);
		vob.setDamage(0);
		vob.setIsBarrier(true);
		vob.setIsBlunt(true);
		vob.setIsEdge(true);
		vob.setIsFire(true);
		vob.setIsFall(true);
		vob.setIsFly(true);
		vob.setIsMagic(true);
		vob.setIsPoint(true);
		vob.setRepeatDelay(Duration.ZERO);
		vob.setVolumeScale(1);
		vob.setCollisionType(TouchCollisionType.NONE);
	}
}