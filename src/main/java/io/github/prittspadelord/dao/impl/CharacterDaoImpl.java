package io.github.prittspadelord.dao.impl;

import io.github.prittspadelord.dao.CharacterDao;
import io.github.prittspadelord.dao.filters.CharacterFilter;
import io.github.prittspadelord.dao.filters.CharacterLocalSpecialityFilter;
import io.github.prittspadelord.model.Character;
import io.github.prittspadelord.model.LocalSpeciality;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class CharacterDaoImpl implements CharacterDao {
    private static final Log LOG = LogFactory.getLog(CharacterDaoImpl.class);
    private static final RowMapper<Character> ROW_MAPPER = new BeanPropertyRowMapper<>(Character.class);

    private final JdbcTemplate jdbcTemplate;

    public CharacterDaoImpl(@Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Character getCharacterById(int id) {
        LOG.info("getCharacterById called");
        String sql = "SELECT * FROM characters WHERE id = ?";

        return jdbcTemplate.queryForObject(sql, ROW_MAPPER, id);
    }

    @Override
    public Character getCharacterByExactName(String name) {
        LOG.info("getCharacterByExactName called");
        String sql = "SELECT * FROM characters WHERE name = ?";

        return jdbcTemplate.queryForObject(sql, ROW_MAPPER, name);
    }

    @Override
    public List<Character> listAllCharacters() {
        LOG.info("getCharacterByExactName called");
        String sql = "SELECT * FROM characters";

        Stream<Character> stream = jdbcTemplate.queryForStream(sql, ROW_MAPPER);
        return stream.toList();
    }

    @Override
    public List<Character> listCharactersWithFilter(CharacterFilter filter) {
        List<Object> queryParams = new ArrayList<>();
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT * FROM characters WHERE 1=1");

        if(filter.getElement() != null) {
            queryBuilder.append(" AND element = ?::element");
            queryParams.add(filter.getElement().name());
        }

        if(filter.getRarity() != null) {
            queryBuilder.append(" AND rarity = ?::rarity");
            queryParams.add(filter.getRarity().name());
        }

        if(filter.getReleaseVersion() != null) {
            queryBuilder.append(" AND release_version = ?");
            queryParams.add(filter.getReleaseVersion());
        }

        if(filter.getNation() != null) {
            queryBuilder.append(" AND nation = ?::nation");
            queryParams.add(filter.getNation().name());
        }

        if(filter.getWeaponType() != null) {
            queryBuilder.append(" AND weapon_type = ?::weapon_type");
            queryParams.add(filter.getWeaponType().name());
        }

        if(filter.getModelType() != null) {
            queryBuilder.append(" AND model_type = ?::model_type");
            queryParams.add(filter.getModelType().name());
        }

        //more to be added

        String sql = queryBuilder.toString();
        Stream<Character> stream = jdbcTemplate.queryForStream(sql, ROW_MAPPER, queryParams.toArray());
        return stream.toList();
    }

    @Override
    public List<Character> listCharactersWithFilter(CharacterLocalSpecialityFilter filter) {
        return List.of();
    }
}
