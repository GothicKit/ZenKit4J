package dev.gothickit.zenkit.capi;

import com.sun.jna.Library;
import com.sun.jna.Native;

import java.lang.ref.Cleaner;
import java.util.HashMap;

public final class ZenKit {
	public static final Cleaner CLEANER = Cleaner.create();
	public static ZenKitNative API;

	public static ZenKitNative load(String encoding, String lib) {
		var options = new HashMap<String, Object>();
		options.put(Library.OPTION_TYPE_MAPPER, new ZenKitTypeMapper());
		options.put(Library.OPTION_STRING_ENCODING, encoding);
		return Native.load(lib, ZenKitNative.class, options);
	}

	public static ZenKitNative load(String encoding) {
		if (API == null) API = load(encoding, "zenkitcapi");
		return API;
	}

	public static ZenKitNative load() {
		return load("Windows-1252");
	}

	public static void unload() {
		API = null;
	}
}
