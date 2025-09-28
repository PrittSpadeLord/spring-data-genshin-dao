package io.github.prittspadelord.dao.impl;

import io.github.prittspadelord.dao.CharacterDao;
import io.github.prittspadelord.dao.filters.CharacterFilter;
import io.github.prittspadelord.dao.filters.CharacterLocalSpecialityFilter;
import io.github.prittspadelord.model.Character;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static final Logger LOG = LoggerFactory.getLogger(CharacterDaoImpl.class);
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
            queryBuilder.append(" AND element");
            queryParams.add(filter.getElement().name());

            switch(filter.getElementEqualityOperation()) {
                case equal -> queryBuilder.append(" =");
                case not_equal -> queryBuilder.append(" !=");
            }

            queryBuilder.append(" ?::character_element");
        }

        if(filter.getRarity() != null) {
            queryBuilder.append(" AND rarity");
            queryParams.add(filter.getRarity().name());

            switch(filter.getRarityEqualityOperation()) {
                case equal -> queryBuilder.append(" =");
                case not_equal -> queryBuilder.append(" !=");
            }

            queryBuilder.append(" ?::rarity");
        }

        if(filter.getReleaseVersion() != null) {
            queryBuilder.append(" AND release_version");
            queryParams.add(filter.getReleaseVersion());

            switch(filter.getReleaseVersionEqualityOperation()) {
                case equal -> queryBuilder.append(" =");
                case not_equal -> queryBuilder.append(" !=");
            }

            queryBuilder.append(" ?");
        }

        if(filter.getNation() != null) {
            queryBuilder.append(" AND nation");
            queryParams.add(filter.getNation().name());

            switch(filter.getNationEqualityOperation()) {
                case equal -> queryBuilder.append(" =");
                case not_equal -> queryBuilder.append(" !=");
            }

            queryBuilder.append(" ?::nation");
        }

        if(filter.getWeaponType() != null) {
            queryBuilder.append(" AND weapon_type");
            queryParams.add(filter.getWeaponType().name());

            switch(filter.getWeaponTypeEqualityOperation()) {
                case equal -> queryBuilder.append(" =");
                case not_equal -> queryBuilder.append(" !=");
            }

            queryBuilder.append(" ?::weapon_type");
        }

        if(filter.getModelType() != null) {
            queryBuilder.append(" AND model_type");
            queryParams.add(filter.getModelType().name());

            switch(filter.getModelTypeEqualityOperation()) {
                case equal -> queryBuilder.append(" =");
                case not_equal -> queryBuilder.append(" !=");
            }

            queryBuilder.append(" ?::model_type");
        }

        if(filter.getBaseHP() != null) {
            queryBuilder.append(" AND base_hp");
            queryParams.add(filter.getBaseHP());

            switch(filter.getBaseHPComparisonOperation()) {
                case equal -> queryBuilder.append(" =");
                case greater -> queryBuilder.append(" >");
                case lesser -> queryBuilder.append(" <");
                case greater_or_equal -> queryBuilder.append(" >=");
                case lesser_or_equal -> queryBuilder.append(" <=");
                case not_equal -> queryBuilder.append(" !=");
            }

            queryBuilder.append(" ?");
        }

        if(filter.getBaseATK() != null) {
            queryBuilder.append(" AND base_atk");
            queryParams.add(filter.getBaseATK());

            switch(filter.getBaseATKComparisonOperation()) {
                case equal -> queryBuilder.append(" =");
                case greater -> queryBuilder.append(" >");
                case lesser -> queryBuilder.append(" <");
                case greater_or_equal -> queryBuilder.append(" >=");
                case lesser_or_equal -> queryBuilder.append(" <=");
                case not_equal -> queryBuilder.append(" !=");
            }

            queryBuilder.append(" ?");
        }

        if(filter.getBaseDEF() != null) {
            queryBuilder.append(" AND base_def");
            queryParams.add(filter.getBaseDEF());

            switch(filter.getBaseDEFComparisonOperation()) {
                case equal -> queryBuilder.append(" =");
                case greater -> queryBuilder.append(" >");
                case lesser -> queryBuilder.append(" <");
                case greater_or_equal -> queryBuilder.append(" >=");
                case lesser_or_equal -> queryBuilder.append(" <=");
            }

            queryBuilder.append(" ?");
        }

        if(filter.getAscensionStat() != null) {
            queryBuilder.append(" AND ascension_stat");
            queryParams.add(filter.getAscensionStat().name());

            switch(filter.getAscensionStatEqualityOperation()) {
                case equal -> queryBuilder.append(" =");
                case not_equal -> queryBuilder.append(" !=");
            }

            queryBuilder.append(" ?::ascension_stat");
        }

        String sql = queryBuilder.toString();
        Stream<Character> stream = jdbcTemplate.queryForStream(sql, ROW_MAPPER, queryParams.toArray());
        return stream.toList();
    }

    @Override
    public List<Character> listCharactersWithFilter(CharacterLocalSpecialityFilter filter) {
        //under construction!!
        return new ArrayList<>();
    }
}
