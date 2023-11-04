package dev.gothickit.zenkit.ani;

import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
import dev.gothickit.zenkit.Util;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ModelAnimationTest {
	public static final int[] NODE_INDICES_G1 = new int[]{0, 1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 15, 16, 17, 18, 19, 26, 27, 28, 29, 30, 31, 32, 33};

	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	private static void checkSample(
			AnimationSample sample, float px, float py, float pz, float rx, float ry, float rz, float rw
	) {
		assertEquals(px, sample.position.x);
		assertEquals(py, sample.position.y);
		assertEquals(pz, sample.position.z);
		assertEquals(rx, sample.rotation.x);
		assertEquals(ry, sample.rotation.y);
		assertEquals(rz, sample.rotation.z);
		assertEquals(rw, sample.rotation.w);
	}

	@Test
	void loadG1() {
		var ani = new ModelAnimation(Util.getResource("G1/HUMANS-S_FISTRUN.MAN"));

		var bbox = ani.getBbox();
		assertEquals(46.33139419555664f, bbox.max.x);
		assertEquals(67.0935287475586f, bbox.max.y);
		assertEquals(49.88602828979492f, bbox.max.z);
		assertEquals(-51.09061050415039f, bbox.min.x);
		assertEquals(-94.02226257324219f, bbox.min.y);
		assertEquals(-31.280731201171875f, bbox.min.z);

		assertEquals(3325331650L, ani.getChecksum());
		assertEquals(10.0f, ani.getFps());
		assertEquals(25.0f, ani.getFpsSource());
		assertEquals(20, ani.getFrameCount());
		assertEquals(1, ani.getLayer());
		assertEquals("S_FISTRUN", ani.getName());
		assertEquals("S_FISTRUN", ani.getNext());

		var nodeIndices = ani.getNodeIndices();
		assertEquals(25, ani.getNodeCount());
		assertEquals(25, nodeIndices.length);
		assertArrayEquals(NODE_INDICES_G1, nodeIndices);

		var aniSamples = ani.getSamples();
		assertEquals(25 * 20, ani.getSampleCount());
		assertEquals(25 * 20, aniSamples.size());

		checkSample(
				aniSamples.get(0),
				12.635274887084961f,
				88.75251770019531f,
				-1.093428611755371f,
				0.0f,
				0.6293110251426697f,
				0.0f,
				0.7771535515785217f
		);

		checkSample(
				ani.getSample(249),
				12.626323699951172f,
				-0.00145721435546875f,
				22.643518447875977f,
				0.0f,
				0.70708167552948f,
				0.0f,
				0.7071319222450256f
		);

		checkSample(
				aniSamples.get(499),
				12.626323699951172f,
				-0.00145721435546875f,
				22.643518447875977f,
				0.0f,
				0.70708167552948f,
				0.0f,
				0.7071319222450256f
		);

		assertEquals("\\_WORK\\DATA\\ANIMS\\HUM_AMB_FISTRUN_M01.ASC", ani.getSourcePath());
		assertEquals(
				"\t\t\tANI\t\t\t(\"S_FISTRUN\"\t\t\t\t1\t\"S_FISTRUN\"\t\t0.0 0.1 MI\t\"HUM_AMB_FISTRUN_M01.ASC\"\tF   1\t50\tFPS:10)",
				ani.getSourceScript()
		);
	}

	@Test
	void loadG2() {
		var ani = new ModelAnimation(Util.getResource("G2/HUMANS-S_FISTRUN.MAN"));

		var bbox = ani.getBbox();
		assertEquals(46.33139419555664f, bbox.max.x);
		assertEquals(67.0935287475586f, bbox.max.y);
		assertEquals(49.88602828979492f, bbox.max.z);
		assertEquals(-51.090614318847656f, bbox.min.x);
		assertEquals(-94.02226257324219f, bbox.min.y);
		assertEquals(-31.280733108520508f, bbox.min.z);

		assertEquals(3325331650L, ani.getChecksum());
		assertEquals(10.0f, ani.getFps());
		assertEquals(25.0f, ani.getFpsSource());
		assertEquals(20, ani.getFrameCount());
		assertEquals(1, ani.getLayer());
		assertEquals("S_FISTRUN", ani.getName());
		assertEquals("S_FISTRUN", ani.getNext());

		var nodeIndices = ani.getNodeIndices();
		assertEquals(25, ani.getNodeCount());
		assertEquals(25, nodeIndices.length);
		assertArrayEquals(NODE_INDICES_G1, nodeIndices);

		var aniSamples = ani.getSamples();
		assertEquals(25 * 20, ani.getSampleCount());
		assertEquals(25 * 20, aniSamples.size());

		checkSample(
				aniSamples.get(0),
				12.635274887084961f,
				88.75251770019531f,
				-1.093428611755371f,
				0.0f,
				0.6293110251426697f,
				0.0f,
				0.7771535515785217f
		);

		checkSample(
				ani.getSample(249),
				12.626323699951172f,
				-0.00145721435546875f,
				22.643518447875977f,
				0.0f,
				0.70708167552948f,
				0.0f,
				0.7071319222450256f
		);

		checkSample(
				aniSamples.get(499),
				12.626323699951172f,
				-0.00145721435546875f,
				22.643518447875977f,
				0.0f,
				0.70708167552948f,
				0.0f,
				0.7071319222450256f
		);

		assertEquals("\\_WORK\\DATA\\ANIMS\\HUM_AMB_FISTRUN_M01.ASC", ani.getSourcePath());
		assertEquals(
				"\t\t\tANI\t\t\t(\"S_FISTRUN\"\t\t\t\t1\t\"S_FISTRUN\"\t\t0.0 0.1 MI\t\"HUM_AMB_FISTRUN_M01.ASC\"\tF   1\t50\tFPS:10)",
				ani.getSourceScript()
		);
	}
}