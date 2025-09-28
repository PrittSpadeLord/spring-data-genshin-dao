package io.github.prittspadelord.dao.impl;

import io.github.prittspadelord.dao.LocalSpecialityWithCharactersDao;
import io.github.prittspadelord.model.LocalSpecialityWithCharacters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LocalSpecialityWithCharactersDaoImpl implements LocalSpecialityWithCharactersDao {

    private static final Logger LOG = LoggerFactory.getLogger(LocalSpecialityWithCharactersDaoImpl.class);

    private final JdbcTemplate jdbcTemplate;

    public LocalSpecialityWithCharactersDaoImpl(@Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<LocalSpecialityWithCharacters> listAllLocalSpecialitiesWithCharacters() {

        String sql = "SELECT local_specialities.id AS local_specialities_id, local_specialities.name AS local_specialities_name, local_specialities.nation AS local_specialities_nation, characters.name AS characters_name FROM local_specialities INNER JOIN characters ON characters.local_speciality_id = local_specialities.id";

        ResultSetExtractor<List<LocalSpecialityWithCharacters>> rse = (resultSet) -> {

            boolean found = false;
            ArrayList<LocalSpecialityWithCharacters> list = new ArrayList<>();

            while(resultSet.next()) {
                for(LocalSpecialityWithCharacters localSpeciality: list) {
                    if(resultSet.getInt("local_specialities_id") == localSpeciality.getId()) {
                        found = true;

                        List<String> characterList = localSpeciality.getCharacters();
                        characterList.add(resultSet.getString("characters_name"));
                        localSpeciality.setCharacters(characterList);
                    }
                }

                if(!found) {
                    LocalSpecialityWithCharacters localSpecialityWithCharacters = new LocalSpecialityWithCharacters();

                    localSpecialityWithCharacters.setId(resultSet.getInt("local_specialities_id"));
                    localSpecialityWithCharacters.setName(resultSet.getString("local_specialities_name"));
                    localSpecialityWithCharacters.setNation(LocalSpecialityWithCharacters.Nation.valueOf(resultSet.getString("local_specialities_nation")));

                    List<String> charList = new ArrayList<>();
                    charList.add(resultSet.getString("characters_name"));

                    localSpecialityWithCharacters.setCharacters(charList);

                    list.add(localSpecialityWithCharacters);
                }

                found = false;
            }

            return list;
        };

        return jdbcTemplate.query(sql, rse);
    }
}
