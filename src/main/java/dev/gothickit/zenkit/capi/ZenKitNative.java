package dev.gothickit.zenkit.capi;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;
import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.ani.AnimationSample;
import dev.gothickit.zenkit.bsp.BinarySpacePartitionNode;
import dev.gothickit.zenkit.bsp.BinarySpacePartitionType;
import dev.gothickit.zenkit.daedalus.DaedalusDataType;
import dev.gothickit.zenkit.daedalus.DaedalusInstanceType;
import dev.gothickit.zenkit.daedalus.DaedalusInstruction;
import dev.gothickit.zenkit.daedalus.instance.*;
import dev.gothickit.zenkit.fnt.FontGlyph;
import dev.gothickit.zenkit.mat.*;
import dev.gothickit.zenkit.mdh.ModelHierarchyNode;
import dev.gothickit.zenkit.mds.AnimationDirection;
import dev.gothickit.zenkit.mds.EventType;
import dev.gothickit.zenkit.mds.FightMode;
import dev.gothickit.zenkit.mrm.*;
import dev.gothickit.zenkit.msh.Vertex;
import dev.gothickit.zenkit.ssm.SoftSkinWedgeNormal;
import dev.gothickit.zenkit.ssm.SoftSkinWeightEntry;
import dev.gothickit.zenkit.tex.TextureFormat;
import dev.gothickit.zenkit.vfs.VfsOverwriteBehavior;
import dev.gothickit.zenkit.way.WayEdge;
import dev.gothickit.zenkit.world.AiType;
import dev.gothickit.zenkit.world.visual.VisualType;
import dev.gothickit.zenkit.world.vob.*;
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

	@Nullable
	Pointer ZkVfs_resolvePath(Pointer slf, String path);

	@Nullable
	Pointer ZkVfs_findNode(Pointer slf, String path);

	Pointer ZkVfsNode_newFile(String name, byte[] buf, long size, long ts);

	Pointer ZkVfsNode_newDir(String name, long ts);

	void ZkVfsNode_del(Pointer slf);

	boolean ZkVfsNode_isFile(Pointer slf);

	boolean ZkVfsNode_isDir(Pointer slf);

	long ZkVfsNode_getTime(Pointer slf);

	String ZkVfsNode_getName(Pointer slf);

	@Nullable
	Pointer ZkVfsNode_getChild(Pointer slf, String name);

	Pointer ZkVfsNode_create(Pointer slf, Pointer node);

	boolean ZkVfsNode_remove(Pointer slf, String name);

	Pointer ZkVfsNode_open(Pointer slf);

	void ZkVfsNode_enumerateChildren(Pointer slf, ZkVfsNodeEnumerator callback, Pointer ctx);

	Pointer ZkCutsceneLibrary_load(Pointer buf);

	Pointer ZkCutsceneLibrary_loadPath(String path);

	Pointer ZkCutsceneLibrary_loadVfs(Pointer vfs, String name);

	void ZkCutsceneLibrary_del(Pointer slf);

	long ZkCutsceneLibrary_getBlockCount(Pointer slf);

	Pointer ZkCutsceneLibrary_getBlock(Pointer slf, String name);

	Pointer ZkCutsceneLibrary_getBlockByIndex(Pointer slf, long i);

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

	FontGlyph ZkFont_getGlyph(Pointer slf, long i);

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

	AnimationSample ZkModelAnimation_getSample(Pointer slf, long i);

	void ZkModelAnimation_enumerateSamples(Pointer slf, ZkAnimationSampleEnumerator cb, Pointer ctx);

	Pointer ZkModelAnimation_getNodeIndices(Pointer slf, LongByReference size);

	Pointer ZkModelHierarchy_load(Pointer buf);

	Pointer ZkModelHierarchy_loadPath(String path);

	Pointer ZkModelHierarchy_loadVfs(Pointer vfs, String name);

	void ZkModelHierarchy_del(Pointer slf);

	long ZkModelHierarchy_getNodeCount(Pointer slf);

	ModelHierarchyNode ZkModelHierarchy_getNode(Pointer slf, long i);

	AxisAlignedBoundingBox.ByValue ZkModelHierarchy_getBbox(Pointer slf);

	AxisAlignedBoundingBox.ByValue ZkModelHierarchy_getCollisionBbox(Pointer slf);

	Vec3f ZkModelHierarchy_getRootTranslation(Pointer slf);

	long ZkModelHierarchy_getChecksum(Pointer slf);

	ZkDate ZkModelHierarchy_getSourceDate(Pointer slf);

	String ZkModelHierarchy_getSourcePath(Pointer slf);

	void ZkModelHierarchy_enumerateNodes(Pointer slf, ZkModelHierarchyNodeEnumerator cb, Pointer ctx);

	Vec3f ZkOrientedBoundingBox_getCenter(Pointer slf);

	Vec3f ZkOrientedBoundingBox_getAxis(Pointer slf, long i);

	Vec3f ZkOrientedBoundingBox_getHalfWidth(Pointer slf);

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

	Vec2f ZkMaterial_getTextureScale(Pointer slf);

	float ZkMaterial_getTextureAnimationFps(Pointer slf);

	AnimationMapping ZkMaterial_getTextureAnimationMapping(Pointer slf);

	Vec2f ZkMaterial_getTextureAnimationMappingDirection(Pointer slf);

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

	Vec2f ZkMaterial_getDefaultMapping(Pointer slf);


	Pointer ZkMultiResolutionMesh_load(Pointer buf);

	Pointer ZkMultiResolutionMesh_loadPath(String path);

	Pointer ZkMultiResolutionMesh_loadVfs(Pointer vfs, String name);

	void ZkMultiResolutionMesh_del(Pointer slf);

	long ZkMultiResolutionMesh_getPositionCount(Pointer slf);

	Vec3f ZkMultiResolutionMesh_getPosition(Pointer slf, long i);

	long ZkMultiResolutionMesh_getNormalCount(Pointer slf);

	Vec3f ZkMultiResolutionMesh_getNormal(Pointer slf, long i);

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

	long ZkSubMesh_getWedgeCount(Pointer slf);

	MeshWedge.ByValue ZkSubMesh_getWedge(Pointer slf, long i);

	Pointer ZkSubMesh_getColors(Pointer slf, IntByReference count);

	Pointer ZkSubMesh_getTrianglePlaneIndices(Pointer slf, IntByReference count);

	long ZkSubMesh_getTrianglePlaneCount(Pointer slf);

	MeshPlane.ByValue ZkSubMesh_getTrianglePlane(Pointer slf, long i);

	MeshTriangleEdge ZkSubMesh_getTriangleEdges(Pointer slf, IntByReference count);

	MeshEdge ZkSubMesh_getEdges(Pointer slf, IntByReference count);

	Pointer ZkSubMesh_getEdgeScores(Pointer slf, IntByReference count);

	Pointer ZkSubMesh_getWedgeMap(Pointer slf, IntByReference count);

	long ZkSoftSkinMesh_getNodeCount(Pointer slf);

	Pointer ZkSoftSkinMesh_getMesh(Pointer slf);

	Pointer ZkSoftSkinMesh_getBbox(Pointer slf, long node);

	void ZkSoftSkinMesh_enumerateBoundingBoxes(Pointer slf, ZkOrientedBoundingBoxEnumerator cb, Pointer ctx);

	long ZkSoftSkinMesh_getWeightTotal(Pointer slf);

	long ZkSoftSkinMesh_getWeightCount(Pointer slf, long node);

	SoftSkinWeightEntry.ByValue ZkSoftSkinMesh_getWeight(Pointer slf, long node, long i);

	long ZkSoftSkinMesh_getWedgeNormalCount(Pointer slf);

	SoftSkinWedgeNormal ZkSoftSkinMesh_getWedgeNormal(Pointer slf, long i);

	Pointer ZkSoftSkinMesh_getNodes(Pointer slf, LongByReference count);

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

	long ZkMorphMesh_getMorphPositionCount(Pointer slf);

	Vec3f ZkMorphMesh_getMorphPosition(Pointer slf, long i);

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

	Pointer ZkMorphAnimation_getVertices(Pointer slf, LongByReference count);

	long ZkMorphAnimation_getSampleCount(Pointer slf);

	Vec3f ZkMorphAnimation_getSample(Pointer slf, long i);

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

	long ZkMesh_getPositionCount(Pointer slf);

	Vec3f ZkMesh_getPosition(Pointer slf, long i);

	long ZkMesh_getVertexCount(Pointer slf);

	Vertex ZkMesh_getVertex(Pointer slf, long i);

	long ZkMesh_getLightMapCount(Pointer slf);

	Pointer ZkMesh_getLightMap(Pointer slf, long i);

	void ZkMesh_enumerateLightMaps(Pointer slf, ZkLightMapEnumerator cb, Pointer ctx);

	long ZkMesh_getPolygonCount(Pointer slf);

	Pointer ZkMesh_getPolygon(Pointer slf, long i);

	void ZkMesh_enumeratePolygons(Pointer slf, ZkPolygonEnumerator cb, Pointer ctx);

	Pointer ZkLightMap_getImage(Pointer slf);

	Vec3f ZkLightMap_getOrigin(Pointer slf);

	Vec3f ZkLightMap_getNormal(Pointer slf, long i);

	int ZkPolygon_getMaterialIndex(Pointer slf);

	int ZkPolygon_getLightMapIndex(Pointer slf);

	Pointer ZkPolygon_getPositionIndices(Pointer slf, Pointer msh, LongByReference count);

	Pointer ZkPolygon_getFeatureIndices(Pointer slf, Pointer msh, LongByReference count);

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

	Pointer ZkModelScript_load(Pointer buf);

	Pointer ZkModelScript_loadPath(String path);

	Pointer ZkModelScript_loadVfs(Pointer vfs, String name);

	void ZkModelScript_del(Pointer slf);

	String ZkModelScript_getSkeletonName(Pointer slf);

	boolean ZkModelScript_getSkeletonMeshDisabled(Pointer slf);

	long ZkModelScript_getMeshCount(Pointer slf);

	long ZkModelScript_getDisabledAnimationsCount(Pointer slf);

	long ZkModelScript_getAnimationCombineCount(Pointer slf);

	long ZkModelScript_getAnimationBlendCount(Pointer slf);

	long ZkModelScript_getAnimationAliasCount(Pointer slf);

	long ZkModelScript_getModelTagCount(Pointer slf);

	long ZkModelScript_getAnimationCount(Pointer slf);

	String ZkModelScript_getDisabledAnimation(Pointer slf, long i);

	String ZkModelScript_getMesh(Pointer slf, long i);

	Pointer ZkModelScript_getAnimationCombine(Pointer slf, long i);

	Pointer ZkModelScript_getAnimationBlend(Pointer slf, long i);

	Pointer ZkModelScript_getAnimationAlias(Pointer slf, long i);

	String ZkModelScript_getModelTag(Pointer slf, long i);

	Pointer ZkModelScript_getAnimation(Pointer slf, long i);

	void ZkModelScript_enumerateAnimationCombines(Pointer slf, ZkAnimationCombineEnumerator cb, Pointer ctx);

	void ZkModelScript_enumerateMeshes(Pointer slf, ZkStringEnumerator cb, Pointer ctx);

	void ZkModelScript_enumerateDisabledAnimations(Pointer slf, ZkStringEnumerator cb, Pointer ctx);

	void ZkModelScript_enumerateAnimationBlends(Pointer slf, ZkAnimationBlendEnumerator cb, Pointer ctx);

	void ZkModelScript_enumerateAnimationAliases(Pointer slf, ZkAnimationAliasEnumerator cb, Pointer ctx);

	void ZkModelScript_enumerateModelTags(Pointer slf, ZkStringEnumerator cb, Pointer ctx);

	void ZkModelScript_enumerateAnimations(Pointer slf, ZkAnimationEnumerator cb, Pointer ctx);

	String ZkAnimation_getName(Pointer slf);

	int ZkAnimation_getLayer(Pointer slf);

	String ZkAnimation_getNext(Pointer slf);

	float ZkAnimation_getBlendIn(Pointer slf);

	float ZkAnimation_getBlendOut(Pointer slf);

	int ZkAnimation_getFlags(Pointer slf);

	String ZkAnimation_getModel(Pointer slf);

	AnimationDirection ZkAnimation_getDirection(Pointer slf);

	int ZkAnimation_getFirstFrame(Pointer slf);

	int ZkAnimation_getLastFrame(Pointer slf);

	float ZkAnimation_getFps(Pointer slf);

	float ZkAnimation_getSpeed(Pointer slf);

	float ZkAnimation_getCollisionVolumeScale(Pointer slf);

	long ZkAnimation_getEventTagCount(Pointer slf);

	long ZkAnimation_getParticleEffectCount(Pointer slf);

	long ZkAnimation_getParticleEffectStopCount(Pointer slf);

	long ZkAnimation_getSoundEffectCount(Pointer slf);

	long ZkAnimation_getSoundEffectGroundCount(Pointer slf);

	long ZkAnimation_getMorphAnimationCount(Pointer slf);

	long ZkAnimation_getCameraTremorCount(Pointer slf);

	Pointer ZkAnimation_getEventTag(Pointer slf, long i);

	Pointer ZkAnimation_getParticleEffect(Pointer slf, long i);

	Pointer ZkAnimation_getParticleEffectStop(Pointer slf, long i);

	Pointer ZkAnimation_getSoundEffect(Pointer slf, long i);

	Pointer ZkAnimation_getSoundEffectGround(Pointer slf, long i);

	Pointer ZkAnimation_getMorphAnimation(Pointer slf, long i);

	Pointer ZkAnimation_getCameraTremor(Pointer slf, long i);

	void ZkAnimation_enumerateEventTags(Pointer slf, ZkEventTagEnumerator cb, Pointer ctx);

	void ZkAnimation_enumerateParticleEffects(Pointer slf, ZkEventParticleEffectEnumerator cb, Pointer ctx);

	void ZkAnimation_enumerateParticleEffectStops(Pointer slf, ZkEventParticleEffectStopEnumerator cb, Pointer ctx);

	void ZkAnimation_enumerateSoundEffects(Pointer slf, ZkEventSoundEffectEnumerator cb, Pointer ctx);

	void ZkAnimation_enumerateSoundEffectGrounds(Pointer slf, ZkEventSoundEffectGroundEnumerator cb, Pointer ctx);

	void ZkAnimation_enumerateMorphAnimations(Pointer slf, ZkEventMorphAnimationEnumerator cb, Pointer ctx);

	void ZkAnimation_enumerateCameraTremors(Pointer slf, ZkEventCameraTremorEnumerator cb, Pointer ctx);

	int ZkEventTag_getFrame(Pointer slf);

	EventType ZkEventTag_getType(Pointer slf);

	String ZkEventTag_getSlot(Pointer slf, long i);

	String ZkEventTag_getItem(Pointer slf);

	Pointer ZkEventTag_getFrames(Pointer slf, LongByReference count);

	FightMode ZkEventTag_getFightMode(Pointer slf);

	boolean ZkEventTag_getIsAttached(Pointer slf);

	int ZkEventParticleEffect_getFrame(Pointer slf);

	int ZkEventParticleEffect_getIndex(Pointer slf);

	String ZkEventParticleEffect_getName(Pointer slf);

	String ZkEventParticleEffect_getPosition(Pointer slf);

	boolean ZkEventParticleEffect_getIsAttached(Pointer slf);

	int ZkEventParticleEffectStop_getFrame(Pointer slf);

	int ZkEventParticleEffectStop_getIndex(Pointer slf);

	int ZkEventCameraTremor_getFrame(Pointer slf);

	int ZkEventCameraTremor_getField1(Pointer slf);

	int ZkEventCameraTremor_getField2(Pointer slf);

	int ZkEventCameraTremor_getField3(Pointer slf);

	int ZkEventCameraTremor_getField4(Pointer slf);

	int ZkEventSoundEffect_getFrame(Pointer slf);

	String ZkEventSoundEffect_getName(Pointer slf);

	float ZkEventSoundEffect_getRange(Pointer slf);

	boolean ZkEventSoundEffect_getEmptySlot(Pointer slf);

	int ZkEventSoundEffectGround_getFrame(Pointer slf);

	String ZkEventSoundEffectGround_getName(Pointer slf);

	float ZkEventSoundEffectGround_getRange(Pointer slf);

	boolean ZkEventSoundEffectGround_getEmptySlot(Pointer slf);

	int ZkMorphAnimation_getFrame(Pointer slf);

	String ZkMorphAnimation_getAnimation(Pointer slf);

	String ZkMorphAnimation_getNode(Pointer slf);

	String ZkAnimationCombine_getName(Pointer slf);

	int ZkAnimationCombine_getLayer(Pointer slf);

	String ZkAnimationCombine_getNext(Pointer slf);

	float ZkAnimationCombine_getBlendIn(Pointer slf);

	float ZkAnimationCombine_getBlendOut(Pointer slf);

	int ZkAnimationCombine_getFlags(Pointer slf);

	String ZkAnimationCombine_getModel(Pointer slf);

	int ZkAnimationCombine_getLastFrame(Pointer slf);

	String ZkAnimationBlend_getName(Pointer slf);

	String ZkAnimationBlend_getNext(Pointer slf);

	float ZkAnimationBlend_getBlendIn(Pointer slf);

	float ZkAnimationBlend_getBlendOut(Pointer slf);

	String ZkAnimationAlias_getName(Pointer slf);

	int ZkAnimationAlias_getLayer(Pointer slf);

	String ZkAnimationAlias_getNext(Pointer slf);

	float ZkAnimationAlias_getBlendIn(Pointer slf);

	float ZkAnimationAlias_getBlendOut(Pointer slf);

	int ZkAnimationAlias_getFlags(Pointer slf);

	String ZkAnimationAlias_getAlias(Pointer slf);

	AnimationDirection ZkAnimationAlias_getDirection(Pointer slf);

	BinarySpacePartitionType ZkBspTree_getType(Pointer slf);

	Pointer ZkBspTree_getPolygonIndices(Pointer slf, IntByReference count);

	Pointer ZkBspTree_getLeafPolygonIndices(Pointer slf, IntByReference count);

	Pointer ZkBspTree_getPortalPolygonIndices(Pointer slf, IntByReference count);

	long ZkBspTree_getLightPointCount(Pointer slf);

	Vec3f ZkBspTree_getLightPoint(Pointer slf, long i);

	Pointer ZkBspTree_getLeafNodeIndices(Pointer slf, IntByReference count);

	long ZkBspTree_getNodeCount(Pointer slf);

	BinarySpacePartitionNode ZkBspTree_getNode(Pointer slf, long i);

	long ZkBspTree_getSectorCount(Pointer slf);

	Pointer ZkBspTree_getSector(Pointer slf, long i);

	void ZkBspTree_enumerateSectors(Pointer slf, ZkBspSectorEnumerator cb, Pointer ctx);

	String ZkBspSector_getName(Pointer slf);

	Pointer ZkBspSector_getNodeIndices(Pointer slf, LongByReference count);

	Pointer ZkBspSector_getPortalPolygonIndices(Pointer slf, LongByReference count);

	WayEdge ZkWayNet_getEdges(Pointer slf, LongByReference count);

	long ZkWayNet_getPointCount(Pointer slf);

	Pointer ZkWayNet_getPoint(Pointer slf, long i);

	void ZkWayNet_enumeratePoints(Pointer slf, ZkWayPointEnumerator cb, Pointer ctx);

	String ZkWayPoint_getName(Pointer slf);

	int ZkWayPoint_getWaterDepth(Pointer slf);

	boolean ZkWayPoint_getUnderWater(Pointer slf);

	Vec3f ZkWayPoint_getPosition(Pointer slf);

	Vec3f ZkWayPoint_getDirection(Pointer slf);

	boolean ZkWayPoint_getFreePoint(Pointer slf);

	Pointer ZkWorld_load(Pointer buf);

	Pointer ZkWorld_loadPath(String path);

	Pointer ZkWorld_loadVfs(Pointer vfs, String name);

	void ZkWorld_del(Pointer slf);

	Pointer ZkWorld_getMesh(Pointer slf);

	Pointer ZkWorld_getWayNet(Pointer slf);

	Pointer ZkWorld_getBspTree(Pointer slf);

	long ZkWorld_getRootObjectCount(Pointer slf);

	Pointer ZkWorld_getRootObject(Pointer slf, long i);

	void ZkWorld_enumerateRootObjects(Pointer slf, ZkVirtualObjectEnumerator cb, Pointer ctx);

	Pointer ZkObject_takeRef(Pointer obj);

	Pointer ZkVirtualObject_load(Pointer buf, GameVersion version);

	Pointer ZkVirtualObject_loadPath(String path, GameVersion version);

	Pointer ZkVirtualObject_new(VirtualObjectType type);

	void ZkVirtualObject_del(Pointer slf);

	VirtualObjectType ZkVirtualObject_getType(Pointer slf);

	int ZkVirtualObject_getId(Pointer slf);

	AxisAlignedBoundingBox.ByValue ZkVirtualObject_getBbox(Pointer slf);

	Vec3f ZkVirtualObject_getPosition(Pointer slf);

	Mat3x3.ByValue ZkVirtualObject_getRotation(Pointer slf);

	boolean ZkVirtualObject_getShowVisual(Pointer slf);

	SpriteAlignment ZkVirtualObject_getSpriteCameraFacingMode(Pointer slf);

	boolean ZkVirtualObject_getCdStatic(Pointer slf);

	boolean ZkVirtualObject_getCdDynamic(Pointer slf);

	boolean ZkVirtualObject_getVobStatic(Pointer slf);

	ShadowType ZkVirtualObject_getDynamicShadows(Pointer slf);

	boolean ZkVirtualObject_getPhysicsEnabled(Pointer slf);

	AnimationType ZkVirtualObject_getAnimMode(Pointer slf);

	int ZkVirtualObject_getBias(Pointer slf);

	boolean ZkVirtualObject_getAmbient(Pointer slf);

	float ZkVirtualObject_getAnimStrength(Pointer slf);

	float ZkVirtualObject_getFarClipScale(Pointer slf);

	String ZkVirtualObject_getPresetName(Pointer slf);

	String ZkVirtualObject_getName(Pointer slf);

	Pointer ZkVirtualObject_getVisual(Pointer slf);

	void ZkVirtualObject_setVisual(Pointer slf, Pointer visual);

	byte ZkVirtualObject_getSleepMode(Pointer slf);

	void ZkVirtualObject_setSleepMode(Pointer slf, byte sleepMode);

	float ZkVirtualObject_getNextOnTimer(Pointer slf);

	void ZkVirtualObject_setNextOnTimer(Pointer slf, float nextOnTimer);

	Pointer ZkVirtualObject_getAi(Pointer slf);

	void ZkVirtualObject_setAi(Pointer slf, Pointer ai);

	Pointer ZkVirtualObject_getEventManager(Pointer slf);

	void ZkVirtualObject_setEventManager(Pointer slf, Pointer em);

	long ZkVirtualObject_getChildCount(Pointer slf);

	Pointer ZkVirtualObject_getChild(Pointer slf, long i);

	void ZkVirtualObject_enumerateChildren(Pointer slf, ZkVirtualObjectEnumerator cb, Pointer ctx);

	void ZkVirtualObject_addChild(Pointer slf, Pointer child);

	void ZkVirtualObject_setBbox(Pointer slf, AxisAlignedBoundingBox.ByValue val);

	void ZkVirtualObject_setPosition(Pointer slf, Vec3f val);

	void ZkVirtualObject_setRotation(Pointer slf, Mat3x3.ByValue val);

	void ZkVirtualObject_setShowVisual(Pointer slf, boolean val);

	void ZkVirtualObject_setSpriteCameraFacingMode(Pointer slf, SpriteAlignment val);

	void ZkVirtualObject_setCdStatic(Pointer slf, boolean val);

	void ZkVirtualObject_setCdDynamic(Pointer slf, boolean val);

	void ZkVirtualObject_setVobStatic(Pointer slf, boolean val);

	void ZkVirtualObject_setDynamicShadows(Pointer slf, ShadowType val);

	void ZkVirtualObject_setPhysicsEnabled(Pointer slf, boolean val);

	void ZkVirtualObject_setAnimMode(Pointer slf, AnimationType val);

	void ZkVirtualObject_setBias(Pointer slf, int val);

	void ZkVirtualObject_setAmbient(Pointer slf, boolean val);

	void ZkVirtualObject_setAnimStrength(Pointer slf, float val);

	void ZkVirtualObject_setFarClipScale(Pointer slf, float val);

	void ZkVirtualObject_setPresetName(Pointer slf, String val);

	void ZkVirtualObject_setName(Pointer slf, String val);

	Pointer ZkVisual_new(VisualType type);

	void ZkVisual_del(Pointer slf);

	String ZkVisual_getName(Pointer slf);

	VisualType ZkVisual_getType(Pointer slf);

	void ZkVisual_setName(Pointer slf, String val);

	Vec2f ZkVisualDecal_getDimension(Pointer slf);

	Vec2f ZkVisualDecal_getOffset(Pointer slf);

	boolean ZkVisualDecal_getTwoSided(Pointer slf);

	AlphaFunction ZkVisualDecal_getAlphaFunc(Pointer slf);

	float ZkVisualDecal_getTextureAnimFps(Pointer slf);

	byte ZkVisualDecal_getAlphaWeight(Pointer slf);

	boolean ZkVisualDecal_getIgnoreDaylight(Pointer slf);

	void ZkVisualDecal_setDimension(Pointer slf, Vec2f val);

	void ZkVisualDecal_setOffset(Pointer slf, Vec2f val);

	void ZkVisualDecal_setTwoSided(Pointer slf, boolean val);

	void ZkVisualDecal_setAlphaFunc(Pointer slf, AlphaFunction val);

	void ZkVisualDecal_setTextureAnimFps(Pointer slf, float val);

	void ZkVisualDecal_setAlphaWeight(Pointer slf, byte val);

	void ZkVisualDecal_setIgnoreDaylight(Pointer slf, boolean val);

	Pointer ZkAi_new(AiType type);

	void ZkAi_del(Pointer slf);

	AiType ZkAi_getType(Pointer slf);

	float ZkAiHuman_getFloorY(Pointer slf);

	float ZkAiHuman_getWaterY(Pointer slf);

	float ZkAiHuman_getCeilY(Pointer slf);

	float ZkAiHuman_getFeetY(Pointer slf);

	float ZkAiHuman_getHeadY(Pointer slf);

	float ZkAiHuman_getFallDistY(Pointer slf);

	float ZkAiHuman_getFallStartY(Pointer slf);

	Pointer ZkAiHuman_getNpc(Pointer slf);

	int ZkAiHuman_getWalkMode(Pointer slf);

	int ZkAiHuman_getWeaponMode(Pointer slf);

	int ZkAiHuman_getWmodeAst(Pointer slf);

	int ZkAiHuman_getWmodeSelect(Pointer slf);

	boolean ZkAiHuman_getChangeWeapon(Pointer slf);

	int ZkAiHuman_getActionMode(Pointer slf);

	void ZkAiHuman_setWaterLevel(Pointer slf, int water_level);

	void ZkAiHuman_setFloorY(Pointer slf, float floor_y);

	void ZkAiHuman_setWaterY(Pointer slf, float water_y);

	void ZkAiHuman_setCeilY(Pointer slf, float ceil_y);

	void ZkAiHuman_setFeetY(Pointer slf, float feet_y);

	void ZkAiHuman_setHeadY(Pointer slf, float head_y);

	void ZkAiHuman_setFallDistY(Pointer slf, float fall_dist_y);

	void ZkAiHuman_setFallStartY(Pointer slf, float fall_start_y);

	void ZkAiHuman_setNpc(Pointer slf, Pointer npc);

	void ZkAiHuman_setWalkMode(Pointer slf, int walk_mode);

	void ZkAiHuman_setWeaponMode(Pointer slf, int weapon_mode);

	void ZkAiHuman_setWmodeAst(Pointer slf, int wmode_ast);

	void ZkAiHuman_setWmodeSelect(Pointer slf, int wmode_select);

	void ZkAiHuman_setChangeWeapon(Pointer slf, boolean change_weapon);

	void ZkAiHuman_setActionMode(Pointer slf, int action_mode);

	Pointer ZkAiMove_getVob(Pointer slf);

	Pointer ZkAiMove_getOwner(Pointer slf);

	void ZkAiMove_setVob(Pointer slf, Pointer vob);

	void ZkAiMove_setOwner(Pointer slf, Pointer owner);

	Pointer ZkEventManager_new();

	void ZkEventManager_del(Pointer slf);

	boolean ZkEventManager_getCleared(Pointer slf);

	void ZkEventManager_setCleared(Pointer slf, boolean cleared);

	boolean ZkEventManager_getActive(Pointer slf);

	void ZkEventManager_setActive(Pointer slf, boolean active);

	Pointer ZkCutsceneCamera_load(Pointer buf, GameVersion version);

	Pointer ZkCutsceneCamera_loadPath(String path, GameVersion version);

	void ZkCutsceneCamera_del(Pointer slf);

	CameraTrajectory ZkCutsceneCamera_getTrajectoryFOR(Pointer slf);

	CameraTrajectory ZkCutsceneCamera_getTargetTrajectoryFOR(Pointer slf);

	CameraLoopType ZkCutsceneCamera_getLoopMode(Pointer slf);

	CameraLerpType ZkCutsceneCamera_getLerpMode(Pointer slf);

	boolean ZkCutsceneCamera_getIgnoreFORVobRotation(Pointer slf);

	boolean ZkCutsceneCamera_getIgnoreFORVobRotationTarget(Pointer slf);

	boolean ZkCutsceneCamera_getAdapt(Pointer slf);

	boolean ZkCutsceneCamera_getEaseFirst(Pointer slf);

	boolean ZkCutsceneCamera_getEaseLast(Pointer slf);

	float ZkCutsceneCamera_getTotalDuration(Pointer slf);

	String ZkCutsceneCamera_getAutoFocusVob(Pointer slf);

	boolean ZkCutsceneCamera_getAutoPlayerMovable(Pointer slf);

	boolean ZkCutsceneCamera_getAutoUntriggerLast(Pointer slf);

	float ZkCutsceneCamera_getAutoUntriggerLastDelay(Pointer slf);

	int ZkCutsceneCamera_getPositionCount(Pointer slf);

	int ZkCutsceneCamera_getTargetCount(Pointer slf);

	long ZkCutsceneCamera_getFrameCount(Pointer slf);

	void ZkCutsceneCamera_setTrajectoryFOR(Pointer slf, CameraTrajectory val);

	void ZkCutsceneCamera_setTargetTrajectoryFOR(Pointer slf, CameraTrajectory val);

	void ZkCutsceneCamera_setLoopMode(Pointer slf, CameraLoopType val);

	void ZkCutsceneCamera_setLerpMode(Pointer slf, CameraLerpType val);

	void ZkCutsceneCamera_setIgnoreFORVobRotation(Pointer slf, boolean val);

	void ZkCutsceneCamera_setIgnoreFORVobRotationTarget(Pointer slf, boolean val);

	void ZkCutsceneCamera_setAdapt(Pointer slf, boolean val);

	void ZkCutsceneCamera_setEaseFirst(Pointer slf, boolean val);

	void ZkCutsceneCamera_setEaseLast(Pointer slf, boolean val);

	void ZkCutsceneCamera_setTotalDuration(Pointer slf, float val);

	void ZkCutsceneCamera_setAutoFocusVob(Pointer slf, String val);

	void ZkCutsceneCamera_setAutoPlayerMovable(Pointer slf, boolean val);

	void ZkCutsceneCamera_setAutoUntriggerLast(Pointer slf, boolean val);

	void ZkCutsceneCamera_setAutoUntriggerLastDelay(Pointer slf, float val);

	boolean ZkCutsceneCamera_getIsPaused(Pointer slf);

	void ZkCutsceneCamera_setIsPaused(Pointer slf, boolean isPaused);

	boolean ZkCutsceneCamera_getIsStarted(Pointer slf);

	void ZkCutsceneCamera_setIsStarted(Pointer slf, boolean isStarted);

	boolean ZkCutsceneCamera_getGotoTimeMode(Pointer slf);

	void ZkCutsceneCamera_setGotoTimeMode(Pointer slf, boolean gotoTimeMode);

	float ZkCutsceneCamera_getTime(Pointer slf);

	void ZkCutsceneCamera_setTime(Pointer slf, float time);

	Pointer ZkCutsceneCamera_getFrame(Pointer slf, long i);

	void ZkCutsceneCamera_enumerateFrames(Pointer slf, ZkCameraTrajectoryFrameEnumerator cb, Pointer ctx);

	void ZkCameraTrajectoryFrame_del(Pointer slf);

	float ZkCameraTrajectoryFrame_getTime(Pointer slf);

	float ZkCameraTrajectoryFrame_getRollAngle(Pointer slf);

	float ZkCameraTrajectoryFrame_getFovScale(Pointer slf);

	CameraMotion ZkCameraTrajectoryFrame_getMotionType(Pointer slf);

	CameraMotion ZkCameraTrajectoryFrame_getMotionTypeFov(Pointer slf);

	CameraMotion ZkCameraTrajectoryFrame_getMotionTypeRoll(Pointer slf);

	CameraMotion ZkCameraTrajectoryFrame_getMotionTypeTimeScale(Pointer slf);

	float ZkCameraTrajectoryFrame_getTension(Pointer slf);

	float ZkCameraTrajectoryFrame_getCamBias(Pointer slf);

	float ZkCameraTrajectoryFrame_getContinuity(Pointer slf);

	float ZkCameraTrajectoryFrame_getTimeScale(Pointer slf);

	boolean ZkCameraTrajectoryFrame_getTimeFixed(Pointer slf);

	Mat4x4.ByValue ZkCameraTrajectoryFrame_getOriginalPose(Pointer slf);

	void ZkCameraTrajectoryFrame_setTime(Pointer slf, float val);

	void ZkCameraTrajectoryFrame_setRollAngle(Pointer slf, float val);

	void ZkCameraTrajectoryFrame_setFovScale(Pointer slf, float val);

	void ZkCameraTrajectoryFrame_setMotionType(Pointer slf, CameraMotion val);

	void ZkCameraTrajectoryFrame_setMotionTypeFov(Pointer slf, CameraMotion val);

	void ZkCameraTrajectoryFrame_setMotionTypeRoll(Pointer slf, CameraMotion val);

	void ZkCameraTrajectoryFrame_setMotionTypeTimeScale(Pointer slf, CameraMotion val);

	void ZkCameraTrajectoryFrame_setTension(Pointer slf, float val);

	void ZkCameraTrajectoryFrame_setCamBias(Pointer slf, float val);

	void ZkCameraTrajectoryFrame_setContinuity(Pointer slf, float val);

	void ZkCameraTrajectoryFrame_setTimeScale(Pointer slf, float val);

	void ZkCameraTrajectoryFrame_setTimeFixed(Pointer slf, boolean val);

	void ZkCameraTrajectoryFrame_setOriginalPose(Pointer slf, Mat4x4.ByValue val);

	Pointer ZkLightPreset_load(Pointer buf, GameVersion version);

	Pointer ZkLightPreset_loadPath(String path, GameVersion version);

	void ZkLightPreset_del(Pointer slf);

	Pointer ZkLight_load(Pointer slf, GameVersion version);

	Pointer ZkLight_loadPath(String path, GameVersion version);

	void ZkLight_del(Pointer slf);

	String ZkLightPreset_getPreset(Pointer slf);

	LightType ZkLightPreset_getLightType(Pointer slf);

	float ZkLightPreset_getRange(Pointer slf);

	Color.ByValue ZkLightPreset_getColor(Pointer slf);

	float ZkLightPreset_getConeAngle(Pointer slf);

	boolean ZkLightPreset_getIsStatic(Pointer slf);

	LightQuality ZkLightPreset_getQuality(Pointer slf);

	String ZkLightPreset_getLensflareFx(Pointer slf);

	boolean ZkLightPreset_getOn(Pointer slf);

	Pointer ZkLightPreset_getRangeAnimationScale(Pointer slf, IntByReference count);

	float ZkLightPreset_getRangeAnimationFps(Pointer slf);

	boolean ZkLightPreset_getRangeAnimationSmooth(Pointer slf);

	long ZkLightPreset_getColorAnimationCount(Pointer slf);

	Color.ByValue ZkLightPreset_getColorAnimationItem(Pointer slf, long i);

	float ZkLightPreset_getColorAnimationFps(Pointer slf);

	boolean ZkLightPreset_getColorAnimationSmooth(Pointer slf);

	boolean ZkLightPreset_getCanMove(Pointer slf);

	void ZkLightPreset_setPreset(Pointer slf, String val);

	void ZkLightPreset_setLightType(Pointer slf, LightType val);

	void ZkLightPreset_setRange(Pointer slf, float val);

	void ZkLightPreset_setColor(Pointer slf, Color val);

	void ZkLightPreset_setConeAngle(Pointer slf, float val);

	void ZkLightPreset_setIsStatic(Pointer slf, boolean val);

	void ZkLightPreset_setQuality(Pointer slf, LightQuality val);

	void ZkLightPreset_setLensflareFx(Pointer slf, String val);

	void ZkLightPreset_setOn(Pointer slf, boolean val);

	void ZkLightPreset_setRangeAnimationScale(Pointer slf, float[] val, long count);

	void ZkLightPreset_setRangeAnimationFps(Pointer slf, float val);

	void ZkLightPreset_setRangeAnimationSmooth(Pointer slf, boolean val);

	void ZkLightPreset_setColorAnimationFps(Pointer slf, float val);

	void ZkLightPreset_setColorAnimationSmooth(Pointer slf, boolean val);

	void ZkLightPreset_setCanMove(Pointer slf, boolean val);

	String ZkLight_getPreset(Pointer slf);

	LightType ZkLight_getLightType(Pointer slf);

	float ZkLight_getRange(Pointer slf);

	Color.ByValue ZkLight_getColor(Pointer slf);

	float ZkLight_getConeAngle(Pointer slf);

	boolean ZkLight_getIsStatic(Pointer slf);

	LightQuality ZkLight_getQuality(Pointer slf);

	String ZkLight_getLensflareFx(Pointer slf);

	boolean ZkLight_getOn(Pointer slf);

	Pointer ZkLight_getRangeAnimationScale(Pointer slf, IntByReference count);

	float ZkLight_getRangeAnimationFps(Pointer slf);

	boolean ZkLight_getRangeAnimationSmooth(Pointer slf);

	long ZkLight_getColorAnimationCount(Pointer slf);

	Color.ByValue ZkLight_getColorAnimationItem(Pointer slf, long i);

	float ZkLight_getColorAnimationFps(Pointer slf);

	boolean ZkLight_getColorAnimationSmooth(Pointer slf);

	boolean ZkLight_getCanMove(Pointer slf);

	void ZkLight_setPreset(Pointer slf, String val);

	void ZkLight_setLightType(Pointer slf, LightType val);

	void ZkLight_setRange(Pointer slf, float val);

	void ZkLight_setColor(Pointer slf, Color val);

	void ZkLight_setConeAngle(Pointer slf, float val);

	void ZkLight_setIsStatic(Pointer slf, boolean val);

	void ZkLight_setQuality(Pointer slf, LightQuality val);

	void ZkLight_setLensflareFx(Pointer slf, String val);

	void ZkLight_setOn(Pointer slf, boolean val);

	void ZkLight_setRangeAnimationScale(Pointer slf, float[] val, long count);

	void ZkLight_setRangeAnimationFps(Pointer slf, float val);

	void ZkLight_setRangeAnimationSmooth(Pointer slf, boolean val);

	void ZkLight_setColorAnimationFps(Pointer slf, float val);

	void ZkLight_setColorAnimationSmooth(Pointer slf, boolean val);

	void ZkLight_setCanMove(Pointer slf, boolean val);

	Pointer ZkAnimate_load(Pointer buf, GameVersion version);

	Pointer ZkAnimate_loadPath(String path, GameVersion version);

	void ZkAnimate_del(Pointer slf);

	boolean ZkAnimate_getStartOn(Pointer slf);

	boolean ZkAnimate_getIsRunning(Pointer slf);

	void ZkAnimate_setStartOn(Pointer slf, boolean val);

	void ZkAnimate_setIsRunning(Pointer slf, boolean val);

	Pointer ZkItem_load(Pointer buf, GameVersion version);

	Pointer ZkItem_loadPath(String path, GameVersion version);

	void ZkItem_del(Pointer slf);

	String ZkItem_getInstance(Pointer slf);

	int ZkItem_getAmount(Pointer slf);

	int ZkItem_getFlags(Pointer slf);

	void ZkItem_setInstance(Pointer slf, String val);

	void ZkItem_setAmount(Pointer slf, int val);

	void ZkItem_setFlags(Pointer slf, int val);

	Pointer ZkLensFlare_load(Pointer buf, GameVersion version);

	Pointer ZkLensFlare_loadPath(String path, GameVersion version);

	void ZkLensFlare_del(Pointer slf);

	String ZkLensFlare_getEffect(Pointer slf);

	void ZkLensFlare_setEffect(Pointer slf, String val);

	Pointer ZkParticleEffectController_load(Pointer buf, GameVersion version);

	Pointer ZkParticleEffectController_loadPath(String path, GameVersion version);

	void ZkParticleEffectController_del(Pointer slf);

	String ZkParticleEffectController_getEffectName(Pointer slf);

	boolean ZkParticleEffectController_getKillWhenDone(Pointer slf);

	boolean ZkParticleEffectController_getInitiallyRunning(Pointer slf);

	void ZkParticleEffectController_setEffectName(Pointer slf, String val);

	void ZkParticleEffectController_setKillWhenDone(Pointer slf, boolean val);

	void ZkParticleEffectController_setInitiallyRunning(Pointer slf, boolean val);

	Pointer ZkMessageFilter_load(Pointer buf, GameVersion version);

	Pointer ZkMessageFilter_loadPath(String path, GameVersion version);

	void ZkMessageFilter_del(Pointer slf);

	String ZkMessageFilter_getTarget(Pointer slf);

	MessageFilterAction ZkMessageFilter_getOnTrigger(Pointer slf);

	MessageFilterAction ZkMessageFilter_getOnUntrigger(Pointer slf);

	void ZkMessageFilter_setTarget(Pointer slf, String val);

	void ZkMessageFilter_setOnTrigger(Pointer slf, MessageFilterAction val);

	void ZkMessageFilter_setOnUntrigger(Pointer slf, MessageFilterAction val);

	Pointer ZkCodeMaster_load(Pointer buf, GameVersion version);

	Pointer ZkCodeMaster_loadPath(String path, GameVersion version);

	void ZkCodeMaster_del(Pointer slf);

	String ZkCodeMaster_getTarget(Pointer slf);

	boolean ZkCodeMaster_getOrdered(Pointer slf);

	boolean ZkCodeMaster_getFirstFalseIsFailure(Pointer slf);

	String ZkCodeMaster_getFailureTarget(Pointer slf);

	boolean ZkCodeMaster_getUntriggeredCancels(Pointer slf);

	void ZkCodeMaster_setTarget(Pointer slf, String val);

	void ZkCodeMaster_setOrdered(Pointer slf, boolean val);

	void ZkCodeMaster_setFirstFalseIsFailure(Pointer slf, boolean val);

	void ZkCodeMaster_setFailureTarget(Pointer slf, String val);

	void ZkCodeMaster_setUntriggeredCancels(Pointer slf, boolean val);

	long ZkCodeMaster_getSlaveCount(Pointer slf);

	String ZkCodeMaster_getSlave(Pointer slf, long i);

	void ZkCodeMaster_enumerateSlaves(Pointer slf, ZkStringEnumerator cb, Pointer ctx);

	void ZkCodeMaster_addSlave(Pointer slf, String val);

	void ZkCodeMaster_removeSlave(Pointer slf, long i);

	Pointer ZkMoverController_load(Pointer buf, GameVersion version);

	Pointer ZkMoverController_loadPath(String path, GameVersion version);

	void ZkMoverController_del(Pointer slf);

	String ZkMoverController_getTarget(Pointer slf);

	MoverMessageType ZkMoverController_getMessage(Pointer slf);

	int ZkMoverController_getKey(Pointer slf);

	void ZkMoverController_setTarget(Pointer slf, String val);

	void ZkMoverController_setMessage(Pointer slf, MoverMessageType val);

	void ZkMoverController_setKey(Pointer slf, int val);

	Pointer ZkTouchDamage_load(Pointer buf, GameVersion version);

	Pointer ZkTouchDamage_loadPath(String path, GameVersion version);

	void ZkTouchDamage_del(Pointer slf);

	float ZkTouchDamage_getDamage(Pointer slf);

	boolean ZkTouchDamage_getIsBarrier(Pointer slf);

	boolean ZkTouchDamage_getIsBlunt(Pointer slf);

	boolean ZkTouchDamage_getIsEdge(Pointer slf);

	boolean ZkTouchDamage_getIsFire(Pointer slf);

	boolean ZkTouchDamage_getIsFly(Pointer slf);

	boolean ZkTouchDamage_getIsMagic(Pointer slf);

	boolean ZkTouchDamage_getIsPoint(Pointer slf);

	boolean ZkTouchDamage_getIsFall(Pointer slf);

	float ZkTouchDamage_getRepeatDelaySeconds(Pointer slf);

	float ZkTouchDamage_getVolumeScale(Pointer slf);

	TouchCollisionType ZkTouchDamage_getCollisionType(Pointer slf);

	void ZkTouchDamage_setDamage(Pointer slf, float val);

	void ZkTouchDamage_setIsBarrier(Pointer slf, boolean val);

	void ZkTouchDamage_setIsBlunt(Pointer slf, boolean val);

	void ZkTouchDamage_setIsEdge(Pointer slf, boolean val);

	void ZkTouchDamage_setIsFire(Pointer slf, boolean val);

	void ZkTouchDamage_setIsFly(Pointer slf, boolean val);

	void ZkTouchDamage_setIsMagic(Pointer slf, boolean val);

	void ZkTouchDamage_setIsPoint(Pointer slf, boolean val);

	void ZkTouchDamage_setIsFall(Pointer slf, boolean val);

	void ZkTouchDamage_setRepeatDelaySeconds(Pointer slf, float val);

	void ZkTouchDamage_setVolumeScale(Pointer slf, float val);

	void ZkTouchDamage_setCollisionType(Pointer slf, TouchCollisionType val);

	Pointer ZkEarthquake_load(Pointer buf, GameVersion version);

	Pointer ZkEarthquake_loadPath(String path, GameVersion version);

	void ZkEarthquake_del(Pointer slf);

	float ZkEarthquake_getRadius(Pointer slf);

	float ZkEarthquake_getDuration(Pointer slf);

	Vec3f ZkEarthquake_getAmplitude(Pointer slf);

	void ZkEarthquake_setRadius(Pointer slf, float val);

	void ZkEarthquake_setDuration(Pointer slf, float val);

	void ZkEarthquake_setAmplitude(Pointer slf, Vec3f val);

	Pointer ZkMovableObject_load(Pointer buf, GameVersion version);

	Pointer ZkMovableObject_loadPath(String path, GameVersion version);

	void ZkMovableObject_del(Pointer slf);

	String ZkMovableObject_getName(Pointer slf);

	int ZkMovableObject_getHp(Pointer slf);

	int ZkMovableObject_getDamage(Pointer slf);

	boolean ZkMovableObject_getMovable(Pointer slf);

	boolean ZkMovableObject_getTakable(Pointer slf);

	boolean ZkMovableObject_getFocusOverride(Pointer slf);

	SoundMaterialType ZkMovableObject_getMaterial(Pointer slf);

	String ZkMovableObject_getVisualDestroyed(Pointer slf);

	String ZkMovableObject_getOwner(Pointer slf);

	String ZkMovableObject_getOwnerGuild(Pointer slf);

	boolean ZkMovableObject_getDestroyed(Pointer slf);

	void ZkMovableObject_setName(Pointer slf, String val);

	void ZkMovableObject_setHp(Pointer slf, int val);

	void ZkMovableObject_setDamage(Pointer slf, int val);

	void ZkMovableObject_setMovable(Pointer slf, boolean val);

	void ZkMovableObject_setTakable(Pointer slf, boolean val);

	void ZkMovableObject_setFocusOverride(Pointer slf, boolean val);

	void ZkMovableObject_setMaterial(Pointer slf, SoundMaterialType val);

	void ZkMovableObject_setVisualDestroyed(Pointer slf, String val);

	void ZkMovableObject_setOwner(Pointer slf, String val);

	void ZkMovableObject_setOwnerGuild(Pointer slf, String val);

	void ZkMovableObject_setDestroyed(Pointer slf, boolean val);

	Pointer ZkInteractiveObject_load(Pointer buf, GameVersion version);

	Pointer ZkInteractiveObject_loadPath(String path, GameVersion version);

	void ZkInteractiveObject_del(Pointer slf);

	int ZkInteractiveObject_getState(Pointer slf);

	String ZkInteractiveObject_getTarget(Pointer slf);

	String ZkInteractiveObject_getItem(Pointer slf);

	String ZkInteractiveObject_getConditionFunction(Pointer slf);

	String ZkInteractiveObject_getOnStateChangeFunction(Pointer slf);

	boolean ZkInteractiveObject_getRewind(Pointer slf);

	void ZkInteractiveObject_setState(Pointer slf, int val);

	void ZkInteractiveObject_setTarget(Pointer slf, String val);

	void ZkInteractiveObject_setItem(Pointer slf, String val);

	void ZkInteractiveObject_setConditionFunction(Pointer slf, String val);

	void ZkInteractiveObject_setOnStateChangeFunction(Pointer slf, String val);

	void ZkInteractiveObject_setRewind(Pointer slf, boolean val);

	Pointer ZkFire_load(Pointer buf, GameVersion version);

	Pointer ZkFire_loadPath(String path, GameVersion version);

	void ZkFire_del(Pointer slf);

	String ZkFire_getSlot(Pointer slf);

	String ZkFire_getVobTree(Pointer slf);

	void ZkFire_setSlot(Pointer slf, String val);

	void ZkFire_setVobTree(Pointer slf, String val);

	Pointer ZkContainer_load(Pointer buf, GameVersion version);

	Pointer ZkContainer_loadPath(String path, GameVersion version);

	void ZkContainer_del(Pointer slf);

	boolean ZkContainer_getIsLocked(Pointer slf);

	String ZkContainer_getKey(Pointer slf);

	String ZkContainer_getPickString(Pointer slf);

	String ZkContainer_getContents(Pointer slf);

	void ZkContainer_setIsLocked(Pointer slf, boolean val);

	void ZkContainer_setKey(Pointer slf, String val);

	void ZkContainer_setPickString(Pointer slf, String val);

	void ZkContainer_setContents(Pointer slf, String val);

	long ZkContainer_getItemCount(Pointer slf);

	Pointer ZkContainer_getItem(Pointer slf, long i);

	void ZkContainer_addItem(Pointer slf, Pointer item);

	void ZkContainer_removeItem(Pointer slf, long i);

	Pointer ZkDoor_load(Pointer buf, GameVersion version);

	Pointer ZkDoor_loadPath(String path, GameVersion version);

	void ZkDoor_del(Pointer slf);

	boolean ZkDoor_getIsLocked(Pointer slf);

	String ZkDoor_getKey(Pointer slf);

	String ZkDoor_getPickString(Pointer slf);

	void ZkDoor_setIsLocked(Pointer slf, boolean val);

	void ZkDoor_setKey(Pointer slf, String val);

	void ZkDoor_setPickString(Pointer slf, String val);

	Pointer ZkSound_load(Pointer buf, GameVersion version);

	Pointer ZkSound_loadPath(String path, GameVersion version);

	void ZkSound_del(Pointer slf);

	float ZkSound_getVolume(Pointer slf);

	SoundMode ZkSound_getMode(Pointer slf);

	float ZkSound_getRandomDelay(Pointer slf);

	float ZkSound_getRandomDelayVar(Pointer slf);

	boolean ZkSound_getInitiallyPlaying(Pointer slf);

	boolean ZkSound_getAmbient3d(Pointer slf);

	boolean ZkSound_getObstruction(Pointer slf);

	float ZkSound_getConeAngle(Pointer slf);

	SoundTriggerVolumeType ZkSound_getVolumeType(Pointer slf);

	float ZkSound_getRadius(Pointer slf);

	String ZkSound_getSoundName(Pointer slf);

	boolean ZkSound_getIsRunning(Pointer slf);

	boolean ZkSound_getIsAllowedToRun(Pointer slf);

	void ZkSound_setVolume(Pointer slf, float val);

	void ZkSound_setMode(Pointer slf, SoundMode val);

	void ZkSound_setRandomDelay(Pointer slf, float val);

	void ZkSound_setRandomDelayVar(Pointer slf, float val);

	void ZkSound_setInitiallyPlaying(Pointer slf, boolean val);

	void ZkSound_setAmbient3d(Pointer slf, boolean val);

	void ZkSound_setObstruction(Pointer slf, boolean val);

	void ZkSound_setConeAngle(Pointer slf, float val);

	void ZkSound_setVolumeType(Pointer slf, SoundTriggerVolumeType val);

	void ZkSound_setRadius(Pointer slf, float val);

	void ZkSound_setSoundName(Pointer slf, String val);

	void ZkSound_setIsRunning(Pointer slf, boolean val);

	void ZkSound_setIsAllowedToRun(Pointer slf, boolean val);

	Pointer ZkSoundDaytime_load(Pointer buf, GameVersion version);

	Pointer ZkSoundDaytime_loadPath(String path, GameVersion version);

	void ZkSoundDaytime_del(Pointer slf);

	float ZkSoundDaytime_getStartTime(Pointer slf);

	float ZkSoundDaytime_getEndTime(Pointer slf);

	String ZkSoundDaytime_getSoundNameDaytime(Pointer slf);

	void ZkSoundDaytime_setStartTime(Pointer slf, float val);

	void ZkSoundDaytime_setEndTime(Pointer slf, float val);

	void ZkSoundDaytime_setSoundNameDaytime(Pointer slf, String val);

	Pointer ZkTrigger_load(Pointer buf, GameVersion version);

	Pointer ZkTrigger_loadPath(String path, GameVersion version);

	void ZkTrigger_del(Pointer slf);

	String ZkTrigger_getTarget(Pointer slf);

	String ZkTrigger_getVobTarget(Pointer slf);

	int ZkTrigger_getMaxActivationCount(Pointer slf);

	float ZkTrigger_getRetriggerDelaySeconds(Pointer slf);

	float ZkTrigger_getDamageThreshold(Pointer slf);

	float ZkTrigger_getFireDelaySeconds(Pointer slf);

	void ZkTrigger_setTarget(Pointer slf, String val);

	boolean ZkTrigger_getStartEnabled(Pointer slf);

	boolean ZkTrigger_getSendUntrigger(Pointer slf);

	boolean ZkTrigger_getReactToOnTrigger(Pointer slf);

	boolean ZkTrigger_getReactToOnTouch(Pointer slf);

	boolean ZkTrigger_getReactToOnDamage(Pointer slf);

	boolean ZkTrigger_getRespondToObject(Pointer slf);

	boolean ZkTrigger_getRespondToPC(Pointer slf);

	boolean ZkTrigger_getRespondToNPC(Pointer slf);

	void ZkTrigger_setStartEnabled(Pointer slf, boolean b);

	void ZkTrigger_setSendUntrigger(Pointer slf, boolean b);

	void ZkTrigger_setReactToOnTrigger(Pointer slf, boolean b);

	void ZkTrigger_setReactToOnTouch(Pointer slf, boolean b);

	void ZkTrigger_setReactToOnDamage(Pointer slf, boolean b);

	void ZkTrigger_setRespondToObject(Pointer slf, boolean b);

	void ZkTrigger_setRespondToPC(Pointer slf, boolean b);

	void ZkTrigger_setRespondToNPC(Pointer slf, boolean b);

	void ZkTrigger_setVobTarget(Pointer slf, String val);

	void ZkTrigger_setMaxActivationCount(Pointer slf, int val);

	void ZkTrigger_setRetriggerDelaySeconds(Pointer slf, float val);

	void ZkTrigger_setDamageThreshold(Pointer slf, float val);

	void ZkTrigger_setFireDelaySeconds(Pointer slf, float val);

	float ZkTrigger_getNextTimeTriggerable(Pointer slf);

	Pointer ZkTrigger_getOtherVob(Pointer slf);

	int ZkTrigger_getCountCanBeActivated(Pointer slf);

	boolean ZkTrigger_getIsEnabled(Pointer slf);

	void ZkTrigger_setNextTimeTriggerable(Pointer slf, float val);

	void ZkTrigger_setOtherVob(Pointer slf, Pointer val);

	void ZkTrigger_setCountCanBeActivated(Pointer slf, int val);

	void ZkTrigger_setIsEnabled(Pointer slf, boolean val);

	Pointer ZkMover_load(Pointer buf, GameVersion version);

	Pointer ZkMover_loadPath(String path, GameVersion version);

	void ZkMover_del(Pointer slf);

	MoverBehavior ZkMover_getBehavior(Pointer slf);

	float ZkMover_getTouchBlockerDamage(Pointer slf);

	float ZkMover_getStayOpenTimeSeconds(Pointer slf);

	boolean ZkMover_getIsLocked(Pointer slf);

	boolean ZkMover_getAutoLink(Pointer slf);

	boolean ZkMover_getAutoRotate(Pointer slf);

	float ZkMover_getSpeed(Pointer slf);

	MoverLerpType ZkMover_getLerpType(Pointer slf);

	MoverSpeedType ZkMover_getSpeedType(Pointer slf);

	long ZkMover_getKeyframeCount(Pointer slf);

	AnimationSample ZkMover_getKeyframe(Pointer slf, long i);

	String ZkMover_getSfxOpenStart(Pointer slf);

	String ZkMover_getSfxOpenEnd(Pointer slf);

	String ZkMover_getSfxTransitioning(Pointer slf);

	String ZkMover_getSfxCloseStart(Pointer slf);

	String ZkMover_getSfxCloseEnd(Pointer slf);

	String ZkMover_getSfxLock(Pointer slf);

	String ZkMover_getSfxUnlock(Pointer slf);

	String ZkMover_getSfxUseLocked(Pointer slf);

	void ZkMover_setBehavior(Pointer slf, MoverBehavior val);

	void ZkMover_setTouchBlockerDamage(Pointer slf, float val);

	void ZkMover_setStayOpenTimeSeconds(Pointer slf, float val);

	void ZkMover_setIsLocked(Pointer slf, boolean val);

	void ZkMover_setAutoLink(Pointer slf, boolean val);

	void ZkMover_setAutoRotate(Pointer slf, boolean val);

	void ZkMover_setSpeed(Pointer slf, float val);

	void ZkMover_setLerpType(Pointer slf, MoverLerpType val);

	void ZkMover_setSpeedType(Pointer slf, MoverSpeedType val);

	void ZkMover_setSfxOpenStart(Pointer slf, String val);

	void ZkMover_setSfxOpenEnd(Pointer slf, String val);

	void ZkMover_setSfxTransitioning(Pointer slf, String val);

	void ZkMover_setSfxCloseStart(Pointer slf, String val);

	void ZkMover_setSfxCloseEnd(Pointer slf, String val);

	void ZkMover_setSfxLock(Pointer slf, String val);

	void ZkMover_setSfxUnlock(Pointer slf, String val);

	void ZkMover_setSfxUseLocked(Pointer slf, String val);

	Vec3f ZkMover_getActKeyPosDelta(Pointer slf);

	float ZkMover_getActKeyframeF(Pointer slf);

	int ZkMover_getActKeyframe(Pointer slf);

	int ZkMover_getNextKeyframe(Pointer slf);

	float ZkMover_getMoveSpeedUnit(Pointer slf);

	float ZkMover_getAdvanceDir(Pointer slf);

	int ZkMover_getMoverState(Pointer slf);

	int ZkMover_getTriggerEventCount(Pointer slf);

	float ZkMover_getStayOpenTimeDest(Pointer slf);

	void ZkMover_setActKeyPosDelta(Pointer slf, Vec3f actKeyPosDelta);

	void ZkMover_setActKeyframeF(Pointer slf, float actKeyframeF);

	void ZkMover_setActKeyframe(Pointer slf, int actKeyframe);

	void ZkMover_setNextKeyframe(Pointer slf, int nextKeyframe);

	void ZkMover_setMoveSpeedUnit(Pointer slf, float moveSpeedUnit);

	void ZkMover_setAdvanceDir(Pointer slf, float advanceDir);

	void ZkMover_setMoverState(Pointer slf, int moverState);

	void ZkMover_setTriggerEventCount(Pointer slf, int triggerEventCount);

	void ZkMover_setStayOpenTimeDest(Pointer slf, float stayOpenTimeDest);

	Pointer ZkTriggerList_load(Pointer buf, GameVersion version);

	Pointer ZkTriggerList_loadPath(String path, GameVersion version);

	void ZkTriggerList_del(Pointer slf);

	TriggerBatchMode ZkTriggerList_getMode(Pointer slf);

	long ZkTriggerList_getTargetCount(Pointer slf);

	Pointer ZkTriggerList_getTarget(Pointer slf, long i);

	void ZkTriggerList_setMode(Pointer slf, TriggerBatchMode val);

	void
	ZkTriggerList_enumerateTargets(Pointer slf, ZkTriggerListTargetEnumerator cb, Pointer ctx);

	Pointer ZkTriggerList_addTarget(Pointer slf);

	void ZkTriggerList_removeTarget(Pointer slf, long i);

	byte ZkTriggerList_getActTarget(Pointer slf);

	boolean ZkTriggerList_getSendOnTrigger(Pointer slf);

	void ZkTriggerList_setActTarget(Pointer slf, byte actTarget);

	void ZkTriggerList_setSendOnTrigger(Pointer slf, boolean sendOnTrigger);

	String ZkTriggerListTarget_getName(Pointer slf);

	float ZkTriggerListTarget_getDelaySeconds(Pointer slf);

	void ZkTriggerListTarget_setName(Pointer slf, String val);

	void ZkTriggerListTarget_setDelaySeconds(Pointer slf, float val);

	Pointer ZkTriggerScript_load(Pointer buf, GameVersion version);

	Pointer ZkTriggerScript_loadPath(String path, GameVersion version);

	void ZkTriggerScript_del(Pointer slf);

	String ZkTriggerScript_getFunction(Pointer slf);

	void ZkTriggerScript_setFunction(Pointer slf, String val);

	Pointer ZkTriggerChangeLevel_load(Pointer buf, GameVersion version);

	Pointer ZkTriggerChangeLevel_loadPath(String path, GameVersion version);

	void ZkTriggerChangeLevel_del(Pointer slf);

	String ZkTriggerChangeLevel_getLevelName(Pointer slf);

	String ZkTriggerChangeLevel_getStartVob(Pointer slf);

	void ZkTriggerChangeLevel_setLevelName(Pointer slf, String val);

	void ZkTriggerChangeLevel_setStartVob(Pointer slf, String val);

	Pointer ZkTriggerWorldStart_load(Pointer buf, GameVersion version);

	Pointer ZkTriggerWorldStart_loadPath(String path, GameVersion version);

	void ZkTriggerWorldStart_del(Pointer slf);

	String ZkTriggerWorldStart_getTarget(Pointer slf);

	boolean ZkTriggerWorldStart_getFireOnce(Pointer slf);

	void ZkTriggerWorldStart_setTarget(Pointer slf, String val);

	void ZkTriggerWorldStart_setFireOnce(Pointer slf, boolean val);

	boolean ZkTriggerWorldStart_getHasFired(Pointer slf);

	void ZkTriggerWorldStart_setHasFired(Pointer slf, boolean val);

	Pointer ZkTriggerUntouch_load(Pointer buf, GameVersion version);

	Pointer ZkTriggerUntouch_loadPath(String path, GameVersion version);

	void ZkTriggerUntouch_del(Pointer slf);

	String ZkTriggerUntouch_getTarget(Pointer slf);

	void ZkTriggerUntouch_setTarget(Pointer slf, String val);

	Pointer ZkZoneMusic_load(Pointer buf, GameVersion version);

	Pointer ZkZoneMusic_loadPath(String path, GameVersion version);

	void ZkZoneMusic_del(Pointer slf);

	boolean ZkZoneMusic_getIsEnabled(Pointer slf);

	int ZkZoneMusic_getPriority(Pointer slf);

	boolean ZkZoneMusic_getIsEllipsoid(Pointer slf);

	float ZkZoneMusic_getReverb(Pointer slf);

	float ZkZoneMusic_getVolume(Pointer slf);

	boolean ZkZoneMusic_getIsLoop(Pointer slf);

	void ZkZoneMusic_setIsEnabled(Pointer slf, boolean val);

	void ZkZoneMusic_setPriority(Pointer slf, int val);

	void ZkZoneMusic_setIsEllipsoid(Pointer slf, boolean val);

	void ZkZoneMusic_setReverb(Pointer slf, float val);

	void ZkZoneMusic_setVolume(Pointer slf, float val);

	void ZkZoneMusic_setIsLoop(Pointer slf, boolean val);

	boolean ZkZoneMusic_getLocalEnabled(Pointer slf);

	boolean ZkZoneMusic_getDayEntranceDone(Pointer slf);

	boolean ZkZoneMusic_getNightEntranceDone(Pointer slf);

	void ZkZoneMusic_setLocalEnabled(Pointer slf, boolean localEnabled);

	void ZkZoneMusic_setDayEntranceDone(Pointer slf, boolean dayEntraceDone);

	void ZkZoneMusic_setNightEntranceDone(Pointer slf, boolean nightEntranceDone);

	Pointer ZkZoneFarPlane_load(Pointer buf, GameVersion version);

	Pointer ZkZoneFarPlane_loadPath(String path, GameVersion version);

	void ZkZoneFarPlane_del(Pointer slf);

	float ZkZoneFarPlane_getVobFarPlaneZ(Pointer slf);

	float ZkZoneFarPlane_getInnerRangePercentage(Pointer slf);

	void ZkZoneFarPlane_setVobFarPlaneZ(Pointer slf, float val);

	void ZkZoneFarPlane_setInnerRangePercentage(Pointer slf, float val);

	Pointer ZkZoneFog_load(Pointer buf, GameVersion version);

	Pointer ZkZoneFog_loadPath(String path, GameVersion version);

	void ZkZoneFog_del(Pointer slf);

	float ZkZoneFog_getRangeCenter(Pointer slf);

	float ZkZoneFog_getInnerRangePercentage(Pointer slf);

	Color.ByValue ZkZoneFog_getColor(Pointer slf);

	boolean ZkZoneFog_getFadeOutSky(Pointer slf);

	boolean ZkZoneFog_getOverrideColor(Pointer slf);

	void ZkZoneFog_setRangeCenter(Pointer slf, float val);

	void ZkZoneFog_setInnerRangePercentage(Pointer slf, float val);

	void ZkZoneFog_setColor(Pointer slf, Color.ByValue val);

	void ZkZoneFog_setFadeOutSky(Pointer slf, boolean val);

	void ZkZoneFog_setOverrideColor(Pointer slf, boolean val);

	Pointer ZkDaedalusScript_load(Pointer buf);

	Pointer ZkDaedalusScript_loadPath(String path);

	Pointer ZkDaedalusScript_loadVfs(Pointer vfs, String name);

	void ZkDaedalusScript_del(Pointer slf);

	int ZkDaedalusScript_getSymbolCount(Pointer slf);

	void ZkDaedalusScript_enumerateSymbols(Pointer slf, ZkDaedalusSymbolEnumerator cb, Pointer ctx);

	void ZkDaedalusScript_enumerateInstanceSymbols(
			Pointer slf,
			String className,
			ZkDaedalusSymbolEnumerator cb,
			Pointer ctx
	);

	DaedalusInstruction ZkDaedalusScript_getInstruction(Pointer slf, long address);

	Pointer ZkDaedalusScript_getSymbolByIndex(Pointer slf, int i);

	Pointer ZkDaedalusScript_getSymbolByAddress(Pointer slf, long i);

	Pointer ZkDaedalusScript_getSymbolByName(Pointer slf, String i);

	String ZkDaedalusSymbol_getString(Pointer slf, short index, Pointer context);

	float ZkDaedalusSymbol_getFloat(Pointer slf, short index, Pointer context);

	int ZkDaedalusSymbol_getInt(Pointer slf, short index, Pointer context);

	void ZkDaedalusSymbol_setString(Pointer slf, String value, short index, Pointer context);

	void ZkDaedalusSymbol_setFloat(Pointer slf, float value, short index, Pointer context);

	void ZkDaedalusSymbol_setInt(Pointer slf, int value, short index, Pointer context);

	boolean ZkDaedalusSymbol_getIsConst(Pointer slf);

	boolean ZkDaedalusSymbol_getIsMember(Pointer slf);

	boolean ZkDaedalusSymbol_getIsExternal(Pointer slf);

	boolean ZkDaedalusSymbol_getIsMerged(Pointer slf);

	boolean ZkDaedalusSymbol_getIsGenerated(Pointer slf);

	boolean ZkDaedalusSymbol_getHasReturn(Pointer slf);

	String ZkDaedalusSymbol_getName(Pointer slf);

	int ZkDaedalusSymbol_getAddress(Pointer slf);

	int ZkDaedalusSymbol_getParent(Pointer slf);

	int ZkDaedalusSymbol_getSize(Pointer slf);

	DaedalusInstanceType ZkDaedalusInstance_getType(Pointer slf);

	int ZkDaedalusInstance_getIndex(Pointer ptr);

	Pointer ZkDaedalusVm_load(Pointer buf);

	Pointer ZkDaedalusVm_loadPath(String path);

	Pointer ZkDaedalusVm_loadVfs(Pointer vfs, String name);

	void ZkDaedalusVm_del(Pointer slf);

	void ZkDaedalusVm_pushInt(Pointer slf, int value);

	void ZkDaedalusVm_pushFloat(Pointer slf, float value);

	void ZkDaedalusVm_pushString(Pointer slf, String value);

	void ZkDaedalusVm_pushInstance(Pointer slf, Pointer value);

	int ZkDaedalusVm_popInt(Pointer slf);

	float ZkDaedalusVm_popFloat(Pointer slf);

	String ZkDaedalusVm_popString(Pointer slf);

	Pointer ZkDaedalusVm_popInstance(Pointer slf);

	Pointer ZkDaedalusVm_getGlobalSelf(Pointer slf);

	Pointer ZkDaedalusVm_getGlobalOther(Pointer slf);

	Pointer ZkDaedalusVm_getGlobalVictim(Pointer slf);

	Pointer ZkDaedalusVm_getGlobalHero(Pointer slf);

	Pointer ZkDaedalusVm_getGlobalItem(Pointer slf);

	void ZkDaedalusVm_setGlobalSelf(Pointer slf, Pointer value);

	void ZkDaedalusVm_setGlobalOther(Pointer slf, Pointer value);

	void ZkDaedalusVm_setGlobalVictim(Pointer slf, Pointer value);

	void ZkDaedalusVm_setGlobalHero(Pointer slf, Pointer value);

	void ZkDaedalusVm_setGlobalItem(Pointer slf, Pointer value);

	void ZkDaedalusVm_callFunction(Pointer slf, Pointer sym);

	Pointer ZkDaedalusVm_allocInstance(Pointer slf, Pointer sym, DaedalusInstanceType type);

	Pointer ZkDaedalusVm_initInstance(Pointer slf, Pointer sym, DaedalusInstanceType type);

	void ZkDaedalusVm_initInstanceDirect(Pointer slf, Pointer instance);

	void ZkDaedalusVm_registerExternal(Pointer slf, Pointer sym, ZkDaedalusVmExternalCallback cb, Pointer ctx);

	void ZkDaedalusVm_registerExternalDefault(Pointer slf, ZkDaedalusVmExternalDefaultCallback cb, Pointer ctx);

	void ZkDaedalusVm_printStackTrace(Pointer slf);

	int ZkGuildValuesInstance_getWaterDepthKnee(Pointer slf, long i);

	int ZkGuildValuesInstance_getWaterDepthChest(Pointer slf, long i);

	int ZkGuildValuesInstance_getJumpUpHeight(Pointer slf, long i);

	int ZkGuildValuesInstance_getSwimTime(Pointer slf, long i);

	int ZkGuildValuesInstance_getDiveTime(Pointer slf, long i);

	int ZkGuildValuesInstance_getStepHeight(Pointer slf, long i);

	int ZkGuildValuesInstance_getJumpLowHeight(Pointer slf, long i);

	int ZkGuildValuesInstance_getJumpMidHeight(Pointer slf, long i);

	int ZkGuildValuesInstance_getSlideAngle(Pointer slf, long i);

	int ZkGuildValuesInstance_getSlideAngle2(Pointer slf, long i);

	int ZkGuildValuesInstance_getDisableAutoRoll(Pointer slf, long i);

	int ZkGuildValuesInstance_getSurfaceAlign(Pointer slf, long i);

	int ZkGuildValuesInstance_getClimbHeadingAngle(Pointer slf, long i);

	int ZkGuildValuesInstance_getClimbHorizAngle(Pointer slf, long i);

	int ZkGuildValuesInstance_getClimbGroundAngle(Pointer slf, long i);

	int ZkGuildValuesInstance_getFightRangeBase(Pointer slf, long i);

	int ZkGuildValuesInstance_getFightRangeFist(Pointer slf, long i);

	int ZkGuildValuesInstance_getFightRangeG(Pointer slf, long i);

	int ZkGuildValuesInstance_getFightRange1Hs(Pointer slf, long i);

	int ZkGuildValuesInstance_getFightRange1Ha(Pointer slf, long i);

	int ZkGuildValuesInstance_getFightRange2Hs(Pointer slf, long i);

	int ZkGuildValuesInstance_getFightRange2Ha(Pointer slf, long i);

	int ZkGuildValuesInstance_getFallDownHeight(Pointer slf, long i);

	int ZkGuildValuesInstance_getFallDownDamage(Pointer slf, long i);

	int ZkGuildValuesInstance_getBloodDisabled(Pointer slf, long i);

	int ZkGuildValuesInstance_getBloodMaxDistance(Pointer slf, long i);

	int ZkGuildValuesInstance_getBloodAmount(Pointer slf, long i);

	int ZkGuildValuesInstance_getBloodFlow(Pointer slf, long i);

	int ZkGuildValuesInstance_getTurnSpeed(Pointer slf, long i);

	String ZkGuildValuesInstance_getBloodEmitter(Pointer slf, long i);

	String ZkGuildValuesInstance_getBloodTexture(Pointer slf, long i);

	int ZkNpcInstance_getId(Pointer slf);

	String ZkNpcInstance_getSlot(Pointer slf);

	String ZkNpcInstance_getEffect(Pointer slf);

	NpcInstanceType ZkNpcInstance_getType(Pointer slf);

	int ZkNpcInstance_getFlags(Pointer slf);

	int ZkNpcInstance_getDamageType(Pointer slf);

	int ZkNpcInstance_getGuild(Pointer slf);

	int ZkNpcInstance_getLevel(Pointer slf);

	int ZkNpcInstance_getFightTactic(Pointer slf);

	int ZkNpcInstance_getWeapon(Pointer slf);

	int ZkNpcInstance_getVoice(Pointer slf);

	int ZkNpcInstance_getVoicePitch(Pointer slf);

	int ZkNpcInstance_getBodyMass(Pointer slf);

	int ZkNpcInstance_getDailyRoutine(Pointer slf);

	int ZkNpcInstance_getStartAiState(Pointer slf);

	String ZkNpcInstance_getSpawnPoint(Pointer slf);

	int ZkNpcInstance_getSpawnDelay(Pointer slf);

	int ZkNpcInstance_getSenses(Pointer slf);

	int ZkNpcInstance_getSensesRange(Pointer slf);

	String ZkNpcInstance_getWp(Pointer slf);

	int ZkNpcInstance_getExp(Pointer slf);

	int ZkNpcInstance_getExpNext(Pointer slf);

	int ZkNpcInstance_getLp(Pointer slf);

	int ZkNpcInstance_getBodyStateInterruptableOverride(Pointer slf);

	int ZkNpcInstance_getNoFocus(Pointer slf);

	String ZkNpcInstance_getName(Pointer slf, NpcInstanceNameSlot slot);

	int ZkNpcInstance_getMission(Pointer slf, NpcInstanceMissionSlot slot);

	int ZkNpcInstance_getAttribute(Pointer slf, NpcInstanceAttribute attribute);

	int ZkNpcInstance_getHitChance(Pointer slf, NpcInstanceTalent talent);

	int ZkNpcInstance_getProtection(Pointer slf, DamageType type);

	int ZkNpcInstance_getDamage(Pointer slf, DamageType type);

	int ZkNpcInstance_getAiVar(Pointer slf, long i);

	String ZkMissionInstance_getName(Pointer slf);

	String ZkMissionInstance_getDescription(Pointer slf);

	int ZkMissionInstance_getDuration(Pointer slf);

	int ZkMissionInstance_getImportant(Pointer slf);

	int ZkMissionInstance_getOfferConditions(Pointer slf);

	int ZkMissionInstance_getOffer(Pointer slf);

	int ZkMissionInstance_getSuccessConditions(Pointer slf);

	int ZkMissionInstance_getSuccess(Pointer slf);

	int ZkMissionInstance_getFailureConditions(Pointer slf);

	int ZkMissionInstance_getFailure(Pointer slf);

	int ZkMissionInstance_getObsoleteConditions(Pointer slf);

	int ZkMissionInstance_getObsolete(Pointer slf);

	int ZkMissionInstance_getRunning(Pointer slf);

	int ZkItemInstance_getId(Pointer slf);

	String ZkItemInstance_getName(Pointer slf);

	String ZkItemInstance_getNameId(Pointer slf);

	int ZkItemInstance_getHp(Pointer slf);

	int ZkItemInstance_getHpMax(Pointer slf);

	int ZkItemInstance_getMainFlag(Pointer slf);

	int ZkItemInstance_getFlags(Pointer slf);

	int ZkItemInstance_getWeight(Pointer slf);

	int ZkItemInstance_getValue(Pointer slf);

	int ZkItemInstance_getDamageType(Pointer slf);

	int ZkItemInstance_getDamageTotal(Pointer slf);

	int ZkItemInstance_getWear(Pointer slf);

	int ZkItemInstance_getNutrition(Pointer slf);

	int ZkItemInstance_getMagic(Pointer slf);

	int ZkItemInstance_getOnEquip(Pointer slf);

	int ZkItemInstance_getOnUnequip(Pointer slf);

	int ZkItemInstance_getOwner(Pointer slf);

	int ZkItemInstance_getOwnerGuild(Pointer slf);

	int ZkItemInstance_getDisguiseGuild(Pointer slf);

	String ZkItemInstance_getVisual(Pointer slf);

	String ZkItemInstance_getVisualChange(Pointer slf);

	String ZkItemInstance_getEffect(Pointer slf);

	int ZkItemInstance_getVisualSkin(Pointer slf);

	String ZkItemInstance_getSchemeName(Pointer slf);

	int ZkItemInstance_getMaterial(Pointer slf);

	int ZkItemInstance_getMunition(Pointer slf);

	int ZkItemInstance_getSpell(Pointer slf);

	int ZkItemInstance_getRange(Pointer slf);

	int ZkItemInstance_getMagCircle(Pointer slf);

	String ZkItemInstance_getDescription(Pointer slf);

	int ZkItemInstance_getInvZBias(Pointer slf);

	int ZkItemInstance_getInvRotX(Pointer slf);

	int ZkItemInstance_getInvRotY(Pointer slf);

	int ZkItemInstance_getInvRotZ(Pointer slf);

	int ZkItemInstance_getInvAnimate(Pointer slf);

	int ZkItemInstance_getDamage(Pointer slf, DamageType type);

	int ZkItemInstance_getProtection(Pointer slf, DamageType type);

	int ZkItemInstance_getCondAtr(Pointer slf, ItemInstanceConditionSlot slot);

	int ZkItemInstance_getCondValue(Pointer slf, ItemInstanceConditionSlot slot);

	int ZkItemInstance_getChangeAtr(Pointer slf, ItemInstanceConditionSlot slot);

	int ZkItemInstance_getChangeValue(Pointer slf, ItemInstanceConditionSlot slot);

	int ZkItemInstance_getOnState(Pointer slf, ItemInstanceStateSlot slot);

	String ZkItemInstance_getText(Pointer slf, ItemInstanceTextSlot slot);

	int ZkItemInstance_getCount(Pointer slf, ItemInstanceTextSlot slot);

	float ZkFocusInstance_getNpcLongrange(Pointer slf);

	float ZkFocusInstance_getNpcRange1(Pointer slf);

	float ZkFocusInstance_getNpcRange2(Pointer slf);

	float ZkFocusInstance_getNpcAzi(Pointer slf);

	float ZkFocusInstance_getNpcElevdo(Pointer slf);

	float ZkFocusInstance_getNpcElevup(Pointer slf);

	int ZkFocusInstance_getNpcPrio(Pointer slf);

	float ZkFocusInstance_getItemRange1(Pointer slf);

	float ZkFocusInstance_getItemRange2(Pointer slf);

	float ZkFocusInstance_getItemAzi(Pointer slf);

	float ZkFocusInstance_getItemElevdo(Pointer slf);

	float ZkFocusInstance_getItemElevup(Pointer slf);

	int ZkFocusInstance_getItemPrio(Pointer slf);

	float ZkFocusInstance_getMobRange1(Pointer slf);

	float ZkFocusInstance_getMobRange2(Pointer slf);

	float ZkFocusInstance_getMobAzi(Pointer slf);

	float ZkFocusInstance_getMobElevdo(Pointer slf);

	float ZkFocusInstance_getMobElevup(Pointer slf);

	int ZkFocusInstance_getMobPrio(Pointer slf);

	int ZkInfoInstance_getNpc(Pointer slf);

	int ZkInfoInstance_getNr(Pointer slf);

	int ZkInfoInstance_getImportant(Pointer slf);

	int ZkInfoInstance_getCondition(Pointer slf);

	int ZkInfoInstance_getInformation(Pointer slf);

	String ZkInfoInstance_getDescription(Pointer slf);

	int ZkInfoInstance_getTrade(Pointer slf);

	int ZkInfoInstance_getPermanent(Pointer slf);

	int ZkItemReactInstance_getNpc(Pointer slf);

	int ZkItemReactInstance_getTradeItem(Pointer slf);

	int ZkItemReactInstance_getTradeAmount(Pointer slf);

	int ZkItemReactInstance_getRequestedCategory(Pointer slf);

	int ZkItemReactInstance_getRequestedItem(Pointer slf);

	int ZkItemReactInstance_getRequestedAmount(Pointer slf);

	int ZkItemReactInstance_getReaction(Pointer slf);

	float ZkSpellInstance_getTimePerMana(Pointer slf);

	int ZkSpellInstance_getDamagePerLevel(Pointer slf);

	int ZkSpellInstance_getDamageType(Pointer slf);

	int ZkSpellInstance_getSpellType(Pointer slf);

	int ZkSpellInstance_getCanTurnDuringInvest(Pointer slf);

	int ZkSpellInstance_getCanChangeTargetDuringInvest(Pointer slf);

	int ZkSpellInstance_getIsMultiEffect(Pointer slf);

	int ZkSpellInstance_getTargetCollectAlgo(Pointer slf);

	int ZkSpellInstance_getTargetCollectType(Pointer slf);

	int ZkSpellInstance_getTargetCollectRange(Pointer slf);

	int ZkSpellInstance_getTargetCollectAzi(Pointer slf);

	int ZkSpellInstance_getTargetCollectElevation(Pointer slf);

	String ZkMenuInstance_getBackPic(Pointer slf);

	String ZkMenuInstance_getBackWorld(Pointer slf);

	int ZkMenuInstance_getPosX(Pointer slf);

	int ZkMenuInstance_getPosY(Pointer slf);

	int ZkMenuInstance_getDimX(Pointer slf);

	int ZkMenuInstance_getDimY(Pointer slf);

	int ZkMenuInstance_getAlpha(Pointer slf);

	String ZkMenuInstance_getMusicTheme(Pointer slf);

	int ZkMenuInstance_getEventTimerMsec(Pointer slf);

	int ZkMenuInstance_getFlags(Pointer slf);

	int ZkMenuInstance_getDefaultOutgame(Pointer slf);

	int ZkMenuInstance_getDefaultIngame(Pointer slf);

	String ZkMenuInstance_getItem(Pointer slf, long i);

	String ZkMenuItemInstance_getFontName(Pointer slf);

	String ZkMenuItemInstance_getBackpic(Pointer slf);

	String ZkMenuItemInstance_getAlphaMode(Pointer slf);

	int ZkMenuItemInstance_getAlpha(Pointer slf);

	MenuItemType ZkMenuItemInstance_getType(Pointer slf);

	String ZkMenuItemInstance_getOnChgSetOption(Pointer slf);

	String ZkMenuItemInstance_getOnChgSetOptionSection(Pointer slf);

	int ZkMenuItemInstance_getPosX(Pointer slf);

	int ZkMenuItemInstance_getPosY(Pointer slf);

	int ZkMenuItemInstance_getDimX(Pointer slf);

	int ZkMenuItemInstance_getDimY(Pointer slf);

	float ZkMenuItemInstance_getSizeStartScale(Pointer slf);

	int ZkMenuItemInstance_getFlags(Pointer slf);

	float ZkMenuItemInstance_getOpenDelayTime(Pointer slf);

	float ZkMenuItemInstance_getOpenDuration(Pointer slf);

	int ZkMenuItemInstance_getFramePosX(Pointer slf);

	int ZkMenuItemInstance_getFramePosY(Pointer slf);

	int ZkMenuItemInstance_getFrameSizeX(Pointer slf);

	int ZkMenuItemInstance_getFrameSizeY(Pointer slf);

	String ZkMenuItemInstance_getHideIfOptionSectionSet(Pointer slf);

	String ZkMenuItemInstance_getHideIfOptionSet(Pointer slf);

	int ZkMenuItemInstance_getHideOnValue(Pointer slf);

	String ZkMenuItemInstance_getText(Pointer slf, long i);

	int ZkMenuItemInstance_getOnSelAction(Pointer slf, long i);

	String ZkMenuItemInstance_getOnSelActionS(Pointer slf, long i);

	int ZkMenuItemInstance_getOnEventAction(Pointer slf, long i);

	float ZkMenuItemInstance_getUserFloat(Pointer slf, long i);

	String ZkMenuItemInstance_getUserString(Pointer slf, long i);

	float ZkCameraInstance_getBestRange(Pointer slf);

	float ZkCameraInstance_getMinRange(Pointer slf);

	float ZkCameraInstance_getMaxRange(Pointer slf);

	float ZkCameraInstance_getBestElevation(Pointer slf);

	float ZkCameraInstance_getMinElevation(Pointer slf);

	float ZkCameraInstance_getMaxElevation(Pointer slf);

	float ZkCameraInstance_getBestAzimuth(Pointer slf);

	float ZkCameraInstance_getMinAzimuth(Pointer slf);

	float ZkCameraInstance_getMaxAzimuth(Pointer slf);

	float ZkCameraInstance_getBestRotZ(Pointer slf);

	float ZkCameraInstance_getMinRotZ(Pointer slf);

	float ZkCameraInstance_getMaxRotZ(Pointer slf);

	float ZkCameraInstance_getRotOffsetX(Pointer slf);

	float ZkCameraInstance_getRotOffsetY(Pointer slf);

	float ZkCameraInstance_getRotOffsetZ(Pointer slf);

	float ZkCameraInstance_getTargetOffsetX(Pointer slf);

	float ZkCameraInstance_getTargetOffsetY(Pointer slf);

	float ZkCameraInstance_getTargetOffsetZ(Pointer slf);

	float ZkCameraInstance_getVeloTrans(Pointer slf);

	float ZkCameraInstance_getVeloRot(Pointer slf);

	int ZkCameraInstance_getTranslate(Pointer slf);

	int ZkCameraInstance_getRotate(Pointer slf);

	int ZkCameraInstance_getCollision(Pointer slf);

	float ZkMusicSystemInstance_getVolume(Pointer slf);

	int ZkMusicSystemInstance_getBitResolution(Pointer slf);

	int ZkMusicSystemInstance_getGlobalReverbEnabled(Pointer slf);

	int ZkMusicSystemInstance_getSampleRate(Pointer slf);

	int ZkMusicSystemInstance_getNumChannels(Pointer slf);

	int ZkMusicSystemInstance_getReverbBufferSize(Pointer slf);

	String ZkMusicThemeInstance_getFile(Pointer slf);

	float ZkMusicThemeInstance_getVol(Pointer slf);

	int ZkMusicThemeInstance_getLoop(Pointer slf);

	float ZkMusicThemeInstance_getReverbmix(Pointer slf);

	float ZkMusicThemeInstance_getReverbtime(Pointer slf);

	MusicTransitionEffect ZkMusicThemeInstance_getTranstype(Pointer slf);

	MusicTransitionType ZkMusicThemeInstance_getTranssubtype(Pointer slf);

	String ZkMusicJingleInstance_getName(Pointer slf);

	int ZkMusicJingleInstance_getLoop(Pointer slf);

	float ZkMusicJingleInstance_getVol(Pointer slf);

	int ZkMusicJingleInstance_getTranssubtype(Pointer slf);

	float ZkParticleEffectInstance_getPpsValue(Pointer slf);

	String ZkParticleEffectInstance_getPpsScaleKeysS(Pointer slf);

	int ZkParticleEffectInstance_getPpsIsLooping(Pointer slf);

	int ZkParticleEffectInstance_getPpsIsSmooth(Pointer slf);

	float ZkParticleEffectInstance_getPpsFps(Pointer slf);

	String ZkParticleEffectInstance_getPpsCreateEmS(Pointer slf);

	float ZkParticleEffectInstance_getPpsCreateEmDelay(Pointer slf);

	String ZkParticleEffectInstance_getShpTypeS(Pointer slf);

	String ZkParticleEffectInstance_getShpForS(Pointer slf);

	String ZkParticleEffectInstance_getShpOffsetVecS(Pointer slf);

	String ZkParticleEffectInstance_getShpDistribTypeS(Pointer slf);

	float ZkParticleEffectInstance_getShpDistribWalkSpeed(Pointer slf);

	int ZkParticleEffectInstance_getShpIsVolume(Pointer slf);

	String ZkParticleEffectInstance_getShpDimS(Pointer slf);

	String ZkParticleEffectInstance_getShpMeshS(Pointer slf);

	int ZkParticleEffectInstance_getShpMeshRenderB(Pointer slf);

	String ZkParticleEffectInstance_getShpScaleKeysS(Pointer slf);

	int ZkParticleEffectInstance_getShpScaleIsLooping(Pointer slf);

	int ZkParticleEffectInstance_getShpScaleIsSmooth(Pointer slf);

	float ZkParticleEffectInstance_getShpScaleFps(Pointer slf);

	String ZkParticleEffectInstance_getDirModeS(Pointer slf);

	String ZkParticleEffectInstance_getDirForS(Pointer slf);

	String ZkParticleEffectInstance_getDirModeTargetForS(Pointer slf);

	String ZkParticleEffectInstance_getDirModeTargetPosS(Pointer slf);

	float ZkParticleEffectInstance_getDirAngleHead(Pointer slf);

	float ZkParticleEffectInstance_getDirAngleHeadVar(Pointer slf);

	float ZkParticleEffectInstance_getDirAngleElev(Pointer slf);

	float ZkParticleEffectInstance_getDirAngleElevVar(Pointer slf);

	float ZkParticleEffectInstance_getVelAvg(Pointer slf);

	float ZkParticleEffectInstance_getVelVar(Pointer slf);

	float ZkParticleEffectInstance_getLspPartAvg(Pointer slf);

	float ZkParticleEffectInstance_getLspPartVar(Pointer slf);

	String ZkParticleEffectInstance_getFlyGravityS(Pointer slf);

	int ZkParticleEffectInstance_getFlyColldetB(Pointer slf);

	String ZkParticleEffectInstance_getVisNameS(Pointer slf);

	String ZkParticleEffectInstance_getVisOrientationS(Pointer slf);

	int ZkParticleEffectInstance_getVisTexIsQuadpoly(Pointer slf);

	float ZkParticleEffectInstance_getVisTexAniFps(Pointer slf);

	int ZkParticleEffectInstance_getVisTexAniIsLooping(Pointer slf);

	String ZkParticleEffectInstance_getVisTexColorStartS(Pointer slf);

	String ZkParticleEffectInstance_getVisTexColorEndS(Pointer slf);

	String ZkParticleEffectInstance_getVisSizeStartS(Pointer slf);

	float ZkParticleEffectInstance_getVisSizeEndScale(Pointer slf);

	String ZkParticleEffectInstance_getVisAlphaFuncS(Pointer slf);

	float ZkParticleEffectInstance_getVisAlphaStart(Pointer slf);

	float ZkParticleEffectInstance_getVisAlphaEnd(Pointer slf);

	float ZkParticleEffectInstance_getTrlFadeSpeed(Pointer slf);

	String ZkParticleEffectInstance_getTrlTextureS(Pointer slf);

	float ZkParticleEffectInstance_getTrlWidth(Pointer slf);

	float ZkParticleEffectInstance_getMrkFadesPeed(Pointer slf);

	String ZkParticleEffectInstance_getMrktExtureS(Pointer slf);

	float ZkParticleEffectInstance_getMrkSize(Pointer slf);

	String ZkParticleEffectInstance_getFlockMode(Pointer slf);

	float ZkParticleEffectInstance_getFlockStrength(Pointer slf);

	int ZkParticleEffectInstance_getUseEmittersFor(Pointer slf);

	String ZkParticleEffectInstance_getTimeStartEndS(Pointer slf);

	int ZkParticleEffectInstance_getMBiasAmbientPfx(Pointer slf);

	String ZkEffectBaseInstance_getVisNameS(Pointer slf);

	String ZkEffectBaseInstance_getVisSizeS(Pointer slf);

	float ZkEffectBaseInstance_getVisAlpha(Pointer slf);

	String ZkEffectBaseInstance_getVisAlphaBlendFuncS(Pointer slf);

	float ZkEffectBaseInstance_getVisTexAniFps(Pointer slf);

	int ZkEffectBaseInstance_getVisTexAniIsLooping(Pointer slf);

	String ZkEffectBaseInstance_getEmTrjModeS(Pointer slf);

	String ZkEffectBaseInstance_getEmTrjOriginNode(Pointer slf);

	String ZkEffectBaseInstance_getEmTrjTargetNode(Pointer slf);

	float ZkEffectBaseInstance_getEmTrjTargetRange(Pointer slf);

	float ZkEffectBaseInstance_getEmTrjTargetAzi(Pointer slf);

	float ZkEffectBaseInstance_getEmTrjTargetElev(Pointer slf);

	int ZkEffectBaseInstance_getEmTrjNumKeys(Pointer slf);

	int ZkEffectBaseInstance_getEmTrjNumKeysVar(Pointer slf);

	float ZkEffectBaseInstance_getEmTrjAngleElevVar(Pointer slf);

	float ZkEffectBaseInstance_getEmTrjAngleHeadVar(Pointer slf);

	float ZkEffectBaseInstance_getEmTrjKeyDistVar(Pointer slf);

	String ZkEffectBaseInstance_getEmTrjLoopModeS(Pointer slf);

	String ZkEffectBaseInstance_getEmTrjEaseFuncS(Pointer slf);

	float ZkEffectBaseInstance_getEmTrjEaseVel(Pointer slf);

	float ZkEffectBaseInstance_getEmTrjDynUpdateDelay(Pointer slf);

	int ZkEffectBaseInstance_getEmTrjDynUpdateTargetOnly(Pointer slf);

	String ZkEffectBaseInstance_getEmFxCreateS(Pointer slf);

	String ZkEffectBaseInstance_getEmFxInvestOriginS(Pointer slf);

	String ZkEffectBaseInstance_getEmFxInvestTargetS(Pointer slf);

	float ZkEffectBaseInstance_getEmFxTriggerDelay(Pointer slf);

	int ZkEffectBaseInstance_getEmFxCreateDownTrj(Pointer slf);

	String ZkEffectBaseInstance_getEmActionCollDynS(Pointer slf);

	String ZkEffectBaseInstance_getEmActionCollStatS(Pointer slf);

	String ZkEffectBaseInstance_getEmFxCollStatS(Pointer slf);

	String ZkEffectBaseInstance_getEmFxCollDynS(Pointer slf);

	String ZkEffectBaseInstance_getEmFxCollStatAlignS(Pointer slf);

	String ZkEffectBaseInstance_getEmFxCollDynAlignS(Pointer slf);

	float ZkEffectBaseInstance_getEmFxLifespan(Pointer slf);

	int ZkEffectBaseInstance_getEmCheckCollision(Pointer slf);

	int ZkEffectBaseInstance_getEmAdjustShpToOrigin(Pointer slf);

	float ZkEffectBaseInstance_getEmInvestNextKeyDuration(Pointer slf);

	float ZkEffectBaseInstance_getEmFlyGravity(Pointer slf);

	String ZkEffectBaseInstance_getEmSelfRotVelS(Pointer slf);

	String ZkEffectBaseInstance_getLightPresetName(Pointer slf);

	String ZkEffectBaseInstance_getSfxId(Pointer slf);

	int ZkEffectBaseInstance_getSfxIsAmbient(Pointer slf);

	int ZkEffectBaseInstance_getSendAssessMagic(Pointer slf);

	float ZkEffectBaseInstance_getSecsPerDamage(Pointer slf);

	String ZkEffectBaseInstance_getEmFxCollDynPercS(Pointer slf);

	String ZkEffectBaseInstance_getUserString(Pointer slf, long i);

	String ZkParticleEffectEmitKeyInstance_getVisNameS(Pointer slf);

	float ZkParticleEffectEmitKeyInstance_getVisSizeScale(Pointer slf);

	float ZkParticleEffectEmitKeyInstance_getScaleDuration(Pointer slf);

	float ZkParticleEffectEmitKeyInstance_getPfxPpsValue(Pointer slf);

	int ZkParticleEffectEmitKeyInstance_getPfxPpsIsSmoothChg(Pointer slf);

	int ZkParticleEffectEmitKeyInstance_getPfxPpsIsLoopingChg(Pointer slf);

	float ZkParticleEffectEmitKeyInstance_getPfxScTime(Pointer slf);

	String ZkParticleEffectEmitKeyInstance_getPfxFlyGravityS(Pointer slf);

	String ZkParticleEffectEmitKeyInstance_getPfxShpDimS(Pointer slf);

	int ZkParticleEffectEmitKeyInstance_getPfxShpIsVolumeChg(Pointer slf);

	float ZkParticleEffectEmitKeyInstance_getPfxShpScaleFps(Pointer slf);

	float ZkParticleEffectEmitKeyInstance_getPfxShpDistribWalksPeed(Pointer slf);

	String ZkParticleEffectEmitKeyInstance_getPfxShpOffsetVecS(Pointer slf);

	String ZkParticleEffectEmitKeyInstance_getPfxShpDistribTypeS(Pointer slf);

	String ZkParticleEffectEmitKeyInstance_getPfxDirModeS(Pointer slf);

	String ZkParticleEffectEmitKeyInstance_getPfxDirForS(Pointer slf);

	String ZkParticleEffectEmitKeyInstance_getPfxDirModeTargetForS(Pointer slf);

	String ZkParticleEffectEmitKeyInstance_getPfxDirModeTargetPosS(Pointer slf);

	float ZkParticleEffectEmitKeyInstance_getPfxVelAvg(Pointer slf);

	float ZkParticleEffectEmitKeyInstance_getPfxLspPartAvg(Pointer slf);

	float ZkParticleEffectEmitKeyInstance_getPfxVisAlphaStart(Pointer slf);

	String ZkParticleEffectEmitKeyInstance_getLightPresetName(Pointer slf);

	float ZkParticleEffectEmitKeyInstance_getLightRange(Pointer slf);

	String ZkParticleEffectEmitKeyInstance_getSfxId(Pointer slf);

	int ZkParticleEffectEmitKeyInstance_getSfxIsAmbient(Pointer slf);

	String ZkParticleEffectEmitKeyInstance_getEmCreateFxId(Pointer slf);

	float ZkParticleEffectEmitKeyInstance_getEmFlyGravity(Pointer slf);

	String ZkParticleEffectEmitKeyInstance_getEmSelfRotVelS(Pointer slf);

	String ZkParticleEffectEmitKeyInstance_getEmTrjModeS(Pointer slf);

	float ZkParticleEffectEmitKeyInstance_getEmTrjEaseVel(Pointer slf);

	int ZkParticleEffectEmitKeyInstance_getEmCheckCollision(Pointer slf);

	float ZkParticleEffectEmitKeyInstance_getEmFxLifespan(Pointer slf);

	FightAiMove ZkFightAiInstance_getMove(Pointer slf, long i);

	String ZkSoundEffectInstance_getFile(Pointer slf);

	int ZkSoundEffectInstance_getPitchOff(Pointer slf);

	int ZkSoundEffectInstance_getPitchVar(Pointer slf);

	int ZkSoundEffectInstance_getVolume(Pointer slf);

	int ZkSoundEffectInstance_getLoop(Pointer slf);

	int ZkSoundEffectInstance_getLoopStartOffset(Pointer slf);

	int ZkSoundEffectInstance_getLoopEndOffset(Pointer slf);

	float ZkSoundEffectInstance_getReverbLevel(Pointer slf);

	String ZkSoundEffectInstance_getPfxName(Pointer slf);

	float ZkSoundSystemInstance_getVolume(Pointer slf);

	int ZkSoundSystemInstance_getBitResolution(Pointer slf);

	int ZkSoundSystemInstance_getSampleRate(Pointer slf);

	int ZkSoundSystemInstance_getUseStereo(Pointer slf);

	int ZkSoundSystemInstance_getNumSfxChannels(Pointer slf);

	String ZkSoundSystemInstance_getUsed3DProviderName(Pointer slf);


	DaedalusDataType ZkDaedalusSymbol_getType(Pointer slf);

	int ZkDaedalusSymbol_getIndex(Pointer slf);

	DaedalusDataType ZkDaedalusSymbol_getReturnType(Pointer slf);

	int ZkDaedalusSymbol_getFileIndex(Pointer slf);
	int ZkDaedalusSymbol_getOffsetAsMember(Pointer slf);
	int ZkDaedalusSymbol_getLineStart(Pointer slf);
	int ZkDaedalusSymbol_getLineCount(Pointer slf);
	int ZkDaedalusSymbol_getCharStart(Pointer slf);
	int ZkDaedalusSymbol_getCharCount(Pointer slf);
	int ZkDaedalusSymbol_getClassSize(Pointer slf);

	String ZkNpc_getNpcInstance(Pointer slf);

	Vec3f ZkNpc_getModelScale(Pointer slf);

	float ZkNpc_getModelFatness(Pointer slf);

	int ZkNpc_getFlags(Pointer slf);

	int ZkNpc_getGuild(Pointer slf);

	int ZkNpc_getGuildTrue(Pointer slf);

	int ZkNpc_getLevel(Pointer slf);

	int ZkNpc_getXp(Pointer slf);

	int ZkNpc_getXpNextLevel(Pointer slf);

	int ZkNpc_getLp(Pointer slf);

	int ZkNpc_getFightTactic(Pointer slf);

	int ZkNpc_getFightMode(Pointer slf);

	boolean ZkNpc_getWounded(Pointer slf);

	boolean ZkNpc_getMad(Pointer slf);

	int ZkNpc_getMadTime(Pointer slf);

	boolean ZkNpc_getPlayer(Pointer slf);

	String ZkNpc_getStartAiState(Pointer slf);

	String ZkNpc_getScriptWaypoint(Pointer slf);

	int ZkNpc_getAttitude(Pointer slf);

	int ZkNpc_getAttitudeTemp(Pointer slf);

	int ZkNpc_getNameNr(Pointer slf);

	boolean ZkNpc_getMoveLock(Pointer slf);

	boolean ZkNpc_getCurrentStateValid(Pointer slf);

	String ZkNpc_getCurrentStateName(Pointer slf);

	int ZkNpc_getCurrentStateIndex(Pointer slf);

	boolean ZkNpc_getCurrentStateIsRoutine(Pointer slf);

	boolean ZkNpc_getNextStateValid(Pointer slf);

	String ZkNpc_getNextStateName(Pointer slf);

	int ZkNpc_getNextStateIndex(Pointer slf);

	boolean ZkNpc_getNextStateIsRoutine(Pointer slf);

	int ZkNpc_getLastAiState(Pointer slf);

	boolean ZkNpc_getHasRoutine(Pointer slf);

	boolean ZkNpc_getRoutineChanged(Pointer slf);

	boolean ZkNpc_getRoutineOverlay(Pointer slf);

	int ZkNpc_getRoutineOverlayCount(Pointer slf);

	int ZkNpc_getWalkmodeRoutine(Pointer slf);

	boolean ZkNpc_getWeaponmodeRoutine(Pointer slf);

	boolean ZkNpc_getStartNewRoutine(Pointer slf);

	int ZkNpc_getAiStateDriven(Pointer slf);

	Vec3f ZkNpc_getAiStatePos(Pointer slf);

	String ZkNpc_getCurrentRoutine(Pointer slf);

	boolean ZkNpc_getRespawn(Pointer slf);

	int ZkNpc_getRespawnTime(Pointer slf);

	int ZkNpc_getBsInterruptableOverride(Pointer slf);

	int ZkNpc_getNpcType(Pointer slf);

	int ZkNpc_getSpellMana(Pointer slf);

	Pointer ZkNpc_getCarryVob(Pointer slf);

	Pointer ZkNpc_getEnemy(Pointer slf);

	void ZkNpc_setNpcInstance(Pointer slf, String npcInstance);

	void ZkNpc_setModelScale(Pointer slf, Vec3f modelScale);

	void ZkNpc_setModelFatness(Pointer slf, float modelFatness);

	void ZkNpc_setFlags(Pointer slf, int flags);

	void ZkNpc_setGuild(Pointer slf, int guild);

	void ZkNpc_setGuildTrue(Pointer slf, int guildTrue);

	void ZkNpc_setLevel(Pointer slf, int level);

	void ZkNpc_setXp(Pointer slf, int xp);

	void ZkNpc_setXpNextLevel(Pointer slf, int xpNextLevel);

	void ZkNpc_setLp(Pointer slf, int lp);

	void ZkNpc_setFightTactic(Pointer slf, int fightTactic);

	void ZkNpc_setFightMode(Pointer slf, int fightMode);

	void ZkNpc_setWounded(Pointer slf, boolean wounded);

	void ZkNpc_setMad(Pointer slf, boolean mad);

	void ZkNpc_setMadTime(Pointer slf, int madTime);

	void ZkNpc_setPlayer(Pointer slf, boolean player);

	void ZkNpc_setStartAiState(Pointer slf, String startAiState);

	void ZkNpc_setScriptWaypoint(Pointer slf, String scriptWaypoint);

	void ZkNpc_setAttitude(Pointer slf, int attitude);

	void ZkNpc_setAttitudeTemp(Pointer slf, int attitudeTemp);

	void ZkNpc_setNameNr(Pointer slf, int nameNr);

	void ZkNpc_setMoveLock(Pointer slf, boolean moveLock);

	void ZkNpc_setCurrentStateValid(Pointer slf, boolean currentStateValid);

	void ZkNpc_setCurrentStateName(Pointer slf, String currentStateName);

	void ZkNpc_setCurrentStateIndex(Pointer slf, int currentStateIndex);

	void ZkNpc_setCurrentStateIsRoutine(Pointer slf, boolean currentStateIsRoutine);

	void ZkNpc_setNextStateValid(Pointer slf, boolean nextStateValid);

	void ZkNpc_setNextStateName(Pointer slf, String nextStateName);

	void ZkNpc_setNextStateIndex(Pointer slf, int nextStateIndex);

	void ZkNpc_setNextStateIsRoutine(Pointer slf, boolean nextStateIsRoutine);

	void ZkNpc_setLastAiState(Pointer slf, int lastAiState);

	void ZkNpc_setHasRoutine(Pointer slf, boolean hasRoutine);

	void ZkNpc_setRoutineChanged(Pointer slf, boolean routineChanged);

	void ZkNpc_setRoutineOverlay(Pointer slf, boolean routineOverlay);

	void ZkNpc_setRoutineOverlayCount(Pointer slf, int routineOverlayCount);

	void ZkNpc_setWalkmodeRoutine(Pointer slf, int walkmodeRoutine);

	void ZkNpc_setWeaponmodeRoutine(Pointer slf, boolean weaponmodeRoutine);

	void ZkNpc_setStartNewRoutine(Pointer slf, boolean startNewRoutine);

	void ZkNpc_setAiStateDriven(Pointer slf, int aiStateDriven);

	void ZkNpc_setAiStatePos(Pointer slf, Vec3f aiStatePos);

	void ZkNpc_setCurrentRoutine(Pointer slf, String currentRoutine);

	void ZkNpc_setRespawn(Pointer slf, boolean respawn);

	void ZkNpc_setRespawnTime(Pointer slf, int respawnTime);

	void ZkNpc_setBsInterruptableOverride(Pointer slf, int bsInterruptableOverride);

	void ZkNpc_setNpcType(Pointer slf, int npcType);

	void ZkNpc_setSpellMana(Pointer slf, int spellMana);

	void ZkNpc_setCarryVob(Pointer slf, Pointer carryVob);

	void ZkNpc_setEnemy(Pointer slf, Pointer enemy);

	long ZkNpc_getOverlayCount(Pointer slf);

	String ZkNpc_getOverlay(Pointer slf, long i);

	void ZkNpc_clearOverlays(Pointer slf);

	void ZkNpc_removeOverlay(Pointer slf, long i);

	void ZkNpc_setOverlay(Pointer slf, long i, String overlay);

	void ZkNpc_addOverlay(Pointer slf, String overlay);

	long ZkNpc_getTalentCount(Pointer slf);

	Pointer ZkNpc_getTalent(Pointer slf, long i);

	void ZkNpc_clearTalents(Pointer slf);

	void ZkNpc_removeTalent(Pointer slf, long i);

	void ZkNpc_setTalent(Pointer slf, long i, Pointer talent);

	void ZkNpc_addTalent(Pointer slf, Pointer talent);

	long ZkNpc_getItemCount(Pointer slf);

	Pointer ZkNpc_getItem(Pointer slf, long i);

	void ZkNpc_clearItems(Pointer slf);

	void ZkNpc_removeItem(Pointer slf, long i);

	void ZkNpc_setItem(Pointer slf, long i, Pointer item);

	void ZkNpc_addItem(Pointer slf, Pointer item);

	long ZkNpc_getSlotCount(Pointer slf);

	Pointer ZkNpc_getSlot(Pointer slf, long i);

	void ZkNpc_clearSlots(Pointer slf);

	void ZkNpc_removeSlot(Pointer slf, long i);

	Pointer ZkNpc_addSlot(Pointer slf);

	int ZkNpc_getProtection(Pointer slf, long i);

	void ZkNpc_setProtection(Pointer slf, long i, int v);

	int ZkNpc_getAttribute(Pointer slf, long i);

	void ZkNpc_setAttribute(Pointer slf, long i, int v);

	int ZkNpc_getHitChance(Pointer slf, long i);

	void ZkNpc_setHitChance(Pointer slf, long i, int v);

	int ZkNpc_getMission(Pointer slf, long i);

	void ZkNpc_setMission(Pointer slf, long i, int v);

	Pointer ZkNpc_getAiVars(Pointer slf, LongByReference len);

	void ZkNpc_setAiVars(Pointer slf, int[] vars, long len);

	String ZkNpc_getPacked(Pointer slf, long i);

	void ZkNpc_setPacked(Pointer slf, long i, String v);

	Pointer ZkNpcTalent_new();

	void ZkNpcTalent_del(Pointer slf);

	int ZkNpcTalent_getTalent(Pointer slf);

	int ZkNpcTalent_getValue(Pointer slf);

	int ZkNpcTalent_getSkill(Pointer slf);

	void ZkNpcTalent_setTalent(Pointer slf, int v);

	void ZkNpcTalent_setValue(Pointer slf, int v);

	void ZkNpcTalent_setSkill(Pointer slf, int v);

	boolean ZkNpcSlot_getUsed(Pointer slf);

	String ZkNpcSlot_getName(Pointer slf);

	Pointer ZkNpcSlot_getItem(Pointer slf);

	boolean ZkNpcSlot_getInInventory(Pointer slf);

	void ZkNpcSlot_setUsed(Pointer slf, boolean used);

	void ZkNpcSlot_setName(Pointer slf, String name);

	void ZkNpcSlot_setItem(Pointer slf, Pointer item);

	void ZkNpcSlot_setInInventory(Pointer slf, boolean inInventory);

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
		boolean invoke(Pointer ctx, Pointer glyph);
	}

	interface ZkAnimationSampleEnumerator extends Callback {
		boolean invoke(Pointer ctx, AnimationSample sample);
	}

	interface ZkModelHierarchyNodeEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer node);
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

	interface ZkAnimationCombineEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer evt);
	}

	interface ZkStringEnumerator extends Callback {
		boolean invoke(Pointer ctx, String evt);
	}

	interface ZkAnimationBlendEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer evt);
	}

	interface ZkAnimationAliasEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer evt);
	}

	interface ZkAnimationEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer evt);
	}

	interface ZkEventTagEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer evt);
	}

	interface ZkEventParticleEffectEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer evt);
	}

	interface ZkEventParticleEffectStopEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer evt);
	}

	interface ZkEventSoundEffectEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer evt);
	}

	interface ZkEventSoundEffectGroundEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer evt);
	}

	interface ZkEventMorphAnimationEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer evt);
	}

	interface ZkEventCameraTremorEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer evt);
	}

	interface ZkBspSectorEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer sector);
	}

	interface ZkVirtualObjectEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer vob);
	}

	interface ZkWayPointEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer point);
	}

	interface ZkCameraTrajectoryFrameEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer frame);
	}

	interface ZkTriggerListTargetEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer target);
	}

	interface ZkDaedalusSymbolEnumerator extends Callback {
		boolean invoke(Pointer ctx, Pointer symbol);
	}

	interface ZkDaedalusVmExternalDefaultCallback extends Callback {
		void invoke(Pointer ctx, Pointer vm, Pointer sym);
	}

	interface ZkDaedalusVmExternalCallback extends Callback {
		void invoke(Pointer ctx, Pointer vm);
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
