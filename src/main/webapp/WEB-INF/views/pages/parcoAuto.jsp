<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
            <sec:authorize access='hasRole("ADMIN")'>
                <th>
                    Operazioni
                </th>
            </sec:authorize>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="auto" items="${autoList}">
            <tr>
                <td>${auto.costruttore}</td>
                <td>${auto.modello}</td>
                <td>${auto.tipologia}</td>
                <td>${auto.targa}</td>
                <td><fmt:formatDate value="${auto.immatricolazione}" type="date" /></td>
                <sec:authorize access='hasRole("ADMIN")'>
                    <td>
                        <div class="tableBtnGroup" role="group">
                            <c:url var="prenotazioniUrl" value="/admin/prenotazioni/auto/${auto.id}"/>
                            <a href="" type="button" class="btn btn-success">Modifica</a>
                            <button onclick='eliminaAuto("${auto.id}")' type="button" class="btn btn-danger">Elimina</button>
                            <a href="${prenotazioniUrl}" type="button" class="btn btn-primary">Prenotazioni</a>
                        </div>
                    </td>
                </sec:authorize>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>