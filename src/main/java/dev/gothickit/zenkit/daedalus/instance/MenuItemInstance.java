package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public class MenuItemInstance extends DaedalusInstance {
	public MenuItemInstance(Pointer handle) {
		super(handle);
	}

	public String getFontName() {
		return ZenKit.API.ZkMenuItemInstance_getFontName(getHandle());
	}

	public String getBackpic() {
		return ZenKit.API.ZkMenuItemInstance_getBackpic(getHandle());
	}

	public String getAlphaMode() {
		return ZenKit.API.ZkMenuItemInstance_getAlphaMode(getHandle());
	}

	public int getAlpha() {
		return ZenKit.API.ZkMenuItemInstance_getAlpha(getHandle());
	}

	public MenuItemType getMenuItemType() {
		return ZenKit.API.ZkMenuItemInstance_getType(getHandle());
	}

	public String getOnChgSetOption() {
		return ZenKit.API.ZkMenuItemInstance_getOnChgSetOption(getHandle());
	}

	public String getOnChgSetOptionSection() {
		return ZenKit.API.ZkMenuItemInstance_getOnChgSetOptionSection(getHandle());
	}

	public int getPosX() {
		return ZenKit.API.ZkMenuItemInstance_getPosX(getHandle());
	}

	public int getPosY() {
		return ZenKit.API.ZkMenuItemInstance_getPosY(getHandle());
	}

	public int getDimX() {
		return ZenKit.API.ZkMenuItemInstance_getDimX(getHandle());
	}

	public int getDimY() {
		return ZenKit.API.ZkMenuItemInstance_getDimY(getHandle());
	}

	public float getSizeStartScale() {
		return ZenKit.API.ZkMenuItemInstance_getSizeStartScale(getHandle());
	}

	public int getFlags() {
		return ZenKit.API.ZkMenuItemInstance_getFlags(getHandle());
	}

	public float getOpenDelayTime() {
		return ZenKit.API.ZkMenuItemInstance_getOpenDelayTime(getHandle());
	}

	public float getOpenDuration() {
		return ZenKit.API.ZkMenuItemInstance_getOpenDuration(getHandle());
	}

	public int getFramePosX() {
		return ZenKit.API.ZkMenuItemInstance_getFramePosX(getHandle());
	}

	public int getFramePosY() {
		return ZenKit.API.ZkMenuItemInstance_getFramePosY(getHandle());
	}

	public int getFrameSizeX() {
		return ZenKit.API.ZkMenuItemInstance_getFrameSizeX(getHandle());
	}

	public int getFrameSizeY() {
		return ZenKit.API.ZkMenuItemInstance_getFrameSizeY(getHandle());
	}

	public String getHideIfOptionSectionSet() {
		return ZenKit.API.ZkMenuItemInstance_getHideIfOptionSectionSet(getHandle());
	}

	public String getHideIfOptionSet() {
		return ZenKit.API.ZkMenuItemInstance_getHideIfOptionSet(getHandle());
	}

	public int getHideOnValue() {
		return ZenKit.API.ZkMenuItemInstance_getHideOnValue(getHandle());
	}

	public String getText(long i) {
		return ZenKit.API.ZkMenuItemInstance_getText(getHandle(), i);
	}

	public int getOnSelAction(long i) {
		return ZenKit.API.ZkMenuItemInstance_getOnSelAction(getHandle(), i);
	}

	public String getOnSelActionS(long i) {
		return ZenKit.API.ZkMenuItemInstance_getOnSelActionS(getHandle(), i);
	}

	public int getOnEventAction(long i) {
		return ZenKit.API.ZkMenuItemInstance_getOnEventAction(getHandle(), i);
	}

	public float getUserFloat(long i) {
		return ZenKit.API.ZkMenuItemInstance_getUserFloat(getHandle(), i);
	}

	public String getUserString(long i) {
		return ZenKit.API.ZkMenuItemInstance_getUserString(getHandle(), i);
	}
}
