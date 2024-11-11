package refactoring.problema3;

public class Order {
  private int orderId;
  private String orderDate;
  private int itemId;
  private int quantity;

  public Order(int orderId, String orderDate, int itemId, int quantity) {
    this.orderId = orderId;
    this.orderDate = orderDate;
    this.itemId = itemId;
    this.quantity = quantity;
  }

  public Order(String[] data) {
    this.orderId = Integer.parseInt(data[0]);
    this.orderDate = data[1];
    this.itemId = Integer.parseInt(data[2]);
    this.quantity = Integer.parseInt(data[3]);
  }

  public int getOrderId() {
    return orderId;
  }

  public String getOrderDate() {
    return orderDate;
  }

  public int getItemId() {
    return itemId;
  }

  public int getQuantity() {
    return quantity;
  }
}
