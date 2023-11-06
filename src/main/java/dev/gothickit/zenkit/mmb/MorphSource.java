package dev.gothickit.zenkit.mmb;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;

import java.util.Calendar;

public class MorphSource {
	private final Pointer handle;

	public MorphSource(Pointer handle) {
		this.handle = handle;
	}

	public String getFileName() {
		return ZenKit.API.ZkMorphSource_getFileName(handle);
	}

	public Calendar getFileDate() {
		return ZenKit.API.ZkMorphSource_getFileDate(handle).toCalendar();
	}
}
