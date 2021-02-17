<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1>Modifica prenotazione</h1>

<form:form method="post" modelAttribute="prenotazione">
    <form:input path="id" type="hidden"/>
    <form:input path="stato" type="hidden"/>
    <div class="formRow">
        <label for="auto" class=" col-sm-2 col-form-label">Auto</label>
        <div class="col">
            <form:select path="auto" items="${autoList}" cssClass="form-select"/>
            <div class="has-error">
                <form:errors path="auto" cssClass="badge bg-danger"/>
            </div>
        </div>
    </div>
    <fmt:formatDate value="${prenotazione.inizio}" pattern="yyyy-MM-dd" var="formatInizio"/>
    <div class="formRow">
        <label for="inizio" class="col-sm-2 col-form-label">Inizio</label>
        <div class="col">
            <form:input path="inizio" type="date" value='${formatInizio}' cssClass="form-control"/>
            <div class="has-error">
                <form:errors path="inizio" cssClass="badge bg-danger"/>
            </div>
        </div>
    </div>
    <fmt:formatDate value="${prenotazione.fine}" pattern="yyyy-MM-dd" var="formatFine"/>
    <div class="formRow">
        <label for="fine" class="col-sm-2 col-form-label">Fine</label>
        <div class="col">
            <form:input path="fine" type="date" value='${formatFine}' cssClass="form-control"/>
            <div class="has-error">
                <form:errors path="fine" cssClass="badge bg-danger"/>
            </div>
        </div>
    </div>
    <input type="submit" class="btn btn-primary" value="Salva">
</form:form>