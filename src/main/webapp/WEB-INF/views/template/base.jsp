<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> <tiles:getAsString name="title"/> </title>
    <link href="<c:url value='/webjars/bootstrap/5.0.0-beta1/css/bootstrap.min.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/style.css' />" rel="stylesheet"/>
    <script src="<c:url value='/webjars/bootstrap/5.0.0-beta1/js/bootstrap.min.js' />"></script>
</head>
<body>
    <header class="alert alert-success">
        <tiles:insertAttribute name="header"/>
    </header>
    <div class="container">
        <div class="row">
            <section id="sideMenu" class="col-1">
                <tiles:insertAttribute name="menu"/>
            </section>
            <section id="content" class="col-11">
                <tiles:insertAttribute name="body"/>
            </section>
        </div>
    </div>
    <section id="footer">
        <tiles:insertAttribute name="footer"/>
    </section>
</body>
</html>
