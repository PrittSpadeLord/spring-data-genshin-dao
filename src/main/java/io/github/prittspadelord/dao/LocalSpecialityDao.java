package io.github.prittspadelord.dao;

import io.github.prittspadelord.model.LocalSpeciality;

import java.util.List;

public interface LocalSpecialityDao {
    List<LocalSpeciality> listAllLocalSpecialities();
    List<LocalSpeciality> listLocalSpecialitiesByNation(LocalSpeciality.Nation nation);
    LocalSpeciality getLocalSpecialityForId(int id);
}