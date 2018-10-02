package pojo.person;


import java.sql.Date;

public class Person {

    private Integer id;
    private String name;
    private String address;
    private Date dateBirth;
    private Role role;
    private String login;
    private String password;
    private Integer bonusPoints;



    public Person() {

    }

    public Person(Integer id, String name, String address, Date dateBirth,
                  Role role, String login, String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dateBirth = dateBirth;
        this.role = role;
        this.login = login;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getBonusPoints() {
        return bonusPoints;
    }

    public void setBonusPoints(Integer bonusPoints) {
        this.bonusPoints = bonusPoints;
    }

}
