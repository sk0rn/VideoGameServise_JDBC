package pojo.person;


import java.sql.Date;

public abstract class Person {

    protected int id;
    protected String name;
    protected String address;
    protected Date dateBirth;

    public Person() {
    }

    public Person(int id, String name, String address, Date dateBirth) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dateBirth = dateBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
