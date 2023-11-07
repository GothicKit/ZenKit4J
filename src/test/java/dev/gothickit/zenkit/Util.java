package dev.gothickit.zenkit;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

public class Util {
	public static Read getResource(String path) {
		URL url = Thread.currentThread().getContextClassLoader().getResource(path);
		File file = new File(url.getPath());
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try (var br = new FileInputStream(file)) {
			br.transferTo(out);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return new Read(out.toByteArray());
	}
}
