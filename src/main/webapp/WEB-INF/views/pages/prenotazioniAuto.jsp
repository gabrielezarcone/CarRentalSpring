<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>Prenotazioni per <strong>${auto}</strong></h1>

<div class="table-responsive">
    <table class="styleTable">
        <thead>
        <tr>
            <th>Inizio</th>
            <th>Fine</th>
            <th>Utente</th>
            <th>Stato</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="prenotazione" items="${listaPrenotazioniAuto}">
            <tr>
                <td><fmt:formatDate value="${prenotazione.inizio}" type="date" /></td>
                <td><fmt:formatDate value="${prenotazione.fine}" type="date" /></td>
                <td>${prenotazione.user.username}</td>
                <c:choose>
                    <c:when test='${prenotazione.stato eq "PENDING"}'>
                        <td><div class="tableBtnGroup" role="group">
                            <button type="button" class="btn btn-primary" onclick="approvaPrenotazione(${prenotazione.id})">Accetta</button>
                            <button type="button" class="btn btn-dark" onclick="rifiutaPrenotazione(${prenotazione.id})">Rifiuta</button>
                        </td>
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