package dev.gothickit.zenkit.daedalus;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DaedalusSymbol implements NativeObject {
	private final Pointer handle;

	private DaedalusSymbol(Pointer handle) {
		this.handle = handle;
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable DaedalusSymbol fromNativeHandle(@Nullable Pointer handle) {
		if (handle == null) return null;
		return new DaedalusSymbol(handle);
	}

	public String getString(short index, @Nullable DaedalusInstance context) {
		return ZenKit.API.ZkDaedalusSymbol_getString(
				handle,
				index,
				context == null ? Pointer.NULL : context.getNativeHandle()
		);
	}

	public float getFloat(short index, @Nullable DaedalusInstance context) {
		return ZenKit.API.ZkDaedalusSymbol_getFloat(
				handle,
				index,
				context == null ? Pointer.NULL : context.getNativeHandle()
		);
	}

	public int getInt(short index, @Nullable DaedalusInstance context) {
		return ZenKit.API.ZkDaedalusSymbol_getInt(handle, index, context == null ? Pointer.NULL : context.getNativeHandle());
	}

	public void setString(String value, short index, @Nullable DaedalusInstance context) {
		ZenKit.API.ZkDaedalusSymbol_setString(
				handle,
				value,
				index,
				context == null ? Pointer.NULL : context.getNativeHandle()
		);
	}

	public void setFloat(float value, short index, @Nullable DaedalusInstance context) {
		ZenKit.API.ZkDaedalusSymbol_setFloat(
				handle,
				value,
				index,
				context == null ? Pointer.NULL : context.getNativeHandle()
		);
	}

	public void setInt(int value, short index, @Nullable DaedalusInstance context) {
		ZenKit.API.ZkDaedalusSymbol_setInt(handle, value, index, context == null ? Pointer.NULL : context.getNativeHandle());
	}

	public boolean isConst() {
		return ZenKit.API.ZkDaedalusSymbol_getIsConst(handle);
	}

	public boolean isMember() {
		return ZenKit.API.ZkDaedalusSymbol_getIsMember(handle);
	}

	public boolean isExternal() {
		return ZenKit.API.ZkDaedalusSymbol_getIsExternal(handle);
	}

	public boolean isMerged() {
		return ZenKit.API.ZkDaedalusSymbol_getIsMerged(handle);
	}

	public boolean isGenerated() {
		return ZenKit.API.ZkDaedalusSymbol_getIsGenerated(handle);
	}

	public boolean hasReturn() {
		return ZenKit.API.ZkDaedalusSymbol_getHasReturn(handle);
	}

	public String getName() {
		return ZenKit.API.ZkDaedalusSymbol_getName(handle);
	}

	public int getAddress() {
		return ZenKit.API.ZkDaedalusSymbol_getAddress(handle);
	}

	public int getParent() {
		return ZenKit.API.ZkDaedalusSymbol_getParent(handle);
	}

	public int getSize() {
		return ZenKit.API.ZkDaedalusSymbol_getSize(handle);
	}

	public DaedalusDataType getType() {
		return ZenKit.API.ZkDaedalusSymbol_getType(handle);
	}

	public int getIndex() {
		return ZenKit.API.ZkDaedalusSymbol_getIndex(handle);
	}

	public DaedalusDataType getReturnType() {
		return ZenKit.API.ZkDaedalusSymbol_getReturnType(handle);
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle;
	}
}
