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
    <style>
      .message{
        color:green;
      }
    </style>
  </head>
  <body>
    <h1>Create new product</h1>
  <p>
    <c:if test = '${requestScope["message"] != null}'>
      <span class= "message">${requestScope["message"]}</span>
    </c:if>
  </p>
  <p>
    <a href = "${pageContext.request.contextPath}/products">Back to product list</a>
  </p>
  <form method = "post" enctype = "multipart/form-data">
    <fieldset>
      <legend>Product information</legend>
      <table>
        <tr>
          <td>Name:</td>
          <td>
            <label for="name"></label><input type = "text" name = "name" id = "name" placeholder = "Input product name"/>
          </td>
        </tr>
        <tr>
          <td>Price:</td>
          <td>
            <label for="price"></label><input type = "text" name = "price" id = "price" placeholder = "Input price of product"/>
          </td>
        </tr>
        <tr>
          <td>Quantity:</td>
          <td>
            <label for="quantity"></label><input type = "text" name = "quantity" id = "quantity" placeholder = "Input quantity of product"/>
          </td>
        </tr>
        <tr>
        <tr>
          <td>Picture:</td>
          <td>
            <label for = "picture"></label><input type = "file" name = "picture" id = "picture" placeholder = "update file"/>
          </td>
        </tr>
        <tr>
          <td></td>
          <td><input type="submit" value="Create product"></td>
        </tr>
      </table>
    </fieldset>
  </form>
  </body>
</html>
