<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- Data di oggi --%>
<jsp:useBean id="now" class="java.util.Date" />

<h1>Buongiorno <strong>${loggedUser.name}</strong></h1>

<a href="<c:url value="/customer/aggiungiPrenotazione"></c:url>" class="addUserBtn"><i class="bi bi-bookmark-plus-fill"></i></a>
<div class="table-responsive">
    <table class="styleTable">
        <thead>
        <tr>
            <th>Inizio</th>
            <th>Fine</th>
            <th>Auto</th>
            <th>Stato</th>
            <th scope="col">
                <c:url value="/customer/home" var="url"/>
                <form class="d-flex"  onsubmit="return cercaPrenotazione('${url}');">
                    <input id="testoRicercaPrenotazione" class="form-control me-2" type="search" placeholder="Cerca" aria-label="Search">
                    <select id="filtroRicercaPrenotazione" class="form-select me-2 w-50 bg-dark text-white" aria-label="Default select example">
                        <option selected value="username">Auto</option>
                        <option value="name">Stato</option>
                        <option value="inizio">Inizio</option>
                        <option value="fine">Fine</option>
                    </select>
                    <button class="btn btn-outline-primary" type="submit">Cerca</button>
                </form>
            </th>
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