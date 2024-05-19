package dev.gothickit.zenkit;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.capi.ZenKitNative;
import dev.gothickit.zenkit.utils.Handle;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NativeRead implements NativeObject, Read {
	private final Handle handle;
	private final Pointer memory;
	private final Read java;

	NativeRead(byte @NotNull [] bytes) {
		memory = new Memory(bytes.length);
		memory.write(0, bytes, 0, bytes.length);
		java = null;
		handle = new Handle(ZenKit.API.ZkRead_newMem(memory, bytes.length), ZenKit.API::ZkRead_del);
		ZenKit.CLEANER.register(this, handle);
	}

	NativeRead(String path) {
		handle = new Handle(ZenKit.API.ZkRead_newPath(path), ZenKit.API::ZkRead_del);
		java = null;
		memory = null;
	}

	NativeRead(Read java) {
		this.java = java;

		var ext = new ZenKitNative.ZkReadExt();
		ext.read = (ctx, buf, len) -> java.read(buf, len);
		ext.seek = (ctx, off, whence) -> java.seek(off, whence);
		ext.tell = (ctx) -> java.tell();
		ext.eof = (ctx) -> java.eof();

		handle = new Handle(ZenKit.API.ZkRead_newExt(ext, Pointer.NULL), ZenKit.API::ZkRead_del);
		memory = null;
	}

	private NativeRead(Pointer handle) {
		this.handle = new Handle(handle, ZenKit.API::ZkRead_del);
		java = null;
		memory = null;
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable NativeRead fromNativeHandle(Pointer handle) {
		if (handle == null) return null;
		return new NativeRead(handle);
	}

	public @NotNull Pointer getNativeHandle() {
		return handle.get();
	}

	@Override
	public long read(Pointer into, long length) {
		throw new UnsupportedOperationException();
	}

	@Override
	public long seek(long offset, Whence whence) {
		throw new UnsupportedOperationException();
	}

	@Override
	public long tell() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean eof() {
		throw new UnsupportedOperationException();
	}
}
