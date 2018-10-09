package pojo.orders;


public class OrderDetails {
  private Integer orderId;
  private Integer gameId;
  private Integer amount;

  /**
   * field exist only in Pojo class
  * */
  private String gameName;

  public OrderDetails() {
  }

    public OrderDetails(Integer orderId, Integer gameId,
                        Integer amount) {
        this.orderId = orderId;
        this.gameId = gameId;
        this.amount = amount;
    }

  public OrderDetails(Integer orderId, Integer gameId,
                      Integer amount, String gameName) {
    this.orderId = orderId;
    this.gameId = gameId;
    this.amount = amount;
    this.gameName = gameName;
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

  public String getGameName() {
    return gameName;
  }

  public void setGameName(String gameName) {
    this.gameName = gameName;
  }
}
