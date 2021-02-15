<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title> <tiles:getAsString name="title"/> </title>
    <link href="<c:url value='/webjars/bootstrap/5.0.0-beta1/css/bootstrap.min.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/main.css' />" rel="stylesheet"/>
    <script src="<c:url value='/webjars/bootstrap/5.0.0-beta1/js/bootstrap.min.js' />"></script>
    <script src="<c:url value='/static/js/main.js' />"></script>
</head>
<body>
    <header>
        <tiles:insertAttribute name="header"/>
    </header>
    <div class="container">
        <div class="row">
            <section id="sideMenu" class="col-1">
                <tiles:insertAttribute name="menu"/>
            </section>
            <section id="content" class="mt-4 col-11">
                <tiles:insertAttribute name="body"/>
            </section>
        </div>
    </div>
    <section id="footer">
        <tiles:insertAttribute name="footer"/>
    </section>
</body>
</html>
