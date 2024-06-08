package dev.gothickit.zenkit.mds;

import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
import dev.gothickit.zenkit.ResourceIOException;
import dev.gothickit.zenkit.Util;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ModelScriptTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void load() throws ResourceIOException {
		var script = ModelScript.load(Util.getResource("waran.mds"));

		assertTrue(script.skeletonMeshDisabled());
		assertEquals("TestModelMesh.asc", script.skeletonName());

		var anims = script.animations();
		assertEquals(2, anims.size());
		assertEquals("aniName1", anims.get(0).name());
		assertEquals(111, anims.get(0).layer());
		assertEquals("aniNext1", anims.get(0).next());
		assertEquals(4.2f, anims.get(0).blendIn());
		assertEquals(0.5f, anims.get(0).blendOut());
		assertTrue(anims.get(0).flags().containsAll(Set.of(AnimationFlag.MOVE, AnimationFlag.IDLE)));
		assertEquals("aniModel1", anims.get(0).model());
		assertEquals(AnimationDirection.FORWARD, anims.get(0).direction());
		assertEquals(221, anims.get(0).firstFrame());
		assertEquals(-331, anims.get(0).lastFrame());
		assertEquals(25.0f, anims.get(0).fps());
		assertEquals(0.0f, anims.get(0).speed());
		assertEquals(0.2f, anims.get(0).collisionVolumeScale());
		assertEquals(0, anims.get(0).particleEffects().size());
		assertEquals(0, anims.get(0).particleEffectsStop().size());
		assertEquals(0, anims.get(0).soundEffects().size());
		assertEquals(0, anims.get(0).soundEffectsGround().size());
		assertEquals(0, anims.get(0).eventTags().size());
		assertEquals(0, anims.get(0).morphAnimations().size());
		assertEquals(0, anims.get(0).cameraTremors().size());
		assertEquals(0, anims.get(0).particleEffectCount());
		assertEquals(0, anims.get(0).particleEffectStopCount());
		assertEquals(0, anims.get(0).soundEffectCount());
		assertEquals(0, anims.get(0).soundEffectGroundCount());
		assertEquals(0, anims.get(0).eventTagCount());
		assertEquals(0, anims.get(0).morphAnimationCount());
		assertEquals(0, anims.get(0).cameraTremorCount());

		assertEquals("aniName2", anims.get(1).name());
		assertEquals(112, anims.get(1).layer());
		assertEquals("aniNext2", anims.get(1).next());
		assertEquals(9.0f, anims.get(1).blendIn());
		assertEquals(0.0f, anims.get(1).blendOut());
		assertTrue(anims.get(1).flags().contains(AnimationFlag.MOVE));
		assertEquals("aniModel2", anims.get(1).model());
		assertEquals(AnimationDirection.BACKWARD, anims.get(1).direction());
		assertEquals(222, anims.get(1).firstFrame());
		assertEquals(332, anims.get(1).lastFrame());
		assertEquals(25.0f, anims.get(1).fps());
		assertEquals(0.0f, anims.get(1).speed());
		assertEquals(1.0f, anims.get(1).collisionVolumeScale());

		var events = anims.get(1).eventTags();
		assertEquals(3, events.size());
		assertEquals(0, events.get(0).frame());
		assertEquals(EventType.TORCH_DROP, events.get(0).type());
		assertTrue(events.get(0).isAttached());
		assertEquals(1, events.get(1).frame());
		assertEquals(EventType.COMBO_WINDOW, events.get(1).type());
		assertFalse(events.get(1).isAttached());
		assertEquals(0, events.get(2).frame());
		assertEquals(EventType.ITEM_CREATE, events.get(2).type());
		assertEquals("eventSlot", events.get(2).slot(0));
		assertEquals("eventItem", events.get(2).item());
		assertFalse(events.get(2).isAttached());
		assertEquals(1, events.get(1).frames()[0]);
		assertEquals(2, events.get(1).frames()[1]);
		assertEquals(3, events.get(1).frames()[2]);
		assertEquals(4, events.get(1).frames()[3]);
		assertEquals(5, events.get(1).frames()[4]);

		var sfx = anims.get(1).soundEffects();
		assertEquals(3, sfx.size());
		assertEquals(3, sfx.get(0).frame());
		assertEquals("sfxName1", sfx.get(0).name());
		assertTrue(sfx.get(0).emptySlot());
		assertEquals(4, sfx.get(1).frame());
		assertEquals("sfxName2", sfx.get(1).name());
		assertEquals(67.4f, sfx.get(1).range());
		assertFalse(sfx.get(1).emptySlot());

		var sfxGround = anims.get(1).soundEffectsGround();
		assertEquals(1, sfxGround.size());
		assertEquals(5, sfxGround.get(0).frame());
		assertEquals("sfxGrndName", sfxGround.get(0).name());
		assertFalse(sfxGround.get(0).emptySlot());

		var pfx = anims.get(1).particleEffects();
		assertEquals(3, pfx.size());
		assertEquals(6, pfx.get(0).frame());
		assertEquals(0, pfx.get(0).index());
		assertEquals("pfxName1", pfx.get(0).name());
		assertEquals("pfxPosition1", pfx.get(0).position());
		assertTrue(pfx.get(0).isAttached());
		assertEquals(7, pfx.get(1).frame());
		assertEquals(991, pfx.get(1).index());
		assertEquals("pfxName2", pfx.get(1).name());
		assertEquals("pfxPosition2", pfx.get(1).position());
		assertFalse(pfx.get(1).isAttached());
		assertEquals(9, pfx.get(2).frame());
		assertEquals(991, pfx.get(2).index());
		assertEquals("pfxName3", pfx.get(2).name());
		assertEquals("pfxPosition3", pfx.get(2).position());
		assertTrue(pfx.get(2).isAttached());

		var pfxStop = anims.get(1).particleEffectsStop();
		assertEquals(1, pfxStop.size());
		assertEquals(8, pfxStop.get(0).frame());
		assertEquals(992, pfxStop.get(0).index());

		var morph = anims.get(1).morphAnimations();
		assertEquals(2, morph.size());
		assertEquals(9, morph.get(0).frame());
		assertEquals("mmAni1", morph.get(0).animation());
		assertEquals("", morph.get(0).node());
		assertEquals(10, morph.get(1).frame());
		assertEquals("mmAni2", morph.get(1).animation());
		assertEquals("mmNode", morph.get(1).node());

		var tremors = anims.get(1).cameraTremors();
		assertEquals(1, tremors.size());
		assertEquals(11, tremors.get(0).frame());
		assertEquals(881, tremors.get(0).field1());
		assertEquals(882, tremors.get(0).field2());
		assertEquals(883, tremors.get(0).field3());
		assertEquals(884, tremors.get(0).field4());

		var blends = script.animationBlends();
		assertEquals(3, blends.size());
		assertEquals("blendName1", blends.get(0).name());
		assertEquals("blendNext1", blends.get(0).next());
		assertEquals("blendName2", blends.get(1).name());
		assertEquals("blendNext2", blends.get(1).next());
		assertEquals("blendName3", blends.get(2).name());
		assertEquals("blendNext3", blends.get(2).next());
		assertEquals(223.1f, blends.get(2).blendIn());
		assertEquals(333.1f, blends.get(2).blendOut());

		var aliases = script.animationAliases();
		assertEquals(2, aliases.size());
		assertEquals("aliasName1", aliases.get(0).name());
		assertEquals(114, aliases.get(0).layer());
		assertEquals("aliasNext1", aliases.get(0).next());
		assertEquals(100.1f, aliases.get(0).blendIn());
		assertEquals(200.2f, aliases.get(0).blendOut());
		assertTrue(aliases.get(0).flags().containsAll(Set.of(AnimationFlag.ROTATE, AnimationFlag.QUEUE)));
		assertEquals("aliasAlias1", aliases.get(0).alias());
		assertEquals(AnimationDirection.FORWARD, aliases.get(0).direction());
		assertEquals("aliasName2", aliases.get(1).name());
		assertEquals(115, aliases.get(1).layer());
		assertEquals("aliasNext2", aliases.get(1).next());
		assertEquals(101.1f, aliases.get(1).blendIn());
		assertEquals(201.2f, aliases.get(1).blendOut());
		assertTrue(aliases.get(1).flags().contains(AnimationFlag.FLY));
		assertEquals("aliasAlias2", aliases.get(1).alias());
		assertEquals(AnimationDirection.BACKWARD, aliases.get(1).direction());

		var combines = script.animationCombines();
		assertEquals(2, combines.size());
		assertEquals("combName1", combines.get(0).name());
		assertEquals(116, combines.get(0).layer());
		assertEquals("combNext1", combines.get(0).next());
		assertEquals(102.1f, combines.get(0).blendIn());
		assertEquals(202.2f, combines.get(0).blendOut());
		assertTrue(combines.get(0).flags().contains(AnimationFlag.MOVE));
		assertEquals("combModel1", combines.get(0).model());
		assertEquals(226, combines.get(0).lastFrame());
		assertEquals("combName2", combines.get(1).name());
		assertEquals(117, combines.get(1).layer());
		assertEquals("combNext2", combines.get(1).next());
		assertEquals(103.1f, combines.get(1).blendIn());
		assertEquals(203.2f, combines.get(1).blendOut());
		assertTrue(combines.get(1).flags().contains(AnimationFlag.IDLE));
		assertEquals("combModel2", combines.get(1).model());
		assertEquals(227, combines.get(1).lastFrame());

		var disabled = script.disabledAnimations();
		assertEquals(2, disabled.size());
		assertEquals("disable1", disabled.get(0));
		assertEquals("disable2", disabled.get(1));

		var tags = script.modelTags();
		assertEquals(2, tags.size());
		assertEquals("tag1", tags.get(0));
		assertEquals("tag2", tags.get(1));
	}
}
