package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {

  private static Map<Integer, Product> products;

  static {
    products = new HashMap<>();
    int id_product1 = (int) (Math.random() * 100000);
    products.put(id_product1, new Product(id_product1," iPhone 7 Plus 32GB",13490000,(int) (Math.random() * 100) + 1,"iphone-7-plus-gold-400x460.png"));
    int id_product2 = (int) (Math.random() * 100000);
    products.put(id_product2, new Product(id_product2, "Samsung Galaxy A10", 2850000, (int) (Math.random() * 100) + 1, "samsung-galaxy-a10-red-400x400.jpg"));
    int id_product3 = (int) (Math.random() * 100000);
    products.put(id_product3, new Product(id_product3, "Xiaomi Redmi 7 32GB", 3690000, (int) (Math.random() * 100) + 1, "xiaomi-redmi-7-black-1-400x400.jpg"));
    int id_product4 = (int) (Math.random() * 100000);
    products.put(id_product4, new Product(id_product4, "Vivo Y91C", 2590000, (int) (Math.random() * 100) + 1, "vivo-y91c-400x400.jpg"));
    int id_product5 = (int) (Math.random() * 100000);
    products.put(id_product5, new Product(id_product5, "iPhone Xs 256GB", 32990000, (int) (Math.random() * 100) + 1, "iphone-xs-256gb-white-400x400.jpg"));
    int id_product6 = (int) (Math.random() * 100000);
    products.put(id_product6, new Product(id_product6, "Huawei P30 Pro", 20690000, (int) (Math.random() * 100) + 1, "huawei-p30-pro-1-400x400.jpg"));
    int id_product7 = (int) (Math.random() * 100000);
    products.put(id_product7, new Product(id_product7, "BlackBerry KEY2", 15990000, (int) (Math.random() * 100) + 1, "blackberry-key2-3-400x460.png"));
    int id_product8 = (int) (Math.random() * 100000);
    products.put(id_product8, new Product(id_product8, "Vsmart Live", 5990000, (int) (Math.random() * 100) + 1, "vsmart-live-blue-18thangbh-400x400.jpg"));
  }

  @Override
  public List<Product> findAll() {
    return new ArrayList<>(products.values());
  }

  @Override
  public void save(Product product) {
    products.put(product.getId(), product);
  }

  @Override
  public Product findById(int id) {
    return products.get(id);
  }

  @Override
  public void update(int id, Product product) {
    products.put(id, product);
  }

  @Override
  public void remove(int id) {
    products.remove(id);
  }

  @Override
  public List<Product> searchByName(String name) {
    List<Product> products = findAll();
    String isLowerName = name.toLowerCase().trim();
    List<Product> responseProducts = new ArrayList<>();
    for (Product product : products){
      String isLoweProduct = product.getName().toLowerCase().trim();
      if(isLoweProduct.contains(isLowerName)) responseProducts.add(product);
    }
    return responseProducts;
  }
}
