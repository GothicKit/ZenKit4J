package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.world.visual.VisualType;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VirtualObjectTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	private void checkVec2(@NotNull Vec2f v, float x, float y) {
		assertEquals(x, v.x);
		assertEquals(y, v.y);
	}

	private void checkVec3(@NotNull Vec3f v, float x, float y, float z) {
		assertEquals(x, v.x);
		assertEquals(y, v.y);
		assertEquals(z, v.z);
	}

	@Test
	void loadG1() {
		var vob = new VirtualObject(Util.getResource("./G1/VOb/zCVob.zen"), GameVersion.GOTHIC_1);

		checkVec3(vob.getBoundingBox().min, -18966.623f, -236.707687f, 4373.23486f);
		checkVec3(vob.getBoundingBox().max, -18772.623f, -42.7076874f, 4567.23486f);
		checkVec3(vob.getPosition(), -18869.623f, -139.707687f, 4470.23486f);

		assertEquals(1, vob.getRotation().m00);
		assertEquals(0, vob.getRotation().m01);
		assertEquals(0, vob.getRotation().m02);
		assertEquals(0, vob.getRotation().m10);
		assertEquals(1, vob.getRotation().m11);
		assertEquals(0, vob.getRotation().m12);
		assertEquals(0, vob.getRotation().m20);
		assertEquals(0, vob.getRotation().m21);
		assertEquals(1, vob.getRotation().m22);
		assertTrue(vob.getShowVisual());
		assertEquals(SpriteAlignment.NONE, vob.getSpriteCameraFacingMode());
		assertFalse(vob.isCdStatic());
		assertFalse(vob.isCdDynamic());
		assertFalse(vob.isStatic());
		assertEquals(ShadowType.NONE, vob.getDynamicShadows());
		assertFalse(vob.isPhysicsEnabled());
		assertEquals(AnimationType.NONE, vob.getAnimationType());
		assertEquals(0, vob.getBias());
		assertFalse(vob.getAmbient());
		assertEquals(0, vob.getAnimationStrength());
		assertEquals(2.0, vob.getFarClipScale());
		assertEquals("", vob.getPresetName());
		assertEquals("", vob.getName());

		var visual = vob.getVisual();
		assertEquals("FIRE.pfx", visual.getName());
		assertEquals(VisualType.PARTICLE_EFFECT, visual.getType());
	}

	@Test
	void loadG2() {
		var vob = new VirtualObject(Util.getResource("./G2/VOb/zCVob.zen"), GameVersion.GOTHIC_2);

		checkVec3(vob.getBoundingBox().min, 30897.1035f, 4760.24951f, -14865.5723f);
		checkVec3(vob.getBoundingBox().max, 30929.8301f, 4836.17529f, -14817.3135f);
		checkVec3(vob.getPosition(), 30913.4668f, 4798.9751f, -14841.4434f);

		assertEquals(0.920505285f, vob.getRotation().m00);
		assertEquals(0, vob.getRotation().m01);
		assertEquals(-0.390731275f, vob.getRotation().m02);
		assertEquals(0, vob.getRotation().m10);
		assertEquals(1, vob.getRotation().m11);
		assertEquals(0, vob.getRotation().m12);
		assertEquals(0.390731275f, vob.getRotation().m20);
		assertEquals(0, vob.getRotation().m21);
		assertEquals(0.920505285f, vob.getRotation().m22);
		assertTrue(vob.getShowVisual());
		assertEquals(SpriteAlignment.NONE, vob.getSpriteCameraFacingMode());
		assertFalse(vob.isCdStatic());
		assertFalse(vob.isCdDynamic());
		assertTrue(vob.isStatic());
		assertEquals(ShadowType.NONE, vob.getDynamicShadows());
		assertFalse(vob.isPhysicsEnabled());
		assertEquals(AnimationType.NONE, vob.getAnimationType());
		assertEquals(0, vob.getBias());
		assertFalse(vob.getAmbient());
		assertEquals(0, vob.getAnimationStrength());
		assertEquals(1, vob.getFarClipScale());
		assertEquals("", vob.getPresetName());
		assertEquals("", vob.getName());

		var visual = vob.getVisual();
		assertEquals("OW_MISC_WALL_TORCH_01.3DS", visual.getName());
		assertEquals(VisualType.MULTI_RESOLUTION_MESH, visual.getType());
	}
}