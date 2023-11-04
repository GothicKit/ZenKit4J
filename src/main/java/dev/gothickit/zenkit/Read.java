package dev.gothickit.zenkit;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.capi.ZenKitNative;
import dev.gothickit.zenkit.utils.Handle;

public class Read {
	private final Handle handle;
	private final Pointer memory;

	public Read(byte[] bytes) {
		memory = new Memory(bytes.length);
		memory.write(0, bytes, 0, bytes.length);

		handle = new Handle(ZenKit.API.ZkRead_newMem(memory, bytes.length), ZenKit.API::ZkRead_del);
		ZenKit.CLEANER.register(this, handle);
	}

	public Read(String path) {
		handle = new Handle(ZenKit.API.ZkRead_newPath(path), ZenKit.API::ZkRead_del);
		memory = null;
	}

	public Read(Custom i) {
		var ext = new ZenKitNative.ZkReadExt();
		ext.read = (ctx, buf, len) -> i.read(buf, len);
		ext.seek = (ctx, off, whence) -> i.seek(off, whence);
		ext.tell = (ctx) -> i.tell();
		ext.eof = (ctx) -> i.eof();

		handle = new Handle(ZenKit.API.ZkRead_newExt(ext, Pointer.NULL), ZenKit.API::ZkRead_del);
		memory = null;
	}

	public Read(Pointer handle) {
		this.handle = new Handle(handle, ZenKit.API::ZkRead_del);
		this.memory = null;
	}

	public Pointer getHandle() {
		return this.handle.get();
	}

	public interface Custom {
		long read(Pointer into, long length);

		long seek(long offset, Whence whence);

		long tell();

		boolean eof();
	}
}
