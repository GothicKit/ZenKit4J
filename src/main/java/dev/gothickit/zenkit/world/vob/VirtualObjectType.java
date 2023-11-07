package dev.gothickit.zenkit.world.vob;

import dev.gothickit.zenkit.utils.EnumNative;

public enum VirtualObjectType implements EnumNative<VirtualObjectType> {
	zCVob(0),
	zCVobLevelCompo(1),
	oCItem(2),
	oCNpc(3),
	zCMoverController(4),
	zCVobScreenFX(5),
	zCVobStair(6),
	zCPFXController(7),
	zCVobAnimate(8),
	zCVobLensFlare(9),
	zCVobLight(10),
	zCVobSpot(11),
	zCVobStartpoint(12),
	zCMessageFilter(13),
	zCCodeMaster(14),
	zCTriggerWorldStart(15),
	zCCSCamera(16),
	zCCamTrj_KeyFrame(17),
	oCTouchDamage(18),
	zCTriggerUntouch(19),
	zCEarthquake(20),
	oCMOB(21),
	oCMobInter(22),
	oCMobBed(23),
	oCMobFire(24),
	oCMobLadder(25),
	oCMobSwitch(26),
	oCMobWheel(27),
	oCMobContainer(28),
	oCMobDoor(29),
	zCTrigger(30),
	zCTriggerList(31),
	oCTriggerScript(32),
	oCTriggerChangeLevel(33),
	oCCSTrigger(34),
	zCMover(35),
	zCVobSound(36),
	zCVobSoundDaytime(37),
	oCZoneMusic(38),
	oCZoneMusicDefault(39),
	zCZoneZFog(40),
	zCZoneZFogDefault(41),
	zCZoneVobFarPlane(42),
	zCZoneVobFarPlaneDefault(43),
	IGNORED(44),
	UNKNOWN(45),
	;

	public final int value;

	VirtualObjectType(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	@Override
	public VirtualObjectType getForValue(int i) {
		return switch (i) {
			case 0 -> zCVob;
			case 1 -> zCVobLevelCompo;
			case 2 -> oCItem;
			case 3 -> oCNpc;
			case 4 -> zCMoverController;
			case 5 -> zCVobScreenFX;
			case 6 -> zCVobStair;
			case 7 -> zCPFXController;
			case 8 -> zCVobAnimate;
			case 9 -> zCVobLensFlare;
			case 10 -> zCVobLight;
			case 11 -> zCVobSpot;
			case 12 -> zCVobStartpoint;
			case 13 -> zCMessageFilter;
			case 14 -> zCCodeMaster;
			case 15 -> zCTriggerWorldStart;
			case 16 -> zCCSCamera;
			case 17 -> zCCamTrj_KeyFrame;
			case 18 -> oCTouchDamage;
			case 19 -> zCTriggerUntouch;
			case 20 -> zCEarthquake;
			case 21 -> oCMOB;
			case 22 -> oCMobInter;
			case 23 -> oCMobBed;
			case 24 -> oCMobFire;
			case 25 -> oCMobLadder;
			case 26 -> oCMobSwitch;
			case 27 -> oCMobWheel;
			case 28 -> oCMobContainer;
			case 29 -> oCMobDoor;
			case 30 -> zCTrigger;
			case 31 -> zCTriggerList;
			case 32 -> oCTriggerScript;
			case 33 -> oCTriggerChangeLevel;
			case 34 -> oCCSTrigger;
			case 35 -> zCMover;
			case 36 -> zCVobSound;
			case 37 -> zCVobSoundDaytime;
			case 38 -> oCZoneMusic;
			case 39 -> oCZoneMusicDefault;
			case 40 -> zCZoneZFog;
			case 41 -> zCZoneZFogDefault;
			case 42 -> zCZoneVobFarPlane;
			case 43 -> zCZoneVobFarPlaneDefault;
			case 44 -> IGNORED;
			case 45 -> UNKNOWN;
			default -> null;
		};
	}
}
