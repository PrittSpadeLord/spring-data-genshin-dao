package io.github.prittspadelord.model;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class Character {

    public enum Rarity {
        four, five
    }

    public enum Element {
        anemo, geo, electro, dendro, hydro, pyro, cryo
    }

    public enum WeaponType {
        sword, polearm, bow, claymore, catalyst;
    }

    public enum ModelType {
        tall_male, tall_female, medium_male, medium_female, short_female
    }

    public enum Nation {
        mondstadt, liyue, inazuma, sumeru, fontaine, natlan, snezhnaya;
    }

    public enum AscensionStat {
        hf,
        af,
        df,
        hp,
        ap,
        dp,
        er,
        em,
        cr,
        cd,
        hb,
        fdmg,
        admg,
        gdmg,
        edmg,
        ddmg,
        hdmg,
        pdmg,
        cdmg,
        fres,
        ares,
        gres,
        dres,
        hres,
        pres,
        cres;
    }

    private int id;
    @NonNull private String name;
    @NonNull private Rarity rarity;
    @NonNull private String releaseVersion;
    @NonNull private Element element;
    @NonNull private WeaponType weaponType;
    @NonNull private ModelType modelType;
    @Nullable private Nation nation;
    private int localSpecialityId;
    @NonNull private String bossDrop;
    @NonNull private String commonEnemyDrop;
    @NonNull private String talentMaterial;
    @NonNull private String weeklyBossDrop;
    private double baseHp;
    private double baseAtk;
    private double baseDef;
    @NonNull private AscensionStat ascensionStat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NonNull AscensionStat getAscensionStat() {
        return ascensionStat;
    }

    public void setAscensionStat(@NonNull AscensionStat ascensionStat) {
        this.ascensionStat = ascensionStat;
    }

    public double getBaseDef() {
        return baseDef;
    }

    public void setBaseDef(double baseDef) {
        this.baseDef = baseDef;
    }

    public double getBaseAtk() {
        return baseAtk;
    }

    public void setBaseAtk(double baseAtk) {
        this.baseAtk = baseAtk;
    }

    public double getBaseHp() {
        return baseHp;
    }

    public void setBaseHp(double baseHp) {
        this.baseHp = baseHp;
    }

    public @NonNull String getTalentMaterial() {
        return talentMaterial;
    }

    public void setTalentMaterial(@NonNull String talentMaterial) {
        this.talentMaterial = talentMaterial;
    }

    public @NonNull String getWeeklyBossDrop() {
        return weeklyBossDrop;
    }

    public void setWeeklyBossDrop(@NonNull String weeklyBossDrop) {
        this.weeklyBossDrop = weeklyBossDrop;
    }

    public @NonNull String getCommonEnemyDrop() {
        return commonEnemyDrop;
    }

    public void setCommonEnemyDrop(@NonNull String commonEnemyDrop) {
        this.commonEnemyDrop = commonEnemyDrop;
    }

    public @NonNull String getBossDrop() {
        return bossDrop;
    }

    public void setBossDrop(@NonNull String bossDrop) {
        this.bossDrop = bossDrop;
    }

    public int getLocalSpecialityId() {
        return localSpecialityId;
    }

    public void setLocalSpecialityId(int localSpecialityId) {
        this.localSpecialityId = localSpecialityId;
    }

    public @Nullable Nation getNation() {
        return nation;
    }

    public void setNation(@Nullable Nation nation) {
        this.nation = nation;
    }

    public @NonNull ModelType getModelType() {
        return modelType;
    }

    public void setModelType(@NonNull ModelType modelType) {
        this.modelType = modelType;
    }

    public @NonNull WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(@NonNull WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public @NonNull Element getElement() {
        return element;
    }

    public void setElement(@NonNull Element element) {
        this.element = element;
    }

    public @NonNull String getReleaseVersion() {
        return releaseVersion;
    }

    public void setReleaseVersion(@NonNull String releaseVersion) {
        this.releaseVersion = releaseVersion;
    }

    public @NonNull Rarity getRarity() {
        return rarity;
    }

    public void setRarity(@NonNull Rarity rarity) {
        this.rarity = rarity;
    }

    public @NonNull String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }
}
