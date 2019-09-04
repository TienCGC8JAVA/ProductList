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
    <h1>Delete product</h1>
    <p>
      <a href = "${pageContext.request.contextPath}/products">Back to customer list</a>
    </p>
    <form method = "post">
      <h3>Are you sure?</h3>
      <fieldset>
        <legend>Product information</legend>
        <table>
          <tr>
            <td>Name: </td>
            <td>${requestScope["product"].getName()}</td>
          </tr>
          <tr>
            <td>Price: </td>
            <td>${requestScope["product"].getPrice()}</td>
          </tr>
          <tr>
            <td>Quantity: </td>
            <td>${requestScope["product"].getQuantity()}</td>
          </tr>
          <tr>
            <td>Picture: </td>
            <td><img src = "${requestScope["product"].getPicture()}"  height = "180"/></td>
          </tr>
          <tr>
            <td><input type="submit" value="Delete product"></td>
            <td>
              <a href="${pageContext.request.contextPath}/products">Back to product list</a>
            </td>
          </tr>
        </table>
      </fieldset>
    </form>
  </body>
</html>
