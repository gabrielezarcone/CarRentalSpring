<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> <tiles:getAsString name="title"/> </title>
</head>
<body>
    <header>
        <tiles:insertAttribute name="header"/>
    </header>
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
