package io.github.prittspadelord.dao.filters;

import io.github.prittspadelord.model.Character;
import lombok.Setter;

@Setter
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

}
