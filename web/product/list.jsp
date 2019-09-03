<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 8/31/2019
  Time: 7:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Bài tập của Chãu Chãu xinh trai</title>
  </head>
  <body>
    <h1>Products</h1>
  <p>
    <a href = "${pageContext.request.contextPath}/products?action=create">Create new product</a>
  </p>
  <table border = "1">
    <tr>
      <td>ID</td>
      <td>Name</td>
      <td>Price</td>
      <td>quantity</td>
      <td>Edit</td>
      <td>Delete</td>
    </tr>
    <c:forEach items = '${requestScope["products"]}' var = "product">
      <tr>
        <td>${product.getId()}</td>
        <td>
          <a href = "${pageContext.request.contextPath}/products?action=view&id=${product.getId()}">${product.getName()}</a>
        </td>
        <td>${product.getPrice()} VND</td>
        <td>${product.getQuantity()}</td>
        <td>
          <a href = "${pageContext.request.contextPath}/products?action=edit&id=${product.getId()}">edit</a>
        </td>
        <td>
          <a href = "${pageContext.request.contextPath}/products?action=delete&id=${product.getId()}">delete</a>
        </td>
      </tr>
    </c:forEach>
  </table>
  </body>
</html>