package dev.gothickit.zenkit.ani;

import com.sun.jna.Structure;
import dev.gothickit.zenkit.Quat;
import dev.gothickit.zenkit.Vec3f;

@Structure.FieldOrder({"position", "rotation"})
public final class AnimationSample extends Structure implements Structure.ByValue {
	public Vec3f position = new Vec3f();
	public Quat rotation = new Quat();
}
