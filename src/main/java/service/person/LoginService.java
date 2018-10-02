package service.person;

public interface LoginService {

    int getRole(String login);

    boolean checkAuth(String login, String password);
}
