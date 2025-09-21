package io.github.prittspadelord.dao.filters;

import io.github.prittspadelord.model.Character;
import org.jspecify.annotations.Nullable;

import java.util.concurrent.ConcurrentMap;

public class CharacterFilter {

    public enum ComparisonType {
        equal, greater, lesser, greater_or_equal, lesser_or_equal;
    }

    private Character.Element element;
    private Character.Rarity rarity;
    private String releaseVersion;
    private Character.Nation nation;
    private Character.WeaponType weaponType;
    private Character.ModelType modelType;

    private Float baseHP;
    private ComparisonType baseHPComparisonType;
    private Float baseATK;
    private ComparisonType baseATKComparisonType;
    private Float baseDEF;
    private ComparisonType baseDEFComparisonType;
    private Character.AscensionStat ascensionStat;

    public Character.Element getElement() {
        return element;
    }

    public void setElement(Character.Element element) {
        this.element = element;
    }

    public Character.Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Character.Rarity rarity) {
        this.rarity = rarity;
    }

    public String getReleaseVersion() {
        return releaseVersion;
    }

    public void setReleaseVersion(String releaseVersion) {
        this.releaseVersion = releaseVersion;
    }

    public Character.ModelType getModelType() {
        return modelType;
    }

    public void setModelType(Character.ModelType modelType) {
        this.modelType = modelType;
    }

    public Character.WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(Character.WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public Character.Nation getNation() {
        return nation;
    }

    public void setNation(Character.Nation nation) {
        this.nation = nation;
    }

    public Float getBaseHP() {
        return baseHP;
    }

    public void setBaseHP(Float baseHP) {
        this.baseHP = baseHP;
    }

    public ComparisonType getBaseHPComparisonType() {
        return baseHPComparisonType;
    }

    public void setBaseHPComparisonType(ComparisonType baseHPComparisonType) {
        this.baseHPComparisonType = baseHPComparisonType;
    }

    public Float getBaseATK() {
        return baseATK;
    }

    public void setBaseATK(Float baseATK) {
        this.baseATK = baseATK;
    }

    public ComparisonType getBaseATKComparisonType() {
        return baseATKComparisonType;
    }

    public void setBaseATKComparisonType(ComparisonType baseATKComparisonType) {
        this.baseATKComparisonType = baseATKComparisonType;
    }

    public Float getBaseDEF() {
        return baseDEF;
    }

    public void setBaseDEF(Float baseDEF) {
        this.baseDEF = baseDEF;
    }

    public Character.AscensionStat getAscensionStat() {
        return ascensionStat;
    }

    public void setAscensionStat(Character.AscensionStat ascensionStat) {
        this.ascensionStat = ascensionStat;
    }

    public ComparisonType getBaseDEFComparisonType() {
        return baseDEFComparisonType;
    }

    public void setBaseDEFComparisonType(ComparisonType baseDEFComparisonType) {
        this.baseDEFComparisonType = baseDEFComparisonType;
    }
}
