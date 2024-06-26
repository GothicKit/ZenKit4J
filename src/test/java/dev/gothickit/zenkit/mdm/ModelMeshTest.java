package dev.gothickit.zenkit.mdm;

import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelMeshTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void loadAttachments() throws ResourceIOException {
		var mdm = ModelMesh.load(Util.getResource("secretdoor.mdm"));
		var attachments = mdm.attachments();

		assertEquals(1, attachments.size());
		assertEquals(1, mdm.attachmentCount());

		assertTrue(attachments.containsKey("BIP01 DOOR"));
		assertEquals(8, attachments.get("BIP01 DOOR").positions().length);

		var fromNative = mdm.attachment("BIP01 DOOR");
		assertNotNull(fromNative);
		assertEquals(8, fromNative.positions().length);
	}

	private void checkVec3(Vec3f v, float x, float y, float z) {
		assertEquals(x, v.x);
		assertEquals(y, v.y);
		assertEquals(z, v.z);
	}

	@Test
	void load() throws ResourceIOException {
		var mdm = ModelMesh.load(Util.getResource("smoke_waterpipe.mdm"));

		var meshes = mdm.meshes();
		assertEquals(1, meshes.size());

		var rawMesh = meshes.get(0).mesh();
		assertEquals(115, rawMesh.positions().length);
		assertEquals(115, rawMesh.normals().length);
		assertEquals(1, rawMesh.materialCount());
		assertEquals(1, rawMesh.subMeshCount());

		var weights = meshes.get(0).weights();
		assertEquals(115, weights.size());
		assertEquals(1, weights.get(0).length);
		assertEquals(1.0f, weights.get(0)[0].weight);
		assertEquals(0, weights.get(0)[0].nodeIndex);
		checkVec3(weights.get(0)[0].position, -5.49776077f, 35.086731f, -2.64756012f);

		assertEquals(1, weights.get(62).length);
		assertEquals(1.0f, weights.get(62)[0].weight);
		assertEquals(4, weights.get(62)[0].nodeIndex);
		checkVec3(weights.get(62)[0].position, 0.260997772f, 18.0412712f, -23.9048882f);

		assertEquals(1, weights.get(114).length);
		assertEquals(1.0f, weights.get(114)[0].weight);
		assertEquals(0, weights.get(114)[0].nodeIndex);
		checkVec3(weights.get(114)[0].position, 1.05304337f, 71.0284958f, 1.32049942f);

		assertEquals(0, meshes.get(0).wedgeNormals().length);

		var nodes = meshes.get(0).nodes();
		assertEquals(6, nodes.length);
		assertEquals(0, nodes[0]);
		assertEquals(5, nodes[1]);
		assertEquals(3, nodes[2]);

		var bboxes = meshes.get(0).boundingBoxes();
		assertEquals(6, bboxes.size());
		checkVec3(bboxes.get(0).center(), 0.612892151f, 41.7827187f, 0.705307007f);
		checkVec3(bboxes.get(0).halfWidth(), 15.2073612f, 33.4261742f, 14.8513918f);
		checkVec3(bboxes.get(0).axes()[0], 0.777145922f, 0, -0.629320442f);
		checkVec3(bboxes.get(0).axes()[1], 0, 1, 0);
		checkVec3(bboxes.get(0).axes()[2], 0.629320442f, 0, 0.777145922f);
		assertEquals(0, bboxes.get(0).children().size());
	}
}