package io.github.prittspadelord.model;

import lombok.Getter;
import lombok.Setter;
import org.jspecify.annotations.NonNull;

import java.util.List;

@Getter
@Setter
public class LocalSpecialityWithCharacters {
    public enum Nation {
        mondstadt, liyue, inazuma, sumeru, fontaine, natlan, snezhnaya, ;
    }

    int id;
    @NonNull String name;
    @NonNull Nation nation;
    @NonNull List<String> characters;
}
