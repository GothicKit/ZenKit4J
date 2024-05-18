package dev.gothickit.zenkit.mmb;

import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
import dev.gothickit.zenkit.ResourceIOException;
import dev.gothickit.zenkit.Util;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MorphMeshTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void load() throws ResourceIOException {
		var mmb = MorphMesh.load(Util.getResource("morph0.mmb"));
		assertEquals("ITRWSMALLBOW", mmb.name());

		var positions = mmb.morphPositions();
		assertEquals(28, positions.length);
		assertEquals(-40.9461403f, positions[0].x);
		assertEquals(-1.73638999f, positions[0].y);
		assertEquals(-26.7512894f, positions[0].z);
		assertEquals(-29.6147194f, positions[1].x);
		assertEquals(-1.97599006f, positions[1].y);
		assertEquals(-9.19756984f, positions[1].z);

		var animations = mmb.animations();
		assertEquals(4, animations.size());
		assertEquals(4, mmb.animationCount());

		var ani = animations.get(1);
		assertEquals("S_SHOOT", ani.name());
		assertEquals(1, ani.layer());
		assertEquals(0.0100000007f, ani.blendIn());
		assertEquals(-0.0100000007f, ani.blendOut());
		assertEquals(400.0f, ani.duration());
		assertEquals(0.0250000004f, ani.speed());
		assertEquals(0, ani.flags());
		assertEquals(10, ani.frameCount());

		var vertices = ani.vertices();
		assertEquals(3, vertices.length);
		assertEquals(25, vertices[0]);
		assertEquals(26, vertices[1]);
		assertEquals(27, vertices[2]);

		var samples = ani.samples();
		assertEquals(30, samples.length);
		assertEquals(0.519770026f, samples[0].x);
		assertEquals(0, samples[0].y);
		assertEquals(1.27206039f, samples[0].z);
		assertEquals(0, samples[9].x);
		assertEquals(0, samples[9].y);
		assertEquals(0, samples[9].z);
		assertEquals(-8.51126003f, samples[19].x);
		assertEquals(0, samples[19].y);
		assertEquals(-20.8299408f, samples[19].z);

		var sources = mmb.sources();
		assertEquals(4, sources.size());

		var source = sources.get(1);
		assertEquals(2000, source.fileDate().get(Calendar.YEAR));
		assertEquals(5, source.fileDate().get(Calendar.MONTH));
		assertEquals(8, source.fileDate().get(Calendar.DAY_OF_MONTH));
		assertEquals(9, source.fileDate().get(Calendar.HOUR_OF_DAY));
		assertEquals(13, source.fileDate().get(Calendar.MINUTE));
		assertEquals(58, source.fileDate().get(Calendar.SECOND));
		assertEquals("ITRWSMALLBOWSHOOT.ASC", source.fileName());
	}
}