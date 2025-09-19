package io.github.prittspadelord.dao.impl;

import io.github.prittspadelord.dao.LocalSpecialityDao;
import io.github.prittspadelord.model.LocalSpeciality;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class LocalSpecialityDaoImpl implements LocalSpecialityDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocalSpecialityDaoImpl.class);

    private final DataSource dataSource;

    public LocalSpecialityDaoImpl(@Autowired DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<LocalSpeciality> listAllLocalSpecialities() {

        String sql = "SELECT * FROM local_specialities";

        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            ResultSet resultSet = statement.executeQuery();

            ArrayList<LocalSpeciality> localSpecialities = new ArrayList<>();

            while(resultSet.next()) {
                LocalSpeciality localSpeciality = new LocalSpeciality();
                localSpeciality.setId(resultSet.getInt("id"));
                localSpeciality.setName(resultSet.getString("name"));
                localSpeciality.setNation(LocalSpeciality.Nation.valueOf(resultSet.getString("nation")));

                localSpecialities.add(localSpeciality);
            }

            return localSpecialities;
        }
        catch(SQLException e) {
            LOGGER.error("SQL Error occured", e);
            return new ArrayList<>();
        }
    }

    @Override
    public List<LocalSpeciality> listLocalSpecialitiesByNation(LocalSpeciality.Nation nation) {
        return new ArrayList<>(); //ignore this is incomplete
    }

    @Override
    public LocalSpeciality getLocalSpecialityForId(int id) {
        return null; //ignore this is incomplete
    }
}
