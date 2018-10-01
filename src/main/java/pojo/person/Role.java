package pojo.person;


public class Role {

  private int id;
  private String name;

  public Role() {
  }

  public Role(int roleId, String name) {
    this.id = roleId;
    this.name = name;
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

  @Override
  public String toString() {
    return "Role{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }
}
