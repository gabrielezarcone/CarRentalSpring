<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="prenotazione" items="${listaPrenotazioniUtente}">
    ${prenotazione.stato}<br>
</c:forEach>