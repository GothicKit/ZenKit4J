package dev.gothickit.zenkit.capi;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import dev.gothickit.zenkit.LogLevel;
import dev.gothickit.zenkit.vfs.VfsOverwriteBehavior;
import dev.gothickit.zenkit.Whence;
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

	interface ZkLogger extends Callback {
		void invoke(Pointer ctx, LogLevel level, String name, String message);
	}

	interface ZkVfsNodeEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer node);
	}

	final class ZkReadExt extends Structure {
		public ReadFn read;
		public SeekFn seek;
		public TellFn tell;
		public EofFn eof;
		private Pointer del = Pointer.NULL;

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
}
