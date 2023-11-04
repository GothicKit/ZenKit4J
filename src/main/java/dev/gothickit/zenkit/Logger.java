package dev.gothickit.zenkit;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;

public final class Logger {
	public static void set(LogLevel lvl, Callback cb) {
		ZenKit.API.ZkLogger_set(lvl, (ctx, level, name, message) -> cb.invoke(level, name, message), Pointer.NULL);
	}

	public static void setDefault(LogLevel lvl) {
		ZenKit.API.ZkLogger_setDefault(lvl);
	}

	public static void log(LogLevel lvl, String name, String message) {
		ZenKit.API.ZkLogger_log(lvl, name, message);
	}

	public interface Callback {
		void invoke(LogLevel level, String name, String message);
	}
}
