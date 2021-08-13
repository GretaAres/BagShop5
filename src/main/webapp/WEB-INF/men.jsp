<%@ page import="com.example.BagShop.model.Bag" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: vartan
  Date: 06.08.2021
  Time: 0:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.6.0.min.js"></script>

    <link href="css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<% List<Bag> bags = (List<Bag>) request.getAttribute("bags");%>
<% if (bags != null && !bags.isEmpty()) {
    for (Bag bag : bags) {
%>
<div class="wrapper">
    <div class="container">
        <div class="row g-1">
            <div class="col-md-3">
                <div class="card p-3">
                    <div class="text-center"> <img src="<%=bag.getPicUrl()%>" width="200" height="250"> </div>
                    <div class="product-details"> <span class="font-weight-bold d-block"><%=bag.getPrice()%> $</span> <span><%=bag.getName()%></span>
                        <div class="buttons d-flex flex-row">
                            <div class="cart"><i class="fa fa-shopping-cart"></i></div>
                            <a href="/buy" class="btn btn-success cart-button btn-block"><span class="dot">1</span> Buy</a>
                        </div>
                        <div class="weight"> <small><%=bag.getCount()%> piece</small> </div>
                    </div>

                </div>
            </div>
            <% }
            }%>

        </div>
    </div>
</div>
</body>
<script>
    document.addEventListener("DOMContentLoaded", function(event) {


        const cartButtons = document.querySelectorAll('.cart-button');

        cartButtons.forEach(button => {

            button.addEventListener('click',cartClick);

        });

        function cartClick(){
            let button =this;
            button.classList.add('clicked');
        }



    });
</script>
</html>
