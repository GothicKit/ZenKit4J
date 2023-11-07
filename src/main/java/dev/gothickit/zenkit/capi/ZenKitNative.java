package dev.gothickit.zenkit.capi;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;
import dev.gothickit.zenkit.*;
import dev.gothickit.zenkit.ani.AnimationSample;
import dev.gothickit.zenkit.bsp.BspNode;
import dev.gothickit.zenkit.bsp.BspTreeType;
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

	Pointer ZkEventTag_getFrames(Pointer slf, IntByReference count);

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

	BspTreeType ZkBspTree_getType(Pointer slf);

	Pointer ZkBspTree_getPolygonIndices(Pointer slf, IntByReference count);

	Pointer ZkBspTree_getLeafPolygonIndices(Pointer slf, IntByReference count);

	Pointer ZkBspTree_getPortalPolygonIndices(Pointer slf, IntByReference count);

	Vec3f ZkBspTree_getLightPoints(Pointer slf, IntByReference count);

	Pointer ZkBspTree_getLeafNodeIndices(Pointer slf, IntByReference count);

	BspNode ZkBspTree_getNodes(Pointer slf, IntByReference count);

	long ZkBspTree_getSectorCount(Pointer slf);

	Pointer ZkBspTree_getSector(Pointer slf, long i);

	void ZkBspTree_enumerateSectors(Pointer slf, ZkBspSectorEnumerator cb, Pointer ctx);

	String ZkBspSector_getName(Pointer slf);

	Pointer ZkBspSector_getNodeIndices(Pointer slf, IntByReference count);

	Pointer ZkBspSector_getPortalPolygonIndices(Pointer slf, IntByReference count);

	WayEdge ZkWayNet_getEdges(Pointer slf, IntByReference count);

	long ZkWayNet_getPointCount(Pointer slf);

	Pointer ZkWayNet_getPoint(Pointer slf, long i);

	void ZkWayNet_enumeratePoints(Pointer slf, ZkWayPointEnumerator cb, Pointer ctx);

	String ZkWayPoint_getName(Pointer slf);

	int ZkWayPoint_getWaterDepth(Pointer slf);

	boolean ZkWayPoint_getUnderWater(Pointer slf);

	Vec3f.ByValue ZkWayPoint_getPosition(Pointer slf);

	Vec3f.ByValue ZkWayPoint_getDirection(Pointer slf);

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

	Pointer ZkVirtualObject_load(Pointer buf, GameVersion version);

	Pointer ZkVirtualObject_loadPath(String path, GameVersion version);

	void ZkVirtualObject_del(Pointer slf);

	VirtualObjectType ZkVirtualObject_getType(Pointer slf);

	int ZkVirtualObject_getId(Pointer slf);

	AxisAlignedBoundingBox.ByValue ZkVirtualObject_getBbox(Pointer slf);

	Vec3f.ByValue ZkVirtualObject_getPosition(Pointer slf);

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

	String ZkVirtualObject_getVisualName(Pointer slf);

	VisualType ZkVirtualObject_getVisualType(Pointer slf);

	Pointer ZkVirtualObject_getVisualDecal(Pointer slf);

	long ZkVirtualObject_getChildCount(Pointer slf);

	Pointer ZkVirtualObject_getChild(Pointer slf, long i);

	void ZkVirtualObject_enumerateChildren(Pointer slf, ZkVirtualObjectEnumerator cb, Pointer ctx);

	String ZkDecal_getName(Pointer slf);

	Vec2f ZkDecal_getDimension(Pointer slf);

	Vec2f ZkDecal_getOffset(Pointer slf);

	boolean ZkDecal_getTwoSided(Pointer slf);

	AlphaFunction ZkDecal_getAlphaFunc(Pointer slf);

	float ZkDecal_getTextureAnimFps(Pointer slf);

	byte ZkDecal_getAlphaWeight(Pointer slf);

	boolean ZkDecal_getIgnoreDaylight(Pointer slf);

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

	Pointer ZkCutsceneCamera_getFrame(Pointer slf, long i);

	void ZkCutsceneCamera_enumerateFrames(Pointer slf, ZkCameraTrajectoryFrameEnumerator cb, Pointer ctx);

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

	Color ZkLightPreset_getColorAnimationList(Pointer slf, IntByReference count);

	float ZkLightPreset_getColorAnimationFps(Pointer slf);

	boolean ZkLightPreset_getColorAnimationSmooth(Pointer slf);

	boolean ZkLightPreset_getCanMove(Pointer slf);

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

	Color ZkLight_getColorAnimationList(Pointer slf, IntByReference count);

	float ZkLight_getColorAnimationFps(Pointer slf);

	boolean ZkLight_getColorAnimationSmooth(Pointer slf);

	boolean ZkLight_getCanMove(Pointer slf);

	Pointer ZkAnimate_load(Pointer buf, GameVersion version);

	Pointer ZkAnimate_loadPath(String path, GameVersion version);

	void ZkAnimate_del(Pointer slf);

	boolean ZkAnimate_getStartOn(Pointer slf);

	Pointer ZkItem_load(Pointer buf, GameVersion version);

	Pointer ZkItem_loadPath(String path, GameVersion version);

	void ZkItem_del(Pointer slf);

	String ZkItem_getInstance(Pointer slf);

	Pointer ZkLensFlare_load(Pointer buf, GameVersion version);

	Pointer ZkLensFlare_loadPath(String path, GameVersion version);

	void ZkLensFlare_del(Pointer slf);

	String ZkLensFlare_getEffect(Pointer slf);

	Pointer ZkParticleEffectController_load(Pointer buf, GameVersion version);

	Pointer ZkParticleEffectController_loadPath(String path, GameVersion version);

	void ZkParticleEffectController_del(Pointer slf);

	String ZkParticleEffectController_getEffectName(Pointer slf);

	boolean ZkParticleEffectController_getKillWhenDone(Pointer slf);

	boolean ZkParticleEffectController_getInitiallyRunning(Pointer slf);

	Pointer ZkMessageFilter_load(Pointer buf, GameVersion version);

	Pointer ZkMessageFilter_loadPath(String path, GameVersion version);

	void ZkMessageFilter_del(Pointer slf);

	String ZkMessageFilter_getTarget(Pointer slf);

	MessageFilterAction ZkMessageFilter_getOnTrigger(Pointer slf);

	MessageFilterAction ZkMessageFilter_getOnUntrigger(Pointer slf);

	Pointer ZkCodeMaster_load(Pointer buf, GameVersion version);

	Pointer ZkCodeMaster_loadPath(String path, GameVersion version);

	void ZkCodeMaster_del(Pointer slf);

	String ZkCodeMaster_getTarget(Pointer slf);

	boolean ZkCodeMaster_getOrdered(Pointer slf);

	boolean ZkCodeMaster_getFirstFalseIsFailure(Pointer slf);

	String ZkCodeMaster_getFailureTarget(Pointer slf);

	boolean ZkCodeMaster_getUntriggeredCancels(Pointer slf);

	long ZkCodeMaster_getSlaveCount(Pointer slf);

	String ZkCodeMaster_getSlave(Pointer slf, long i);

	void ZkCodeMaster_enumerateSlaves(Pointer slf, ZkStringEnumerator cb, Pointer ctx);

	Pointer ZkMoverController_load(Pointer buf, GameVersion version);

	Pointer ZkMoverController_loadPath(String path, GameVersion version);

	void ZkMoverController_del(Pointer slf);

	String ZkMoverController_getTarget(Pointer slf);

	MoverMessageType ZkMoverController_getMessage(Pointer slf);

	int ZkMoverController_getKey(Pointer slf);

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

	Pointer ZkEarthquake_load(Pointer buf, GameVersion version);

	Pointer ZkEarthquake_loadPath(String path, GameVersion version);

	void ZkEarthquake_del(Pointer slf);

	float ZkEarthquake_getRadius(Pointer slf);

	float ZkEarthquake_getDuration(Pointer slf);

	Vec3f.ByValue ZkEarthquake_getAmplitude(Pointer slf);

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

	Pointer ZkInteractiveObject_load(Pointer buf, GameVersion version);

	Pointer ZkInteractiveObject_loadPath(String path, GameVersion version);

	void ZkInteractiveObject_del(Pointer slf);

	int ZkInteractiveObject_getState(Pointer slf);

	String ZkInteractiveObject_getTarget(Pointer slf);

	String ZkInteractiveObject_getItem(Pointer slf);

	String ZkInteractiveObject_getConditionFunction(Pointer slf);

	String ZkInteractiveObject_getOnStateChangeFunction(Pointer slf);

	boolean ZkInteractiveObject_getRewind(Pointer slf);

	Pointer ZkFire_load(Pointer buf, GameVersion version);

	Pointer ZkFire_loadPath(String path, GameVersion version);

	void ZkFire_del(Pointer slf);

	String ZkFire_getSlot(Pointer slf);

	String ZkFire_getVobTree(Pointer slf);

	Pointer ZkContainer_load(Pointer buf, GameVersion version);

	Pointer ZkContainer_loadPath(String path, GameVersion version);

	void ZkContainer_del(Pointer slf);

	boolean ZkContainer_getIsLocked(Pointer slf);

	String ZkContainer_getKey(Pointer slf);

	String ZkContainer_getPickString(Pointer slf);

	String ZkContainer_getContents(Pointer slf);

	Pointer ZkDoor_load(Pointer buf, GameVersion version);

	Pointer ZkDoor_loadPath(String path, GameVersion version);

	void ZkDoor_del(Pointer slf);

	boolean ZkDoor_getIsLocked(Pointer slf);

	String ZkDoor_getKey(Pointer slf);

	String ZkDoor_getPickString(Pointer slf);

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

	Pointer ZkSoundDaytime_load(Pointer buf, GameVersion version);

	Pointer ZkSoundDaytime_loadPath(String path, GameVersion version);

	void ZkSoundDaytime_del(Pointer slf);

	float ZkSoundDaytime_getStartTime(Pointer slf);

	float ZkSoundDaytime_getEndTime(Pointer slf);

	String ZkSoundDaytime_getSoundNameDaytime(Pointer slf);

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
