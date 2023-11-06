package dev.gothickit.zenkit.mmb;

import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
import dev.gothickit.zenkit.Util;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.temporal.TemporalField;
import java.time.temporal.TemporalQueries;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MorphMeshTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void load() {
		var mmb = new MorphMesh(Util.getResource("morph0.mmb"));
		assertEquals("ITRWSMALLBOW", mmb.getName());

		var positions = mmb.getMorphPositions();
		assertEquals(28, positions.length);
		assertEquals(-40.9461403f, positions[0].x);
		assertEquals(-1.73638999f, positions[0].y);
		assertEquals(-26.7512894f, positions[0].z);
		assertEquals(-29.6147194f, positions[1].x);
		assertEquals(-1.97599006f, positions[1].y);
		assertEquals(-9.19756984f, positions[1].z);

		var animations = mmb.getAnimations();
		assertEquals(4, animations.size());
		assertEquals(4, mmb.getAnimationCount());

		var ani = animations.get(1);
		assertEquals("S_SHOOT", ani.getName());
		assertEquals(1, ani.getLayer());
		assertEquals(0.0100000007f, ani.getBlendIn());
		assertEquals(-0.0100000007f, ani.getBlendOut());
		assertEquals(400.0f, ani.getDuration());
		assertEquals(0.0250000004f, ani.getSpeed());
		assertEquals(0, ani.getFlags());
		assertEquals(10, ani.getFrameCount());

		var vertices = ani.getVertices();
		assertEquals(3, vertices.length);
		assertEquals(25, vertices[0]);
		assertEquals(26, vertices[1]);
		assertEquals(27, vertices[2]);

		var samples = ani.getSamples();
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

		var sources = mmb.getSources();
		assertEquals(4, sources.size());

		var source = sources.get(1);
		assertEquals(2000, source.getFileDate().get(Calendar.YEAR));
		assertEquals(5, source.getFileDate().get(Calendar.MONTH));
		assertEquals(8, source.getFileDate().get(Calendar.DAY_OF_MONTH));
		assertEquals(9, source.getFileDate().get(Calendar.HOUR_OF_DAY));
		assertEquals(13, source.getFileDate().get(Calendar.MINUTE));
		assertEquals(58, source.getFileDate().get(Calendar.SECOND));
		assertEquals("ITRWSMALLBOWSHOOT.ASC", source.getFileName());
	}
}