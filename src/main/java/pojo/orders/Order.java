package pojo.orders;


import java.sql.Date;

public class Order {
  private Integer id;
  private Integer customerId;
  private java.sql.Date dateOrder;
  private java.sql.Date dateReturn;
  private Integer status;

  public Order() {
  }

  public Order(Integer id, Integer customerId, Date dateOrder,
               Date dateReturn, Integer status) {
    this.id = id;
    this.customerId = customerId;
    this.dateOrder = dateOrder;
    this.dateReturn = dateReturn;
    this.status = status;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  public Date getDateOrder() {
    return dateOrder;
  }

  public void setDateOrder(Date dateOrder) {
    this.dateOrder = dateOrder;
  }

  public Date getDateReturn() {
    return dateReturn;
  }

  public void setDateReturn(Date dateReturn) {
    this.dateReturn = dateReturn;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }
}
