package io.github.prittspadelord.dao;

import io.github.prittspadelord.dao.filters.CharacterFilter;
import io.github.prittspadelord.dao.filters.CharacterLocalSpecialityFilter;
import io.github.prittspadelord.model.Character;

import java.util.List;

public interface CharacterDao {
    Character getCharacterById(int id);
    Character getCharacterByExactName(String name);
    List<Character> listAllCharacters();
    List<Character> listCharactersWithFilter(CharacterFilter filter);
    List<Character> listCharactersWithFilter(CharacterLocalSpecialityFilter filter);
}