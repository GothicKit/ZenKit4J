package dev.gothickit.zenkit.capi;

import com.sun.jna.DefaultTypeMapper;
import dev.gothickit.zenkit.utils.EnumConverter;
import dev.gothickit.zenkit.utils.EnumNative;

public final class ZenKitTypeMapper extends DefaultTypeMapper {
	public ZenKitTypeMapper() {
		this.addTypeConverter(EnumNative.class, new EnumConverter());
	}
}
