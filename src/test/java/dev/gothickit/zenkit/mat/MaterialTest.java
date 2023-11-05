package dev.gothickit.zenkit.mat;

import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
import dev.gothickit.zenkit.Util;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaterialTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void loadG1() {
		var mat = new Material(Util.getResource("G1/DEMON_DIE_BODY.MAT"));
		assertEquals("BODY", mat.getName());
		assertEquals(MaterialGroup.UNDEFINED, mat.getGroup());
		assertEquals(115, mat.getColor().r);
		assertEquals(91, mat.getColor().g);
		assertEquals(77, mat.getColor().b);
		assertEquals((byte) 255, mat.getColor().a);
		assertEquals(60.0f, mat.getSmoothAngle());
		assertEquals("DEM_BODY_V0.TGA", mat.getTexture());
		assertEquals(512.0f, mat.getTextureScale().x);
		assertEquals(512.0f, mat.getTextureScale().y);
		assertEquals(0.0f, mat.getTextureAnimationFps());
		assertEquals(AnimationMapping.NONE, mat.getTextureAnimationMapping());
		assertEquals(9.9999997e-005f, mat.getTextureAnimationMappingDirection().x);
		assertEquals(0.0f, mat.getTextureAnimationMappingDirection().y);
		assertFalse(mat.getDisableCollision());
		assertFalse(mat.getDisableLightmap());
		assertFalse(mat.getDontCollapse());
		assertEquals("", mat.getDetailObject());
		assertEquals(2.34375f, mat.getDefaultMapping().x);
		assertEquals(2.34375f, mat.getDefaultMapping().y);
	}

	@Test
	void loadG2() {
		var mat = new Material(Util.getResource("G2/DEMON_DIE_BODY.MAT"));
		assertEquals("BODY", mat.getName());
		assertEquals(MaterialGroup.UNDEFINED, mat.getGroup());
		assertEquals(115, mat.getColor().r);
		assertEquals(91, mat.getColor().g);
		assertEquals(77, mat.getColor().b);
		assertEquals((byte) 255, mat.getColor().a);
		assertEquals(60.0f, mat.getSmoothAngle());
		assertEquals("DEM_BODY_V0.TGA", mat.getTexture());
		assertEquals(512.0f, mat.getTextureScale().x);
		assertEquals(512.0f, mat.getTextureScale().y);
		assertEquals(0.0f, mat.getTextureAnimationFps());
		assertEquals(AnimationMapping.NONE, mat.getTextureAnimationMapping());
		assertEquals(0.0f, mat.getTextureAnimationMappingDirection().x);
		assertEquals(0.0f, mat.getTextureAnimationMappingDirection().y);
		assertFalse(mat.getDisableCollision());
		assertFalse(mat.getDisableLightmap());
		assertFalse(mat.getDontCollapse());
		assertEquals("", mat.getDetailObject());
		assertEquals(2.34375f, mat.getDefaultMapping().x);
		assertEquals(2.34375f, mat.getDefaultMapping().y);

		assertEquals(AlphaFunction.NONE, mat.getAlphaFunction());
		assertEquals(1.0f, mat.getDetailObjectScale());
		assertFalse(mat.getForceOccluder());
		assertFalse(mat.getEnvironmentMapping());
		assertEquals(1.0f, mat.getEnvironmentMappingStrength());
		assertEquals(WaveMode.NONE, mat.getWaveMode());
		assertEquals(WaveSpeed.NORMAL, mat.getWaveSpeed());
		assertEquals(30.0f, mat.getWaveAmplitude());
		assertEquals(100.0f, mat.getWaveGridSize());
		assertFalse(mat.getIgnoreSun());
	}
}