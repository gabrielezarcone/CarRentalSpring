<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
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
</head>
<body>
<div class="errorDiv">
    <h1><tiles:getAsString name="messaggioErrore"/></h1>
    <a class="backToHomeBtn" href="<c:url value="/"/>">Torna alla home</a>
</div>
</body>
</html>
