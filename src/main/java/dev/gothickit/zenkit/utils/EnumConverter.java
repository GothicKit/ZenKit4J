package dev.gothickit.zenkit.utils;

import com.sun.jna.FromNativeContext;
import com.sun.jna.ToNativeContext;
import com.sun.jna.TypeConverter;

public class EnumConverter implements TypeConverter {
	@Override
	public Object fromNative(Object nativeValue, FromNativeContext context) {
		int i = (int) nativeValue;
		Class<?> targetClass = context.getTargetType();
		if (!EnumNative.class.isAssignableFrom(targetClass)) {
			return null;
		}

		Object[] enums = targetClass.getEnumConstants();
		assert enums.length > 0;

		// In order to avoid nasty reflective junk and to avoid needing
		// to know about every subclass of JnaEnum, we retrieve the first
		// element of the enum and make IT do the conversion for us.
		EnumNative<?> instance = (EnumNative<?>) enums[0];
		return instance.getForValue(i);
	}

	@Override
	public Object toNative(Object value, ToNativeContext context) {
		return ((EnumNative<?>) value).getIntValue();
	}

	@Override
	public Class<?> nativeType() {
		return Integer.class;
	}
}
