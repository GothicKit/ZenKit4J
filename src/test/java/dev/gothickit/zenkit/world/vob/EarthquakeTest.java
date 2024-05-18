package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EarthquakeTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void load() {
		var vob = new Earthquake(Util.getResource("G2/VOb/zCEarthquake.zen"), GameVersion.GOTHIC_2);
		assertEquals(1000.0f, vob.getRadius());
		assertEquals(5, vob.getDuration().getSeconds());
		assertEquals(2.0, vob.getAmplitude().x);
		assertEquals(10.0, vob.getAmplitude().y);
		assertEquals(2.0, vob.getAmplitude().z);
	}

	@Test
	void set() {
		var vob = new Earthquake(Util.getResource("G2/VOb/zCEarthquake.zen"), GameVersion.GOTHIC_2);
		vob.setRadius(0);
		vob.setDuration(Duration.ZERO);
		vob.setAmplitude(new Vec3f(1, 2, 3));

		assertEquals(1.0, vob.getAmplitude().x);
		assertEquals(2.0, vob.getAmplitude().y);
		assertEquals(3.0, vob.getAmplitude().z);
	}
}