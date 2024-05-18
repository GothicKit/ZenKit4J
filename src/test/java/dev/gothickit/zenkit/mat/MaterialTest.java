package dev.gothickit.zenkit.mat;

import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
import dev.gothickit.zenkit.ResourceIOException;
import dev.gothickit.zenkit.Util;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class MaterialTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void loadG1() throws ResourceIOException {
		var mat = Material.load(Util.getResource("G1/DEMON_DIE_BODY.MAT"));
		assertEquals("BODY", mat.name());
		assertEquals(MaterialGroup.UNDEFINED, mat.group());
		assertEquals(115, mat.color().r);
		assertEquals(91, mat.color().g);
		assertEquals(77, mat.color().b);
		assertEquals((byte) 255, mat.color().a);
		assertEquals(60.0f, mat.smoothAngle());
		assertEquals("DEM_BODY_V0.TGA", mat.texture());
		assertEquals(512.0f, mat.textureScale().x);
		assertEquals(512.0f, mat.textureScale().y);
		assertEquals(0.0f, mat.textureAnimationFps());
		assertEquals(AnimationMapping.NONE, mat.textureAnimationMapping());
		assertEquals(9.9999997e-005f, mat.textureAnimationMappingDirection().x);
		assertEquals(0.0f, mat.textureAnimationMappingDirection().y);
		assertFalse(mat.disableCollision());
		assertFalse(mat.disableLightmap());
		assertFalse(mat.dontCollapse());
		assertEquals("", mat.detailObject());
		assertEquals(2.34375f, mat.defaultMapping().x);
		assertEquals(2.34375f, mat.defaultMapping().y);
	}

	@Test
	void loadG2() throws ResourceIOException {
		var mat = Material.load(Util.getResource("G2/DEMON_DIE_BODY.MAT"));
		assertEquals("BODY", mat.name());
		assertEquals(MaterialGroup.UNDEFINED, mat.group());
		assertEquals(115, mat.color().r);
		assertEquals(91, mat.color().g);
		assertEquals(77, mat.color().b);
		assertEquals((byte) 255, mat.color().a);
		assertEquals(60.0f, mat.smoothAngle());
		assertEquals("DEM_BODY_V0.TGA", mat.texture());
		assertEquals(512.0f, mat.textureScale().x);
		assertEquals(512.0f, mat.textureScale().y);
		assertEquals(0.0f, mat.textureAnimationFps());
		assertEquals(AnimationMapping.NONE, mat.textureAnimationMapping());
		assertEquals(0.0f, mat.textureAnimationMappingDirection().x);
		assertEquals(0.0f, mat.textureAnimationMappingDirection().y);
		assertFalse(mat.disableCollision());
		assertFalse(mat.disableLightmap());
		assertFalse(mat.dontCollapse());
		assertEquals("", mat.detailObject());
		assertEquals(2.34375f, mat.defaultMapping().x);
		assertEquals(2.34375f, mat.defaultMapping().y);

		assertEquals(AlphaFunction.NONE, mat.alphaFunction());
		assertEquals(1.0f, mat.detailObjectScale());
		assertFalse(mat.forceOccluder());
		assertFalse(mat.environmentMapping());
		assertEquals(1.0f, mat.environmentMappingStrength());
		assertEquals(WaveMode.NONE, mat.waveMode());
		assertEquals(WaveSpeed.NORMAL, mat.waveSpeed());
		assertEquals(30.0f, mat.waveAmplitude());
		assertEquals(100.0f, mat.waveGridSize());
		assertFalse(mat.ignoreSun());
	}
}