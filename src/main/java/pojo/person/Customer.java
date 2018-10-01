package pojo.person;


import java.sql.Date;

public class Customer extends Person {

    public Customer() {
    }

    public Customer(int id, String name, String address, Date dateBirth) {
        super(id, name, address, dateBirth);
    }

    private int bonusPoints;

  public int getBonusPoints() {
    return bonusPoints;
  }

  public void setBonusPoints(int bonusPoints) {
    this.bonusPoints = bonusPoints;
  }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", dateBirth=" + dateBirth +
                ", bonusPoints=" + bonusPoints +
                '}';
    }
}
