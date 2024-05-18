package dev.gothickit.zenkit.ani;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.LongByReference;
import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.bsp.NativeBinarySpacePartitionTree;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class NativeModelAnimation implements NativeObject, ModelAnimation {
	private final Handle handle;

	NativeModelAnimation(@NotNull String path) throws ResourceIOException {
		var handle = new Handle(ZenKit.API.ZkModelAnimation_loadPath(path), ZenKit.API::ZkModelAnimation_del);
		if (handle.isNull()) {
			throw new ResourceIOException(ModelAnimation.class, ResourceIOSource.DISK, path);
		}

		ZenKit.CLEANER.register(this, handle);
		this.handle = handle;
	}

	NativeModelAnimation(@NotNull Read buf) throws ResourceIOException {
		var handle = new Handle(ZenKit.API.ZkModelAnimation_load(buf.getHandle()), ZenKit.API::ZkModelAnimation_del);
		if (handle.isNull()) {
			throw new ResourceIOException(ModelAnimation.class, ResourceIOSource.STREAM, buf.getHandle().toString());
		}

		ZenKit.CLEANER.register(this, handle);
		this.handle = handle;
	}

	NativeModelAnimation(@NotNull Vfs vfs, @NotNull String name) throws ResourceIOException {
		var handle = new Handle(
				ZenKit.API.ZkModelAnimation_loadVfs(vfs.getHandle(), name),
				ZenKit.API::ZkModelAnimation_del
		);

		if (handle.isNull()) {
			throw new ResourceIOException(ModelAnimation.class, ResourceIOSource.VFS, name);
		}

		ZenKit.CLEANER.register(this, handle);
		this.handle = handle;
	}

	public @NotNull Pointer getNativeHandle() {
		return this.handle.get();
	}

	@Override
	public @NotNull String name() {
		return ZenKit.API.ZkModelAnimation_getName(getNativeHandle());
	}

	@Override
	public @NotNull String next() {
		return ZenKit.API.ZkModelAnimation_getNext(getNativeHandle());
	}

	@Override
	public int layer() {
		return ZenKit.API.ZkModelAnimation_getLayer(getNativeHandle());
	}

	@Override
	public int frameCount() {
		return ZenKit.API.ZkModelAnimation_getFrameCount(getNativeHandle());
	}

	@Override
	public int nodeCount() {
		return ZenKit.API.ZkModelAnimation_getNodeCount(getNativeHandle());
	}

	@Override
	public float fps() {
		return ZenKit.API.ZkModelAnimation_getFps(getNativeHandle());
	}

	@Override
	public float fpsSource() {
		return ZenKit.API.ZkModelAnimation_getFpsSource(getNativeHandle());
	}

	@Override
	public @NotNull AxisAlignedBoundingBox bbox() {
		return ZenKit.API.ZkModelAnimation_getBbox(getNativeHandle());
	}

	@Override
	public long checksum() {
		return ZenKit.API.ZkModelAnimation_getChecksum(getNativeHandle());
	}

	@Override
	public @NotNull String sourcePath() {
		return ZenKit.API.ZkModelAnimation_getSourcePath(getNativeHandle());
	}

	@Override
	public @NotNull Calendar sourceDate() {
		return ZenKit.API.ZkModelAnimation_getSourceDate(getNativeHandle()).toCalendar();
	}

	@Override
	public @NotNull String sourceScript() {
		return ZenKit.API.ZkModelAnimation_getSourceScript(getNativeHandle());
	}

	@Override
	public long sampleCount() {
		return ZenKit.API.ZkModelAnimation_getSampleCount(getNativeHandle());
	}

	@Override
	public AnimationSample sample(long i) {
		return ZenKit.API.ZkModelAnimation_getSample(getNativeHandle(), i);
	}

	@Override
	public @NotNull List<AnimationSample> samples() {
		var samples = new ArrayList<AnimationSample>((int) this.sampleCount());

		ZenKit.API.ZkModelAnimation_enumerateSamples(getNativeHandle(), (ctx, sample) -> {
			samples.add(sample);
			return false;
		}, Pointer.NULL);

		return samples;
	}

	@Override
	public int @NotNull [] nodeIndices() {
		var size = new LongByReference();
		var ptr = ZenKit.API.ZkModelAnimation_getNodeIndices(getNativeHandle(), size);
		return ptr.getIntArray(0, (int) size.getValue());
	}

	@Contract(" -> new")
	@Override
	public @NotNull CachedModelAnimation cache() {
		return new CachedModelAnimation(
				name(),
				next(),
				layer(),
				frameCount(),
				nodeCount(),
				fps(),
				fpsSource(),
				bbox(),
				checksum(),
				sourcePath(),
				sourceDate(),
				sourceScript(),
				samples(),
				nodeIndices()
		);
	}

	@Override
	public boolean isCached() {
		return false;
	}
}
