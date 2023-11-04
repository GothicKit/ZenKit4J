package dev.gothickit.zenkit.mdh;

import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
import dev.gothickit.zenkit.Util;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelHierarchyTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void load() {
		var mdh = new ModelHierarchy(Util.getResource("hierarchy0.mdh"));
		var mdhNodes = mdh.getNodes();

		assertEquals(7, mdh.getNodeCount());
		assertEquals(7, mdhNodes.size());

		var node = mdhNodes.get(0);
		assertEquals("BIP01 MUEHLE", node.name);
		assertEquals(-1, node.parentIndex);
		assertEquals(-1, node.transform.m00);
		assertEquals(0, node.transform.m01);
		assertEquals(0, node.transform.m02);
		assertEquals(0, node.transform.m03);
		assertEquals(0, node.transform.m10);
		assertEquals(1, node.transform.m11);
		assertEquals(0, node.transform.m12);
		assertEquals(0, node.transform.m13);
		assertEquals(0, node.transform.m20);
		assertEquals(0, node.transform.m21);
		assertEquals(-1, node.transform.m22);
		assertEquals(0, node.transform.m23);
		assertEquals(0, node.transform.m30);
		assertEquals(0, node.transform.m31);
		assertEquals(0, node.transform.m32);
		assertEquals(1, node.transform.m33);

		node = mdh.getNode(1);
		assertEquals("BIP01 NABE", node.name);
		assertEquals(0, node.parentIndex);
		assertEquals(1, node.transform.m00);
		assertEquals(0, node.transform.m01);
		assertEquals(0, node.transform.m02);
		assertEquals(0, node.transform.m03);
		assertEquals(0, node.transform.m10);
		assertEquals(1, node.transform.m11);
		assertEquals(-0.0f, node.transform.m12);
		assertEquals(0, node.transform.m13);
		assertEquals(0, node.transform.m20);
		assertEquals(0, node.transform.m21);
		assertEquals(1, node.transform.m22);
		assertEquals(0, node.transform.m23);
		assertEquals(0, node.transform.m30);
		assertEquals(0, node.transform.m31);
		assertEquals(-394.040466f, node.transform.m32);
		assertEquals(1, node.transform.m33);

		assertEquals(-497.17572f, mdh.getBbox().min.x);
		assertEquals(-0.575592041f, mdh.getBbox().min.y);
		assertEquals(-105.896698f, mdh.getBbox().min.z);
		assertEquals(515.717346f, mdh.getBbox().max.x);
		assertEquals(364.943878f, mdh.getBbox().max.y);
		assertEquals(893.536743f, mdh.getBbox().max.z);

		assertEquals(-248.58786f, mdh.getCollisionBbox().min.x);
		assertEquals(-0.402914435f, mdh.getCollisionBbox().min.y);
		assertEquals(-52.948349f, mdh.getCollisionBbox().min.z);
		assertEquals(257.858673f, mdh.getCollisionBbox().max.x);
		assertEquals(291.955109f, mdh.getCollisionBbox().max.y);
		assertEquals(446.768372f, mdh.getCollisionBbox().max.z);

		assertEquals(-0.f, mdh.getRootTranslation().x);
		assertEquals(0, mdh.getRootTranslation().y);
		assertEquals(-394.040466f, mdh.getRootTranslation().z);
		assertEquals(965956401, mdh.getChecksum());
		assertEquals("\\_WORK\\DATA\\ANIMS\\\\_WORK\\DATA\\ANIMS\\ASC_MOBSI\\ANIMATED\\STONEMILL_OM.ASC", mdh.getSourcePath());
	}
}