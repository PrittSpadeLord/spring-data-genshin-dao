package io.github.prittspadelord;

import io.github.prittspadelord.config.DataSourceConfiguration;

import io.github.prittspadelord.dao.CharacterDao;
import io.github.prittspadelord.dao.filters.CharacterFilter;
import io.github.prittspadelord.model.Character;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@Slf4j
public class SpringDataGenshinDaoApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);

        CharacterDao characterDao = context.getBean(CharacterDao.class);

        CharacterFilter filter = new CharacterFilter();
        filter.setNation(Character.Nation.inazuma);
        filter.setModelType(Character.ModelType.medium_female);

        List<Character> characters = characterDao.listCharactersWithFilter(filter);

        for(Character character: characters) {
            log.info(character.getName());
        }
    }
}

