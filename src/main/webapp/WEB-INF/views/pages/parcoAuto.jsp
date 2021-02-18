<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1><strong>Parco Auto</strong></h1>

<div class="table-responsive">
    <table class="styleTableAuto">
        <thead>
        <tr>
            <th>Costruttore</th>
            <th>Modello</th>
            <th>Tipologia</th>
            <th>Targa</th>
            <th>Immatricolazione</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="auto" items="${autoList}">
            <tr>
                <td>${auto.costruttore}</td>
                <td>${auto.modello}</td>
                <td>${auto.tipologia}</td>
                <td>${auto.targa}</td>
                <td><fmt:formatDate value="${auto.immatricolazione}" type="date" /></td
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>