package dev.gothickit.zenkit.daedalus;

import com.sun.jna.Structure;

@Structure.FieldOrder({"op_", "size", "data", "index"})
public final class DaedalusInstruction extends Structure implements Structure.ByValue {
	public int op_;
	public int size;
	public int data;
	public int index;

	public DaedalusOpcode op() {
		return DaedalusOpcode.ADD.getForValue(op_);
	}
}
