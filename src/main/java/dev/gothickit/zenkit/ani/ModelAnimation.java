package dev.gothickit.zenkit.ani;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import dev.gothickit.zenkit.AxisAlignedBoundingBox;
import dev.gothickit.zenkit.Read;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.utils.Handle;
import dev.gothickit.zenkit.vfs.Vfs;
import org.jetbrains.annotations.NotNull;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ModelAnimation {
	private final Handle handle;

	public ModelAnimation(String path) {
		var handle = new Handle(ZenKit.API.ZkModelAnimation_loadPath(path), ZenKit.API::ZkModelAnimation_del);
		if (handle.isNull()) throw new RuntimeException("Failed to load model animation");
		ZenKit.CLEANER.register(this, handle);
		this.handle = handle;
	}

	public ModelAnimation(@NotNull Read buf) {
		var handle = new Handle(ZenKit.API.ZkModelAnimation_load(buf.getHandle()), ZenKit.API::ZkModelAnimation_del);
		if (handle.isNull()) throw new RuntimeException("Failed to load model animation");
		ZenKit.CLEANER.register(this, handle);
		this.handle = handle;
	}

	public ModelAnimation(@NotNull Vfs vfs, String name) {
		var handle = new Handle(
				ZenKit.API.ZkModelAnimation_loadVfs(vfs.getHandle(), name),
				ZenKit.API::ZkModelAnimation_del
		);
		if (handle.isNull()) throw new RuntimeException("Failed to load model animation");
		ZenKit.CLEANER.register(this, handle);
		this.handle = handle;
	}

	public Pointer getHandle() {
		return this.handle.get();
	}

	public String getName() {
		return ZenKit.API.ZkModelAnimation_getName(this.getHandle());
	}

	public String getNext() {
		return ZenKit.API.ZkModelAnimation_getNext(this.getHandle());
	}

	public int getLayer() {
		return ZenKit.API.ZkModelAnimation_getLayer(this.getHandle());
	}

	public int getFrameCount() {
		return ZenKit.API.ZkModelAnimation_getFrameCount(this.getHandle());
	}

	public int getNodeCount() {
		return ZenKit.API.ZkModelAnimation_getNodeCount(this.getHandle());
	}

	public float getFps() {
		return ZenKit.API.ZkModelAnimation_getFps(this.getHandle());
	}

	public float getFpsSource() {
		return ZenKit.API.ZkModelAnimation_getFpsSource(this.getHandle());
	}

	public AxisAlignedBoundingBox getBbox() {
		return ZenKit.API.ZkModelAnimation_getBbox(this.getHandle());
	}

	public long getChecksum() {
		return ZenKit.API.ZkModelAnimation_getChecksum(this.getHandle());
	}

	public String getSourcePath() {
		return ZenKit.API.ZkModelAnimation_getSourcePath(this.getHandle());
	}

	public Instant getSourceDate() {
		return ZenKit.API.ZkModelAnimation_getSourceDate(this.getHandle()).toInstant();
	}

	public String getSourceScript() {
		return ZenKit.API.ZkModelAnimation_getSourceScript(this.getHandle());
	}

	public long getSampleCount() {
		return ZenKit.API.ZkModelAnimation_getSampleCount(this.getHandle());
	}

	public AnimationSample getSample(long i) {
		return ZenKit.API.ZkModelAnimation_getSample(this.getHandle(), i);
	}

	public List<AnimationSample> getSamples() {
		var samples = new ArrayList<AnimationSample>((int) this.getSampleCount());

		ZenKit.API.ZkModelAnimation_enumerateSamples(this.getHandle(), (ctx, sample) -> {
			samples.add(sample);
			return false;
		}, Pointer.NULL);

		return samples;
	}

	public int[] getNodeIndices() {
		var size = new IntByReference();
		var ptr = ZenKit.API.ZkModelAnimation_getNodeIndices(this.getHandle(), size);
		return ptr.getIntArray(0, size.getValue());
	}
}
