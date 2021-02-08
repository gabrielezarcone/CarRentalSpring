<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> <tiles:getAsString name="title"/> </title>
    <link rel='stylesheet' type="text/css" href='/webjars/bootstrap/css/bootstrap.min.css'>
<%--    <link rel='stylesheet' href='/webjars/bootstrap/4.6.0/css/bootstrap.min.css'>--%>
<%--    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>--%>
</head>
<body>
    <header class="alert alert-success">
        <tiles:insertAttribute name="header"/>
    </header>
    <h1>Prova bootstrap <span class="badge bg-secondary">Prova badge</span></h1>
    <section id="sideMenu">
        <tiles:insertAttribute name="menu"/>
    </section>
    <section id="content">
        <tiles:insertAttribute name="body"/>
    </section>
    <section id="footer">
        <tiles:insertAttribute name="footer"/>
    </section>
</body>
</html>
