package io.github.prittspadelord.model;

//import lombok.Getter;
//import lombok.Setter;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

//@Getter
//@Setter
public class Character {

    public enum Rarity {
        FOUR_STAR, FIVE_STAR;

        public int getValue() {
            return switch(this) {
                case FOUR_STAR -> 4;
                case FIVE_STAR -> 5;
            };
        }

        public static Rarity getRarity(int value) {
            return switch (value) {
                case 4 -> FOUR_STAR;
                case 5 -> FIVE_STAR;
                default -> throw new IllegalArgumentException("Rarity must be 4 or 5");
            };
        }
    }

    public enum Element {
        ANEMO, GEO, ELECTRO, DENDRO, HYDRO, PYRO, CRYO;

        @Override
        @NonNull
        public String toString() {
            return this.name().toLowerCase();
        }

        @NonNull
        public static Element getElement(@NonNull String value) {
            try {
                return Element.valueOf(value.toUpperCase());
            }
            catch(IllegalArgumentException e) {
                throw new IllegalArgumentException("Element must be anemo, geo, electro, dendro, hydro, pyro or cryo", e);
            }
        }
    }

    public enum WeaponType {
        SWORD, POLEARM, BOW, CLAYMORE, CATALYST;

        @Override
        @NonNull
        public String toString() {
            return this.name().toLowerCase();
        }

        @NonNull
        public static WeaponType getWeaponType(@NonNull String value) {
            try {
                return WeaponType.valueOf(value.toUpperCase());
            }
            catch(IllegalArgumentException e) {
                throw new IllegalArgumentException("Weapon type must be sword, polearm, bow, claymore or catalyst", e);
            }
        }
    }

    private int id;
    @NonNull private String name;
    @NonNull private Rarity rarity; //enum
    @NonNull private String releaseVersion;
    @NonNull private Element element; //enum
    @NonNull private WeaponType weaponType; //enum
    @NonNull private String modelType; //enum
    @Nullable private String nation; //enum
    private int localSpecialityId;
    @NonNull private String bossDrop;
    @NonNull private String commonEnemyDrop;
    @NonNull private String talentMaterial;
    @NonNull private String weeklyBossDrop;
    private double baseHp;
    private double baseAtk;
    private double baseDef;
    @NonNull private String ascensionStat; //enum
}
