package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.GameVersion;
import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
import dev.gothickit.zenkit.Util;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class CutsceneCameraTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void loadG2() {
		var vob = new CutsceneCamera(Util.getResource("G2/VOb/zCCSCamera.zen"), GameVersion.GOTHIC_2);

		assertEquals(VirtualObjectType.zCCSCamera, vob.getType());
		assertEquals(CameraTrajectory.WORLD, vob.getTrajectoryFOR());
		assertEquals(CameraTrajectory.WORLD, vob.getTargetTrajectoryFOR());
		assertEquals(CameraLoopType.NONE, vob.getLoopMode());
		assertEquals(CameraLerpType.PATH, vob.getLerpMode());
		assertFalse(vob.getIgnoreFORVobRotation());
		assertFalse(vob.getIgnoreFORVobRotationTarget());
		assertFalse(vob.getAdapt());
		assertFalse(vob.getEaseFirst());
		assertFalse(vob.getEaseLast());
		assertEquals(20.0f, vob.getTotalDuration());
		assertEquals("", vob.getAutoFocusVob());
		assertFalse(vob.getAutoPlayerMovable());
		assertFalse(vob.getAutoUntriggerLast());
		assertEquals(0.0f, vob.getAutoUntriggerLastDelay());
		assertEquals(2, vob.getPositionCount());
		assertEquals(1, vob.getTargetCount());

		var frames = vob.getFrames();
		assertEquals(3, frames.size());
		assertEquals(0.0f, frames.get(0).getTime());
		assertEquals(0.0f, frames.get(0).getRollAngle());
		assertEquals(1.0f, frames.get(0).getFovScale());
		assertEquals(CameraMotion.SLOW, frames.get(0).getMotionType());
		assertEquals(CameraMotion.SMOOTH, frames.get(0).getMotionTypeFov());
		assertEquals(CameraMotion.SMOOTH, frames.get(0).getMotionTypeRoll());
		assertEquals(CameraMotion.SMOOTH, frames.get(0).getMotionTypeTimeScale());
		assertEquals(0.0f, frames.get(0).getTension());
		assertEquals(0.0f, frames.get(0).getCamBias());
		assertEquals(0.0f, frames.get(0).getContinuity());
		assertEquals(1.0f, frames.get(0).getTimeScale());
		assertFalse(frames.get(0).isTimeFixed());

		var pose = frames.get(0).getOriginalPose();
		assertEquals(0.202226311f, pose.m00);
		assertEquals(3.00647909e-11f, pose.m01);
		assertEquals(-0.979338825f, pose.m02);
		assertEquals(0, pose.m03);

		assertEquals(0.00805913191f, pose.m10);
		assertEquals(0.999966145f, pose.m11);
		assertEquals(0.00166415179f, pose.m12);
		assertEquals(0.0f, pose.m13);

		assertEquals(0.979305685f, pose.m20);
		assertEquals(-0.00822915602f, pose.m21);
		assertEquals(0.202219456f, pose.m22);
		assertEquals(0.0f, pose.m23);

		assertEquals(81815.7656f, pose.m30);
		assertEquals(3905.95044f, pose.m31);
		assertEquals(29227.1875f, pose.m32);
		assertEquals(1.0f, pose.m33);

	}
}