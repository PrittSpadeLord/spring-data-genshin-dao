package io.github.prittspadelord.dao.filters;

import io.github.prittspadelord.model.Character;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterFilter {

    public enum EqualityOperation {
        equal_to, not_equal_to
    }

    public enum ComparisonOperation {
        equal_to, greater_than, less_than, greater_than_or_equal_to, less_than_or_equal_to, not_equal_to
    }

    public enum OrderByStat {
        baseHp, baseATK, baseDEF
    }

    public enum OrderByDirection {
        ascending, descending
    }

    private Character.Element element;
    @Setter(AccessLevel.NONE) private EqualityOperation elementEqualityOperation = EqualityOperation.equal_to;
    private Character.Rarity rarity;
    @Setter(AccessLevel.NONE) private EqualityOperation rarityEqualityOperation = EqualityOperation.equal_to;
    private String releaseVersion;
    @Setter(AccessLevel.NONE) private EqualityOperation releaseVersionEqualityOperation = EqualityOperation.equal_to;
    private Character.Nation nation;
    @Setter(AccessLevel.NONE) private EqualityOperation nationEqualityOperation = EqualityOperation.equal_to;
    private Character.WeaponType weaponType;
    @Setter(AccessLevel.NONE) private EqualityOperation weaponTypeEqualityOperation = EqualityOperation.equal_to;
    private Character.ModelType modelType;
    @Setter(AccessLevel.NONE) private EqualityOperation modelTypeEqualityOperation = EqualityOperation.equal_to;

    private Float baseHP;
    @Setter(AccessLevel.NONE) private ComparisonOperation baseHPComparisonOperation = ComparisonOperation.equal_to;
    private Float baseATK;
    @Setter(AccessLevel.NONE) private ComparisonOperation baseATKComparisonOperation = ComparisonOperation.equal_to;
    private Float baseDEF;
    @Setter(AccessLevel.NONE) private ComparisonOperation baseDEFComparisonOperation = ComparisonOperation.equal_to;

    private Character.AscensionStat ascensionStat;
    @Setter(AccessLevel.NONE) private EqualityOperation ascensionStatEqualityOperation = EqualityOperation.equal_to;

    private OrderByStat orderByStat = null;
    private OrderByDirection orderByDirection = null;

    public void setElement(Character.Element element, EqualityOperation elementEqualityOperation) {
        this.element = element;
        this.elementEqualityOperation = elementEqualityOperation;
    }

    public void setRarity(Character.Rarity rarity, EqualityOperation rarityEqualityOperation) {
        this.rarity = rarity;
        this.rarityEqualityOperation = rarityEqualityOperation;
    }

    public void setReleaseVersion(String releaseVersion, EqualityOperation releaseVersionEqualityOperation) {
        this.releaseVersion = releaseVersion;
        this.releaseVersionEqualityOperation = releaseVersionEqualityOperation;
    }

    public void setNation(Character.Nation nation, EqualityOperation nationEqualityOperation) {
        this.nation = nation;
        this.nationEqualityOperation = nationEqualityOperation;
    }

    public void setWeaponType(Character.WeaponType weaponType, EqualityOperation weaponTypeEqualityOperation) {
        this.weaponType = weaponType;
        this.weaponTypeEqualityOperation = weaponTypeEqualityOperation;
    }

    public void setModelType(Character.ModelType modelType, EqualityOperation modelTypeEqualityOperation) {
        this.modelType = modelType;
        this.modelTypeEqualityOperation = modelTypeEqualityOperation;
    }

    public void setBaseHP(Float baseHP, ComparisonOperation baseHPComparisonOperation) {
        this.baseHP = baseHP;
        this.baseHPComparisonOperation = baseHPComparisonOperation;
    }

    public void setBaseATK(Float baseATK, ComparisonOperation baseATKComparisonOperation) {
        this.baseATK = baseATK;
        this.baseATKComparisonOperation = baseATKComparisonOperation;
    }

    public void setBaseDEF(Float baseDEF, ComparisonOperation baseDEFComparisonOperation) {
        this.baseDEF = baseDEF;
        this.baseDEFComparisonOperation = baseDEFComparisonOperation;
    }

    public void setAscensionStat(Character.AscensionStat ascensionStat, EqualityOperation ascensionStatEqualityOperation) {
        this.ascensionStat = ascensionStat;
        this.ascensionStatEqualityOperation = ascensionStatEqualityOperation;
    }
}
