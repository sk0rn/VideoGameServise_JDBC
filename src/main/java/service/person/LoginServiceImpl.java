package service.person;

import org.apache.log4j.Logger;
import pojo.person.Person;
import repository.dao.person.impl.PersonDaoImpl;
import repository.dao.person.interfaces.PersonDao;
import utils.CheckUserData;
import utils.UtilMD5;

import java.sql.SQLException;

public class LoginServiceImpl implements LoginService {

    private static final Logger LOGGER = Logger.getLogger(LoginServiceImpl.class);
    PersonDao personDao = new PersonDaoImpl();

    // метод возвращаем int значение роли юзера(для админа значение == 1)
    @Override
    public int getRole(String login) {
        Person person;
        if (login != null) {
            try {
                person = personDao.getPersonByLogin(login);
                if (person == null)
                    return 0;
                return person.getRole().getId();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
        return -1;
    }

    // метод проверяет есть ли в бд искомый логин с соответствующим пароле
    @Override
    public boolean checkAuth(String login, String password) {
        Person person;
        if (login != null && password != null) {
            try {
                person = personDao.getPersonByLogin(login);
                if (person != null) {
                    if (person.getPassword().equals(UtilMD5.md5Custom(password)))
                        return true;
                } else {
                    return false;
                }
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
        return false;
    }

    @Override
    public Person getCustomerByLogin(String login) {
        try {
            return personDao.getPersonByLogin(login);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public boolean checkPassword(String password) {
        return CheckUserData.checkPassword(password,
                8, 2, 2, 2);
    }


}
