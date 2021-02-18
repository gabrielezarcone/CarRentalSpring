<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- Data di oggi --%>
<jsp:useBean id="now" class="java.util.Date" />

<div class="table-responsive">
    <table class="styleTable">
        <thead>
        <tr>
            <th>Inizio</th>
            <th>Fine</th>
            <th>Auto</th>
            <th>Stato</th>
            <th>Operazioni</th>
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
                <c:choose>
                    <c:when test="${mappaPrenotazioniUtente.get(prenotazione)}">
                        <td>
                            <div class="tableBtnGroup" role="group">
                                <c:url var="modificaUrl" value="/customer/modificaPrenotazione/${prenotazione.id}"/>
                                <a href="${modificaUrl}" type="button" class="btn btn-success">Modifica</a>
                                <button onclick="eliminaPrenotazione(${prenotazione.id})" type="button" class="btn btn-danger">Elimina</button>
                            </div>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td class="w-50">
                            <div class="alert alert-light">Non possono essere fatte modifiche alla prenotazione se la data di inizio dista meno di 2 giorni dalla data odierna.</div>
                        </td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>