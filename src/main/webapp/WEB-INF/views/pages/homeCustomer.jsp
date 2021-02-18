<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- Data di oggi --%>
<jsp:useBean id="now" class="java.util.Date" />

<h1>Buongiorno <strong>${loggedUser.name}</strong></h1>

<a href="<c:url value="/customer/aggiungiPrenotazione"></c:url>" class="addUserBtn"><i class="bi bi-bookmark-plus-fill"></i></a>
<div class="table-responsive">
    <table class="styleTable">
        <thead>
        <tr>
            <c:url var="url" value="/customer/home"/>
            <th>Inizio</th>
            <th>Fine</th>
            <th>
                <select onchange="cercaAutoPrenotazione('${url}')" id="filtroAutoPrenotazione" class="tableFilterDropdown">
                    <option disabled selected>Auto</option>
                    <option value="tutti">Tutti</option>
                    <c:forEach var="auto" items="${autoList}">
                        <option value="${auto.id}">${auto}</option>
                    </c:forEach>
                </select>
            </th>
            <th>
                <select onchange="cercaStatoPrenotazione('${url}')" id="filtroStatoPrenotazione" class="tableFilterDropdown">
                    <option disabled selected>Stato</option>
                    <option value="tutti">Tutti</option>
                    <option value="APPROVATO">Approvato</option>
                    <option value="PENDING">In attesa</option>
                    <option value="RIFIUTATO">Rifiutato</option>
                </select>
            </th>
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
                            <div class="alert alert-light"><i class="bi bi-exclamation-triangle-fill"></i> Non possono essere fatte modifiche alla prenotazione se la data di inizio dista meno di 2 giorni dalla data odierna.</div>
                        </td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>