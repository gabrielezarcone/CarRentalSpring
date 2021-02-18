<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>Prenotazioni per <strong>${auto}</strong></h1>
<c:forEach var="prenotazione" items="${listaPrenotazioniAuto}">
    ${prenotazione}<br>
</c:forEach>