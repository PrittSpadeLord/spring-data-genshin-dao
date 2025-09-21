package io.github.prittspadelord.dao.filters;

import io.github.prittspadelord.model.Character;

public class CharacterLocalSpecialityFilter {

    public enum ComparisonType {
        equal, greater, lesser, greater_or_equal, lesser_or_equal;
    }

    private io.github.prittspadelord.model.Character.Element element;
    private io.github.prittspadelord.model.Character.Rarity rarity;
    private String releaseVersion;
    private io.github.prittspadelord.model.Character.Nation nation;
    private io.github.prittspadelord.model.Character.WeaponType weaponType;
    private io.github.prittspadelord.model.Character.ModelType modelType;

    private Integer localSpecialityId;
    private String localSpecialityName;

    private Float baseHP;
    private CharacterLocalSpecialityFilter.ComparisonType baseHPComparisonType;
    private Float baseATK;
    private CharacterLocalSpecialityFilter.ComparisonType baseATKComparisonType;
    private Float baseDEF;
    private CharacterLocalSpecialityFilter.ComparisonType baseDEFComparisonType;
    private Character.AscensionStat ascensionStat;

    public void setElement(Character.Element element) {
        this.element = element;
    }

    public void setRarity(Character.Rarity rarity) {
        this.rarity = rarity;
    }

    public void setReleaseVersion(String releaseVersion) {
        this.releaseVersion = releaseVersion;
    }

    public void setNation(Character.Nation nation) {
        this.nation = nation;
    }

    public void setWeaponType(Character.WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public void setModelType(Character.ModelType modelType) {
        this.modelType = modelType;
    }

    public void setLocalSpecialityId(Integer localSpecialityId) {
        this.localSpecialityId = localSpecialityId;
    }

    public void setLocalSpecialityName(String localSpecialityName) {
        this.localSpecialityName = localSpecialityName;
    }

    public void setBaseHP(Float baseHP) {
        this.baseHP = baseHP;
    }

    public void setBaseHPComparisonType(ComparisonType baseHPComparisonType) {
        this.baseHPComparisonType = baseHPComparisonType;
    }

    public void setBaseATK(Float baseATK) {
        this.baseATK = baseATK;
    }

    public void setBaseDEF(Float baseDEF) {
        this.baseDEF = baseDEF;
    }

    public void setBaseATKComparisonType(ComparisonType baseATKComparisonType) {
        this.baseATKComparisonType = baseATKComparisonType;
    }

    public void setAscensionStat(Character.AscensionStat ascensionStat) {
        this.ascensionStat = ascensionStat;
    }

    public void setBaseDEFComparisonType(ComparisonType baseDEFComparisonType) {
        this.baseDEFComparisonType = baseDEFComparisonType;
    }
}
