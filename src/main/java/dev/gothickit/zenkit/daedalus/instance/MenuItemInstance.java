package dev.gothickit.zenkit.daedalus.instance;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.DaedalusInstance;

public final class MenuItemInstance extends DaedalusInstance {
	public MenuItemInstance(Pointer handle) {
		super(handle);
	}

	public String getFontName() {
		return ZenKit.API.ZkMenuItemInstance_getFontName(getNativeHandle());
	}

	public String getBackpic() {
		return ZenKit.API.ZkMenuItemInstance_getBackpic(getNativeHandle());
	}

	public String getAlphaMode() {
		return ZenKit.API.ZkMenuItemInstance_getAlphaMode(getNativeHandle());
	}

	public int getAlpha() {
		return ZenKit.API.ZkMenuItemInstance_getAlpha(getNativeHandle());
	}

	public MenuItemType getMenuItemType() {
		return ZenKit.API.ZkMenuItemInstance_getType(getNativeHandle());
	}

	public String getOnChgSetOption() {
		return ZenKit.API.ZkMenuItemInstance_getOnChgSetOption(getNativeHandle());
	}

	public String getOnChgSetOptionSection() {
		return ZenKit.API.ZkMenuItemInstance_getOnChgSetOptionSection(getNativeHandle());
	}

	public int getPosX() {
		return ZenKit.API.ZkMenuItemInstance_getPosX(getNativeHandle());
	}

	public int getPosY() {
		return ZenKit.API.ZkMenuItemInstance_getPosY(getNativeHandle());
	}

	public int getDimX() {
		return ZenKit.API.ZkMenuItemInstance_getDimX(getNativeHandle());
	}

	public int getDimY() {
		return ZenKit.API.ZkMenuItemInstance_getDimY(getNativeHandle());
	}

	public float getSizeStartScale() {
		return ZenKit.API.ZkMenuItemInstance_getSizeStartScale(getNativeHandle());
	}

	public int getFlags() {
		return ZenKit.API.ZkMenuItemInstance_getFlags(getNativeHandle());
	}

	public float getOpenDelayTime() {
		return ZenKit.API.ZkMenuItemInstance_getOpenDelayTime(getNativeHandle());
	}

	public float getOpenDuration() {
		return ZenKit.API.ZkMenuItemInstance_getOpenDuration(getNativeHandle());
	}

	public int getFramePosX() {
		return ZenKit.API.ZkMenuItemInstance_getFramePosX(getNativeHandle());
	}

	public int getFramePosY() {
		return ZenKit.API.ZkMenuItemInstance_getFramePosY(getNativeHandle());
	}

	public int getFrameSizeX() {
		return ZenKit.API.ZkMenuItemInstance_getFrameSizeX(getNativeHandle());
	}

	public int getFrameSizeY() {
		return ZenKit.API.ZkMenuItemInstance_getFrameSizeY(getNativeHandle());
	}

	public String getHideIfOptionSectionSet() {
		return ZenKit.API.ZkMenuItemInstance_getHideIfOptionSectionSet(getNativeHandle());
	}

	public String getHideIfOptionSet() {
		return ZenKit.API.ZkMenuItemInstance_getHideIfOptionSet(getNativeHandle());
	}

	public int getHideOnValue() {
		return ZenKit.API.ZkMenuItemInstance_getHideOnValue(getNativeHandle());
	}

	public String getText(long i) {
		return ZenKit.API.ZkMenuItemInstance_getText(getNativeHandle(), i);
	}

	public int getOnSelAction(long i) {
		return ZenKit.API.ZkMenuItemInstance_getOnSelAction(getNativeHandle(), i);
	}

	public String getOnSelActionS(long i) {
		return ZenKit.API.ZkMenuItemInstance_getOnSelActionS(getNativeHandle(), i);
	}

	public int getOnEventAction(long i) {
		return ZenKit.API.ZkMenuItemInstance_getOnEventAction(getNativeHandle(), i);
	}

	public float getUserFloat(long i) {
		return ZenKit.API.ZkMenuItemInstance_getUserFloat(getNativeHandle(), i);
	}

	public String getUserString(long i) {
		return ZenKit.API.ZkMenuItemInstance_getUserString(getNativeHandle(), i);
	}
}
