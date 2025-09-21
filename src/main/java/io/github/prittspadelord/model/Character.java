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
    @NonNull private Rarity rarity; //enum
    @NonNull private String releaseVersion;
    @NonNull private Element element; //enum
    @NonNull private WeaponType weaponType; //enum
    @NonNull private ModelType modelType; //enum
    @Nullable private Nation nation; //enum
    private int localSpecialityId;
    @NonNull private String bossDrop;
    @NonNull private String commonEnemyDrop;
    @NonNull private String talentMaterial;
    @NonNull private String weeklyBossDrop;
    private double baseHp;
    private double baseAtk;
    private double baseDef;
    @NonNull private AscensionStat ascensionStat; //enum
}
