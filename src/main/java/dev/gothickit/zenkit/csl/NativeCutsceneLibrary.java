package dev.gothickit.zenkit.csl;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class NativeCutsceneLibrary implements NativeObject, CutsceneLibrary {
	private final Handle handle;

	NativeCutsceneLibrary(String path) throws ResourceIOException {
		var handle = new Handle(ZenKit.API.ZkCutsceneLibrary_loadPath(path), ZenKit.API::ZkCutsceneLibrary_del);

		if (handle.isNull()) {
			throw new ResourceIOException(CutsceneLibrary.class, ResourceIOSource.DISK, path);
		}

		ZenKit.CLEANER.register(this, handle);
		this.handle = handle;
	}

	NativeCutsceneLibrary(@NotNull Read buf) throws ResourceIOException {
		var handle = new Handle(ZenKit.API.ZkCutsceneLibrary_load(buf.getHandle()), ZenKit.API::ZkCutsceneLibrary_del);

		if (handle.isNull()) {
			throw new ResourceIOException(CutsceneLibrary.class, ResourceIOSource.STREAM, buf.getHandle().toString());
		}

		ZenKit.CLEANER.register(this, handle);
		this.handle = handle;
	}

	NativeCutsceneLibrary(@NotNull Vfs vfs, String name) throws ResourceIOException {
		var handle = new Handle(
				ZenKit.API.ZkCutsceneLibrary_loadVfs(vfs.getHandle(), name),
				ZenKit.API::ZkCutsceneLibrary_del
		);

		if (handle.isNull()) {
			throw new ResourceIOException(CutsceneLibrary.class, ResourceIOSource.VFS, name);
		}

		ZenKit.CLEANER.register(this, handle);
		this.handle = handle;
	}

	public @NotNull Pointer getNativeHandle() {
		return this.handle.get();
	}

	@Override
	public long blockCount() {
		return ZenKit.API.ZkCutsceneLibrary_getBlockCount(getNativeHandle());
	}

	@Override
	public @Nullable CutsceneBlock block(String name) {
		var handle = ZenKit.API.ZkCutsceneLibrary_getBlock(getNativeHandle(), name);
		return NativeCutsceneBlock.fromNativeHandle(handle);
	}

	@Override
	public @Nullable CutsceneBlock block(long i) {
		var handle = ZenKit.API.ZkCutsceneLibrary_getBlockByIndex(getNativeHandle(), i);
		return NativeCutsceneBlock.fromNativeHandle(handle);
	}

	@Override
	public @NotNull List<CutsceneBlock> blocks() {
		var blocks = new ArrayList<CutsceneBlock>();

		ZenKit.API.ZkCutsceneLibrary_enumerateBlocks(getNativeHandle(), (ctx, block) -> {
			blocks.add(NativeCutsceneBlock.fromNativeHandle(block));
			return false;
		}, Pointer.NULL);

		return blocks;
	}

	@Override
	public @NotNull CachedCutsceneLibrary cache() {
		return new CachedCutsceneLibrary(blocks().stream().map(CacheableObject::cache).collect(Collectors.toList()));
	}

	@Override
	public boolean isCached() {
		return false;
	}
}
