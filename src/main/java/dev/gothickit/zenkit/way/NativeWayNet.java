package dev.gothickit.zenkit.way;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.LongByReference;
import dev.gothickit.zenkit.NativeObject;
import dev.gothickit.zenkit.capi.ZenKit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public final class NativeWayNet implements NativeObject, WayNet {
	private final Pointer handle;

	private NativeWayNet(Pointer handle) {
		this.handle = handle;
	}

	@Contract("null -> null; !null -> new")
	public static @Nullable WayNet fromNativeHandle(Pointer handle) {
		if (handle == null) return null;
		return new NativeWayNet(handle);
	}

	@Override
	public WayEdge @NotNull [] edges() {
		var count = new LongByReference();
		var ptr = ZenKit.API.ZkWayNet_getEdges(handle, count);
		if (ptr == null || count.getValue() == 0) return new WayEdge[0];
		return (WayEdge[]) ptr.toArray((int) count.getValue());
	}

	@Override
	public long pointCount() {
		return ZenKit.API.ZkWayNet_getPointCount(handle);
	}

	@Override
	public WayPoint point(long i) {
		return NativeWayPoint.fromNativeHandle(ZenKit.API.ZkWayNet_getPoint(handle, i));
	}

	@Override
	public @NotNull List<WayPoint> points() {
		var points = new ArrayList<WayPoint>();

		ZenKit.API.ZkWayNet_enumeratePoints(handle, (ctx, point) -> {
			points.add(NativeWayPoint.fromNativeHandle(point));
			return false;
		}, Pointer.NULL);

		return points;
	}

	@Override
	public @NotNull CachedWayNet cache() {
		return new CachedWayNet(
				edges(),
				points()
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
