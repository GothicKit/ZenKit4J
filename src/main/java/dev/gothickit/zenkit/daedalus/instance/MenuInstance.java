package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public class MenuInstance extends DaedalusInstance {
	public MenuInstance(Pointer handle) {
		super(handle);
	}

	public String getBackPic() {
		return ZenKit.API.ZkMenuInstance_getBackPic(getHandle());
	}

	public String getBackWorld() {
		return ZenKit.API.ZkMenuInstance_getBackWorld(getHandle());
	}

	public int getPosX() {
		return ZenKit.API.ZkMenuInstance_getPosX(getHandle());
	}

	public int getPosY() {
		return ZenKit.API.ZkMenuInstance_getPosY(getHandle());
	}

	public int getDimX() {
		return ZenKit.API.ZkMenuInstance_getDimX(getHandle());
	}

	public int getDimY() {
		return ZenKit.API.ZkMenuInstance_getDimY(getHandle());
	}

	public int getAlpha() {
		return ZenKit.API.ZkMenuInstance_getAlpha(getHandle());
	}

	public String getMusicTheme() {
		return ZenKit.API.ZkMenuInstance_getMusicTheme(getHandle());
	}

	public int getEventTimerMsec() {
		return ZenKit.API.ZkMenuInstance_getEventTimerMsec(getHandle());
	}

	public int getFlags() {
		return ZenKit.API.ZkMenuInstance_getFlags(getHandle());
	}

	public int getDefaultOutgame() {
		return ZenKit.API.ZkMenuInstance_getDefaultOutgame(getHandle());
	}

	public int getDefaultIngame() {
		return ZenKit.API.ZkMenuInstance_getDefaultIngame(getHandle());
	}

	public String getItem(long i) {
		return ZenKit.API.ZkMenuInstance_getItem(getHandle(), i);
	}
}
