package dev.gothickit.zenkit.way;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import dev.gothickit.zenkit.capi.ZenKit;

import java.util.ArrayList;
import java.util.List;

public class WayNet {
	private final Pointer handle;

	public WayNet(Pointer handle) {
		this.handle = handle;
	}

	public WayEdge[] getEdges() {
		var count = new IntByReference();
		var ptr = ZenKit.API.ZkWayNet_getEdges(handle, count);
		if (ptr == null || count.getValue() == 0) return new WayEdge[0];
		return (WayEdge[]) ptr.toArray(count.getValue());
	}

	public long getPointCount() {
		return ZenKit.API.ZkWayNet_getPointCount(handle);
	}

	public WayPoint getPoint(long i) {
		return new WayPoint(ZenKit.API.ZkWayNet_getPoint(handle, i));
	}

	public List<WayPoint> getPoints() {
		var points = new ArrayList<WayPoint>();

		ZenKit.API.ZkWayNet_enumeratePoints(handle, (ctx, point) -> {
			points.add(new WayPoint(point));
			return false;
		}, Pointer.NULL);

		return points;
	}
}
