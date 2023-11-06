package dev.gothickit.zenkit.mds;

import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
import dev.gothickit.zenkit.Util;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelScriptTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void load() {
		var script = new ModelScript(Util.getResource("waran.mds"));

		assertTrue(script.getSkeletonMeshDisabled());
		assertEquals("TestModelMesh.asc", script.getSkeletonName());

		var anims = script.getAnimations();
		assertEquals(2, anims.size());
		assertEquals("aniName1", anims.get(0).getName());
		assertEquals(111, anims.get(0).getLayer());
		assertEquals("aniNext1", anims.get(0).getNext());
		assertEquals(4.2f, anims.get(0).getBlendIn());
		assertEquals(0.5f, anims.get(0).getBlendOut());
		assertEquals(AnimationFlag.MOVE | AnimationFlag.IDLE, anims.get(0).getFlags());
		assertEquals("aniModel1", anims.get(0).getModel());
		assertEquals(AnimationDirection.FORWARD, anims.get(0).getDirection());
		assertEquals(221, anims.get(0).getFirstFrame());
		assertEquals(-331, anims.get(0).getLastFrame());
		assertEquals(25.0f, anims.get(0).getFps());
		assertEquals(0.0f, anims.get(0).getSpeed());
		assertEquals(0.2f, anims.get(0).getCollisionVolumeScale());
		assertEquals(0, anims.get(0).getParticleEffects().size());
		assertEquals(0, anims.get(0).getParticleEffectsStop().size());
		assertEquals(0, anims.get(0).getSoundEffects().size());
		assertEquals(0, anims.get(0).getSoundEffectsGround().size());
		assertEquals(0, anims.get(0).getEventTags().size());
		assertEquals(0, anims.get(0).getMorphAnimations().size());
		assertEquals(0, anims.get(0).getCameraTremors().size());
		assertEquals(0, anims.get(0).getParticleEffectCount());
		assertEquals(0, anims.get(0).getParticleEffectStopCount());
		assertEquals(0, anims.get(0).getSoundEffectCount());
		assertEquals(0, anims.get(0).getSoundEffectGroundCount());
		assertEquals(0, anims.get(0).getEventTagCount());
		assertEquals(0, anims.get(0).getMorphAnimationCount());
		assertEquals(0, anims.get(0).getCameraTremorCount());

		assertEquals("aniName2", anims.get(1).getName());
		assertEquals(112, anims.get(1).getLayer());
		assertEquals("aniNext2", anims.get(1).getNext());
		assertEquals(9.0f, anims.get(1).getBlendIn());
		assertEquals(0.0f, anims.get(1).getBlendOut());
		assertEquals(AnimationFlag.MOVE, anims.get(1).getFlags());
		assertEquals("aniModel2", anims.get(1).getModel());
		assertEquals(AnimationDirection.BACKWARD, anims.get(1).getDirection());
		assertEquals(222, anims.get(1).getFirstFrame());
		assertEquals(332, anims.get(1).getLastFrame());
		assertEquals(25.0f, anims.get(1).getFps());
		assertEquals(0.0f, anims.get(1).getSpeed());
		assertEquals(1.0f, anims.get(1).getCollisionVolumeScale());

		var events = anims.get(1).getEventTags();
		assertEquals(3, events.size());
		assertEquals(0, events.get(0).getFrame());
		assertEquals(EventType.TORCH_DROP, events.get(0).getType());
		assertTrue(events.get(0).isAttached());
		assertEquals(1, events.get(1).getFrame());
		assertEquals(EventType.COMBO_WINDOW, events.get(1).getType());
		assertFalse(events.get(1).isAttached());
		assertEquals(0, events.get(2).getFrame());
		assertEquals(EventType.ITEM_CREATE, events.get(2).getType());
		assertEquals("eventSlot", events.get(2).getSlot(0));
		assertEquals("eventItem", events.get(2).getItem());
		assertFalse(events.get(2).isAttached());
		assertEquals(1, events.get(1).getFrames()[0]);
		assertEquals(2, events.get(1).getFrames()[1]);
		assertEquals(3, events.get(1).getFrames()[2]);
		assertEquals(4, events.get(1).getFrames()[3]);
		assertEquals(5, events.get(1).getFrames()[4]);

		var sfx = anims.get(1).getSoundEffects();
		assertEquals(3, sfx.size());
		assertEquals(3, sfx.get(0).getFrame());
		assertEquals("sfxName1", sfx.get(0).getName());
		assertTrue(sfx.get(0).getEmptySlot());
		assertEquals(4, sfx.get(1).getFrame());
		assertEquals("sfxName2", sfx.get(1).getName());
		assertEquals(67.4f, sfx.get(1).getRange());
		assertFalse(sfx.get(1).getEmptySlot());

		var sfxGround = anims.get(1).getSoundEffectsGround();
		assertEquals(1, sfxGround.size());
		assertEquals(5, sfxGround.get(0).getFrame());
		assertEquals("sfxGrndName", sfxGround.get(0).getName());
		assertFalse(sfxGround.get(0).getEmptySlot());

		var pfx = anims.get(1).getParticleEffects();
		assertEquals(3, pfx.size());
		assertEquals(6, pfx.get(0).getFrame());
		assertEquals(0, pfx.get(0).getIndex());
		assertEquals("pfxName1", pfx.get(0).getName());
		assertEquals("pfxPosition1", pfx.get(0).getPosition());
		assertTrue(pfx.get(0).isAttached());
		assertEquals(7, pfx.get(1).getFrame());
		assertEquals(991, pfx.get(1).getIndex());
		assertEquals("pfxName2", pfx.get(1).getName());
		assertEquals("pfxPosition2", pfx.get(1).getPosition());
		assertFalse(pfx.get(1).isAttached());
		assertEquals(9, pfx.get(2).getFrame());
		assertEquals(991, pfx.get(2).getIndex());
		assertEquals("pfxName3", pfx.get(2).getName());
		assertEquals("pfxPosition3", pfx.get(2).getPosition());
		assertTrue(pfx.get(2).isAttached());

		var pfxStop = anims.get(1).getParticleEffectsStop();
		assertEquals(1, pfxStop.size());
		assertEquals(8, pfxStop.get(0).getFrame());
		assertEquals(992, pfxStop.get(0).getIndex());

		var morph = anims.get(1).getMorphAnimations();
		assertEquals(2, morph.size());
		assertEquals(9, morph.get(0).getFrame());
		assertEquals("mmAni1", morph.get(0).getAnimation());
		assertEquals("", morph.get(0).getNode());
		assertEquals(10, morph.get(1).getFrame());
		assertEquals("mmAni2", morph.get(1).getAnimation());
		assertEquals("mmNode", morph.get(1).getNode());

		var tremors = anims.get(1).getCameraTremors();
		assertEquals(1, tremors.size());
		assertEquals(11, tremors.get(0).getFrame());
		assertEquals(881, tremors.get(0).getField1());
		assertEquals(882, tremors.get(0).getField2());
		assertEquals(883, tremors.get(0).getField3());
		assertEquals(884, tremors.get(0).getField4());

		var blends = script.getAnimationBlends();
		assertEquals(3, blends.size());
		assertEquals("blendName1", blends.get(0).getName());
		assertEquals("blendNext1", blends.get(0).getNext());
		assertEquals("blendName2", blends.get(1).getName());
		assertEquals("blendNext2", blends.get(1).getNext());
		assertEquals("blendName3", blends.get(2).getName());
		assertEquals("blendNext3", blends.get(2).getNext());
		assertEquals(223.1f, blends.get(2).getBlendIn());
		assertEquals(333.1f, blends.get(2).getBlendOut());

		var aliases = script.getAnimationAliases();
		assertEquals(2, aliases.size());
		assertEquals("aliasName1", aliases.get(0).getName());
		assertEquals(114, aliases.get(0).getLayer());
		assertEquals("aliasNext1", aliases.get(0).getNext());
		assertEquals(100.1f, aliases.get(0).getBlendIn());
		assertEquals(200.2f, aliases.get(0).getBlendOut());
		assertEquals(AnimationFlag.ROTATE | AnimationFlag.QUEUE, aliases.get(0).getFlags());
		assertEquals("aliasAlias1", aliases.get(0).getAlias());
		assertEquals(AnimationDirection.FORWARD, aliases.get(0).getDirection());
		assertEquals("aliasName2", aliases.get(1).getName());
		assertEquals(115, aliases.get(1).getLayer());
		assertEquals("aliasNext2", aliases.get(1).getNext());
		assertEquals(101.1f, aliases.get(1).getBlendIn());
		assertEquals(201.2f, aliases.get(1).getBlendOut());
		assertEquals(AnimationFlag.FLY, aliases.get(1).getFlags());
		assertEquals("aliasAlias2", aliases.get(1).getAlias());
		assertEquals(AnimationDirection.BACKWARD, aliases.get(1).getDirection());

		var combines = script.getAnimationCombines();
		assertEquals(2, combines.size());
		assertEquals("combName1", combines.get(0).getName());
		assertEquals(116, combines.get(0).getLayer());
		assertEquals("combNext1", combines.get(0).getNext());
		assertEquals(102.1f, combines.get(0).getBlendIn());
		assertEquals(202.2f, combines.get(0).getBlendOut());
		assertEquals(AnimationFlag.MOVE, combines.get(0).getFlags());
		assertEquals("combModel1", combines.get(0).getModel());
		assertEquals(226, combines.get(0).getLastFrame());
		assertEquals("combName2", combines.get(1).getName());
		assertEquals(117, combines.get(1).getLayer());
		assertEquals("combNext2", combines.get(1).getNext());
		assertEquals(103.1f, combines.get(1).getBlendIn());
		assertEquals(203.2f, combines.get(1).getBlendOut());
		assertEquals(AnimationFlag.IDLE, combines.get(1).getFlags());
		assertEquals("combModel2", combines.get(1).getModel());
		assertEquals(227, combines.get(1).getLastFrame());

		var disabled = script.getDisabledAnimations();
		assertEquals(2, disabled.size());
		assertEquals("disable1", disabled.get(0));
		assertEquals("disable2", disabled.get(1));

		var tags = script.getModelTags();
		assertEquals(2, tags.size());
		assertEquals("tag1", tags.get(0));
		assertEquals("tag2", tags.get(1));
	}
}
