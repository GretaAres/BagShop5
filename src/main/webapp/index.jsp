<%@ page import="com.example.BagShop.model.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>Index</title>
    <script src="js/jquery-3.6.0.min.js"></script>
    <Link href="css/Style.css" rel="stylesheet">

    <link href="css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-3.6.0.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->
</head>

<body background="uploadedImages/02_DKNY_7.27_HP_LANDSCAPE.jpg" >
}

<%
    User user=(User) session.getAttribute("user");
    if (user!=null){
        response.sendRedirect("/home");
    }

    String msg=(String) session.getAttribute("msg");%>
<% if (msg!=null && !"".equals(msg)){%>
<span><%=msg%>%></span>
<%
        session.removeAttribute("msg");
    }%>
<div class="page-heading" >

</div>
<div class="container" >
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-login">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-6">
                            <a href="#" class="active" id="login-form-link">Login</a>
                        </div>
                        <div class="col-xs-6">
                            <a href="#" id="register-form-link">Register</a>
                        </div>
                    </div>
                    <hr>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <form id="login-form" action="/login" method="post" role="form" style="display: block;">
                                <div class="form-group">
                                    <input type="text" name="email" id="email" tabindex="1" class="form-control" placeholder="Email" value="">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Log In">
                                            <h3 style="color: red">The best bags for you</h3>
                                        </div>
                                    </div>
                                </div>

                            </form>
                            <form id="register-form" action="/register" method="post" role="form" style="display: none;">
                                <div class="form-group">
                                    <input type="text" name="name" id="name" tabindex="1" class="form-control" placeholder="Name" value="">
                                </div>
                                <div class="form-group">
                                    <input type="text" surname="surname" id="surname" tabindex="1" class="form-control" placeholder="Surname" value="">
                                </div>
                                <div class="form-group">
                                    <input type="email" name="email" id="email" tabindex="1" class="form-control" placeholder="Email Address" value="">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">
                                </div>
                                <div class="form-group">
                                    <input type="re-password" name="re-password" id="re-password" tabindex="2" class="form-control" placeholder="Re- Password">
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Register Now">
                                            <h3 style="color: red">The best bags for you</h3>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $(function() {

        $('#login-form-link').click(function(e) {
            $("#login-form").delay(100).fadeIn(100);
            $("#register-form").fadeOut(100);
            $('#register-form-link').removeClass('active');
            $(this).addClass('active');
            e.preventDefault();
        });
        $('#register-form-link').click(function(e) {
            $("#register-form").delay(100).fadeIn(100);
            $("#login-form").fadeOut(100);
            $('#login-form-link').removeClass('active');
            $(this).addClass('active');
            e.preventDefault();
        });

    });

</script>


</html>