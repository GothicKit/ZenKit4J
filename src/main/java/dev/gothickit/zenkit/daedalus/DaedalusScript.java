package dev.gothickit.zenkit.daedalus;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DaedalusScript implements NativeObject {
	protected final Handle handle;

	private DaedalusScript(@NotNull NativeRead buf) throws ResourceIOException {
		this.handle = new Handle(ZenKit.API.ZkDaedalusScript_load(buf.getNativeHandle()), ZenKit.API::ZkDaedalusScript_del);

		if (handle.isNull()) {
			throw new ResourceIOException(DaedalusScript.class, ResourceIOSource.STREAM, buf.toString());
		}

		ZenKit.CLEANER.register(this, handle);
	}

	private DaedalusScript(String path) throws ResourceIOException {
		this.handle = new Handle(ZenKit.API.ZkDaedalusScript_loadPath(path), ZenKit.API::ZkDaedalusScript_del);

		if (handle.isNull()) {
			throw new ResourceIOException(DaedalusScript.class, ResourceIOSource.DISK, path);
		}

		ZenKit.CLEANER.register(this, handle);
	}

	private DaedalusScript(@NotNull Vfs vfs, String name) throws ResourceIOException {
		this.handle = new Handle(
				ZenKit.API.ZkDaedalusScript_loadVfs(vfs.getNativeHandle(), name),
				ZenKit.API::ZkDaedalusScript_del
		);

		if (handle.isNull()) {
			throw new ResourceIOException(DaedalusScript.class, ResourceIOSource.VFS, name);
		}

		ZenKit.CLEANER.register(this, handle);
	}

	protected DaedalusScript(Handle handle) {
		this.handle = handle;
		ZenKit.CLEANER.register(this, handle);
	}

	@Contract("_ -> new")
	public static @NotNull DaedalusScript load(@NotNull String path) throws ResourceIOException {
		return new DaedalusScript(path);
	}

	@Contract("_ -> new")
	public static @NotNull DaedalusScript load(@NotNull Read buf) throws ResourceIOException {
		return new DaedalusScript(Read.adapt(buf));
	}

	@Contract("_, _ -> new")
	public static @NotNull DaedalusScript load(@NotNull Vfs vfs, @NotNull String name) throws ResourceIOException {
		return new DaedalusScript(vfs, name);
	}

	public int getSymbolCount() {
		return ZenKit.API.ZkDaedalusScript_getSymbolCount(getNativeHandle());
	}

	public List<DaedalusSymbol> getSymbols() {
		var symbols = new ArrayList<DaedalusSymbol>();

		ZenKit.API.ZkDaedalusScript_enumerateSymbols(getNativeHandle(), (ctx, symbol) -> {
			symbols.add(DaedalusSymbol.fromNativeHandle(symbol));
			return false;
		}, Pointer.NULL);

		return symbols;
	}

	public List<DaedalusSymbol> getInstanceSymbols(String className) {
		var symbols = new ArrayList<DaedalusSymbol>();

		ZenKit.API.ZkDaedalusScript_enumerateInstanceSymbols(getNativeHandle(), className, (ctx, symbol) -> {
			symbols.add(DaedalusSymbol.fromNativeHandle(symbol));
			return false;
		}, Pointer.NULL);

		return symbols;
	}

	public DaedalusInstruction getInstruction(long address) {
		return ZenKit.API.ZkDaedalusScript_getInstruction(getNativeHandle(), address);
	}

	public DaedalusSymbol getSymbolByIndex(int index) {
		var ptr = ZenKit.API.ZkDaedalusScript_getSymbolByIndex(getNativeHandle(), index);
		return DaedalusSymbol.fromNativeHandle(ptr);
	}

	public DaedalusSymbol getSymbolByAddress(long address) {
		var ptr = ZenKit.API.ZkDaedalusScript_getSymbolByAddress(getNativeHandle(), address);
		return DaedalusSymbol.fromNativeHandle(ptr);
	}

	public DaedalusSymbol getSymbolByName(String name) {
		var ptr = ZenKit.API.ZkDaedalusScript_getSymbolByName(getNativeHandle(), name);
		return DaedalusSymbol.fromNativeHandle(ptr);
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle.get();
	}
}
