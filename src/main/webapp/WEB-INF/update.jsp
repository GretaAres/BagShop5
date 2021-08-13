<%@ page import="com.example.BagShop.model.Bag" %><%--
  Created by IntelliJ IDEA.
  User: vartan
  Date: 13.08.2021
  Time: 0:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%String msg=(String) session.getAttribute("msg");%>
<%Bag bag=(Bag) request.getAttribute("bag");%>
<% if (msg!=null && !"".equals(msg)){%>
<span><%=msg%>%></span>
<%
    session.removeAttribute("msg");
  }%>
<h1>AddBook</h1>  <a href="/logout">Logout</a>
<form action="/updateBag" method="post" enctype="multipart/form-data">
  <input type="hidden" name="id"value="<%=bag.getId()%>" /><br>
  title:<input type="text" name="title" value="<%=bag.getName()%>"/><br>
  authorName:<input type="text" name="authorName" value="<%=bag.getDescription()%>"/><br>
  price:<input type="number" name="price" value="<%=bag.getPrice()%>"/><br>
  price:<input type="number" name="count" value="<%=bag.getCount()%>"/><br>
  picture:<input type="file" name="picture"><br>
  type:<select name="type">
  <option value="WOMEN">WOMEN</option>
  <option value="MEN">MEN</option>
  <option value="CHILD">CHILD</option>
  <option value="NEW">NEW</option>
</select>
  <input type="submit"value="add bag">
</form>
</body>
</html>
