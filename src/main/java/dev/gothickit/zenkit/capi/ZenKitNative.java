package dev.gothickit.zenkit.capi;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;
import dev.gothickit.zenkit.AxisAlignedBoundingBox;
import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.Whence;
import dev.gothickit.zenkit.ani.AnimationSample;
import dev.gothickit.zenkit.fnt.FontGlyph;
import dev.gothickit.zenkit.vfs.VfsOverwriteBehavior;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface ZenKitNative extends Library {
	void ZkLogger_set(LogLevel lvl, ZkLogger logger, Pointer ctx);

	void ZkLogger_setDefault(LogLevel lvl);

	void ZkLogger_log(LogLevel lvl, String name, String message);

	Pointer ZkRead_newFile(Pointer stream);

	Pointer ZkRead_newMem(Pointer bytes, long length);

	Pointer ZkRead_newPath(String path);

	Pointer ZkRead_newExt(ZkReadExt ext, Pointer ctx);

	void ZkRead_del(Pointer slf);

	Pointer ZkVfs_new();

	void ZkVfs_del(Pointer slf);

	Pointer ZkVfs_getRoot(Pointer slf);

	Pointer ZkVfs_mkdir(Pointer slf, String path);

	boolean ZkVfs_remove(Pointer slf, String path);

	void ZkVfs_mount(Pointer slf, Pointer node, String parent, VfsOverwriteBehavior overwrite);

	void ZkVfs_mountHost(Pointer slf, String path, String parent, VfsOverwriteBehavior overwrite);

	void ZkVfs_mountDisk(Pointer slf, Pointer buf, VfsOverwriteBehavior overwrite);

	void ZkVfs_mountDiskHost(Pointer slf, String path, VfsOverwriteBehavior overwrite);

	@Nullable Pointer ZkVfs_resolvePath(Pointer slf, String path);

	@Nullable Pointer ZkVfs_findNode(Pointer slf, String path);

	Pointer ZkVfsNode_newFile(String name, byte[] buf, long size, long ts);

	Pointer ZkVfsNode_newDir(String name, long ts);

	void ZkVfsNode_del(Pointer slf);

	boolean ZkVfsNode_isFile(Pointer slf);

	boolean ZkVfsNode_isDir(Pointer slf);

	long ZkVfsNode_getTime(Pointer slf);

	String ZkVfsNode_getName(Pointer slf);

	@Nullable Pointer ZkVfsNode_getChild(Pointer slf, String name);

	Pointer ZkVfsNode_create(Pointer slf, Pointer node);

	boolean ZkVfsNode_remove(Pointer slf, String name);

	Pointer ZkVfsNode_open(Pointer slf);

	void ZkVfsNode_enumerateChildren(Pointer slf, ZkVfsNodeEnumerator callback, Pointer ctx);

	Pointer ZkCutsceneLibrary_load(Pointer buf);

	Pointer ZkCutsceneLibrary_loadPath(String path);

	Pointer ZkCutsceneLibrary_loadVfs(Pointer vfs, String name);

	void ZkCutsceneLibrary_del(Pointer slf);

	Pointer ZkCutsceneLibrary_getBlock(Pointer slf, String name);

	void ZkCutsceneLibrary_enumerateBlocks(Pointer slf, ZkCutsceneBlockEnumerator cb, Pointer ctx);

	String ZkCutsceneBlock_getName(Pointer slf);

	Pointer ZkCutsceneBlock_getMessage(Pointer slf);

	int ZkCutsceneMessage_getType(Pointer slf);

	String ZkCutsceneMessage_getText(Pointer slf);

	String ZkCutsceneMessage_getName(Pointer slf);

	Pointer ZkFont_load(Pointer buf);

	Pointer ZkFont_loadPath(String path);

	Pointer ZkFont_loadVfs(Pointer vfs, String path);

	void ZkFont_del(Pointer slf);

	String ZkFont_getName(Pointer slf);

	int ZkFont_getHeight(Pointer slf);

	long ZkFont_getGlyphCount(Pointer slf);

	FontGlyph.ByValue ZkFont_getGlyph(Pointer slf, long i);

	void ZkFont_enumerateGlyphs(Pointer slf, ZkFontGlyphEnumerator cb, Pointer ctx);

	Pointer ZkModelAnimation_load(Pointer buf);

	Pointer ZkModelAnimation_loadPath(String path);

	Pointer ZkModelAnimation_loadVfs(Pointer vfs, String name);

	void ZkModelAnimation_del(Pointer slf);

	String ZkModelAnimation_getName(Pointer slf);

	String ZkModelAnimation_getNext(Pointer slf);

	int ZkModelAnimation_getLayer(Pointer slf);

	int ZkModelAnimation_getFrameCount(Pointer slf);

	int ZkModelAnimation_getNodeCount(Pointer slf);

	float ZkModelAnimation_getFps(Pointer slf);

	float ZkModelAnimation_getFpsSource(Pointer slf);

	AxisAlignedBoundingBox.ByValue ZkModelAnimation_getBbox(Pointer slf);

	long ZkModelAnimation_getChecksum(Pointer slf);

	String ZkModelAnimation_getSourcePath(Pointer slf);

	ZkDate.ByValue ZkModelAnimation_getSourceDate(Pointer slf);

	String ZkModelAnimation_getSourceScript(Pointer slf);

	long ZkModelAnimation_getSampleCount(Pointer slf);

	AnimationSample.ByValue ZkModelAnimation_getSample(Pointer slf, long i);

	void ZkModelAnimation_enumerateSamples(Pointer slf, ZkAnimationSampleEnumerator cb, Pointer ctx);

	Pointer ZkModelAnimation_getNodeIndices(Pointer slf, IntByReference size);

	interface ZkLogger extends Callback {
		void invoke(Pointer ctx, LogLevel level, String name, String message);
	}

	interface ZkVfsNodeEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer node);
	}

	interface ZkCutsceneBlockEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer block);
	}

	interface ZkFontGlyphEnumerator extends Callback {
		boolean invoke(Pointer ctx, FontGlyph.ByReference glyph);
	}

	interface ZkAnimationSampleEnumerator extends Callback {
		boolean invoke(Pointer ctx, AnimationSample.ByReference sample);
	}

	final class ZkReadExt extends Structure {
		private final Pointer del = Pointer.NULL;
		public ReadFn read;
		public SeekFn seek;
		public TellFn tell;
		public EofFn eof;

		@Override
		protected List<String> getFieldOrder() {
			return List.of("read", "seek", "tell", "eof", "del");
		}

		public interface ReadFn extends Callback {
			long invoke(Pointer ctx, Pointer buf, long len);
		}

		public interface SeekFn extends Callback {
			long invoke(Pointer ctx, long off, Whence whence);
		}

		public interface TellFn extends Callback {
			long invoke(Pointer ctx);
		}


		public interface EofFn extends Callback {
			boolean invoke(Pointer ctx);
		}
	}

	class ZkDate extends Structure {
		public int year;
		public short month;
		public short day;
		public short hour;
		public short minute;
		public short second;

		@Override
		protected List<String> getFieldOrder() {
			return List.of("year", "month", "day", "hour", "minute", "second");
		}

		public static class ByValue extends ZkDate implements Structure.ByValue {
		}
	}
}
