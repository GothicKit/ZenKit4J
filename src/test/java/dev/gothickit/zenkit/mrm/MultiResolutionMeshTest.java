package dev.gothickit.zenkit.mrm;

import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MultiResolutionMeshTest {
	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	private void checkVec3(@NotNull Vec3f v, float x, float y, float z) {
		assertEquals(x, v.x);
		assertEquals(y, v.y);
		assertEquals(z, v.z);
	}

	private void checkTriangle(@NotNull MeshTriangle tri, int a, int b, int c) {
		assertEquals(tri.wedge0, a);
		assertEquals(tri.wedge1, b);
		assertEquals(tri.wedge2, c);
	}

	private void checkWedge(@NotNull MeshWedge tri, float nx, float ny, float nz, float tx, float ty, int i) {
		assertEquals(tri.normal.x, nx);
		assertEquals(tri.normal.y, ny);
		assertEquals(tri.normal.z, nz);
		assertEquals(tri.texture.x, tx);
		assertEquals(tri.texture.y, ty);
		assertEquals(tri.index, i);
	}

	private void checkPlane(@NotNull MeshPlane plane, float d, float nx, float ny, float nz) {
		assertEquals(plane.distance, d);
		assertEquals(plane.normal.x, nx);
		assertEquals(plane.normal.y, ny);
		assertEquals(plane.normal.z, nz);
	}

	@Test
	void load() throws ResourceIOException {
		var mrm = MultiResolutionMesh.load(Util.getResource("mesh0.mrm"));
		var positions = mrm.positions();
		assertEquals(8, positions.length);
		checkVec3(positions[0], 200, 398.503906f, 200);
		checkVec3(positions[1], -200, 398.503906f, 200);
		checkVec3(positions[7], -200, 0, -200);

		var normals = mrm.normals();
		assertEquals(0, normals.length);

		assertTrue(mrm.alphaTest());
		checkVec3(mrm.bbox().min, -200, 0, -200);
		checkVec3(mrm.bbox().max, 200, 398.503906f, 200);

		var subMeshes = mrm.subMeshes();
		assertEquals(1, subMeshes.size());

		var subMesh = subMeshes.get(0);
		assertEquals("EVT_TPL_GITTERKAEFIG_01", subMesh.material().name());
		assertEquals("OCODFLGATELI.TGA", subMesh.material().texture());
		assertEquals(0, subMesh.colors().length);
		assertEquals(0, subMesh.triangleEdges().length);
		assertEquals(0, subMesh.edgeScores().length);
		assertEquals(0, subMesh.edges().length);

		var triangles = subMesh.triangles();
		assertEquals(16, triangles.length);
		checkTriangle(triangles[0], 26, 19, 12);
		checkTriangle(triangles[1], 8, 13, 18);
		checkTriangle(triangles[14], 2, 6, 29);
		checkTriangle(triangles[15], 28, 20, 3);

		var wedges = subMesh.wedges();
		assertEquals(32, wedges.length);
		checkWedge(wedges[0], 0, 0, -1, -1.50000048f, -1.49251938f, 4);
		checkWedge(wedges[1], -1, 0, 0, 2.49999952f, -1.49251938f, 4);
		checkWedge(wedges[31], 0, 0, -1, -1.50000048f, 2.49251938f, 7);

		var tpi = subMesh.trianglePlaneIndices();
		assertEquals(16, tpi.length);
		assertEquals(0, tpi[0]);
		assertEquals(1, tpi[1]);
		assertEquals(7, tpi[14]);
		assertEquals(5, tpi[15]);

		var tp = subMesh.trianglePlanes();
		assertEquals(8, tp.length);
		checkPlane(tp[0], 200, 1, -0.0f, 0);
		checkPlane(tp[1], 200, 0, 0, 1);
		checkPlane(tp[6], 200, 0, 0, -1);
		checkPlane(tp[7], -200, 0, 0, 1);

		var wedgeMap = subMesh.wedgeMap();
		assertEquals(32, wedgeMap.length);
		assertEquals(-1, wedgeMap[0]);
		assertEquals(-1, wedgeMap[1]);
		assertEquals(2, wedgeMap[29]);
		assertEquals(1, wedgeMap[30]);
		assertEquals(0, wedgeMap[31]);
	}
}