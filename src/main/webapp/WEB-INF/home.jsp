<%@ page import="com.example.BagShop.model.User" %><%--
  Created by IntelliJ IDEA.
  User: vartan
  Date: 05.08.2021
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <script src="js/jquery-3.6.0.min.js"></script>
    <Link href="css/homeCss.css" rel="stylesheet">
</head>
<body>
<% User user=(User) session.getAttribute("user");
  String msg=(String) session.getAttribute("msg");%>
<% if (msg!=null && !"".equals(msg)){%>
<span><%=msg%>%></span>
<%
    session.removeAttribute("msg");
  }%>

<div class="hero-image">
    <h1 style="color: #5d10a0">The best bags</h1>
    <div class="hero-text">

    </div>
    <div>
        <a href="/new"><h1 style="color: #254bac">New</h1></a>
    </div>
    <div>
        <a href="/women"><h1 style="color: #2547ac">Women</h1></a>
    </div>
    <div>
        <a href="/men"><h1 style="color: #2547ac">Men</h1></a>
    </div>
    <div>
        <a href="/child"><h1 style="color: #2537ac">Child</h1></a>
    </div>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<a href="/logout"><h1>Logout</h1></a>
</body>
</html>
