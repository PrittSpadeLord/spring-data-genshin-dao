package io.github.prittspadelord.dao.impl;

import io.github.prittspadelord.dao.LocalSpecialityDao;
import io.github.prittspadelord.model.LocalSpeciality;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Slf4j
@Repository
public class LocalSpecialityDaoImpl implements LocalSpecialityDao {

    private static final RowMapper<LocalSpeciality> ROW_MAPPER = new BeanPropertyRowMapper<>(LocalSpeciality.class);

    private final JdbcTemplate jdbcTemplate;

    public LocalSpecialityDaoImpl(@Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<LocalSpeciality> listAllLocalSpecialities() {
        log.info("listAllLocalSpecialities called");
        String sql = "SELECT id, name, nation FROM local_specialities";

        Stream<LocalSpeciality> stream = jdbcTemplate.queryForStream(sql, ROW_MAPPER);

        return stream.toList();
    }

    @Override
    public List<LocalSpeciality> listLocalSpecialitiesByNation(LocalSpeciality.Nation nation) {
        log.info("listLocalSpecialitiesByNation called");
        String sql = "SELECT id, name, nation FROM local_specialities WHERE nation = ?::nation";

        Stream<LocalSpeciality> stream = jdbcTemplate.queryForStream(sql, ROW_MAPPER, nation.toString());

        return stream.toList();
    }

    @Override
    public LocalSpeciality getLocalSpecialityForId(int id) {
        log.info("getLocalSpecialityForId called");
        String sql = "SELECT id, name, nation FROM local_specialities WHERE id = ?";

        return jdbcTemplate.queryForObject(sql, ROW_MAPPER, id);
    }

    @Override
    public String getLocalSpecialityNameForId(int id) {
        log.info("getLocalSpecialityNameForId called");
        String sql = "SELECT name FROM local_specialities WHERE id = ?";

        return jdbcTemplate.queryForObject(sql, String.class, id);
    }
}
