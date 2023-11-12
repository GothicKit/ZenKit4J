package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public class ItemReactInstance extends DaedalusInstance {
	public ItemReactInstance(Pointer handle) {
		super(handle);
	}

	public int getNpc() {
		return ZenKit.API.ZkItemReactInstance_getNpc(getHandle());
	}

	public int getTradeItem() {
		return ZenKit.API.ZkItemReactInstance_getTradeItem(getHandle());
	}

	public int getTradeAmount() {
		return ZenKit.API.ZkItemReactInstance_getTradeAmount(getHandle());
	}

	public int getRequestedCategory() {
		return ZenKit.API.ZkItemReactInstance_getRequestedCategory(getHandle());
	}

	public int getRequestedItem() {
		return ZenKit.API.ZkItemReactInstance_getRequestedItem(getHandle());
	}

	public int getRequestedAmount() {
		return ZenKit.API.ZkItemReactInstance_getRequestedAmount(getHandle());
	}

	public int getReaction() {
		return ZenKit.API.ZkItemReactInstance_getReaction(getHandle());
	}

}
