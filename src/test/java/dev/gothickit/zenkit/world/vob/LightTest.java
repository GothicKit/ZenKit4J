package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LightTest {
	private static final float[] G1LightRangeAnimationScale = {};

	private static final Color[] G1LightColorAnimationList =
			{
					new Color(211, 147, 107, 255), new Color(223, 173, 117, 255), new Color(211, 147, 107, 255),
					new Color(223, 173, 117, 255), new Color(225, 197, 100, 255), new Color(223, 173, 117, 255),
					new Color(227, 209, 106, 255), new Color(223, 173, 117, 255), new Color(211, 147, 107, 255),
					new Color(223, 173, 117, 255), new Color(225, 197, 100, 255), new Color(227, 209, 106, 255),
					new Color(223, 173, 117, 255), new Color(211, 147, 107, 255), new Color(225, 197, 100, 255),
					new Color(223, 173, 117, 255), new Color(225, 197, 100, 255), new Color(211, 147, 107, 255),
					new Color(223, 173, 117, 255), new Color(227, 209, 106, 255), new Color(225, 197, 100, 255),
					new Color(211, 147, 107, 255), new Color(225, 197, 100, 255), new Color(223, 173, 117, 255),
					new Color(225, 197, 100, 255), new Color(227, 209, 106, 255), new Color(223, 173, 117, 255),
					new Color(211, 147, 107, 255), new Color(223, 173, 117, 255), new Color(211, 147, 107, 255),
					new Color(225, 197, 100, 255), new Color(227, 209, 106, 255), new Color(223, 173, 117, 255),
			};

	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void load() {
		var vob = new Light(Util.getResource("G1/VOb/zCVobLight.zen"), GameVersion.GOTHIC_1);

		assertEquals("", vob.getPreset());
		assertEquals(LightType.POINT, vob.getLightType());
		assertEquals(2000.0f, vob.getRange());
		assertEquals((byte) 223, vob.getColor().r);
		assertEquals((byte) 173, vob.getColor().g);
		assertEquals((byte) 117, vob.getColor().b);
		assertEquals((byte) 255, vob.getColor().a);
		assertEquals(0.0f, vob.getConeAngle());
		assertEquals(LightQuality.LOW, vob.getQuality());
		assertEquals("", vob.getLensflareFx());
		assertArrayEquals(G1LightRangeAnimationScale, vob.getRangeAnimationScale());
		assertEquals(0.0f, vob.getRangeAnimationFps());
		assertArrayEquals(G1LightColorAnimationList, vob.getColorAnimationList());
		assertEquals(11.0000067f, vob.getColorAnimationFps());
		assertTrue(vob.getOn());
		assertTrue(vob.getRangeAnimationSmooth());
		assertTrue(vob.getCanMove());
		assertFalse(vob.isLightStatic());
		assertFalse(vob.getColorAnimationSmooth());
	}

	@Test
	void set() {
		var vob = new Light(Util.getResource("G1/VOb/zCVobLight.zen"), GameVersion.GOTHIC_1);
		vob.setPreset("");
		vob.setLightType(LightType.POINT);
		vob.setRange(0);
		vob.setColor(new Color(0, 0, 0, 0));
		vob.setConeAngle(0.0f);
		vob.setStatic(true);
		vob.setQuality(LightQuality.HIGH);
		vob.setLensflareFx("");
		vob.setOn(true);
		vob.setRangeAnimationScale(new float[]{1, 2, 3});
		vob.setRangeAnimationFps(0);
		vob.setRangeAnimationSmooth(false);
		vob.setColorAnimationFps(0);
		vob.setColorAnimationSmooth(false);
		vob.setCanMove(true);
	}
}