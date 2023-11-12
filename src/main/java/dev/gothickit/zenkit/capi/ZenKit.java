package dev.gothickit.zenkit.capi;

import com.sun.jna.Library;
import com.sun.jna.Native;

import java.lang.ref.Cleaner;
import java.util.HashMap;

public final class ZenKit {
	public static final Cleaner CLEANER = Cleaner.create();
	public static ZenKitNative API;

	public static ZenKitNative load(String lib) {
		var options = new HashMap<String, Object>();
		options.put(Library.OPTION_TYPE_MAPPER, new ZenKitTypeMapper());
		return Native.load(lib, ZenKitNative.class, options);
	}

	public static ZenKitNative load() {
		if (API == null) API = load("zenkitcapi");
		return API;
	}
}
