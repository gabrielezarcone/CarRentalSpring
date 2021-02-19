<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${not (auto.costruttore eq null)}">
        <h1>Modifica <strong>${auto}</strong></h1>
    </c:when>
    <c:otherwise>
        <h1>Nuova auto</h1>
    </c:otherwise>
</c:choose>

<form:form method="post" modelAttribute="auto">
    <form:input path="id" type="hidden"/>
    <div class="formRow">
        <label for="costruttore" class=" col-sm-2 col-form-label">Costruttore</label>
        <div class="col">
            <form:input path="costruttore" cssClass="form-control"/>
            <div class="has-error">
                <form:errors path="costruttore" cssClass="badge bg-danger"/>
            </div>
        </div>
    </div>
    <div class="formRow">
        <label for="modello" class="col-sm-2 col-form-label">Modello</label>
        <div class="col">
            <form:input path="modello" cssClass="form-control"/>
            <div class="has-error">
                <form:errors path="modello" cssClass="badge bg-danger"/>
            </div>
        </div>
    </div>
    <div class="formRow">
        <label for="targa" class="col-sm-2 col-form-label">Targa</label>
        <div class="col">
            <form:input path="targa" cssClass="form-control"/>
            <div class="has-error">
                <form:errors path="targa" cssClass="badge bg-danger"/>
            </div>
        </div>
    </div>
    <div class="formRow">
        <label for="tipologia" class="col-sm-2 col-form-label">Tipologia</label>
        <div class="col">
            <form:input path="tipologia" cssClass="form-control"/>
            <div class="has-error">
                <form:errors path="tipologia" cssClass="badge bg-danger"/>
            </div>
        </div>
    </div>
    <fmt:formatDate value="${auto.immatricolazione}" pattern="yyyy-MM-dd" var="formatImmatricolazione"/>
    <div class="formRow">
        <label for="immatricolazione" class="col-sm-2 col-form-label">Immatricolazione</label>
        <div class="col">
            <form:input path="immatricolazione" type="date" value='${formatImmatricolazione}' cssClass="form-control"/>
            <div class="has-error">
                <form:errors path="immatricolazione" cssClass="badge bg-danger"/>
            </div>
        </div>
    </div>
    <input type="submit" class="btn btn-primary" value="Salva">
</form:form>