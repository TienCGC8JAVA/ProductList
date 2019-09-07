package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
    maxFileSize = 1024 * 1024 * 10,
    maxRequestSize = 1024 * 1024 * 50)
public class ProductServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  public static final String SAVE_DIRECTORY = "images";

  private ProductService productService = new ProductServiceImpl();

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String action = request.getParameter("action");

    if(action == null){
      action = "";
    }
    switch (action){
      case  "create":
          createProduct(request, response);
        break;
      case "edit":
          updateProduct(request, response);
        break;
      case "delete":
        deleteProduct(request, response);
        break;
      case "search":
        searchByName(request, response);
      default:
        break;
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String action = request.getParameter("action");

    if(action == null){
      action = "";
    }
    switch (action){
      case  "create":
        showCreateForm(request, response);
        break;
      case "edit":
        showEditForm(request, response);
        break;
      case "delete":
        showDeleteForm(request, response);
        break;
      case "view":
        viewProduct(request, response);
        break;
      default:
        listProduct(request, response);
        break;
    }
  }

  private void listProduct(HttpServletRequest request, HttpServletResponse response){

    List<Product> products = this.productService.findAll();
    request.setAttribute("products", products);

    RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
    try {
      dispatcher.forward(request, response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }

  private void showCreateForm(HttpServletRequest request, HttpServletResponse response){

    RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
    try {
      dispatcher.forward(request, response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }

  private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    String name = request.getParameter("name");
    int price;
    int quantity;
    String picture = "";
    RequestDispatcher dispatcher;

    try {
      price = Integer.parseInt(request.getParameter("price"));
      quantity = Integer.parseInt(request.getParameter("quantity"));
      String appPath = request.getServletContext().getRealPath("");
      appPath = appPath.replace('\\', '/');
      String fullSavePath;
      if (appPath.endsWith("/")) {
        fullSavePath = appPath + SAVE_DIRECTORY;
      } else {
        fullSavePath = appPath + "/" + SAVE_DIRECTORY;
      }
      File fileSaveDir = new File(fullSavePath);
      if (!fileSaveDir.exists()) {
        fileSaveDir.mkdir();
      }
      for (Part part : request.getParts()) {
        String fileName = extractFileName(part);
        if (fileName != null && fileName.length() > 0) {
          String filePath = fullSavePath + File.separator + fileName;
          part.write(filePath);
          picture = fileName;
        }
      }
      int id = (int) (Math.random() * 100000);

      Product product = new Product(id, name, price, quantity, picture);
      this.productService.save(product);
      dispatcher = request.getRequestDispatcher("product/create.jsp");
      request.setAttribute("message", "New product was created");
    } catch (NumberFormatException e) {
      dispatcher = request.getRequestDispatcher("error-404.jsp");
    }
    try {
      dispatcher.forward(request, response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }

  private String extractFileName(Part part) {

    String contentDisp = part.getHeader("content-disposition");
    String[] items = contentDisp.split(";");
    for (String s : items) {
      if (s.trim().startsWith("filename")) {

        String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
        clientFileName = clientFileName.replace("\\", "/");
        int i = clientFileName.lastIndexOf('/');

        return clientFileName.substring(i + 1);
      }
    }
    return null;
  }

  private  void showEditForm(HttpServletRequest request, HttpServletResponse response){

    int id = Integer.parseInt(request.getParameter("id"));
    Product product = this.productService.findById(id);
    RequestDispatcher dispatcher;
    if(product == null){
      dispatcher = request.getRequestDispatcher("error-404.jsp");
    } else {
      request.setAttribute("product", product);
      dispatcher = request.getRequestDispatcher("product/edit.jsp");
    }
    try {
      dispatcher.forward(request, response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }

  private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException {

    RequestDispatcher dispatcher;
    try {
      int id = Integer.parseInt(request.getParameter("id"));
      String name = request.getParameter("name");
      int price = Integer.parseInt(request.getParameter("price"));
      int quantity = Integer.parseInt(request.getParameter("quantity"));
      String picture = request.getParameter("picture");

      String appPath = request.getServletContext().getRealPath("");
      appPath = appPath.replace('\\', '/');
      String fullSavePath = null;
      if (appPath.endsWith("/")) {
        fullSavePath = appPath + SAVE_DIRECTORY;
      } else {
        fullSavePath = appPath + "/" + SAVE_DIRECTORY;
      }
      File fileSaveDir = new File(fullSavePath);
      if (!fileSaveDir.exists()) {
        fileSaveDir.mkdir();
      }
      for (Part part : request.getParts()) {
        String fileName = extractFileName(part);
        if (fileName != null && fileName.length() > 0) {
          String filePath = fullSavePath + File.separator + fileName;
          part.write(filePath);
          picture = fileName;
        }
      }


      Product product = this.productService.findById(id);
      product.setId(id);
      product.setName(name);
      product.setPrice(price);
      product.setQuantity(quantity);
      product.setPicture(picture);
      this.productService.update(id, product);
      request.setAttribute("product", product);
      request.setAttribute("message", "Product information was updated");
      dispatcher = request.getRequestDispatcher("product/edit.jsp");
    } catch (NumberFormatException | IOException e) {
      dispatcher = request.getRequestDispatcher("error-404.jsp");
    }
    try {
      dispatcher.forward(request, response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }

  private void showDeleteForm(HttpServletRequest request, HttpServletResponse response){
    int id = Integer.parseInt(request.getParameter("id"));
    Product product = this.productService.findById(id);
    RequestDispatcher dispatcher;
    if(product == null){
      dispatcher = request.getRequestDispatcher("error-404.jsp");
    } else {
      request.setAttribute("product", product);
      dispatcher = request.getRequestDispatcher("product/delete.jsp");
    }
    try {
      dispatcher.forward(request, response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }

  private void deleteProduct(HttpServletRequest request, HttpServletResponse response){

    int id = Integer.parseInt(request.getParameter("id"));
    Product product = this.productService.findById(id);
    RequestDispatcher dispatcher;
    if(product == null){
      dispatcher = request.getRequestDispatcher("error-404.jsp");
    } else {
      this.productService.remove(id);
      try {
        response.sendRedirect("/products");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private void viewProduct(HttpServletRequest request, HttpServletResponse response){

    int id = Integer.parseInt(request.getParameter("id"));
    Product product = this.productService.findById(id);
    RequestDispatcher dispatcher;
    if(product == null){
      dispatcher = request.getRequestDispatcher("error-404.jsp");
    } else {
      request.setAttribute("product", product);
      dispatcher = request.getRequestDispatcher("product/view.jsp");
    }
    try {
      dispatcher.forward(request, response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }

  private void searchByName(HttpServletRequest request, HttpServletResponse response){

    String search = request.getParameter("search");
    List<Product> products = this.productService.searchByName(search);
    RequestDispatcher dispatcher;
    if(products == null){
      dispatcher = request.getRequestDispatcher("error-404.jsp");
    } else {
      request.setAttribute("products", products);
      dispatcher = request.getRequestDispatcher("product/result.jsp");
    }
    try {
      dispatcher.forward(request, response);
    } catch (ServletException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
