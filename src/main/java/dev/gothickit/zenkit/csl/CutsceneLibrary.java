package dev.gothickit.zenkit.csl;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CutsceneLibrary {
	private final Handle handle;

	public CutsceneLibrary(String path) {
		var handle = new Handle(ZenKit.API.ZkCutsceneLibrary_loadPath(path), ZenKit.API::ZkCutsceneLibrary_del);
		if (handle.isNull()) throw new RuntimeException("Failed to load cutscene library node");
		ZenKit.CLEANER.register(this, handle);
		this.handle = handle;
	}

	public CutsceneLibrary(@NotNull Read buf) {
		var handle = new Handle(ZenKit.API.ZkCutsceneLibrary_load(buf.getHandle()), ZenKit.API::ZkCutsceneLibrary_del);
		if (handle.isNull()) throw new RuntimeException("Failed to load cutscene library node");
		ZenKit.CLEANER.register(this, handle);
		this.handle = handle;
	}

	public CutsceneLibrary(@NotNull Vfs vfs, String name) {
		var handle = new Handle(
				ZenKit.API.ZkCutsceneLibrary_loadVfs(vfs.getHandle(), name),
				ZenKit.API::ZkCutsceneLibrary_del
		);

		if (handle.isNull()) {
			throw new RuntimeException("Failed to load cutscene library node");
		}

		ZenKit.CLEANER.register(this, handle);
		this.handle = handle;
	}

	public Pointer getHandle() {
		return this.handle.get();
	}

	public @Nullable CutsceneBlock getBlock(String name) {
		var handle = ZenKit.API.ZkCutsceneLibrary_getBlock(this.getHandle(), name);
		return handle == Pointer.NULL ? null : new CutsceneBlock(handle);
	}

	public List<CutsceneBlock> getBlocks() {
		var blocks = new ArrayList<CutsceneBlock>();

		ZenKit.API.ZkCutsceneLibrary_enumerateBlocks(this.getHandle(), (ctx, block) -> {
			blocks.add(new CutsceneBlock(block));
			return false;
		}, Pointer.NULL);

		return blocks;
	}
}
