package dev.gothickit.zenkit.daedalus;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.Nullable;

public class DaedalusSymbol {
	private final Pointer handle;


	DaedalusSymbol(Pointer handle) {
		this.handle = handle;
	}

	public String getString(short index, @Nullable DaedalusInstance context) {
		return ZenKit.API.ZkDaedalusSymbol_getString(
				handle,
				index,
				context == null ? Pointer.NULL : context.getHandle()
		);
	}

	public float getFloat(short index, @Nullable DaedalusInstance context) {
		return ZenKit.API.ZkDaedalusSymbol_getFloat(
				handle,
				index,
				context == null ? Pointer.NULL : context.getHandle()
		);
	}

	public int getInt(short index, @Nullable DaedalusInstance context) {
		return ZenKit.API.ZkDaedalusSymbol_getInt(handle, index, context == null ? Pointer.NULL : context.getHandle());
	}

	public void setString(String value, short index, @Nullable DaedalusInstance context) {
		ZenKit.API.ZkDaedalusSymbol_setString(
				handle,
				value,
				index,
				context == null ? Pointer.NULL : context.getHandle()
		);
	}

	public void setFloat(float value, short index, @Nullable DaedalusInstance context) {
		ZenKit.API.ZkDaedalusSymbol_setFloat(
				handle,
				value,
				index,
				context == null ? Pointer.NULL : context.getHandle()
		);
	}

	public void setInt(int value, short index, @Nullable DaedalusInstance context) {
		ZenKit.API.ZkDaedalusSymbol_setInt(handle, value, index, context == null ? Pointer.NULL : context.getHandle());
	}

	public boolean getIsConst() {
		return ZenKit.API.ZkDaedalusSymbol_getIsConst(handle);
	}

	public boolean getIsMember() {
		return ZenKit.API.ZkDaedalusSymbol_getIsMember(handle);
	}

	public boolean getIsExternal() {
		return ZenKit.API.ZkDaedalusSymbol_getIsExternal(handle);
	}

	public boolean getIsMerged() {
		return ZenKit.API.ZkDaedalusSymbol_getIsMerged(handle);
	}

	public boolean getIsGenerated() {
		return ZenKit.API.ZkDaedalusSymbol_getIsGenerated(handle);
	}

	public boolean getHasReturn() {
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
}
