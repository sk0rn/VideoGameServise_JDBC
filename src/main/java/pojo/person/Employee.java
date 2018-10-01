package pojo.person;


import java.sql.Date;

public class Employee extends Person {

  private Role role;

    public Employee() {

    }

    public Employee(int id, String name, String address, Date dateBirth, Role role) {
        super(id, name, address, dateBirth);
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +

                "id=" + id +
                ", role=" + role +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", dateBirth=" + dateBirth +
                '}';
    }
}
