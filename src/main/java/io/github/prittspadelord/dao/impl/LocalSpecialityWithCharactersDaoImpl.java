package io.github.prittspadelord.dao.impl;

import io.github.prittspadelord.dao.LocalSpecialityWithCharactersDao;
import io.github.prittspadelord.model.LocalSpecialityWithCharacters;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.util.ArrayList;
import java.util.List;

public class LocalSpecialityWithCharactersDaoImpl implements LocalSpecialityWithCharactersDao {

    private static final Log LOG = LogFactory.getLog(LocalSpecialityWithCharactersDaoImpl.class);

    private final JdbcTemplate jdbcTemplate;

    public LocalSpecialityWithCharactersDaoImpl(@Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<LocalSpecialityWithCharacters> listAllLocalSpecialitiesWithCharacters() {

        String sql = "SELECT local_specialities.id, local_specialities.name, local_specialities.nation, characters.name FROM local_specialities INNER JOIN characters ON characters.local_speciality_id = local_specialities.id";

        ResultSetExtractor<List<LocalSpecialityWithCharacters>> rse = (resultSet) -> {

            boolean found = false;
            ArrayList<LocalSpecialityWithCharacters> list = new ArrayList<>();

            while(resultSet.next()) {
                for(LocalSpecialityWithCharacters localSpeciality: list) {
                    if(resultSet.getInt("local_specialities.id") == localSpeciality.getId()) {
                        found = true;

                        List<String> characterList = localSpeciality.getCharacters();
                        characterList.add(resultSet.getString("characters.name"));
                        localSpeciality.setCharacters(characterList);
                    }
                }
            }

            if(!found) {
                LocalSpecialityWithCharacters localSpecialityWithCharacters = new LocalSpecialityWithCharacters();

                //stuff

                list.add(localSpecialityWithCharacters);
            }

            return list;
        };

        return jdbcTemplate.query(sql, rse);
    }
}
