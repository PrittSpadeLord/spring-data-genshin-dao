package io.github.prittspadelord;

import io.github.prittspadelord.config.DataSourceConfiguration;
import io.github.prittspadelord.dao.LocalSpecialityDao;
import io.github.prittspadelord.model.LocalSpeciality;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class SpringDataGenshinDaoApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);
        LocalSpecialityDao localSpecialityDao = context.getBean(LocalSpecialityDao.class);

        List<LocalSpeciality> list = localSpecialityDao.listAllLocalSpecialities();

        for(LocalSpeciality item: list) {
            System.out.println(item.getName());
        }
    }
}