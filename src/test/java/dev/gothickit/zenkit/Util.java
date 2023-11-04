package dev.gothickit.zenkit;

import dev.gothickit.zenkit.capi.ZenKit;

import java.io.*;
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
