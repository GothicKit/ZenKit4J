package dev.gothickit.zenkit.vfs;

import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Logger;
import dev.gothickit.zenkit.Util;
import dev.gothickit.zenkit.capi.ZenKit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VfsTest {

	private void checkContents(Vfs vfs) {
		var roots = vfs.getRoot().getChildren();
		assertEquals(3, roots.size());

		var configYml = vfs.find("config.yml");
		assertNotNull(configYml);
		assertTrue(configYml.isFile());

		var readmeMd = vfs.find("readme.md");
		assertNotNull(readmeMd);
		assertTrue(readmeMd.isFile());

		var licensesDir = vfs.find("licenses");
		assertNotNull(licensesDir);
		assertTrue(licensesDir.isDir());
		assertEquals(2, licensesDir.getChildren().size());

		var mitMd = vfs.find("MIT.MD");
		assertNotNull(mitMd);
		assertTrue(mitMd.isFile());

		var gplDir = licensesDir.getChild("gpl");
		assertNotNull(gplDir);
		assertTrue(gplDir.isDir());
		assertEquals(2, gplDir.getChildren().size());

		var lgplMd = gplDir.getChild("lgpl-3.0.md");
		assertNotNull(lgplMd);
		assertTrue(lgplMd.isFile());
		assertNull(gplDir.getChild("lgpl"));

		var gplMd = gplDir.getChild("gpl-3.0.MD");
		assertNotNull(gplMd);
		assertTrue(gplMd.isFile());

		assertNotNull(vfs.find("lGpL-3.0.Md"));
		assertNull(vfs.find("nonexistent"));
		assertNotNull(vfs.find("liceNSES"));
		assertNull(vfs.find(""));

		assertNotNull(vfs.resolve("licEnSES/GPL/gpl-3.0.md"));
		assertNull(vfs.resolve("licEnSES/GPL/nonexistent"));
		assertNotNull(vfs.resolve("/LICENSES"));
		assertNotNull(vfs.resolve(""));
		assertNotNull(vfs.resolve("/"));

		assertNotNull(vfs.find("config.yml "));
		assertNotNull(vfs.resolve("licEnSES /GPL/gpl-3.0.md "));
	}

	@BeforeAll
	static void beforeAll() {
		ZenKit.load();
		Logger.setDefault(LogLevel.DEBUG);
	}

	@Test
	void mountDisk() {
		var vfs = new Vfs();
		vfs.mountDisk(Util.getResource("basic.vdf"), VfsOverwriteBehavior.OLDER);
		checkContents(vfs);
	}
}