package dev.gothickit.zenkit.world;

import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.bsp.BinarySpacePartitionType;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.mat.MaterialGroup;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorldTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	private void checkVec2(Vec2f v, float x, float y) {
		assertEquals(x, v.x);
		assertEquals(y, v.y);
	}

	private void checkVec3(Vec3f v, float x, float y, float z) {
		assertEquals(x, v.x);
		assertEquals(y, v.y);
		assertEquals(z, v.z);
	}

	@Test
	void load() throws ResourceIOException {
		var wld = World.load(Util.getResource("world.proprietary.zen"));

		var mesh = wld.getMesh();
		var feats = mesh.vertices();
		assertEquals(mesh.positions().length, 55439);
		assertEquals(feats.length, 419936);
		assertEquals(mesh.materials().size(), 2263);
		assertEquals(mesh.name(), "");

		var box0 = mesh.boundingBox();
		checkVec3(box0.min, 0, 0, 0);
		checkVec3(box0.max, 0, 0, 0);

		var obb = mesh.orientedBoundingBox();
		checkVec3(obb.center(), 0, 0, 0);
		checkVec3(obb.axes()[0], 0, 0, 0);
		checkVec3(obb.axes()[1], 0, 0, 0);
		checkVec3(obb.axes()[2], 0, 0, 0);
		checkVec3(obb.halfWidth(), 0, 0, 0);

		var verts = mesh.positions();
		checkVec3(verts[0], 91365, -4026.60083f, 46900);
		checkVec3(verts[1], 92900, -4029.99976f, 38399.9961f);
		checkVec3(verts[500], 44263.8203f, 708.517822f, 6841.18262f);
		checkVec3(verts[501], 45672.6094f, 640.436157f, 6877.81543f);

		checkVec2(feats[0].texture, 1.11193848f, 2.64415169f);
		checkVec3(feats[0].normal, 0.0000220107158f, 1, -0.000121058853f);
		assertEquals(feats[0].light, -2039584);

		checkVec2(feats[1].texture, -0.371101379f, -0.909111022f);
		checkVec3(feats[1].normal, 0.0000251403726f, 1, -0.000138271935f);
		assertEquals(feats[1].light, -2039584);

		checkVec2(feats[500].texture, -0.524971008f, 2.59478664f);
		checkVec3(feats[500].normal, -0.000046945388f, -0.99999994f, 0.000258200336f);
		assertEquals(feats[500].light, -13882324);

		checkVec2(feats[501].texture, 1.93376923f, -0.734043121f);
		checkVec3(feats[501].normal, 0.000102534526f, -1, -0.00014051389f);
		assertEquals(feats[501].light, -13882324);

		var mats = mesh.materials();
		var mat0 = mats.get(0);
		var mat500 = mats.get(500);

		assertEquals(mat0.name(), "OWODWATSTOP");
		assertEquals(mat0.group(), MaterialGroup.WATER);
		assertEquals(mat0.texture(), "OWODSEA_A0.TGA");

		assertEquals(mat500.name(), "OMWABROWNGREEN01");
		assertEquals(mat500.group(), MaterialGroup.STONE);
		assertEquals(mat500.texture(), "OMWABROWNGREEN01.TGA");

		// Check the BSP tree
		var tree = wld.getBspTree();
		assertEquals(tree.type(), BinarySpacePartitionType.OUTDOOR);

		var treePolys = tree.polygonIndices();
		assertEquals(treePolys.length, 480135);
		assertEquals(treePolys[0], 0);
		assertEquals(treePolys[1], 1);
		assertEquals(treePolys[2], 2);
		assertEquals(treePolys[150], 102);
		assertEquals(treePolys[151], 103);
		assertEquals(treePolys[152], 92);

		var nodes = tree.nodes();
		assertEquals(nodes.length, 6644);
		assertEquals(nodes[0].plane.x, 1);
		assertEquals(nodes[0].plane.y, 0);
		assertEquals(nodes[0].plane.z, 0);
		assertEquals(nodes[0].plane.w, 18540.0156f);
		assertEquals(nodes[0].frontIndex, 1);
		assertEquals(nodes[0].parentIndex, -1);
		assertEquals(nodes[0].backIndex, 1599);
		assertEquals(nodes[0].polygonIndex, 0);
		assertEquals(nodes[0].polygonCount, 0);
		checkVec3(nodes[0].bbox.min, -71919.9609f, -12000, -59900);
		checkVec3(nodes[0].bbox.max, 108999.992f, 20014.0371f, 67399.9921f);

		assertEquals(nodes[1].plane.x, 0);
		assertEquals(nodes[1].plane.y, 0);
		assertEquals(nodes[1].plane.z, 1);
		assertEquals(nodes[1].plane.w, 3749.99609f);
		assertEquals(nodes[1].frontIndex, 2);
		assertEquals(nodes[1].parentIndex, 0);
		assertEquals(nodes[1].backIndex, 445);
		assertEquals(nodes[1].polygonIndex, 0);
		assertEquals(nodes[1].polygonCount, 0);
		checkVec3(nodes[1].bbox.min, 15499.999f, -12000, -59900);
		checkVec3(nodes[1].bbox.max, 108999.992f, 19502.1973f, 67399.9921f);

		var leaves = tree.leafNodeIndices();
		assertEquals(leaves.length, 3318);
		assertEquals(leaves[0], 5);
		assertEquals(leaves[10], 26);

		var sectors = tree.sectors();
		assertEquals(sectors.size(), 299);

		assertEquals(sectors.get(0).name(), "WALD11");
		assertEquals(sectors.get(0).nodeIndices().length, 9);
		assertEquals(sectors.get(0).portalPolygonIndices().length, 24);

		assertEquals(sectors.get(50).name(), "OWCAVE01");
		assertEquals(sectors.get(50).nodeIndices().length, 4);
		assertEquals(sectors.get(50).portalPolygonIndices().length, 2);

		var portalPolys = tree.portalPolygonIndices();
		assertEquals(portalPolys.length, 0);

		assertEquals(tree.lightPoints().length, 3318);
		checkVec3(tree.lightPoints()[0], -99, -99, -99);

		// TODO(lmichaelis): Check the VOb tree
		/*
		auto& vobs = wld.world_vobs;
		assertEquals(vobs.size(), 14);

		auto& vob0 = vobs[0];
		auto& vob13 = vobs[13];

		{
			box0 = vob0->bbox;
			assertEquals(box0.min, -71919.9609, -13091.8232, -59900);
			assertEquals(box0.max, 108999.992, 20014.0352, 67399.9921);

			auto mat = vob0->rotation;
			assertEquals(mat[0][0], 1.0f);
			assertEquals(mat[1][0], 0.0f);
			assertEquals(mat[2][0], 0.0f);
			assertEquals(mat[0][1], 0.0f);
			assertEquals(mat[1][1], 1.0f);
			assertEquals(mat[2][1], 0.0f);
			assertEquals(mat[0][2], 0.0f);
			assertEquals(mat[1][2], 0.0f);
			assertEquals(mat[2][2], 1.0f);

			assertEquals(vob0->vob_name, "LEVEL-VOB");
			assertEquals(vob0->visual_name, "SURFACE.3DS");
			CHECK(vob0->preset_name.empty());
			assertEquals(vob0->position, 0, 0, 0);
			CHECK_FALSE(vob0->show_visual);
			assertEquals(vob0->sprite_camera_facing_mode, zenkit::SpriteAlignment::NONE);
			assertEquals(vob0->anim_mode, zenkit::AnimationType::NONE);
			assertEquals(vob0->anim_strength, 0.0f);
			assertEquals(vob0->far_clip_scale, 0.0f);
			CHECK(vob0->cd_static);
			CHECK_FALSE(vob0->cd_dynamic);
			CHECK_FALSE(vob0->vob_static);
			assertEquals(vob0->dynamic_shadows, zenkit::ShadowType::NONE);
			assertEquals(vob0->bias, 0);
			CHECK_FALSE(vob0->ambient);
			CHECK_FALSE(vob0->physics_enabled);

			auto& children = vob0->children;
			assertEquals(children.size(), 7496);

			auto& child1 = children[0];

			{
				auto box1 = child1->bbox;
				assertEquals(box1.min, -18596.9004, -161.17189, 4091.1333);
				assertEquals(box1.max, -18492.0723, -111.171906, 4191.26221);

				auto matc = child1->rotation;
				assertEquals(matc[0][0], -0.779196978f);
				assertEquals(matc[1][0], 0.0f);
				assertEquals(matc[2][0], 0.626779079f);

				assertEquals(matc[0][1], 0.0f);
				assertEquals(matc[1][1], 1.0f);
				assertEquals(matc[2][1], 0.0f);

				assertEquals(matc[0][2], -0.626779079f);
				assertEquals(matc[1][2], 0.0f);
				assertEquals(matc[2][2], -0.779196978f);

				assertEquals(child1->vob_name, "FP_CAMPFIRE_PATH_BANDITOS2_03_02");
				CHECK(child1->visual_name.empty());
				CHECK(child1->preset_name.empty());
				assertEquals(child1->position, -18544.4863, -136.171906, 4141.19727);
				CHECK_FALSE(child1->show_visual);
				assertEquals(child1->sprite_camera_facing_mode, zenkit::SpriteAlignment::NONE);
				assertEquals(child1->anim_mode, zenkit::AnimationType::NONE);
				assertEquals(child1->anim_strength, 0.0f);
				assertEquals(child1->far_clip_scale, 0.0f);
				CHECK_FALSE(child1->cd_static);
				CHECK_FALSE(child1->cd_dynamic);
				CHECK_FALSE(child1->vob_static);
				assertEquals(child1->dynamic_shadows, zenkit::ShadowType::NONE);
				assertEquals(child1->bias, 0);
				CHECK_FALSE(child1->ambient);
				CHECK_FALSE(child1->physics_enabled);

				CHECK(child1->children.empty());
			}
		}

		{
			auto box2 = vob13->bbox;
			assertEquals(box2.min, -9999.40234, -10000.0039, -9200);
			assertEquals(box2.max, 9060.59765, 5909.90039, 7537.47461);

			auto mat = vob13->rotation;
			assertEquals(mat[0][0], 1.0f);
			assertEquals(mat[1][0], 0.0f);
			assertEquals(mat[2][0], 0.0f);
			assertEquals(mat[0][1], 0.0f);
			assertEquals(mat[1][1], 1.0f);
			assertEquals(mat[2][1], 0.0f);
			assertEquals(mat[0][2], 0.0f);
			assertEquals(mat[1][2], 0.0f);
			assertEquals(mat[2][2], 1.0f);

			assertEquals(vob13->vob_name, "LEVEL-VOB");
			assertEquals(vob13->visual_name, "OLDCAMP.3DS");
			CHECK(vob13->preset_name.empty());
			assertEquals(vob13->position, 0, 0, 0);
			CHECK_FALSE(vob13->show_visual);
			assertEquals(vob13->sprite_camera_facing_mode, zenkit::SpriteAlignment::NONE);
			assertEquals(vob13->anim_mode, zenkit::AnimationType::NONE);
			assertEquals(vob13->anim_strength, 0.0f);
			assertEquals(vob13->far_clip_scale, 0.0f);
			CHECK_FALSE(vob13->cd_static);
			CHECK_FALSE(vob13->cd_dynamic);
			CHECK_FALSE(vob13->vob_static);
			assertEquals(vob13->dynamic_shadows, zenkit::ShadowType::NONE);
			assertEquals(vob13->bias, 0);
			CHECK_FALSE(vob13->ambient);
			CHECK_FALSE(vob13->physics_enabled);

			auto& children = vob13->children;
			assertEquals(children.size(), 3250);
		}
		*/

		// Check the waynet

		var waynet = wld.getWayNet();
		var points = waynet.points();
		assertEquals(points.size(), 2784);
		assertEquals(waynet.edges().length, 3500);

		var wp0 = points.get(0);
		var wp100 = points.get(100);

		assertEquals(wp0.name(), "LOCATION_28_07");
		assertEquals(wp0.waterDepth(), 0);
		assertFalse(wp0.underWater());
		checkVec3(wp0.position(), 23871.457f, -553.283813f, 27821.3516f);
		checkVec3(wp0.direction(), 0.86651814f, 0, -0.499145567f);
		assertTrue(wp0.freePoint());

		assertEquals(wp100.name(), "CASTLE_MOVEMENT_STRAIGHT3");
		assertEquals(wp100.waterDepth(), 0);
		assertFalse(wp100.underWater());
		checkVec3(wp100.position(), 3362.21948f, 8275.1709f, -21067.9473f);
		checkVec3(wp100.direction(), -0.342115372f, 0, 0.939657927f);
		assertFalse(wp100.freePoint());

		var edges = waynet.edges();
		var edge0 = edges[0];
		var edge5 = edges[5];
		var edge100 = edges[100];
		var edge500 = edges[500];

		assertEquals(edge0.a, 20);
		assertEquals(edge0.b, 21);

		// edge 6 is a reference
		assertEquals(edge5.a, 28);
		assertEquals(edge5.b, 30);

		assertEquals(edge100.a, 123);
		assertEquals(edge100.b, 126);

		assertEquals(edge500.a, 521);
		assertEquals(edge500.b, 515);
	}
}