package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public final class MenuInstance extends DaedalusInstance {
	public MenuInstance(Pointer handle) {
		super(handle);
	}

	public String getBackPic() {
		return ZenKit.API.ZkMenuInstance_getBackPic(getNativeHandle());
	}

	public String getBackWorld() {
		return ZenKit.API.ZkMenuInstance_getBackWorld(getNativeHandle());
	}

	public int getPosX() {
		return ZenKit.API.ZkMenuInstance_getPosX(getNativeHandle());
	}

	public int getPosY() {
		return ZenKit.API.ZkMenuInstance_getPosY(getNativeHandle());
	}

	public int getDimX() {
		return ZenKit.API.ZkMenuInstance_getDimX(getNativeHandle());
	}

	public int getDimY() {
		return ZenKit.API.ZkMenuInstance_getDimY(getNativeHandle());
	}

	public int getAlpha() {
		return ZenKit.API.ZkMenuInstance_getAlpha(getNativeHandle());
	}

	public String getMusicTheme() {
		return ZenKit.API.ZkMenuInstance_getMusicTheme(getNativeHandle());
	}

	public int getEventTimerMsec() {
		return ZenKit.API.ZkMenuInstance_getEventTimerMsec(getNativeHandle());
	}

	public int getFlags() {
		return ZenKit.API.ZkMenuInstance_getFlags(getNativeHandle());
	}

	public int getDefaultOutgame() {
		return ZenKit.API.ZkMenuInstance_getDefaultOutgame(getNativeHandle());
	}

	public int getDefaultIngame() {
		return ZenKit.API.ZkMenuInstance_getDefaultIngame(getNativeHandle());
	}

	public String getItem(long i) {
		return ZenKit.API.ZkMenuInstance_getItem(getNativeHandle(), i);
	}
}
