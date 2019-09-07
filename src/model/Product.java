package model;

import java.io.File;

public class Product {
  private int id;
  private String name;
  private long price;
  private int quantity;
  private File picture;

  public Product(int id, String name, int price, int quantity, File picture) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
    this.picture = picture;
  }

  public File getPicture() {
    return picture;
  }

  public void setPicture(File picture) {
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
