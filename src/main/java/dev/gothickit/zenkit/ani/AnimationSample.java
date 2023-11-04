package dev.gothickit.zenkit.ani;

import com.sun.jna.Structure;
import dev.gothickit.zenkit.Quat;
import dev.gothickit.zenkit.Vec3f;

import java.util.List;

public class AnimationSample extends Structure {
	public Vec3f position;

	public Quat rotation;

	public AnimationSample() {
		position = new Vec3f();
		rotation = new Quat();
	}

	@Override
	protected List<String> getFieldOrder() {
		return List.of("position", "rotation");
	}

	public static class ByValue extends AnimationSample implements Structure.ByValue {
	}

	public static class ByReference extends AnimationSample implements Structure.ByReference {
	}
}
