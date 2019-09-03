package service;

import model.Product;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {

  private static Map<Integer, Product> products;

  static {
    products = new HashMap<>();
    int id_product1 = (int) (Math.random() * 100000);
    products.put(id_product1, new Product(id_product1,"IPhone 6S",8150000,(int) (Math.random() * 100) + 1));
    int id_product2 = (int) (Math.random() * 100000);
    products.put(id_product2, new Product(id_product2, "Samsung Galaxy A10", 2850000, (int) (Math.random() * 100) + 1));
    int id_product3 = (int) (Math.random() * 100000);
    products.put(id_product3, new Product(id_product3, "OPPO F7", 7288000, (int) (Math.random() * 100) + 1));
    int id_product4 = (int) (Math.random() * 100000);
    products.put(id_product4, new Product(id_product4, "Samsung Galaxy A30", 4690000, (int) (Math.random() * 100) + 1));
    int id_product5 = (int) (Math.random() * 100000);
    products.put(id_product5, new Product(id_product5, "Xiaomi Redmi Note 7", 4490000, (int) (Math.random() * 100) + 1));
    int id_product6 = (int) (Math.random() * 100000);
    products.put(id_product6, new Product(id_product6, "Nokia 6.1 Plus", 3490000, (int) (Math.random() * 100) + 1));
    int id_product7 = (int) (Math.random() * 100000);
    products.put(id_product7, new Product(id_product7, "IPhone X 64GB VN/A", 19990000, (int) (Math.random() * 100) + 1));
    int id_product8 = (int) (Math.random() * 100000);
    products.put(id_product8, new Product(id_product8, "Samsung Galaxy S10e", 14990000, (int) (Math.random() * 100) + 1));
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
}
