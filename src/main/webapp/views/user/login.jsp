<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 31/03/2023
  Time: 9:44 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LOGIN</title>
    <%@ include file="/common/head.jsp"%>
    <!--

    TemplateMo 556 Catalog-Z

    https://templatemo.com/tm-556-catalog-z

    -->
</head>
<body>
<%@ include file="/common/header.jsp"%>
<div class="container-fluid tm-mt-60">
    <div class="row tm-mb-50">
        <div class="col-lg-12 col-12 mb-5">
            <h2 class="tm-text-primary mb-5" style="text-align: center">Login</h2>
            <form id="login-form" action="login" method="POST" class="tm-contact-form mx-auto">
                <div class="form-group">
                    <input type="text" name="username" class="form-control rounded-0" placeholder="Username" required />
                </div>
                <div class="form-group">
                    <input type="password" name="password" class="form-control rounded-0" placeholder="Password" required />
                </div>
                <div class="form-group tm-text-right">
                    <button type="submit" class="btn btn-primary">Send</button>
                </div>
            </form>
        </div>
    </div>
</div> <!-- container-fluid, tm-container-content -->
<%@ include file="/common/footer.jsp"%>
</body>
</html>
