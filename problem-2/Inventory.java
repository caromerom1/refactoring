package refactoring.problema3;

import refactoring.problema3.Product;
import refactoring.problema3.Sale;
import refactoring.problema3.Order;
import refactoring.problema3.utils.File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Inventory {

  public static void main(String[] args) {
    String csvFileProducts = "./refactoring/problema3/data/products.csv";
    String csvFileSales = "./refactoring/problema3/data/sales.csv";
    String csvFileOrders = "./refactoring/problema3/data/orders.csv";

    System.out.println(csvFileProducts);
    String csvSplitBy = ",";

    ArrayList<Product> products = new ArrayList<Product>();
    ArrayList<Sale> sales = new ArrayList<Sale>();
    ArrayList<Order> orders = new ArrayList<Order>();

    List<String[]> productsData = File.readCsv(csvFileProducts, csvSplitBy);
    List<String[]> salesData = File.readCsv(csvFileSales, csvSplitBy);
    List<String[]> ordersData = File.readCsv(csvFileOrders, csvSplitBy);

    for (String[] data : productsData) {
      Product product = new Product(data);
      products.add(product);
    }

    for (String[] data : salesData) {
      Sale sale = new Sale(data);
      sales.add(sale);
    }

    for (String[] data : ordersData) {
      Order order = new Order(data);
      orders.add(order);
    }

    for (Order order : orders) {
      Product item = products.get(order.getItemId());
      item.setQuantity(item.getQuantity() + order.getQuantity());
    }

    for (Sale sale : sales) {
      Product item = products.get(sale.getItemId());
      item.setQuantity(item.getQuantity() - sale.getQuantity());
    }

    for (Product product : products) {
      System.out.println(product.getItem() + " " + product.getQuantity());
    }

  }
}
