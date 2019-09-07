<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/7/2019
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Bài tập của Chãu Chãu xinh trai</title>
  </head>
  <body>
    <h1>Result search</h1>
    <p>
      <a href="${pageContext.request.contextPath}/products">Back to product list</a>
    </p>
    <c:forEach items="${requestScope['products']}" var="product">
      <table>
        <tr>
          <td>Name: </td>
          <td>${product.getName()}</td>
        </tr>
        <tr>
          <td>Price: </td>
          <td>${product.getPrice()} VND</td>
        </tr>
        <tr>
          <td>Quantity: </td>
          <td>${product.getQuantity()}</td>
        </tr>
        <tr>
          <td>Picture: </td>
          <td><img src = "<%=request.getContextPath()%>/images/${product.getPicture()}"  alt = "not connect wifi"/></td>
        </tr>
      </table>
    </c:forEach>

  </body>
</html>
