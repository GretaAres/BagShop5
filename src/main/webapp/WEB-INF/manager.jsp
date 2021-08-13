<%@ page import="com.example.BagShop.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.BagShop.model.Bag" %><%--
  Created by IntelliJ IDEA.
  User: vartan
  Date: 06.08.2021
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.6.0.min.js"></script>

    <link href="css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="js/bootstrap.min.js"></script>

    <!------ Include the above in your HEAD tag ---------->
</head>
<body>
<%String msg=(String) session.getAttribute("msg");%>
<% if (msg!=null && !"".equals(msg)){%>
<span><%=msg%>%></span>
<%
        session.removeAttribute("msg");
    }%>


<% List<User> users =(List<User>) request.getAttribute("users");%>
<% List<Bag> bags =(List<Bag>) request.getAttribute("bags");%>


<main class="container pt-5">
    <div class="card mb-5">
        <div class="card-header"><h1>All Users</h1></div>
        <div class="card-block p-0">
            <table class="table table-bordered table-sm m-0">
                <thead class="">
                <tr>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>E-mail address</th>
                    <th>Type</th>
                </tr>
                </thead>
                <tbody>
                <tr>

                    <% if (users != null && !users.isEmpty()) {
                        for (User user : users) {
                    %>

                    <td><%=user.getName()%>
                    </td>
                    <td><%=user.getSurname()%>
                    </td>
                    <td><%=user.getEmail()%>
                    </td>
                    <td><%=user.getUserType().name()%>
                    </td>
                </tr>
                <% }
                }%>

                </tbody>
            </table>
        </div>

    </div>
    <h1> All Bags</h1>
    <table class="table table-bordered table-definition mb-5">
        <thead class="table-warning ">
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Count</th>
            <th>Picture</th>
            <th>Type</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <% if (bags != null && !bags.isEmpty()) {
                for (Bag bag : bags) {
            %>
            <td><%=bag.getName()%>
            </td>
            <td><%=bag.getDescription()%>
            </td>
            <td><%=bag.getPrice()%>
            </td>
            <td><%=bag.getCount()%>
            </td>
            <td><%=bag.getPicUrl()%>
            </td>
            <td><%=bag.getType().name()%>
            </td>
            <td><a href="/updateBag?id=<%=bag.getId()%>">Update</a> | <a
                    href="/deleteBag?id=<%=bag.getId()%>">Delete</a></td>
        </tr>
        <% }
        }%>
        </tbody>
        <tfoot>
        <tr>
            <th></th>
            <th colspan="4">

            </th>
        </tr>
        </tfoot>
    </table>
    <a href="/addBag"><h1>Add Bag</h1></a>


    <a href="/logout"><h1>Logout</h1></a>
</main>


</html>
<script>
    function calc_total() {
        var sum = 0;
        $('.input-amount').each(function () {
            sum += parseFloat($(this).text());
        });
        $(".preview-total").text(sum);
    }

    $(document).on('click', '.input-remove-row', function () {
        var tr = $(this).closest('tr');
        tr.fadeOut(200, function () {
            tr.remove();
            calc_total()
        });
    });

    $(function () {
        $('.preview-add-button').click(function () {
            var form_data = {};
            form_data["concept"] = $('.payment-form input[name="concept"]').val();
            form_data["description"] = $('.payment-form input[name="description"]').val();
            form_data["amount"] = parseFloat($('.payment-form input[name="amount"]').val()).toFixed(2);
            form_data["status"] = $('.payment-form #status option:selected').text();
            form_data["date"] = $('.payment-form input[name="date"]').val();
            form_data["remove-row"] = '<span class="glyphicon glyphicon-remove"></span>';
            var row = $('<tr></tr>');
            $.each(form_data, function (type, value) {
                $('<td class="input-' + type + '"></td>').html(value).appendTo(row);
            });
            $('.preview-table > tbody:last').append(row);
            calc_total();
        });
    });
</script>
