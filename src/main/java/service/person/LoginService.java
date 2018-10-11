package service.person;

import pojo.person.Person;

public interface LoginService {

    int getRole(String login);

    boolean checkAuth(String login, String password);

    Person getCustomerByLogin(String login);

}
