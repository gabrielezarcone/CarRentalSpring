<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="btn-group-vertical w-100 mt-4 p-0">
    <c:url var="nuovoUtenteUrl"  value="/admin/aggiungi"/>
    <c:url var="nuovaAutoUrl"  value="/admin/aggiungiAuto"/>
    <a class="btn btn-light" href="${nuovoUtenteUrl}">Nuovo Utente</a>
    <a class="btn btn-light" href="${nuovaAutoUrl}">Nuova Auto</a>
</div>