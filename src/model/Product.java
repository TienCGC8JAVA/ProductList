package model;


public class Product {
  private int id;
  private String name;
  private long price;
  private int quantity;
  private String picture;

  public Product(int id, String name, int price, int quantity, String picture) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
    this.picture = picture;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
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

  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
