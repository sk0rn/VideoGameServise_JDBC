package pojo.orders;


public class OrderDetails {
  private Integer orderId;
  private Integer gameId;
  private Integer amount;

  public OrderDetails() {
  }

    public OrderDetails(Integer orderId, Integer gameId,
                        Integer amount) {
        this.orderId = orderId;
        this.gameId = gameId;
        this.amount = amount;
    }

    public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public Integer getGameId() {
    return gameId;
  }

  public void setGameId(Integer gameId) {
    this.gameId = gameId;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }
}
