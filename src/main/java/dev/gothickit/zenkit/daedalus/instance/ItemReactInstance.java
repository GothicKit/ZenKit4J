package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public final class ItemReactInstance extends DaedalusInstance {
	public ItemReactInstance(Pointer handle) {
		super(handle);
	}

	public int getNpc() {
		return ZenKit.API.ZkItemReactInstance_getNpc(getNativeHandle());
	}

	public int getTradeItem() {
		return ZenKit.API.ZkItemReactInstance_getTradeItem(getNativeHandle());
	}

	public int getTradeAmount() {
		return ZenKit.API.ZkItemReactInstance_getTradeAmount(getNativeHandle());
	}

	public int getRequestedCategory() {
		return ZenKit.API.ZkItemReactInstance_getRequestedCategory(getNativeHandle());
	}

	public int getRequestedItem() {
		return ZenKit.API.ZkItemReactInstance_getRequestedItem(getNativeHandle());
	}

	public int getRequestedAmount() {
		return ZenKit.API.ZkItemReactInstance_getRequestedAmount(getNativeHandle());
	}

	public int getReaction() {
		return ZenKit.API.ZkItemReactInstance_getReaction(getNativeHandle());
	}

}
