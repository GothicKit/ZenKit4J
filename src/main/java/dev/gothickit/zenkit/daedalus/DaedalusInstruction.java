package dev.gothickit.zenkit.daedalus;

import com.sun.jna.Structure;

@Structure.FieldOrder({"op", "size", "data", "index"})
public final class DaedalusInstruction extends Structure implements Structure.ByValue {
	public DaedalusOpcode op;
	public int size;
	public int data;
	public int index;
}
