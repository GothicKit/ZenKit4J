package dev.gothickit.zenkit.daedalus;

import com.sun.jna.Pointer;
import dev.gothickit.zenkit.capi.ZenKit;
import dev.gothickit.zenkit.daedalus.instance.*;
import org.jetbrains.annotations.Nullable;

public class DaedalusInstance {
	private final Pointer handle;

	protected DaedalusInstance(Pointer handle) {
		this.handle = handle;
	}

	public static @Nullable DaedalusInstance fromNative(Pointer handle) {
		if (handle == Pointer.NULL) return null;
		return switch (ZenKit.API.ZkDaedalusInstance_getType(handle)) {
			case GUILD_VALUES -> new GuildValuesInstance(handle);
			case NPC -> new NpcInstance(handle);
			case MISSION -> new MissionInstance(handle);
			case ITEM -> new ItemInstance(handle);
			case FOCUS -> new FocusInstance(handle);
			case INFO -> new InfoInstance(handle);
			case ITEM_REACT -> new ItemReactInstance(handle);
			case SPELL -> new SpellInstance(handle);
			case MENU -> new MenuInstance(handle);
			case MENU_ITEM -> new MenuItemInstance(handle);
			case CAMERA -> new CameraInstance(handle);
			case MUSIC_SYSTEM -> new MusicSystemInstance(handle);
			case MUSIC_THEME -> new MusicThemeInstance(handle);
			case MUSIC_JINGLE -> new MusicJingleInstance(handle);
			case PARTICLE_EFFECT -> new ParticleEffectInstance(handle);
			case EFFECT_BASE -> new EffectBaseInstance(handle);
			case PARTICLE_EFFECT_EMIT_KEY -> new ParticleEffectEmitKeyInstance(handle);
			case FIGHT_AI -> new FightAiInstance(handle);
			case SOUND_EFFECT -> new SoundEffectInstance(handle);
			case SOUND_SYSTEM -> new SoundSystemInstance(handle);
			case SVM -> new SvmInstance(handle);
			default -> new DaedalusInstance(handle);
		};
	}

	public Pointer getHandle() {
		return handle;
	}

	public DaedalusInstanceType getType() {
		return ZenKit.API.ZkDaedalusInstance_getType(handle);
	}

	public int getIndex() {
		return ZenKit.API.ZkDaedalusInstance_getIndex(handle);
	}
}
