<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 8/31/2019
  Time: 7:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Bài tập của Chãu Chãu xinh trai</title>
  </head>
  <body>
    <h1>Product details</h1>
    <p>
      <a href="${pageContext.request.contextPath}/products">Back to product list</a>
    </p>
    <table>
      <tr>
        <td>Name: </td>
        <td>${requestScope["product"].getName()}</td>
      </tr>
      <tr>
        <td>Price: </td>
        <td>${requestScope["product"].getPrice()} VND</td>
      </tr>
      <tr>
        <td>Quantity: </td>
        <td>${requestScope["product"].getQuantity()}</td>
      </tr>
      <tr>
        <td>Picture: </td>
        <td><img src = "${requestScope["product"].getPicture()}"  alt = "not connect wifi"/></td>
      </tr>
    </table>
  </body>
</html>
