package io.github.prittspadelord;

import io.github.prittspadelord.config.DataSourceConfiguration;
import io.github.prittspadelord.dao.LocalSpecialityWithCharactersDao;

import io.github.prittspadelord.model.LocalSpecialityWithCharacters;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class SpringDataGenshinDaoApplication {

    private static final Log LOG = LogFactory.getLog(SpringDataGenshinDaoApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);
//        CharacterDao characterDao = context.getBean(CharacterDao.class);
//
//        CharacterFilter characterFilter = new CharacterFilter();
//        characterFilter.setElement(Character.Element.hydro, CharacterFilter.EqualityOperation.not_equal);
//        characterFilter.setNation(Character.Nation.fontaine);
//
//        List<Character> characters = characterDao.listCharactersWithFilter(characterFilter);
//
//        if(characters.isEmpty()) LOG.info("No characters match these filters");
//
//        for(Character character: characters) {
//            LOG.info(character.getName());
//        }

        LocalSpecialityWithCharactersDao dao = context.getBean(LocalSpecialityWithCharactersDao.class);

        List<LocalSpecialityWithCharacters> list = dao.listAllLocalSpecialitiesWithCharacters();

        for(LocalSpecialityWithCharacters item: list) {
            System.out.println(item.getName() + ": " + item.getCharacters());
        }
    }
}

