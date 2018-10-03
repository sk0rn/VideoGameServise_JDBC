package service.person;

import org.apache.log4j.Logger;
import pojo.person.Person;
import repository.dao.person.impl.UserDaoImpl;
import repository.dao.person.interfaces.UserDao;
import utils.UtilMD5;

import java.sql.SQLException;

public class LoginServiceImpl implements LoginService {

    private static final Logger LOGGER = Logger.getLogger(LoginServiceImpl.class);
    UserDao userDao = new UserDaoImpl();

    // метод возвращаем int значение роли юзера(для админа значение == 1)
    @Override
    public int getRole(String login) {
        Person person;
        if (login != null) {
            try {
                person = userDao.getUserByLogin(login);
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
        Person personr;
        if (login != null && password != null) {
            try {
                personr = userDao.getUserByLogin(login);
                if (personr != null) {
                    if (personr.getPassword().equals(UtilMD5.md5Custom(password)))
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

}
