package dev.gothickit.zenkit.mmb;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.LongByReference;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.Vec3f;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NativeMorphAnimation implements NativeObject, MorphAnimation {
	private final Pointer handle;

	private NativeMorphAnimation(Pointer handle) {
		this.handle = handle;
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable NativeMorphAnimation fromNativeHandle(Pointer handle) {
		if (handle == null) return null;
		return new NativeMorphAnimation(handle);
	}

	@Override
	public @NotNull String name() {
		return ZenKit.API.ZkMorphAnimation_getName(handle);
	}

	@Override
	public int layer() {
		return ZenKit.API.ZkMorphAnimation_getLayer(handle);
	}

	@Override
	public float blendIn() {
		return ZenKit.API.ZkMorphAnimation_getBlendIn(handle);
	}

	@Override
	public float blendOut() {
		return ZenKit.API.ZkMorphAnimation_getBlendOut(handle);
	}

	@Override
	public float duration() {
		return ZenKit.API.ZkMorphAnimation_getDuration(handle);
	}

	@Override
	public float speed() {
		return ZenKit.API.ZkMorphAnimation_getSpeed(handle);
	}

	@Override
	public byte flags() {
		return ZenKit.API.ZkMorphAnimation_getFlags(handle);
	}

	@Override
	public int frameCount() {
		return ZenKit.API.ZkMorphAnimation_getFrameCount(handle);
	}

	@Override
	public int @NotNull [] vertices() {
		var count = new LongByReference();
		var ptr = ZenKit.API.ZkMorphAnimation_getVertices(handle, count);
		if (ptr == Pointer.NULL || count.getValue() == 0) return new int[0];
		return ptr.getIntArray(0, (int) count.getValue());
	}

	@Override
	public Vec3f @NotNull [] samples() {
		var count = ZenKit.API.ZkMorphAnimation_getSampleCount(handle);
		var weights = new Vec3f[(int) count];

		for (int i = 0; i < count; i++) {
			weights[i] = ZenKit.API.ZkMorphAnimation_getSample(handle, i);
		}

		return weights;
	}

	@Override
	public @NotNull CachedMorphAnimation cache() {
		return new CachedMorphAnimation(
				name(),
				layer(),
				blendIn(),
				blendOut(),
				duration(),
				speed(),
				flags(),
				frameCount(),
				vertices(),
				samples()
		);
	}

	@Override
	public boolean isCached() {
		return false;
	}

	@Override
	public @NotNull Pointer getNativeHandle() {
		return handle;
	}
}
