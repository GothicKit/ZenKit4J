package dev.gothickit.zenkit.capi;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;
import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.ani.AnimationSample;
import dev.gothickit.zenkit.fnt.FontGlyph;
import dev.gothickit.zenkit.mat.*;
import dev.gothickit.zenkit.mdh.ModelHierarchyNode;
import dev.gothickit.zenkit.mrm.*;
import dev.gothickit.zenkit.msh.Vertex;
import dev.gothickit.zenkit.ssm.SoftSkinWedgeNormal;
import dev.gothickit.zenkit.ssm.SoftSkinWeightEntry;
import dev.gothickit.zenkit.tex.TextureFormat;
import dev.gothickit.zenkit.vfs.VfsOverwriteBehavior;
import org.jetbrains.annotations.Nullable;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

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

	Pointer ZkModelHierarchy_load(Pointer buf);

	Pointer ZkModelHierarchy_loadPath(String path);

	Pointer ZkModelHierarchy_loadVfs(Pointer vfs, String name);

	void ZkModelHierarchy_del(Pointer slf);

	long ZkModelHierarchy_getNodeCount(Pointer slf);

	ModelHierarchyNode.ByValue ZkModelHierarchy_getNode(Pointer slf, long i);

	AxisAlignedBoundingBox.ByValue ZkModelHierarchy_getBbox(Pointer slf);

	AxisAlignedBoundingBox.ByValue ZkModelHierarchy_getCollisionBbox(Pointer slf);

	Vec3f.ByValue ZkModelHierarchy_getRootTranslation(Pointer slf);

	long ZkModelHierarchy_getChecksum(Pointer slf);

	ZkDate ZkModelHierarchy_getSourceDate(Pointer slf);

	String ZkModelHierarchy_getSourcePath(Pointer slf);

	void ZkModelHierarchy_enumerateNodes(Pointer slf, ZkModelHierarchyNodeEnumerator cb, Pointer ctx);

	Vec3f.ByValue ZkOrientedBoundingBox_getCenter(Pointer slf);

	Vec3f.ByValue ZkOrientedBoundingBox_getAxis(Pointer slf, long i);

	Vec3f.ByValue ZkOrientedBoundingBox_getHalfWidth(Pointer slf);

	long ZkOrientedBoundingBox_getChildCount(Pointer slf);

	Pointer ZkOrientedBoundingBox_getChild(Pointer slf, long i);

	void ZkOrientedBoundingBox_enumerateChildren(Pointer slf, ZkOrientedBoundingBoxEnumerator cb, Pointer ctx);

	AxisAlignedBoundingBox.ByValue ZkOrientedBoundingBox_toAabb(Pointer slf);

	Pointer ZkMaterial_load(Pointer buf);

	Pointer ZkMaterial_loadPath(String path);

	void ZkMaterial_del(Pointer slf);

	String ZkMaterial_getName(Pointer slf);

	MaterialGroup ZkMaterial_getGroup(Pointer slf);

	Color.ByValue ZkMaterial_getColor(Pointer slf);

	float ZkMaterial_getSmoothAngle(Pointer slf);

	String ZkMaterial_getTexture(Pointer slf);

	Vec2f.ByValue ZkMaterial_getTextureScale(Pointer slf);

	float ZkMaterial_getTextureAnimationFps(Pointer slf);

	AnimationMapping ZkMaterial_getTextureAnimationMapping(Pointer slf);

	Vec2f.ByValue ZkMaterial_getTextureAnimationMappingDirection(Pointer slf);

	boolean ZkMaterial_getDisableCollision(Pointer slf);

	boolean ZkMaterial_getDisableLightmap(Pointer slf);

	boolean ZkMaterial_getDontCollapse(Pointer slf);

	String ZkMaterial_getDetailObject(Pointer slf);

	float ZkMaterial_getDetailObjectScale(Pointer slf);

	boolean ZkMaterial_getForceOccluder(Pointer slf);

	boolean ZkMaterial_getEnvironmentMapping(Pointer slf);

	float ZkMaterial_getEnvironmentMappingStrength(Pointer slf);

	WaveMode ZkMaterial_getWaveMode(Pointer slf);

	WaveSpeed ZkMaterial_getWaveSpeed(Pointer slf);

	float ZkMaterial_getWaveAmplitude(Pointer slf);

	float ZkMaterial_getWaveGridSize(Pointer slf);

	boolean ZkMaterial_getIgnoreSun(Pointer slf);

	AlphaFunction ZkMaterial_getAlphaFunction(Pointer slf);

	Vec2f.ByValue ZkMaterial_getDefaultMapping(Pointer slf);


	Pointer ZkMultiResolutionMesh_load(Pointer buf);

	Pointer ZkMultiResolutionMesh_loadPath(String path);

	Pointer ZkMultiResolutionMesh_loadVfs(Pointer vfs, String name);

	void ZkMultiResolutionMesh_del(Pointer slf);

	Vec3f ZkMultiResolutionMesh_getPositions(Pointer slf, IntByReference count);

	Vec3f ZkMultiResolutionMesh_getNormals(Pointer slf, IntByReference count);

	long ZkMultiResolutionMesh_getSubMeshCount(Pointer slf);

	Pointer ZkMultiResolutionMesh_getSubMesh(Pointer slf, long i);

	void ZkMultiResolutionMesh_enumerateSubMeshes(Pointer slf, ZkSubMeshEnumerator cb, Pointer i);

	long ZkMultiResolutionMesh_getMaterialCount(Pointer slf);

	Pointer ZkMultiResolutionMesh_getMaterial(Pointer slf, long i);

	void ZkMultiResolutionMesh_enumerateMaterials(Pointer slf, ZkMaterialEnumerator cb, Pointer i);

	boolean ZkMultiResolutionMesh_getAlphaTest(Pointer slf);

	AxisAlignedBoundingBox.ByValue ZkMultiResolutionMesh_getBbox(Pointer slf);

	Pointer ZkMultiResolutionMesh_getOrientedBbox(Pointer slf);

	Pointer ZkSubMesh_getMaterial(Pointer slf);

	MeshTriangle ZkSubMesh_getTriangles(Pointer slf, IntByReference count);

	MeshWedge ZkSubMesh_getWedges(Pointer slf, IntByReference count);

	Pointer ZkSubMesh_getColors(Pointer slf, IntByReference count);

	Pointer ZkSubMesh_getTrianglePlaneIndices(Pointer slf, IntByReference count);

	MeshPlane ZkSubMesh_getTrianglePlanes(Pointer slf, IntByReference count);

	MeshTriangleEdge ZkSubMesh_getTriangleEdges(Pointer slf, IntByReference count);

	MeshEdge ZkSubMesh_getEdges(Pointer slf, IntByReference count);

	Pointer ZkSubMesh_getEdgeScores(Pointer slf, IntByReference count);

	Pointer ZkSubMesh_getWedgeMap(Pointer slf, IntByReference count);

	long ZkSoftSkinMesh_getNodeCount(Pointer slf);

	Pointer ZkSoftSkinMesh_getMesh(Pointer slf);

	Pointer ZkSoftSkinMesh_getBbox(Pointer slf, long node);

	void ZkSoftSkinMesh_enumerateBoundingBoxes(Pointer slf, ZkOrientedBoundingBoxEnumerator cb, Pointer ctx);

	SoftSkinWeightEntry ZkSoftSkinMesh_getWeights(Pointer slf, long node, IntByReference count);

	void ZkSoftSkinMesh_enumerateWeights(Pointer slf, ZkSoftSkinWeightEnumerator cb, Pointer ctx);

	SoftSkinWedgeNormal ZkSoftSkinMesh_getWedgeNormals(Pointer slf, IntByReference count);

	Pointer ZkSoftSkinMesh_getNodes(Pointer slf, IntByReference count);

	Pointer ZkModelMesh_load(Pointer buf);

	Pointer ZkModelMesh_loadPath(String path);

	Pointer ZkModelMesh_loadVfs(Pointer vfs, String name);

	void ZkModelMesh_del(Pointer slf);

	long ZkModelMesh_getMeshCount(Pointer slf);

	Pointer ZkModelMesh_getMesh(Pointer slf, long i);

	void ZkModelMesh_enumerateMeshes(Pointer slf, ZkSoftSkinMeshEnumerator cb, Pointer ctx);

	long ZkModelMesh_getAttachmentCount(Pointer slf);

	Pointer ZkModelMesh_getAttachment(Pointer slf, String name);

	void ZkModelMesh_enumerateAttachments(Pointer slf, ZkAttachmentEnumerator cb, Pointer ctx);

	long ZkModelMesh_getChecksum(Pointer slf);

	Pointer ZkModel_load(Pointer buf);

	Pointer ZkModel_loadPath(String path);

	Pointer ZkModel_loadVfs(Pointer vfs, String name);

	void ZkModel_del(Pointer slf);

	Pointer ZkModel_getHierarchy(Pointer slf);

	Pointer ZkModel_getMesh(Pointer slf);

	Pointer ZkTexture_load(Pointer buf);

	Pointer ZkTexture_loadPath(String path);

	Pointer ZkTexture_loadVfs(Pointer vfs, String name);

	void ZkTexture_del(Pointer slf);

	TextureFormat ZkTexture_getFormat(Pointer slf);

	int ZkTexture_getWidth(Pointer slf);

	int ZkTexture_getHeight(Pointer slf);

	int ZkTexture_getWidthMipmap(Pointer slf, long level);

	int ZkTexture_getHeightMipmap(Pointer slf, long level);

	int ZkTexture_getWidthRef(Pointer slf);

	int ZkTexture_getHeightRef(Pointer slf);

	int ZkTexture_getMipmapCount(Pointer slf);

	int ZkTexture_getAverageColor(Pointer slf);

	ZkColorArgb ZkTexture_getPalette(Pointer slf, IntByReference size);

	Pointer ZkTexture_getMipmapRaw(Pointer slf, long level, IntByReference size);

	long ZkTexture_getMipmapRgba(Pointer slf, long level, byte[] buf, long size);

	void ZkTexture_enumerateRawMipmaps(Pointer slf, ZkTextureMipmapEnumerator cb, Pointer ctx);

	void ZkTexture_enumerateRgbaMipmaps(Pointer slf, ZkTextureMipmapEnumerator cb, Pointer ctx);

	Pointer ZkMorphMesh_load(Pointer buf);

	Pointer ZkMorphMesh_loadPath(String path);

	Pointer ZkMorphMesh_loadVfs(Pointer vfs, String name);

	void ZkMorphMesh_del(Pointer slf);

	String ZkMorphMesh_getName(Pointer slf);

	Pointer ZkMorphMesh_getMesh(Pointer slf);

	Vec3f ZkMorphMesh_getMorphPositions(Pointer slf, IntByReference count);

	long ZkMorphMesh_getAnimationCount(Pointer slf);

	Pointer ZkMorphMesh_getAnimation(Pointer slf, long i);

	void ZkMorphMesh_enumerateAnimations(Pointer slf, ZkMorphAnimationEnumerator cb, Pointer ctx);

	long ZkMorphMesh_getSourceCount(Pointer slf);

	Pointer ZkMorphMesh_getSource(Pointer slf, long i);

	void ZkMorphMesh_enumerateSources(Pointer slf, ZkMorphSourceEnumerator cb, Pointer ctx);

	String ZkMorphAnimation_getName(Pointer slf);

	int ZkMorphAnimation_getLayer(Pointer slf);

	float ZkMorphAnimation_getBlendIn(Pointer slf);

	float ZkMorphAnimation_getBlendOut(Pointer slf);

	float ZkMorphAnimation_getDuration(Pointer slf);

	float ZkMorphAnimation_getSpeed(Pointer slf);

	byte ZkMorphAnimation_getFlags(Pointer slf);

	int ZkMorphAnimation_getFrameCount(Pointer slf);

	Pointer ZkMorphAnimation_getVertices(Pointer slf, IntByReference count);

	Vec3f ZkMorphAnimation_getSamples(Pointer slf, IntByReference count);

	String ZkMorphSource_getFileName(Pointer slf);

	ZkDate.ByValue ZkMorphSource_getFileDate(Pointer slf);


	Pointer ZkMesh_load(Pointer buf);

	Pointer ZkMesh_loadPath(String path);

	Pointer ZkMesh_loadVfs(Pointer vfs, String name);

	void ZkMesh_del(Pointer slf);

	ZkDate.ByValue ZkMesh_getSourceDate(Pointer slf);

	String ZkMesh_getName(Pointer slf);

	AxisAlignedBoundingBox.ByValue ZkMesh_getBoundingBox(Pointer slf);

	Pointer ZkMesh_getOrientedBoundingBox(Pointer slf);

	long ZkMesh_getMaterialCount(Pointer slf);

	Pointer ZkMesh_getMaterial(Pointer slf, long i);

	void ZkMesh_enumerateMaterials(Pointer slf, ZkMaterialEnumerator cb, Pointer ctx);

	Vec3f ZkMesh_getPositions(Pointer slf, IntByReference count);

	Vertex ZkMesh_getVertices(Pointer slf, IntByReference count);

	long ZkMesh_getLightMapCount(Pointer slf);

	Pointer ZkMesh_getLightMap(Pointer slf, long i);

	void ZkMesh_enumerateLightMaps(Pointer slf, ZkLightMapEnumerator cb, Pointer ctx);

	long ZkMesh_getPolygonCount(Pointer slf);

	Pointer ZkMesh_getPolygon(Pointer slf, long i);

	void ZkMesh_enumeratePolygons(Pointer slf, ZkPolygonEnumerator cb, Pointer ctx);

	Pointer ZkLightMap_getImage(Pointer slf);

	Vec3f.ByValue ZkLightMap_getOrigin(Pointer slf);

	Vec3f.ByValue ZkLightMap_getNormal(Pointer slf, long i);

	int ZkPolygon_getMaterialIndex(Pointer slf);

	int ZkPolygon_getLightMapIndex(Pointer slf);

	Pointer ZkPolygon_getPositionIndices(Pointer slf, IntByReference count);

	Pointer ZkPolygon_getPolygonIndices(Pointer slf, IntByReference count);

	boolean ZkPolygon_getIsPortal(Pointer slf);

	boolean ZkPolygon_getIsOccluder(Pointer slf);

	boolean ZkPolygon_getIsSector(Pointer slf);

	boolean ZkPolygon_getShouldRelight(Pointer slf);

	boolean ZkPolygon_getIsOutdoor(Pointer slf);

	boolean ZkPolygon_getIsGhostOccluder(Pointer slf);

	boolean ZkPolygon_getIsDynamicallyLit(Pointer slf);

	boolean ZkPolygon_getIsLod(Pointer slf);

	byte ZkPolygon_getNormalAxis(Pointer slf);

	short ZkPolygon_getSectorIndex(Pointer slf);

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

	interface ZkModelHierarchyNodeEnumerator extends Callback {
		boolean invoke(Pointer ctx, ModelHierarchyNode.ByReference node);
	}

	interface ZkOrientedBoundingBoxEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer box);
	}

	interface ZkSubMeshEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer mesh);
	}

	interface ZkMaterialEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer material);
	}

	interface ZkSoftSkinWeightEnumerator extends Callback {
		boolean invoke(Pointer ctx, SoftSkinWeightEntry entry, long count);
	}

	interface ZkSoftSkinMeshEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer ssm);
	}

	interface ZkAttachmentEnumerator extends Callback {
		boolean invoke(Pointer ctx, String name, Pointer mesh);
	}

	interface ZkTextureMipmapEnumerator extends Callback {
		boolean invoke(Pointer ctx, long level, Pointer data, long size);
	}

	interface ZkMorphAnimationEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer ani);
	}

	interface ZkMorphSourceEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer src);
	}

	interface ZkLightMapEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer lightMap);
	}

	interface ZkPolygonEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer polygon);
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

		public Calendar toCalendar() {
			var cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
			cal.clear();
			cal.set(year, month, day, hour, minute, second);
			return cal;
		}

		@Override
		protected List<String> getFieldOrder() {
			return List.of("year", "month", "day", "hour", "minute", "second");
		}

		public static class ByValue extends ZkDate implements Structure.ByValue {
		}
	}

	@Structure.FieldOrder({"a", "r", "g", "b"})
	class ZkColorArgb extends Structure {
		public byte a, r, g, b;
	}
}
