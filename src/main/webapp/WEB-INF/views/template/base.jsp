<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>

<html class="h-100">
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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css"> <%-- CDN per usare le icone Bootstrap--%>
</head>
<body class="d-flex flex-column h-100">
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
    <footer id="footer" class="footerTemplate">
        <tiles:insertAttribute name="footer"/>
    </footer>
</body>
</html>
