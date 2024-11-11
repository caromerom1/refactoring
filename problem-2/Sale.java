package refactoring.problema3;

public class Sale {
  private int saleId;
  private String saleDate;
  private int itemId;
  private int quantity;

  public Sale(int saleId, String saleDate, int itemId, int quantity) {
    this.saleId = saleId;
    this.saleDate = saleDate;
    this.itemId = itemId;
    this.quantity = quantity;
  }

  public Sale(String[] data) {
    this.saleId = Integer.parseInt(data[0]);
    this.saleDate = data[1];
    this.itemId = Integer.parseInt(data[2]);
    this.quantity = Integer.parseInt(data[3]);
  }

  public int getSaleId() {
    return saleId;
  }

  public String getSaleDate() {
    return saleDate;
  }

  public int getItemId() {
    return itemId;
  }

  public int getQuantity() {
    return quantity;
  }
}
