package io.github.prittspadelord;

import io.github.prittspadelord.config.DataSourceConfiguration;
import io.github.prittspadelord.dao.LocalSpecialityDao;

import io.github.prittspadelord.model.LocalSpeciality;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class SpringDataGenshinDaoApplication {

    private static final Log LOG = LogFactory.getLog(SpringDataGenshinDaoApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);
        LocalSpecialityDao localSpecialityDao = context.getBean(LocalSpecialityDao.class);

        List<LocalSpeciality> localSpecialities = localSpecialityDao.listLocalSpecialitiesByNation(LocalSpeciality.Nation.sumeru);

        for(LocalSpeciality localSpeciality: localSpecialities) {
            LOG.info(localSpeciality.getName());
        }
    }
}