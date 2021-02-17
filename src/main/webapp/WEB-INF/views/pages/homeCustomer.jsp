<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="table-responsive">
    <table class="styleTable">
        <thead>
        <tr>
            <th>Inizio</th>
            <th>Fine</th>
            <th>Auto</th>
            <th>Stato</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="prenotazione" items="${listaPrenotazioniUtente}">
            <tr>
                <td><fmt:formatDate value="${prenotazione.inizio}" type="date" /></td>
                <td><fmt:formatDate value="${prenotazione.fine}" type="date" /></td>
                <td>${prenotazione.auto.costruttore} ${prenotazione.auto.modello}</td>
                <c:choose>
                    <c:when test='${prenotazione.stato eq "PENDING"}'>
                        <td class="table-warning">IN ATTESA</td>
                    </c:when>
                    <c:when test='${prenotazione.stato eq "APPROVATO"}'>
                        <td class="table-success">${prenotazione.stato}</td>
                    </c:when>
                    <c:when test='${prenotazione.stato eq "RIFIUTATO"}'>
                        <td class="table-danger">${prenotazione.stato}</td>
                    </c:when>
                </c:choose>
            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>