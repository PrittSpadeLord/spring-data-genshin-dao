package io.github.prittspadelord;

import io.github.prittspadelord.config.DataSourceConfiguration;
import io.github.prittspadelord.dao.LocalSpecialityWithCharactersDao;
import io.github.prittspadelord.model.LocalSpecialityWithCharacters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class SpringDataGenshinDaoApplication {

    private static final Logger LOG = LoggerFactory.getLogger(SpringDataGenshinDaoApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);

        LocalSpecialityWithCharactersDao dao = context.getBean(LocalSpecialityWithCharactersDao.class);

        List<LocalSpecialityWithCharacters> list = dao.listAllLocalSpecialitiesWithCharacters();

        for(LocalSpecialityWithCharacters item: list) {
            LOG.info("{}: {}", item.getName(), item.getCharacters());
        }
    }
}

