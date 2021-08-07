<%--
  Created by IntelliJ IDEA.
  User: vartan
  Date: 08.08.2021
  Time: 0:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<%String msg=(String) session.getAttribute("msg");%>
<% if (msg!=null && !"".equals(msg)){%>
<span><%=msg%>%></span>
<%
        session.removeAttribute("msg");
    }%>
<h1>AddBag</h1>
<form action="/addBag" method="post" enctype="multipart/form-data">
    <div class="container">
        <div class="row">

            <!-- panel preview -->
            <div class="col-sm-5">

                <div class="panel panel-default">
                    <div class="panel-body form-horizontal payment-form">
                        <div class="form-group">
                            <label for="concept" class="col-sm-3 control-label">Name</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="concept" name="name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="description" class="col-sm-3 control-label">Description</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="description" name="description">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="amount" class="col-sm-3 control-label">Price</label>
                            <div class="col-sm-9">
                                <input type="number" class="form-control" id="amount" name="price">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="status" class="col-sm-3 control-label">Count</label>
                            <div class="col-sm-9">
                                <input type="number" class="form-control" id="status" name="count">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="picture" class="col-sm-3 control-label">Picture</label>
                            <div class="col-sm-9">
                                <input type="file" class="form-control" id="picture" name="picture">
                            </div>
                        </div>

                    </div>
                    <div class="form-group">
                        <div class="col-sm-12 text-right">
                            <input type="submit" value="Add">
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </div>
</form>

</body>
</html>
