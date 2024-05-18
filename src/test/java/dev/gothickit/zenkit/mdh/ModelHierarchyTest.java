package dev.gothickit.zenkit.mdh;

import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
import dev.gothickit.zenkit.ResourceIOException;
import dev.gothickit.zenkit.Util;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModelHierarchyTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void load() throws ResourceIOException {
		var mdh = ModelHierarchy.load(Util.getResource("hierarchy0.mdh"));
		var mdhNodes = mdh.nodes();

		assertEquals(7, mdh.nodeCount());
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

		node = mdh.node(1);
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

		assertEquals(-497.17572f, mdh.bbox().min.x);
		assertEquals(-0.575592041f, mdh.bbox().min.y);
		assertEquals(-105.896698f, mdh.bbox().min.z);
		assertEquals(515.717346f, mdh.bbox().max.x);
		assertEquals(364.943878f, mdh.bbox().max.y);
		assertEquals(893.536743f, mdh.bbox().max.z);

		assertEquals(-248.58786f, mdh.collisionBbox().min.x);
		assertEquals(-0.402914435f, mdh.collisionBbox().min.y);
		assertEquals(-52.948349f, mdh.collisionBbox().min.z);
		assertEquals(257.858673f, mdh.collisionBbox().max.x);
		assertEquals(291.955109f, mdh.collisionBbox().max.y);
		assertEquals(446.768372f, mdh.collisionBbox().max.z);

		assertEquals(-0.f, mdh.rootTranslation().x);
		assertEquals(0, mdh.rootTranslation().y);
		assertEquals(-394.040466f, mdh.rootTranslation().z);
		assertEquals(965956401, mdh.checksum());
		assertEquals(
				"\\_WORK\\DATA\\ANIMS\\\\_WORK\\DATA\\ANIMS\\ASC_MOBSI\\ANIMATED\\STONEMILL_OM.ASC",
				mdh.sourcePath()
		);
	}
}