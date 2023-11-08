package dev.gothickit.zenkit.daedalus;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DaedalusScript {
	private final Handle handle;

	public DaedalusScript(@NotNull Read buf) {
		this.handle = new Handle(ZenKit.API.ZkDaedalusScript_load(buf.getHandle()), ZenKit.API::ZkDaedalusScript_del);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load DaedalusScript");
	}

	public DaedalusScript(String path) {
		this.handle = new Handle(ZenKit.API.ZkDaedalusScript_loadPath(path), ZenKit.API::ZkDaedalusScript_del);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load DaedalusScript");
	}

	public DaedalusScript(@NotNull Vfs vfs, String name) {
		this.handle = new Handle(
				ZenKit.API.ZkDaedalusScript_loadVfs(vfs.getHandle(), name),
				ZenKit.API::ZkDaedalusScript_del
		);
		if (this.handle.isNull()) throw new RuntimeException("Failed to load DaedalusScript");
	}

	public Pointer getHandle() {
		return handle.get();
	}

	public int getSymbolCount() {
		return ZenKit.API.ZkDaedalusScript_getSymbolCount(getHandle());
	}

	public List<DaedalusSymbol> getSymbols() {
		var symbols = new ArrayList<DaedalusSymbol>();

		ZenKit.API.ZkDaedalusScript_enumerateSymbols(getHandle(), (ctx, symbol) -> {
			symbols.add(new DaedalusSymbol(symbol));
			return false;
		}, Pointer.NULL);

		return symbols;
	}

	public List<DaedalusSymbol> getInstanceSymbols(String className) {
		var symbols = new ArrayList<DaedalusSymbol>();

		ZenKit.API.ZkDaedalusScript_enumerateInstanceSymbols(getHandle(), className, (ctx, symbol) -> {
			symbols.add(new DaedalusSymbol(symbol));
			return false;
		}, Pointer.NULL);

		return symbols;
	}

	public DaedalusInstruction getInstruction(long address) {
		return ZenKit.API.ZkDaedalusScript_getInstruction(getHandle(), address);
	}

	public DaedalusSymbol getSymbolByIndex(int index) {
		var ptr = ZenKit.API.ZkDaedalusScript_getSymbolByIndex(getHandle(), index);
		return ptr == Pointer.NULL ? null : new DaedalusSymbol(ptr);
	}

	public DaedalusSymbol getSymbolByAddress(long address) {
		var ptr = ZenKit.API.ZkDaedalusScript_getSymbolByAddress(getHandle(), address);
		return ptr == Pointer.NULL ? null : new DaedalusSymbol(ptr);
	}

	public DaedalusSymbol getSymbolByName(String name) {
		var ptr = ZenKit.API.ZkDaedalusScript_getSymbolByName(getHandle(), name);
		return ptr == Pointer.NULL ? null : new DaedalusSymbol(ptr);
	}
}
