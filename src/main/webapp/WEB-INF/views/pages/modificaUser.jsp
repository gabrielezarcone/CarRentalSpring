<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Modifica user <strong>${user.username}</strong></h1>

<c:url var="actionUrl"  value="/admin/modifica" />
<form:form method="post" modelAttribute="user" action="${actionUrl}">
    <form:input path="id" type="hidden"/>
    <div class="formRow">
        <label for="username" class=" col-sm-2 col-form-label">Username</label>
        <div class="col">
            <form:input path="username" cssClass="form-control"/>
        </div>
    </div>
    <div class="formRow">
        <label for="name" class="col-sm-2 col-form-label">Nome</label>
        <div class="col">
            <form:input path="name" cssClass="form-control"/>
        </div>
    </div>
    <div class="formRow">
        <label for="surname" class="col-sm-2 col-form-label">Cognome</label>
        <div class="col">
            <form:input path="surname" cssClass="form-control"/>
        </div>
    </div>
    <div class="formRow">
        <label for="password" class="col-sm-2 col-form-label">Password</label>
        <div class="col">
            <form:input path="password" type="password" cssClass="form-control"/>
        </div>
    </div>
    <fmt:formatDate value="${user.birthDate}" pattern="yyyy-MM-dd" var="formatBirthDate"/>
    <div class="formRow">
        <label for="birthDate" class="col-sm-2 col-form-label">Data di nascita</label>
        <div class="col">
            <form:input path="birthDate" type="date" value='${formatBirthDate}' cssClass="form-control"/>
        </div>
    </div>
    <div class="formRow">
        <label for="ruoli" class="col-sm-2 col-form-label">Ruoli</label>
        <div class="col">
            <form:checkboxes path="ruoli" items="${roleList}" cssClass="form-check-input mx-2"/>
        </div>
    </div>
    <input type="submit" class="btn btn-primary" value="Salva">
</form:form>